package com.qingyi.model;

public class SendResult<T> {
	
	private String resultCode;
	
	private String resultMsg;
	
	private String orderId;
	
	private T result;

	public SendResult() {
		super();
	}

	
	public SendResult(String resultCode, String resultMsg, String orderId) {
		super();
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
		this.orderId = orderId;
	}


	public SendResult(String resultCode, String resultMsg, String orderId, T result) {
		super();
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
		this.orderId = orderId;
		this.result = result;
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

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}


	@Override
	public String toString() {
		return "SendResult [resultCode=" + resultCode + ", resultMsg=" + resultMsg + ", orderId=" + orderId
				+ ", result=" + result + "]";
	}
	
	
}
