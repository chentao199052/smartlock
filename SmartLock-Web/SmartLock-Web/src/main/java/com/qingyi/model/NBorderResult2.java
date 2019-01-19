package com.qingyi.model;

public class NBorderResult2 {
	private Integer resultstatus;
	private String order;
	private String id;
	public NBorderResult2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NBorderResult2(Integer resultstatus, String order, String id) {
		super();
		this.resultstatus = resultstatus;
		this.order = order;
		this.id = id;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
