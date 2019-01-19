package com.qingyi.model;

public class NBorderResult7 {
	private String orderid;
	private Integer resultstatus;
	private Integer failtype;
	private String resultorder;
	private String order;
	private String rfid;
	public NBorderResult7() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NBorderResult7(String orderid, Integer resultstatus, Integer failtype, String resultorder, String order,
			String rfid) {
		super();
		this.orderid = orderid;
		this.resultstatus = resultstatus;
		this.failtype = failtype;
		this.resultorder = resultorder;
		this.order = order;
		this.rfid = rfid;
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
	public Integer getFailtype() {
		return failtype;
	}
	public void setFailtype(Integer failtype) {
		this.failtype = failtype;
	}
	public String getResultorder() {
		return resultorder;
	}
	public void setResultorder(String resultorder) {
		this.resultorder = resultorder;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getRfid() {
		return rfid;
	}
	public void setRfid(String rfid) {
		this.rfid = rfid;
	}
	
}
