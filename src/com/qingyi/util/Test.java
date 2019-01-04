package com.qingyi.util;

import com.qingyi.model.NBUnlockPsw;
import com.qingyi.model.SendResult;
import com.qingyi.send.info.SendOrderInfo;
import com.qingyi.send.info.impl.SendOrderImpl;

public class Test {
	public static void main(String[] args) {
		//发送密码授权指令
//		SendOrderInfo info=new SendOrderImpl();
//		NBUnlockPsw psw=new NBUnlockPsw();
//		psw.setRoomimei("867726030863346");
//		psw.setCount("-1");
//		psw.setEdate("1901301630");
//		psw.setPass("123456");
//		psw.setRoomtxtype("2");
//		psw.setUnlocketime("23:59");
//		psw.setUnlockstime("00:00");
//		SendResult result = info.saveUnlockPswNB("1828001358", psw, 100, "www.ci.com");
//		System.out.println(result.getResultCode() +"-"+result.getResultMsg()+"-"+result.getOrderId());
	//取消密码授权指令
//		SendOrderInfo info=new SendOrderImpl();
//		NBUnlockPsw psw=new NBUnlockPsw();
//		psw.setRoomimei("867726030863346");
//		psw.setCount("-1");
//		psw.setEdate("1901301630");
//		psw.setPass("123456");
//		psw.setRoomtxtype("2");
//		psw.setUnlocketime("23:59");
//		psw.setUnlockstime("00:00");
//		SendResult result = info.delUnlockpswNB("1828001358", psw, 100, "www.ci.com");
//		System.out.println(result.getResultCode() +"-"+result.getResultMsg()+"-"+result.getOrderId());
	//重载卡片白名单 NB
		SendOrderInfo info=new SendOrderImpl();
		SendResult result = info.updateRoomCardxzsxNB("1828001358", , 100, "www.ci.com");
		System.out.println(result.getResultCode() +"-"+result.getResultMsg()+"-"+result.getOrderId());
	}
}
