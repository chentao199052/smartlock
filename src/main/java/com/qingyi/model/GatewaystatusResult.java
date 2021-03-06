package com.qingyi.model;
/**
 * 网关状态查询
 * @author Administrator
 *
 */
public class GatewaystatusResult {
	private String orderid;
	private Integer resultstatus;
	private Integer filetype;
	private Integer recordnum;
	private String version;
	private String beforever;
	private String powerlev;
	private String xindaoID ;
	private Integer xindao;
	private String  information;
	private Integer locknum;
	private String locks;
	private String wid;
	private Integer no;
	private String begin;
	private String result;
	private String space;
	private String osdate; // 下发时间
	public GatewaystatusResult() {
		super();
	}
	public GatewaystatusResult(String orderid, Integer resultstatus, Integer filetype, Integer recordnum,
			String version, String beforever, String powerlev, String xindaoID, Integer xindao, String information,
			Integer locknum, String locks, String wid, Integer no, String begin, String result, String space,
			String osdate) {
		super();
		this.orderid = orderid;
		this.resultstatus = resultstatus;
		this.filetype = filetype;
		this.recordnum = recordnum;
		this.version = version;
		this.beforever = beforever;
		this.powerlev = powerlev;
		this.xindaoID = xindaoID;
		this.xindao = xindao;
		this.information = information;
		this.locknum = locknum;
		this.locks = locks;
		this.wid = wid;
		this.no = no;
		this.begin = begin;
		this.result = result;
		this.space = space;
		this.osdate = osdate;
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
	public Integer getRecordnum() {
		return recordnum;
	}
	public void setRecordnum(Integer recordnum) {
		this.recordnum = recordnum;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getBeforever() {
		return beforever;
	}
	public void setBeforever(String beforever) {
		this.beforever = beforever;
	}
	public String getPowerlev() {
		return powerlev;
	}
	public void setPowerlev(String powerlev) {
		this.powerlev = powerlev;
	}
	public String getXindaoID() {
		return xindaoID;
	}
	public void setXindaoID(String xindaoID) {
		this.xindaoID = xindaoID;
	}
	public Integer getXindao() {
		return xindao;
	}
	public void setXindao(Integer xindao) {
		this.xindao = xindao;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
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
	public String getWid() {
		return wid;
	}
	public void setWid(String wid) {
		this.wid = wid;
	}
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public String getBegin() {
		return begin;
	}
	public void setBegin(String begin) {
		this.begin = begin;
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
	public String getOsdate() {
		return osdate;
	}
	public void setOsdate(String osdate) {
		this.osdate = osdate;
	}
	
	
	
}
