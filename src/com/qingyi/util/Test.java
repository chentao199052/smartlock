package com.qingyi.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qingyi.model.Command;
import com.qingyi.model.NBUnlockPsw;
import com.qingyi.model.Room;
import com.qingyi.model.RoomCard;
import com.qingyi.model.RoomCardxzsx;
import com.qingyi.model.RoomFinger;
import com.qingyi.model.RoomFingerxzsx;
import com.qingyi.model.SendResult;
import com.qingyi.model.UnlockPsw;
import com.qingyi.nbsend.info.NBSendOrderInfo;
import com.qingyi.nbsend.info.impl.NBSendOrderImpl;
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
//		RoomCardxzsx xz=new RoomCardxzsx("开门卡", "00000ca9", "0000003", "1haolou_3", "-1",
//				"2", "123456", "-1", "-1", "00:00", "23:59", "1853");
//		
//		SendOrderInfo info=new SendOrderImpl();
//		
//		SendResult result = info.updateRoomCardxzsxNB("1828001358","867726030863346","2",xz, 100, "www.ci.com");
//		System.out.println(result.getResultCode() +"-"+result.getResultMsg()+"-"+result.getOrderId());
	//重载指纹白名单 NB
//		SendOrderInfo info=new SendOrderImpl();
//		String s="dd0217ff843201c8060b02c30c2908c88c45024f8d8990070cda11140dd213110768141608d7c104143802d2971204669d2008e6a1160a6e4050a40e08f2a74705d8283b0560294e0258c0cc800d04441b2d1a60201c0d6d840f034b5cc91d1605e41e2d0d63a12203e300000000c194000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000dbdfcb79edbebc78867776070000000000000000550053000b0a4347474747474b4b4b524747474747474b4b4b4f4a4a4b4b4b4b4b4b4f4f52524f4f4f4f4f4f4f4f665e5b57535353534f4f6b6b635f5b575353534f6f6f6b63635b5753535373736f6b675f57575353ff77736b67635b575757ff7b736f67635f5b5757ffff736f6b675f5b57ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff209d0000000000000000000000000000808a04700e45e5bf410b00a6";
//		SendResult result=info.updateRoomFingerxzsxNB("1828001358", "867726030863346", "2", "00000009", s, "18556", 100, "www.ci.com");
//		System.out.println(result.getResultCode() +"-"+result.getResultMsg()+"-"+result.getOrderId());
		//System.out.println("2".matches("^[1-4]{1}$"));
	//删除指纹授权 NB
//		RoomFingerxzsx sx=new RoomFingerxzsx("1900111", "00000009", s, "-1", "1", "00:00", "00:29", "1");
//		SendOrderInfo info=new SendOrderImpl();
//		SendResult result=info.delRoomFingerNB("1828001358", "867726030863346", "2", sx, 100, "www.ci.com");
//		System.out.println(result.getResultCode() +"-"+result.getResultMsg()+"-"+result.getOrderId());
	//集群指纹同步NB
//		SendOrderInfo info=new SendOrderImpl();
//		List<RoomFinger> rflist=new ArrayList<RoomFinger>();
//		RoomFinger rf=new RoomFinger("00000009", s, "-1", "00:12", "12:54", "-1", "1");
//		rflist.add(rf);
//		SendResult result=info.syscFingerNB("1828001358", "867726030863346", "2", rflist, 100, "www.ci.com");
//		System.out.println(result.getResultCode() +"-"+result.getResultMsg()+"-"+result.getOrderId());
	//集群卡片同步NB
//		SendOrderInfo info=new SendOrderImpl();
//		List<RoomCard> rclist=new ArrayList<RoomCard>();
//		RoomCard card=new RoomCard("开门卡", "00000ca9", "-1", "00:45","21:12", "10");
//		List<UnlockPsw> pswlist=new ArrayList<UnlockPsw>();
//		UnlockPsw psw=new UnlockPsw("123456", "10", "-1", "00:12", "22:11");
//		rclist.add(card);
//		pswlist.add(psw);
//		SendResult result= info.syscCardNB("1828001358", "867726030863346", "2", rclist, pswlist, 100, "www.ss.com");
//		System.out.println(result.getResultCode() +"-"+result.getResultMsg()+"-"+result.getOrderId());
	//卡片授权
