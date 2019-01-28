package com.qingyi.model;
/**
 * 初始化房间编号
 * @author Administrator
 *
 */
public class LockInitializeResult {
	private String orderid;
	
	private Integer resultstatus;
	
	private Integer filetype;
	
	private String newcode;
	
	private Integer locklca;
	
	private Integer lockstatus;
	
	private Integer lockstatus2;
	
	private String channelid;
	
	private String channel;
	
	private String powerlev;
	
	private Integer networkmode;
	
	private Integer workmode;
	
	private Integer locktype;
	
	private Integer figernum;
	
	private Integer recordnum;
	
	private String lockver;
	
	private Integer lockcharge;
	
	private String order;
	
	private String no;
	
	private String space;
	
	private String result;
	
	private String od;
	private String osdate; // 下发时间
	public LockInitializeResult() {
		super();
	}
	public LockInitializeResult(String orderid, Integer resultstatus, Integer filetype, String newcode, Integer locklca,
			Integer lockstatus, Integer lockstatus2, String channelid, String channel, String powerlev,
			Integer networkmode, Integer workmode, Integer locktype, Integer figernum, Integer recordnum,
			String lockver, Integer lockcharge, String order, String no, String space, String result, String od,
			String osdate) {
		super();
		this.orderid = orderid;
		this.resultstatus = resultstatus;
		this.filetype = filetype;
		this.newcode = newcode;
		this.locklca = locklca;
		this.lockstatus = lockstatus;
		this.lockstatus2 = lockstatus2;
		this.channelid = channelid;
		this.channel = channel;
		this.powerlev = powerlev;
		this.networkmode = networkmode;
		this.workmode = workmode;
		this.locktype = locktype;
		this.figernum = figernum;
		this.recordnum = recordnum;
		this.lockver = lockver;
		this.lockcharge = lockcharge;
		this.order = order;
		this.no = no;
		this.space = space;
		this.result = result;
		this.od = od;
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
	public String getNewcode() {
		return newcode;
	}
	public void setNewcode(String newcode) {
		this.newcode = newcode;
	}
	public Integer getLocklca() {
		return locklca;
	}
	public void setLocklca(Integer locklca) {
		this.locklca = locklca;
	}
	public Integer getLockstatus() {
		return lockstatus;
	}
	public void setLockstatus(Integer lockstatus) {
		this.lockstatus = lockstatus;
	}
	public Integer getLockstatus2() {
		return lockstatus2;
	}
	public void setLockstatus2(Integer lockstatus2) {
		this.lockstatus2 = lockstatus2;
	}
	public String getChannelid() {
		return channelid;
	}
	public void setChannelid(String channelid) {
		this.channelid = channelid;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getPowerlev() {
		return powerlev;
	}
	public void setPowerlev(String powerlev) {
		this.powerlev = powerlev;
	}
	public Integer getNetworkmode() {
		return networkmode;
	}
	public void setNetworkmode(Integer networkmode) {
		this.networkmode = networkmode;
	}
	public Integer getWorkmode() {
		return workmode;
	}
	public void setWorkmode(Integer workmode) {
		this.workmode = workmode;
	}
	public Integer getLocktype() {
		return locktype;
	}
	public void setLocktype(Integer locktype) {
		this.locktype = locktype;
	}
	public Integer getFigernum() {
		return figernum;
	}
	public void setFigernum(Integer figernum) {
		this.figernum = figernum;
	}
	public Integer getRecordnum() {
		return recordnum;
	}
	public void setRecordnum(Integer recordnum) {
		this.recordnum = recordnum;
	}
	public String getLockver() {
		return lockver;
	}
	public void setLockver(String lockver) {
		this.lockver = lockver;
	}
	public Integer getLockcharge() {
		return lockcharge;
	}
	public void setLockcharge(Integer lockcharge) {
		this.lockcharge = lockcharge;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getSpace() {
		return space;
	}
	public void setSpace(String space) {
		this.space = space;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getOd() {
		return od;
	}
	public void setOd(String od) {
		this.od = od;
	}
	public String getOsdate() {
		return osdate;
	}
	public void setOsdate(String osdate) {
		this.osdate = osdate;
	}
	
	
}
