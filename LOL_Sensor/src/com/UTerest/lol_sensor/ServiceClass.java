package com.UTerest.lol_sensor;

import java.io.IOException;

import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import com.UTerest.lol_sensor.util.Util;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Vibrator;
import android.widget.Toast;

public class ServiceClass extends Service {

	HttpClient client;
	//알림 메니저 객체
	 NotificationManager notiManager;
	 //진동을 줘보자 진동객체
	 Vibrator vibrator;
	 //알림 식별값
	 final static int MyNoti=0;
	 
	 private String lolId;
	 private long sleepTime;
	 
	 ServiceThread st;
	 
	@Override
	public void onCreate() {
		client = new DefaultHttpClient();
		
		// 메인 핸들러 생성
	     
		super.onCreate();
	}
	
    
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		super.onStartCommand(intent, flags, startId);
		Toast.makeText(this, "서비스시작", Toast.LENGTH_SHORT).show();
		
		lolId = intent.getStringExtra("lolId");
		st = new ServiceThread();
		st.start();
		
		return START_STICKY;
		
	}
	
	class ServiceThread extends Thread implements Runnable {
		private boolean isPlay = false;
        
        public ServiceThread() {
            isPlay = true;
        }
         
        public void isThreadState(boolean isPlay) {
            this.isPlay = isPlay;
        }
         
        public void stopThread() {
            isPlay = !isPlay;
        }
		
		@Override
		public void run() {
			super.run();
			
			while (isPlay) {
				try {
					runToast("msg!!!!!!!");
					Thread.sleep(60000 * 1);
				} catch (InterruptedException e) { 
					e.printStackTrace(); 
				}
			}
		}
	}
	
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onDestroy() {
		Toast.makeText(this, "서비스종료", Toast.LENGTH_SHORT).show();
		super.onDestroy();
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
	      Intent intent = new Intent(ServiceClass.this, ServiceClass.class);
	      //새로운 태스크(Task) 상에서 실행되도록(보통은 태스크1에 쌓이지만 태스크2를 만들어서 전혀 다른 실행으로 관리한다)
	      intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	      //인텐트 객체를 포장해서 전달할 인텐트 전달자 객체
	      PendingIntent pendingI = PendingIntent.getActivity(ServiceClass.this, 0, intent, 0);
	      //상단바를 드래그 했을때 보여질 내용 정의하기
	      noti.setLatestEventInfo(ServiceClass.this, "[알림]", lolId+"님이 접속하였습니다!!!! ", pendingI);
	      //알림창 띄우기(알림이 여러개일수도 있으니 알림을 구별할 상수값, 여러개라면 상수값을 달리 줘야 한다.)
	      notiManager.notify(MyNoti, noti);
	      //진동주기(** 퍼미션이 필요함 **)
	      vibrator.vibrate(2000); //2초 동안 진동
	}
	
	public void runToast(String msg){
		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
	}
}
