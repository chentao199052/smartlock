package com.qingyi.send.info.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;

import com.qingyi.model.SendResult;
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
	public SendResult getLockStaus(String gatewaycode, String gatewaycode2, String roomcode, String orderid, String callbackurl) {
		// TODO Auto-generated method stub
		LinkedHashMap param=new LinkedHashMap();
		param.put("gatewaycode", gatewaycode);
		param.put("gatewaycode2", gatewaycode2);
		param.put("roomcode", roomcode);
		param.put("orderid", orderid);
		param.put("callbackurl", callbackurl);
		String result=HttpsUtil.httpURLConnectionPOST(baseurl, "getlockstaus", secret, param);
		SendResult sr=(SendResult) StringTools.getResultObject(result,SendResult.class);
		return sr;
	}

	
	

}
