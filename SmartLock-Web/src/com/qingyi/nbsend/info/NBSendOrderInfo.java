package com.qingyi.nbsend.info;

import java.util.List;

import com.qingyi.model.Command;
import com.qingyi.model.NBUnlockPsw;
import com.qingyi.model.Room;
import com.qingyi.model.RoomCard;
import com.qingyi.model.RoomCardxzsx;
import com.qingyi.model.RoomFinger;
import com.qingyi.model.RoomFingerxzsx;
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
		 * @param paramvalue  SlSystemparam spa = (SlSystemparam)dxDao.getObjectByStringid("sleeptime", SlSystemparam.class);  spa.getParamvalue()
		 * @param duedate_1  yyyy-MM-dd HH:mm:ss
		 * @param itstate_isopen
		 * @param itstate_reset
		 * @param command
		 * @param timeout
		 * @param callbackurl
		 * @return
		 */
		public SendResult saveNblog(Room room,String paramvalue,String duedate_1,String itstate_isopen,String itstate_reset,Command command,Integer timeout, String callbackurl);
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
		 * NB锁记录
		 * @param roomid
		 * @param command
		 * @param timeout
		 * @param callbackurl
		 * @return
		 */
		public SendResult NBrecords(String roomid,String recordNum,String records,Integer timeout, String callbackurl);
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
