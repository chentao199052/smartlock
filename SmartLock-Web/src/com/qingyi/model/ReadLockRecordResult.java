package com.qingyi.model;

import java.util.List;

public class ReadLockRecordResult {
	private String orderid;
	private Integer filetype;
	private Integer resultstatus;
	private String no;
	private String order;
	private String result;
	private String space;
	private List<ReadLockRecord> lockRecords;
	public ReadLockRecordResult() {
		super();
	}
	public ReadLockRecordResult(String orderid, Integer filetype, Integer resultstatus, String no, String order,
			String result, String space, List<ReadLockRecord> lockRecords) {
		super();
		this.orderid = orderid;
		this.filetype = filetype;
		this.resultstatus = resultstatus;
		this.no = no;
		this.order = order;
		this.result = result;
		this.space = space;
		this.lockRecords = lockRecords;
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
	public Integer getResultstatus() {
		return resultstatus;
	}
	public void setResultstatus(Integer resultstatus) {
		this.resultstatus = resultstatus;
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
	public List<ReadLockRecord> getLockRecords() {
		return lockRecords;
	}
	public void setLockRecords(List<ReadLockRecord> lockRecords) {
		this.lockRecords = lockRecords;
	}
	
}
