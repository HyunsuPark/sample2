package com.chat;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MouseHandler {
	
	public void mouseMove(String msg) throws AWTException{
		Map<String, String> geoMap = getMouseGeo(msg);
	    Robot robot = new Robot();
        
	    //폰에서 넘어온 벡터값
	    int screenX = (int)Float.parseFloat(geoMap.get("screenX")) ;
	    int screenY = (int)Float.parseFloat(geoMap.get("screenY")) ;
	    
	    //현재 x,y좌표
	    int defX = MouseInfo.getPointerInfo().getLocation().x;
	    int defY = MouseInfo.getPointerInfo().getLocation().y;
	    
        robot.mouseMove(defX + screenX, defY + screenY);
	}
	
	private Map<String, String> getMouseGeo(String msg){
		int i = 0;
		StringTokenizer st = new StringTokenizer(msg,"/");
		Map<String, String> map = new HashMap<String, String>();
		
		String[] arrData = new String[st.countTokens()];

		while(st.hasMoreTokens())
		{
			arrData[i++] = st.nextToken().trim();
		}
		
		map.put("screenX", arrData[0]);
		map.put("screenY", arrData[1]);
		
		return map;
	}
}
