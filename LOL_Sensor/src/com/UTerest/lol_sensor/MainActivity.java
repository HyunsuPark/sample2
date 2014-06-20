package com.UTerest.lol_sensor;

import java.io.IOException;

import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

import com.UTerest.lol_sensor.util.Util;

public class MainActivity extends Activity {
	 //알림 메니저 객체
	 NotificationManager notiManager;
	 //진동을 줘보자 진동객체
	 Vibrator vibrator;
	 //알림 식별값
	 final static int MyNoti=0;
	
	 HttpClient client;
	 EditText et;
	 String lolId;
	 
	 private ProgressDialog loagindDialog;
	 
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);

		client = new DefaultHttpClient();
		
		//알림 메니저 객체 얻어오기
        notiManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        //진동 객체 생성
        vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
		
        et = (EditText)findViewById(R.id.editID);
        
        
		Button btn = (Button)findViewById(R.id.btnSearch);
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					lolId = et.getText().toString();
//					createThreadAndDialog();
					if(!Util.HttpPostData(client, lolId)){
						getNotifi(lolId);	
					} else{
						Toast toast = Toast.makeText(getApplicationContext(), lolId+"님은 접속중이 아닙니다", Toast.LENGTH_SHORT);
						toast.show();	
					}
				} catch (ParseException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
		Button btnPlayTime = (Button)findViewById(R.id.btnPlayTime);
		btnPlayTime.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				lolId = et.getText().toString();
				String url = "http://kr.wastedonlol.com/kr-"+lolId+"/";
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
				startActivity(intent);
			}
		});
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void getNotifi(String lolId){
		Notification noti = new Notification(R.drawable.ic_launcher//알림창에 띄울 아이콘
	               , lolId+"님이 접속하였습니다!!!! " + Util.getCurrentTime(), //간단 메세지
	               System.currentTimeMillis()); //도착 시간
	      //기본으로 지정된 소리를 내기 위해
	      noti.defaults = Notification.DEFAULT_SOUND;
	      //알림 소리를 한번만 내도록
	      noti.flags = Notification.FLAG_ONLY_ALERT_ONCE;
	      //확인하면 자동으로 알림이 제거 되도록
	      noti.flags = Notification.FLAG_AUTO_CANCEL;
	      //사용자가 알람을 확인하고 클릭했을때 새로운 액티비티를 시작할 인텐트 객체
	      Intent intent = new Intent(MainActivity.this, MainActivity.class);
	      //새로운 태스크(Task) 상에서 실행되도록(보통은 태스크1에 쌓이지만 태스크2를 만들어서 전혀 다른 실행으로 관리한다)
	      intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	      //인텐트 객체를 포장해서 전달할 인텐트 전달자 객체
	      PendingIntent pendingI = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
	      //상단바를 드래그 했을때 보여질 내용 정의하기
	      noti.setLatestEventInfo(MainActivity.this, "[알림]", lolId+"님이 접속하였습니다!!!! ", pendingI);
	      //알림창 띄우기(알림이 여러개일수도 있으니 알림을 구별할 상수값, 여러개라면 상수값을 달리 줘야 한다.)
	      notiManager.notify(MyNoti, noti);
	      //진동주기(** 퍼미션이 필요함 **)
	      vibrator.vibrate(2000); //2초 동안 진동
	}
	
	void createThreadAndDialog() {
        
        /* ProgressDialog */
        loagindDialog = ProgressDialog.show(this, "Loading",
                "Searching....", true, false);
         
        Thread thread = new Thread(new Runnable() {
            private static final int LOADING_TIME = 3000;  
            @Override
            public void run() {
                // 시간걸리는 처리
                handler.sendEmptyMessageDelayed(0, LOADING_TIME);   
            }
        });
        thread.start();
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            loagindDialog.dismiss(); // 다이얼로그 삭제
            // View갱신
        }
    };
}
