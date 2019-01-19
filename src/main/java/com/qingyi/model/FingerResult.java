package com.qingyi.model;

public class FingerResult {
	private String orderType;
	private FingerfailResult failResult;
	private FingerfinishResult finishResult;
	private FingersuccessResult successResult;
	public FingerResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FingerResult(String orderType, FingerfailResult failResult, FingerfinishResult finishResult,
			FingersuccessResult successResult) {
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
	public FingerfailResult getFailResult() {
		return failResult;
	}
	public void setFailResult(FingerfailResult failResult) {
		this.failResult = failResult;
	}
	public FingerfinishResult getFinishResult() {
		return finishResult;
	}
	public void setFinishResult(FingerfinishResult finishResult) {
		this.finishResult = finishResult;
	}
	public FingersuccessResult getSuccessResult() {
		return successResult;
	}
	public void setSuccessResult(FingersuccessResult successResult) {
		this.successResult = successResult;
	}
	
	
}
