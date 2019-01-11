package com.qingyi.nbsend.info.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.qingyi.model.Card;
import com.qingyi.model.Command;
import com.qingyi.model.NBUnlockPsw;
import com.qingyi.model.RegistNb;
import com.qingyi.model.Room;
import com.qingyi.model.RoomCard;
import com.qingyi.model.RoomCardxzsx;
import com.qingyi.model.RoomFinger;
import com.qingyi.model.RoomFingerxzsx;
import com.qingyi.model.RoomNB;
import com.qingyi.model.SendResult;
import com.qingyi.model.UnlockPsw;
import com.qingyi.nbsend.info.NBSendOrderInfo;
import com.qingyi.util.Constant;
import com.qingyi.util.HttpsUtil;
import com.qingyi.util.StringTools;

public class NBSendOrderImpl implements NBSendOrderInfo {
	private String baseurl;
	
	private String secret;

	public NBSendOrderImpl() {
		super();
		baseurl=Constant.BASEURL;
		secret=Constant.SECRET;
	}

	public NBSendOrderImpl(String baseurl, String secret) {
		super();
		this.baseurl = baseurl;
		this.secret = secret;
	}

	
		@Override
		public SendResult saveUnlockPswNB(String roomcode2, NBUnlockPsw psw, Integer timeout, String callbackurl) {
			// TODO Auto-generated method stub
			LinkedHashMap param=new LinkedHashMap();
			param.put("roomcode2", roomcode2);
			param.put("roomimei",psw.getRoomimei());
			param.put("pass", psw.getPass());
			param.put("count",psw.getCount());
			param.put("edate", psw.getEdate());
			param.put("roomtxtype",psw.getRoomtxtype());
			param.put("unlockstime", psw.getUnlockstime());
			param.put("unlocketime", psw.getUnlocketime());
			param.put("timeout", timeout);
			param.put("callbackurl", callbackurl);
			SendResult sr=StringTools.check(param);
			if("0".equals(sr.getResultCode())) {
				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"saveUnlockPswNB", secret, param);
				sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
			}
			return sr;
		}
		@Override
		public SendResult delUnlockpswNB(String roomcode2, NBUnlockPsw psw, Integer timeout, String callbackurl) {
			// TODO Auto-generated method stub
			LinkedHashMap param=new LinkedHashMap();
			param.put("roomcode2", roomcode2);
			param.put("roomimei",psw.getRoomimei());
			param.put("pass", psw.getPass());
			param.put("count",psw.getCount());
			param.put("edate", psw.getEdate());
			param.put("roomtxtype",psw.getRoomtxtype());
			param.put("unlockstime", psw.getUnlockstime());
			param.put("unlocketime", psw.getUnlocketime());
			param.put("timeout", timeout);
			param.put("callbackurl", callbackurl);
			SendResult sr=StringTools.check(param);
			if("0".equals(sr.getResultCode())) {
				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"delUnlockpswNB", secret, param);
				sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
			}
			return sr;
		}

		@Override
		public SendResult updateRoomCardxzsxNB(String roomcode2, String roomimei,String roomtxtype, RoomCardxzsx xzsx, Integer timeout,
				String callbackurl) {
			// TODO Auto-generated method stub
			LinkedHashMap param=new LinkedHashMap();
			param.put("roomcode2", roomcode2);
			param.put("roomimei",roomimei);
			param.put("roomtxtype",roomtxtype);
			param.put("cardtype",xzsx.getCardtype());
			param.put("cardcode",xzsx.getCardcode());
			param.put("cardedate",xzsx.getCardedate());
			param.put("cardunlocktype",xzsx.getCardunlocktype());
			param.put("personcode",xzsx.getPersoncode());
			param.put("personname",xzsx.getPersonname());
			param.put("empedate",xzsx.getEmpedate());
			param.put("rcusecount",xzsx.getRcusecount());
			param.put("openstime",xzsx.getOpenstime());
			param.put("openetime",xzsx.getOpenetime());
			param.put("orderid",xzsx.getRcid());
			param.put("cardpass",xzsx.getCardpass());
			param.put("timeout", timeout);
			param.put("callbackurl", callbackurl);
			SendResult sr=StringTools.check(param);
			if("0".equals(sr.getResultCode())) {
				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"updateRoomCardxzsxNB", secret, param);
				sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
			}
			return sr;
		}

		@Override
		public SendResult updateRoomFingerxzsxNB(String roomcode2, String roomimei, String roomtxtype, String fingercode,
				String fingercontent, String orderid, Integer timeout, String callbackurl) {
			LinkedHashMap param=new LinkedHashMap();
			param.put("roomcode2", roomcode2);
			param.put("roomimei",roomimei);
			param.put("roomtxtype",roomtxtype);
			param.put("fingercode",fingercode);
			param.put("fingercontent",fingercontent);
			param.put("orderid",orderid);
			param.put("timeout", timeout);
			param.put("callbackurl", callbackurl);
			SendResult sr=StringTools.check(param);
			if("0".equals(sr.getResultCode())) {
				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"updateRoomFingerxzsxNB", secret, param);
				sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
			}
			return sr;
		}

		@Override
		public SendResult delRoomFingerNB(String roomcode2, String roomimei, String roomtxtype, RoomFingerxzsx rf,
				Integer timeout, String callbackurl) {
			// TODO Auto-generated method stub
			LinkedHashMap param=new LinkedHashMap();
			param.put("roomcode2", roomcode2);
			param.put("roomimei",roomimei);
			param.put("roomtxtype",roomtxtype);
			param.put("fingercode",rf.getFingercode());
			param.put("fingerseq",rf.getFingerseq());
			param.put("orderid",rf.getRfid());
			param.put("empedate",rf.getEmpedate());
			param.put("openstime",rf.getOpenstime());
			param.put("openetime",rf.getOpenetime());
			param.put("count",rf.getCount());
			param.put("timeout", timeout);
			param.put("callbackurl", callbackurl);
			SendResult sr=StringTools.check(param);
			if("0".equals(sr.getResultCode())) {
				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"delRoomFingerNB", secret, param);
				sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
			}
			return sr;
		}

		@Override
		public SendResult syscFingerNB(String roomcode2, String roomimei, String roomtxtype, List<RoomFinger> rflist,
				Integer timeout, String callbackurl) {
			// TODO Auto-generated method stub
			LinkedHashMap param=new LinkedHashMap();
			param.put("roomcode2", roomcode2);
			param.put("roomimei",roomimei);
			param.put("roomtxtype",roomtxtype);
			param.put("rflist",rflist);
			param.put("timeout", timeout);
			param.put("callbackurl", callbackurl);
			SendResult sr=StringTools.check(param);
			if("0".equals(sr.getResultCode())) {
				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"syscFingerNB", secret, param);
				sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
			}
			return sr;
		}

		@Override
		public SendResult syscCardNB(String roomcode2, String roomimei, String roomtxtype, List<RoomCard> rclist,List<UnlockPsw> pswlist,
				Integer timeout, String callbackurl) {
			// TODO Auto-generated method stub
			LinkedHashMap param=new LinkedHashMap();
			param.put("roomcode2", roomcode2);
			param.put("roomimei",roomimei);
			param.put("roomtxtype",roomtxtype);
			param.put("rclist",rclist);
			param.put("pswlist",pswlist);
			param.put("timeout", timeout);
			param.put("callbackurl", callbackurl);
			SendResult sr=StringTools.check(param);
			if("0".equals(sr.getResultCode())) {
				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"syscCardNB", secret, param);
				sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
			}
			return sr;
		}

		@Override
		public SendResult saveRoomCardNB(String roomcode2, String roomimei, String roomtxtype,String rcid, RoomCardxzsx rc, Integer timeout,
				String callbackurl) {
			// TODO Auto-generated method stub
			LinkedHashMap param=new LinkedHashMap();
			param.put("roomcode2", roomcode2);
			param.put("roomimei",roomimei);
			param.put("roomtxtype",roomtxtype);
			param.put("rcid",rcid);
			param.put("cardtype",rc.getCardtype());
			param.put("cardcode",rc.getCardcode());
			param.put("cardedate",rc.getCardedate());
			param.put("cardunlocktype",rc.getCardunlocktype());
			param.put("cardpass",rc.getCardpass());
			param.put("empedate",rc.getEmpedate());
			param.put("personcode",rc.getPersoncode());
			param.put("personname",rc.getPersonname());
			param.put("openstime",rc.getOpenstime());
			param.put("openetime",rc.getOpenetime());
			param.put("rcusecount",rc.getRcusecount());
			param.put("timeout", timeout);
			param.put("callbackurl", callbackurl);
			SendResult sr=StringTools.check(param);
			if("0".equals(sr.getResultCode())) {
				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"saveRoomCardNB", secret, param);
				sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
			}
			return sr;
		}

		@Override
		public SendResult delRoomCardNB(String roomcode2, String roomimei, String roomtxtype, String rcid, RoomCardxzsx rc,
				Integer timeout, String callbackurl) {
			// TODO Auto-generated method stub
			LinkedHashMap param=new LinkedHashMap();
			param.put("roomcode2", roomcode2);
			param.put("roomimei",roomimei);
			param.put("roomtxtype",roomtxtype);
			param.put("rcid",rcid);
			param.put("cardtype",rc.getCardtype());
			param.put("cardcode",rc.getCardcode());
			param.put("cardedate",rc.getCardedate());
			param.put("cardunlocktype",rc.getCardunlocktype());
			param.put("cardpass",rc.getCardpass());
			param.put("empedate",rc.getEmpedate());
			param.put("personcode",rc.getPersoncode());
			param.put("personname",rc.getPersonname());
			param.put("openstime",rc.getOpenstime());
			param.put("openetime",rc.getOpenetime());
			param.put("rcusecount",rc.getRcusecount());
			param.put("timeout", timeout);
			param.put("callbackurl", callbackurl);
			SendResult sr=StringTools.check(param);
			if("0".equals(sr.getResultCode())) {
				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"delRoomCardNB", secret, param);
				sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
			}
			return sr;
		}

		@Override
		public SendResult saveNblog(Room room, String paramvalue, String duedate_1, String itstate_isopen,
				String itstate_reset, Command command,Integer timeout, String callbackurl) {
			// TODO Auto-generated method stub
			LinkedHashMap param=new LinkedHashMap();
			param.put("roomcode2", room.getRoomcode2());
			param.put("roomimei",command.getImei());
			param.put("paramvalue",paramvalue);
			param.put("duedate_1",duedate_1);
			param.put("itstate_isopen",itstate_isopen);
			param.put("itstate_reset",itstate_reset);
			param.put("id",command.getId());
			param.put("messageCnt",command.getMessageCnt());
			param.put("time",command.getTime());
			param.put("forcelock",room.getForcelock());
			param.put("networkmode",room.getNetworkmode());
			param.put("workmode",room.getWorkmode());
			param.put("timeout", timeout);
			param.put("callbackurl", callbackurl);
			SendResult sr=StringTools.check(param);
			if("0".equals(sr.getResultCode())) {
				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"saveNblog", secret, param);
				System.out.println(result);
				sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
			}
			return sr;
		}

		@Override
		public SendResult saveNblog1(String roomcode2, String json, Integer timeout, String callbackurl) {
			// TODO Auto-generated method stub
			LinkedHashMap param=new LinkedHashMap();
			param.put("roomcode2", roomcode2);
			param.put("json", json);
			param.put("timeout", timeout);
			param.put("callbackurl", callbackurl);
			SendResult sr=StringTools.check(param);
			if("0".equals(sr.getResultCode())) {
				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"saveNblog1", secret, param);
				sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
			}
			return sr;
		}

		@Override
		public SendResult NBrecords(String roomid, String recordNum,String records, Integer timeout, String callbackurl) {
			// TODO Auto-generated method stub
			LinkedHashMap param=new LinkedHashMap();
			param.put("roomid", roomid);
			param.put("recordNum", recordNum);
			param.put("records", records);
			param.put("timeout", timeout);
			param.put("callbackurl", callbackurl);
			SendResult sr=StringTools.check(param);
			if("0".equals(sr.getResultCode())) {
				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"recordsNB", secret, param);
				sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
			}
			return sr;
		}

		@Override
		public SendResult addDXOnline(String id, String deviceId, Integer timeout, String callbackurl) {
			// TODO Auto-generated method stub
			LinkedHashMap param=new LinkedHashMap();
			param.put("id", id);
			param.put("deviceId", deviceId);
			param.put("timeout", timeout);
			param.put("callbackurl", callbackurl);
			SendResult sr=StringTools.check(param);
			if("0".equals(sr.getResultCode())) {
				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"addDXOnline", secret, param);
				sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
			}
			return sr;
		}

		@Override
		public SendResult registerDevice(String roomlocation,String roomname,String roomimsi,String roomtxtype, String roomimei, Integer timeout, String callbackurl) {
			// TODO Auto-generated method stub
			LinkedHashMap param=new LinkedHashMap();
			param.put("roomlocation", roomlocation);
			param.put("roomname", roomname);
			param.put("roomimsi", roomimsi);
			param.put("roomtxtype", roomtxtype);
			param.put("roomimei", roomimei);
			param.put("timeout", timeout);
			param.put("callbackurl", callbackurl);
			SendResult sr=StringTools.check(param);
			if("0".equals(sr.getResultCode())) {
				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"registerDevice", secret, param);
				Map map=StringTools.stringToMap2(result);
				if(map!=null) {
					String resultCode=map.get("resultCode")==null?"":map.get("resultCode").toString();
					String resultMsg=map.get("resultMsg")==null?"":map.get("resultMsg").toString();
					String orderId=map.get("orderId")==null?"":map.get("orderId").toString();
					String msg=map.get("msg")==null?"":map.get("msg").toString();
					String[] split = msg.split("~");
					String deviceId="";
					String verifyCode="";
					String psk="";
					if(split.length==3) {
						deviceId=split[0];
						verifyCode=split[1];
						psk=split[2];
					}else {
						deviceId=msg;
					}
					RegistNb registNb=new RegistNb(deviceId, verifyCode, psk);
					sr=new SendResult(resultCode, resultMsg, orderId, registNb);
				}
				
				//sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
			}
			return sr;
		}

		@Override
		public SendResult updateDevice(String roomlocation, String roomname, String roomtxtype, String roomimei,String roomdeviceid,
				Integer timeout, String callbackurl) {
			// TODO Auto-generated method stub
			LinkedHashMap param=new LinkedHashMap();
			param.put("roomlocation", roomlocation);
			param.put("roomname", roomname);
			param.put("roomtxtype", roomtxtype);
			param.put("roomimei", roomimei);
			param.put("roomdeviceid", roomdeviceid);
			param.put("timeout", timeout);
			param.put("callbackurl", callbackurl);
			SendResult sr=StringTools.check(param);
			if("0".equals(sr.getResultCode())) {
				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"updateDevice", secret, param);
				sr=(SendResult)StringTools.getResultObject(result, SendResult.class);
			}
			return sr;
		}

		@Override
		public SendResult delDevice(String roomdeviceid,String roomtxtype, Integer timeout, String callbackurl) {
			// TODO Auto-generated method stub
			LinkedHashMap param=new LinkedHashMap();
			param.put("roomdeviceid", roomdeviceid);
			param.put("roomtxtype", roomtxtype);
			param.put("timeout", timeout);
			param.put("callbackurl", callbackurl);
			SendResult sr=StringTools.check(param);
			if("0".equals(sr.getResultCode())) {
				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"delDevice", secret, param);
				sr=(SendResult)StringTools.getResultObject(result, SendResult.class);
			}
			return sr;
		}

		@Override
		public SendResult saveDeviceDataHw(String body,RoomNB room,String valueSleep,String valueSpace,String itstateisopen,String itstatereset,Card card,Card card1,Integer rccount,Integer timeout,String callbackurl) {
			// TODO Auto-generated method stub
			LinkedHashMap param=new LinkedHashMap();
			String room2="";
			String card_1="";
			String card_2="";
			try {
				 room2=StringTools.simpleObjectToJsonStr(room);
				 card_1=StringTools.simpleObjectToJsonStr(card);
				 card_2=StringTools.simpleObjectToJsonStr(card1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			param.put("body", body);
			param.put("room", room2);
			param.put("valueSleep", valueSleep);
			param.put("valueSpace", valueSpace);
			param.put("itstateisopen", itstateisopen);
			param.put("itstatereset", itstatereset);
			param.put("card", card_1);
			param.put("card1", card_2);
			param.put("rccount", rccount);
			param.put("timeout", timeout);
			param.put("callbackurl", callbackurl);
			SendResult sr=StringTools.check(param);
			if("0".equals(sr.getResultCode())) {
				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"saveDeviceDataHw", secret, param);
				sr=(SendResult)StringTools.getResultObject(result, SendResult.class);
			}
			return sr;
		}

		@Override
		public SendResult updateCommandHw(String body, Integer timeout, String callbackurl) {
			// TODO Auto-generated method stub
			LinkedHashMap param=new LinkedHashMap();
			param.put("body", body);
			param.put("timeout", timeout);
			param.put("callbackurl", callbackurl);
			SendResult sr=StringTools.check(param);
			if("0".equals(sr.getResultCode())) {
				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"updateCommandHw", secret, param);
				sr=(SendResult)StringTools.getResultObject(result, SendResult.class);
			}
			return sr;
		}

		@Override
		public SendResult saveDeviceDataDx(String body,RoomNB room,String valueSleep,String valueSpace,String itstateisopen,String itstatereset,Card card,Card card1,Integer rccount,Integer timeout,String callbackurl) {
			LinkedHashMap param=new LinkedHashMap();
			String room2="";
			String card_1="";
			String card_2="";
			try {
				 room2=StringTools.simpleObjectToJsonStr(room);
				 card_1=StringTools.simpleObjectToJsonStr(card);
				 card_2=StringTools.simpleObjectToJsonStr(card1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			param.put("body", body);
			param.put("room", room2);
			param.put("valueSleep", valueSleep);
			param.put("valueSpace", valueSpace);
			param.put("itstateisopen", itstateisopen);
			param.put("itstatereset", itstatereset);
			param.put("card", card_1);
			param.put("card1", card_2);
			param.put("rccount", rccount);
			param.put("timeout", timeout);
			param.put("callbackurl", callbackurl);
			SendResult sr=StringTools.check(param);
			if("0".equals(sr.getResultCode())) {
				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"saveDeviceDataDx", secret, param);
				sr=(SendResult)StringTools.getResultObject(result, SendResult.class);
			}
			return sr;
		}
		
		@Override
		public SendResult updateCommandDx(String body, Integer timeout, String callbackurl) {
			// TODO Auto-generated method stub
			LinkedHashMap param=new LinkedHashMap();
			param.put("body", body);
			param.put("timeout", timeout);
			param.put("callbackurl", callbackurl);
			SendResult sr=StringTools.check(param);
			if("0".equals(sr.getResultCode())) {
				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"updateCommandDx", secret, param);
				sr=(SendResult)StringTools.getResultObject(result, SendResult.class);
			}
			return sr;
		}


		@Override
		public SendResult saveDeviceDataYd(String retmsg, String body, RoomNB room, String valueSleep,
				String valueSpace, String itstateisopen, String itstatereset, Card card, Card card1, Integer rccount,
				Integer timeout, String callbackurl) {
			// TODO Auto-generated method stub
			LinkedHashMap param=new LinkedHashMap();
			String room2="";
			String card_1="";
			String card_2="";
			try {
				 room2=StringTools.simpleObjectToJsonStr(room);
				 card_1=StringTools.simpleObjectToJsonStr(card);
				 card_2=StringTools.simpleObjectToJsonStr(card1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			param.put("retmsg", retmsg);
			param.put("body", body);
			param.put("room", room2);
			param.put("valueSleep", valueSleep);
			param.put("valueSpace", valueSpace);
			param.put("itstateisopen", itstateisopen);
			param.put("itstatereset", itstatereset);
			param.put("card", card_1);
			param.put("card1", card_2);
			param.put("rccount", rccount);
			param.put("timeout", timeout);
			param.put("callbackurl", callbackurl);
			SendResult sr=StringTools.check(param);
			if("0".equals(sr.getResultCode())) {
				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"saveDeviceDataYd", secret, param);
				sr=(SendResult)StringTools.getResultObject(result, SendResult.class);
			}
			return sr;
		}

		@Override
		public SendResult updateCommandYd(String body, Integer timeout, String callbackurl) {
			// TODO Auto-generated method stub
			LinkedHashMap param=new LinkedHashMap();
			param.put("body", body);
			param.put("timeout", timeout);
			param.put("callbackurl", callbackurl);
			SendResult sr=StringTools.check(param);
			if("0".equals(sr.getResultCode())) {
				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"updateCommandYd", secret, param);
				sr=(SendResult)StringTools.getResultObject(result, SendResult.class);
			}
			return sr;
		}

		
}
