package com.qingyi.send.info;

import java.util.List;

import com.qingyi.model.AuthCard;
import com.qingyi.model.AuthDelCard;
import com.qingyi.model.AuthDelFinger;
import com.qingyi.model.AuthDelPsw;
import com.qingyi.model.AuthFinger;
import com.qingyi.model.AuthPsw;
import com.qingyi.model.AuthRestAndOpen;
import com.qingyi.model.AuthResult;
import com.qingyi.model.AuthSync;
import com.qingyi.model.AuthTotal;
import com.qingyi.model.DelCardsResult;
import com.qingyi.model.DelFingersResult;
import com.qingyi.model.DelRoomFinger;
import com.qingyi.model.DelUnlockPsw;
import com.qingyi.model.LockResult;
import com.qingyi.model.Log;
import com.qingyi.model.PowResult;
import com.qingyi.model.PswsResult;
import com.qingyi.model.RegistNb;
import com.qingyi.model.Room;
import com.qingyi.model.RoomCard;
import com.qingyi.model.RoomFinger;
import com.qingyi.model.RoomResult;
import com.qingyi.model.Roompow;
import com.qingyi.model.SendResult;
import com.qingyi.model.SyncResult;
import com.qingyi.model.UnlockPsw;

public interface SendOrderInfo {
	/**
	 * 查询门锁状态指令    NB锁不支持
	 * @param gatewaycode 门锁归属网关通讯ID
	 * @param gatewaycode2 门锁归属网关唯一ID
	 * @param roomcode 房间编号
	 * @param timeout 有效时间（单位s）
	 * @param callbackurl 回调地址（接收指令发送结果）
	 * @return 指令发送结果SendResult
	 */
	public SendResult getLockStatus(String gatewaycode,String gatewaycode2,String roomcode,Integer timeout,String callbackurl);
	
	
	/**
	 * 发送门锁记录读取指令 (不含NB锁)
	 * @param gatewaycode 门锁归属网关通讯ID
	 * @param gatewaycode2 门锁归属网关唯一ID
	 * @param roomcode 房间编号
	 * @param timeout 有效时间（单位s）
	 * @param callbackurl 回调地址（接收指令发送结果）
	 * @return 指令发送结果SendResult
	 */
	public SendResult readLockRecord(String gatewaycode,String gatewaycode2,String roomcode,Integer timeout,String callbackurl);
	
	
	/**
	 * 修改门锁功率等级
	 * @param gatewaycode 门锁归属网关通讯ID
	 * @param gatewaycode2  门锁归属网关唯一ID
	 * @param roomcode 房间编号
	 * @param level 1=A0,2=A1,3=A2,4=A3
	 * @param timeout 有效时间（单位s）
	 * @param callbackurl 回调地址（接收指令发送结果）
	 * @return 指令发送结果SendResult
	 */
	public SendResult updateRoompow(String gatewaycode,String gatewaycode2,String roomcode,Integer level,Integer timeout,String callbackurl);
	
	/**
	 * 指纹机录入准备
	 * @param fpcode  指纹机唯一ID
	 * @param timeout 有效时间（单位s）
	 * @param callbackurl 回调地址（接收指令发送结果）
	 * @return 指令发送结果SendResult
	 */
	public SendResult saveFingerReagy(String fpcode,Integer timeout,String callbackurl);
	/**
	 * 指纹机清空
	 * @param fpcode  指纹机唯一ID
	 * @param type  类型  0指纹 1身份证 2卡号
	 * @param timeout
	 * @param callbackurl
	 * @return
	 */
	public SendResult clearFingerMachine(String fpcode,String type);
	
	/**
	 * 指纹机读取
	 * @param fpcode  指纹机唯一ID
	 * @param type  类型  0指纹 1身份证 2卡号
	 * @param timeout
	 * @param callbackurl
	 * @return
	 */
	public SendResult<String> readFingerMachine(String fpcode,String type);
	
	
	
	/**
	 * 指纹机状态(查询是否可录入指纹)
	 * @param fpcode  指纹机唯一ID
	 * @param timeout 有效时间（单位s）
	 * @param callbackurl 回调地址（接收指令发送结果）
	 * @return
	 */
	public SendResult fingerMachineState(String fpcode,Integer timeout,String callbackurl);
	
