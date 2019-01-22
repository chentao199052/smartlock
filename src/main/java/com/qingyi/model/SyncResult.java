package com.qingyi.model;

import java.util.List;

public class SyncResult {
	
	private List<SyncCPResult> syncpresult;
	
	private List<SyncFResult> synfresult;
	
	public SyncResult() {
		super();
	}

	/**
	 * 授权同步结果构造方法
	 * @param syncpresult 卡密授权同步结果list
	 * @param synfresult 指纹授权同步结果list
	 */
	public SyncResult(List<SyncCPResult> syncpresult, List<SyncFResult> synfresult) {
		super();
		this.syncpresult = syncpresult;
		this.synfresult = synfresult;
	}

	public List<SyncCPResult> getSyncpresult() {
		return syncpresult;
	}

	public void setSyncpresult(List<SyncCPResult> syncpresult) {
		this.syncpresult = syncpresult;
	}

	public List<SyncFResult> getSynfresult() {
		return synfresult;
	}

	public void setSynfresult(List<SyncFResult> synfresult) {
		this.synfresult = synfresult;
	}

	
}
