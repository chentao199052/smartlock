package com.qingyi.model;

public class DelRoomCardxzsx {
	private String rcid;
	private String cardtype;
	private String cardedate;//yyMMddHHmm
	private String cardcode;
	private String openstime;
	private String openetime;
	private String rcusecount;
	
	
	public DelRoomCardxzsx() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DelRoomCardxzsx(String rcid, String cardtype, String cardedate, String cardcode, String openstime,
			String openetime, String rcusecount) {
		super();
		this.rcid = rcid;
		this.cardtype = cardtype;
		this.cardedate = cardedate;
		this.cardcode = cardcode;
		this.openstime = openstime;
		this.openetime = openetime;
		this.rcusecount = rcusecount;
	}
	public String getRcid() {
		return rcid;
	}
	public void setRcid(String rcid) {
		this.rcid = rcid;
	}
	public String getCardtype() {
		return cardtype;
	}
	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	public String getCardedate() {
		return cardedate;
	}
	public void setCardedate(String cardedate) {
		this.cardedate = cardedate;
	}
	public String getCardcode() {
		return cardcode;
	}
	public void setCardcode(String cardcode) {
		this.cardcode = cardcode;
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
	public String getRcusecount() {
		return rcusecount;
	}
	public void setRcusecount(String rcusecount) {
		this.rcusecount = rcusecount;
	}
	
		
}