	/**
	 * 网关状态查询
	 * @param gatewaycode 网关通讯ID
	 * @param gatewaycode2  网关唯一ID
	 * @param timeout 有效时间（单位s）
	 * @param date (格式yyMMddHHmm)
	 * @param callbackurl 回调地址（接收指令发送结果）
	 * @return 指令发送结果SendResult
	 */
	public SendResult getGatewaystatus(String gatewaycode,String gatewaycode2,String date,Integer timeout,String callbackurl);
	
	/**
	 * 修改网关功率等级
	 * @param gatewaycode 网关通讯ID
	 * @param gatewaycode2  网关唯一ID
	 * @param level 1=A0,2=A1,3=A2,4=A3
	 * @param timeout 有效时间（单位s）
	 * @param callbackurl 回调地址（接收指令发送结果）
	 * @return 指令发送结果SendResult
	 */
	public SendResult updateGatewaypow(String gatewaycode,String gatewaycode2,Integer level,Integer timeout,String callbackurl);
	/**
	 * 清除网关异常数据
	 * @param gatewaycode  网关通讯ID
	 * @param gatewaycode2   网关唯一ID
	 * @param timeout      有效时间（单位s）
	 * @param callbackurl  回调地址（接收指令发送结果）
	 * @return
	 */
	public SendResult clearsGatewaytatus(String gatewaycode,String gatewaycode2,Integer timeout,String callbackurl);
	
	/**
	 * 网关路由表更新
	 * @param gatewaycode 网关通讯ID
	 * @param gatewaycode2  网关唯一ID
	 * @param roomcodes 网关下门锁编号拼接字符串(如俩个房间：12345678)
	 * @param timeout 有效时间（单位s）
	 * @param callbackurl 回调地址（接收指令发送结果）
	 * @return 指令发送结果SendResult
	 */
	public SendResult updateGatewayRooms(String gatewaycode,String gatewaycode2,String roomcodes,Integer timeout,String callbackurl);
	
	/**
	 * 读取网关记录
	 * @param gatewaycode 网关通讯ID
	 * @param gatewaycode2  网关唯一ID
	 * @param timeout 有效时间（单位s）
	 * @param callbackurl 回调地址（接收指令发送结果）
	 * @return 指令发送结果SendResult
	 */
	public SendResult readGatewayRecord(String gatewaycode,String gatewaycode2,Integer timeout,String callbackurl);
	
	/**
	 * 初始化网关ID
	 * @param gatewaycode 网关通讯ID
	 * @param newgatewaycode 网关新通讯ID
	 * @param gatewaycode2  网关唯一ID
	 * @param timeout 有效时间（单位s）
	 * @param callbackurl 回调地址（接收指令发送结果）
	 * @return 指令发送结果SendResult
	 */
	public SendResult gatewayInitialize(String gatewaycode,String newgatewaycode,String gatewaycode2,Integer timeout,String callbackurl);
	
	
	/**
	 * 发送初始化房间编号指令  NB不支持
	 * @param gatewaycode 门锁归属网关通讯ID
	 * @param gatewaycode2 门锁归属网关唯一ID
	 * @param roomcode 房间编号
	 * @param roomcode2 房间唯一ID
	 * @param timeout 有效时间（单位s）
	 * @param callbackurl 回调地址（接收指令发送结果）
	 * @return 指令发送结果SendResult
	 */
	public SendResult lockInitialize(String gatewaycode,String gatewaycode2,String roomcode,String roomcode2,Integer timeout,String callbackurl);
	
	
	
	
	
	
	/**
	 * 发送房间卡片/密码授权同步指令
	 * @param gatewaycode 门锁归属网关通讯ID（联网锁必填）
	 * @param gatewaycode2 门锁归属网关唯一ID（联网锁必填）
	 * @param roomcode 房间编号（联网锁必填）
	 * @param roomcode2 房间唯一ID（NB锁必填）
	 * @param roomimei NB锁imei（NB锁必填）
	 * @param locktype 门锁类型（必填，1，联网锁，2华为NB，3电信NB，4移动NB）
	 * @param rclist 卡片授权实体list（卡片或密码list不能同时为空）
	 * @param pswlist 密码授权实体list（）
	 * @param timeout 有效时间（必填，单位s）
	 * @param callbackurl 回调地址（必填，接收指令发送结果）
	 * @return 指令发送结果SendResult
	 */
	public SendResult syncRoomCardAndPsw(String gatewaycode,String gatewaycode2,String roomcode,String roomcode2,String roomimei,String locktype,List<RoomCard> rclist,List<UnlockPsw> pswlist,Integer timeout,String callbackurl);
	

