package com.qingyi.model;

public class NBbackorderResult2 {
	private String orderid;
	private Integer resultstatus;
	private String order;
	private Integer num;
	private String finishorder;
	private String rcids;
	public NBbackorderResult2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NBbackorderResult2(String orderid, Integer resultstatus, String order, Integer num, String finishorder,
			String rcids) {
		super();
		this.orderid = orderid;
		this.resultstatus = resultstatus;
		this.order = order;
		this.num = num;
		this.finishorder = finishorder;
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
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getFinishorder() {
		return finishorder;
	}
	public void setFinishorder(String finishorder) {
		this.finishorder = finishorder;
	}
	public String getRcids() {
		return rcids;
	}
	public void setRcids(String rcids) {
		this.rcids = rcids;
	}
}
