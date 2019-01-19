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
	private String oscontent; // 下发指令
	private String osdate; // 下发时间
	private String osresult;//结果
	private Integer oscount;//次数
	private String osstatus;//指令状态
	private String osspace;//
	private List<ReadLockRecord> lockRecords;
	public ReadLockRecordResult() {
		super();
	}
	public ReadLockRecordResult(String orderid, String itid, Integer filetype, Integer resultstatus,
			Integer recordcount, String no, String order, String result, String space, String oscontent, String osdate,
			String osresult, Integer oscount, String osstatus, String osspace, List<ReadLockRecord> lockRecords) {
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
		this.oscontent = oscontent;
		this.osdate = osdate;
		this.osresult = osresult;
		this.oscount = oscount;
		this.osstatus = osstatus;
		this.osspace = osspace;
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
	public String getOscontent() {
		return oscontent;
	}
	public void setOscontent(String oscontent) {
		this.oscontent = oscontent;
	}
	public String getOsdate() {
		return osdate;
	}
	public void setOsdate(String osdate) {
		this.osdate = osdate;
	}
	public String getOsresult() {
		return osresult;
	}
	public void setOsresult(String osresult) {
		this.osresult = osresult;
	}
	public Integer getOscount() {
		return oscount;
	}
	public void setOscount(Integer oscount) {
		this.oscount = oscount;
	}
	public String getOsstatus() {
		return osstatus;
	}
	public void setOsstatus(String osstatus) {
		this.osstatus = osstatus;
	}
	public String getOsspace() {
		return osspace;
	}
	public void setOsspace(String osspace) {
		this.osspace = osspace;
	}
	public List<ReadLockRecord> getLockRecords() {
		return lockRecords;
	}
	public void setLockRecords(List<ReadLockRecord> lockRecords) {
		this.lockRecords = lockRecords;
	}
	
	
}