	/**
	 * 发送房间指纹授权同步指令
	 * @param gatewaycode 门锁归属网关通讯ID
	 * @param gatewaycode2  门锁归属网关唯一ID
	 * @param roomcode 房间编号
	 * @param rflist 指纹授权实体list
	 * @param locktype 门锁类型
	 * @param timeout 有效时间（单位s）
	 * @param callbackurl  回调地址（接收指令发送结果）
	 * @return 指令发送结果SendResult
	 */
	public SendResult syncRoomFinger(String gatewaycode,String gatewaycode2,String roomcode,String roomcode2,String roomimei,String locktype,List<RoomFinger> rflist,Integer timeout,String callbackurl); 

	/**
	 * 根据授权列表生成网关锁与NB锁的授权与取消授权指令
	 * @param clist 需授权卡片列表
	 * @param dclist 需删除卡片授权列表
	 * @param flist 需授权指纹列表
	 * @param dflist 需删除指纹列表
	 * @param plist 需授权密码列表
	 * @param dplist 需删除密码列表
	 * @param timeout
	 * @param callbackurl
	 * @return
	 */
	public SendResult<AuthResult> saveLotAuth(List<AuthCard> clist,List<AuthDelCard> dclist,List<AuthFinger> flist,List<AuthDelFinger> dflist,List<AuthPsw> plist,List<AuthDelPsw> dplist,Integer timeout,String callbackurl);
	
	/**
	 * 批量卡密/指纹授权同步
	 * @param clist 需同步的卡片列表
	 * @param plist 需同步的密码列表
	 * @param flist 需同步的指纹列表
	 * @return
	 */
	public SendResult<SyncResult> saveAuthSync(List<AuthSync> synclist);
	/**
	 * 发送门锁复位指令(合)
	 * @param gatewaycode 网关通讯ID
	 * @param gatewaycode2 属网关唯一ID
	 * @param roomcode  房间编号
	 * @param roomcode2 
	 * @param locktype	门锁类型 1联网锁2华为3电信4移动
	 * @param timeout 有效时间（单位s）
	 * @param callbackurl 回调地址
	 * @return
	 */
	public SendResult saveTotalReset(String gatewaycode,String gatewaycode2,String roomcode,String roomcode2,String locktype,Integer timeout,String callbackurl);
	/**
	 * 发送门锁复位指令(合-批量)
	 * @param rstlist
	 * @return
	 */
	public SendResult<List<LockResult>> saveTotalResetList(List<AuthRestAndOpen> rstlist);

