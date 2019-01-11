package com.qingyi.model;

public class SaveRoomFingerResult {
	private String orderid;
	private Integer resultstatus;
	private Integer filetype;
	private String type;
	private String num;
	private String fingercodes;
	private String oscontent; // 下发指令
	private String osdate; // 下发时间
	private String osresult;//结果
	private Integer oscount;//次数
	private String osstatus;//指令状态
	private String osspace;//

	public SaveRoomFingerResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SaveRoomFingerResult(String orderid, Integer resultstatus, Integer filetype, String type, String num,
			String fingercodes, String oscontent, String osdate, String osresult, Integer oscount, String osstatus,
			String osspace) {
		super();
		this.orderid = orderid;
		this.resultstatus = resultstatus;
		this.filetype = filetype;
		this.type = type;
		this.num = num;
		this.fingercodes = fingercodes;
		this.oscontent = oscontent;
		this.osdate = osdate;
		this.osresult = osresult;
		this.oscount = oscount;
		this.osstatus = osstatus;
		this.osspace = osspace;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public Integer getResultstatus() {
		return resultstatus;
	}

	public void setResultstatus(Integer resultstatus) {
		this.resultstatus = resultstatus;
	}

	public Integer getFiletype() {
		return filetype;
	}

	public void setFiletype(Integer filetype) {
		this.filetype = filetype;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getFingercodes() {
		return fingercodes;
	}

	public void setFingercodes(String fingercodes) {
		this.fingercodes = fingercodes;
	}

	public String getOscontent() {
		return oscontent;
	}

	public void setOscontent(String oscontent) {
		this.oscontent = oscontent;
	}

	public String getOsdate() {
		return osdate;
	}

	public void setOsdate(String osdate) {
		this.osdate = osdate;
	}

	public String getOsresult() {
		return osresult;
	}

	public void setOsresult(String osresult) {
		this.osresult = osresult;
	}

	public Integer getOscount() {
		return oscount;
	}

	public void setOscount(Integer oscount) {
		this.oscount = oscount;
	}

	public String getOsstatus() {
		return osstatus;
	}

	public void setOsstatus(String osstatus) {
		this.osstatus = osstatus;
	}

	public String getOsspace() {
		return osspace;
	}

	public void setOsspace(String osspace) {
		this.osspace = osspace;
	}
	
	
}
