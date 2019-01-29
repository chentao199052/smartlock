package com.qingyi.model;

/**
 * 卡密授权同步解析结果
 * @author Administrator
 *
 */
public class SyncFOrderResult {
	
	private String orderid;
	
	private Integer resultstatus;
	
	private Integer failtype;
	
	private String orderType;
	
	private String no;
	
	private String osdate;
	
	private String fingers;
	
	public SyncFOrderResult() {
		super();
	}

	/**
	 * 卡密授权同步解析结果
	 * @param orderid 指令id(如果结果包含多个指令id，以逗号隔开，如："12,13")
	 * @param resultstatus 结果状态（0-下发失败，1-下发成功，2-异常失败）
	 * @param failtype 失败类型
	 * @param orderType 结果类型（总结果-1，小包结果-0）
	 * @param no 下发轮次
	 * @param osdate 指令下发时间
	 * @param fingers 小包结果所包含的指纹
	 */
	public SyncFOrderResult(String orderid,Integer resultstatus, Integer failtype, String orderType, String no, String osdate,
			String fingers) {
		super();
		this.orderid = orderid;
		this.resultstatus = resultstatus;
		this.failtype = failtype;
		this.orderType = orderType;
		this.no = no;
		this.osdate = osdate;
		this.fingers = fingers;
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

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
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

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getFingers() {
		return fingers;
	}

	public void setFingers(String fingers) {
		this.fingers = fingers;
	}
	
	
}
