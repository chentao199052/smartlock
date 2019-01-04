package com.qingyi.model;

public class GatewayRecord {
	private String roomcode;
	private String cardcode;
	private String cardcode2;
	private String packageNo;
	private String time; //格式： “yyyy-MM-dd HH:mm:ss”
	private String type;
	private String password;
	public GatewayRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GatewayRecord(String roomcode, String cardcode, String cardcode2, String packageNo, String time, String type,
			String password) {
		super();
		this.roomcode = roomcode;
		this.cardcode = cardcode;
		this.cardcode2 = cardcode2;
		this.packageNo = packageNo;
		this.time = time;
		this.type = type;
		this.password = password;
	}
	public String getRoomcode() {
		return roomcode;
	}
	public void setRoomcode(String roomcode) {
		this.roomcode = roomcode;
	}
	public String getCardcode() {
		return cardcode;
	}
	public void setCardcode(String cardcode) {
		this.cardcode = cardcode;
	}
	public String getCardcode2() {
		return cardcode2;
	}
	public void setCardcode2(String cardcode2) {
		this.cardcode2 = cardcode2;
	}
	public String getPackageNo() {
		return packageNo;
	}
	public void setPackageNo(String packageNo) {
		this.packageNo = packageNo;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
