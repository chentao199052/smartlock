package com.qingyi.model;
/**
 * 密码授权实体类
 * @author 陈涛
 *
 */
public class UnlockPsw {
	
	private String password;
	
	private String opencount;
	
	private String edate;
	
	private String openstime;
	
	private String openetime;

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
	
	public String getPassword() {
		return password;
	}

	public UnlockPsw(String password, String opencount, String edate, String openstime, String openetime) {
		super();
		this.password = password;
		this.opencount = opencount;
		this.edate = edate;
		this.openstime = openstime;
		this.openetime = openetime;
	}
	

	public void setPassword(String password) {
		this.password = password;
	}
	public String getOpencount() {
		return opencount;
	}

	public void setOpencount(String opencount) {
		this.opencount = opencount;
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
	@Override
	public String toString() {
		return "{'password':'" + password + "', 'opencount':'" + opencount + "', 'edate':'" + edate + "', 'openstime':'" + openstime
				+ "', 'openetime':'" + openetime + "'}";
	}

		
}
