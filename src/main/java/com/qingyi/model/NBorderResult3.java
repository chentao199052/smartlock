package com.qingyi.model;

public class NBorderResult3 {
	private String orderid;
	private Integer resultstatus;
	private Integer filetype;
	private String order;
	private String result;
	private String puids;
	private String rcids;
	public NBorderResult3() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NBorderResult3(String orderid, Integer resultstatus, Integer filetype, String order, String result,
			String puids, String rcids) {
		super();
		this.orderid = orderid;
		this.resultstatus = resultstatus;
		this.filetype = filetype;
		this.order = order;
		this.result = result;
		this.puids = puids;
		this.rcids = rcids;
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
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getPuids() {
		return puids;
	}
	public void setPuids(String puids) {
		this.puids = puids;
	}
	public String getRcids() {
		return rcids;
	}
	public void setRcids(String rcids) {
		this.rcids = rcids;
	}
	
}
