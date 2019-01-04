package com.qingyi.model;

public class NBUnlockPsw {

private String roomimei;
private String pass;
private String count;
private String edate;
private String roomtxtype;
private String unlockstime;
private String unlocketime;

public NBUnlockPsw() {
	super();
	// TODO Auto-generated constructor stub
}
/**
 * 
 * @param pass 开门密码（必须位6位数字）
 * @param count 可开门次数（-1为不限次数）
 * @param edate 有效结束日期（-1为不限日期，日期格式yyMMddHHmm）
 * @param unlockstime 可开门时间段开始时间（格式为XX:XX）
 * @param unlocketime 可开门时间段结束时间（格式为XX:XX）
 * @param roomtxtype 锁的种类2华为3电信4移动
 * 
 */
public NBUnlockPsw(String roomimei, String pass, String count, String edate, String roomtxtype, String unlockstime,
		String unlocketime) {
	super();
	this.roomimei = roomimei;
	this.pass = pass;
	this.count = count;
	this.edate = edate;
	this.roomtxtype = roomtxtype;
	this.unlockstime = unlockstime;
	this.unlocketime = unlocketime;
}

public String getRoomimei() {
	return roomimei;
}

public void setRoomimei(String roomimei) {
	this.roomimei = roomimei;
}

public String getPass() {
	return pass;
}

public void setPass(String pass) {
	this.pass = pass;
}

public String getCount() {
	return count;
}

public void setCount(String count) {
	this.count = count;
}

public String getEdate() {
	return edate;
}

public void setEdate(String edate) {
	this.edate = edate;
}

public String getRoomtxtype() {
	return roomtxtype;
}

public void setRoomtxtype(String roomtxtype) {
	this.roomtxtype = roomtxtype;
}

public String getUnlockstime() {
	return unlockstime;
}

public void setUnlockstime(String unlockstime) {
	this.unlockstime = unlockstime;
}

public String getUnlocketime() {
	return unlocketime;
}

public void setUnlocketime(String unlocketime) {
	this.unlocketime = unlocketime;
}

}
