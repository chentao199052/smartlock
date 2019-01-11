package com.qingyi.model;



public class RoomCardxzsx {
	private String cardtype;
	private String cardcode;
	private String personcode;
	private String personname;
	private String rcusecount;
	private String cardunlocktype;
	private String cardpass;
	private String empedate;	//yyMMddHHmm	-1空
	private String cardedate; //yyMMddHHmm  -1无
	private String openstime;
	private String openetime;
	private String rcid;
	public RoomCardxzsx() {
		super();
	}
	public RoomCardxzsx(String cardtype, String cardcode, String personcode, String personname, String rcusecount,
			String cardunlocktype, String cardpass, String empedate, String cardedate, String openstime,
			String openetime, String rcid) {
		super();
		this.cardtype = cardtype;
		this.cardcode = cardcode;
		this.personcode = personcode;
		this.personname = personname;
		this.rcusecount = rcusecount;
		this.cardunlocktype = cardunlocktype;
		this.cardpass = cardpass;
		this.empedate = empedate;
		this.cardedate = cardedate;
		this.openstime = openstime;
		this.openetime = openetime;
		this.rcid = rcid;
	}
	public String getCardtype() {
		return cardtype;
	}
	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	public String getCardcode() {
		return cardcode;
	}
	public void setCardcode(String cardcode) {
		this.cardcode = cardcode;
	}
	public String getPersoncode() {
		return personcode;
	}
	public void setPersoncode(String personcode) {
		this.personcode = personcode;
	}
	public String getPersonname() {
		return personname;
	}
	public void setPersonname(String personname) {
		this.personname = personname;
	}
	public String getRcusecount() {
		return rcusecount;
	}
	public void setRcusecount(String rcusecount) {
		this.rcusecount = rcusecount;
	}
	public String getCardunlocktype() {
		return cardunlocktype;
	}
	public void setCardunlocktype(String cardunlocktype) {
		this.cardunlocktype = cardunlocktype;
	}
	public String getCardpass() {
		return cardpass;
	}
	public void setCardpass(String cardpass) {
		this.cardpass = cardpass;
	}
	public String getEmpedate() {
		return empedate;
	}
	public void setEmpedate(String empedate) {
		this.empedate = empedate;
	}
	public String getCardedate() {
		return cardedate;
	}
	public void setCardedate(String cardedate) {
		this.cardedate = cardedate;
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
	public String getRcid() {
		return rcid;
	}
	public void setRcid(String rcid) {
		this.rcid = rcid;
	}
	
	
}
