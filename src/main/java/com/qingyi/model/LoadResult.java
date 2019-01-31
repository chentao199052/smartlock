package com.qingyi.model;

public class LoadResult {
	private String locktype;
	private String result;
	private String gatewaycode;
	private String gatewaycode2;
	private String roomcode;
	private Integer locklca;
	private String channelid;
	private Integer antilock;
	private Integer open;
	private Integer channel;
	private String powerlev;
	private Integer recordnum;
	private String lockver;
	private Integer roomcharge;
	public LoadResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param locktype 门锁类型
	 * @param result   通路测试的结果
	 * @param gatewaycode 网关通讯ID
	 * @param gatewaycode2 网关唯一ID
	 * @param roomcode 房间编号
	 * @param locklca 门锁生命周期
	 * @param channelid 信道id
	 * @param antilock 反锁状态 1 反锁，0未反锁
	 * @param open 开关门状态 1开门，0关门
	 * @param channel 信道号  
	 * @param powerlev 功率等级
	 * @param recordnum 记录条数
	 * @param lockver 门锁软件版本号
	 * @param roomcharge 电量
	 */
	public LoadResult(String locktype, String result, String gatewaycode, String gatewaycode2, String roomcode,
			Integer locklca, String channelid, Integer antilock, Integer open, Integer channel, String powerlev,
			Integer recordnum, String lockver, Integer roomcharge) {
		super();
		this.locktype = locktype;
		this.result = result;
		this.gatewaycode = gatewaycode;
		this.gatewaycode2 = gatewaycode2;
		this.roomcode = roomcode;
		this.locklca = locklca;
		this.channelid = channelid;
		this.antilock = antilock;
		this.open = open;
		this.channel = channel;
		this.powerlev = powerlev;
		this.recordnum = recordnum;
		this.lockver = lockver;
		this.roomcharge = roomcharge;
	}
	public String getLocktype() {
		return locktype;
	}
	public void setLocktype(String locktype) {
		this.locktype = locktype;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getGatewaycode() {
		return gatewaycode;
	}
	public void setGatewaycode(String gatewaycode) {
		this.gatewaycode = gatewaycode;
	}
	public String getGatewaycode2() {
		return gatewaycode2;
	}
	public void setGatewaycode2(String gatewaycode2) {
		this.gatewaycode2 = gatewaycode2;
	}
	public String getRoomcode() {
		return roomcode;
	}
	public void setRoomcode(String roomcode) {
		this.roomcode = roomcode;
	}
	public Integer getLocklca() {
		return locklca;
	}
	public void setLocklca(Integer locklca) {
		this.locklca = locklca;
	}
	public String getChannelid() {
		return channelid;
	}
	public void setChannelid(String channelid) {
		this.channelid = channelid;
	}
	public Integer getAntilock() {
		return antilock;
	}
	public void setAntilock(Integer antilock) {
		this.antilock = antilock;
	}
	public Integer getOpen() {
		return open;
	}
	public void setOpen(Integer open) {
		this.open = open;
	}
	public Integer getChannel() {
		return channel;
	}
	public void setChannel(Integer channel) {
		this.channel = channel;
	}
	public String getPowerlev() {
		return powerlev;
	}
	public void setPowerlev(String powerlev) {
		this.powerlev = powerlev;
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
	public Integer getRoomcharge() {
		return roomcharge;
	}
	public void setRoomcharge(Integer roomcharge) {
		this.roomcharge = roomcharge;
	}
	
	
}
