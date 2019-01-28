package com.qingyi.model;
/**
 * 门锁复位
 * @author Administrator
 *
 */
public class LockResetResult {
	private String orderid;
	
	private Integer filetype;
	
	private String locktype;
	
	private Integer resultstatus;
	
	private String order;
	
	private Integer no;
	
	private String result;
	
	private String space;
	
	private String osdate; // 下发时间
	
	public LockResetResult() {
		super();
	}
	/**
	 * 
	 * @param orderid  ID
	 * @param filetype  失败类型
	 * @param locktype  门锁类型
	 * @param resultstatus 状态
	 * @param order 内容
	 * @param no 次数
	 * @param result 结果
	 * @param space 时长
	 * @param osdate 发送时间
	 */
	public LockResetResult(String orderid, Integer filetype, String locktype, Integer resultstatus, String order,
			Integer no, String result, String space, String osdate) {
		super();
		this.orderid = orderid;
		this.filetype = filetype;
		this.locktype = locktype;
		this.resultstatus = resultstatus;
		this.order = order;
		this.no = no;
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

	public Integer getFiletype() {
		return filetype;
	}

	public void setFiletype(Integer filetype) {
		this.filetype = filetype;
	}

	public String getLocktype() {
		return locktype;
	}

	public void setLocktype(String locktype) {
		this.locktype = locktype;
	}

	public Integer getResultstatus() {
		return resultstatus;
	}

	public void setResultstatus(Integer resultstatus) {
		this.resultstatus = resultstatus;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
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
