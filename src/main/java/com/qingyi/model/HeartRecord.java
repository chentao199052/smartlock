package com.qingyi.model;
/**
 * 网关详细记录
 * @author Administrator
 *
 */
public class HeartRecord {
	private String roomcode;
	private String cardcode;
	private String packageNo;
	private String time;
	private String cardcode2;
	private String type;
	public HeartRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HeartRecord(String roomcode, String cardcode, String packageNo, String time, String cardcode2, String type) {
		super();
		this.roomcode = roomcode;
		this.cardcode = cardcode;
		this.packageNo = packageNo;
		this.time = time;
		this.cardcode2 = cardcode2;
		this.type = type;
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
	public String getCardcode2() {
		return cardcode2;
	}
	public void setCardcode2(String cardcode2) {
		this.cardcode2 = cardcode2;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
