package com.qingyi.model;

public class SyncFinishResult {
	private String orderid;
	private Integer resultstatus;
	private Integer filetype;
	private String cardcodes;
	public SyncFinishResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SyncFinishResult(String orderid, Integer resultstatus, Integer filetype, String cardcodes) {
		super();
		this.orderid = orderid;
		this.resultstatus = resultstatus;
		this.filetype = filetype;
		this.cardcodes = cardcodes;
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
	public String getCardcodes() {
		return cardcodes;
	}
	public void setCardcodes(String cardcodes) {
		this.cardcodes = cardcodes;
	}
	
	
}
