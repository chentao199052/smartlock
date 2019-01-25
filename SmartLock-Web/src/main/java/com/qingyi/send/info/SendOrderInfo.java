package com.qingyi.send.info;

import java.util.List;
import com.qingyi.model.AuthCard;
import com.qingyi.model.AuthDelCard;
import com.qingyi.model.AuthDelFinger;
import com.qingyi.model.AuthDelPsw;
import com.qingyi.model.AuthFinger;
import com.qingyi.model.AuthPsw;
import com.qingyi.model.AuthRestAndOpen;
import com.qingyi.model.AuthSync;
import com.qingyi.model.AuthTotal;
import com.qingyi.model.Command;
import com.qingyi.model.DelRoomFinger;
import com.qingyi.model.DelUnlockPsw;
import com.qingyi.model.Room;
import com.qingyi.model.RoomCard;
import com.qingyi.model.RoomFinger;
import com.qingyi.model.Roompow;
import com.qingyi.model.SendResult;
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
	 * 发送门锁复位指令
	 * @param gatewaycode 门锁归属网关通讯ID
	 * @param gatewaycode2 门锁归属网关唯一ID
	 * @param roomcode 房间编号
	 * @param timeout 有效时间（单位s）
	 * @param callbackurl 回调地址（接收指令发送结果）
	 * @return 指令发送结果SendResult
	 */
	public SendResult saveLockReset(String gatewaycode,String gatewaycode2,String roomcode,Integer timeout,String callbackurl);
	
	/**
	 * 发送门锁远程开门指令
	 * @param gatewaycode 门锁归属网关通讯ID
	 * @param gatewaycode2 门锁归属网关唯一ID
	 * @param roomcode 房间编号
	 * @param timeout 有效时间（单位s）
	 * @param callbackurl 回调地址（接收指令发送结果）
	 * @return 指令发送结果SendResult
	 */
	public SendResult saveLockRemoteOpen(String gatewaycode,String gatewaycode2,String roomcode,Integer timeout,String callbackurl);
	
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
	 * 修改门锁强锁/非强锁模式
	 * @param gatewaycode 门锁归属网关通讯ID
	 * @param gatewaycode2  门锁归属网关唯一ID
	 * @param roomcode 房间编号
	 * @param type 1强制锁门 2非强制锁门
	 * @param timeout 有效时间（单位s）
	 * @param callbackurl 回调地址（接收指令发送结果）
	 * @return 指令发送结果SendResult
	 */
	public SendResult updateRoomForcelock(String gatewaycode,String gatewaycode2,String roomcode,Integer type,Integer timeout,String callbackurl);
	
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
	 * 修改门锁常开/常闭模式
	 * @param gatewaycode 门锁归属网关通讯ID
	 * @param gatewaycode2  门锁归属网关唯一ID
	 * @param roomcode 房间编号
	 * @param type 1常开，2常闭
	 * @param timeout 有效时间（单位s）
	 * @param callbackurl 回调地址（接收指令发送结果）
	 * @return 指令发送结果SendResult
	 */
	public SendResult updateRoomWorkmode(String gatewaycode,String gatewaycode2,String roomcode,Integer type,Integer timeout,String callbackurl);
	
	/**
	 * 修改门锁联网模式
	 * @param gatewaycode 门锁归属网关通讯ID
	 * @param gatewaycode2  门锁归属网关唯一ID
	 * @param roomcode 房间编号
	 * @param type 1允许离线授权，2禁止离线授权
	 * @param timeout 有效时间（单位s）
	 * @param callbackurl 回调地址（接收指令发送结果）
	 * @return 指令发送结果SendResult
	 */
	public SendResult updateRoomNetmode(String gatewaycode,String gatewaycode2,String roomcode,Integer type,Integer timeout,String callbackurl);
	
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
	public SendResult readFingerMachine(String fpcode,String type);
	
	
	
	/**
	 * 指纹机状态(查询是否可录入指纹)
	 * @param fpcode  指纹机唯一ID
	 * @param sifid  SlIntimefingerprint 的Id  
	 * @param timeout
	 * @param callbackurl
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
	 * @param gatewaycode
	 * @param gatewaycode2
	 * @param timeout
	 * @param callbackurl
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
	 * 发送密码授权指令
	 * @param gatewaycode 门锁归属网关通讯ID
	 * @param gatewaycode2  门锁归属网关唯一ID
	 * @param roomcode 房间编号
	 * @param timeout 有效时间（单位s）
	 * @param psw 密码授权对象
	 * @param callbackurl 回调地址（接收指令发送结果）
	 * @return 指令发送结果SendResult
	 */
	public SendResult saveUnlockPsw(String gatewaycode,String gatewaycode2,String roomcode,Integer timeout,UnlockPsw psw,String callbackurl);
	
	/**
	 * 取消密码授权指令
	 * @param gatewaycode 门锁归属网关通讯ID
	 * @param gatewaycode2  门锁归属网关唯一ID
	 * @param roomcode 房间编号
	 * @param dpsw 取消密码授权对象
	 * @param timeout 有效时间（单位s）
	 * @param callbackurl 回调地址（接收指令发送结果）
	 * @return
	 */
	public SendResult delUnlockpsw(String gatewaycode,String gatewaycode2,String roomcode,DelUnlockPsw dpsw,Integer timeout,String callbackurl);
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
	 * 发送卡片授权指令
	 * @param gatewaycode 门锁归属网关通讯ID
	 * @param gatewaycode2 门锁归属网关唯一ID
	 * @param roomcode 房间编号
	 * @param rc 卡片授权实体 cardtype 卡片类型（开门卡/管理卡/授权卡/身份证）
	 * @param timeout 有效时间（单位s）
	 * @param callbackurl 回调地址（接收指令发送结果）
	 * @return 指令发送结果SendResult
	 */
	public SendResult saveRoomCard(String gatewaycode,String gatewaycode2,String roomcode,RoomCard rc,Integer timeout,String callbackurl);
	
	/**
	 * 发送指纹授权指令
	 * @param gatewaycode 门锁归属网关通讯ID
	 * @param gatewaycode2 门锁归属网关唯一ID
	 * @param roomcode 房间编号
	 * @param rf 指纹授权实体
	 * @param timeout 有效时间（单位s）
	 * @param callbackurl 回调地址（接收指令发送结果）
	 * @return 指令发送结果SendResult
	 */
	public SendResult saveRoomFinger(String gatewaycode,String gatewaycode2,String roomcode,RoomFinger rf,Integer timeout,String callbackurl);
	
	/**
	 * 删除卡片授权指令
	 * @param gatewaycode 门锁归属网关通讯ID
	 * @param gatewaycode2 门锁归属网关唯一ID
	 * @param roomcode 房间编号
	 * @param cardcode
	 * @param timeout 有效时间（单位s）
	 * @param callbackurl 回调地址（接收指令发送结果）
	 * @return 指令发送结果SendResult
	 */
	public SendResult delRoomCard(String gatewaycode,String gatewaycode2,String roomcode,String rcid,String cardtype,String cardcode,Integer timeout,String callbackurl);
	
	
	
	/**
	 * 删除指纹授权指令
	 * @param gatewaycode 门锁归属网关通讯ID
	 * @param gatewaycode2 门锁归属网关唯一ID
	 * @param roomcode 房间编号
	 * @param fingercode 指纹编号
	 * @param timeout 有效时间（单位s）
	 * @param callbackurl 回调地址（接收指令发送结果）
	 * @return 指令发送结果SendResult
	 * 
	 * orderId 为 XXXX(orderId)-XXX(rfid)   
	 */
	public List<SendResult> delRoomFinger(String gatewaycode,String gatewaycode2,String roomid,String roomcode,List<DelRoomFinger> rflist,Integer timeout,String callbackurl);
	
	/**
	 * 发送房间卡片/密码授权同步指令
	 * @param gatewaycode 门锁归属网关通讯ID
	 * @param gatewaycode2 门锁归属网关唯一ID
	 * @param roomcode 房间编号
	 * @param rclist 卡片授权实体list
	 * @param pswlist 密码授权实体list
	 * @param timeout 有效时间（单位s）
	 * @param callbackurl 回调地址（接收指令发送结果）
	 * @return 指令发送结果SendResult
	 */
	public SendResult syncRoomCardAndPsw(String gatewaycode,String gatewaycode2,String roomcode,List<RoomCard> rclist,List<UnlockPsw> pswlist,Integer timeout,String callbackurl);
	

	/**
	 * 发送房间指纹授权同步指令
	 * @param gatewaycode 门锁归属网关通讯ID
	 * @param gatewaycode2  门锁归属网关唯一ID
	 * @param roomcode 房间编号
	 * @param rflist 指纹授权实体list
	 * @param timeout 有效时间（单位s）
	 * @param callbackurl  回调地址（接收指令发送结果）
	 * @return 指令发送结果SendResult
	 */
	public SendResult updateRoomFiger(String gatewaycode,String gatewaycode2,String roomcode,List<RoomFinger> rflist,Integer timeout,String callbackurl); 

	/**
	 * 重载卡片白名单
	 * @param gatewaycode
	 * @param gatewaycode2
	 * @param roomcode
	 * @param xzsx
	 * @param timeout
	 * @param callbackurl
	 * @return
	 */
	public SendResult updateRoomCardxzsx(String gatewaycode,String gatewaycode2,String roomcode,RoomCard card,Integer timeout,String callbackurl); 
	
	/**
	 * 重载指纹白名单
	 * @param gatewaycode
	 * @param gatewaycode2
	 * @param gatewayip
	 * @param roomcode
	 * @param xzsx
	 * @param timeout
	 * @param callbackurl
	 * @return
	 */
	public SendResult updateRoomFingerxzsx(String gatewaycode,String gatewaycode2,String roomcode,RoomFinger finger,Integer timeout,String callbackurl);
	
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
	public SendResult saveLotAuth(List<AuthCard> clist,List<AuthDelCard> dclist,List<AuthFinger> flist,List<AuthDelFinger> dflist,List<AuthPsw> plist,List<AuthDelPsw> dplist,Integer timeout,String callbackurl);
	
	/**
	 * 批量卡密/指纹授权同步
	 * @param clist 需同步的卡片列表
	 * @param plist 需同步的密码列表
	 * @param flist 需同步的指纹列表
	 * @return
	 */
	public SendResult saveAuthSync(List<AuthSync> synclist);
	/**
	 * 发送门锁复位指令(合)
	 * @param gatewaycode
	 * @param gatewaycode2
	 * @param roomcode
	 * @param roomcode2
	 * @param locktype
	 * @param timeout
	 * @param callbackurl
	 * @return
	 */
	public SendResult saveTotalReset(String gatewaycode,String gatewaycode2,String roomcode,String roomcode2,String locktype,Integer timeout,String callbackurl);
	/**
	 * 发送门锁复位指令(合-批量)
	 * @param rstlist
	 * @return
	 */
	public SendResult saveTotalResetList(List<AuthRestAndOpen> rstlist);

	/**
	 *  发送门锁远程开门指令(合)
	 * @param gatewaycode
	 * @param gatewaycode2
	 * @param roomcode
	 * @param roomcode2
	 * @param locktype
	 * @param timeout
	 * @param callbackurl
	 * @return
	 */
	public SendResult saveTotalOpen(String gatewaycode,String gatewaycode2,String roomcode,String roomcode2,String locktype,Integer timeout,String callbackurl);
	/**
	 * 发送门锁远程开门指令(合-批量)
	 * @param oplist
	 * @return
	 */
	public SendResult saveTotalOpenList(List<AuthRestAndOpen> oplist);
	/**
	 * 修改门锁强锁/非强锁模式（合)
	 * @param type  type 1强制锁门 2非强制锁门
	 * @param gatewaycode
	 * @param gatewaycode2
	 * @param roomcode
	 * @param roomcode2
	 * @param locktype
	 * @param timeout
	 * @param callbackurl
	 * @return
	 */
	public SendResult updateTotalForcelock(Integer type,String gatewaycode,String gatewaycode2,String roomcode,String roomcode2,String locktype,Integer timeout,String callbackurl);
	/**
	 * 修改门锁强锁/非强锁模式（合-批量）
	 * @param frlist
	 * @return
	 */
	public SendResult updateTotalForcelockList(List<AuthTotal> frlist);
	/**
	 * 修改门锁常开/常闭模式(合)
	 * @param type  type 1常开，2常闭
	 * @param gatewaycode
	 * @param gatewaycode2
	 * @param roomcode
	 * @param roomcode2
	 * @param locktype
	 * @param timeout
	 * @param callbackurl
	 * @return
	 */
	public SendResult updateTotalRoomWorkmode(Integer type,String gatewaycode,String gatewaycode2,String roomcode,String roomcode2,String locktype,Integer timeout,String callbackurl);
	/**
	 * 修改门锁常开/常闭模式(合-批量)
	 * @param wklist
	 * @return
	 */
	public SendResult updateTotalRoomWorkmodeList(List<AuthTotal> wklist);
	/**
	 * 修改门锁授权模式（合）
	 * @param type type 1允许离线授权，2禁止离线授权
	 * @param gatewaycode
	 * @param gatewaycode2
	 * @param roomcode
	 * @param roomcode2
	 * @param locktype
	 * @param timeout
	 * @param callbackurl
	 * @return
	 */
	public SendResult updateTotalRoomNetmode(Integer type,String gatewaycode,String gatewaycode2,String roomcode,String roomcode2 ,String locktype,Integer timeout,String callbackurl);
	/**
	 * 修改门锁授权模式（合-批量）
	 * @param ntlist
	 * @return
	 */
	public SendResult updateTotalRoomNetmodeList(List<AuthTotal> ntlist);

	/**
	 * 发送密码授权指令(合)
	 * @param gatewaycode
	 * @param gatewaycode2
	 * @param roomcode
	 * @param roomcode2
	 * @param locktype
	 * @param roomimei
	 * @param timeout
	 * @param psw
	 * @param callbackurl
	 * @return
	 */
	public SendResult saveTotalUnlockPsw(String gatewaycode,String gatewaycode2,String roomcode,String roomcode2,String locktype,String roomimei,Integer timeout,UnlockPsw psw,String callbackurl);
	/**
	 * 发送密码授权指令(合-批量)
	 * @param plist
	 * @return
	 */
	public SendResult saveTotalUnlockPswList(List<AuthPsw> plist);
	/**
	 * 取消密码授权指令(合)
	 * @param gatewaycode
	 * @param gatewaycode2
	 * @param roomcode
	 * @param roomcode2
	 * @param roomimei
	 * @param locktype
	 * @param dpsw
	 * @param timeout
	 * @param callbackurl
	 * @return
	 */
	public SendResult delTotalUnlockpsw(String gatewaycode,String gatewaycode2,String roomcode,String roomcode2,String roomimei,String locktype,DelUnlockPsw dpsw,Integer timeout,String callbackurl);
	/**
	 * 取消密码授权指令(合-批量)
	 * @param delist
	 * @return
	 */
	public SendResult delTotalUnlockpswList(List<AuthDelPsw> delist);

	/**
	 * 发送卡片授权指令(合)
	 * @param gatewaycode
	 * @param gatewaycode2
	 * @param roomcode
	 * @param roomcode2
	 * @param roomimei
	 * @param locktype
	 * @param rc
	 * @param timeout
	 * @param callbackurl
	 * @return
	 */
	public SendResult saveTotalRoomCard(String gatewaycode,String gatewaycode2,String roomcode,String roomcode2,String roomimei,String locktype,RoomCard rc,Integer timeout,String callbackurl);
	/**
	 * 发送卡片授权指令(合-批量)
	 * @param clist
	 * @return
	 */
	public SendResult saveTotalRoomCardList(List<AuthCard> clist);

	/**
	 * 删除卡片授权指令(合)
	 * @param gatewaycode
	 * @param gatewaycode2
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
	public SendResult delTotalRoomCardList(List<AuthDelCard> dclist);
	
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
	public SendResult saveTotalRoomFingerList(List<AuthFinger> rflist);
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
	public SendResult delTotalRoomFinger(String gatewaycode,String gatewaycode2,String roomid,String roomcode,String roomcode2,String roomimei,String locktype,List<DelRoomFinger> rflist,Integer timeout,String callbackurl);
	/**
	 *  删除指纹授权指令(合-批量)
	 * @param dflist
	 * @return
	 */
	public SendResult delTotalRoomFingerList(List<AuthDelFinger> dflist);
	
	/**
	 * 批量修改门锁功率等级
	 */
	public SendResult updateRoompowList(List<Roompow> powlist);
	
	/**
	 * 注册NB锁
	 * @param roomlocation  移动注册时必传
	 * @param roomname  移动注册时必传
	 * @param roomimsi  移动注册时必传
	 * @param roomtxtype
	 * @param roomimei
	 * @param timeout
	 * @param callbackurl
	 * @return
	 */
	public SendResult registerDevice(String locktype,String roomimei,String lockname,String roomimsi); 
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
	public SendResult updateDevice(String roomlocation,String roomname,String roomtxtype ,String roomimei,String roomdeviceid,Integer timeout ,String callbackurl); 
	
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
	public SendResult setGatewayRecordBackUrl(String gatewaycode2,String url);
	/**
	 * 授权卡授权回调设置
	 * @param locktype
	 * @param gatewaycode2
	 * @param roomcode2
	 * @param url
	 * @return
	 */
	public SendResult setCardAuthBackUrl(String locktype,String gatewayByCode2, String roomcode2,String url);
	/**
	 * 网关-服务器通路测试回调设置
	 * @param gatewaycode2
	 * @param url
	 * @return
	 */
	public SendResult setInstallTestBackUrl(String gatewaycode2,String url);
	/**
	 * 指纹特征码上传回调设置
	 * @param gatewaycode2
	 * @param url
	 * @return
	 */
	public SendResult setFingerContentBackUrl(String gatewaycode2,String url);
	/**
	 * NB锁门锁记录回调设置
	 * @param roomcode2
	 * @param url
	 * @return
	 */
	public SendResult setNbLockRecordBackUrl(String roomcode2,String url);
	
	/**
	 * 网关记录回调获取
	 * @param gatewaycode2  网关唯一ID
	 * @param url  回调地址
	 * @return
	 */
	public SendResult getGatewayRecordBackUrl(String gatewaycode2);
	/**
	 * 授权卡授权回调获取
	 * @param locktype
	 * @param gatewaycode2
	 * @param roomcode2
	 * @param url
	 * @return
	 */
	public SendResult getCardAuthBackUrl(String locktype,String gatewaycode2, String roomcode2);
	/**
	 * 网关-服务器通路测试回调获取
	 * @param gatewaycode2
	 * @param url
	 * @return
	 */
	public SendResult getInstallTestBackUrl(String gatewaycode2);
	/**
	 * 指纹特征码上传回调获取
	 * @param gatewaycode2
	 * @param url
	 * @return
	 */
	public SendResult getFingerContentBackUrl(String gatewaycode2);
	/**
	 * NB锁门锁记录回调获取
	 * @param roomcode2
	 * @param url
	 * @return
	 */
	public SendResult getNbLockRecordBackUrl(String roomcode2);
}
