package com.qingyi.send.info;

import com.qingyi.model.SendResult;

public interface SendOrderInfo {
	/**
	 * 查询门锁状态方法
	 * @param gatewaycode 门锁归属网关通讯ID
	 * @param gatewaycode2 门锁归属网关唯一ID
	 * @param roomcode 房间编号
	 * @param orderid 指令ID（必须全局唯一）
	 * @param callbackurl 回调地址（接收指令发送结果）
	 * @return 指令发送结果SendResult
	 */
	public SendResult getLockStaus(String gatewaycode,String gatewaycode2,String roomcode,String orderid,String callbackurl);

}
