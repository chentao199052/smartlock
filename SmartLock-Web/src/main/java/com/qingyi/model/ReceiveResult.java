package com.qingyi.model;

public class ReceiveResult<T> {
	
	private String resultCode;
	
	private String resultMsg;
	
	private Integer resultstatus;
	
	private T result;
	

	public ReceiveResult() {
		super();
	}


	public ReceiveResult(String resultCode, String resultMsg, Integer resultstatus, T result) {
		super();
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
		this.resultstatus = resultstatus;
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


	public Integer getResultstatus() {
		return resultstatus;
	}


	public void setResultstatus(Integer resultstatus) {
		this.resultstatus = resultstatus;
	}


	public T getResult() {
		return result;
	}


	public void setResult(T result) {
		this.result = result;
	}


	
	
}
