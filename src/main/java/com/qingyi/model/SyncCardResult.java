package com.qingyi.model;

public class SyncCardResult {
	private String orderType;
	private SyncFailResult failResult;
	private SyncFinishResult finishResult;
	private SyncSuccessResult successResult;
	public SyncCardResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SyncCardResult(String orderType, SyncFailResult failResult, SyncFinishResult finishResult,
			SyncSuccessResult successResult) {
		super();
		this.orderType = orderType;
		this.failResult = failResult;
		this.finishResult = finishResult;
		this.successResult = successResult;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public SyncFailResult getFailResult() {
		return failResult;
	}
	public void setFailResult(SyncFailResult failResult) {
		this.failResult = failResult;
	}
	public SyncFinishResult getFinishResult() {
		return finishResult;
	}
	public void setFinishResult(SyncFinishResult finishResult) {
		this.finishResult = finishResult;
	}
	public SyncSuccessResult getSuccessResult() {
		return successResult;
	}
	public void setSuccessResult(SyncSuccessResult successResult) {
		this.successResult = successResult;
	}
	
	
	
}
