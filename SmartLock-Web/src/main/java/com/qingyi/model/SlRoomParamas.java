package com.qingyi.model;

public class SlRoomParamas {
	private Integer roomcharge;
	private String roomecl;
	private String roomsnr;
	private String lockver;
	private Integer locklca;
	private Integer roomreset;
	private String roomconfig;
	private Integer roomstatus2;
	private Integer roomstatus;
	private Integer recordcount;
	public SlRoomParamas() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SlRoomParamas(Integer roomcharge, String roomecl, String roomsnr, String lockver, Integer locklca,
			Integer roomreset, String roomconfig, Integer roomstatus2, Integer roomstatus, Integer recordcount) {
		super();
		this.roomcharge = roomcharge;
		this.roomecl = roomecl;
		this.roomsnr = roomsnr;
		this.lockver = lockver;
		this.locklca = locklca;
		this.roomreset = roomreset;
		this.roomconfig = roomconfig;
		this.roomstatus2 = roomstatus2;
		this.roomstatus = roomstatus;
		this.recordcount = recordcount;
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
	public String getLockver() {
		return lockver;
	}
	public void setLockver(String lockver) {
		this.lockver = lockver;
	}
	public Integer getLocklca() {
		return locklca;
	}
	public void setLocklca(Integer locklca) {
		this.locklca = locklca;
	}
	public Integer getRoomreset() {
		return roomreset;
	}
	public void setRoomreset(Integer roomreset) {
		this.roomreset = roomreset;
	}
	public String getRoomconfig() {
		return roomconfig;
	}
	public void setRoomconfig(String roomconfig) {
		this.roomconfig = roomconfig;
	}
	public Integer getRoomstatus2() {
		return roomstatus2;
	}
	public void setRoomstatus2(Integer roomstatus2) {
		this.roomstatus2 = roomstatus2;
	}
	public Integer getRoomstatus() {
		return roomstatus;
	}
	public void setRoomstatus(Integer roomstatus) {
		this.roomstatus = roomstatus;
	}
	public Integer getRecordcount() {
		return recordcount;
	}
	public void setRecordcount(Integer recordcount) {
		this.recordcount = recordcount;
	}
	
	
	
}
