package com.qingyi.model;
/**
 * 取消密码授权实体类
 * @author Administrator
 *
 */
public class DelUnlockPsw {
	private String rcid;
	
	private String pass;
	
	private String count;
	
	private String edate;
	

	public DelUnlockPsw() {
		super();
	}
	/**
	 * 
	 * @param rcid 密码开锁id
	 * @param pass 开门密码（必须位6位数字）
	 * @param count 可开门次数（-1为不限次数）
	 * @param edate 有效结束日期（-1为不限日期，日期格式yyMMddHHmm）
	 */
	public DelUnlockPsw(String rcid, String pass, String count, String edate) {
		super();
		this.rcid = rcid;
		this.pass = pass;
		this.count = count;
		this.edate = edate;
	}

	public String getRcid() {
		return rcid;
	}

	public void setRcid(String rcid) {
		this.rcid = rcid;
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

	
	
}
