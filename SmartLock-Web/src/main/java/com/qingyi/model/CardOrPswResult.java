package com.qingyi.model;

public class CardOrPswResult {
	
	private String orderid;
	private Integer resultstatus;
	private Integer failtype;
	private String order;
	private String orderType;
	private String result;
	private String no;
	private String osdate; // 下发时间
	private String locktype;
	public CardOrPswResult() {
		super();
	}
	/**
	 * 卡密授权，删除授权，指纹删除授权结果处理
	 * @param orderid 指令id
	 * @param resultstatus 结果状态（0-下发失败，1-下发成功，2-异常失败）
	 * @param failtype 失败类型
	 * @param order 下发指令
	 * @param orderType 结果键名（最终结果-ordersuccess，单轮失败结果-orderfail，NB锁成功结果-c1success，NB锁失败结果-c1fail）
	 * @param result 门锁返回指令
	 * @param no 下发次数
	 * @param osdate 指令时间
	 * @param locktype 门锁类型（1联网锁，2华为NB，3电信NB，4移动NB）
	 */
	public CardOrPswResult(String orderid, Integer resultstatus, Integer failtype, String order,
			String orderType, String result, String no, String osdate,String locktype) {
		super();
		this.orderid = orderid;
		this.resultstatus = resultstatus;
		this.failtype = failtype;
		this.order = order;
		this.orderType = orderType;
		this.result = result;
		this.no = no;
		this.osdate = osdate;
		this.locktype = locktype;
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
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	
	public String getOsdate() {
		return osdate;
	}
	public void setOsdate(String osdate) {
		this.osdate = osdate;
	}
	public String getLocktype() {
		return locktype;
	}
	public void setLocktype(String locktype) {
		this.locktype = locktype;
	}
	
}
