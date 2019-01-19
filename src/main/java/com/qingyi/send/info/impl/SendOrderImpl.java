package com.qingyi.send.info.impl;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.qingyi.model.AuthCard;
import com.qingyi.model.AuthDelCard;
import com.qingyi.model.AuthDelFinger;
import com.qingyi.model.AuthDelPsw;
import com.qingyi.model.AuthFinger;
import com.qingyi.model.AuthPsw;
import com.qingyi.model.AuthResult;
import com.qingyi.model.CardsResult;
import com.qingyi.model.Command;
import com.qingyi.model.DelCardsResult;
import com.qingyi.model.DelFingersResult;
import com.qingyi.model.DelPswsResult;
import com.qingyi.model.DelRoomFinger;
import com.qingyi.model.DelUnlockPsw;
import com.qingyi.model.FingersResult;
import com.qingyi.model.PswsResult;
import com.qingyi.model.Room;
import com.qingyi.model.RoomCard;
import com.qingyi.model.RoomFinger;
import com.qingyi.model.SendResult;
import com.qingyi.model.UnlockPsw;
import com.qingyi.send.info.SendOrderInfo;
import com.qingyi.util.Constant;
import com.qingyi.util.HttpsUtil;
import com.qingyi.util.StringTools;
import net.sf.json.JSONObject;
public class SendOrderImpl implements SendOrderInfo{
	
	private String baseurl;
	
	private String secret;

	public SendOrderImpl() {
		super();
		baseurl=Constant.BASEURL;
		secret=Constant.SECRET;
	}

	public SendOrderImpl(String baseurl, String secret) {
		super();
		this.baseurl = baseurl;
		this.secret = secret;
	}
	
	public String getBaseurl() {
		return baseurl;
	}