	/**
	 *  发送门锁远程开门指令(合)
	 * @param gatewaycode 网关通讯ID
	 * @param gatewaycode2 网关唯一ID
	 * @param roomcode  房间编号
	 * @param roomcode2	房间唯一ID
	 * @param locktype 门锁类型 1网关锁 2华为 3电信  4 移动
	 * @param timeout  超时时间
	 * @param callbackurl 回调地址
	 * @return
	 */
	public SendResult saveTotalOpen(String gatewaycode,String gatewaycode2,String roomcode,String roomcode2,String locktype,Integer timeout,String callbackurl);
	/**
	 * 发送门锁远程开门指令(合-批量)
	 * @param oplist
	 * @return
	 */
	public SendResult<List<LockResult>> saveTotalOpenList(List<AuthRestAndOpen> oplist);
	/**
	 * 修改门锁强锁/非强锁模式（合)
	 * @param type  type 1强制锁门 2非强制锁门
	 * @param gatewaycode  网关通讯ID
	 * @param gatewaycode2	网关唯一ID
	 * @param roomcode 房间编号
	 * @param roomcode2	房间唯一ID
	 * @param locktype 门锁类型 1网关锁 2华为 3电信4 移动
	 * @param timeout 有效时间
	 * @param callbackurl 回调地址
	 * @return
	 */
	public SendResult updateTotalForcelock(Integer type,String gatewaycode,String gatewaycode2,String roomcode,String roomcode2,String locktype,Integer timeout,String callbackurl);
	/**
	 * 修改门锁强锁/非强锁模式（合-批量）
	 * @param frlist
	 * @return
	 */
	public SendResult<List<LockResult>> updateTotalForcelockList(List<AuthTotal> frlist);
	/**
	 * 修改门锁常开/常闭模式(合)
	 * @param type  type 1常开，2常闭
	 * @param gatewaycode 网关通讯ID
	 * @param gatewaycode2	网关唯一ID
	 * @param roomcode 房间编号
	 * @param roomcode2 房间唯一编号
	 * @param locktype 门锁类型  1网关锁 2华为 3电信4 移动
	 * @param timeout 有效时间
	 * @param callbackurl 回调地址
	 * @return
	 */
	public SendResult updateTotalRoomWorkmode(Integer type,String gatewaycode,String gatewaycode2,String roomcode,String roomcode2,String locktype,Integer timeout,String callbackurl);
	/**
	 * 修改门锁常开/常闭模式(合-批量)
	 * @param wklist
	 * @return
	 */
	public SendResult<List<LockResult>> updateTotalRoomWorkmodeList(List<AuthTotal> wklist);
	/**
	 * 修改门锁授权模式（合）
	 * @param type type 1允许离线授权，2禁止离线授权
	 * @param gatewaycode 网关通讯ID
	 * @param gatewaycode2 网关唯一ID
	 * @param roomcode	房间编号
	 * @param roomcode2	房间唯一ID
	 * @param locktype 门锁类型
	 * @param timeout 有效时间
	 * @param callbackurl 回调地址
	 * @return
	 */
	public SendResult updateTotalRoomNetmode(Integer type,String gatewaycode,String gatewaycode2,String roomcode,String roomcode2 ,String locktype,Integer timeout,String callbackurl);
	/**
	 * 修改门锁授权模式（合-批量）
	 * @param ntlist
	 * @return
	 */
	public SendResult<List<LockResult>> updateTotalRoomNetmodeList(List<AuthTotal> ntlist);

	/**
	 * 发送密码授权指令(合)
	 * @param gatewaycode 网关通讯ID
	 * @param gatewaycode2 网关唯一ID
	 * @param roomcode 房间编号
	 * @param roomcode2 房间唯一ID
	 * @param locktype 门锁类型 1网关锁 2华为 3电信 4移动
	 * @param roomimei IMEI
	 * @param timeout 有效时间
	 * @param psw 密码授权实体
	 * @param callbackurl 回调地址
	 * @return
	 */
	public SendResult saveTotalUnlockPsw(String gatewaycode,String gatewaycode2,String roomcode,String roomcode2,String locktype,String roomimei,Integer timeout,UnlockPsw psw,String callbackurl);
	/**
	 * 发送密码授权指令(合-批量)
	 * @param plist
	 * @return
	 */
	public SendResult<AuthResult> saveTotalUnlockPswList(List<AuthPsw> plist,Integer timeout,String callbackurl);
	/**
	 * 取消密码授权指令(合)
	 * @param gatewaycode 网关通讯ID
	 * @param gatewaycode2 网关唯一ID
	 * @param roomcode 房间编号
	 * @param roomcode2 房间唯一ID
	 * @param roomimei IMEI
	 * @param locktype 门锁类型 1网关锁 2华为 3电信 4移动
	 * @param dpsw 密码授权实体
	 * @param timeout 有效时间
	 * @param callbackurl 回调地址
	 * @return
	 */
	public SendResult delTotalUnlockpsw(String gatewaycode,String gatewaycode2,String roomcode,String roomcode2,String roomimei,String locktype,DelUnlockPsw dpsw,Integer timeout,String callbackurl);
	/**
	 * 取消密码授权指令(合-批量)
	 * @param delist
	 * @return
	 */
	public SendResult<List<PswsResult>> delTotalUnlockpswList(List<AuthDelPsw> delist,Integer timeout,String callbackurl);

