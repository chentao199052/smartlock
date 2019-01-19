package com.qingyi.nbsend.info;

import java.util.List;

import com.qingyi.model.Card;
import com.qingyi.model.Command;
import com.qingyi.model.DelRoomCardxzsx;
import com.qingyi.model.DelRoomFinger;
import com.qingyi.model.Intimeorder;
import com.qingyi.model.Room;
import com.qingyi.model.RoomCard;
import com.qingyi.model.RoomFinger;
import com.qingyi.model.RoomNB;
import com.qingyi.model.SendResult;
import com.qingyi.model.UnlockPsw;

public interface NBSendOrderInfo {
		/**
		 * 发送密码授权指令
		 * @param roomcode2 门锁唯一ID
		 * @param psw NB锁密码授权实体类
		 * @param timeout 有效时间（单位s）
		 * @param callbackurl 回调地址（接收指令发送结果）
		 * @return 指令发送结果SendResult
		 */
		public SendResult saveUnlockPswNB(String roomcode2,String roomtxtype,String roomimei,UnlockPsw psw,Integer timeout,String callbackurl);
		/**
		 * 取消密码授权指令
		 * @param roomcode 门锁唯一ID
		 * @param dpsw 密码授权对象
		 * @param timeout 有效时间（单位s）
		 * @param callbackurl 回调地址（接收指令发送结果）
		 * @return
		 */
		public SendResult delUnlockpswNB(String roomcode2,String roomimei,String roomtxtype, UnlockPsw psw,Integer timeout,String callbackurl);

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
		public SendResult updateRoomCardxzsxNB(String roomcode2,String roomimei,String roomtxtype,RoomCard card,Integer timeout,String callbackurl); 
		/**
		    * 重载指纹白名单 NB
		 * @param roomcode2 门锁唯一ID
		 * @param roomimei IMEI
		 * @param roomtxtype 锁的种类 2华为 3电信 4移动
		 * @param fingercode 指纹编号
		 * @param fingercontent 指纹内容
		 * @param rfid SlRoomfinger类的ID 
		 * @param timeout
		 * @param callbackurl
		 * @return
		 */
		public SendResult updateRoomFingerxzsxNB(String roomcode2,String roomimei,String roomtxtype,String fingercode,String fingercontent,String rfid,Integer timeout,String callbackurl); 
		/**
		 * 指纹授权 NB
		 * @param roomcode2
		 * @param roomimei
		 * @param roomtxtype
		 * @param fingercode
		 * @param content
		 * @param timeout
		 * @param callbackurl
		 * @return
		 */
		public SendResult saveRoomFingerNB(String roomcode2,String roomimei,String roomtxtype,String fingercode,String content,Integer timeout,String callbackurl);
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
		public List<SendResult> delRoomFingerNB(String roomcode2,String roomimei,String roomtxtype,List<DelRoomFinger> rflist,Integer timeout,String callbackurl); 
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
		 * @param rc  卡片类型（开门卡/管理卡/授权卡/身份证)
		 * @param timeout
		 * @param callbackurl
		 * @return
		 */
		public SendResult saveRoomCardNB(String roomcode2,String roomimei,String roomtxtype,RoomCard rc,Integer timeout,String callbackurl);
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
		public SendResult delRoomCardNB(String roomcode2,String roomimei,String roomtxtype,DelRoomCardxzsx rc,Integer timeout,String callbackurl);
		/**
		 * 远程开门   门锁复位   常开，常闭设置   授权模式设置  强锁，解除强锁
		 * @param roomcode2 门锁唯一ID
		 * @param roomimei  IMEI
		 * @param roomtxtype 门锁类型
		 * @param ittype  指令类型
		 * @param itstate  指令状态
		 * @param timeout
		 * @param callbackurl
		 * @return
		 */
		public SendResult saveIntimenb(String roomcode2,String roomimei,String roomtxtype,String ittype,String itstate,String timeout, String callbackurl, String sysdate, String verify);
		/**
		 * 
		 * @param roomcode2
		 * @param json  一个json串
		 * @param timeout
		 * @param callbackurl
		 * @return
		 */
		public SendResult saveNblog1(String roomcode2,String json,Integer timeout, String callbackurl);
		/**
		 * 
		 * @param id
		 * @param deviceId
		 * @param timeout
		 * @param callbackurl
		 * @return
		 */
		//public SendResult addDXOnline(String id ,String deviceId,Integer timeout ,String callbackurl); 
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
		public SendResult registerDevice(String roomlocation,String roomname,String roomimsi,String roomtxtype ,String roomimei,Integer timeout ,String callbackurl); 
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
		 * 华为NB心跳（接收）
		 * @param body  推送的主体内容
		 * @param room  房间实体 
		 * @param valueSleep  NB锁睡眠时间	
		 * @param valueSpace  NB锁间隔时间
		 * @param itstateisopen  该房间最后一条远程开门指令下发状态
		 * @param itstatereset   该房间最后一条门锁复位指令下发状态
		 * @param card  被授权卡实体类  command   cardcode2
		 * @param card1   授权卡实体类       command   cardcode
		 * @param rccount     被授权卡实体类与房间 Slroomcard记录条数
		 * @param timeout
		 * @param callbackurl
		 * @return
		 */
		//public SendResult saveDeviceDataHw(String body,RoomNB room,String valueSleep,String valueSpace,String itstateisopen,String itstatereset,Card card,Card card1,Integer rccount,Integer timeout,String callbackurl);
		/**
		 * 华为（修改）
		 * @param body
		 * @param room
		 * @param card
		 * @param card2
		 * @param rccount
		 * @param timeout
		 * @param callbackurl
		 * @return
		 */
		//public SendResult updateCommandHw(String body,Integer timeout ,String callbackurl);
		
		/**
		 * 电信NB心跳（接收）
		 * @param body  推送的主体内容
		 * @param room  房间实体 
		 * @param valueSleep  NB锁间隔时间
		 * @param valueSpace  NB锁睡眠时间	
		 * @param itstateisopen  该房间最后一条远程开门指令下发状态
		 * @param itstatereset   该房间最后一条门锁复位指令下发状态
		 * @param card  被授权卡实体类
		 * @param card1   授权卡实体类
		 * @param rccount     被授权卡实体类与房间 Slroomcard记录条数
		 * @param timeout
		 * @param callbackurl
		 * @return
		 */
		//public SendResult saveDeviceDataDx(String body,RoomNB room,String valueSleep,String valueSpace,String itstateisopen,String itstatereset,Card card,Card card1,Integer rccount,Integer timeout,String callbackurl);
		/**
		 * 电信（修改）
		 * @param body
		 * @param room
		 * @param card
		 * @param card2
		 * @param rccount
		 * @param timeout
		 * @param callbackurl
		 * @return
		 */
		//public SendResult updateCommandDx(String body,Integer timeout ,String callbackurl);
		/**
		 * 移动NB心跳（接收）
		 * @param retmsg
		 * @param body  推送的主体内容
		 * @param room  房间实体 
		 * @param valueSleep  NB锁间隔时间
		 * @param valueSpace  NB锁睡眠时间	
		 * @param itstateisopen  该房间最后一条远程开门指令下发状态
		 * @param itstatereset   该房间最后一条门锁复位指令下发状态
		 * @param card  被授权卡实体类
		 * @param card1   授权卡实体类
		 * @param rccount     被授权卡实体类与房间 Slroomcard记录条数
		 * @param timeout
		 * @param callbackurl
		 * @return
		 */
		//public SendResult saveDeviceDataYd(String retmsg,String body,RoomNB room,String valueSleep,String valueSpace,String itstateisopen,String itstatereset,Card card,Card card1,Integer rccount,Integer timeout,String callbackurl);
		/**
		 * 移动（修改）
		 * @param body
		 * @param room
		 * @param card
		 * @param card2
		 * @param rccount
		 * @param timeout
		 * @param callbackurl
		 * @return
		 */
		//public SendResult updateCommandYd(String body,Integer timeout ,String callbackurl);
}
