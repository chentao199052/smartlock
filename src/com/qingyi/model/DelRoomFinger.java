package com.qingyi.model;

public class DelRoomFinger {
	private String fingercode;
	private String empedate;//yyMMddHHmm
	private String fingerseq;//指纹序列号
	private String openstime;//00:00
	private String openetime;//00:00
	private String rfusecount;//可开门次数
	public DelRoomFinger() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DelRoomFinger(String fingercode, String empedate, String fingerseq, String openstime, String openetime,
			String rfusecount) {
		super();
		this.fingercode = fingercode;
		this.empedate = empedate;
		this.fingerseq = fingerseq;
		this.openstime = openstime;
		this.openetime = openetime;
		this.rfusecount = rfusecount;
	}
	public String getFingercode() {
		return fingercode;
	}
	public void setFingercode(String fingercode) {
		this.fingercode = fingercode;
	}
	public String getEmpedate() {
		return empedate;
	}
	public void setEmpedate(String empedate) {
		this.empedate = empedate;
	}
	public String getFingerseq() {
		return fingerseq;
	}
	public void setFingerseq(String fingerseq) {
		this.fingerseq = fingerseq;
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
	public String getRfusecount() {
		return rfusecount;
	}
	public void setRfusecount(String rfusecount) {
		this.rfusecount = rfusecount;
	}
	
	
}
