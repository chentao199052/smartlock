package com.qingyi.send.info.impl;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
import com.qingyi.model.CardsResult;
import com.qingyi.model.Command;
import com.qingyi.model.DelCardsResult;
import com.qingyi.model.DelFingersResult;
import com.qingyi.model.DelPswsResult;
import com.qingyi.model.DelRoomFinger;
import com.qingyi.model.DelUnlockPsw;
import com.qingyi.model.FingersResult;
import com.qingyi.model.LockResult;
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
	public SendResult readLockRecord(String gatewaycode, String gatewaycode2, String roomcode,Integer timeout,
			String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("gatewaycode", gatewaycode);
		param.put("gatewaycode2", gatewaycode2);
		param.put("roomcode", roomcode);
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr=StringTools.checkTotal(param);
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
		param.put("password", psw.getPassword());
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
		param.put("cardedate", card.getEdate());
		param.put("openstime", card.getOpenstime());
		param.put("openetime", card.getOpenetime());
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
	public SendResult<String> readFingerMachine(String fpcode, String type) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("fpcode", fpcode);
		param.put("type", type);
		SendResult<String> sr=StringTools.check(param);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl,"readfingermachine", secret, param);
			//sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
			sr=(SendResult<String>) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
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
	public SendResult<AuthResult> saveLotAuth(List<AuthCard> clist,List<AuthDelCard> dclist,List<AuthFinger> flist,List<AuthDelFinger> dflist,List<AuthPsw> plist,List<AuthDelPsw> dplist,Integer timeout,String callbackurl) {
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
			return new SendResult("-20003","授权内容不能全部为空","");
		}
		//判断
		SendResult<AuthResult> sr = StringTools.checkCardList(clist);
		if(null==callbackurl || callbackurl.equals("") || callbackurl.equals("null")) {
			sr.setResultCode("-20004");
			sr.setResultMsg("回调地址不能为空");
			return sr;
		}
		
		if(null==timeout || timeout<0) {
			sr.setResultCode("-20005");
			sr.setResultMsg("指令超时时间不能为空或小于0");
			return sr;
		}
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		
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

	@Override
	public SendResult saveTotalUnlockPsw(String gatewaycode, String gatewaycode2, String roomcode, String roomcode2,
			String locktype, String roomimei, Integer timeout, UnlockPsw psw, String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("gatewaycode", gatewaycode);
		param.put("gatewaycode2", gatewaycode2);
		param.put("roomcode", roomcode);
		param.put("roomcode2", roomcode2);
		param.put("locktype", locktype);
		param.put("roomimei", roomimei);
		param.put("password", psw.getPassword());
		param.put("opencount", psw.getOpencount());
		param.put("edate", psw.getEdate());
		param.put("openstime", psw.getOpenstime());
		param.put("openetime", psw.getOpenetime());
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr=StringTools.checkTotal(param);
		if(sr.getResultCode().equals("0")) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "savetotalunlockpsw", secret, param);
			sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult<List<LockResult>> saveTotalResetList(List<AuthRestAndOpen> rstlist) {
		// TODO Auto-generated method stub
		LinkedHashMap param =new LinkedHashMap();
		if(rstlist==null || rstlist.size()==0) {
			return new SendResult<>("10007", "参数不能为空","");
		}else {
			param.put("rstlist", rstlist);
		}
		SendResult sr=StringTools.checkRestAndOpenList( rstlist);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "savetotalresetlist", secret, param);
			System.out.println(result);
			sr = StringTools.getSendResultByJson2(result,LockResult.class);
		}
		return sr;
	}

	@Override
	public SendResult<List<LockResult>> saveTotalOpenList(List<AuthRestAndOpen> oplist) {
		// TODO Auto-generated method stub
		LinkedHashMap param =new LinkedHashMap();
		if(oplist==null || oplist.size()==0) {
			return new SendResult<>("10007", "参数不能为空","");
		}else {
			param.put("oplist", oplist);
		}
		SendResult sr=StringTools.checkRestAndOpenList( oplist);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "savetotalopenlist", secret, param);
			//System.out.println(result);
			sr = StringTools.getSendResultByJson2(result,LockResult.class);
			System.out.println(sr);
		}
		return sr;
	}

	@Override
	public SendResult<List<LockResult>> updateTotalForcelockList(List<AuthTotal> frlist) {
		// TODO Auto-generated method stub
		LinkedHashMap param =new LinkedHashMap();
		if(frlist==null || frlist.size()==0) {
			return new SendResult<>("10007", "参数不能为空","");
		}else {
			param.put("frlist", frlist);
		}
		SendResult sr=StringTools.checkAuthTotalList(frlist);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "updatetotalforcelocklist", secret, param);
			System.out.println(result);
			sr = StringTools.getSendResultByJson2(result,LockResult.class);
		}
		return sr;
	}

	@Override
	public SendResult<List<LockResult>> updateTotalRoomWorkmodeList(List<AuthTotal> wklist) {
		// TODO Auto-generated method stub
		LinkedHashMap param =new LinkedHashMap();
		if(wklist==null || wklist.size()==0) {
			return new SendResult<>("10007", "参数不能为空","");
		}else {
			param.put("wklist", wklist);
		}
		SendResult sr=StringTools.checkAuthTotalList(wklist);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "updatetotalroomworkmodelist", secret, param);
			System.out.println(result);
			sr = StringTools.getSendResultByJson2(result,LockResult.class);
		}
		return sr;
	}

	@Override
	public SendResult<List<LockResult>> updateTotalRoomNetmodeList(List<AuthTotal> ntlist) {
		// TODO Auto-generated method stub
		LinkedHashMap param =new LinkedHashMap();
		if(ntlist==null || ntlist.size()==0) {
			return new SendResult<>("10007", "参数不能为空","");
		}else {
			param.put("ntlist", ntlist);
		}
		SendResult sr=StringTools.checkAuthTotalList(ntlist);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "updatetotalroomnetmodelist", secret, param);
			sr = StringTools.getSendResultByJson2(result,LockResult.class);
		}
		return sr;
	}

	@Override
	public SendResult<AuthResult> saveTotalUnlockPswList(List<AuthPsw> plist,Integer timeout,String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param =new LinkedHashMap();
		if(null!=plist&&plist.size()>0) {
			param.put("pswlist", plist);
		}
		if(param.isEmpty()) {
			return new SendResult("-20003","授权内容不能全部为空","");
		}
		SendResult<AuthResult> sr=StringTools.checkPswList(plist);
		if(null==callbackurl || callbackurl.equals("") || callbackurl.equals("null")) {
			sr.setResultCode("-20004");
			sr.setResultMsg("回调地址不能为空");
			return sr;
		}
		
		if(null==timeout || timeout<0) {
			sr.setResultCode("-20005");
			sr.setResultMsg("指令超时时间不能为空或小于0");
			return sr;
		}
		param.put("timeout", timeout);
		param.put("callbackurl",callbackurl);
		if("0".equals(sr.getResultCode())) {
			if(!"0".equals(sr.getResultCode())) {
				return sr;
			}else {
				String result=HttpsUtil.httpURLConnectionPOST(baseurl, "savetotalunlockpswlist", secret, param);
				sr = StringTools.getSendResultByJson(result);
			}
		}
		return sr;
	}

	@Override
	public SendResult delTotalUnlockpsw(String gatewaycode, String gatewaycode2, String roomcode,String roomcode2,String roomimei,String locktype, DelUnlockPsw dpsw,
			Integer timeout, String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param =new LinkedHashMap();
		param.put("gatewaycode", gatewaycode);
		param.put("gatewaycode2", gatewaycode2);
		param.put("roomcode", roomcode);
		param.put("roomcode2", roomcode2);
		param.put("roomimei", roomimei);
		param.put("locktype", locktype);
		param.put("pass", dpsw.getPass());
		param.put("count",dpsw.getCount());
		param.put("edate", dpsw.getEdate());
		SendResult sr=StringTools.checkTotal(param);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "deltotalunlockpsw", secret, param);
			sr = (SendResult) StringTools.getResultObject(result, SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult delTotalUnlockpswList(List<AuthDelPsw> delist) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("delist", delist);
		SendResult sr = StringTools.checkDelPswList(delist);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "deltotalunlockpswlist", secret, param);
			sr = StringTools.getSendResultByJson2(result,PswsResult.class);
		}
		return sr;
	}

	@Override
	public SendResult saveTotalRoomCard(String gatewaycode, String gatewaycode2, String roomcode, String roomcode2,
			String roomimei, String locktype, RoomCard rc, Integer timeout, String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("gatewaycode", gatewaycode);
		param.put("gatewaycode2", gatewaycode2);
		param.put("roomcode", roomcode);
		param.put("roomcode2", roomcode2);
		param.put("roomimei", roomimei);
		param.put("locktype", locktype);
		param.put("cardtype", rc.getCardtype());
		param.put("cardcode", rc.getCardcode());
		param.put("personcode", rc.getPersoncode());
		param.put("personname", rc.getPersonname());
		param.put("edate", rc.getEdate());
		param.put("openstime", rc.getOpenstime());
		param.put("openetime", rc.getOpenetime());
		param.put("opencount", rc.getOpencount());
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr = StringTools.checkTotal(param);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "savetotalroomcard", secret, param);
			sr = (SendResult) StringTools.getResultObject(result, SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult<AuthResult> saveTotalRoomCardList(List<AuthCard> clist, Integer timeout, String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		if(null!=clist&&clist.size()>0){
			param.put("cardlist", clist);
		}
		if(param.isEmpty()) {
			return new SendResult("-20003","授权内容不能全部为空","");
		}
		SendResult<AuthResult> sr = StringTools.checkCardList(clist);
		if(null==callbackurl || callbackurl.equals("") || callbackurl.equals("null")) {
			sr.setResultCode("-20004");
			sr.setResultMsg("回调地址不能为空");
			return sr;
		}
		
		if(null==timeout || timeout<0) {
			sr.setResultCode("-20005");
			sr.setResultMsg("指令超时时间不能为空或小于0");
			return sr;
		}
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		if(!"0".equals(sr.getResultCode())) {
			return sr;
		}else {
			if(!"0".equals(sr.getResultCode())) {
				return sr;
			}
		}
		
		String result=HttpsUtil.httpURLConnectionPOST(baseurl, "savetotalroomcardlist", secret, param);
		sr = StringTools.getSendResultByJson(result);
		return sr;
	}

	@Override
	public SendResult delTotalRoomCard(String gatewaycode, String gatewaycode2, String roomcode, String roomcode2,
			String roomimei, String locktype, String cardtype, String cardcode, Integer timeout, String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("gatewaycode", gatewaycode);
		param.put("gatewaycode2", gatewaycode2);
		param.put("roomcode", roomcode);
		param.put("roomcode2", roomcode2);
		param.put("roomimei", roomimei);
		param.put("locktype", locktype);
		param.put("cardtype", cardtype);
		param.put("cardcode", cardcode);
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr = StringTools.checkTotal(param);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "deltotalroomcard", secret, param);
			sr = (SendResult) StringTools.getResultObject(result, SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult<List<DelCardsResult>> delTotalRoomCardList(List<AuthDelCard> dclist) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("dclist", dclist);
		SendResult sr = StringTools.checkDelCardList(dclist);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "deltotalroomcardlist", secret, param);
			sr=StringTools.getSendResultByJson2(result,DelCardsResult.class);
		}
		return sr;
	}

	@Override
	public SendResult saveTotalRoomFinger(String gatewaycode, String gatewaycode2, String roomcode, String roomcode2,
			String roomimei, String locktype, RoomFinger rf, Integer timeout, String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("gatewaycode", gatewaycode);
		param.put("gatewaycode2", gatewaycode2);
		param.put("roomcode", roomcode);
		param.put("roomcode2", roomcode2);
		param.put("roomimei", roomimei);
		param.put("locktype", locktype);
		param.put("fingercode", rf.getFingercode());
		param.put("fingercontent", rf.getFingercontent());
		param.put("edate", rf.getEdate());
		param.put("openstime", rf.getOpenstime());
		param.put("openetime", rf.getOpenetime());
		param.put("opencount", rf.getOpencount());
		param.put("actioncount", rf.getActioncount());
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr = StringTools.checkTotal(param);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "savetotalroomfinger", secret, param);
			//StringTools.getSendResultByJson2(result,DelCardsResult.class);
			sr = (SendResult) StringTools.getResultObject(result, SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult<AuthResult> saveTotalRoomFingerList(List<AuthFinger> flist,Integer timeout,String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		if(null!=flist&&flist.size()>0) {
			param.put("finlist", flist);
		}
		if(param.isEmpty()) {
			return new SendResult("-20003","授权内容不能全部为空","");
		}
		SendResult<AuthResult> sr = StringTools.checkFingerList(flist);
		if(null==callbackurl || callbackurl.equals("") || callbackurl.equals("null")) {
			sr.setResultCode("-20004");
			sr.setResultMsg("回调地址不能为空");
			return sr;
		}
		
		if(null==timeout || timeout<0) {
			sr.setResultCode("-20005");
			sr.setResultMsg("指令超时时间不能为空或小于0");
			return sr;
		}
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		if("0".equals(sr.getResultCode())) {
			if("0".equals(sr.getResultCode())) {
				String result=HttpsUtil.httpURLConnectionPOST(baseurl, "savetotalroomfingerlist", secret, param);
				sr = StringTools.getSendResultByJson(result);
			}
		}
		return sr;
	}

	@Override
	public SendResult delTotalRoomFinger(String gatewaycode, String gatewaycode2, String roomid, String roomcode,
			String roomcode2, String roomimei, String locktype, List<DelRoomFinger> rflist, Integer timeout,
			String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("gatewaycode", gatewaycode);
		param.put("gatewaycode2", gatewaycode2);
		param.put("roomid", roomid);
		param.put("roomcode", roomcode);
		param.put("roomcode2", roomcode2);
		param.put("roomimei", roomimei);
		param.put("locktype", locktype);
		param.put("rflist", rflist);
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr = StringTools.checkTotal(param);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "deltotalroomfinger", secret, param);
			sr=StringTools.getSendResultByJson2(result,DelFingersResult.class);
		}
		return sr;
	}
	
	@Override
	public SendResult delTotalRoomFingerList(List<AuthDelFinger> dflist) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("dflist", dflist);
		SendResult sr = StringTools.checkDelFingerList(dflist);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "deltotalroomfingerlist", secret, param);
			sr =StringTools.getSendResultByJson2(result,DelFingersResult.class);
		}
		return sr;
	}
	
	@Override
	public SendResult<SyncResult> saveAuthSync(List<AuthSync> synclist) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		if(null!=synclist&&synclist.size()>0){
			param.put("synclist", synclist);
		}else {
			return new SendResult("-2003","参数不能为空","");
		}
		SendResult<SyncResult> sr = StringTools.checkSyncList(synclist);
		if(sr.getResultCode().equals("0")) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl,"savelotauthsync", secret, param);
			sr = StringTools.getSyncSendResultByJson(result);
		}
		return sr;
	}

	@Override
	public SendResult updateRoompowList(List<Roompow> powlist,Integer timeout,String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("powlist", powlist);
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr = StringTools.checkPowList(param);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl,"updateroompowlist", secret, param);
			sr =StringTools.getSendResultByJson2(result,PowResult.class);
		}
		return sr;
	}

	@Override
	public SendResult getLockStatusList(List<Room> rlist, Integer timeout, String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("rlist", rlist);
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr = StringTools.checkRoomList(param);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl,"getlockstatuslist", secret, param);
			System.out.println(result);
			sr =StringTools.getSendResultByJson2(result,RoomResult.class);
		}
		return sr;
	}
	
	@Override
	public SendResult readLockRecordList(List<Room> rlist, Integer timeout, String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("rlist", rlist);
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr = StringTools.checkRoomList(param);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl,"readLockRecordList", secret, param);
			sr =StringTools.getSendResultByJson2(result,RoomResult.class);
		}
		return sr;
	}
	@Override
	public SendResult registerDevice(String locktype,String roomimei,String lockname,String roomimsi) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("locktype", locktype);
		param.put("roomimei", roomimei);
		param.put("lockname", lockname);
		param.put("roomimsi", roomimsi);
		SendResult sr=StringTools.check(param);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl,"registerdevice", secret, param);
			JSONObject json = JSONObject.fromObject(result);
			String ar = json.getString("result");
			RegistNb rr=(RegistNb)JSONObject.toBean(JSONObject.fromObject(ar), RegistNb.class);
			sr=new SendResult(json.getString("resultCode"),json.getString("resultMsg") , "");
			sr.setResult(rr);
			//sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult updateDevice(String locktype,String roomimei,String roomdeviceid,String lockname,String roomimsi) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("locktype", locktype);
		param.put("roomimei", roomimei);
		param.put("roomdeviceid", roomdeviceid);
		param.put("lockname", lockname);
		param.put("roomimsi", roomimsi);
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

	@Override
	public SendResult setGatewayRecordBackUrl(String url) {
		// TODO Auto-generated method stub
		LinkedHashMap param =new LinkedHashMap();
		param.put("url",url);
		SendResult sr = StringTools.checkurl(param);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl,"setgatewayrecordbackurl", secret, param);
			sr=(SendResult)JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult setCardAuthBackUrl(String url) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("url", url);
		SendResult sr = StringTools.checkurl(param);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl,"setcardauthbackurl", secret, param);
			sr=(SendResult)JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult setInstallTestBackUrl(String url) {
		// TODO Auto-generated method stub
		LinkedHashMap param =new LinkedHashMap();
		param.put("url",url);
		SendResult sr = StringTools.checkurl(param);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl,"setinstalltestbackurl", secret, param);
			sr=(SendResult)JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult setFingerContentBackUrl(String url) {
		// TODO Auto-generated method stub
		LinkedHashMap param =new LinkedHashMap();
		param.put("url",url);
		SendResult sr = StringTools.checkurl(param);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl,"setfingercontentbackurl", secret, param);
			sr=(SendResult)JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult setNbLockRecordBackUrl(String url) {
		// TODO Auto-generated method stub
		LinkedHashMap param =new LinkedHashMap();
		param.put("url",url);
		SendResult sr = StringTools.checkurl(param);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl,"setnblockrecordbackurl", secret, param);
			sr=(SendResult)JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult getGatewayRecordBackUrl() {
		// TODO Auto-generated method stub
		LinkedHashMap param =new LinkedHashMap();
		SendResult sr = StringTools.getSendResult();
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl,"getGatewayRecordBackUrl", secret, param);
			sr=(SendResult)JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult getCardAuthBackUrl() {
		// TODO Auto-generated method stub
		LinkedHashMap param =new LinkedHashMap();
		SendResult sr = StringTools.getSendResult();
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl,"getcardauthbackurl", secret, param);
			sr=(SendResult)JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult getInstallTestBackUrl() {
		// TODO Auto-generated method stub
		LinkedHashMap param =new LinkedHashMap();
		SendResult sr = StringTools.getSendResult();
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl,"getinstalltestbackurl", secret, param);
			sr=(SendResult)JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult getFingerContentBackUrl() {
		// TODO Auto-generated method stub
		LinkedHashMap param =new LinkedHashMap();
		SendResult sr = StringTools.getSendResult();
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl,"getfingercontentbackurl", secret, param);
			sr=(SendResult)JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult getNbLockRecordBackUrl() {
		// TODO Auto-generated method stub
		LinkedHashMap param =new LinkedHashMap();
		SendResult sr = StringTools.getSendResult();
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl,"getnblockrecordbackurl", secret, param);
			sr=(SendResult)JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
			//sr=(SendResult) StringTools.getResultObject(result, SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult setNbRoomParamasBackUrl(String url) {
		// TODO Auto-generated method stub
		LinkedHashMap param =new LinkedHashMap();
		param.put("url",url);
		SendResult sr = StringTools.checkurl(param);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl,"setnbroomparamasbackurl", secret, param);
			sr=(SendResult)JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult getNbRoomParamasBackUrl() {
		// TODO Auto-generated method stub
		LinkedHashMap param =new LinkedHashMap();
		SendResult sr = StringTools.getSendResult();
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl,"getnbroomparamasbackurl", secret, param);
			sr=(SendResult)JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
			//sr=(SendResult) StringTools.getResultObject(result, SendResult.class);
		}
		return sr;
	}



	

	
	
}
