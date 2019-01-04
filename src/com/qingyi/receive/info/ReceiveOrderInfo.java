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
	/**
	 * 解析查询门锁复位指令结果
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult getLockResetResult(String content,String sysdate,String verify);
	/**
	 * 解析门锁远程开门指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult getLockRemoteOpenResult(String content,String sysdate,String verify);
	/**
	 * 解析门锁记录读取指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult getReadLockRecordResult(String content,String sysdate,String verify);
	/**
	 * 解析修改门锁强锁/非强锁模式指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult getUpdateRoomForcelockResult(String content,String sysdate,String verify);
	/**
	 * 解析修改门锁功率等级指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult getUpdateRoompowResult(String content,String sysdate,String verify);
	/**
	 * 解析修改门锁常开/常闭模式指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult getUpdateRoomWorkmodeResult(String content,String sysdate,String verify);
	/**
	 * 解析修改门锁联网模式指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult getUpdateRoomNetmodeResult(String content,String sysdate,String verify);
	/**
	 * 解析指纹机录入准备指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult getSaveFingerReagyResult(String content,String sysdate,String verify);
	/**
	 * 解析网关状态查询指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult getGatewaystatusResult(String content,String sysdate,String verify);
	/**
	 * 解析修改网关功率等级指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult getUpdateGatewaypowResult(String content,String sysdate,String verify);
	/**
	 * 解析清除网关异常数据指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult getClearsGatewaytatusResult(String content,String sysdate,String verify);
	/**
	 * 解析网关路由表更新指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult getUpdateGatewayRoomsResult(String content,String sysdate,String verify);
	/**
	 * 解析读取网关记录指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult getReadGatewayRecordResult(String content,String sysdate,String verify);
	/**
	 * 解析初始化网关ID指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult getGatewayInitializeResult(String content,String sysdate,String verify);
	/**
	 * 解析发送密码授权指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult getSaveUnlockPswResult(String content,String sysdate,String verify);
	/**
	 * 解析取消密码授权指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult getDelUnlockpswResult(String content,String sysdate,String verify);
	/**
	 * 解析发送初始化房间编号指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult getLockInitializeResult(String content,String sysdate,String verify);
	/**
	 * 解析发送卡片授权指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult getSaveRoomCardResult(String content,String sysdate,String verify);
	/**
	 * 解析发送/取消指纹授权指令(失败)
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult getSaveRoomFingerResult(String content,String sysdate,String verify);
	/**
	 * 解析发送/取消指纹授权指令(分包)
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult getSaveRoomFingerResult2(String content,String sysdate,String verify);
	/**
	 * 解析发送/取消指纹授权指令(总结果)
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult getSaveRoomFingerResult3(String content,String sysdate,String verify);
	/**
	 * 解析删除卡片授权指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult getDelRoomCardResult(String content,String sysdate,String verify);
	
	/**
	 * 解析卡片授权同步失败指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult getSyncFailResult(String content,String sysdate,String verify);
	/**
	 * 解析卡片授权同步的分包结果
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult getSyncFinishResult(String content,String sysdate,String verify);
	/**
	 * 解析卡片授权同步的总结果
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult getSyncSuccessResult(String content,String sysdate,String verify);
	/**
	 * 解析指纹授权同步失败指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult getFingerfailResult(String content,String sysdate,String verify);
	/**
	 * 解析指纹指令分包成功结果
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult getFingerfinishResult(String content,String sysdate,String verify);
	/**
	 * 解析指纹指令总结果
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult getFingersuccessResult(String content,String sysdate,String verify);
	
	//NB---------------------------------------------------------------------------------------------
	//C1back*  DC1back*   YC1back*
	public ReceiveResult getNBbackorderResult(String content,String sysdate,String verify);
	//syscbackC1_*   syscbackDC1_*  syscbackYC1_*
	public ReceiveResult getNBbackorderResult2(String content,String sysdate,String verify);
	//syscbackC2_*  syscbackDC2_* syscbackYC2_*
	public ReceiveResult getNBbackorderResult3(String content,String sysdate,String verify);
	//C2firstback_*   DC2firstback_*   YC2firstback_*
	public ReceiveResult getNBbackorderResult4(String content,String sysdate,String verify);
	//C2back* DC2back*    YC2back*
	public ReceiveResult getNBbackorderResult5(String content,String sysdate,String verify);

	//C1onesuccess_*(华为)    DC1onesuccess_*(电信)   YC1onesuccess_*（移动）
	public ReceiveResult getNBorderResult(String content,String sysdate,String verify);
	// C2onesuccess_*(华为)    DC2onesuccess_*(电信)   YC2onesuccess_*（移动）
	public ReceiveResult getNBorderResult2(String content,String sysdate,String verify);
	/*syscC1success_*(华为)  syscfailC1_*(华为)syscDC1success_*(电信)   syscfailDC1_*(电信) 
	syscYC1success_*（移动）syscfailYC1_*（移动）
	*/
	public ReceiveResult getNBorderResult3(String content,String sysdate,String verify);
	//syscC2success_*(华为)   syscDC2success_*(电信)   syscYC2success_*（移动） 
	public ReceiveResult getNBorderResult4(String content,String sysdate,String verify);
	//syscfailC2_* (华为)       syscfailDC2_*(电信)  syscfailYC2_*（移动）
	public ReceiveResult getNBorderResult5(String content,String sysdate,String verify);
	//C1success* (华为)      DC1success* (电信)  YC1success*（移动）
	public ReceiveResult getNBorderResult6(String content,String sysdate,String verify);
	//C2success_*(华为)    DC2success_* (电信)   YC2success_*（移动）
	public ReceiveResult getNBorderResult7(String content,String sysdate,String verify);
	/**
	 * 解析NB锁操作记录
	 * @param content
	 * @param sysdate
	 * @param verify
	 * @return
	 */
	public ReceiveResult getNBrecordsResult(String content,String sysdate,String verify);
}
