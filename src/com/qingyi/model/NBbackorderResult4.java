package com.qingyi.model;

public class NBbackorderResult4 {
	private String orderid;
	private Integer resultstatus;
	private Integer num;
	public NBbackorderResult4() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NBbackorderResult4(String orderid, Integer resultstatus, Integer num) {
		super();
		this.orderid = orderid;
		this.resultstatus = resultstatus;
		this.num = num;
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
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
	
}
