package com.qingyi.model;

public class SendResult {
	
	private String resultCode;
	
	private String resultMsg;
	
	private String orderId;

	public SendResult() {
		super();
	}

	public SendResult(String resultCode, String resultMsg, String orderId) {
		super();
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
		this.orderId = orderId;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
}