	/**
	 * 发送卡片授权指令(合)
	 * @param gatewaycode 网关通讯ID
	 * @param gatewaycode2 网关唯一ID
	 * @param roomcode 房间编号
	 * @param roomcode2	房间唯一ID
	 * @param roomimei IMEI
	 * @param locktype 门锁类型
	 * @param rc 卡片授权实体
	 * @param timeout 超时时间
	 * @param callbackurl 回调地址
	 * @return
	 */
	public SendResult saveTotalRoomCard(String gatewaycode,String gatewaycode2,String roomcode,String roomcode2,String roomimei,String locktype,RoomCard rc,Integer timeout,String callbackurl);
	/**
	 * 发送卡片授权指令(合-批量)
	 * @param clist
	 * @return
	 */
	public SendResult<AuthResult> saveTotalRoomCardList(List<AuthCard> clist,Integer timeout, String callbackurl);

	/**
	 * 删除卡片授权指令(合)
	 * @param gatewaycode  网关通讯ID
	 * @param gatewaycode2 网关
	 * @param roomcode
	 * @param roomcode2
	 * @param roomimei
	 * @param locktype
	 * @param cardtype
	 * @param cardcode
	 * @param timeout
	 * @param callbackurl
	 * @return
	 */
	public SendResult delTotalRoomCard(String gatewaycode,String gatewaycode2,String roomcode,String roomcode2,String roomimei,String locktype,String cardtype,String cardcode,Integer timeout,String callbackurl);
	/**
	 * 删除卡片授权指令(合-批量)
	 * @param dclist
	 * @return
	 */
	public SendResult<List<DelCardsResult>> delTotalRoomCardList(List<AuthDelCard> dclist,Integer timeout,String callbackurl);
	
	/**
	 * 发送指纹授权指令(合)
	 * @param gatewaycode
	 * @param gatewaycode2
	 * @param roomcode
	 * @param roomcode2
	 * @param roomimei
	 * @param locktype
	 * @param rf
	 * @param timeout
	 * @param callbackurl
	 * @return
	 */
	public SendResult saveTotalRoomFinger(String gatewaycode,String gatewaycode2,String roomcode,String roomcode2,String roomimei,String locktype,RoomFinger rf,Integer timeout,String callbackurl);
	/**
	 *  发送指纹授权指令(合-批量)
	 * @param rflist
	 * @return
	 */
	public SendResult<AuthResult> saveTotalRoomFingerList(List<AuthFinger> flist,Integer timeout,String callbackurl);
	/**
	 *  删除指纹授权指令(合)
	 * @param gatewaycode
	 * @param gatewaycode2
	 * @param roomid
	 * @param roomcode
	 * @param roomcode2
	 * @param roomimei
	 * @param locktype
	 * @param rflist
	 * @param timeout
	 * @param callbackurl
	 * @return
	 */
	public SendResult<DelFingersResult> delTotalRoomFinger(String gatewaycode,String gatewaycode2,String roomid,String roomcode,String roomcode2,String roomimei,String locktype,List<DelRoomFinger> rflist,Integer timeout,String callbackurl);
	/**
	 *  删除指纹授权指令(合-批量)
	 * @param dflist
	 * @return
	 */
	public SendResult<List<DelFingersResult>> delTotalRoomFingerList(List<AuthDelFinger> dflist,Integer timeout,String callbackurl);
	
	/**
	 * 批量修改门锁功率等级
	 */
	public SendResult<List<PowResult>> updateRoompowList(List<Roompow> powlist,Integer timeout,String callbackurl);
	
