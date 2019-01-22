package com.qingyi.model;

import java.sql.Timestamp;

public class SyncFResult {
	
	private String orderId;
	
	private String roomcode2;
	
	
	public SyncFResult() {
		super();
	}

	/**
	 * 指纹授权同步结果构造方法
	 * @param orderId 指令id
	 * @param roomcode2 门锁唯一ID
	 */
	public SyncFResult(String orderId, String roomcode2) {
		super();
		this.orderId = orderId;
		this.roomcode2 = roomcode2;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getRoomcode2() {
		return roomcode2;
	}

	public void setRoomcode2(String roomcode2) {
		this.roomcode2 = roomcode2;
	}

	
	
}
