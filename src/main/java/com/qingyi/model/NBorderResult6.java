package com.qingyi.model;

import java.util.List;

public class NBorderResult6 {
	private String orderid;
	private Integer resultstatus;
	private Integer failtype;
	private String resultorder;
	private String order;
	private String ids;
	private List<String> c_ids;
	private List<String> f_ids;
	private List<String> p_ids;
	public NBorderResult6() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NBorderResult6(String orderid, Integer resultstatus, Integer failtype, String resultorder, String order,
			String ids, List<String> c_ids, List<String> f_ids, List<String> p_ids) {
		super();
		this.orderid = orderid;
		this.resultstatus = resultstatus;
		this.failtype = failtype;
		this.resultorder = resultorder;
		this.order = order;
		this.ids = ids;
		this.c_ids = c_ids;
		this.f_ids = f_ids;
		this.p_ids = p_ids;
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
	public Integer getFailtype() {
		return failtype;
	}
	public void setFailtype(Integer failtype) {
		this.failtype = failtype;
	}
	public String getResultorder() {
		return resultorder;
	}
	public void setResultorder(String resultorder) {
		this.resultorder = resultorder;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public List<String> getC_ids() {
		return c_ids;
	}
	public void setC_ids(List<String> c_ids) {
		this.c_ids = c_ids;
	}
	public List<String> getF_ids() {
		return f_ids;
	}
	public void setF_ids(List<String> f_ids) {
		this.f_ids = f_ids;
	}
	public List<String> getP_ids() {
		return p_ids;
	}
	public void setP_ids(List<String> p_ids) {
		this.p_ids = p_ids;
	}
	
	
}
