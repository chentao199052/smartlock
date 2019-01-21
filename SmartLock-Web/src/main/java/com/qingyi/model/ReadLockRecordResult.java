package com.qingyi.model;

import java.util.List;

public class ReadLockRecordResult {
	private String orderid;
	private String itid;//slIntimeorder 的主键
	private Integer filetype;
	private Integer resultstatus;
	private Integer Recordcount;
	private String no;
	private String order;
	private String result;
	private String space;
	private String osdate; // 下发时间
	private List<ReadLockRecord> lockRecords;
	public ReadLockRecordResult() {
		super();
	}
	public ReadLockRecordResult(String orderid, String itid, Integer filetype, Integer resultstatus,
			Integer recordcount, String no, String order, String result, String space, String osdate,
			List<ReadLockRecord> lockRecords) {
		super();
		this.orderid = orderid;
		this.itid = itid;
		this.filetype = filetype;
		this.resultstatus = resultstatus;
		Recordcount = recordcount;
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
	public String getItid() {
		return itid;
	}
	public void setItid(String itid) {
		this.itid = itid;
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
		return Recordcount;
	}
	public void setRecordcount(Integer recordcount) {
		Recordcount = recordcount;
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
