package com.example.remotetest;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText text;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		text = (EditText) findViewById(R.id.editText1);
		Button btn = (Button) findViewById(R.id.button1);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(text.getText().toString().equals("")){
					Toast.makeText(getApplicationContext(), "IP를 입력하세요", Toast.LENGTH_SHORT).show();
				}else{
					onConnect(text.getText().toString());
				}
			}
		});
	}
	
	protected void onConnect(String ipAddr) {
		// TODO Auto-generated method stub
		Intent myIntent = new Intent(this,CtrActivity.class);
		myIntent.putExtra("ipAddr", ipAddr);
		startActivity(myIntent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
