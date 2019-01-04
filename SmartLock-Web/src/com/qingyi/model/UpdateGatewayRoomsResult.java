package com.qingyi.model;

public class UpdateGatewayRoomsResult {
	private String orderid;
	private Integer resultstatus;
	private Integer filetype;
	private Integer no;
	private String space;
	private String order;
	private String result;
	public UpdateGatewayRoomsResult() {
		super();
	}
	public UpdateGatewayRoomsResult(String orderid, Integer resultstatus, Integer filetype, Integer no, String space,
			String order, String result) {
		super();
		this.orderid = orderid;
		this.resultstatus = resultstatus;
		this.filetype = filetype;
		this.no = no;
		this.space = space;
		this.order = order;
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
	
	
}
