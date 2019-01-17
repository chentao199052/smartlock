package com.qingyi.model;

public class RoomNB {
	private Integer roombdcard;
	private Integer roommaxcard;
	private Long  roomid;
	private String  roomcode2;
	private String  roomlocation;
	private String  roomname;
	private Integer  forcelock;
	private Integer  networkmode;
	private Integer  workmode;
	public RoomNB() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RoomNB(Integer roombdcard, Integer roommaxcard, Long roomid, String roomcode2, String roomlocation,
			String roomname, Integer forcelock, Integer networkmode, Integer workmode) {
		super();
		this.roombdcard = roombdcard;
		this.roommaxcard = roommaxcard;
		this.roomid = roomid;
		this.roomcode2 = roomcode2;
		this.roomlocation = roomlocation;
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
	public Long getRoomid() {
		return roomid;
	}
	public void setRoomid(Long roomid) {
		this.roomid = roomid;
	}
	public String getRoomcode2() {
		return roomcode2;
	}
	public void setRoomcode2(String roomcode2) {
		this.roomcode2 = roomcode2;
	}
	public String getRoomlocation() {
		return roomlocation;
	}
	public void setRoomlocation(String roomlocation) {
		this.roomlocation = roomlocation;
	}
	public String getRoomname() {
		return roomname;
	}
	public void setRoomname(String roomname) {
		this.roomname = roomname;
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
	
}
