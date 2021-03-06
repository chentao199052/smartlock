package com.qingyi.model;
/**
 * 密码授权
 * @author Administrator
 *
 */
public class SaveUnlockPswResult {
    private String orderid;
	
	private Integer resultstatus;
	
	private Integer filetype;
	
	private String order;
	
	private String result;
	
	private String cardtype;
	
	private String no;
	
	private String space;
    
	private String osdate; // 下发时间
	public SaveUnlockPswResult() {
		super();
	}
	public SaveUnlockPswResult(String orderid, Integer resultstatus, Integer filetype, String order, String result,
			String cardtype, String no, String space, String osdate) {
		super();
		this.orderid = orderid;
		this.resultstatus = resultstatus;
		this.filetype = filetype;
		this.order = order;
		this.result = result;
		this.cardtype = cardtype;
		this.no = no;
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
	public String getCardtype() {
		return cardtype;
	}
	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
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
