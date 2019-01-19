package com.qingyi.model;

public class NBbackorder {
	private String[] param;
	private Integer paramvalue;
	private String id;
	public NBbackorder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NBbackorder(String[] param, Integer paramvalue, String id) {
		super();
		this.param = param;
		this.paramvalue = paramvalue;
		this.id = id;
	}
	public String[] getParam() {
		return param;
	}
	public void setParam(String[] param) {
		this.param = param;
	}
	public Integer getParamvalue() {
		return paramvalue;
	}
	public void setParamvalue(Integer paramvalue) {
		this.paramvalue = paramvalue;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
