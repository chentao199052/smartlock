package com.qingyi.nbsend.info.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.qingyi.model.Card;
import com.qingyi.model.Command;
import com.qingyi.model.DelRoomCardxzsx;
import com.qingyi.model.DelRoomFinger;
import com.qingyi.model.Intimeorder;
import com.qingyi.model.RegistNb;
import com.qingyi.model.Room;
import com.qingyi.model.RoomCard;
import com.qingyi.model.RoomFinger;
import com.qingyi.model.RoomNB;
import com.qingyi.model.SendResult;
import com.qingyi.model.UnlockPsw;
import com.qingyi.nbsend.info.NBSendOrderInfo;
import com.qingyi.util.Constant;
import com.qingyi.util.HttpsUtil;
import com.qingyi.util.StringTools;

import net.sf.json.JSONObject;

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
		public SendResult saveUnlockPswNB(String roomcode2,String roomtxtype,String roomimei,UnlockPsw psw, Integer timeout, String callbackurl) {
			// TODO Auto-generated method stub
			LinkedHashMap param=new LinkedHashMap();
			param.put("roomcode2", roomcode2);
			param.put("roomimei",roomimei);
			param.put("pass", psw.getPass());
			param.put("count",psw.getOpencount());
			param.put("edate", psw.getEdate());
			param.put("roomtxtype",roomtxtype);
			param.put("unlockstime", psw.getOpenstime());
			param.put("unlocketime", psw.getOpenetime());
			param.put("timeout", timeout);
			param.put("callbackurl", callbackurl);
			SendResult sr=StringTools.check(param);
			if("0".equals(sr.getResultCode())) {
				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"saveunlockpswnb", secret, param);
				//sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
				sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
			}
			return sr;
		}
		@Override
		public SendResult delUnlockpswNB(String roomcode2,String roomimei,String roomtxtype, UnlockPsw psw, Integer timeout, String callbackurl) {
			// TODO Auto-generated method stub
			LinkedHashMap param=new LinkedHashMap();
			param.put("roomcode2", roomcode2);
			param.put("pass", psw.getPass());
			param.put("count",psw.getOpencount());
			param.put("edate", psw.getEdate());
			param.put("unlockstime", psw.getOpenstime());
			param.put("unlocketime", psw.getOpenetime());
			param.put("timeout", timeout);
			param.put("callbackurl", callbackurl);
			SendResult sr=StringTools.check(param);
			if("0".equals(sr.getResultCode())) {
				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"delunlockpswnb", secret, param);
				//sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
				sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
			}
			return sr;
		}

		@Override
		public SendResult updateRoomCardxzsxNB(String roomcode2, String roomimei,String roomtxtype, RoomCard card, Integer timeout,
				String callbackurl) {
			// TODO Auto-generated method stub
			LinkedHashMap param=new LinkedHashMap();
			param.put("roomcode2", roomcode2);
			param.put("roomimei",roomimei);
			param.put("roomtxtype",roomtxtype);
			param.put("cardtype",card.getCardtype());
			param.put("cardcode",card.getCardcode());
			param.put("personcode",card.getPersoncode());
			param.put("personname",card.getPersonname());
			param.put("empedate",card.getEmpedate());
			param.put("rcusecount",card.getOpencount());
			param.put("openstime",card.getOpenstime());
			param.put("openetime",card.getOpenetime());
			param.put("rcid",card.getRcid());
			param.put("timeout", timeout);
			param.put("callbackurl", callbackurl);
			SendResult sr=StringTools.check(param);
			if("0".equals(sr.getResultCode())) {
				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"updateroomcardxzsxnb", secret, param);
				//sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
				sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
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
			param.put("rfid",orderid);
			param.put("timeout", timeout);
			param.put("callbackurl", callbackurl);
			SendResult sr=StringTools.check(param);
			if("0".equals(sr.getResultCode())) {
				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"updateroomfingerxzsxnb", secret, param);
				//sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
				sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
			}
			return sr;
		}

		@Override
		public List<SendResult> delRoomFingerNB(String roomcode2,String roomimei,String roomtxtype,List<DelRoomFinger> rflist,Integer timeout,String callbackurl) {
			// TODO Auto-generated method stub
			LinkedHashMap param=new LinkedHashMap();
			param.put("roomcode2", roomcode2);
			param.put("roomimei",roomimei);
			param.put("roomtxtype",roomtxtype);
			param.put("rflist",rflist);
			param.put("timeout", timeout);
			param.put("callbackurl", callbackurl);
			SendResult sr=StringTools.check(param);
			List<SendResult> result=null;
			if(sr.getResultCode().equals("0")) {
				String ss=HttpsUtil.httpURLConnectionPOST(baseurl, "delroomfingernb", secret, param);
				if(ss.length()>1) {
					result=new ArrayList<SendResult>();
					String sss=ss.substring(1,ss.length()-1);
					System.out.println(sss);
					while (!(sss.indexOf("{")==-1)) {
						String s1=sss.substring(sss.indexOf("{"),sss.indexOf("}")+1);
						sss=sss.substring(sss.indexOf("}")+1);
						//sr=(SendResult) StringTools.getResultObject(s1,SendResult.class);
						sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(s1), SendResult.class);
						result.add(sr);
					}
				}
			}
			return result;
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
				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"syscfingernb", secret, param);
				//sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
				sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
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
				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"sysccardnb", secret, param);
				//sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
				sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
			}
			return sr;
		}

		@Override
		public SendResult saveRoomCardNB(String roomcode2, String roomimei, String roomtxtype, RoomCard rc, Integer timeout,
				String callbackurl) {
			// TODO Auto-generated method stub
			LinkedHashMap param=new LinkedHashMap();
			param.put("roomcode2", roomcode2);
			param.put("roomimei",roomimei);
			param.put("roomtxtype",roomtxtype);
			param.put("cardtype",rc.getCardtype());
			param.put("cardcode",rc.getCardcode());
			param.put("empedate",rc.getEmpedate());
			param.put("cardedate",rc.getEdate());
			param.put("personcode",rc.getPersoncode());
			param.put("personname",rc.getPersonname());
			param.put("openstime",rc.getOpenstime());
			param.put("openetime",rc.getOpenetime());
			param.put("rcusecount",rc.getOpencount());
			param.put("timeout", timeout);
			param.put("callbackurl", callbackurl);
			SendResult sr=StringTools.check(param);
			if("0".equals(sr.getResultCode())) {
				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"saveroomcardnb", secret, param);
				//sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
				sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
			}
			return sr;
		}

		@Override
		public SendResult delRoomCardNB(String roomcode2, String roomimei, String roomtxtype, DelRoomCardxzsx rc,
				Integer timeout, String callbackurl) {
			// TODO Auto-generated method stub
			LinkedHashMap param=new LinkedHashMap();
			param.put("roomcode2", roomcode2);
			param.put("roomimei",roomimei);
			param.put("roomtxtype",roomtxtype);
			param.put("rcid",rc.getRcid());
			param.put("cardtype",rc.getCardtype());
			param.put("cardcode",rc.getCardcode());
			param.put("cardedate",rc.getCardedate());
			param.put("openstime",rc.getOpenstime());
			param.put("openetime",rc.getOpenetime());
			param.put("rcusecount",rc.getRcusecount());
			param.put("timeout", timeout);
			param.put("callbackurl", callbackurl);
			SendResult sr=StringTools.check(param);
			if("0".equals(sr.getResultCode())) {
				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"delroomcardnb", secret, param);
				//sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
				sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
			}
			return sr;
		}

