package com.qingyi.model;

import java.sql.Timestamp;

public class Card {
	private String cardcode;//
	private Integer cardstate;//
	private String cardedate;// yyyy-MM-dd HH:mm:ss
	private Integer cardtype;//
	private Integer cardunlocktype;//
	private Integer cardcount;//
	private String personcode;//
	private String personname;//
	private String cardcdate;// yyyy-MM-dd HH:mm:ss
	private String  cardunlocktime;//"0000~2359"
	private String cardpass;//
	private Integer day;//
	private Integer cardusecount;//
	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Card(String cardcode, Integer cardstate, String cardedate, Integer cardtype, Integer cardunlocktype,
			Integer cardcount, String personcode, String personname, String cardcdate, String cardunlocktime,
			String cardpass, Integer day, Integer cardusecount) {
		super();
		this.cardcode = cardcode;
		this.cardstate = cardstate;
		this.cardedate = cardedate;
		this.cardtype = cardtype;
		this.cardunlocktype = cardunlocktype;
		this.cardcount = cardcount;
		this.personcode = personcode;
		this.personname = personname;
		this.cardcdate = cardcdate;
		this.cardunlocktime = cardunlocktime;
		this.cardpass = cardpass;
		this.day = day;
		this.cardusecount = cardusecount;
	}
	public String getCardcode() {
		return cardcode;
	}
	public void setCardcode(String cardcode) {
		this.cardcode = cardcode;
	}
	public Integer getCardstate() {
		return cardstate;
	}
	public void setCardstate(Integer cardstate) {
		this.cardstate = cardstate;
	}
	public String getCardedate() {
		return cardedate;
	}
	public void setCardedate(String cardedate) {
		this.cardedate = cardedate;
	}
	public Integer getCardtype() {
		return cardtype;
	}
	public void setCardtype(Integer cardtype) {
		this.cardtype = cardtype;
	}
	public Integer getCardunlocktype() {
		return cardunlocktype;
	}
	public void setCardunlocktype(Integer cardunlocktype) {
		this.cardunlocktype = cardunlocktype;
	}
	public Integer getCardcount() {
		return cardcount;
	}
	public void setCardcount(Integer cardcount) {
		this.cardcount = cardcount;
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
	public String getCardcdate() {
		return cardcdate;
	}
	public void setCardcdate(String cardcdate) {
		this.cardcdate = cardcdate;
	}
	public String getCardunlocktime() {
		return cardunlocktime;
	}
	public void setCardunlocktime(String cardunlocktime) {
		this.cardunlocktime = cardunlocktime;
	}
	public String getCardpass() {
		return cardpass;
	}
	public void setCardpass(String cardpass) {
		this.cardpass = cardpass;
	}
	public Integer getDay() {
		return day;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	public Integer getCardusecount() {
		return cardusecount;
	}
	public void setCardusecount(Integer cardusecount) {
		this.cardusecount = cardusecount;
	}
	
	
	
}
