package com.qingyi.model;

public class NbOpenResult {
	private String itid;
	private String roomtxtype;
	private String status;
	private String roomcode2;
	private String osdate;
	
	
	
	public NbOpenResult() {
		super();
		// TODO Auto-generated constructor stub
	}



	public NbOpenResult(String itid, String roomtxtype, String status, String roomcode2, String osdate) {
		super();
		this.itid = itid;
		this.roomtxtype = roomtxtype;
		this.status = status;
		this.roomcode2 = roomcode2;
		this.osdate = osdate;
	}



	public String getItid() {
		return itid;
	}



	public void setItid(String itid) {
		this.itid = itid;
	}



	public String getRoomtxtype() {
		return roomtxtype;
	}



	public void setRoomtxtype(String roomtxtype) {
		this.roomtxtype = roomtxtype;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getRoomcode2() {
		return roomcode2;
	}



	public void setRoomcode2(String roomcode2) {
		this.roomcode2 = roomcode2;
	}



	public String getOsdate() {
		return osdate;
	}



	public void setOsdate(String osdate) {
		this.osdate = osdate;
	}
	
	
	
	
}
