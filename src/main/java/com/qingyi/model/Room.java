package com.qingyi.model;

public class Room {
	private String roomcode2;
	private String forcelock;
	private String networkmode;
	private String workmode;
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Room(String roomcode2, String forcelock, String networkmode, String workmode) {
		super();
		this.roomcode2 = roomcode2;
		this.forcelock = forcelock;
		this.networkmode = networkmode;
		this.workmode = workmode;
	}
	public String getRoomcode2() {
		return roomcode2;
	}
	public void setRoomcode2(String roomcode2) {
		this.roomcode2 = roomcode2;
	}
	public String getForcelock() {
		return forcelock;
	}
	public void setForcelock(String forcelock) {
		this.forcelock = forcelock;
	}
	public String getNetworkmode() {
		return networkmode;
	}
	public void setNetworkmode(String networkmode) {
		this.networkmode = networkmode;
	}
	public String getWorkmode() {
		return workmode;
	}
	public void setWorkmode(String workmode) {
		this.workmode = workmode;
	}
	
	
}
