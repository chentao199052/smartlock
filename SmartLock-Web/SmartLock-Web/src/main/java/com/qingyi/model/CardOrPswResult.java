package com.qingyi.model;

public class CardOrPswResult {
	private String orderid;
	private String rcid;
	private Integer resultstatus;
	private Integer failtype;
	private String order;
	private String orderType;
	private String result;
	private String cardtype;
	private String no;
	private String space;
	private String osdate; // 下发时间
	public CardOrPswResult() {
		super();
	}
	public CardOrPswResult(String orderid, String rcid, Integer resultstatus, Integer failtype, String order,
			String orderType, String result, String cardtype, String no, String space, String osdate) {
		super();
		this.orderid = orderid;
		this.rcid = rcid;
		this.resultstatus = resultstatus;
		this.failtype = failtype;
		this.order = order;
		this.orderType = orderType;
		this.result = result;
		this.cardtype = cardtype;
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
	public String getRcid() {
		return rcid;
	}
	public void setRcid(String rcid) {
		this.rcid = rcid;
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
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getCardtype() {
		return cardtype;
	}
	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
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
