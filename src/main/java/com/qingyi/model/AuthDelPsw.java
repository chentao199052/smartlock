package com.qingyi.model;

import java.sql.Timestamp;

public class AuthDelPsw {
	
	private Integer locktype;
	
	private String roomcode2;
	
	private String roomcode;
	
	private String gatewaycode2;
	
	private String gatewaycode;
	
	private String password;
	
	private Integer timeout;
	
	private String callbackurl;
	
	private String imei;
	
	public AuthDelPsw() {
		super();
	}

	/**
	 * 密码删除授权构造方法
	 * @param locktype 门锁类型（必填），1为无线联网锁，2为华为NB锁，3为电信NB锁，4为移动NB锁
	 * @param roomcode2 门锁唯一ID（必填）
	 * @param roomcode 房间编号（无线联网锁必填）
	 * @param gatewaycode2 网关唯一ID（无线联网锁必填）
	 * @param gatewaycode 网关通信ID（无线联网锁必填）
	 * @param password 6位数字密码（必填）
	 * @param timeout 超时秒数（网关或门锁离线超时秒数后，指令超时，必填）
	 * @param callbackurl 回调地址（指令结果回调地址，必填）
	 * @param imei NB锁imei（NB锁必填）
	*/
	public AuthDelPsw(Integer locktype, String roomcode2, String roomcode, String gatewaycode2, String gatewaycode,
			String password,Integer timeout,String callbackurl,String imei) {
		super();
		this.locktype = locktype;
		this.roomcode2 = roomcode2;
		this.roomcode = roomcode;
		this.gatewaycode2 = gatewaycode2;
		this.gatewaycode = gatewaycode;
		this.password = password;
		this.timeout = timeout;
		this.callbackurl = callbackurl;
		this.imei = imei;
	}

	public Integer getLocktype() {
		return locktype;
	}

	public void setLocktype(Integer locktype) {
		this.locktype = locktype;
	}

	public String getRoomcode2() {
		return roomcode2;
	}

	public void setRoomcode2(String roomcode2) {
		this.roomcode2 = roomcode2;
	}

	public String getRoomcode() {
		return roomcode;
	}

	public void setRoomcode(String roomcode) {
		this.roomcode = roomcode;
	}

	public String getGatewaycode2() {
		return gatewaycode2;
	}

	public void setGatewaycode2(String gatewaycode2) {
		this.gatewaycode2 = gatewaycode2;
	}

	public String getGatewaycode() {
		return gatewaycode;
	}

	public void setGatewaycode(String gatewaycode) {
		this.gatewaycode = gatewaycode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getTimeout() {
		return timeout;
	}

	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}

	public String getCallbackurl() {
		return callbackurl;
	}

	public void setCallbackurl(String callbackurl) {
		this.callbackurl = callbackurl;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	
}
