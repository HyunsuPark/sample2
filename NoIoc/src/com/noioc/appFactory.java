package com.noioc;

public class appFactory {
	
	public myInter getApp(String s){
		if(s.equals("1")){
			return new app1();
		}else if(s.equals("2")){
			return new app2();
		}else{
			return null;
		}
	}
}
