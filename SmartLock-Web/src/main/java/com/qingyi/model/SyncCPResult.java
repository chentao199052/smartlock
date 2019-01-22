package com.qingyi.model;

import java.sql.Timestamp;

public class SyncCPResult {
	
	@Override
	public String toString() {
		return "SyncCPResult [orderId=" + orderId + ", roomcode2=" + roomcode2 + "]";
	}


	private String orderId;
	
	private String roomcode2;
	
	
	public SyncCPResult() {
		super();
	}

	/**
	 * 卡密授权同步结果构造方法
	 * @param orderId
	 * @param roomcode2
	 */
	public SyncCPResult(String orderId, String roomcode2) {
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
