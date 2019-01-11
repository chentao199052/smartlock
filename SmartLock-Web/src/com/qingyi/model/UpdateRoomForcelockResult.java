package com.qingyi.model;

public class UpdateRoomForcelockResult {
	private String orderid;
	private Integer filetype;
	private Integer resultstatus;
	private Integer no;
	private String order;
	private String result;
	private String space;
	private String type;
	private String oscontent; // 下发指令
	private String osdate; // 下发时间
	private String osresult;//结果
	private Integer oscount;//次数
	private String osstatus;//指令状态
	private String osspace;//
	public UpdateRoomForcelockResult() {
		super();
	}
	public UpdateRoomForcelockResult(String orderid, Integer filetype, Integer resultstatus, Integer no, String order,
			String result, String space, String type, String oscontent, String osdate, String osresult, Integer oscount,
			String osstatus, String osspace) {
		super();
		this.orderid = orderid;
		this.filetype = filetype;
		this.resultstatus = resultstatus;
		this.no = no;
		this.order = order;
		this.result = result;
		this.space = space;
		this.type = type;
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
	public Integer getFiletype() {
		return filetype;
	}
	public void setFiletype(Integer filetype) {
		this.filetype = filetype;
	}
	public Integer getResultstatus() {
		return resultstatus;
	}
	public void setResultstatus(Integer resultstatus) {
		this.resultstatus = resultstatus;
	}
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getSpace() {
		return space;
	}
	public void setSpace(String space) {
		this.space = space;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
