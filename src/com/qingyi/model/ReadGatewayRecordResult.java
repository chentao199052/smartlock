package com.qingyi.model;

import java.util.List;

public class ReadGatewayRecordResult {
	private String gatewaycode2;
	private String record;
	private List<GatewayRecord> gatewayRecords;
	public ReadGatewayRecordResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReadGatewayRecordResult(String gatewaycode2, String record, List<GatewayRecord> gatewayRecords) {
		super();
		this.gatewaycode2 = gatewaycode2;
		this.record = record;
		this.gatewayRecords = gatewayRecords;
	}
	public String getGatewaycode2() {
		return gatewaycode2;
	}
	public void setGatewaycode2(String gatewaycode2) {
		this.gatewaycode2 = gatewaycode2;
	}
	public String getRecord() {
		return record;
	}
	public void setRecord(String record) {
		this.record = record;
	}
	public List<GatewayRecord> getGatewayRecords() {
		return gatewayRecords;
	}
	public void setGatewayRecords(List<GatewayRecord> gatewayRecords) {
		this.gatewayRecords = gatewayRecords;
	}
	
	
	
}
