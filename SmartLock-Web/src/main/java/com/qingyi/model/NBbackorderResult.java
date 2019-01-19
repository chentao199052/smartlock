package com.qingyi.model;

import java.util.List;

public class NBbackorderResult {
	private Integer resultstatus;
	private String order;
	private List<String> rcfps;
	private List<NBbackorder> rcs;
	private List<NBbackorder> rfs;
	private List<NBbackorder> rps;
	public NBbackorderResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NBbackorderResult(Integer resultstatus, String order, List<String> rcfps, List<NBbackorder> rcs,
			List<NBbackorder> rfs, List<NBbackorder> rps) {
		super();
		this.resultstatus = resultstatus;
		this.order = order;
		this.rcfps = rcfps;
		this.rcs = rcs;
		this.rfs = rfs;
		this.rps = rps;
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
	public List<String> getRcfps() {
		return rcfps;
	}
	public void setRcfps(List<String> rcfps) {
		this.rcfps = rcfps;
	}
	public List<NBbackorder> getRcs() {
		return rcs;
	}
	public void setRcs(List<NBbackorder> rcs) {
		this.rcs = rcs;
	}
	public List<NBbackorder> getRfs() {
		return rfs;
	}
	public void setRfs(List<NBbackorder> rfs) {
		this.rfs = rfs;
	}
	public List<NBbackorder> getRps() {
		return rps;
	}
	public void setRps(List<NBbackorder> rps) {
		this.rps = rps;
	}
	
}
