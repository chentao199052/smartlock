package com.qingyi.model;

public class UpdateRoomForcelockResult {
	private String orderid;
	private Integer filetype;
	private Integer resultstatus;
	private Integer no;
	private String order;
	private String result;
	private String space;
	
	
	public UpdateRoomForcelockResult() {
		super();
	}


	public UpdateRoomForcelockResult(String orderid, Integer filetype, Integer resultstatus, Integer no, String order,
			String result, String space) {
		super();
		this.orderid = orderid;
		this.filetype = filetype;
		this.resultstatus = resultstatus;
		this.no = no;
		this.order = order;
		this.result = result;
		this.space = space;
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


	public Integer getNo() {
		return no;
	}


	public void setNo(Integer no) {
		this.no = no;
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


	public String getSpace() {
		return space;
	}


	public void setSpace(String space) {
		this.space = space;
	}

	

	
}
