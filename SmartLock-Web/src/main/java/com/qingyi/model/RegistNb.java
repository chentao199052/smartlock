package com.qingyi.model;

public class RegistNb {
	private String deviceId;
	private String verifyCode;
	private String psk;
	public RegistNb() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RegistNb(String deviceId, String verifyCode, String psk) {
		super();
		this.deviceId = deviceId;
		this.verifyCode = verifyCode;
		this.psk = psk;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getVerifyCode() {
		return verifyCode;
	}
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	public String getPsk() {
		return psk;
	}
	public void setPsk(String psk) {
		this.psk = psk;
	}
	
}