//		@Override
//		public SendResult saveNblog(Room room, String paramvalue, String duedate_1, String itstate_isopen,
//				String itstate_reset, Command command,Integer timeout, String callbackurl) {
//			// TODO Auto-generated method stub
//			LinkedHashMap param=new LinkedHashMap();
//			param.put("roomcode2", room.getRoomcode2());
//			param.put("roomimei",command.getImei());
//			param.put("paramvalue",paramvalue);
//			param.put("duedate_1",duedate_1);
//			param.put("itstate_isopen",itstate_isopen);
//			param.put("itstate_reset",itstate_reset);
//			param.put("messageCnt",command.getMessageCnt());
//			param.put("time",command.getTime());
//			param.put("forcelock",room.getForcelock());
//			param.put("networkmode",room.getNetworkmode());
//			param.put("workmode",room.getWorkmode());
//			param.put("timeout", timeout);
//			param.put("callbackurl", callbackurl);
//			SendResult sr=StringTools.check(param);
//			if("0".equals(sr.getResultCode())) {
//				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"savenblog", secret, param);
//				System.out.println(result);
//				sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
//			}
//			return sr;
//		}

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
				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"savenblog1", secret, param);
				//sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
				sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
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
				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"recordsnb", secret, param);
				//sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
				sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
			}
			return sr;
		}

		//@Override
