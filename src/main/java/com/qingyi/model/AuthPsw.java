package com.qingyi.model;

import java.sql.Timestamp;

public class AuthPsw {
	
	private Integer locktype;
	
	private String roomcode2;
	
	private String roomcode;
	
	private String gatewaycode2;
	
	private String gatewaycode;
	
	private String password;
	
	private String openstime;
	
	private String openetime;
	
	private String edate;
	
	private String opencount;
	
	private String imei;
	
	public AuthPsw() {
		super();
	}

	/**
	 * 密码授权构造方法
	 * @param locktype 门锁类型（必填），1为无线联网锁，2为华为NB锁，3为电信NB锁，4为移动NB锁
	 * @param roomcode2 门锁唯一ID（必填）
	 * @param roomcode 房间编号（无线联网锁必填）
	 * @param imei NB锁imei（NB锁必填）
	 * @param gatewaycode2 网关唯一ID（无线联网锁必填）
	 * @param gatewaycode 网关通信ID（无线联网锁必填）
	 * @param password 6位数字密码（emptype=5,6时必填）
	 * @param openstime 可开门起始时间（必填，格式为HH:mm）
	 * @param openetime 可开门结束时间（必填，格式为HH:mm）
	 * @param edate 授权到期时间（必填，-1表示永久，格式为yyMMddHHmm）
	 * @param opencount 可开门次数（必填，0表示永久，非永久次数范围1-254）
	 */
	public AuthPsw(Integer locktype, String roomcode2, String roomcode,String imei, String gatewaycode2, String gatewaycode,
			String password, String openstime, String openetime, String edate, String opencount) {
		super();
		this.locktype = locktype;
		this.roomcode2 = roomcode2;
		this.roomcode = roomcode;
		this.imei = imei;
		this.gatewaycode2 = gatewaycode2;
		this.gatewaycode = gatewaycode;
		this.password = password;
		this.openstime = openstime;
		this.openetime = openetime;
		this.edate = edate;
		this.opencount = opencount;
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

	public String getOpenstime() {
		return openstime;
	}

	public void setOpenstime(String openstime) {
		this.openstime = openstime;
	}

	public String getOpenetime() {
		return openetime;
	}

	public void setOpenetime(String openetime) {
		this.openetime = openetime;
	}

	public String getEdate() {
		return edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
	}

	public String getOpencount() {
		return opencount;
	}

	public void setOpencount(String opencount) {
		this.opencount = opencount;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	
}
