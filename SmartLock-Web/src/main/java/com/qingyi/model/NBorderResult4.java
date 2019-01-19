package com.qingyi.model;

public class NBorderResult4 {
	private String orderid;
	private Integer resultstatus;
	private String order;
	private String[] orders;
	public NBorderResult4() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NBorderResult4(String orderid, Integer resultstatus, String order, String[] orders) {
		super();
		this.orderid = orderid;
		this.resultstatus = resultstatus;
		this.order = order;
		this.orders = orders;
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
	public String[] getOrders() {
		return orders;
	}
	public void setOrders(String[] orders) {
		this.orders = orders;
	}
	
	
}
