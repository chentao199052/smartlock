package com.qingyi.model;

public class NbForcelockResult {
	private String itid;
	private String roomtxtype;
	private String status;
	private String roomcode2;
	private String osdate;
	private String order;
	public NbForcelockResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NbForcelockResult(String itid, String roomtxtype, String status, String roomcode2, String osdate,
			String order) {
		super();
		this.itid = itid;
		this.roomtxtype = roomtxtype;
		this.status = status;
		this.roomcode2 = roomcode2;
		this.osdate = osdate;
		this.order = order;
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
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	
	
}
