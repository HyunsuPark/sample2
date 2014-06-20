package com.UTerest.lol_sensor.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.widget.Toast;

import com.UTerest.lol_sensor.MainActivity;
import com.UTerest.lol_sensor.R;

public class Util {
	public static String getCurrentTime(){
		long now = System.currentTimeMillis();
		// 현재 시간을 저장 한다.
		Date date = new Date(now);
		// 시간 포맷으로 만든다.
		SimpleDateFormat sdfNow = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String strNow = sdfNow.format(date);
		return strNow;
	}
	
	public static boolean HttpPostData(HttpClient client,String lolId) throws ParseException, IOException {
		 boolean rtn = false;
		 String url = "http://www.op.gg/summoner/ajax/spectator/";
		 HttpPost post = new HttpPost(url);
		 post.setHeader("Content-Type",
                "application/x-www-form-urlencoded;charset=UTF-8");
		 List params = new ArrayList(); 
		//파라미터 이름, 보낼 데이터 순입니다.
		   params.add(new BasicNameValuePair("userName", lolId)); 
		   params.add(new BasicNameValuePair("force", "true"));

		   UrlEncodedFormEntity ent = new UrlEncodedFormEntity(

                  params,HTTP.UTF_8);
			post.setEntity(ent);
			HttpResponse responsePOST = client.execute(post);
			HttpEntity resEntity = responsePOST.getEntity();
			
			String text = EntityUtils.toString(resEntity);
			
			if (resEntity != null) {
//				Log.i("RESPONSE", text+"");
				if(text.indexOf("아닙니다")<0){
					rtn =  false; //접속
				}else{
					rtn = true; //미접속
				}
			}
			return rtn;

	}
	
	public static String HttpGetData(HttpClient client,String lolId) throws ParseException, IOException {
		String url = "http://kr.wastedonlol.com/kr-"+lolId+"/";
		String res = "";
		
		HttpGet get = new HttpGet(url);
		HttpResponse response = client.execute(get);
		HttpEntity resEntity = response.getEntity();
		if(resEntity != null){
			res = EntityUtils.toString(resEntity);
		}
		
		return res;
	}
	
}
