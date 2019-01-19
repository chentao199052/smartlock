package com.qingyi.model;

public class UpdateGatewayRoomsResult {
	private String orderid;
	private Integer resultstatus;
	private String  information;
	private Integer recordnum;
	private Integer locknum;
	private String locks;
	private String version;
	private String wid;
	private String powerlev;
	private Integer filetype;
	private Integer no;
	private String space;
	private String order;
	private String result;
	private String begin;
	private String oscontent; // 下发指令
	private String osdate; // 下发时间
	private String osresult;//结果
	private Integer oscount;//次数
	private String osstatus;//指令状态
	private String osspace;//
	public UpdateGatewayRoomsResult() {
		super();
	}
	public UpdateGatewayRoomsResult(String orderid, Integer resultstatus, String information, Integer recordnum,
			Integer locknum, String locks, String version, String wid, String powerlev, Integer filetype, Integer no,
			String space, String order, String result, String begin, String oscontent, String osdate, String osresult,
			Integer oscount, String osstatus, String osspace) {
		super();
		this.orderid = orderid;
		this.resultstatus = resultstatus;
		this.information = information;
		this.recordnum = recordnum;
		this.locknum = locknum;
		this.locks = locks;
		this.version = version;
		this.wid = wid;
		this.powerlev = powerlev;
		this.filetype = filetype;
		this.no = no;
		this.space = space;
		this.order = order;
		this.result = result;
		this.begin = begin;
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
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public Integer getRecordnum() {
		return recordnum;
	}
	public void setRecordnum(Integer recordnum) {
		this.recordnum = recordnum;
	}
	public Integer getLocknum() {
		return locknum;
	}
	public void setLocknum(Integer locknum) {
		this.locknum = locknum;
	}
	public String getLocks() {
		return locks;
	}
	public void setLocks(String locks) {
		this.locks = locks;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getWid() {
		return wid;
	}
	public void setWid(String wid) {
		this.wid = wid;
	}
	public String getPowerlev() {
		return powerlev;
	}
	public void setPowerlev(String powerlev) {
		this.powerlev = powerlev;
	}
	public Integer getFiletype() {
		return filetype;
	}
	public void setFiletype(Integer filetype) {
		this.filetype = filetype;
	}
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public String getSpace() {
		return space;
	}
	public void setSpace(String space) {
		this.space = space;
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
	public String getBegin() {
		return begin;
	}
	public void setBegin(String begin) {
		this.begin = begin;
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
