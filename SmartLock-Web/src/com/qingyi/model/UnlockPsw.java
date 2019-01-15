package com.qingyi.model;
/**
 * 密码授权实体类
 * @author 陈涛
 *
 */
public class UnlockPsw {
	
	private String pass;
	
	private String count;
	
	private String edate;
	
	private String unlockstime;
	
	private String unlocketime;

	public UnlockPsw() {
		super();
	}
	/**
	 * 
	 * @param pass 开门密码（必须位6位数字）
	 * @param count 可开门次数（-1为不限次数）
	 * @param edate 有效结束日期（-1为不限日期，日期格式yyMMddHHmm）
	 * @param unlockstime 可开门时间段开始时间（格式为XX:XX）
	 * @param unlocketime 可开门时间段结束时间（格式为XX:XX）
	 */
	public UnlockPsw(String pass, String count, String edate, String unlockstime, String unlocketime) {
		super();
		this.pass = pass;
		this.count = count;
		this.edate = edate;
		this.unlockstime = unlockstime;
		this.unlocketime = unlocketime;
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