//		RoomCardxzsx xz=new RoomCardxzsx("开门卡", "00000ca9", "0000003", "1haolou_3", "-1",
//				"2", "123456", "-1", "-1", "00:00", "23:59", "1853");
//		SendOrderInfo info=new SendOrderImpl();
//		SendResult result= info.saveRoomCardNB("1828001358", "867726030863346", "3", "1854", xz, 200, "www.ss.com");
//		System.out.println(result.getResultCode() +"-"+result.getResultMsg()+"-"+result.getOrderId());
	//删除卡片授权
//		SendOrderInfo info=new SendOrderImpl();
//		SendResult result= info.delRoomCardNB("1828001358", "867726030863346", "3", "1854", xz, 200, "www.ss.com");
//		System.out.println(result.getResultCode() +"--"+result.getResultMsg()+"-"+result.getOrderId());
	//远程开门   门锁复位
//		NBSendOrderInfo info=new NBSendOrderImpl();
//		Room room=new Room("1828001358", "0", "1", "1");
//		Command command=new Command("1444", "867726030863346", "00000012", "190104135921");
//		SendResult result= info.saveNblog(room,"2","2019-01-04 13:54:20","0","1",command,200,"www.ss.com");
//		//                      saveNblog(Room room,String paramvalue,String duedate_1,String itstate_isopen,String itstate_reset,Command command,String timeout, String callbackurl);
//		System.out.println(result.getResultCode() +"--"+result.getResultMsg()+"-"+result.getOrderId());
	//saveNblog1
//		NBSendOrderInfo info=new NBSendOrderImpl();
//		String ss="{\"Head\":\"CCCC\",\"messageId\":\"01C1\",\"length\":\"0033\",\"ID\":\"1901033034\",\"IMEI\":\"8677260308645420\",\"messageCnt\":\"00000010\",\"time\":\"190104135907\",\"Null\":\"AA00000000000000000000000000000000000000\",\"check\":\"5FCB\"}";
//		SendResult result=info.saveNblog1("1828001358", ss, 200, "www.ss.com");
//		System.out.println(result.getResultCode() +"--"+result.getResultMsg()+"-"+result.getOrderId());
	//NB锁记录
//		NBSendOrderInfo info=new NBSendOrderImpl();
//		String ss="asadwffwafssssssssssdddddddddddddddddddddddddddddddddddddddddddddddddddddddddfffffffffffffffffffffffffff";
//		SendResult result=info.NBrecords("1828", "01",ss, 200, "www.ss.com");
//		System.out.println(result.getResultCode() +"--"+result.getResultMsg()+"-"+result.getOrderId());
	String ss="{\"old\":\"1,2,3,4\",\"order\":\"1,5,4\",\"ceshi\" : {\"sa\" : as,\"as\" : \"s,a\"} }";
	//Map map = StringTools.stringToMap(ss);
	ss=ss.substring(1,ss.length()-1);
	String[] s=ss.split(",");
	Map map =new HashMap();
	outter:
	for(int i=0; i<s.length ;i++) {
		System.out.println(s[i]);
		if(s[i].contains(":") && ! s[i].contains("{")) {
		String[] str=s[i].split(":");
		String key=str[0].replace("\"", "").trim();
		map.put(key, str[1].replace("\"", "").trim());
		intter:
		for(int j=i+1;j<s.length;j++) {
			String r=s[j];
			if(!r.contains(":")) {
				String va=map.get(key).toString()+","+r.replace("\"", "");
				map.put(key, va.trim());
			}else {
				continue outter;
			}
		  }
		}else if(s[i].contains(":") && s[i].contains("{")) {
			String[] sss=s[i].split(":");
			String key=sss[0].replace("\"","").trim();
			String value=s[i].substring(s[i].indexOf("{"),s[i].length());
//			for()
		}
	}
//	System.out.println(map.get("old"));
//	System.out.println(map.get("order"));
//	System.out.println(map.get("ceshi"));
//	Map<String,String> map=new HashMap<String,String>();
//	String ss1=ss.substring(1, ss.length()-1);
//		for(int i=0;) {}
	}
}
