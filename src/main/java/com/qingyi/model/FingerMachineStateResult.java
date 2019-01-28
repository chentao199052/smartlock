package com.qingyi.model;
/**
 * 指纹机状态
 * @author Administrator
 *
 */
public class FingerMachineStateResult {
	private String orderid;
	private Integer resultstatus;
	private Integer filetype;
	private String version;
	private String order;
	private String result;
	private String space;
	private String osdate; // 下发时间
	public FingerMachineStateResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param orderid ID
	 * @param resultstatus  状态
	 * @param filetype  失败类型
	 * @param version 版本
	 * @param order 内容
	 * @param result 结果
	 * @param space 时间长
	 * @param osdate 发送时间
	 */
	public FingerMachineStateResult(String orderid, Integer resultstatus, Integer filetype, String version,
			String order, String result, String space, String osdate) {
		super();
		this.orderid = orderid;
		this.resultstatus = resultstatus;
		this.filetype = filetype;
		this.version = version;
		this.order = order;
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
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
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
