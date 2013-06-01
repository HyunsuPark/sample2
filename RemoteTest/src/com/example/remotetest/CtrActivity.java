package com.example.remotetest;

import java.io.IOException;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CtrActivity extends Activity {

	private Connection connection = new Connection();
	private String ip;
	int dx = 0;
	int dy = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.controller);
		
		new RetreiveFeedTask().execute(null,null,null);
		
		ip = super.getIntent().getExtras().getString(
				"ipAddr");
		
		ImageView textView = (ImageView) findViewById(R.id.imageView1);
		Button button = (Button) findViewById(R.id.button1);

		textView.setOnTouchListener(new OnTouchListener() {
			float startX = 0;
			float startY = 0;
			float endX = 0;
			float endY = 0;
			
			@Override
			public boolean onTouch(View view, MotionEvent event) {
				switch(event.getAction()) {
				  case MotionEvent.ACTION_DOWN:
//					  Log.d("XDwon", event.getX()+"/"+event.getY());
//					  startX = event.getX();
//					  startY = event.getY();
				
					  break;
				  case MotionEvent.ACTION_UP:
//					  Log.d("Xup", event.getX()+"/"+event.getY());
//					  endX = event.getX();
//					  endY = event.getY();
					 
//					  try {
//							sendGeo(startX, startY, endX, endY);
//						} catch (IOException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
					  break;
				  case MotionEvent.ACTION_MOVE:
				// 주루룩 drag했을 경우 히스토리가 모두 기록되어서 전달됨
				  int length=event.getHistorySize();
				  float sx, sy, ex, ey;
				  
				  Log.d("length", length+"");
				  
				   if (length != 0) {
				    sx = event.getHistoricalX(0);
				    sy = event.getHistoricalY(0);
				    ex = event.getHistoricalX(length-1);
				    ey = event.getHistoricalY(length-1);

				    Log.d("getHistoricalX", event.getHistoricalX(0)+"");
				    
				    dx += (int)(ex-sx);
				    dy += (int)(ey-sy);
				    
				    Log.d("dx", dx+"");
				    Log.d("dy", dy+"");
				   }
					try {
						sendGeo(dx, dy);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				  break;
				  case MotionEvent.ACTION_CANCEL:
						  break;
				}
				
				return true;
			}
		});
		
	}
	
	/**
	 * 좌표를 계산하여 전송
	 * @throws IOException 
	 */
	public void sendGeo(int sendX,int sendY) throws IOException{
		Log.d("XY!!!!!!!!!!", sendX+"/"+sendY);
		connection.sendButClick((sendX+"/"+sendY).getBytes());
	}
	
	/**
	 * 좌표를 계산하여 전송
	 * @throws IOException 
	 */
	public void sendGeo(float startX, float startY,float endX, float endY ) throws IOException{
		String sendX = endX - startX+"";
		String sendY = endY - startY+"";
		Log.d("XY!!!!!!!!!!", sendX+"/"+sendY);
		connection.sendButClick((sendX+"/"+sendY).getBytes());
	}
	
	/**
	 * 서버와 연결
	 * @author RealPHS
	 *
	 */
	class RetreiveFeedTask extends AsyncTask<Void, Void, Void>{

		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			try {
				connection.open(ip);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
		}
		
	}
	
}
