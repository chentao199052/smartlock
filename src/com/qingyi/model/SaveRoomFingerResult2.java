package com.qingyi.model;

public class SaveRoomFingerResult2 {
	private String orderid;
	private Integer resultstatus;
	private Integer filetype;
	private String type;
	private String fingercodes;
	private String result;
	public SaveRoomFingerResult2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SaveRoomFingerResult2(String orderid, Integer resultstatus, Integer filetype, String type,
			String fingercodes, String result) {
		super();
		this.orderid = orderid;
		this.resultstatus = resultstatus;
		this.filetype = filetype;
		this.type = type;
		this.fingercodes = fingercodes;
		this.result = result;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public Integer getResultstatus() {
		return resultstatus;
	}
	public void setResultstatus(Integer resultstatus) {
		this.resultstatus = resultstatus;
	}
	public Integer getFiletype() {
		return filetype;
	}
	public void setFiletype(Integer filetype) {
		this.filetype = filetype;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFingercodes() {
		return fingercodes;
	}
	public void setFingercodes(String fingercodes) {
		this.fingercodes = fingercodes;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	
}
