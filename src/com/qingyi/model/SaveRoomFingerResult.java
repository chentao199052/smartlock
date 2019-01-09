package com.qingyi.model;

public class SaveRoomFingerResult {
	private String orderid;
	private Integer resultstatus;
	private Integer filetype;
	private String type;
	private String num;
	private String fingercodes;
	

	public SaveRoomFingerResult() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SaveRoomFingerResult(String orderid, Integer resultstatus, Integer filetype, String type, String num,
			String fingercodes) {
		super();
		this.orderid = orderid;
		this.resultstatus = resultstatus;
		this.filetype = filetype;
		this.type = type;
		this.num = num;
		this.fingercodes = fingercodes;
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


	public String getNum() {
		return num;
	}


	public void setNum(String num) {
		this.num = num;
	}


	public String getFingercodes() {
		return fingercodes;
	}


	public void setFingercodes(String fingercodes) {
		this.fingercodes = fingercodes;
	}
	
}