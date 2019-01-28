package com.qingyi.model;
/**
 * 门锁强锁/非强锁
 * @author Administrator
 *
 */
public class ForcelockResult {
	private String orderid;
	private Integer filetype;
	private String locktype;//门锁类型
	private String type;//1强制锁门 2非强制锁门
	private Integer resultstatus;//指令状态
	private Integer no;//次数
	private String order; // 下发指令
	private String result;//结果
	private String space;
	private String osdate; // 下发时间
	public ForcelockResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ForcelockResult(String orderid, Integer filetype, String locktype, String type, Integer resultstatus,
			Integer no, String order, String result, String space, String osdate) {
		super();
		this.orderid = orderid;
		this.filetype = filetype;
		this.locktype = locktype;
		this.type = type;
		this.resultstatus = resultstatus;
		this.no = no;
		this.order = order;
		this.result = result;
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
	public String getLocktype() {
		return locktype;
	}
	public void setLocktype(String locktype) {
		this.locktype = locktype;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public String getOsdate() {
		return osdate;
	}
	public void setOsdate(String osdate) {
		this.osdate = osdate;
	}

	
	
}
