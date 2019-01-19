package com.qingyi.model;

import java.sql.Timestamp;

public class DelPswsResult {
	
	private String orderId;
	
	private String password;
	
	private String roomcode2;

	public DelPswsResult(String orderId, String password, String roomcode2) {
		super();
		this.orderId = orderId;
		this.password = password;
		this.roomcode2 = roomcode2;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoomcode2() {
		return roomcode2;
	}

	public void setRoomcode2(String roomcode2) {
		this.roomcode2 = roomcode2;
	}
	
}
