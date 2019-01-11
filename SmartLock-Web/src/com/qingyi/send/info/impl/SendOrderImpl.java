package com.qingyi.send.info.impl;
import java.util.LinkedHashMap;
import java.util.List;

import com.qingyi.model.Command;
import com.qingyi.model.DelRoomFinger;
import com.qingyi.model.DelUnlockPsw;
import com.qingyi.model.NBUnlockPsw;
import com.qingyi.model.Room;
import com.qingyi.model.RoomCard;
import com.qingyi.model.RoomCardxzsx;
import com.qingyi.model.RoomFinger;
import com.qingyi.model.RoomFingerxzsx;
import com.qingyi.model.SendResult;
import com.qingyi.model.UnlockPsw;
import com.qingyi.send.info.SendOrderInfo;
import com.qingyi.util.Constant;
import com.qingyi.util.HttpsUtil;
import com.qingyi.util.StringTools;

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
			sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
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
			sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult readLockRecord(String gatewaycode, String gatewaycode2, String roomcode, Integer timeout,
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
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "readlockrecord", secret, param);
			sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
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
		param.put("timeout", timeout);
		param.put("pass", psw.getPass());
		param.put("count", psw.getCount());
		param.put("edate", psw.getEdate());
		param.put("unlockstime", psw.getUnlockstime());
		param.put("unlocketime", psw.getUnlocketime());
		param.put("callbackurl", callbackurl);
		SendResult sr=StringTools.check(param);
		if(sr.getResultCode().equals("0")) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "saveUnlockPsw", secret, param);
			sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
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
			sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
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
			sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
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
			sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
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
			sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult delRoomCard(String gatewaycode, String gatewaycode2, String roomcode, String cardtype,
			String cardcode, Integer timeout, String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("gatewaycode", gatewaycode);
		param.put("gatewaycode2", gatewaycode2);
		param.put("roomcode", roomcode);
		param.put("cardtype", cardtype);
		param.put("cardcode", cardcode);
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr=StringTools.check(param);
		if(sr.getResultCode().equals("0")) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "delroomcard", secret, param);
			sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult delRoomFinger(String gatewaycode, String gatewaycode2,String roomid,String roomcode, 
			DelRoomFinger rflist, Integer timeout, String callbackurl) {
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
		if(sr.getResultCode().equals("0")) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "delroomfinger", secret, param);
			sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
		}
		return sr;
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
			sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
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
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "updateRoomFiger", secret, param);
			sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
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
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "updateRoomForcelock", secret, param);
			sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
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
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "updateRoompow", secret, param);
			sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
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
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "updateRoomWorkmode", secret, param);
			sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
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
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "updateRoomNetmode", secret, param);
			sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
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
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "saveFingerReagy", secret, param);
			sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
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
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "getGatewaystatus", secret, param);
			sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
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
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "updateGatewayRooms", secret, param);
			sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
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
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "readGatewayRecord", secret, param);
			sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
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
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "gatewayInitialize", secret, param);
			sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
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
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "updateGatewaypow", secret, param);
			sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
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
			String result=HttpsUtil.httpURLConnectionPOST(baseurl,"clearsGatewaytatus", secret, param);
			sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult updateRoomCardxzsx(String gatewaycode, String gatewaycode2, String roomcode, RoomCardxzsx xzsx,
			Integer timeout, String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("gatewaycode", gatewaycode);
		param.put("gatewaycode2", gatewaycode2);
		param.put("roomcode", roomcode);
		param.put("cardtype", xzsx.getCardtype());
		param.put("cardcode", xzsx.getCardcode());
		param.put("personcode", xzsx.getPersoncode());
		param.put("personname", xzsx.getPersonname());
		param.put("rcusecount", xzsx.getRcusecount());
		param.put("cardunlocktype", xzsx.getCardunlocktype());
		param.put("cardpass", xzsx.getCardpass());
		param.put("empedate", xzsx.getEmpedate());
		param.put("cardedate", xzsx.getCardedate());
		param.put("openstime", xzsx.getOpenstime());
		param.put("openetime", xzsx.getOpenetime());
		param.put("rcid", xzsx.getRcid());
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr=StringTools.check(param);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl,"updateRoomCardxzsx", secret, param);
			sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
		}
		return sr;
	}
	@Override
	public SendResult updateRoomFingerxzsx(String gatewaycode,String gatewaycode2,String roomcode,RoomFingerxzsx xzsx,Integer timeout,String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("gatewaycode", gatewaycode);
		param.put("gatewaycode2", gatewaycode2);
		param.put("roomcode", roomcode);
		param.put("fingercode", xzsx.getFingercode());
		param.put("fingercontent", xzsx.getFingercontent());
		param.put("fingerseq", xzsx.getFingerseq());
		param.put("count", xzsx.getCount());
		param.put("rfid", xzsx.getRfid());
		param.put("openstime", xzsx.getOpenstime());
		param.put("openetime", xzsx.getOpenetime());
		param.put("empedate", xzsx.getEmpedate());
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr=StringTools.check(param);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl,"updateRoomFingerxzsx", secret, param);
			sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
		}
		return sr;
	}

}
