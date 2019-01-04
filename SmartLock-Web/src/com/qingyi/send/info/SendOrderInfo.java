package com.qingyi.send.info;

import java.util.List;

import com.qingyi.model.Command;
import com.qingyi.model.DelUnlockPsw;
import com.qingyi.model.NBUnlockPsw;
import com.qingyi.model.Room;
import com.qingyi.model.RoomCard;
import com.qingyi.model.RoomCardxzsx;
import com.qingyi.model.RoomFinger;
import com.qingyi.model.RoomFingerxzsx;
import com.qingyi.model.SendResult;
import com.qingyi.model.UnlockPsw;

public interface SendOrderInfo {
	/**
	 * 查询门锁状态指令    
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
	 * 发送门锁记录读取指令
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
	public SendResult delRoomCard(String gatewaycode,String gatewaycode2,String roomcode,String cardtype,String cardcode,Integer timeout,String callbackurl);
	
	/**
	 * 删除指纹授权指令
	 * @param gatewaycode 门锁归属网关通讯ID
	 * @param gatewaycode2 门锁归属网关唯一ID
	 * @param roomcode 房间编号
	 * @param fingercode 指纹编号
	 * @param timeout 有效时间（单位s）
	 * @param callbackurl 回调地址（接收指令发送结果）
	 * @return 指令发送结果SendResult
	 */
	public SendResult delRoomFinger(String gatewaycode,String gatewaycode2,String roomcode,String fingercode,Integer timeout,String callbackurl);
	
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
	public SendResult updateRoomCardxzsx(String gatewaycode,String gatewaycode2,String roomcode,RoomCardxzsx xzsx,Integer timeout,String callbackurl); 
	
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
	public SendResult updateRoomFingerxzsx(String gatewaycode,String gatewaycode2,String roomcode,RoomFingerxzsx xzsx,Integer timeout,String callbackurl);
	//NB锁-------------------------------------------------------------------------------------------------------------------------------------------------------------
	/**
	 * 发送密码授权指令
	 * @param roomcode2 门锁唯一ID
	 * @param psw NB锁密码授权实体类
	 * @param timeout 有效时间（单位s）
	 * @param callbackurl 回调地址（接收指令发送结果）
	 * @return 指令发送结果SendResult
	 */
	public SendResult saveUnlockPswNB(String roomcode2,NBUnlockPsw psw,Integer timeout,String callbackurl);
	/**
	 * 取消密码授权指令
	 * @param roomcode 门锁唯一ID
	 * @param dpsw 密码授权对象
	 * @param timeout 有效时间（单位s）
	 * @param callbackurl 回调地址（接收指令发送结果）
	 * @return
	 */
	public SendResult delUnlockpswNB(String roomcode2,NBUnlockPsw psw,Integer timeout,String callbackurl);

	/**
	 * 重载卡片白名单 NB
	 * @param roomcode2 门锁唯一ID
	 * @param roomimei IMEI
	 * @param roomtxtype  锁的种类 2华为 3电信 4移动
	 * @param xzsx 白名单实体类  orderid SlRoomcard 主键
	 * @param timeout
	 * @param callbackurl
	 * @return
	 */
	public SendResult updateRoomCardxzsxNB(String roomcode2,String roomimei,String roomtxtype,RoomCardxzsx xzsx,Integer timeout,String callbackurl); 
	/**
	    * 重载指纹白名单 NB
	 * @param roomcode2 门锁唯一ID
	 * @param roomimei IMEI
	 * @param roomtxtype 锁的种类 2华为 3电信 4移动
	 * @param fingercode 指纹编号
	 * @param fingercontent 指纹内容
	 * @param orderid SlRoomfinger类的ID 
	 * @param timeout
	 * @param callbackurl
	 * @return
	 */
	public SendResult updateRoomFingerxzsxNB(String roomcode2,String roomimei,String roomtxtype,String fingercode,String fingercontent,String orderid,Integer timeout,String callbackurl); 
	/**
	 * 删除指纹授权 NB
	 * @param roomcode2
	 * @param roomimei
	 * @param roomtxtype
	 * @param rf   orderid SlRoomfinger 主键
	 * @param timeout
	 * @param callbackurl
	 * @return
	 */
	public SendResult delRoomFingerNB(String roomcode2,String roomimei,String roomtxtype,RoomFingerxzsx rf,Integer timeout,String callbackurl); 
	/**
	 * 集群指纹同步NB
	 * @param roomcode2
	 * @param roomimei
	 * @param roomtxtype
	 * @param rflist
	 * @param timeout
	 * @param callbackurl
	 * @return
	 */
	public SendResult syscFingerNB(String roomcode2,String roomimei,String roomtxtype,List<RoomFinger> rflist,Integer timeout,String callbackurl); 
	/**
	 * 集群卡片同步NB
	 * @param roomcode2
	 * @param roomimei
	 * @param roomtxtype
	 * @param rflist
	 * @param pswlist
	 * @param timeout
	 * @param callbackurl
	 * @return
	 */
	public SendResult syscCardNB(String roomcode2,String roomimei,String roomtxtype,List<RoomCard> rclist,List<UnlockPsw> pswlist,Integer timeout,String callbackurl); 
	/**
	 * 卡片授权
	 * @param roomcode2
	 * @param roomimei
	 * @param roomtxtype
	 * @param rcid slRoomcard 主键
	 * @param rc  卡片类型（开门卡/管理卡/授权卡/身份证)
	 * @param timeout
	 * @param callbackurl
	 * @return
	 */
	public SendResult saveRoomCardNB(String roomcode2,String roomimei,String roomtxtype,String rcid,RoomCardxzsx rc,Integer timeout,String callbackurl);
	/**
	 * 删除卡片授权
	 * @param roomcode2
	 * @param roomimei
	 * @param roomtxtype
	 * @param rcid
	 * @param rc
	 * @param timeout
	 * @param callbackurl
	 * @return
	 */
	public SendResult delRoomCardNB(String roomcode2,String roomimei,String roomtxtype,String rcid,RoomCardxzsx rc,Integer timeout,String callbackurl);
	/**
	 * 远程开门   门锁复位
	 * @param room
	 * @param paramvalue
	 * @param duedate_1
	 * @param itstate_isopen
	 * @param itstate_reset
	 * @param command
	 * @param timeout
	 * @param callbackurl
	 * @return
	 */
	public SendResult saveNblog(Room room,String paramvalue,String duedate_1,String itstate_isopen,String itstate_reset,Command command,String timeout, String callbackurl);
	/**
	 * 
	 * @param roomcode2
	 * @param command
	 * @param timeout
	 * @param callbackurl
	 * @return
	 */
	public SendResult saveNblog1(String roomcode2,String command,String timeout, String callbackurl);
	/**
	 * NB锁记录
	 * @param roomid
	 * @param command {"Head":"CCCC","messageId":"01C2","length":"0033","ID":"1901033037","IMEI":"8677260308645590","messageCnt":"00000001","time":"000000112339","Null":"0000000000000000000000000000000000000000","check":"F79B"}
	 * @param timeout
	 * @param callbackurl
	 * @return
	 */
	public SendResult NBrecords(String roomid,String command,String timeout, String callbackurl);
	/**
	 * 
	 * @param id
	 * @param deviceId
	 * @param timeout
	 * @param callbackurl
	 * @return
	 */
	public SendResult addDXOnline(String id ,String deviceId,String timeout ,String callbackurl); 
}
