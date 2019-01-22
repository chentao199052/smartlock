package com.qingyi.model;

import java.util.List;

public class AuthSync {
	
	private Integer locktype;
	
	private String roomcode2;
	
	private String roomcode;
	
	private String imei;
	
	private String gatewaycode2;
	
	private String gatewaycode;
	
	private Integer timeout;
	
	private String callbackurl;
	
	private List<RoomCard> roomcardlist;
	
	private List<UnlockPsw> pswlist;
	
	private List<RoomFinger> roomfingerlist;

	/**
	 * 授权同步构造方法
	 * @param locktype 门锁类型（必填），1为无线联网锁，2为华为NB锁，3为电信NB锁，4为移动NB锁
	 * @param roomcode2 门锁唯一ID（必填）
	 * @param roomcode 房间编号（无线联网锁必填）
	 * @param imei NB锁imei（NB锁必填）
	 * @param gatewaycode2 网关唯一ID（无线联网锁必填）
	 * @param gatewaycode 网关通信ID（无线联网锁必填）
	 * @param timeout 超时秒数（网关或门锁离线超时秒数后，指令超时，必填）
	 * @param callbackurl 回调地址（指令结果回调地址，必填）
	 * @param roomcardlist 需同步的卡片授权列表
	 * @param pswlist 需同步的密码授权列表
	 * @param roomfingerlist 需同步的指纹授权列表
	 */
	public AuthSync(Integer locktype, String roomcode2, String roomcode,String imei, String gatewaycode2, String gatewaycode,
			Integer timeout,String callbackurl,List<RoomCard> roomcardlist, List<UnlockPsw> pswlist, List<RoomFinger> roomfingerlist) {
		super();
		this.locktype = locktype;
		this.roomcode2 = roomcode2;
		this.roomcode = roomcode;
		this.imei = imei;
		this.gatewaycode2 = gatewaycode2;
		this.gatewaycode = gatewaycode;
		this.timeout = timeout;
		this.callbackurl = callbackurl;
		this.roomcardlist = roomcardlist;
		this.pswlist = pswlist;
		this.roomfingerlist = roomfingerlist;
	}

	public AuthSync() {
		super();
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

	public List<RoomCard> getRoomcardlist() {
		return roomcardlist;
	}

	public void setRoomcardlist(List<RoomCard> roomcardlist) {
		this.roomcardlist = roomcardlist;
	}

	public List<UnlockPsw> getPswlist() {
		return pswlist;
	}

	public void setPswlist(List<UnlockPsw> pswlist) {
		this.pswlist = pswlist;
	}

	public List<RoomFinger> getRoomfingerlist() {
		return roomfingerlist;
	}

	public void setRoomfingerlist(List<RoomFinger> roomfingerlist) {
		this.roomfingerlist = roomfingerlist;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
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

	@Override
	public String toString() {
		return "AuthSync [locktype=" + locktype + ", roomcode2=" + roomcode2 + ", roomcode=" + roomcode + ", imei="
				+ imei + ", gatewaycode2=" + gatewaycode2 + ", gatewaycode=" + gatewaycode + ", timeout=" + timeout
				+ ", callbackurl=" + callbackurl + ", roomcardlist=" + roomcardlist + ", pswlist=" + pswlist
				+ ", roomfingerlist=" + roomfingerlist + "]";
	}
	
	
}
