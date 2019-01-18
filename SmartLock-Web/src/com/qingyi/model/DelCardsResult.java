package com.qingyi.model;

import java.sql.Timestamp;

public class DelCardsResult {
	
private String orderId;
	
	private String cardcode;
	
	private String roomcode2;

	public DelCardsResult(String orderId, String cardcode, String roomcode2) {
		super();
		this.orderId = orderId;
		this.cardcode = cardcode;
		this.roomcode2 = roomcode2;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCardcode() {
		return cardcode;
	}

	public void setCardcode(String cardcode) {
		this.cardcode = cardcode;
	}

	public String getRoomcode2() {
		return roomcode2;
	}

	public void setRoomcode2(String roomcode2) {
		this.roomcode2 = roomcode2;
	}
	
}
