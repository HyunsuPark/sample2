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

public class CtrActivity extends Activity {

	private Connection connection = new Connection();
	private String ip;
	int dx = 0;
	int dy = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.controller);

		new RetreiveFeedTask().execute(null, null, null);

		ip = super.getIntent().getExtras().getString("ipAddr");

		ImageView textView = (ImageView) findViewById(R.id.imageView1);
		Button button = (Button) findViewById(R.id.button1);

		textView.setOnTouchListener(new OnTouchListener() {
			float startX = 0;
			float startY = 0;
			float endX = 0;
			float endY = 0;
			float pX = 0;
			float pY = 0;
			int sense = 2;
			
			@Override
			public boolean onTouch(View view, MotionEvent event) {
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					startX = Math.round(event.getX()/10.0)*10;
					startY = Math.round(event.getY()/10.0)*10;
					break;
				case MotionEvent.ACTION_UP:
					break;
				case MotionEvent.ACTION_MOVE:
					Log.d("X", Math.round(event.getX()/10.0)*10+"");
					Log.d("Y", Math.round(event.getY()/10.0)*10+"");
					endX = Math.round(event.getX()/10.0)*10;
					endY = Math.round(event.getY()/10.0)*10;
					if(endX > startX){
						pX = 0 + sense;
					}else if(endX == startX){
						pX = 0;
					}else{
						pX = 0 - sense;
					}
					
					if(endY > startY){
						pY = 0 + sense;
					}else if(endY == startY){
						pY = 0;
					}else{
						pY = 0 - sense;
					}
					
					try {
						sendGeo((int)pX, (int)pY);
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
	 * 전송
	 * 
	 * @throws IOException
	 */
	public void sendGeo(int sendX, int sendY) throws IOException {
//		Log.d("XY!!!!!!!!!!", sendX + "/" + sendY);
		 connection.sendButClick((sendX+"/"+sendY).getBytes());
	}

	/**
	 * 좌표를 계산하여 전송
	 * 
	 * @throws IOException
	 */
	public void sendGeo(float startX, float startY, float endX, float endY)
			throws IOException {
		String sendX = endX - startX + "";
		String sendY = endY - startY + "";
		Log.d("XY!!!!!!!!!!", sendX + "/" + sendY);
		connection.sendButClick((sendX + "/" + sendY).getBytes());
	}

	/**
	 * 서버와 연결
	 * 
	 * @author RealPHS
	 * 
	 */
	class RetreiveFeedTask extends AsyncTask<Void, Void, Void> {

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
