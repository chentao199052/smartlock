package com.qingyi.model;

public class ReceiveResult {
	
	private String resultCode;
	
	private String resultMsg;
	
	private Integer resultstatus;
	
	private Object result;

	public ReceiveResult() {
		super();
	}

	public ReceiveResult(String resultCode, String resultMsg, Integer resultstatus, Object result) {
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

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	

}
