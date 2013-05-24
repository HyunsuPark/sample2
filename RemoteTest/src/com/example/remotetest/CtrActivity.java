package com.example.remotetest;

import java.io.IOException;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CtrActivity extends Activity {

	private Connection connection = new Connection();
	private String ip;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.controller);
		
		new RetreiveFeedTask().execute(null,null,null);
		
		ip = super.getIntent().getExtras().getString(
				"ipAddr");
		
//		TextView textView = (TextView) findViewById(R.id.mousePad);
		Button button = (Button) findViewById(R.id.button1);

		//버튼클릭
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					//m 이라는 스트링을 보내줌.
					connection.sendButClick("m".getBytes());
					//move라는 메시지를 띄어줌
					Toast.makeText(getApplicationContext(), "move",	Toast.LENGTH_SHORT).show();
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
	}
	
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