	public void setBaseurl(String baseurl) {
		this.baseurl = baseurl;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	@Override
	public SendResult getLockStatus(String gatewaycode, String gatewaycode2, String roomcode, Integer timeout, String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("gatewaycode", gatewaycode);
		param.put("gatewaycode2", gatewaycode2);
		param.put("roomcode", roomcode);
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr=StringTools.check(param);
		if(sr.getResultCode().equals("0")) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "getlockstatus", secret, param);
			sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult saveLockReset(String gatewaycode, String gatewaycode2, String roomcode, Integer timeout,
			String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("gatewaycode", gatewaycode);
		param.put("gatewaycode2", gatewaycode2);
		param.put("roomcode", roomcode);
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr=StringTools.check(param);
		if(sr.getResultCode().equals("0")) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "lockreset", secret, param);
			sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
			//sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult saveLockRemoteOpen(String gatewaycode, String gatewaycode2, String roomcode, Integer timeout,
			String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("gatewaycode", gatewaycode);
		param.put("gatewaycode2", gatewaycode2);
		param.put("roomcode", roomcode);
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr=StringTools.check(param);
		if(sr.getResultCode().equals("0")) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "lockremoteopen", secret, param);
			sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult readLockRecord(String gatewaycode, String gatewaycode2,String itid, String roomcode, Integer timeout,
			String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("gatewaycode", gatewaycode);
		param.put("gatewaycode2", gatewaycode2);
		param.put("itid", itid);
		param.put("roomcode", roomcode);
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr=StringTools.check(param);
		if(sr.getResultCode().equals("0")) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "readlockrecord", secret, param);
			sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult saveUnlockPsw(String gatewaycode, String gatewaycode2, String roomcode, Integer timeout,
			UnlockPsw psw, String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("gatewaycode", gatewaycode);
		param.put("gatewaycode2", gatewaycode2);
		param.put("roomcode", roomcode);
		param.put("pass", psw.getPass());
		param.put("opencount", psw.getOpencount());
		param.put("edate", psw.getEdate());
		param.put("openstime", psw.getOpenstime());
		param.put("openetime", psw.getOpenetime());
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr=StringTools.check(param);
		if(sr.getResultCode().equals("0")) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "saveunlockpsw", secret, param);
			sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
		}
		return sr;
	}
	@Override
	public SendResult delUnlockpsw(String gatewaycode, String gatewaycode2,String roomcode, DelUnlockPsw dpsw,Integer timeout,
			 String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("gatewaycode", gatewaycode);
		param.put("gatewaycode2", gatewaycode2);
		param.put("roomcode", roomcode);
		param.put("rcid", dpsw.getRcid());
		param.put("pass", dpsw.getPass());
		param.put("count", dpsw.getCount());
		param.put("edate", dpsw.getEdate());
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr=StringTools.check(param);
		if(sr.getResultCode().equals("0")) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "delUnlockpsw", secret, param);
			sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
		}
		return sr;
	}
	
	@Override
	public SendResult lockInitialize(String gatewaycode, String gatewaycode2, String roomcode, String roomcode2,
			Integer timeout, String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("gatewaycode", gatewaycode);
		param.put("gatewaycode2", gatewaycode2);
		param.put("roomcode", roomcode);
		param.put("roomcode2", roomcode2);
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr=StringTools.check(param);
		if(sr.getResultCode().equals("0")) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "lockinitialize", secret, param);
			sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult saveRoomCard(String gatewaycode, String gatewaycode2, String roomcode, RoomCard rc,
			Integer timeout, String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("gatewaycode", gatewaycode);
		param.put("gatewaycode2", gatewaycode2);
		param.put("roomcode", roomcode);
		param.put("cardtype", rc.getCardtype());
		param.put("cardcode", rc.getCardcode());
		param.put("cardedate", rc.getEdate());
		param.put("openstime", rc.getOpenstime());
		param.put("openetime", rc.getOpenetime());
		param.put("opencount", rc.getOpencount());
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr=StringTools.check(param);
		if(sr.getResultCode().equals("0")) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "saveroomcard", secret, param);
			sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult saveRoomFinger(String gatewaycode, String gatewaycode2, String roomcode, RoomFinger rf,
			Integer timeout, String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("gatewaycode", gatewaycode);
		param.put("gatewaycode2", gatewaycode2);
		param.put("roomcode", roomcode);
		param.put("fingercode", rf.getFingercode());
		param.put("fingercontent", rf.getFingercontent());
		param.put("fingeredate", rf.getEdate());
		param.put("openstime", rf.getOpenstime());
		param.put("openetime", rf.getOpenetime());
		param.put("opencount", rf.getOpencount());
		param.put("actioncount", rf.getActioncount());
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr=StringTools.check(param);
		if(sr.getResultCode().equals("0")) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "saveroomfinger", secret, param);
			sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult delRoomCard(String gatewaycode, String gatewaycode2, String roomcode,String rcid, String cardtype,
			String cardcode, Integer timeout, String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("gatewaycode", gatewaycode);
		param.put("gatewaycode2", gatewaycode2);
		param.put("roomcode", roomcode);
		param.put("rcid", rcid);
		param.put("cardtype", cardtype);
		param.put("cardcode", cardcode);
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr=StringTools.check(param);
		if(sr.getResultCode().equals("0")) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "delroomcard", secret, param);
			sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
		}
		return sr;
	}

	@Override
	public List<SendResult> delRoomFinger(String gatewaycode, String gatewaycode2,String roomid,String roomcode, 
			List<DelRoomFinger> rflist, Integer timeout, String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("gatewaycode", gatewaycode);
		param.put("gatewaycode2", gatewaycode2);
		param.put("roomid", roomid);
		param.put("roomcode", roomcode);
		param.put("rflist", rflist);
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr=StringTools.check(param);
		List<SendResult> result=null;
		if(sr.getResultCode().equals("0")) {
			String ss=HttpsUtil.httpURLConnectionPOST(baseurl, "delroomfinger", secret, param);
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
	public SendResult syncRoomCardAndPsw(String gatewaycode, String gatewaycode2, String roomcode,
			List<RoomCard> rclist, List<UnlockPsw> pswlist, Integer timeout, String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("gatewaycode", gatewaycode);
		param.put("gatewaycode2", gatewaycode2);
		param.put("roomcode", roomcode);
		param.put("rclist", rclist);
		param.put("pswlist", pswlist);
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr=StringTools.check(param);
		if(sr.getResultCode().equals("0")) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "syncroomcardandpsw", secret, param);
			sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult updateRoomFiger(String gatewaycode, String gatewaycode2, String roomcode, List<RoomFinger> rflist,
			Integer timeout, String callbackurl) {
		LinkedHashMap param=new LinkedHashMap();
		param.put("gatewaycode", gatewaycode);
		param.put("gatewaycode2", gatewaycode2);
		param.put("roomcode", roomcode);
		param.put("rflist", rflist);
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr=StringTools.check(param);
		try {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "updateroomfiger", secret, param);
			sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
		} catch (Exception e) {
			
		}
		return sr;
	}



	@Override
	public SendResult updateRoomForcelock(String gatewaycode, String gatewaycode2, String roomcode, Integer type,
			Integer timeout, String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("gatewaycode", gatewaycode);
		param.put("gatewaycode2", gatewaycode2);
		param.put("roomcode", roomcode);
		param.put("type", type);
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr=StringTools.check(param);
		if(sr.getResultCode().equals("0")) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "updateroomforcelock", secret, param);
		//	sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
			sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult updateRoompow(String gatewaycode, String gatewaycode2, String roomcode, Integer level,
			Integer timeout, String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("gatewaycode", gatewaycode);
		param.put("gatewaycode2", gatewaycode2);
		param.put("roomcode", roomcode);
		param.put("level", level);
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr=StringTools.check(param);
		if(sr.getResultCode().equals("0")) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "updateroompow", secret, param);
			//sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
			sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult updateRoomWorkmode(String gatewaycode, String gatewaycode2, String roomcode, Integer type,
			Integer timeout, String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("gatewaycode", gatewaycode);
		param.put("gatewaycode2", gatewaycode2);
		param.put("roomcode", roomcode);
		param.put("type", type);
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr=StringTools.check(param);
		if(sr.getResultCode().equals("0")) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "updateroomworkmode", secret, param);
			//sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
			sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult updateRoomNetmode(String gatewaycode, String gatewaycode2, String roomcode, Integer type,
			Integer timeout, String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("gatewaycode", gatewaycode);
		param.put("gatewaycode2", gatewaycode2);
		param.put("roomcode", roomcode);
		param.put("type", type);
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr=StringTools.check(param);
		if(sr.getResultCode().equals("0")) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "updateroomnetmode", secret, param);
			//sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
			sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult saveFingerReagy(String fpcode, Integer timeout, String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("fpcode", fpcode);
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr=StringTools.check(param);
		if(sr.getResultCode().equals("0")) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "savefingerreagy", secret, param);
			//sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
			sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult getGatewaystatus(String gatewaycode, String gatewaycode2,String date,Integer timeout, String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("gatewaycode", gatewaycode);
		param.put("gatewaycode2", gatewaycode2);
		param.put("date", date);
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr=StringTools.check(param);
		if(sr.getResultCode().equals("0")) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "getgatewaystatus", secret, param);
			//sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
			sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult updateGatewayRooms(String gatewaycode, String gatewaycode2, String roomcodes, Integer timeout,
			String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("gatewaycode", gatewaycode);
		param.put("gatewaycode2", gatewaycode2);
		param.put("roomcodes", roomcodes);
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr=StringTools.check(param);
		if(sr.getResultCode().equals("0")) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "updategatewayrooms", secret, param);
			//sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
			sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult readGatewayRecord(String gatewaycode, String gatewaycode2, Integer timeout, String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("gatewaycode", gatewaycode);
		param.put("gatewaycode2", gatewaycode2);
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr=StringTools.check(param);
		if(sr.getResultCode().equals("0")) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "readgatewayrecord", secret, param);
			//sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
			sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult gatewayInitialize(String gatewaycode, String newgatewaycode, String gatewaycode2, Integer timeout,
			String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("gatewaycode", gatewaycode);
		param.put("newgatewaycode", newgatewaycode);
		param.put("gatewaycode2", gatewaycode2);
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr=StringTools.check(param);
		if(sr.getResultCode().equals("0")) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "gatewayinitialize", secret, param);
			//sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
			sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult updateGatewaypow(String gatewaycode, String gatewaycode2, Integer level, Integer timeout,
			String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("gatewaycode", gatewaycode);
		param.put("gatewaycode2", gatewaycode2);
		param.put("level", level);
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr=StringTools.check(param);
		if(level ==null || level<1 || level >4) {
			sr.setResultCode("-10042");
			sr.setResultMsg("功率等级错误");
		}
		if(sr.getResultCode().equals("0")) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "updategatewaypow", secret, param);
			//sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
			sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult clearsGatewaytatus(String gatewaycode, String gatewaycode2, Integer timeout, String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("gatewaycode", gatewaycode);
		param.put("gatewaycode2", gatewaycode2);
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr=StringTools.check(param);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl,"clearsgatewaytatus", secret, param);
			//sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
			sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult updateRoomCardxzsx(String gatewaycode, String gatewaycode2, String roomcode, RoomCard card,
			Integer timeout, String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("gatewaycode", gatewaycode);
		param.put("gatewaycode2", gatewaycode2);
		param.put("roomcode", roomcode);
		param.put("cardtype", card.getCardtype());
		param.put("cardcode", card.getCardcode());
		param.put("personcode", card.getPersoncode());
		param.put("personname", card.getPersonname());
		param.put("rcusecount", card.getOpencount());
		param.put("empedate", card.getEmpedate());
		param.put("cardedate", card.getEdate());
		param.put("openstime", card.getOpenstime());
		param.put("openetime", card.getOpenetime());
		param.put("rcid", card.getRcid());
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr=StringTools.check(param);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl,"updateroomcardxzsx", secret, param);
			//sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
			sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
		}
		return sr;
	}
	@Override
	public SendResult updateRoomFingerxzsx(String gatewaycode,String gatewaycode2,String roomcode,RoomFinger finger,Integer timeout,String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("gatewaycode", gatewaycode);
		param.put("gatewaycode2", gatewaycode2);
		param.put("roomcode", roomcode);
		param.put("fingercode", finger.getFingercode());
		param.put("fingercontent", finger.getFingercontent());
		param.put("fingerseq", finger.getFingerseq());
		param.put("count", finger.getOpencount());
		param.put("rfid", finger.getRfid());
		param.put("openstime", finger.getOpenstime());
		param.put("openetime", finger.getOpenetime());
		param.put("empedate", finger.getEdate());
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr=StringTools.check(param);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl,"updateroomfingerxzsx", secret, param);
			//sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
			sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult clearFingerMachine(String fpcode, String type) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("fpcode", fpcode);
		param.put("type", type);
		SendResult sr=StringTools.check(param);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl,"clearfingermachine", secret, param);
			//sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
			sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
		}
		return sr;
		
	}

	@Override
	public SendResult readFingerMachine(String fpcode, String type) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("fpcode", fpcode);
		param.put("type", type);
		SendResult sr=StringTools.check(param);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl,"readfingermachine", secret, param);
			//sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
			sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult fingerMachineState(String fpcode, Integer timeout, String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("fpcode", fpcode);
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr=StringTools.check(param);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl,"fingermachinestate", secret, param);
			//sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
			sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult<AuthResult> saveLotAuth(List<AuthCard> clist,List<AuthDelCard> dclist,List<AuthFinger> flist,List<AuthDelFinger> dflist,List<AuthPsw> plist,List<AuthDelPsw> dplist) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		if(null!=clist&&clist.size()>0){
			param.put("cardlist", clist);
		}
		if(null!=dclist&&dclist.size()>0) {
			param.put("delcardlist", dclist);
		}
		if(null!=flist&&flist.size()>0) {
			param.put("finlist", flist);
		}
		if(null!=dflist&&dflist.size()>0) {
			param.put("delfinlist", dflist);
		}
		if(null!=plist&&plist.size()>0) {
			param.put("pswlist", plist);
		}
		if(null!=dplist&&dplist.size()>0) {
			param.put("delpswlist", dplist);
		}
		if(param.isEmpty()) {
			return new SendResult("-2003","参数不能全部为空","");
		}
		//判断
		SendResult<AuthResult> sr = StringTools.checkCardList(clist);
		if("0".equals(sr.getResultCode())) {
			sr = StringTools.checkDelCardList(dclist);
			if("0".equals(sr.getResultCode())) {
				sr = StringTools.checkFingerList(flist);
				if("0".equals(sr.getResultCode())) {
					sr = StringTools.checkDelFingerList(dflist);
					if("0".equals(sr.getResultCode())) {
						sr = StringTools.checkPswList(plist);
						if("0".equals(sr.getResultCode())) {
							sr = StringTools.checkDelPswList(dplist);
							if(!"0".equals(sr.getResultCode())) {
								return sr;
							}
						}else {
							return sr;
						}
					}else {
						return sr;
					}
				}else {
					return sr;
				}
			}else {
				return sr;
			}
		}else {
			return sr;
		}
		
		String result=HttpsUtil.httpURLConnectionPOST(baseurl,"savelotauth", secret, param);
		sr = StringTools.getSendResultByJson(result);
		return sr;
	}

	@Override
	public SendResult saveTotalReset(String gatewaycode, String gatewaycode2, String roomcode, String roomcode2,
			String locktype, Integer timeout, String callbackurl) {
		LinkedHashMap param=new LinkedHashMap();
		param.put("gatewaycode", gatewaycode);
		param.put("gatewaycode2", gatewaycode2);
		param.put("roomcode", roomcode);
		param.put("roomcode2", roomcode2);
		param.put("locktype", locktype);
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr = StringTools.checkTotal(param);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl,"savetotalreset", secret, param);
			sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult saveTotalOpen(String gatewaycode, String gatewaycode2, String roomcode, String roomcode2,
			 String locktype, Integer timeout,
			String callbackurl) {
		LinkedHashMap param=new LinkedHashMap();
		param.put("gatewaycode", gatewaycode);
		param.put("gatewaycode2", gatewaycode2);
		param.put("roomcode", roomcode);
		param.put("roomcode2", roomcode2);
		param.put("locktype", locktype);
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr = StringTools.checkTotal(param);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl,"savetotalopen", secret, param);
			sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult updateTotalForcelock(Integer type, String gatewaycode, String gatewaycode2, String roomcode,
			String roomcode2,  String locktype,
			Integer timeout, String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("type", type);
		param.put("gatewaycode", gatewaycode);
		param.put("gatewaycode2", gatewaycode2);
		param.put("roomcode", roomcode);
		param.put("roomcode2", roomcode2);
	//	param.put("forcelock", forcelock);
		param.put("locktype", locktype);
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr = StringTools.checkTotal(param);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl,"updatetotalforcelock", secret, param);
			sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult updateTotalRoomWorkmode(Integer type, String gatewaycode, String gatewaycode2, String roomcode,
			String roomcode2, String locktype, Integer timeout, String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("type", type);
		param.put("gatewaycode", gatewaycode);
		param.put("gatewaycode2", gatewaycode2);
		param.put("roomcode", roomcode);
		param.put("roomcode2", roomcode2);
		//param.put("workmode", workmode);
		param.put("locktype", locktype);
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr = StringTools.checkTotal(param);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl,"totalroomworkmode", secret, param);
			sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult updateTotalRoomNetmode(Integer type, String gatewaycode, String gatewaycode2, String roomcode,
			String roomcode2 , String locktype, Integer timeout, String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("type", type);
		param.put("gatewaycode", gatewaycode);
		param.put("gatewaycode2", gatewaycode2);
		param.put("roomcode", roomcode);
		param.put("roomcode2", roomcode2);
		//param.put("networkmode", networkmode);
		param.put("locktype", locktype);
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr = StringTools.checkTotal(param);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl,"totalroomnetmode", secret, param);
			sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
		}
		return sr;
	}

	
}
