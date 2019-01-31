package com.qingyi.model;
/**
 * NB锁房间信息
 * @author Administrator
 *
 */
public class RoomParamas {
	private String roomcode2;
	private Integer roomcharge;
	private String roomecl;
	private String roomsnr;
	private String roompci;
	private String devicetype;
	private String lockver;
	private String locklca;
	private String roomreset;
	private Integer isfinger;
	private Integer isbluetooth;
	private Integer isscanner ;
	private Integer islockswith;
	private Integer islatchswith;
	private Integer iskeyswith;
	private Integer iscontactswith;
	private Integer antilock;
	private Integer open;
	private Integer forcelock;
	private Integer networkmode;
	private Integer workmode;
	private Integer fingernum;
	private Integer passnum;
	private Integer opencardnum;
	private Integer managecardnum;
	private Integer specialcardnum;
	private String signalStrength;
	private String recordcount;
	
	public RoomParamas() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param roomcode2 房间唯一编号
	 * @param roomcharge 电量
	 * @param roomecl 信号覆盖等级
	 * @param roomsnr 信噪比
	 * @param roompci 小区pci
	 * @param devicetype 设备型号
	 * @param lockver 门锁软件版本号
	 * @param locklca 门锁生命周期
	 * @param roomreset 门锁总复位次数
	 * @param isfinger  是否带指纹 1是0否
	 * @param isbluetooth 是否带蓝牙 1是0否
	 * @param isscanner 是否带扫描枪 1是0否
	 * @param islockswith 是否带反锁检测开关 1是0否
	 * @param islatchswith 是否带斜舌检测开关 1是0否
	 * @param iskeyswith 是否带钥匙检测开关 1是0否
	 * @param iscontactswith 是否带门磁检测开关 1是0否
	 * @param antilock 反锁状态 1 反锁，0未反锁
	 * @param open 开关门状态 1开门，0关门
	 * @param forcelock 强锁状态 1强锁，0未强锁
	 * @param networkmode 联网模式，1允许离线授权，0不允许离线授权
	 * @param workmode 工作模式，1常开，0常闭
	 * @param fingernum 指纹数
	 * @param passnum 密码数
	 * @param signalStrength 信号强度
	 * @param opencardnum 开门卡数
	 * @param managecardnum 管理卡数
	 * @param specialcardnum 特殊卡数
	 * @param recordcount 记录条数
	 */
	public RoomParamas(String roomcode2, Integer roomcharge, String roomecl, String roomsnr, String roompci,
			String devicetype, String lockver, String locklca, String roomreset, Integer isfinger, Integer isbluetooth,
			Integer isscanner, Integer islockswith, Integer islatchswith, Integer iskeyswith, Integer iscontactswith,
			Integer antilock, Integer open, Integer forcelock, Integer networkmode, Integer workmode, Integer fingernum,
			Integer passnum, Integer opencardnum, Integer managecardnum, Integer specialcardnum, String signalStrength,
			String recordcount) {
		super();
		this.roomcode2 = roomcode2;
		this.roomcharge = roomcharge;
		this.roomecl = roomecl;
		this.roomsnr = roomsnr;
		this.roompci = roompci;
		this.devicetype = devicetype;
		this.lockver = lockver;
		this.locklca = locklca;
		this.roomreset = roomreset;
		this.isfinger = isfinger;
		this.isbluetooth = isbluetooth;
		this.isscanner = isscanner;
		this.islockswith = islockswith;
		this.islatchswith = islatchswith;
		this.iskeyswith = iskeyswith;
		this.iscontactswith = iscontactswith;
		this.antilock = antilock;
		this.open = open;
		this.forcelock = forcelock;
		this.networkmode = networkmode;
		this.workmode = workmode;
		this.fingernum = fingernum;
		this.passnum = passnum;
		this.opencardnum = opencardnum;
		this.managecardnum = managecardnum;
		this.specialcardnum = specialcardnum;
		this.signalStrength = signalStrength;
		this.recordcount = recordcount;
	}
	
