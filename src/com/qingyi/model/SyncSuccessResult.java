package com.qingyi.model;

public class SyncSuccessResult {
	private String orderid;
	private Integer resultstatus;
	private Integer filetype;
	private String result;
	public SyncSuccessResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SyncSuccessResult(String orderid, Integer resultstatus, Integer filetype, String result) {
		super();
		this.orderid = orderid;
		this.resultstatus = resultstatus;
		this.filetype = filetype;
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
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
}
