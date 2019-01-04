package com.qingyi.model;

public class SyncFailResult {
	private String orderid;
	private Integer resultstatus;
	private Integer filetype;
	private String num;
	private String fail;
	private String cardcodes;
	public SyncFailResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SyncFailResult(String orderid, Integer resultstatus, Integer filetype, String num, String fail,
			String cardcodes) {
		super();
		this.orderid = orderid;
		this.resultstatus = resultstatus;
		this.filetype = filetype;
		this.num = num;
		this.fail = fail;
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
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getFail() {
		return fail;
	}
	public void setFail(String fail) {
		this.fail = fail;
	}
	public String getCardcodes() {
		return cardcodes;
	}
	public void setCardcodes(String cardcodes) {
		this.cardcodes = cardcodes;
	}
}
