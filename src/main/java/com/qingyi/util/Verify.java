package com.qingyi.util;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import com.qingyi.model.ReceiveResult;
public class Verify {

	public static ReceiveResult verify(String content,String sysdate,String verify,String secret,String timeout){
		if(sysdate==null||sysdate.equals("")||sysdate.equals("null")) {
			return getErrResult(100001, "时间因子为必传参数！");
		}
		if(verify==null||verify.equals("")||verify.equals("null")) {
			return getErrResult(100002, "校验为必传参数！");
		}
		String md5=StringTools.getMd5(content+sysdate+secret);
		System.out.println("加密前:"+content+sysdate+secret);
		System.out.println("加密后:"+md5);
		verify=verify.toLowerCase();
		if(verify.equals(md5)) {
			Calendar cal = Calendar.getInstance(); 
			Long now=cal.getTimeInMillis();
			Long ss = (now-Long.valueOf(sysdate)) / (1000);
			if(ss<=Integer.valueOf(timeout)){
	    		return getErrResult(0, "");
			}else {
				return getErrResult(100004, "验证失败，校验码过期！");
			}
		}else {
			return getErrResult(100003, "验证失败，请检查秘钥是否正确！");
		}
	}
	
	public static ReceiveResult getErrResult(Integer errcode,String errmsg) {
		ReceiveResult result=new ReceiveResult();
		result.setResultCode(errcode+"");
		result.setResultMsg(errmsg);
		return result;
	}
	
}
