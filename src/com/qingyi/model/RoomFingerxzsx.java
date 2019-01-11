package com.qingyi.model;

public class RoomFingerxzsx {
	private String rfid;
	private String fingercode;
	private String fingercontent;
	private String empedate;
	private String fingerseq;
	private String openstime;
	private String openetime;
	private String count;
	public RoomFingerxzsx() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RoomFingerxzsx(String rfid, String fingercode, String fingercontent, String empedate, String fingerseq,
			String openstime, String openetime, String count) {
		super();
		this.rfid = rfid;
		this.fingercode = fingercode;
		this.fingercontent = fingercontent;
		this.empedate = empedate;
		this.fingerseq = fingerseq;
		this.openstime = openstime;
		this.openetime = openetime;
		this.count = count;
	}
	public String getRfid() {
		return rfid;
	}
	public void setRfid(String rfid) {
		this.rfid = rfid;
	}
	public String getFingercode() {
		return fingercode;
	}
	public void setFingercode(String fingercode) {
		this.fingercode = fingercode;
	}
	public String getFingercontent() {
		return fingercontent;
	}
	public void setFingercontent(String fingercontent) {
		this.fingercontent = fingercontent;
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
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	
	
}
