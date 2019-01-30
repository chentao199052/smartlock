package com.qingyi.model;

import java.util.List;
/**
 * 网关记录解析
 * @author Administrator
 *
 */
public class HeartRecordResult {
	private Integer resultstatus;
	private String locktype;
	private String gatewaycode2;
	private List<HeartRecord> records;
	public HeartRecordResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HeartRecordResult(Integer resultstatus, String locktype, String gatewaycode2, List<HeartRecord> records) {
		super();
		this.resultstatus = resultstatus;
		this.locktype = locktype;
		this.gatewaycode2 = gatewaycode2;
		this.records = records;
	}
	public Integer getResultstatus() {
		return resultstatus;
	}
	public void setResultstatus(Integer resultstatus) {
		this.resultstatus = resultstatus;
	}
	public String getLocktype() {
		return locktype;
	}
	public void setLocktype(String locktype) {
		this.locktype = locktype;
	}
	public String getGatewaycode2() {
		return gatewaycode2;
	}
	public void setGatewaycode2(String gatewaycode2) {
		this.gatewaycode2 = gatewaycode2;
	}
	public List<HeartRecord> getRecords() {
		return records;
	}
	public void setRecords(List<HeartRecord> records) {
		this.records = records;
	}
	
	
}
