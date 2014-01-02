package com.OMC.daos;

import java.util.List;

import com.OMC.dtos.LoginUserDto;
import com.OMC.dtos.NoticeDto;

public class OMCService {
	private OMCManager omcmanager; 
	private static OMCService OMCService;
	//private OMCManager manager;
	private OMCService() {
		omcmanager = new OMCManager();
	}
	public static OMCService getInstance(){
		if(OMCService ==null ){
			OMCService = new OMCService();
		}
		return OMCService;
	}
	public LoginUserDto getUserLogin(LoginUserDto dto){
		return omcmanager.getUserLogin(dto);
	}
	public Boolean addNotice(NoticeDto dto){
		return omcmanager.addNotice(dto);
	}
	public Boolean delNotice(int seq){
		return omcmanager.delNotice(seq);
	}
	public Boolean setNotice(NoticeDto dto){
		return omcmanager.setNotice(dto);
	}
}
