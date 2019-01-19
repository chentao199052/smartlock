package com.qingyi.model;

public class NBorderResult5 {
	private String orderid;
	private Integer resultstatus;
	private String order;
	private String failids;
	private String result;
	public NBorderResult5() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NBorderResult5(String orderid, Integer resultstatus, String order, String failids, String result) {
		super();
		this.orderid = orderid;
		this.resultstatus = resultstatus;
		this.order = order;
		this.failids = failids;
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
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getFailids() {
		return failids;
	}
	public void setFailids(String failids) {
		this.failids = failids;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
}
