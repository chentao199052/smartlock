package com.qingyi.model;

public class LockResult {
	
	private String orderId;  
	private String locktype;
	private String roomcode2;
	public LockResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param orderId 生成的分布式ID
	 * @param locktype 门锁类型
	 * @param roomcode2 房间唯一ID
	 */
	public LockResult(String orderId, String locktype, String roomcode2) {
		super();
		this.orderId = orderId;
		this.locktype = locktype;
		this.roomcode2 = roomcode2;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getLocktype() {
		return locktype;
	}
	public void setLocktype(String locktype) {
		this.locktype = locktype;
	}
	public String getRoomcode2() {
		return roomcode2;
	}
	public void setRoomcode2(String roomcode2) {
		this.roomcode2 = roomcode2;
	}
	@Override
	public String toString() {
		return "LockResult [orderId=" + orderId + ", locktype=" + locktype + ", roomcode2=" + roomcode2 + "]";
	}
	
	
	
}
