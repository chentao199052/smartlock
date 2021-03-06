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
import com.qingyi.model.ClearCP;
import com.qingyi.model.Command;
import com.qingyi.model.DelCardsResult;
import com.qingyi.model.DelFingersResult;
import com.qingyi.model.DelLog;
import com.qingyi.model.DelPswsResult;
import com.qingyi.model.DelRoomFinger;
import com.qingyi.model.DelUnlockPsw;
import com.qingyi.model.FingersResult;
import com.qingyi.model.LockResult;
import com.qingyi.model.Log;
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
	public SendResult readLockRecord(String gatewaycode, String gatewaycode2, String roomcode,Integer timeout,
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
	public SendResult syncRoomCardAndPsw(String gatewaycode, String gatewaycode2, String roomcode,String roomcode2,String roomimei,String locktype,
			List<RoomCard> rclist, List<UnlockPsw> pswlist, Integer timeout, String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		if(locktype.equals("1")) {
			param.put("gatewaycode", gatewaycode);
			param.put("gatewaycode2", gatewaycode2);
			param.put("roomcode", roomcode);
		}else {
			param.put("roomcode2", roomcode2);
			param.put("roomimei", roomimei);
		}
		param.put("locktype", locktype);
		if(null!=rclist && rclist.size()>0) {
			param.put("rclist", rclist);
		}
		if(null!=pswlist && pswlist.size()>0) {
			param.put("pswlist", pswlist);
		}
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr=StringTools.checksyncOne(param);
		if(sr.getResultCode().equals("0")) {
			if((null==rclist || rclist.size()<=0) && (null==pswlist || pswlist.size()<=0)) {
				return new SendResult("-20003","卡密同步数据不能全空","");
			}else {
				sr = StringTools.checkRoomCardList(rclist);
				if(sr.getResultCode().equals("0")) {
					sr = StringTools.checkUnlockPswList(pswlist);
					if(sr.getResultCode().equals("0")) {
						String result=HttpsUtil.httpURLConnectionPOST(baseurl, "syncroomcardandpsw", secret, param);
						sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
					}
				}
			}
		}
		return sr;
	}

	@Override
	public SendResult syncRoomFinger(String gatewaycode, String gatewaycode2, String roomcode,String roomcode2,String roomimei,String locktype, List<RoomFinger> rflist,
			Integer timeout, String callbackurl) {
		LinkedHashMap param=new LinkedHashMap();
		if(locktype.equals("1")) {
			param.put("gatewaycode", gatewaycode);
			param.put("gatewaycode2", gatewaycode2);
			param.put("roomcode", roomcode);
		}else {
			param.put("roomcode2", roomcode2);
			param.put("roomimei", roomimei);
		}
		param.put("locktype", locktype);
		param.put("rflist", rflist);
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr=StringTools.checksyncOne(param);
		if(null==rflist || rflist.size()<=0) {
			return new SendResult("-20003","指纹同步数据不能全空","");
		}
		if(sr.getResultCode().equals("0")) {
			sr = StringTools.checkRoomFingerList(rflist);
			if(sr.getResultCode().equals("0")) {
				String result=HttpsUtil.httpURLConnectionPOST(baseurl, "syncroomfinger", secret, param);
				sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
			}
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
		if(plist==null || plist.size()==0) {
			return new SendResult<>("10007", "参数不能为空","");
		}else {
			param.put("plist", plist);
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
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr=StringTools.checkTotal(param);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "deltotalunlockpsw", secret, param);
			sr = (SendResult) StringTools.getResultObject(result, SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult delTotalUnlockpswList(List<AuthDelPsw> delist,Integer timeout,String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("delist", delist);
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr = StringTools.checkDelPswList(delist);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "deltotalunlockpswlist", secret, param);
			System.out.println(result);
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
		param.put("clist", clist);
		SendResult sr = StringTools.checkCardList(clist);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "savetotalroomcardlist", secret, param);
			sr = StringTools.getSendResultByJson2(result,CardsResult.class);
			//sr = (SendResult) StringTools.getResultObject(result, SendResult.class);
		}
		if(param.isEmpty()) {
			return new SendResult("-20003","授权内容不能全部为空","");
		}
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
	public SendResult<List<DelCardsResult>> delTotalRoomCardList(List<AuthDelCard> dclist,Integer timeout,String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("dclist", dclist);
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
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
	public SendResult delTotalRoomFingerList(List<AuthDelFinger> dflist,Integer timeout,String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("dflist", dflist);
		param.put("timeout", timeout);
		param.put("callbackurl", callbackurl);
		SendResult sr = StringTools.checkDelFingerList(dflist);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl, "deltotalroomfingerlist", secret, param);
			System.out.println(result);
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
	public SendResult delDevice(String roomdeviceid,String roomtxtype ) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("roomdeviceid", roomdeviceid);
		param.put("roomtxtype", roomtxtype);
		SendResult sr=StringTools.check(param);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl,"deldevice", secret, param);
			//sr=(SendResult)StringTools.getResultObject(result, SendResult.class);
			sr=(SendResult) JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult InitiDevice(String locktype, String roomdeviceid, String lockname) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("locktype", locktype);
		param.put("roomdeviceid", roomdeviceid);
		param.put("lockname", lockname);
		SendResult sr=StringTools.check(param);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl,"initidevice", secret, param);
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
			String result=HttpsUtil.httpURLConnectionPOST(baseurl,"getgatewayrecordbackurl", secret, param);
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

	@Override
	public SendResult saveLog(List<Log> loglist) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("loglist", loglist);
		SendResult  sr = StringTools.checkLog(loglist);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl,"savelog", secret, param);
			JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult setClosegatewaybackUrl(String url) {
		// TODO Auto-generated method stub
		LinkedHashMap param =new LinkedHashMap();
		param.put("url", url);
		SendResult sr = StringTools.checkurl(param);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl,"setclosegatewaybackurl", secret, param);
			sr=(SendResult)JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
			//sr=(SendResult) StringTools.getResultObject(result, SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult setIdLebackUrl(String url) {
		// TODO Auto-generated method stub
		LinkedHashMap param =new LinkedHashMap();
		param.put("url", url);
		SendResult sr = StringTools.checkurl(param);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl,"setidlebackurl", secret, param);
			sr=(SendResult)JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
			//sr=(SendResult) StringTools.getResultObject(result, SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult getClosegatewaybackUrl(String url) {
		// TODO Auto-generated method stub
		LinkedHashMap param =new LinkedHashMap();
		SendResult sr = StringTools.getSendResult();
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl,"getclosegatewaybackurl", secret, param);
			sr=(SendResult)JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult getIdLebackUrl(String url) {
		// TODO Auto-generated method stub
		LinkedHashMap param =new LinkedHashMap();
		SendResult sr = StringTools.getSendResult();
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl,"getidlebackurl", secret, param);
			sr=(SendResult)JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
		}
		return sr;
	}

	@Override
	public SendResult delLog(List<DelLog> dloglist) {
		// TODO Auto-generated method stub
		LinkedHashMap param =new LinkedHashMap();
		param.put("dloglist", dloglist);
		SendResult sr = StringTools.checkdelLog(dloglist);
		if("0".equals(sr.getResultCode())) {
			String result=HttpsUtil.httpURLConnectionPOST(baseurl,"dellog", secret, param);
			sr=(SendResult)JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
		}
		return sr;
	}

}
