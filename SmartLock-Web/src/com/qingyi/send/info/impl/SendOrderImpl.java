package com.qingyi.send.info.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.qingyi.model.RoomCard;
import com.qingyi.model.RoomFinger;
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
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "readlockrecord", secret, param);
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
	public SendResult delRoomFinger(String gatewaycode, String gatewaycode2, String roomcode, 
			String fingercode, Integer timeout, String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("gatewaycode", gatewaycode);
		param.put("gatewaycode2", gatewaycode2);
		param.put("roomcode", roomcode);
		param.put("fingercode", fingercode);
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

}
