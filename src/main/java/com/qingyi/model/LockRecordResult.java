package com.qingyi.model;

import java.util.List;

public class LockRecordResult {
	private String orderid;
	private String roomcode2;//只有NB锁有值
	private String locktype;
	private Integer filetype;
	private Integer resultstatus;
	private Integer recordcount;
	private String no;
	private String order;
	private String result;
	private String space;
	private String osdate; // 下发时间
	private List<ReadLockRecord> lockRecords;
	public LockRecordResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LockRecordResult(String orderid, String roomcode2, String locktype, Integer filetype, Integer resultstatus,
			Integer recordcount, String no, String order, String result, String space, String osdate,
			List<ReadLockRecord> lockRecords) {
		super();
		this.orderid = orderid;
		this.roomcode2 = roomcode2;
		this.locktype = locktype;
		this.filetype = filetype;
		this.resultstatus = resultstatus;
		this.recordcount = recordcount;
		this.no = no;
		this.order = order;
		this.result = result;
		this.space = space;
		this.osdate = osdate;
		this.lockRecords = lockRecords;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getRoomcode2() {
		return roomcode2;
	}
	public void setRoomcode2(String roomcode2) {
		this.roomcode2 = roomcode2;
	}
	public String getLocktype() {
		return locktype;
	}
	public void setLocktype(String locktype) {
		this.locktype = locktype;
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
	public Integer getRecordcount() {
		return recordcount;
	}
	public void setRecordcount(Integer recordcount) {
		this.recordcount = recordcount;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
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
	public List<ReadLockRecord> getLockRecords() {
		return lockRecords;
	}
	public void setLockRecords(List<ReadLockRecord> lockRecords) {
		this.lockRecords = lockRecords;
	}
	
	
}
