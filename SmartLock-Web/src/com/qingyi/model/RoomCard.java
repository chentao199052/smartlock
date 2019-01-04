package com.qingyi.model;
/**
 * 卡片授权实体类
 * @author 陈涛
 *
 */
public class RoomCard {
	
	private String rcid;
	
	private String cardtype;//中文标识
	
	private String cardcode;
	
	private String edate;
	
	private String empedate;//授权卡授权截止日期
	
	private String openstime;
	
	private String openetime;
	
	private String opencount;

	public RoomCard() {
		super();
	}
	/**
	 * 卡片授权构造方法
	 * @param cardtype 卡片类型（开门卡/管理卡/授权卡/身份证）
	 * @param cardcode 卡号（开门卡/管理卡/授权卡为8位16进制字符串，身份证为16位16进制字符串）
	 * @param edate 卡片有效结束日期（-1为不限日期，格式yyMMddHHmm）
	 * @param openstime 可开门时间段开始时间（格式XX:XX）
	 * @param openetime 可开门时间段结束时间（格式XX:XX）
	 * @param opencount 可开门次数（-1为不限次数）
	 */
	public RoomCard(String cardtype, String cardcode, String edate, String openstime, String openetime, String opencount) {
		super();
		this.cardtype = cardtype;
		this.cardcode = cardcode;
		this.edate = edate;
		this.openstime = openstime;
		this.openetime = openetime;
		this.opencount = opencount;
	}
	public RoomCard(String rcid, String cardtype, String cardcode, String edate, String empedate, String openstime,
			String openetime, String opencount) {
		super();
		this.rcid = rcid;
		this.cardtype = cardtype;
		this.cardcode = cardcode;
		this.edate = edate;
		this.empedate = empedate;
		this.openstime = openstime;
		this.openetime = openetime;
		this.opencount = opencount;
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
	public String getCardcode() {
		return cardcode;
	}
	public void setCardcode(String cardcode) {
		this.cardcode = cardcode;
	}
	public String getEdate() {
		return edate;
	}
	public void setEdate(String edate) {
		this.edate = edate;
	}
	public String getEmpedate() {
		return empedate;
	}
	public void setEmpedate(String empedate) {
		this.empedate = empedate;
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
	public String getOpencount() {
		return opencount;
	}
	public void setOpencount(String opencount) {
		this.opencount = opencount;
	}

}