	/**
	 * 批量门锁状态指令    NB锁不支持
	 * @param rlist 房间信息
	 * @param timeout 有效时间（单位s）
	 * @param callbackurl 回调地址（接收指令发送结果）
	 * @return 指令发送结果SendResult
	 */
	public SendResult<List<RoomResult>> getLockStatusList(List<Room> rlist,Integer timeout,String callbackurl);
	/**
	 * 批量门锁记录读取指令 (不含NB锁)
	 * @param rlist 房间信息
	 * @param timeout 有效时间（单位s）
	 * @param callbackurl 回调地址（接收指令发送结果）
	 * @return 指令发送结果SendResult
	 */
	public SendResult<List<RoomResult>> readLockRecordList(List<Room> rlist,Integer timeout,String callbackurl);
	
	
	/**
	 * 注册NB锁
	
	 * @return
	 */
	public SendResult<RegistNb> registerDevice(String locktype,String roomimei,String lockname,String roomimsi); 
	/**
	 * 修改NB锁
	 * @param roomlocation
	 * @param roomname
	 * @param roomimsi
	 * @param roomtxtype
	 * @param roomimei
	 * @param timeout
	 * @param callbackurl
	 * @return
	 */
	public SendResult updateDevice(String locktype,String roomimei,String roomdeviceid,String lockname,String roomimsi); 
	
	/**
	 * 删除NB锁
	 * @param roomdeviceid
	 * @param timeout
	 * @param callbackurl
	 * @return
	 */
	public SendResult delDevice(String roomdeviceid,String roomtxtype,Integer timeout ,String callbackurl); 
	
	/**
	 * 网关记录回调配置
	 * @param gatewaycode2  网关唯一ID
	 * @param url  回调地址
	 * @return
	 */
	public SendResult setGatewayRecordBackUrl(String url);
	/**
	 * 授权卡授权回调设置
	 * @param locktype
	 * @param gatewaycode2
	 * @param roomcode2
	 * @param url
	 * @return
	 */
	public SendResult setCardAuthBackUrl(String url);
	/**
	 * 网关-服务器通路测试回调设置
	 * @param gatewaycode2
	 * @param url
	 * @return
	 */
	public SendResult setInstallTestBackUrl(String url);
	/**
	 * 指纹特征码上传回调设置
	 * @param gatewaycode2
	 * @param url
	 * @return
	 */
	public SendResult setFingerContentBackUrl(String url);
	/**
	 * NB锁门锁记录回调设置
	 * @param roomcode2
	 * @param url
	 * @return
	 */
	public SendResult setNbLockRecordBackUrl(String url);
	
	/**
	 * 网关记录回调获取
	 * @param gatewaycode2  网关唯一ID
	 * @param url  回调地址
	 * @return
	 */
	public SendResult<String> getGatewayRecordBackUrl();
	/**
	 * 授权卡授权回调获取
	 * @param locktype
	 * @param gatewaycode2
	 * @param roomcode2
	 * @param url
	 * @return
	 */
	public SendResult<String> getCardAuthBackUrl();
	/**
	 * 网关-服务器通路测试回调获取
	 * @param gatewaycode2
	 * @param url
	 * @return
	 */
	public SendResult<String> getInstallTestBackUrl();
	/**
	 * 指纹特征码上传回调获取
	 * @param gatewaycode2
	 * @param url
	 * @return
	 */
	public SendResult<String> getFingerContentBackUrl();
	/**
	 * NB锁门锁记录回调获取
	 * @param roomcode2
	 * @param url
	 * @return
	 */
	public SendResult<String> getNbLockRecordBackUrl();
	
	/**
	 * 设置NB锁房间信息的回调地址
	 * @param roomcode2
	 * @param url
	 * @return
	 */
	public SendResult setNbRoomParamasBackUrl(String url);
	/**
	 * 获取NB锁房间信息的回调地址
	 * @param roomcode2
	 * @param url
	 * @return
	 */
	public SendResult getNbRoomParamasBackUrl();
	
	/**
	 * 添加日志
	 * @return
	 */
	public SendResult saveLog(List<Log> loglist);
	/**
	 * 设置关闭网关的回调地址
	 * @param url
	 * @return
	 */
	public SendResult setClosegatewaybackUrl(String url);
	/**
	 * 设置超时的回调地址
	 * @param url
	 * @return
	 */
	public SendResult setIdLebackUrl(String url);
	/**
	 * 获取关闭网关的回调地址
	 */
	public SendResult getClosegatewaybackUrl(String url);
	/**
	 * 获取超时的回调地址
	 */
	public SendResult getIdLebackUrl(String url);
	
	
}
