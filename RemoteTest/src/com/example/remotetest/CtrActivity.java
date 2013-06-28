package com.example.remotetest;

import java.io.IOException;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
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

		ImageView textView = (ImageView) findViewById(R.id.controller);
		//패드부분
		textView.setOnTouchListener(new OnTouchListener() {
			float startX = 0;
			float startY = 0;
			float endX = 0;
			float endY = 0;
			long lastTouchTime = -1;
			
			@Override
			public boolean onTouch(View view, MotionEvent event) {
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					startX = event.getX();
					startY = event.getY();
					Log.d("getAction", event.getAction()+"");
					Log.d("ACTION_MOVE", MotionEvent.ACTION_MOVE+"");
					if(event.getAction()!=MotionEvent.ACTION_MOVE){
						try {
							sendLeftBtn();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
					break;
				case MotionEvent.ACTION_UP:
					endX = event.getX();
					endY = event.getY();
					try {
						sendGeo(startX, startY, endX, endY);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case MotionEvent.ACTION_MOVE:
					break;
				case MotionEvent.ACTION_CANCEL:
					break;
				}
				return true;
			}
		});
		//패드 끝
		
		//왼족버튼
		Button lbutton = (Button) findViewById(R.id.lbtn);
		
		lbutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					sendLeftBtn();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		//왼족버튼끝
		
		//오른쪽버튼
		Button rbutton = (Button) findViewById(R.id.rbtn);
		
		rbutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					sendRightBtn();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		//오른쪽버튼
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
	 * 오른쪽버튼클릭
	 * @throws IOException
	 */
	public void sendRightBtn() throws IOException {
		Log.d("XY!!!!!!!!!!","RRR");
		connection.sendButClick("R".getBytes());
	}

	/**
	 * 왼쪽버튼클릭
	 * @throws IOException
	 */
	public void sendLeftBtn() throws IOException {
		Log.d("XY!!!!!!!!!!","LLL");
		connection.sendButClick("L".getBytes());
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
