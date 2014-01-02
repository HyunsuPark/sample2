package com.OMC.dtos.search;

import java.io.Serializable;

public class Select22Dto implements Serializable {

	private String roomCd;
	private String roomNm;
	public Select22Dto() {
	}
	public Select22Dto(String roomCd, String roomNm) {
		super();
		this.roomCd = roomCd;
		this.roomNm = roomNm;
	}
	@Override
	public String toString() {
		return "Select22Dto [roomCd=" + roomCd + ", roomNm=" + roomNm + "]";
	}
	public String getRoomCd() {
		return roomCd;
	}
	public void setRoomCd(String roomCd) {
		this.roomCd = roomCd;
	}
	public String getRoomNm() {
		return roomNm;
	}
	public void setRoomNm(String roomNm) {
		this.roomNm = roomNm;
	}

}