//		public SendResult addDXOnline(String id, String deviceId, Integer timeout, String callbackurl) {
//			// TODO Auto-generated method stub
//			LinkedHashMap param=new LinkedHashMap();
//			param.put("id", id);
//			param.put("deviceId", deviceId);
//			param.put("timeout", timeout);
//			param.put("callbackurl", callbackurl);
//			SendResult sr=StringTools.check(param);
//			if("0".equals(sr.getResultCode())) {
//				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"adddxonline", secret, param);
//				sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
//			}
//			return sr;
//		}

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
				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"registerdevice", secret, param);
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
				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"updatedevice", secret, param);
				//sr=(SendResult)StringTools.getResultObject(result, SendResult.class);
				sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
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
				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"deldevice", secret, param);
				//sr=(SendResult)StringTools.getResultObject(result, SendResult.class);
				sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
			}
			return sr;
		}

//		@Override
//		public SendResult saveDeviceDataHw(String body,RoomNB room,String valueSleep,String valueSpace,String itstateisopen,String itstatereset,Card card,Card card1,Integer rccount,Integer timeout,String callbackurl) {
//			// TODO Auto-generated method stub
//			LinkedHashMap param=new LinkedHashMap();
//			String room2="";
//			String card_1="";
//			String card_2="";
//			try {
//				 room2=StringTools.simpleObjectToJsonStr(room);
//				 card_1=StringTools.simpleObjectToJsonStr(card);
//				 card_2=StringTools.simpleObjectToJsonStr(card1);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			param.put("body", body);
//			param.put("room", room2);
//			param.put("valueSleep", valueSleep);
//			param.put("valueSpace", valueSpace);
//			param.put("itstateisopen", itstateisopen);
//			param.put("itstatereset", itstatereset);
//			param.put("card", card_1);
//			param.put("card1", card_2);
//			param.put("rccount", rccount);
//			param.put("timeout", timeout);
//			param.put("callbackurl", callbackurl);
//			SendResult sr=StringTools.check(param);
//			if("0".equals(sr.getResultCode())) {
//				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"savedevicedatahw", secret, param);
//				sr=(SendResult)StringTools.getResultObject(result, SendResult.class);
//			}
//			return sr;
//		}

//		@Override
//		public SendResult updateCommandHw(String body, Integer timeout, String callbackurl) {
//			// TODO Auto-generated method stub
//			LinkedHashMap param=new LinkedHashMap();
//			param.put("body", body);
//			param.put("timeout", timeout);
//			param.put("callbackurl", callbackurl);
//			SendResult sr=StringTools.check(param);
//			if("0".equals(sr.getResultCode())) {
//				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"updatecommandhw", secret, param);
//				sr=(SendResult)StringTools.getResultObject(result, SendResult.class);
//			}
//			return sr;
//		}

//		@Override
//		public SendResult saveDeviceDataDx(String body,RoomNB room,String valueSleep,String valueSpace,String itstateisopen,String itstatereset,Card card,Card card1,Integer rccount,Integer timeout,String callbackurl) {
//			LinkedHashMap param=new LinkedHashMap();
//			String room2="";
//			String card_1="";
//			String card_2="";
//			try {
//				 room2=StringTools.simpleObjectToJsonStr(room);
//				 card_1=StringTools.simpleObjectToJsonStr(card);
//				 card_2=StringTools.simpleObjectToJsonStr(card1);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			param.put("body", body);
//			param.put("room", room2);
//			param.put("valueSleep", valueSleep);
//			param.put("valueSpace", valueSpace);
//			param.put("itstateisopen", itstateisopen);
//			param.put("itstatereset", itstatereset);
//			param.put("card", card_1);
//			param.put("card1", card_2);
//			param.put("rccount", rccount);
//			param.put("timeout", timeout);
//			param.put("callbackurl", callbackurl);
//			SendResult sr=StringTools.check(param);
//			if("0".equals(sr.getResultCode())) {
//				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"savedevicedatadx", secret, param);
//				sr=(SendResult)StringTools.getResultObject(result, SendResult.class);
//			}
//			return sr;
//		}
		
