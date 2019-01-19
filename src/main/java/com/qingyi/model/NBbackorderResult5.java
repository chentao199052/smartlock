package com.qingyi.model;

public class NBbackorderResult5 {
	private Integer resultstatus;
	private String orderid;
	private String order;
	private String old;
	private String[] param;
	public NBbackorderResult5() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NBbackorderResult5(Integer resultstatus, String orderid, String order, String old, String[] param) {
		super();
		this.resultstatus = resultstatus;
		this.orderid = orderid;
		this.order = order;
		this.old = old;
		this.param = param;
	}
	public Integer getResultstatus() {
		return resultstatus;
	}
	public void setResultstatus(Integer resultstatus) {
		this.resultstatus = resultstatus;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getOld() {
		return old;
	}
	public void setOld(String old) {
		this.old = old;
	}
	public String[] getParam() {
		return param;
	}
	public void setParam(String[] param) {
		this.param = param;
	}
	
	
}
