package com.qingyi.model;
/**
 * 指纹指令分包成功
 * @author Administrator
 *
 */
public class FingerfinishResult {
	private String orderid;
	private String rcid;
	private Integer resultstatus;
	private Integer filetype;
	private String type;
	private String order;
	private String fingercodes;
	private String result;
	private String osdate; // 下发时间
	private String space;//
	public FingerfinishResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FingerfinishResult(String orderid, String rcid, Integer resultstatus, Integer filetype, String type,
			String order, String fingercodes, String result, String osdate, String space) {
		super();
		this.orderid = orderid;
		this.rcid = rcid;
		this.resultstatus = resultstatus;
		this.filetype = filetype;
		this.type = type;
		this.order = order;
		this.fingercodes = fingercodes;
		this.result = result;
		this.osdate = osdate;
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
	public Integer getFiletype() {
		return filetype;
	}
	public void setFiletype(Integer filetype) {
		this.filetype = filetype;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getOsdate() {
		return osdate;
	}
	public void setOsdate(String osdate) {
		this.osdate = osdate;
	}
	public String getSpace() {
		return space;
	}
	public void setSpace(String space) {
		this.space = space;
	}
	
}
