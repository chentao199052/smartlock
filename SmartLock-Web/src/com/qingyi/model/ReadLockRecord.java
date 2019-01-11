package com.qingyi.model;

public class ReadLockRecord {
	private String cardcode;
	private String packageNo;
	private String time;
	private String type;
	private String cardcode2;
	private String password;
	private Integer number;
	public ReadLockRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReadLockRecord(String cardcode, String packageNo, String time, String type, String cardcode2,
			String password, Integer number) {
		super();
		this.cardcode = cardcode;
		this.packageNo = packageNo;
		this.time = time;
		this.type = type;
		this.cardcode2 = cardcode2;
		this.password = password;
		this.number = number;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCardcode2() {
		return cardcode2;
	}
	public void setCardcode2(String cardcode2) {
		this.cardcode2 = cardcode2;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	
}
