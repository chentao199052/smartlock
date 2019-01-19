package com.qingyi.model;

public class NBorderResult {
	private Integer resultstatus;
	private String order;
	private String ids;
	public NBorderResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NBorderResult(Integer resultstatus, String order, String ids) {
		super();
		this.resultstatus = resultstatus;
		this.order = order;
		this.ids = ids;
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
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	
}
