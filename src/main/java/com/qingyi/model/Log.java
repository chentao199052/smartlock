package com.qingyi.model;
/**
 * 日志
 * @author Administrator
 *
 */
public class Log {
	
	private Integer logtype;
	
	private String gatewaycode;
	
	private String gatewaycode2;
	
	private String roomcode2;
	
	private String callbackurl;

	public Log() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getLogtype() {
		return logtype;
	}
	/**
	 * 
	 * @param logtype 日志类型1（网关）/2（指纹机）/3（NB锁）
	 * @param gatewaycode 网关/指纹机编号（网关/指纹机必填）
	 * @param gatewaycode2 网关唯一ID（网关必填）
	 * @param roomcode2 NB锁唯一ID（NB锁必填）
	 * @param callbackurl 回调地址（必填）
	 */
	public Log(Integer logtype, String gatewaycode, String gatewaycode2, String roomcode2, String callbackurl) {
		super();
		this.logtype = logtype;
		this.gatewaycode = gatewaycode;
		this.gatewaycode2 = gatewaycode2;
		this.roomcode2 = roomcode2;
		this.callbackurl = callbackurl;
	}

	public void setLogtype(Integer logtype) {
		this.logtype = logtype;
	}

	public String getGatewaycode() {
		return gatewaycode;
	}

	public void setGatewaycode(String gatewaycode) {
		this.gatewaycode = gatewaycode;
	}

	public String getGatewaycode2() {
		return gatewaycode2;
	}

	public void setGatewaycode2(String gatewaycode2) {
		this.gatewaycode2 = gatewaycode2;
	}

	public String getRoomcode2() {
		return roomcode2;
	}

	public void setRoomcode2(String roomcode2) {
		this.roomcode2 = roomcode2;
	}

	public String getCallbackurl() {
		return callbackurl;
	}

	public void setCallbackurl(String callbackurl) {
		this.callbackurl = callbackurl;
	}

	
}
