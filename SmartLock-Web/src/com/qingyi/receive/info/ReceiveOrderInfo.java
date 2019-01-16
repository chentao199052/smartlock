package com.qingyi.receive.info;

import com.qingyi.model.CardOrPswResult;
import com.qingyi.model.ClearsGatewaytatusResult;
import com.qingyi.model.DelRoomCardResult;
import com.qingyi.model.DelUnlockpswResult;
import com.qingyi.model.FingerMachineStateResult;
import com.qingyi.model.FingerResult;
import com.qingyi.model.FingerfailResult;
import com.qingyi.model.FingerfinishResult;
import com.qingyi.model.FingersuccessResult;
import com.qingyi.model.GatewayInitializeResult;
import com.qingyi.model.GatewaystatusResult;
import com.qingyi.model.LockInitializeResult;
import com.qingyi.model.LockRemoteOpenResult;
import com.qingyi.model.LockResetResult;
import com.qingyi.model.LockStatusResult;
import com.qingyi.model.ReadGatewayRecordResult;
import com.qingyi.model.ReadLockRecordResult;
import com.qingyi.model.ReceiveResult;
import com.qingyi.model.SaveFingerReagyResult;
import com.qingyi.model.SaveRoomFingerResult;
import com.qingyi.model.SaveRoomFingerResult2;
import com.qingyi.model.SaveRoomFingerResult3;
import com.qingyi.model.SaveUnlockPswResult;
import com.qingyi.model.SyncCardResult;
import com.qingyi.model.SyncFailResult;
import com.qingyi.model.SyncFinishResult;
import com.qingyi.model.SyncSuccessResult;
import com.qingyi.model.UpdateGatewayRoomsResult;
import com.qingyi.model.UpdateGatewaypowResult;
import com.qingyi.model.UpdateRoomForcelockResult;
import com.qingyi.model.UpdateRoomNetmodeResult;
import com.qingyi.model.UpdateRoomWorkmodeResult;
import com.qingyi.model.UpdateRoompowResult;

public interface ReceiveOrderInfo {
	/**
	 * 解析查询门锁状态指令结果
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult<LockStatusResult> getLockStatusResult(String content,String sysdate,String verify);
	/**
	 * 解析查询门锁复位指令结果
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult<LockResetResult> getLockResetResult(String content,String sysdate,String verify);
	/**
	 * 解析门锁远程开门指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult<LockRemoteOpenResult> getLockRemoteOpenResult(String content,String sysdate,String verify);
	/**
	 * 解析门锁记录读取指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult<ReadLockRecordResult> getReadLockRecordResult(String content,String sysdate,String verify);
	/**
	 * 解析修改门锁强锁/非强锁模式指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult<UpdateRoomForcelockResult> getUpdateRoomForcelockResult(String content,String sysdate,String verify);
	/**
	 * 解析修改门锁功率等级指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult<UpdateRoompowResult> getUpdateRoompowResult(String content,String sysdate,String verify);
	/**
	 * 解析修改门锁常开/常闭模式指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult<UpdateRoomWorkmodeResult> getUpdateRoomWorkmodeResult(String content,String sysdate,String verify);
	/**
	 * 解析修改门锁联网模式指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult<UpdateRoomNetmodeResult> getUpdateRoomNetmodeResult(String content,String sysdate,String verify);
	/**
	 * 解析指纹机录入准备指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult<SaveFingerReagyResult> getSaveFingerReagyResult(String content,String sysdate,String verify);
	/**
	 * 解析网关状态查询指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult<GatewaystatusResult> getGatewaystatusResult(String content,String sysdate,String verify);
	/**
	 * 解析修改网关功率等级指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult<UpdateGatewaypowResult> getUpdateGatewaypowResult(String content,String sysdate,String verify);
	/**
	 * 解析清除网关异常数据指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult<ClearsGatewaytatusResult> getClearsGatewaytatusResult(String content,String sysdate,String verify);
	/**
	 * 解析网关路由表更新指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult<UpdateGatewayRoomsResult> getUpdateGatewayRoomsResult(String content,String sysdate,String verify);
	/**
	 * 解析读取网关记录指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult<ReadGatewayRecordResult> getReadGatewayRecordResult(String content,String sysdate,String verify);
	/**
	 * 解析初始化网关ID指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult<GatewayInitializeResult> getGatewayInitializeResult(String content,String sysdate,String verify);
	/**
	 * 解析发送密码授权指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult<SaveUnlockPswResult> getSaveUnlockPswResult(String content,String sysdate,String verify);
	/**
	 * 解析取消密码授权指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult<DelUnlockpswResult> getDelUnlockpswResult(String content,String sysdate,String verify);
	/**
	 * 解析发送初始化房间编号指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult<LockInitializeResult> getLockInitializeResult(String content,String sysdate,String verify);
	/**
	 * 解析发送卡片/密码授权指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult<CardOrPswResult> getCardOrPswResult(String content,String sysdate,String verify);
	/**
	 * 解析发送/取消指纹授权指令(失败)
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult<SaveRoomFingerResult> getSaveRoomFingerResult(String content,String sysdate,String verify);
	/**
	 * 解析发送/取消指纹授权指令(分包)
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult<SaveRoomFingerResult2> getSaveRoomFingerResult2(String content,String sysdate,String verify);
	/**
	 * 解析发送/取消指纹授权指令(总结果)
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult<SaveRoomFingerResult3> getSaveRoomFingerResult3(String content,String sysdate,String verify);
	/**
	 * 解析删除卡片授权指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult<DelRoomCardResult> getDelRoomCardResult(String content,String sysdate,String verify);
	/**
	 * 解析卡片授权同步指令
	 * @param content
	 * @param sysdate
	 * @param verify
	 * @return
	 */
	
	public ReceiveResult<SyncCardResult> getSyncCardResult(String content,String sysdate,String verify);
	
	/**
	 * 解析卡片授权同步失败指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult<SyncFailResult> getSyncFailResult(String content,String sysdate,String verify);
	/**
	 * 解析卡片授权同步的分包结果
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult<SyncFinishResult> getSyncFinishResult(String content,String sysdate,String verify);
	/**
	 * 解析卡片授权同步的总结果
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult<SyncSuccessResult> getSyncSuccessResult(String content,String sysdate,String verify);
	/**
	 * 解析指纹授权同步失败指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult<FingerfailResult> getFingerfailResult(String content,String sysdate,String verify);
	/**
	 * 解析指纹指令分包成功结果
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult<FingerfinishResult> getFingerfinishResult(String content,String sysdate,String verify);
	/**
	 * 解析指纹指令总结果
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult<FingersuccessResult> getFingersuccessResult(String content,String sysdate,String verify);
	
	/**
	 * 解析指纹机状态
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult<FingerMachineStateResult> getFingerMachineStateResult(String content,String sysdate,String verify);
	/**
	 * 解析指纹结果
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	
	public ReceiveResult<FingerResult> getFingerResult(String content,String sysdate,String verify);

}
