package com.qingyi.model;

import java.util.List;

public class NBrecordsResult {
	private Integer resultstatus;
	private String roomid;
	private String records;
	private List<NBrecords> nbrecords;
	public NBrecordsResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NBrecordsResult(Integer resultstatus, String roomid, String records, List<NBrecords> nbrecords) {
		super();
		this.resultstatus = resultstatus;
		this.roomid = roomid;
		this.records = records;
		this.nbrecords = nbrecords;
	}
	public Integer getResultstatus() {
		return resultstatus;
	}
	public void setResultstatus(Integer resultstatus) {
		this.resultstatus = resultstatus;
	}
	public String getRoomid() {
		return roomid;
	}
	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}
	public String getRecords() {
		return records;
	}
	public void setRecords(String records) {
		this.records = records;
	}
	public List<NBrecords> getNbrecords() {
		return nbrecords;
	}
	public void setNbrecords(List<NBrecords> nbrecords) {
		this.nbrecords = nbrecords;
	}
	
}
