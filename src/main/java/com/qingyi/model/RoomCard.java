package com.qingyi.model;
/**
 * 卡片授权实体类
 * @author 陈涛
 *
 */
public class RoomCard {
	
	@Override
	public String toString() {
		return "{'cardtype':'" + cardtype + "', 'cardcode':'" + cardcode + "', 'personcode':'"
				+ personcode + "', 'personname':'" + personname + "', 'edate':'" + edate
				+ "', 'openstime':'" + openstime + "', 'openetime':'" + openetime + "', 'opencount':'" + opencount + "'}";
	}
	private String cardtype;//中文标识
	
	private String cardcode;
	
	private String personcode;
	
	private String personname;
	
	private String edate;
	
	private String openstime;
	
	private String openetime;
	
	private String opencount;//可开门次数

	public RoomCard() {
		super();
	}
	/**
	 * 卡片授权构造方法
	 * @param cardtype 卡片类型（开门卡/管理卡/授权卡/身份证）
	 * @param cardcode 卡号（开门卡/管理卡/授权卡为8位16进制字符串，身份证为16位16进制字符串）
	 * @param edate 卡片有效结束日期（-1为不限日期，格式yyMMddHHmm）
	 * @param personcode 人员编号
	 * @param personname 人员姓名
	 * @param openstime 可开门时间段开始时间（格式XX:XX）
	 * @param openetime 可开门时间段结束时间（格式XX:XX）
	 * @param opencount 可开门次数（-1为不限次数）
	 */
	public RoomCard(String cardtype, String cardcode, String personcode, String personname, String edate,
			String openstime, String openetime, String opencount) {
		super();
		this.cardtype = cardtype;
		this.cardcode = cardcode;
		this.personcode = personcode;
		this.personname = personname;
		this.edate = edate;
		this.openstime = openstime;
		this.openetime = openetime;
		this.opencount = opencount;
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
	
	public String getEdate() {
		return edate;
	}
	public void setEdate(String edate) {
		this.edate = edate;
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
