package com.qingyi.model;

public class RoomNB {
	private Integer roombdcard;
	private Integer roommaxcard;
	private String  roomid;
	private String  roomcode2;
	private String  roomlocatio;
	private String  roomname;
	private String  forcelock;
	private String  networkmode;
	private String  workmode;
	public RoomNB() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RoomNB(Integer roombdcard, Integer roommaxcard, String roomid, String roomcode2, String roomlocatio,
			String roomname, String forcelock, String networkmode, String workmode) {
		super();
		this.roombdcard = roombdcard;
		this.roommaxcard = roommaxcard;
		this.roomid = roomid;
		this.roomcode2 = roomcode2;
		this.roomlocatio = roomlocatio;
		this.roomname = roomname;
		this.forcelock = forcelock;
		this.networkmode = networkmode;
		this.workmode = workmode;
	}
	public Integer getRoombdcard() {
		return roombdcard;
	}
	public void setRoombdcard(Integer roombdcard) {
		this.roombdcard = roombdcard;
	}
	public Integer getRoommaxcard() {
		return roommaxcard;
	}
	public void setRoommaxcard(Integer roommaxcard) {
		this.roommaxcard = roommaxcard;
	}
	public String getRoomid() {
		return roomid;
	}
	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}
	public String getRoomcode2() {
		return roomcode2;
	}
	public void setRoomcode2(String roomcode2) {
		this.roomcode2 = roomcode2;
	}
	public String getRoomlocatio() {
		return roomlocatio;
	}
	public void setRoomlocatio(String roomlocatio) {
		this.roomlocatio = roomlocatio;
	}
	public String getRoomname() {
		return roomname;
	}
	public void setRoomname(String roomname) {
		this.roomname = roomname;
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
