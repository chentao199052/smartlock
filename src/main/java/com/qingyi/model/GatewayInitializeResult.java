package com.qingyi.model;

public class GatewayInitializeResult {
	private String orderid;
	private Integer filetype;
	private Integer resultstatus;
	private String order;
	private String result;
	private Integer no;
	private String space;
	private String osdate; // 下发时间
	public GatewayInitializeResult() {
		super();
	}
	public GatewayInitializeResult(String orderid, Integer filetype, Integer resultstatus, String order, String result,
			Integer no, String space, String osdate) {
		super();
		this.orderid = orderid;
		this.filetype = filetype;
		this.resultstatus = resultstatus;
		this.order = order;
		this.result = result;
		this.no = no;
		this.space = space;
		this.osdate = osdate;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public Integer getFiletype() {
		return filetype;
	}
	public void setFiletype(Integer filetype) {
		this.filetype = filetype;
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
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public String getSpace() {
		return space;
	}
	public void setSpace(String space) {
		this.space = space;
	}
	public String getOsdate() {
		return osdate;
	}
	public void setOsdate(String osdate) {
		this.osdate = osdate;
	}
	
}