//		@Override
//		public SendResult updateCommandDx(String body, Integer timeout, String callbackurl) {
//			// TODO Auto-generated method stub
//			LinkedHashMap param=new LinkedHashMap();
//			param.put("body", body);
//			param.put("timeout", timeout);
//			param.put("callbackurl", callbackurl);
//			SendResult sr=StringTools.check(param);
//			if("0".equals(sr.getResultCode())) {
//				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"updatecommanddx", secret, param);
//				sr=(SendResult)StringTools.getResultObject(result, SendResult.class);
//			}
//			return sr;
//		}


//		@Override
//		public SendResult saveDeviceDataYd(String retmsg, String body, RoomNB room, String valueSleep,
//				String valueSpace, String itstateisopen, String itstatereset, Card card, Card card1, Integer rccount,
//				Integer timeout, String callbackurl) {
//			// TODO Auto-generated method stub
//			LinkedHashMap param=new LinkedHashMap();
//			String room2="";
//			String card_1="";
//			String card_2="";
//			try {
//				 room2=StringTools.simpleObjectToJsonStr(room);
//				 card_1=StringTools.simpleObjectToJsonStr(card);
//				 card_2=StringTools.simpleObjectToJsonStr(card1);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			param.put("retmsg", retmsg);
//			param.put("body", body);
//			param.put("room", room2);
//			param.put("valueSleep", valueSleep);
//			param.put("valueSpace", valueSpace);
//			param.put("itstateisopen", itstateisopen);
//			param.put("itstatereset", itstatereset);
//			param.put("card", card_1);
//			param.put("card1", card_2);
//			param.put("rccount", rccount);
//			param.put("timeout", timeout);
//			param.put("callbackurl", callbackurl);
//			SendResult sr=StringTools.check(param);
//			if("0".equals(sr.getResultCode())) {
//				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"savedevicedatayd", secret, param);
//				sr=(SendResult)StringTools.getResultObject(result, SendResult.class);
//			}
//			return sr;
//		}

//		@Override
//		public SendResult updateCommandYd(String body, Integer timeout, String callbackurl) {
//			// TODO Auto-generated method stub
//			LinkedHashMap param=new LinkedHashMap();
//			param.put("body", body);
//			param.put("timeout", timeout);
//			param.put("callbackurl", callbackurl);
//			SendResult sr=StringTools.check(param);
//			if("0".equals(sr.getResultCode())) {
//				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"updatecommandyd", secret, param);
//				sr=(SendResult)StringTools.getResultObject(result, SendResult.class);
//			}
//			return sr;
//		}

		@Override
		public SendResult saveRoomFingerNB(String roomcode2, String roomimei, String roomtxtype, String fingercode,
				String content, Integer timeout, String callbackurl) {
			// TODO Auto-generated method stub
			LinkedHashMap param=new LinkedHashMap();
			param.put("roomcode2", roomcode2);
			param.put("roomimei", roomimei);
			param.put("roomtxtype", roomtxtype);
			param.put("fingercode", fingercode);
			param.put("content", content);
			param.put("timeout", timeout);
			param.put("callbackurl", callbackurl);
			SendResult sr=StringTools.check(param);
			if("0".equals(sr.getResultCode())) {
				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"saveroomfingernb", secret, param);
				//sr=(SendResult)StringTools.getResultObject(result, SendResult.class);
				sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
			}
			return sr;
		}

		@Override
		public SendResult saveIntimenb(String roomcode2, String roomimei, String roomtxtype, String ittype,
				String itstate, String timeout, String callbackurl) {
			// TODO Auto-generated method stub
			LinkedHashMap param=new LinkedHashMap();
			param.put("roomcode2", roomcode2);
			param.put("roomimei", roomimei);
			param.put("roomtxtype", roomtxtype);
			param.put("ittype", ittype);
			param.put("itstate", itstate);
			param.put("timeout", timeout);
			param.put("callbackurl", callbackurl);
			SendResult sr=StringTools.check(param);
			if("0".equals(sr.getResultCode())) {
				String result=HttpsUtil.httpURLConnectionPOST(baseurl,"saveroomfingernb", secret, param);
				//sr=(SendResult)StringTools.getResultObject(result, SendResult.class);
				sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
			}
			return sr;
		}

		
}
