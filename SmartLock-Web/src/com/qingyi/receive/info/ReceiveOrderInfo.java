package com.qingyi.receive.info;

import com.qingyi.model.ReceiveResult;

public interface ReceiveOrderInfo {
	/**
	 * 解析查询门锁状态指令结果
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult getLockStatusResult(String content,String sysdate,String verify);
	
}