	public String getRoomcode2() {
		return roomcode2;
	}
	public void setRoomcode2(String roomcode2) {
		this.roomcode2 = roomcode2;
	}
	public Integer getRoomcharge() {
		return roomcharge;
	}
	public void setRoomcharge(Integer roomcharge) {
		this.roomcharge = roomcharge;
	}
	public String getRoomecl() {
		return roomecl;
	}
	public void setRoomecl(String roomecl) {
		this.roomecl = roomecl;
	}
	public String getRoomsnr() {
		return roomsnr;
	}
	public void setRoomsnr(String roomsnr) {
		this.roomsnr = roomsnr;
	}
	public String getRoompci() {
		return roompci;
	}
	public void setRoompci(String roompci) {
		this.roompci = roompci;
	}
	public String getDevicetype() {
		return devicetype;
	}
	public void setDevicetype(String devicetype) {
		this.devicetype = devicetype;
	}
	public String getLockver() {
		return lockver;
	}
	public void setLockver(String lockver) {
		this.lockver = lockver;
	}
	public String getLocklca() {
		return locklca;
	}
	public void setLocklca(String locklca) {
		this.locklca = locklca;
	}
	public String getRoomreset() {
		return roomreset;
	}
	public void setRoomreset(String roomreset) {
		this.roomreset = roomreset;
	}
	public Integer getIsfinger() {
		return isfinger;
	}
	public void setIsfinger(Integer isfinger) {
		this.isfinger = isfinger;
	}
	public Integer getIsbluetooth() {
		return isbluetooth;
	}
	public void setIsbluetooth(Integer isbluetooth) {
		this.isbluetooth = isbluetooth;
	}
	public Integer getIsscanner() {
		return isscanner;
	}
	public void setIsscanner(Integer isscanner) {
		this.isscanner = isscanner;
	}
	public Integer getIslockswith() {
		return islockswith;
	}
	public void setIslockswith(Integer islockswith) {
		this.islockswith = islockswith;
	}
	public Integer getIslatchswith() {
		return islatchswith;
	}
	public void setIslatchswith(Integer islatchswith) {
		this.islatchswith = islatchswith;
	}
	public Integer getIskeyswith() {
		return iskeyswith;
	}
	public void setIskeyswith(Integer iskeyswith) {
		this.iskeyswith = iskeyswith;
	}
	public Integer getIscontactswith() {
		return iscontactswith;
	}
	public void setIscontactswith(Integer iscontactswith) {
		this.iscontactswith = iscontactswith;
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
	public Integer getForcelock() {
		return forcelock;
	}
	public void setForcelock(Integer forcelock) {
		this.forcelock = forcelock;
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
	public Integer getFingernum() {
		return fingernum;
	}
	public void setFingernum(Integer fingernum) {
		this.fingernum = fingernum;
	}
	public Integer getPassnum() {
		return passnum;
	}
	public void setPassnum(Integer passnum) {
		this.passnum = passnum;
	}
	public Integer getOpencardnum() {
		return opencardnum;
	}
	public void setOpencardnum(Integer opencardnum) {
		this.opencardnum = opencardnum;
	}
	public Integer getManagecardnum() {
		return managecardnum;
	}
	public void setManagecardnum(Integer managecardnum) {
		this.managecardnum = managecardnum;
	}
	public Integer getSpecialcardnum() {
		return specialcardnum;
	}
	public void setSpecialcardnum(Integer specialcardnum) {
		this.specialcardnum = specialcardnum;
	}
	public String getSignalStrength() {
		return signalStrength;
	}
	public void setSignalStrength(String signalStrength) {
		this.signalStrength = signalStrength;
	}
	public String getRecordcount() {
		return recordcount;
	}
	public void setRecordcount(String recordcount) {
		this.recordcount = recordcount;
	}
	@Override
	public String toString() {
		return "RoomParamas [roomcode2=" + roomcode2 + ", roomcharge=" + roomcharge + ", roomecl=" + roomecl
				+ ", roomsnr=" + roomsnr + ", roompci=" + roompci + ", devicetype=" + devicetype + ", lockver="
				+ lockver + ", locklca=" + locklca + ", roomreset=" + roomreset + ", isfinger=" + isfinger
				+ ", isbluetooth=" + isbluetooth + ", isscanner=" + isscanner + ", islockswith=" + islockswith
				+ ", islatchswith=" + islatchswith + ", iskeyswith=" + iskeyswith + ", iscontactswith=" + iscontactswith
				+ ", antilock=" + antilock + ", open=" + open + ", forcelock=" + forcelock + ", networkmode="
				+ networkmode + ", workmode=" + workmode + ", fingernum=" + fingernum + ", passnum=" + passnum
				+ ", opencardnum=" + opencardnum + ", managecardnum=" + managecardnum + ", specialcardnum="
				+ specialcardnum + ", signalStrength=" + signalStrength + 
				", recordcount=" + recordcount + "]";
	}
	
	
	
}
