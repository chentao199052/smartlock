package com.qingyi.receive.info;

import com.qingyi.model.OrderResult;
import com.qingyi.model.ClearsGatewaytatusResult;
import com.qingyi.model.DelRoomCardResult;
import com.qingyi.model.DelUnlockpswResult;
import com.qingyi.model.FingerMachineStateResult;
import com.qingyi.model.FingerResult;
import com.qingyi.model.FingerfailResult;
import com.qingyi.model.FingerfinishResult;
import com.qingyi.model.FingersuccessResult;
import com.qingyi.model.ForcelockResult;
import com.qingyi.model.GatewayInitializeResult;
import com.qingyi.model.GatewaystatusResult;
import com.qingyi.model.LockInitializeResult;
import com.qingyi.model.LockRecordResult;
import com.qingyi.model.LockResetResult;
import com.qingyi.model.LockStatusResult;
import com.qingyi.model.OpenResult;
import com.qingyi.model.ReadGatewayRecordResult;
import com.qingyi.model.ReceiveResult;
import com.qingyi.model.RoomParamas;
import com.qingyi.model.SaveFingerReagyResult;
import com.qingyi.model.SaveUnlockPswResult;
import com.qingyi.model.SyncCPOrderResult;
import com.qingyi.model.SyncFOrderResult;
import com.qingyi.model.UpdateGatewayRoomsResult;
import com.qingyi.model.UpdateGatewaypowResult;
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
	public ReceiveResult<OpenResult> getLockRemoteOpenResult(String content,String sysdate,String verify);
	/**
	 * 解析门锁记录读取指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult<LockRecordResult> getReadLockRecordResult(String content,String sysdate,String verify);
	/**
	 * 解析修改门锁强锁/非强锁模式指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult<ForcelockResult> getUpdateRoomForcelockResult(String content,String sysdate,String verify);
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
	 * 解析授权指令结果
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult<OrderResult> getOrderResult(String content,String sysdate,String verify);
	
	/**
	 * 解析卡密授权同步指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult<SyncCPOrderResult> getSyncCPResult(String content,String sysdate,String verify);
	
	/**
	 * 解析指纹授权授权同步指令
	 * @param content 结果内容
	 * @param sysdate 时间戳
	 * @param verify 校验
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult<SyncFOrderResult> getSyncFResult(String content,String sysdate,String verify);
		
	
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

	/**
	 * 解析NB锁房间的信息（post过来的信息）
	 * @param content  结果内容
	 * @return 解析结果ReceiveResult
	 */
	public ReceiveResult<RoomParamas> getSlRoomParamas(String content,String sysdate,String verify);
}
