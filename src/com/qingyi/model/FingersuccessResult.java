package com.qingyi.model;

public class FingersuccessResult {
	private String orderid;
	private Integer resultstatus;
	private Integer filetype;
	private String type;
	private String order;
	private String fingercodes;
	private String result;
	public FingersuccessResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FingersuccessResult(String orderid, Integer resultstatus, Integer filetype, String type, String order,
			String fingercodes, String result) {
		super();
		this.orderid = orderid;
		this.resultstatus = resultstatus;
		this.filetype = filetype;
		this.type = type;
		this.order = order;
		this.fingercodes = fingercodes;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getFingercodes() {
		return fingercodes;
	}
	public void setFingercodes(String fingercodes) {
		this.fingercodes = fingercodes;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
}
