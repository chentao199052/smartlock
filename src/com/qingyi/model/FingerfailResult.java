package com.qingyi.model;

public class FingerfailResult {
	private String orderid;// 分布式ID
	private String rcid;//删除指纹授权时为roomid  授权同步/授权为分布式ID 重载白名单为SlRoomfinger id
	private Integer resultstatus;
	private Integer failtype;
	private String type;
	private String num;
	private String order;
	private String fingercodes;
	private String osdate; // 下发时间
	private String result;//结果
	private String space;//
	
	
	
	public FingerfailResult() {
		super();
		// TODO Auto-generated constructor stub
	}



	public FingerfailResult(String orderid, String rcid, Integer resultstatus, Integer failtype, String type,
			String num, String order, String fingercodes, String osdate, String result, String space) {
		super();
		this.orderid = orderid;
		this.rcid = rcid;
		this.resultstatus = resultstatus;
		this.failtype = failtype;
		this.type = type;
		this.num = num;
		this.order = order;
		this.fingercodes = fingercodes;
		this.osdate = osdate;
		this.result = result;
		this.space = space;
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



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getNum() {
		return num;
	}



	public void setNum(String num) {
		this.num = num;
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



	public String getOsdate() {
		return osdate;
	}



	public void setOsdate(String osdate) {
		this.osdate = osdate;
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
