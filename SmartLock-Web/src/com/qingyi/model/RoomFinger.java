package com.qingyi.model;
/**
 * 指纹授权实体
 * @author 陈涛
 *
 */
public class RoomFinger {

	private String fingercode;
	
	private String fingercontent;
	
	private String edate;
	
	private String openstime;
	
	private String openetime;
	
	private String opencount;
	
	private String actioncount;

	public RoomFinger() {
		super();
	}
	/**
	 * 指纹授权构造方法
	 * @param fingercode 指纹编号 （为8位16字节字符串）
	 * @param fingercontent 指纹特征码（为988位16字节字符串）
	 * @param edate 指纹有效结束日期（-1为不限日期，格式yyMMddHHmm）
	 * @param openstime 可开门时间段开始时间（格式XX:XX）
	 * @param openetime 可开门时间段结束时间（格式XX:XX）
	 * @param opencount 可开门次数（-1为不限次数）
	 * @param actioncount 开门需按指纹次数
	 */
	public RoomFinger(String fingercode, String fingercontent, String edate, String openstime, String openetime,
			String opencount, String actioncount) {
		super();
		this.fingercode = fingercode;
		this.fingercontent = fingercontent;
		this.edate = edate;
		this.openstime = openstime;
		this.openetime = openetime;
		this.opencount = opencount;
		this.actioncount = actioncount;
	}

	public String getFingercontent() {
		return fingercontent;
	}
	public void setFingercontent(String fingercontent) {
		this.fingercontent = fingercontent;
	}
	public String getFingercode() {
		return fingercode;
	}

	public void setFingercode(String fingercode) {
		this.fingercode = fingercode;
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

	public String getActioncount() {
		return actioncount;
	}

	public void setActioncount(String actioncount) {
		this.actioncount = actioncount;
	}
}
