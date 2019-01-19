package com.qingyi.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.qingyi.model.AuthCard;
import com.qingyi.model.AuthDelCard;
import com.qingyi.model.AuthDelFinger;
import com.qingyi.model.AuthDelPsw;
import com.qingyi.model.AuthFinger;
import com.qingyi.model.AuthPsw;
import com.qingyi.model.AuthResult;
import com.qingyi.model.CardsResult;
import com.qingyi.model.DelCardsResult;
import com.qingyi.model.DelFingersResult;
import com.qingyi.model.DelPswsResult;
import com.qingyi.model.FingersResult;
import com.qingyi.model.PswsResult;
import com.qingyi.model.RoomCard;
import com.qingyi.model.SendResult;
import com.qingyi.model.UnlockPsw;
import com.qingyi.send.info.SendOrderInfo;
import com.qingyi.send.info.impl.SendOrderImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;




public class StringTools {
	

	
	public static Object mapToBean(Class<?> clazz, Map map) throws Exception {
        Object javabean = clazz.newInstance(); // 鏋勫缓瀵硅薄
        Method[] methods = clazz.getMethods(); // 鑾峰彇鎵�鏈夋柟娉�
        for (Method method : methods) {
            if (method.getName().startsWith("set")) {
                String field = method.getName(); // 鎴彇灞炴�у悕
                field = field.substring(field.indexOf("set") + 3);
                field = field.toLowerCase().charAt(0) + field.substring(1);
                if (map.containsKey(field)) {
                    method.invoke(javabean, map.get(field));
                }
            }
        }
        return javabean;
    }
	
	public static Map stringToMap(String result) {
		Map map=new HashMap();
		String json2=result.substring(1,result.length()-1);
		String arr[]=json2.split(",");
		for(int i=0;i<arr.length;i++) {
			String a[]=arr[i].split(":");
			map.put(a[0].substring(1, a[0].length()-1), a[1].substring(1, a[1].length()-1));
		}
		return map;
	}
	public static Map stringToMap2(String result) {
		String ss=result.substring(1,result.length()-1);
		String[] s=ss.split(",");
		Map map =new HashMap();
		outter:
		for(int i=0; i<s.length ;i++) {
			if(s[i].contains(":")) {
			String[] str=s[i].split(":");
			String key=str[0].replace("\"", "").trim();
			map.put(key, str[1].replace("\"", "").trim());
			intter:
			for(int j=i+1;j<s.length;j++) {
				String r=s[j];
				if(!r.contains(":")) {
					String va=map.get(key).toString()+","+r.replace("\"", "").trim();
					map.put(key, va.trim());
				}else {
					continue outter;
				}
			}
			}
		}
		return map;
	}
	
	public static String beanToString(List<Object> list) {
		
		String json="[";
		if(list==null || list.size()==0){
			return "";
		}
		for(int j=0;j<list.size();j++) {
			Object obj=list.get(j);
			json+="{";
			Field[] fields=obj.getClass().getDeclaredFields(); 
	        try {
				for(int i=0;i<fields.length;i++){  
	//            System.out.println(fields[i].getType());  
				    String name=fields[i].getName(); 
				    String firstLetter = name.substring(0, 1).toUpperCase();    
				    String getter = "get" + firstLetter + name.substring(1);    
				    Method method = obj.getClass().getMethod(getter, new Class[] {});    
				    Object value = method.invoke(obj, new Object[] {});
				    json+="\""+name+"\":\""+value+"\""+(i==fields.length-1?"":",");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        json+="}"+(j==list.size()-1?"":",");
		}
		json+="]";
        return json;  
	}
	
	public static Object getResultObject(String result,Class<?> clazz) {
		Object obj=null;
		HashMap map=new HashMap();
		try {
			String json2=result.substring(1,result.length()-1);
			String arr[]=json2.split(",");
			for(int i=0;i<arr.length;i++) {
				System.out.println(arr[i]);
				String a[]=arr[i].split(":");
				map.put(a[0].substring(1, a[0].length()-1), a[1].substring(1, a[1].length()-1));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("resultCode", "0");
			map.put("resultMsg", "解析失败！");
		}
		try {
			obj=StringTools.mapToBean(clazz, map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
	
	/*public static Object getResultObject(String result,Class<?> clazz) {
		Object obj=null;
		HashMap map=new HashMap();
		try {
			String json2=result.substring(1,result.length()-1);
			String arr[]=json2.split(",");
			for(int i=0;i<arr.length;i++) {
				System.out.println(arr[i]);
				String a[]=arr[i].split(":");
				map.put(a[0].substring(1, a[0].length()-1), a[1].substring(1, a[1].length()-1));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("resultCode", "0");
			map.put("resultMsg", "瑙ｆ瀽缁撴灉鍑洪敊锛�");
		}
		try {
			obj=StringTools.mapToBean(clazz, map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}*/

	public static String getMd5(String plainText) {  
        try {  
            MessageDigest md = MessageDigest.getInstance("MD5");  
            md.update(plainText.getBytes());  
            byte b[] = md.digest();  
            int i;  
            StringBuffer buf = new StringBuffer("");  
            for (int offset = 0; offset < b.length; offset++) {  
                i = b[offset];  
                if (i < 0)  
                    i += 256;  
                if (i < 16)  
                    buf.append("0");  
                buf.append(Integer.toHexString(i));  
            }  
            //鎵撳嵃鐢熸垚鐨凪D5鍔犲瘑淇℃伅鎽樿
            //32浣嶅姞瀵�  
            // return buf.toString();  
            return buf.toString().toLowerCase();
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
	}
	
	public static SendResult checkCardList(List<AuthCard> authlist) {
		SendResult sr=new SendResult("0","","");
		
		if(null==authlist || authlist.size()<=0) {
			return sr;
		}
		for(int i=0;i<authlist.size();i++) {
			AuthCard au = authlist.get(i);
			if(null==au.getLocktype()) {
				sr.setResultCode("-20002");
				sr.setResultMsg("门锁类型不能为空");
				return sr;
			}
			if(au.getLocktype()<1 || au.getLocktype()>4) {
				sr.setResultCode("-20003");
				sr.setResultMsg("门锁类型不存在");
				return sr;
			}
			
			if(null==au.getRoomcode2()||au.getRoomcode2().equals("")||au.getRoomcode2().equals("null")) {
				sr.setResultCode("-10019");
				sr.setResultMsg("门锁唯一ID不能为空");
				return sr;
			}else if(au.getRoomcode2().length()!=10||au.getRoomcode2().toUpperCase().matches(".*[G-Z].*")) {
				sr.setResultCode("-10020");
				sr.setResultMsg("门锁唯一ID必须为10位十六进制字符串");
				return sr;
			}
			if(au.getLocktype()==1) {
				if(null==au.getRoomcode()||au.getRoomcode().equals("")||au.getRoomcode().equals("null")) {
					sr.setResultCode("-10005");
					sr.setResultMsg("无线联网锁门锁编号不能为空");
					return sr;
				}else if(au.getRoomcode().length()!=4||au.getRoomcode().toUpperCase().matches(".*[G-Z].*")) {
					sr.setResultCode("-10006");
					sr.setResultMsg("门锁编号必须为4位十六进制字符串");
					return sr;
				}
				if(null==au.getGatewaycode()||au.getGatewaycode().equals("")||au.getGatewaycode().equals("null")) {
					sr.setResultCode("-10001");
					sr.setResultMsg("无线联网锁网关通讯ID不能为空");
					return sr;
				}else if(au.getGatewaycode().length()!=10||au.getGatewaycode().toUpperCase().matches(".*[G-Z].*")) {
					sr.setResultCode("-10002");
					sr.setResultMsg("网关通讯ID必须为10位十六进制字符串");
					return sr;
				}
				if(null==au.getGatewaycode2()||au.getGatewaycode2().equals("")||au.getGatewaycode2().equals("null")) {
					sr.setResultCode("-10003");
					sr.setResultMsg("无线联网锁网关唯一ID不能为空");
					return sr;
				}else if(au.getGatewaycode2().length()!=10||au.getGatewaycode2().toUpperCase().matches(".*[G-Z].*")) {
					sr.setResultCode("-10004");
					sr.setResultMsg("网关唯一ID必须为10位十六进制字符串");
					return sr;
				}
			}else {
				if(null==au.getImei()||au.getImei().equals("")||au.getImei().equals("null")) {
					sr.setResultCode("-10042");
					sr.setResultMsg("IMEI不能为空");
					return sr;
				}
			}
			
			if(null==au.getCardcode()||au.getCardcode().equals("")||au.getCardcode().equals("null")) {
				sr.setResultCode("-10028");
				sr.setResultMsg("卡号不能为空");
				return sr;
			}
			
			if(null==au.getCardtype()||au.getCardtype().equals("")||au.getCardtype().equals("null")) {
				sr.setResultCode("-20006");
				sr.setResultMsg("卡片类型不能为空");
				return sr;
			}
			
			if(au.getCardtype().equals("开门卡")||au.getCardtype().equals("管理卡")||au.getCardtype().equals("授权卡")) {
				if(au.getCardcode().length()!=8||au.getCardcode().toUpperCase().matches(".*[G-Z].*")) {
					sr.setResultCode("-10029");
					sr.setResultMsg("开门卡/管理卡/授权卡必须为8位十六进制字符串");
					return sr;
				}
			}else if(au.getCardtype().equals("身份证")) {
				if(au.getCardcode().length()!=16||au.getCardcode().toUpperCase().matches(".*[G-Z].*")) {
					sr.setResultCode("-10030");
					sr.setResultMsg("身份证必须为16位十六进制字符串");
					return sr;
				}
			}
				
			if(null==au.getOpenstime()||au.getOpenstime().equals("")||au.getOpenstime().equals("null")) {
				sr.setResultCode("-10022");
				sr.setResultMsg("可开门时间段开始时间不能为空");
				return sr;
			}else if(au.getOpenstime().length()!=5) {
				sr.setResultCode("-10023");
				sr.setResultMsg("可开门时间段开始时间格式为XX:XX，如00:00");
				return sr;
			}else if(!au.getOpenstime().contains(":")) {
				sr.setResultCode("-10023");
				sr.setResultMsg("可开门时间段开始时间格式为XX:XX，如00:00");
				return sr;
			}else {
				String t = au.getOpenstime().replace(":", "");
				if(t.length()!=4||!t.matches("\\d+")) {
					sr.setResultCode("-10023");
					sr.setResultMsg("可开门时间段开始时间格式为XX:XX，如00:00");
					return sr;
				}
			}
				
			if(null==au.getOpenetime()||au.getOpenetime().equals("")||au.getOpenetime().equals("null")) {
				sr.setResultCode("-10024");
				sr.setResultMsg("可开门时间段结束时间不能为空");
				return sr;
			}else if(au.getOpenetime().length()!=5) {
				sr.setResultCode("-10025");
				sr.setResultMsg("可开门时间段结束时间格式为XX:XX，如00:00");
				return sr;
			}else if(!au.getOpenetime().contains(":")) {
				sr.setResultCode("-10025");
				sr.setResultMsg("可开门时间段结束时间格式为XX:XX，如00:00");
				return sr;
			}else {
				String t = au.getOpenetime().replace(":", "");
				if(t.length()!=4||!t.matches("[0-9]+")) {
					sr.setResultCode("-10025");
					sr.setResultMsg("可开门时间段结束时间格式为XX:XX，如00:00");
					return sr;
				}
			}
			
			if(null==au.getEdate()||au.getEdate().equals("")||au.getEdate().equals("null")) {
				sr.setResultCode("-10012");
				sr.setResultMsg("授权结束时间不能为空");
				return sr;
			}else if(!au.getEdate().equals("-1")&&(au.getEdate().length()!=10||!au.getEdate().matches("\\d+"))) {
				sr.setResultCode("-10013");
				sr.setResultMsg("授权结束时间格式为yyMMddHHmm");
				return sr;
			}
			
			if(null==au.getOpencount()||au.getOpencount().equals("")||au.getOpencount().equals("null")) {
				sr.setResultCode("-10010");
				sr.setResultMsg("可开门次数不能为空");
				return sr;
			}else if(!au.getOpencount().matches("[0-9]+|(-1)")) {
				sr.setResultCode("-10011");
				sr.setResultMsg("可开门次数必须为0-254数字,0表示不限次数");
				return sr;
			}
			
			if(null==au.getCallbackurl() || au.getCallbackurl().equals("") || au.getCallbackurl().equals("null")) {
				sr.setResultCode("-20004");
				sr.setResultMsg("回调地址不能为空");
				return sr;
			}
			
			if(null==au.getTimeout() || au.getTimeout()<0) {
				sr.setResultCode("-20005");
				sr.setResultMsg("指令超时时间不能为空");
				return sr;
			}
		}
		return sr;
	}

	public static SendResult checkDelCardList(List<AuthDelCard> authlist) {
		SendResult sr=new SendResult("0","","");
		if(null==authlist || authlist.size()<=0) {
			return sr;
		}
		for(int i=0;i<authlist.size();i++) {
			AuthDelCard au = authlist.get(i);
			if(null==au.getLocktype()) {
				sr.setResultCode("-20002");
				sr.setResultMsg("门锁类型不能为空");
				return sr;
			}
			if(au.getLocktype()<1 || au.getLocktype()>4) {
				sr.setResultCode("-20003");
				sr.setResultMsg("门锁类型不存在");
				return sr;
			}
			
			if(null==au.getRoomcode2()||au.getRoomcode2().equals("")||au.getRoomcode2().equals("null")) {
				sr.setResultCode("-10019");
				sr.setResultMsg("门锁唯一ID不能为空");
				return sr;
			}else if(au.getRoomcode2().length()!=10||au.getRoomcode2().toUpperCase().matches(".*[G-Z].*")) {
				sr.setResultCode("-10020");
				sr.setResultMsg("门锁唯一ID必须为10位十六进制字符串");
				return sr;
			}
			if(au.getLocktype()==1) {
				if(null==au.getRoomcode()||au.getRoomcode().equals("")||au.getRoomcode().equals("null")) {
					sr.setResultCode("-10005");
					sr.setResultMsg("无线联网锁门锁编号不能为空");
					return sr;
				}else if(au.getRoomcode().length()!=4||au.getRoomcode().toUpperCase().matches(".*[G-Z].*")) {
					sr.setResultCode("-10006");
					sr.setResultMsg("门锁编号必须为4位十六进制字符串");
					return sr;
				}
				if(null==au.getGatewaycode()||au.getGatewaycode().equals("")||au.getGatewaycode().equals("null")) {
					sr.setResultCode("-10001");
					sr.setResultMsg("无线联网锁网关通讯ID不能为空");
					return sr;
				}else if(au.getGatewaycode().length()!=10||au.getGatewaycode().toUpperCase().matches(".*[G-Z].*")) {
					sr.setResultCode("-10002");
					sr.setResultMsg("网关通讯ID必须为10位十六进制字符串");
					return sr;
				}
				if(null==au.getGatewaycode2()||au.getGatewaycode2().equals("")||au.getGatewaycode2().equals("null")) {
					sr.setResultCode("-10003");
					sr.setResultMsg("无线联网锁网关唯一ID不能为空");
					return sr;
				}else if(au.getGatewaycode2().length()!=10||au.getGatewaycode2().toUpperCase().matches(".*[G-Z].*")) {
					sr.setResultCode("-10004");
					sr.setResultMsg("网关唯一ID必须为10位十六进制字符串");
					return sr;
				}
			}else {
				if(null==au.getImei()||au.getImei().equals("")||au.getImei().equals("null")) {
					sr.setResultCode("-10042");
					sr.setResultMsg("IMEI不能为空");
					return sr;
				}
			}
			
			if(null==au.getCardcode()||au.getCardcode().equals("")||au.getCardcode().equals("null")) {
				sr.setResultCode("-10028");
				sr.setResultMsg("卡号不能为空");
				return sr;
			}
			
			if((au.getCardcode().length()!=8 && au.getCardcode().length()!=16)||au.getCardcode().toUpperCase().matches(".*[G-Z].*")) {
				sr.setResultCode("-10029");
				sr.setResultMsg("开门卡，管理卡，授权卡卡号必须为8位（身份证16位）十六进制字符串");
				return sr;
			}
			
			if(null==au.getCallbackurl() || au.getCallbackurl().equals("") || au.getCallbackurl().equals("null")) {
				sr.setResultCode("-20004");
				sr.setResultMsg("回调地址不能为空");
				return sr;
			}
			
			if(null==au.getTimeout() || au.getTimeout()<0) {
				sr.setResultCode("-20005");
				sr.setResultMsg("指令超时时间不能为空");
				return sr;
			}
		}
		return sr;
	}
	
	public static SendResult checkFingerList(List<AuthFinger> authlist) {
		SendResult sr=new SendResult("0","","");
		if(null==authlist || authlist.size()<=0) {
			return sr;
		}
		for(int i=0;i<authlist.size();i++) {
			AuthFinger au = authlist.get(i);
			if(null==au.getLocktype()) {
				sr.setResultCode("-20002");
				sr.setResultMsg("门锁类型不能为空");
				return sr;
			}
			if(au.getLocktype()<1 || au.getLocktype()>4) {
				sr.setResultCode("-20003");
				sr.setResultMsg("门锁类型不存在");
				return sr;
			}
			
			if(null==au.getRoomcode2()||au.getRoomcode2().equals("")||au.getRoomcode2().equals("null")) {
				sr.setResultCode("-10019");
				sr.setResultMsg("门锁唯一ID不能为空");
				return sr;
			}else if(au.getRoomcode2().length()!=10||au.getRoomcode2().toUpperCase().matches(".*[G-Z].*")) {
				sr.setResultCode("-10020");
				sr.setResultMsg("门锁唯一ID必须为10位十六进制字符串");
				return sr;
			}
			if(au.getLocktype()==1) {
				if(null==au.getRoomcode()||au.getRoomcode().equals("")||au.getRoomcode().equals("null")) {
					sr.setResultCode("-10005");
					sr.setResultMsg("无线联网锁门锁编号不能为空");
					return sr;
				}else if(au.getRoomcode().length()!=4||au.getRoomcode().toUpperCase().matches(".*[G-Z].*")) {
					sr.setResultCode("-10006");
					sr.setResultMsg("门锁编号必须为4位十六进制字符串");
					return sr;
				}
				if(null==au.getGatewaycode()||au.getGatewaycode().equals("")||au.getGatewaycode().equals("null")) {
					sr.setResultCode("-10001");
					sr.setResultMsg("无线联网锁网关通讯ID不能为空");
					return sr;
				}else if(au.getGatewaycode().length()!=10||au.getGatewaycode().toUpperCase().matches(".*[G-Z].*")) {
					sr.setResultCode("-10002");
					sr.setResultMsg("网关通讯ID必须为10位十六进制字符串");
					return sr;
				}
				if(null==au.getGatewaycode2()||au.getGatewaycode2().equals("")||au.getGatewaycode2().equals("null")) {
					sr.setResultCode("-10003");
					sr.setResultMsg("无线联网锁网关唯一ID不能为空");
					return sr;
				}else if(au.getGatewaycode2().length()!=10||au.getGatewaycode2().toUpperCase().matches(".*[G-Z].*")) {
					sr.setResultCode("-10004");
					sr.setResultMsg("网关唯一ID必须为10位十六进制字符串");
					return sr;
				}
			}else {
				if(null==au.getImei()||au.getImei().equals("")||au.getImei().equals("null")) {
					sr.setResultCode("-10042");
					sr.setResultMsg("IMEI不能为空");
					return sr;
				}
			}
			
			if(null==au.getActioncount()||au.getActioncount().equals("")||au.getActioncount().equals("null")) {
				sr.setResultCode("-10039");
				sr.setResultMsg("开门需按指纹次数不能为空");
				return sr;
			}else if(!au.getActioncount().matches("[0-9]*")) {
				sr.setResultCode("-10040");
				sr.setResultMsg("开门需按指纹次数必须为数字");
				return sr;
			}
			
			if(null==au.getFingercode()||au.getFingercode().equals("")||au.getFingercode().equals("null")) {
				sr.setResultCode("-10035");
				sr.setResultMsg("指纹编号不能为空");
				return sr;
			}else if(au.getFingercode().length()!=8||au.getFingercode().toUpperCase().matches(".*[G-Z].*")) {
				sr.setResultCode("-10036");
				sr.setResultMsg("指纹编号必须为8位十六进制字符串");
				return sr;
			}
			if(null==au.getFingercontent()||au.getFingercontent().equals("")||au.getFingercontent().equals("null")) {
				sr.setResultCode("-10037");
				sr.setResultMsg("指纹特征码不能为空");
				return sr;
			}else if(au.getFingercontent().length()!=988||au.getFingercontent().toUpperCase().matches(".*[G-Z].*")) {
				sr.setResultCode("-10038");
				sr.setResultMsg("指纹特征码必须为988位十六进制字符串");
				return sr;
			}
			
			
			if(null==au.getOpenstime()||au.getOpenstime().equals("")||au.getOpenstime().equals("null")) {
				sr.setResultCode("-10022");
				sr.setResultMsg("可开门时间段开始时间不能为空");
				return sr;
			}else if(au.getOpenstime().length()!=5) {
				sr.setResultCode("-10023");
				sr.setResultMsg("可开门时间段开始时间格式为XX:XX，如00:00");
				return sr;
			}else if(!au.getOpenstime().contains(":")) {
				sr.setResultCode("-10023");
				sr.setResultMsg("可开门时间段开始时间格式为XX:XX，如00:00");
				return sr;
			}else {
				String t = au.getOpenstime().replace(":", "");
				if(t.length()!=4||!t.matches("\\d+")) {
					sr.setResultCode("-10023");
					sr.setResultMsg("可开门时间段开始时间格式为XX:XX，如00:00");
					return sr;
				}
			}
				
			if(null==au.getOpenetime()||au.getOpenetime().equals("")||au.getOpenetime().equals("null")) {
				sr.setResultCode("-10024");
				sr.setResultMsg("可开门时间段结束时间不能为空");
				return sr;
			}else if(au.getOpenetime().length()!=5) {
				sr.setResultCode("-10025");
				sr.setResultMsg("可开门时间段结束时间格式为XX:XX，如00:00");
				return sr;
			}else if(!au.getOpenetime().contains(":")) {
				sr.setResultCode("-10025");
				sr.setResultMsg("可开门时间段结束时间格式为XX:XX，如00:00");
				return sr;
			}else {
				String t = au.getOpenetime().replace(":", "");
				if(t.length()!=4||!t.matches("[0-9]+")) {
					sr.setResultCode("-10025");
					sr.setResultMsg("可开门时间段结束时间格式为XX:XX，如00:00");
					return sr;
				}
			}
			
			if(null==au.getEdate()||au.getEdate().equals("")||au.getEdate().equals("null")) {
				sr.setResultCode("-10012");
				sr.setResultMsg("授权结束时间不能为空");
				return sr;
			}else if(!au.getEdate().equals("-1")&&(au.getEdate().length()!=10||!au.getEdate().matches("\\d+"))) {
				sr.setResultCode("-10013");
				sr.setResultMsg("授权结束时间格式为yyMMddHHmm");
				return sr;
			}
			
			if(null==au.getOpencount()||au.getOpencount().equals("")||au.getOpencount().equals("null")) {
				sr.setResultCode("-10010");
				sr.setResultMsg("可开门次数不能为空");
				return sr;
			}else if(!au.getOpencount().matches("[0-9]+|(-1)")) {
				sr.setResultCode("-10011");
				sr.setResultMsg("可开门次数必须为0-254数字,0表示不限次数");
				return sr;
			}
			
			if(null==au.getCallbackurl() || au.getCallbackurl().equals("") || au.getCallbackurl().equals("null")) {
				sr.setResultCode("-20004");
				sr.setResultMsg("回调地址不能为空");
				return sr;
			}
			
			if(null==au.getTimeout() || au.getTimeout()<0) {
				sr.setResultCode("-20005");
				sr.setResultMsg("指令超时时间不能为空");
				return sr;
			}
		}
		return sr;
	}
	
	public static SendResult check(LinkedHashMap param) {
		// TODO Auto-generated method stub
		Set<Map.Entry<String, String>> paramsSet = param.entrySet();
		SendResult sr=new SendResult("0","","");
		for (Map.Entry<String, String> paramEntry : paramsSet) {
			String key=paramEntry.getKey();
			Object val=paramEntry.getValue();
			if(key.equals("gatewaycode")) {
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10001");
					sr.setResultMsg("网关通讯ID不能为空");
					return sr;
				}else if(val.toString().length()!=10||val.toString().toUpperCase().matches(".*[G-Z].*")) {
					sr.setResultCode("-10002");
					sr.setResultMsg("网关通讯ID必须为10位十六进制字符串");
					return sr;
				}
			}else if(key.equals("gatewaycode2")) {
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10003");
					sr.setResultMsg("网关唯一ID不能为空");
					return sr;
				}else if(val.toString().length()!=10||val.toString().toUpperCase().matches(".*[G-Z].*")) {
					sr.setResultCode("-10004");
					sr.setResultMsg("网关唯一ID必须为10位十六进制字符串");
					return sr;
				}
			}else if(key.equals("roomcode")) {
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10005");
					sr.setResultMsg("门锁编号不能为空");
					return sr;
				}else if(val.toString().length()!=4||val.toString().toUpperCase().matches(".*[G-Z].*")) {
					sr.setResultCode("-10006");
					sr.setResultMsg("门锁编号必须为4位十六进制字符串");
					return sr;
				}
			}else if(key.equals("timeout")) {
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10007");
					sr.setResultMsg("指令超时时间不能为空");
					return sr;
				}else if(!val.toString().matches("[0-9]+")) {
					sr.setResultCode("-10021");
					sr.setResultMsg("指令超时时间必须为数字");
					return sr;
				}
			}else if(key.equals("pass")) {
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10008");
					sr.setResultMsg("密码不能为空");
					return sr;
				}else if(val.toString().length()!=6||!val.toString().matches("[0-9]+")) {
					sr.setResultCode("-10009");
					sr.setResultMsg("密码必须为6位数字");
					return sr;
				}
			}else if(key.equals("count")) {
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10010");
					sr.setResultMsg("可开门次数不能为空");
					return sr;
				}else if(!val.toString().matches("[0-9]+|(-1)")) {
					sr.setResultCode("-10011");
					sr.setResultMsg("可开门次数必须为0-254数字,0表示不限次数");
					return sr;
				}
			}else if(key.equals("edate")) {
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10012");
					sr.setResultMsg("授权结束时间不能为空");
					return sr;
				}else if(!val.toString().equals("-1")&&(val.toString().length()!=10||!val.toString().matches("\\d+"))) {
					sr.setResultCode("-10013");
					sr.setResultMsg("授权结束时间格式为yyMMddHHmm");
					return sr;
				}
			}else if(key.equals("unlockstime")) {
				String val2=val.toString().replace(":", "");
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10014");
					sr.setResultMsg("可开门时间段开始时间不能为空");
					return sr;
				}else if(val.toString().length()!=5) {
					sr.setResultCode("-10015");
					sr.setResultMsg("可开门时间段开始时间格式为XX:XX，如00:00");
					return sr;
				}else if(!val.toString().contains(":")) {
					sr.setResultCode("-10015");
					sr.setResultMsg("可开门时间段开始时间格式为XX:XX，如00:00");
					return sr;
				}else if(val2.length()!=4||!val2.matches("[0-9]+")) {
					sr.setResultCode("-10015");
					sr.setResultMsg("可开门时间段开始时间格式为XX:XX，如00:00");
					return sr;
				}
			}else if(key.equals("unlocketime")) {
				String val2=val.toString().replace(":", "");
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10016");
					sr.setResultMsg("可开门时间段结束时间不能为空");
					return sr;
				}else if(val.toString().length()!=5) {
					sr.setResultCode("-10017");
					sr.setResultMsg("可开门时间段结束时间格式为XX:XX，如00:00");
					return sr;
				}else if(!val.toString().contains(":")) {
					sr.setResultCode("-10017");
					sr.setResultMsg("可开门时间段结束时间格式为XX:XX，如00:00");
					return sr;
				}else if(val2.length()!=4||!val2.matches("[0-9]+")) {
					sr.setResultCode("-10017");
					sr.setResultMsg("可开门时间段结束时间格式为XX:XX，如00:00");
					return sr;
				}
			}else if(key.equals("callbackurl")) {
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10018");
					sr.setResultMsg("回调地址不能为空");
					return sr;
				}
			}else if(key.equals("roomcode2")) {
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10019");
					sr.setResultMsg("门锁唯一ID不能为空");
					return sr;
				}else if(val.toString().length()!=10||val.toString().toUpperCase().matches(".*[G-Z].*")) {
					sr.setResultCode("-10020");
					sr.setResultMsg("门锁唯一ID必须为10位十六进制字符串");
					return sr;
				}
			}else if(key.equals("openstime")) {
				String val2=val.toString().replace(":", "");
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10022");
					sr.setResultMsg("可开门时间段开始时间不能为空");
					return sr;
				}else if(val.toString().length()!=5) {
					sr.setResultCode("-10023");
					sr.setResultMsg("可开门时间段开始时间格式为XX:XX，如00:00");
					return sr;
				}else if(!val.toString().contains(":")) {
					sr.setResultCode("-10023");
					sr.setResultMsg("可开门时间段开始时间格式为XX:XX，如00:00");
					return sr;
				}else if(val2.length()!=4||!val2.matches("\\d+")) {
					sr.setResultCode("-10023");
					sr.setResultMsg("可开门时间段开始时间格式为XX:XX，如00:00");
					return sr;
				}
			}else if(key.equals("openetime")) {
				String val2=val.toString().replace(":", "");
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10024");
					sr.setResultMsg("可开门时间段结束时间不能为空");
					return sr;
				}else if(val.toString().length()!=5) {
					sr.setResultCode("-10025");
					sr.setResultMsg("可开门时间段结束时间格式为XX:XX，如00:00");
					return sr;
				}else if(!val.toString().contains(":")) {
					sr.setResultCode("-10025");
					sr.setResultMsg("可开门时间段结束时间格式为XX:XX，如00:00");
					return sr;
				}else if(val2.length()!=4||!val2.matches("[0-9]+")) {
					sr.setResultCode("-10025");
					sr.setResultMsg("可开门时间段结束时间格式为XX:XX，如00:00");
					return sr;
				}
			}else if(key.equals("cardtype")) {
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10026");
					sr.setResultMsg("卡片类型不能为空");
					return sr;
				}else if(!val.toString().equals("开门卡")&&!val.toString().equals("管理卡")&&!val.toString().equals("授权卡")&&!val.toString().equals("身份证")) {
					sr.setResultCode("-10027");
					sr.setResultMsg("卡片类型必须为开门卡/管理卡/授权卡/身份证");
					return sr;
				}
			}else if(key.equals("cardcode")) {
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10028");
					sr.setResultMsg("卡号不能为空");
					return sr;
				}else if(val.toString().equals("开门卡")||val.toString().equals("管理卡")||val.toString().equals("授权卡")) {
					if(val.toString().length()!=8||val.toString().toUpperCase().matches(".*[G-Z].*")) {
						sr.setResultCode("-10029");
						sr.setResultMsg("开门卡/管理卡/授权卡必须为8位十六进制字符串");
						return sr;
					}
				}else if(val.toString().equals("身份证")) {
					if(val.toString().length()!=16||val.toString().toUpperCase().matches(".*[G-Z].*")) {
						sr.setResultCode("-10030");
						sr.setResultMsg("身份证必须为16位十六进制字符串");
						return sr;
					}
				}
			}else if(key.equals("cardedate")) {
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10031");
					sr.setResultMsg("授权结束时间不能为空");
					return sr;
				}else if(!val.toString().equals("-1")&&(val.toString().length()!=10||!val.toString().matches("\\d+"))) {
					sr.setResultCode("-10032");
					sr.setResultMsg("授权结束时间格式为yyMMddHHmm");
					return sr;
				}
			}else if(key.equals("opencount")) {
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10033");
					sr.setResultMsg("可开门次数不能为空");
					return sr;
				}else if(!val.toString().matches("[0-9]+|(-1)")) {
					sr.setResultCode("-10034");
					sr.setResultMsg("可开门次数必须为0-254数字,0表示不限次数");
					return sr;
				}
			}else if(key.equals("fingercode")) {
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10035");
					sr.setResultMsg("指纹编号不能为空");
					return sr;
				}else if(val.toString().length()!=8||val.toString().toUpperCase().matches(".*[G-Z].*")) {
					sr.setResultCode("-10036");
					sr.setResultMsg("指纹编号必须为8位十六进制字符串");
					return sr;
				}
			}else if(key.equals("fingercontent")) {
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10037");
					sr.setResultMsg("指纹特征码不能为空");
					return sr;
				}else if(val.toString().length()!=988||val.toString().toUpperCase().matches(".*[G-Z].*")) {
					sr.setResultCode("-10038");
					sr.setResultMsg("指纹特征码必须为988位十六进制字符串");
					return sr;
				}
			}else if(key.equals("actioncount")) {
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10039");
					sr.setResultMsg("开门需按指纹次数不能为空");
					return sr;
				}else if(!val.toString().matches("[0-9]+|(-1)")) {
					sr.setResultCode("-10040");
					sr.setResultMsg("开门需按指纹次数必须为数字");
					return sr;
				}
			}else if(key.equals("rclist")) {
			}else if(key.equals("fpcode")) {
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10041");
					sr.setResultMsg("指纹机唯一ID不能为空");
					return sr;
				}
			}else if(key.equals("roomimei")) {
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10042");
					sr.setResultMsg("IMEI不能为空");
					return sr;
				}
			}
		}
		return sr;
	}
	
	public static SendResult checkDelFingerList(List<AuthDelFinger> authlist) {
		SendResult sr=new SendResult("0","","");
		if(null==authlist || authlist.size()<=0) {
			return sr;
		}
		for(int i=0;i<authlist.size();i++) {
			AuthDelFinger au = authlist.get(i);
			if(null==au.getLocktype()) {
				sr.setResultCode("-20002");
				sr.setResultMsg("门锁类型不能为空");
				return sr;
			}
			if(au.getLocktype()<1 || au.getLocktype()>4) {
				sr.setResultCode("-20003");
				sr.setResultMsg("门锁类型不存在");
				return sr;
			}
			
			if(null==au.getRoomcode2()||au.getRoomcode2().equals("")||au.getRoomcode2().equals("null")) {
				sr.setResultCode("-10019");
				sr.setResultMsg("门锁唯一ID不能为空");
				return sr;
			}else if(au.getRoomcode2().length()!=10||au.getRoomcode2().toUpperCase().matches(".*[G-Z].*")) {
				sr.setResultCode("-10020");
				sr.setResultMsg("门锁唯一ID必须为10位十六进制字符串");
				return sr;
			}
			if(au.getLocktype()==1) {
				if(null==au.getRoomcode()||au.getRoomcode().equals("")||au.getRoomcode().equals("null")) {
					sr.setResultCode("-10005");
					sr.setResultMsg("无线联网锁门锁编号不能为空");
					return sr;
				}else if(au.getRoomcode().length()!=4||au.getRoomcode().toUpperCase().matches(".*[G-Z].*")) {
					sr.setResultCode("-10006");
					sr.setResultMsg("门锁编号必须为4位十六进制字符串");
					return sr;
				}
				if(null==au.getGatewaycode()||au.getGatewaycode().equals("")||au.getGatewaycode().equals("null")) {
					sr.setResultCode("-10001");
					sr.setResultMsg("无线联网锁网关通讯ID不能为空");
					return sr;
				}else if(au.getGatewaycode().length()!=10||au.getGatewaycode().toUpperCase().matches(".*[G-Z].*")) {
					sr.setResultCode("-10002");
					sr.setResultMsg("网关通讯ID必须为10位十六进制字符串");
					return sr;
				}
				if(null==au.getGatewaycode2()||au.getGatewaycode2().equals("")||au.getGatewaycode2().equals("null")) {
					sr.setResultCode("-10003");
					sr.setResultMsg("无线联网锁网关唯一ID不能为空");
					return sr;
				}else if(au.getGatewaycode2().length()!=10||au.getGatewaycode2().toUpperCase().matches(".*[G-Z].*")) {
					sr.setResultCode("-10004");
					sr.setResultMsg("网关唯一ID必须为10位十六进制字符串");
					return sr;
				}
			}else {
				if(null==au.getImei()||au.getImei().equals("")||au.getImei().equals("null")) {
					sr.setResultCode("-10042");
					sr.setResultMsg("IMEI不能为空");
					return sr;
				}
			}
			
			if(null==au.getFingercode()||au.getFingercode().equals("")||au.getFingercode().equals("null")) {
				sr.setResultCode("-10035");
				sr.setResultMsg("指纹编号不能为空");
				return sr;
			}else if(au.getFingercode().length()!=8||au.getFingercode().toUpperCase().matches(".*[G-Z].*")) {
				sr.setResultCode("-10036");
				sr.setResultMsg("指纹编号必须为8位十六进制字符串");
				return sr;
			}
			
			if(null==au.getCallbackurl() || au.getCallbackurl().equals("") || au.getCallbackurl().equals("null")) {
				sr.setResultCode("-20004");
				sr.setResultMsg("回调地址不能为空");
				return sr;
			}
			
			if(null==au.getTimeout() || au.getTimeout()<0) {
				sr.setResultCode("-20005");
				sr.setResultMsg("指令超时时间不能为空");
				return sr;
			}
				
		}
		return sr;
	}
	
	public static SendResult checkPswList(List<AuthPsw> authlist) {
		SendResult sr=new SendResult("0","","");
		if(null==authlist || authlist.size()<=0) {
			return sr;
		}
		for(int i=0;i<authlist.size();i++) {
			AuthPsw au = authlist.get(i);
			if(null==au.getLocktype()) {
				sr.setResultCode("-20002");
				sr.setResultMsg("门锁类型不能为空");
				return sr;
			}
			if(au.getLocktype()<1 || au.getLocktype()>4) {
				sr.setResultCode("-20003");
				sr.setResultMsg("门锁类型不存在");
				return sr;
			}
			
			if(null==au.getRoomcode2()||au.getRoomcode2().equals("")||au.getRoomcode2().equals("null")) {
				sr.setResultCode("-10019");
				sr.setResultMsg("门锁唯一ID不能为空");
				return sr;
			}else if(au.getRoomcode2().length()!=10||au.getRoomcode2().toUpperCase().matches(".*[G-Z].*")) {
				sr.setResultCode("-10020");
				sr.setResultMsg("门锁唯一ID必须为10位十六进制字符串");
				return sr;
			}
			if(au.getLocktype()==1) {
				if(null==au.getRoomcode()||au.getRoomcode().equals("")||au.getRoomcode().equals("null")) {
					sr.setResultCode("-10005");
					sr.setResultMsg("无线联网锁门锁编号不能为空");
					return sr;
				}else if(au.getRoomcode().length()!=4||au.getRoomcode().toUpperCase().matches(".*[G-Z].*")) {
					sr.setResultCode("-10006");
					sr.setResultMsg("门锁编号必须为4位十六进制字符串");
					return sr;
				}
				if(null==au.getGatewaycode()||au.getGatewaycode().equals("")||au.getGatewaycode().equals("null")) {
					sr.setResultCode("-10001");
					sr.setResultMsg("无线联网锁网关通讯ID不能为空");
					return sr;
				}else if(au.getGatewaycode().length()!=10||au.getGatewaycode().toUpperCase().matches(".*[G-Z].*")) {
					sr.setResultCode("-10002");
					sr.setResultMsg("网关通讯ID必须为10位十六进制字符串");
					return sr;
				}
				if(null==au.getGatewaycode2()||au.getGatewaycode2().equals("")||au.getGatewaycode2().equals("null")) {
					sr.setResultCode("-10003");
					sr.setResultMsg("无线联网锁网关唯一ID不能为空");
					return sr;
				}else if(au.getGatewaycode2().length()!=10||au.getGatewaycode2().toUpperCase().matches(".*[G-Z].*")) {
					sr.setResultCode("-10004");
					sr.setResultMsg("网关唯一ID必须为10位十六进制字符串");
					return sr;
				}
			}else {
				if(null==au.getImei()||au.getImei().equals("")||au.getImei().equals("null")) {
					sr.setResultCode("-10042");
					sr.setResultMsg("IMEI不能为空");
					return sr;
				}
			}
			if(null==au.getPassword()||au.getPassword().equals("")||au.getPassword().equals("null")) {
				sr.setResultCode("-10008");
				sr.setResultMsg("密码不能为空");
				return sr;
			}
			Pattern pattern = Pattern.compile("[0-9]*");
			Matcher isNum = pattern.matcher(au.getPassword());
			if (!isNum.matches() || au.getPassword().length()!=6) {
				sr.setResultCode("-10009");
				sr.setResultMsg("密码必须为6位数字");
				return sr;
			}
			
			if(null==au.getOpenstime()||au.getOpenstime().equals("")||au.getOpenstime().equals("null")) {
				sr.setResultCode("-10022");
				sr.setResultMsg("可开门时间段开始时间不能为空");
				return sr;
			}else if(au.getOpenstime().length()!=5) {
				sr.setResultCode("-10023");
				sr.setResultMsg("可开门时间段开始时间格式为XX:XX，如00:00");
				return sr;
			}else if(!au.getOpenstime().contains(":")) {
				sr.setResultCode("-10023");
				sr.setResultMsg("可开门时间段开始时间格式为XX:XX，如00:00");
				return sr;
			}else {
				String t = au.getOpenstime().replace(":", "");
				if(t.length()!=4||!t.matches("\\d+")) {
					sr.setResultCode("-10023");
					sr.setResultMsg("可开门时间段开始时间格式为XX:XX，如00:00");
					return sr;
				}
			}
				
			if(null==au.getOpenetime()||au.getOpenetime().equals("")||au.getOpenetime().equals("null")) {
				sr.setResultCode("-10024");
				sr.setResultMsg("可开门时间段结束时间不能为空");
				return sr;
			}else if(au.getOpenetime().length()!=5) {
				sr.setResultCode("-10025");
				sr.setResultMsg("可开门时间段结束时间格式为XX:XX，如00:00");
				return sr;
			}else if(!au.getOpenetime().contains(":")) {
				sr.setResultCode("-10025");
				sr.setResultMsg("可开门时间段结束时间格式为XX:XX，如00:00");
				return sr;
			}else {
				String t = au.getOpenetime().replace(":", "");
				if(t.length()!=4||!t.matches("[0-9]+")) {
					sr.setResultCode("-10025");
					sr.setResultMsg("可开门时间段结束时间格式为XX:XX，如00:00");
					return sr;
				}
			}
			
			if(null==au.getEdate()||au.getEdate().equals("")||au.getEdate().equals("null")) {
				sr.setResultCode("-10012");
				sr.setResultMsg("授权结束时间不能为空");
				return sr;
			}else if(!au.getEdate().equals("-1")&&(au.getEdate().length()!=10||!au.getEdate().matches("\\d+"))) {
				sr.setResultCode("-10013");
				sr.setResultMsg("授权结束时间格式为yyMMddHHmm");
				return sr;
			}
			
			if(null==au.getOpencount()||au.getOpencount().equals("")||au.getOpencount().equals("null")) {
				sr.setResultCode("-10010");
				sr.setResultMsg("可开门次数不能为空");
				return sr;
			}else if(!au.getOpencount().matches("[0-9]+|(-1)")) {
				sr.setResultCode("-10011");
				sr.setResultMsg("可开门次数必须为0-254数字,0表示不限次数");
				return sr;
			}
			
			if(null==au.getCallbackurl() || au.getCallbackurl().equals("") || au.getCallbackurl().equals("null")) {
				sr.setResultCode("-20004");
				sr.setResultMsg("回调地址不能为空");
				return sr;
			}
			
			if(null==au.getTimeout() || au.getTimeout()<0) {
				sr.setResultCode("-20005");
				sr.setResultMsg("指令超时时间不能为空");
				return sr;
			}
		}
		return sr;
	}
	
	public static SendResult checkDelPswList(List<AuthDelPsw> authlist) {
		SendResult sr=new SendResult("0","","");
		if(null==authlist || authlist.size()<=0) {
			return sr;
		}
		for(int i=0;i<authlist.size();i++) {
			AuthDelPsw au = authlist.get(i);
			if(null==au.getLocktype()) {
				sr.setResultCode("-20002");
				sr.setResultMsg("门锁类型不能为空");
				return sr;
			}
			if(au.getLocktype()<1 || au.getLocktype()>4) {
				sr.setResultCode("-20003");
				sr.setResultMsg("门锁类型不存在");
				return sr;
			}
			
			if(null==au.getRoomcode2()||au.getRoomcode2().equals("")||au.getRoomcode2().equals("null")) {
				sr.setResultCode("-10019");
				sr.setResultMsg("门锁唯一ID不能为空");
				return sr;
			}else if(au.getRoomcode2().length()!=10||au.getRoomcode2().toUpperCase().matches(".*[G-Z].*")) {
				sr.setResultCode("-10020");
				sr.setResultMsg("门锁唯一ID必须为10位十六进制字符串");
				return sr;
			}
			if(au.getLocktype()==1) {
				if(null==au.getRoomcode()||au.getRoomcode().equals("")||au.getRoomcode().equals("null")) {
					sr.setResultCode("-10005");
					sr.setResultMsg("无线联网锁门锁编号不能为空");
					return sr;
				}else if(au.getRoomcode().length()!=4||au.getRoomcode().toUpperCase().matches(".*[G-Z].*")) {
					sr.setResultCode("-10006");
					sr.setResultMsg("门锁编号必须为4位十六进制字符串");
					return sr;
				}
				if(null==au.getGatewaycode()||au.getGatewaycode().equals("")||au.getGatewaycode().equals("null")) {
					sr.setResultCode("-10001");
					sr.setResultMsg("无线联网锁网关通讯ID不能为空");
					return sr;
				}else if(au.getGatewaycode().length()!=10||au.getGatewaycode().toUpperCase().matches(".*[G-Z].*")) {
					sr.setResultCode("-10002");
					sr.setResultMsg("网关通讯ID必须为10位十六进制字符串");
					return sr;
				}
				if(null==au.getGatewaycode2()||au.getGatewaycode2().equals("")||au.getGatewaycode2().equals("null")) {
					sr.setResultCode("-10003");
					sr.setResultMsg("无线联网锁网关唯一ID不能为空");
					return sr;
				}else if(au.getGatewaycode2().length()!=10||au.getGatewaycode2().toUpperCase().matches(".*[G-Z].*")) {
					sr.setResultCode("-10004");
					sr.setResultMsg("网关唯一ID必须为10位十六进制字符串");
					return sr;
				}
			}else {
				if(null==au.getImei()||au.getImei().equals("")||au.getImei().equals("null")) {
					sr.setResultCode("-10042");
					sr.setResultMsg("IMEI不能为空");
					return sr;
				}
			}
			
			if(null==au.getPassword()||au.getPassword().equals("")||au.getPassword().equals("null")) {
				sr.setResultCode("-10008");
				sr.setResultMsg("密码不能为空");
				return sr;
			}
			Pattern pattern = Pattern.compile("[0-9]*");
			Matcher isNum = pattern.matcher(au.getPassword());
			if (!isNum.matches() || au.getPassword().length()!=6) {
				sr.setResultCode("-10009");
				sr.setResultMsg("密码必须为6位数字");
				return sr;
			}
			
			if(null==au.getCallbackurl() || au.getCallbackurl().equals("") || au.getCallbackurl().equals("null")) {
				sr.setResultCode("-20004");
				sr.setResultMsg("回调地址不能为空");
				return sr;
			}
			
			if(null==au.getTimeout() || au.getTimeout()<0) {
				sr.setResultCode("-20005");
				sr.setResultMsg("指令超时时间不能为空");
				return sr;
			}
		}
		return sr;
	}
	
	/**
	  * 鍒囧壊鎸囦护鑾峰彇failtype
	  * @param result
	  * @return
	  */
	 public static Integer getFailtype(String result){
		 int ret = 11;
		 if(null!=result && !"".equals(result)){
			String od = "";
			if(result.substring(0,4).toUpperCase().equals("BBBB")){
				od = result.substring(22,24);
			}else{
				od = result.substring(20,22);
			}
			
			if(od.equals("01") || od.equals("3a") || od.equals("3A")){
				ret = -1;
			}else if(od.equals("02")){
				ret = 2;
			}else if(od.equals("03")){
				ret = 3;
			}else if(od.equals("04")){
				ret = 4;
			}else if(od.equals("05")){
				ret = 5;
			}else if(od.equals("06")){
				ret = 6;
			}else if(od.equals("07")){
				ret = 7;
			}else if(od.equals("08")){
				ret = 8;
			}else if(od.equals("09")){
				ret = 9;
			}else if(od.equals("0a") || od.equals("0A")){
				ret = 10;
			}else if(od.equals("0b") || od.equals("0B")){
				ret = 13;
			}else if(od.equals("20")){
				ret = 20;
			}else if(od.equals("21")){
				ret = 21;
			}else if(od.equals("22")){
				ret = 22;
			}else if(od.equals("23")){
				ret = 23;
			}else if(od.equals("30")){
				ret = 30;
			}else if(od.equals("31")){
				ret = 31;
			}else if(od.equals("32")){
				ret = 32;
			}else if(od.equals("33")){
				ret = 33;
			}else if(od.equals("34")){
				ret = 34;
			}
		 }
		 return ret;
	 }
	 
	 /**
	  * 鑾峰彇闂ㄩ攣鐘舵��
	  * @param lockstatus
	  * @return
	  */
	 public static String[] getlockstatus(String lockstatus){
		 String[] ret = new String[2];
		 
		 String ls =hexString2binaryString("0"+lockstatus);
		 ls = ls.substring(4);
		 //1涓猴紙寮�鍏抽棬锛夋棤鎰忎箟
		 if(ls.substring(0,1).equals("0")){
			 if(ls.substring(3,4).equals("1")){
				 ret[0] = "1";
			 }else{
				 ret[0] = "0";
			 }
		 }else{
			 ret[0] = "2";
		 }  
		 
		 //鍙嶉攣鏈夋棤鎰忎箟
		 if(ls.substring(1,2).equals("1")){
			 ret[1] = "2";
		 }else{
			 if(ls.substring(2,3).equals("1")){
				 ret[1] = "1";
			 }else{
				 ret[1] = "0";
			 }
		 }
		 return ret;
	 }
	 
	 public static String hexString2binaryString(String hexString){  
	        if (hexString == null || hexString.length() % 2 != 0)  
	            return null;  
	        String bString = "", tmp;  
	        for (int i = 0; i < hexString.length(); i++)  
	        {  
	            tmp = "0000"  
	                    + Integer.toBinaryString(Integer.parseInt(hexString  
	                            .substring(i, i + 1), 16));  
	            bString += tmp.substring(tmp.length() - 4);  
	        }  
	        return bString;  
		 } 
	 /**
	  * 澶氭潯闂ㄩ攣鎿嶄綔璁板綍瑙ｆ瀽鎴恓son鍒楄〃(瀹屾暣鐗�)
	  * @param order
	  * @return
	  */
	 public static List<Map> getUnlockinglist(String order){
		 List<Map> slUnlockings = new ArrayList<Map>();
		 String uns = "";
		 //鍗曟潯
		 if(order.substring(0,4).toUpperCase().equals("AAAA")){
			 uns = order.substring(36,order.length()-4);
		 }else{
			 uns = order.substring(46,order.length()-4);
		 }
		 String[] oders = getUnlockingorders(uns);
		 for(int i=0;i<oders.length;i++){
			 
			 //010100010203070d000000000000
			 //11 22 33 44 55 66 77 88 99 00 11 22 33 44 55 66 77 88 99=====38
			 String unlock = oders[i];
			 String locktype = unlock.substring(0,2);
			 String cardtype = unlock.substring(2,4);
			 String cardcode = unlock.substring(4,12);
			 String roomcode = unlock.substring(12,16);
			 String packageno = unlock.substring(16,20);
			 String password = unlock.substring(20,26).toUpperCase();
			 String time = unlock.substring(26,38);
			 time = "20" + time.substring(0,2) +"-"+time.substring(2,4)+"-"+time.substring(4,6)+
					 " "+ time.substring(6,8)+":"+time.substring(8,10)+":"+time.substring(10,12);
			
			 Map lock = new HashMap();
			 
			 if(packageno.equals("0000") || packageno.equals("ffff") || packageno.equals("FFFF")){
				 lock.put("packageNo", "0");
			 }else{
				 String n = Long.valueOf(packageno,16) + "";
				 lock.put("packageNo", Integer.valueOf(n)+"");
			 }
			 
			 lock.put("roomcode", roomcode);
			 lock.put("cardcode", cardcode);
			 lock.put("cardcode2", "");
			 
			 if(!password.equals("FFFFFF")){
				 lock.put("password", password);
			 }else{
				 lock.put("password", "0");
			 }
			 lock.put("time", time);
			 if(locktype.equals("01")){
				 if(cardtype.equals("20")){
					 lock.put("type", "6");
				 }else if(cardtype.equals("08")) {
					 lock.put("type", "17");
				 }else if(cardtype.equals("10")) {
					 lock.put("type", "9");
				 }else{
				     lock.put("type", "1");
				 }
			 }else if(locktype.equals("02")){
				 lock.put("type", "4");
				 lock.put("cardcode", "");
			 }else if(locktype.equals("03")){
				 lock.put("type", "3");
				 lock.put("cardcode", "");
			 }else if(locktype.equals("04")){
				 lock.put("type", "5");
				 lock.put("cardcode", "");
			 }else if(locktype.equals("08")){
				 lock.put("type", "8");
				 lock.put("cardcode", "");
			 }else if(locktype.equals("10")){
				 lock.put("type", "10");
				 lock.put("cardcode", "");
			 }else if(locktype.equals("20")){
				 lock.put("type", "20");
				 lock.put("cardcode2", unlock.substring(16, 24));
			 }else if(locktype.equals("80")){
				 lock.put("type", "19");
				 lock.put("cardcode", "");
			 }else if(locktype.equals("90")){
				 lock.put("type", "21");
				 String newcode = cardcode + unlock.substring(16,24);
				 lock.put("cardcode", newcode);
			 }else if(locktype.equals("f1") || locktype.equals("F1")){
				 lock.put("type", "11");
			 }else if(locktype.equals("f2") || locktype.equals("F2")){
				 lock.put("type", "12");
				 lock.put("cardcode", "");
			 }else if(locktype.equals("f3") || locktype.equals("F3")) {
				 lock.put("type", "14");
				 lock.put("cardcode", "");
			 }else if(locktype.equals("f4") || locktype.equals("F4")) {
				 lock.put("type", "15");
			 }else if(locktype.equals("f5") || locktype.equals("F5")) {
				 lock.put("type", "16");
				 lock.put("cardcode", "");
			 }else if(locktype.equals("f6") || locktype.equals("F6")) {
				 lock.put("type", "18");
			 }else{
				 lock.put("type", "0");
			 }
			 slUnlockings.add(lock);
		 }
		 return slUnlockings;
	 } 
	 
	 /**
	  * 鍒嗗壊澶氭潯闂ㄩ攣鎿嶄綔璁板綍涓哄崟鏉¤褰曟暟缁�
	  * @param order
	  * @return
	  */
	 public static String[] getUnlockingorders(String order){
		 String[] oder = new String[order.length()/38];
		 for(int i=0;i<order.length()/38;i++){
			 oder[i] = order.substring(i*38,(i+1)*38);
		 }
		 return oder;
	 }
	 
	 /**
	  * 涓哄涓棬閿佸瓧绗︿覆娣诲姞鍒嗛殧绗﹀彿","
	  * @param locks
	  * @return
	  */
	 public static String getAlllocks(String locks){
		 String alllockString= "";
		 if(locks.length()>4){
			 for(int i=0;i<locks.length()/4;i++){
				 if(alllockString.equals("")){
					 alllockString = locks.substring(i*4,(i+1)*4);
				 }else{
					 alllockString += "," + locks.substring(i*4,(i+1)*4);
				 }
			 }
		 }else if(locks.length()==4){
			 return locks;
		 }
		 return alllockString;
	 }
	 
	 //鎸囦护浣�22,26
	 public static String getAllFailRoomcardByFailorder(String[] od) {
		 String allcardcodes = "";
		 for(int i=0;i<od.length;i++) {
			 String order = od[i];
			 if(order.substring(22, 26).toUpperCase().equals("FFA1")) {
				 return "all";
			 }else {
				 String content = order.substring(42);
				 String cardcodes = getFailRoomcardOne(content);
				 if("".equals(allcardcodes)) {
					 allcardcodes = cardcodes;
				 }else {
					 allcardcodes = "," + cardcodes;
				 }
			 }
		 }
		 return allcardcodes;
	 }
	 
	 private static String getFailRoomcardOne(String content) {
		 String cardcode = "";
		 int len = content.length()/66;
		 for(int i=0;i<len;i++) {
			 String rc = content.substring(i*66, (i+1)*66);
			 if("".equals(cardcode)) {
				 cardcode = "'" + rc.substring(2, 10) + "'";
			 }else {
				 cardcode += ",'" + rc.substring(2, 10) + "'";
			 }
		 }
		 return cardcode;
	 }
	 
	 public static String getFingercodeByOrder(String order) {
		 String fcodes = "";
		 if(order.substring(22, 26).toUpperCase().equals("C1A2")) {
			 String content = order.substring(62);
			 int len = content.length()/66;
			 for(int i=0;i<len;i++) {
				 String rc = content.substring(i*66, (i+1)*66);
				 if("".equals(fcodes)) {
					 fcodes = "'" + rc.substring(2, 10) + "'";
				 }else {
					 fcodes += ",'" + rc.substring(2, 10) + "'";
				 }
			 }
		 }
		 return fcodes;
	 }
	 
	 public static String getFingercodesByOrders(String[] od) {
		 String fcodes = "";
		 for(int i=0;i<od.length;i++) {
			 String content = od[i];
			 if("".equals(fcodes)) {
				 fcodes = "'"+content.substring(64, 72)+"'";
			 }else {
				 fcodes += "," + "'" + content.substring(64, 72) + "'";
			 }
		 }
		 return fcodes;
	 }
	 
	 /**
	  * 澶氭潯闂ㄩ攣鎿嶄綔璁板綍瑙ｆ瀽鎴恓son鍒楄〃(鏈夋晥鎸囦护鎴彇鐗�)
	  * @param order
	  * @return
	  */
	 public static List<Map> getUnlockinglist2(String order){
		 List<Map> slUnlockings = new ArrayList<Map>();
		 if(order.length()<38) {
			 return slUnlockings;
		 }
		 String[] oders = getUnlockingorders(order);
		 for(int i=0;i<oders.length;i++){
			 String unlock = oders[i];
			 if(unlock.length()<38) {
				 continue;
			 }
			 String locktype = unlock.substring(0,2);
			 String cardtype = unlock.substring(2,4);
			 String cardcode = unlock.substring(4,12);
			 String roomcode = unlock.substring(12,16);
			 String packageno = unlock.substring(16,20);
			 String password = unlock.substring(20,26).toUpperCase();
			 String time = unlock.substring(26,38);
			 time = "20" + time.substring(0,2) +"-"+time.substring(2,4)+"-"+time.substring(4,6)+
					 " "+ time.substring(6,8)+":"+time.substring(8,10)+":"+time.substring(10,12);
			
			 Map lock = new HashMap();
			 
			 if(packageno.equals("0000") || packageno.equals("ffff") || packageno.equals("FFFF")){
				 lock.put("packageNo", "0");
			 }else{
				 String n = Long.valueOf(packageno,16) + "";
				 lock.put("packageNo", Integer.valueOf(n)+"");
			 }
			 
			 lock.put("roomcode", roomcode);
			 lock.put("cardcode", cardcode);
			 lock.put("cardcode2", "");
			 
			 if(!password.equals("FFFFFF")){
				 lock.put("password", password);
			 }else{
				 lock.put("password", "0");
			 }
			 lock.put("time", time);
			 if(locktype.equals("01")){
				 if(cardtype.equals("20")){
					 lock.put("type", "6");
				 }else if(cardtype.equals("08")) {
					 lock.put("type", "17");
				 }else if(cardtype.equals("10")) {
					 lock.put("type", "9");
				 }else{
				     lock.put("type", "1");
				 }
			 }else if(locktype.equals("02")){
				 lock.put("type", "4");
				 lock.put("cardcode", "");
			 }else if(locktype.equals("03")){
				 lock.put("type", "3");
				 lock.put("cardcode", "");
			 }else if(locktype.equals("04")){
				 lock.put("type", "5");
				 lock.put("cardcode", "");
			 }else if(locktype.equals("08")){
				 lock.put("type", "8");
				 lock.put("cardcode", "");
			 }else if(locktype.equals("10")){
				 lock.put("type", "10");
				 lock.put("cardcode", "");
			 }else if(locktype.equals("20")){
				 lock.put("type", "20");
				 lock.put("cardcode2", unlock.substring(16, 24));
			 }else if(locktype.equals("80")){
				 lock.put("type", "19");
				 lock.put("cardcode", "");
			 }else if(locktype.equals("90")){
				 lock.put("type", "21");
				 String newcode = cardcode + unlock.substring(16,24);
				 lock.put("cardcode", newcode);
			 }else if(locktype.equals("f1") || locktype.equals("F1")){
				 lock.put("type", "11");
			 }else if(locktype.equals("f2") || locktype.equals("F2")){
				 lock.put("type", "12");
				 lock.put("cardcode", "");
			 }else if(locktype.equals("f3") || locktype.equals("F3")) {
				 lock.put("type", "14");
				 lock.put("cardcode", "");
			 }else if(locktype.equals("f4") || locktype.equals("F4")) {
				 lock.put("type", "15");
			 }else if(locktype.equals("f5") || locktype.equals("F5")) {
				 lock.put("type", "16");
				 lock.put("cardcode", "");
			 }else if(locktype.equals("f6") || locktype.equals("F6")) {
				 lock.put("type", "18");
			 }else{
				 lock.put("type", "0");
			 }
			 slUnlockings.add(lock);
		 }
		 return slUnlockings;
	 }
	 
	 public static List<String> getListByString(String json) {
		 if(json.length()<3) {
			 return new ArrayList<String>();
		 }
		 json = json.substring(1, json.length()-1);
		 String[] ss = json.split(",");
		 //List<String> l = Arrays.asList(json);
		 //JSONArray arr=JSONArray.fromObject(json);
		
		 List<String> l=new ArrayList<String>();
		 
		 /*for (Object object : arr) {
			l.add(object);
		 }*/
		 String rets = "";
		 for(int i=0;i<ss.length;i++) {
			 rets = ss[i].replace(" ", "");
			 rets = rets.replace("\"", "");
			 l.add(rets);
		 }
		 return l;
	 }
	 
	 public static String simpleObjectToJsonStr(Object obj) throws IllegalArgumentException, IllegalAccessException{  
	        if(obj==null){  
	            return "null";  
	        }  
	        String jsonStr = "{";  
	        Class<?> cla = obj.getClass();  
	        Field fields[] = cla.getDeclaredFields();  
	        for (Field field : fields) {  
	            field.setAccessible(true);  
	            if(field.getType() == long.class){  
	                jsonStr += "\""+field.getName()+"\":"+field.getLong(obj)+",";  
	            }else if(field.getType() == double.class){  
	                jsonStr += "\""+field.getName()+"\":"+field.getDouble(obj)+",";  
	            }else if(field.getType() == Timestamp.class){  
	                jsonStr += "\""+field.getName()+"\":"+"\""+field.get(obj)+"\""+",";  
	            }else if(field.getType() == float.class){  
	                jsonStr += "\""+field.getName()+"\":"+field.getFloat(obj)+",";  
	            }else if(field.getType() == int.class){  
	                jsonStr += "\""+field.getName()+"\":"+field.getInt(obj)+",";  
	            }else if(field.getType() == boolean.class){  
	                jsonStr += "\""+field.getName()+"\":"+field.getBoolean(obj)+",";  
	            }else if(field.getType() == Integer.class||field.getType() == Boolean.class  
	                    ||field.getType() == Double.class||field.getType() == Float.class                     
	                    ||field.getType() == Long.class){                 
	                jsonStr += "\""+field.getName()+"\":"+field.get(obj)+",";  
	            }else if(field.getType() == String.class){  
	                jsonStr += "\""+field.getName()+"\":\""+field.get(obj)+"\",";  
	            }                  
	        }  
	        jsonStr = jsonStr.substring(0,jsonStr.length()-1);  
	        jsonStr += "}";  
	            return jsonStr;       
	    }  
	 
	 /**
	  * 姣忎袱浣嶅崄鍏繘鍒跺瓧绗︿覆杞垚浜岃繘鍒�8浣嶅瓧绗︿覆
	  * @param hexString
	  * @return
	  */
	 public static String hexToBinary(String hexString) {
		 int i = Integer.parseInt(hexString, 16);
		 String binaryString = Integer.toBinaryString(i);
		 int len = binaryString.length();
		 for(int j=hexString.length()*4;j>len;j--) {
			 binaryString = "0"+binaryString;
		 }
		 return binaryString;
	 }
	 
	 public static String mapToString(Map params) {
		 String json="{";
		  Set<Map.Entry<String, Object>> paramsSet = params.entrySet();
		  for (Map.Entry<String, Object> paramEntry : paramsSet) {
			String key= paramEntry.getKey();
			String vaule=paramEntry.getValue().toString();
			json+="\""+key +"\""+":"+"\""+vaule+"\""+",";
		  }
		  json=json.substring(0, json.length()-1);
		  json+="}";
		  System.out.println(json);
		  return json;
	 }
	 
	 /**
	  * 鑾峰彇瀹炴椂鏌ヨ闂ㄩ攣璁板綍鎵�寰楄繑鍥炶褰曟�绘暟
	  * @param result
	  * @return
	  */
	 public static Integer getRecordcount(String result){
		 String[] res = result.split("-");
		 int recordcount = 0;
		 for(int i=0;i<res.length;i++){
			 String r = res[i];
			 if(r.length()>46){
				 String num = r.substring(44,46);
				 try {
					recordcount = recordcount + Integer.valueOf(num, 16);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					recordcount = recordcount + 0;
				}
			 }
		 }
		 return recordcount;
	 }
	 
	 /**
	  * 根据字符串获取混合授权的SendResult对象
	  * @param result
	  * @return
	  */
	 public static SendResult getSendResultByJson(String result) {
		SendResult<AuthResult> retsu = new SendResult<AuthResult>();
		AuthResult retau = new AuthResult();
		
		JSONObject json = JSONObject.fromObject(result);
		retsu = (SendResult)JSONObject.toBean(JSONObject.fromObject(result), SendResult.class);
		
		//authresult
		JSONObject ar = json.getJSONObject("result");
		
		if(ar.containsKey("cardsresult") && !ar.get("cardsresult").equals("") && !ar.get("cardsresult").equals("null")) {
			JSONArray cl = ar.getJSONArray("cardsresult");
			List<CardsResult> list= JSONArray.toList(cl, new CardsResult(),new JsonConfig());
			retau.setCardsresult(list);
		}
		if(ar.containsKey("delcardsresult") && !ar.get("delcardsresult").equals("") && !ar.get("delcardsresult").equals("null")) {
			JSONArray dcl = ar.getJSONArray("delcardsresult");
			List<DelCardsResult> list = JSONArray.toList(dcl, new DelCardsResult(),new JsonConfig());
			retau.setDelcardsresult(list);
		}
		if(ar.containsKey("fingersresult") && !ar.get("fingersresult").equals("") && !ar.get("fingersresult").equals("null")) {
			JSONArray fl = ar.getJSONArray("fingersresult");
			List<FingersResult> list = JSONArray.toList(fl, new FingersResult(),new JsonConfig());
			retau.setFingersresult(list);
		}
		if(ar.containsKey("delfingersresult") && !ar.get("delfingersresult").equals("") && !ar.get("delfingersresult").equals("null")) {
			JSONArray dfl = ar.getJSONArray("delfingersresult");
			List<DelFingersResult> list = JSONArray.toList(dfl, new DelFingersResult(),new JsonConfig());
			retau.setDelfingersresult(list);
		}
		if(ar.containsKey("pswsresult") && !ar.get("pswsresult").equals("") && !ar.get("pswsresult").equals("null")) {
			JSONArray pl = ar.getJSONArray("pswsresult");
			List<PswsResult> list5 = JSONArray.toList(pl, new PswsResult(),new JsonConfig());
			retau.setPswsresult(list5);
	 	}
		if(ar.containsKey("delpswsresult") && !ar.get("delpswsresult").equals("") && !ar.get("delpswsresult").equals("null")) {
			JSONArray dpl = ar.getJSONArray("delpswsresult");
			List<DelPswsResult> list = JSONArray.toList(dpl, new DelPswsResult(),new JsonConfig());
			retau.setDelpswsresult(list);
		}
		
		retsu.setResult(retau);
		return retsu;
	}
	 
	 public static void main(String[] args) {
		SendOrderInfo sio = new SendOrderImpl();
		List<AuthCard> clist = new ArrayList<AuthCard>();
		List<AuthDelCard> dclist = new ArrayList<AuthDelCard>();
		List<AuthFinger> flist = new ArrayList<AuthFinger>();
		List<AuthDelFinger> dflist = new ArrayList<AuthDelFinger>();
		List<AuthPsw> plist = new ArrayList<AuthPsw>();
		List<AuthDelPsw> dplist = new ArrayList<AuthDelPsw>();
		
		AuthCard au = new AuthCard();
		au.setLocktype(2);
		au.setCardcode("00010001");
		au.setGatewaycode("002a010101");
		au.setGatewaycode2("1901010001");
		au.setRoomcode("0101");
		au.setRoomcode2("1901000001");
		au.setEdate("-1");
		au.setOpencount("0");
		au.setOpenstime("00:00");
		au.setImei("1216121514151");
		au.setOpenetime("23:59");
		au.setCardtype("身份证");
		au.setCallbackurl("1");
		au.setTimeout(200);
		//clist.add(au);
		
		AuthDelCard d = new AuthDelCard();
		d.setLocktype(2);
		d.setCardcode("00010001");
		d.setGatewaycode("002a010101");
		d.setGatewaycode2("1901010001");
		d.setRoomcode("0101");
		d.setRoomcode2("1901000001");
		d.setImei("1216121514151");
		d.setCallbackurl("1");
		d.setTimeout(200);
		//dclist.add(d);
		
		AuthFinger f = new AuthFinger();
		f.setLocktype(2);
		f.setFingercode("00010001");
		f.setGatewaycode("002a010101");
		f.setGatewaycode2("1901010001");
		f.setRoomcode("0101");
		f.setRoomcode2("1901000001");
		f.setEdate("-1");
		f.setOpencount("0");
		f.setOpenstime("00:00");
		f.setOpenetime("23:59");
		f.setImei("1216121514151");
		f.setActioncount("1");
		f.setFingercontent("dd0217ff843201c8060b02c30c2908c88c45024f8d8990070cda11140dd213110768141608d7c104143802d2971204669d2008e6a1160a6e4050a40e08f2a74705d8283b0560294e0258c0cc800d04441b2d1a60201c0d6d840f034b5cc91d1605e41e2d0d63a12203e300000000c194000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000dbdfcb79edbebc78867776070000000000000000550053000b0a4347474747474b4b4b524747474747474b4b4b4f4a4a4b4b4b4b4b4b4f4f52524f4f4f4f4f4f4f4f665e5b57535353534f4f6b6b635f5b575353534f6f6f6b63635b5753535373736f6b675f57575353ff77736b67635b575757ff7b736f67635f5b5757ffff736f6b675f5b57ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff209d0000000000000000000000000000808a04700e45e5bf410b00a6");
		f.setCallbackurl("1");
		f.setTimeout(200);
		//flist.add(f);
		
		AuthDelFinger df = new AuthDelFinger();
		df.setLocktype(2);
		df.setFingercode("00010001");
		df.setGatewaycode("002a010101");
		df.setGatewaycode2("1901010001");
		df.setRoomcode("0101");
		df.setRoomcode2("1901000001");
		df.setImei("1216121514151");
		df.setCallbackurl("1");
		df.setTimeout(200);
		dflist.add(df);
		
		AuthDelFinger df2 = new AuthDelFinger();
		df2.setLocktype(2);
		df2.setFingercode("00010002");
		df2.setGatewaycode("002a010101");
		df2.setGatewaycode2("1901010001");
		df2.setRoomcode("0101");
		df2.setRoomcode2("1901000001");
		df2.setCallbackurl("1");
		df2.setImei("1216121514151");
		df2.setTimeout(200);
		dflist.add(df2);
		
		AuthDelFinger df3 = new AuthDelFinger();
		df3.setLocktype(2);
		df3.setFingercode("00010001");
		df3.setGatewaycode("002a010102");
		df3.setGatewaycode2("1901010002");
		df3.setRoomcode("0102");
		df3.setRoomcode2("1901000002");
		df3.setCallbackurl("1");
		df3.setImei("1216121514151");
		df3.setTimeout(200);
		dflist.add(df3);
		
		AuthPsw p = new AuthPsw();
		p.setLocktype(3);
		p.setPassword("123456");
		p.setGatewaycode("002a010101");
		p.setGatewaycode2("1901010001");
		p.setRoomcode("0101");
		p.setRoomcode2("1901000001");
		p.setEdate("-1");
		p.setOpencount("0");
		p.setOpenstime("00:00");
		p.setOpenetime("23:59");
		p.setImei("1216121514151");
		p.setCallbackurl("1");
		p.setTimeout(200);
		plist.add(p);
		
		AuthDelPsw dp = new AuthDelPsw();
		dp.setLocktype(2);
		dp.setPassword("123456");
		dp.setGatewaycode("002a010101");
		dp.setGatewaycode2("1901010001");
		dp.setRoomcode("0101");
		dp.setRoomcode2("1901000001");
		dp.setCallbackurl("1");
		dp.setImei("1216121514151");
		dp.setTimeout(200);
		dplist.add(dp);
		
		SendResult<AuthResult> ret = sio.saveLotAuth(clist,dclist,flist,dflist,plist,dplist);
		System.out.println("报错信息:"+ret.getResultCode()+"-"+ret.getResultMsg());
		List<CardsResult> cardl = ret.getResult().getCardsresult();
		for(int i=0;i<cardl.size();i++) {
			System.out.println(cardl.get(i).toString());
		}
	 }

	public static SendResult checkTotal(LinkedHashMap param) {
		// TODO Auto-generated method stub
		SendResult st=new SendResult<>("0", "", "");
		String locktype="";
		if(param.containsKey("locktype")) {
			locktype=param.get("locktype")==null?"":param.get("locktype").toString();
			if(locktype==null || locktype.trim().length()<1 || "null".equals(locktype)) {
				st.setResultCode("10001");
				st.setResultMsg("门锁类型不能为空");
				return st;
			}
			if(!locktype.matches("[1-4]{1}")) {
				st.setResultCode("10002");
				st.setResultMsg("门锁类型必须为1-4的数字");
				return st;
			}
		}else {
			st.setResultCode("10001");
			st.setResultMsg("门锁类型为必传参数");
			return st;
		}
		if(locktype.equals("1")) {
			Set<Map.Entry<String, String>> paramsSet = param.entrySet();
			for (Map.Entry<String, String> paramEntry : paramsSet) {
				String key=paramEntry.getKey();
				Object val=paramEntry.getValue();
				if("gatewaycode".equals(key)) {
					if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
						st.setResultCode("-10001");
						st.setResultMsg("网关通讯ID不允许为空");
						return st;
					}else if(val.toString().length()!=10||val.toString().toUpperCase().matches(".*[G-Z].*")) {
						st.setResultCode("-10002");
						st.setResultMsg("网关通讯ID必须是长度为10的16进制字符串");
						return st;
					}
				}
				if("gatewaycode2".equals(key)) {
					if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
						st.setResultCode("-10003");
						st.setResultMsg("网关唯一ID不允许为空");
						return st;
					}else if(val.toString().length()!=10||val.toString().toUpperCase().matches(".*[G-Z].*")) {
						st.setResultCode("-10004");
						st.setResultMsg("网关唯一ID必须是长度为10的16进制字符串");
						return st;
					}
				}
				if("roomcode".equals(key)) {
					if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
						st.setResultCode("-10005");
						st.setResultMsg("房间编号不允许为空");
						return st;
					}else if(val.toString().length()!=4||val.toString().toUpperCase().matches(".*[G-Z].*")) {
						st.setResultCode("-10006");
						st.setResultMsg("房间编号必须是长度为4的16进制字符串");
						return st;
					}
				}
//				if() {
//					
//				}
			}	
		}else {
			Set<Map.Entry<String, String>> paramsSet = param.entrySet();
			for (Map.Entry<String, String> paramEntry : paramsSet) {
				String key=paramEntry.getKey();
				Object val=paramEntry.getValue();
				if("roomcode2".equals(key)) {
					if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
						st.setResultCode("-10019");
						st.setResultMsg("门锁唯一ID不允许为空");
						return st;
					}else if(val.toString().length()!=10||val.toString().toUpperCase().matches(".*[G-Z].*")) {
						st.setResultCode("-10020");
						st.setResultMsg("门锁唯一ID必须是长度为10的16进制字符串");
						return st;
					}
				}
				if("roomimei".equals(key)) {
					if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
						st.setResultCode("-10042");
						st.setResultMsg("IMEI不允许为空");
						return st;
					}
				}
				
			}	
		}
		String timeout=param.get("timeout")==null?"":param.get("timeout").toString();
		if(timeout==null ||!timeout.matches("[1-9]+")) {
			st.setResultCode("-10042");
			st.setResultMsg("超时间格式错误");
			return st;
		}
		String callbackurl=param.get("callbackurl")==null?"":param.get("callbackurl").toString();
		if(callbackurl==null || callbackurl.trim().length()<0) {
			st.setResultCode("-10042");
			st.setResultMsg("回调地址不能为空");
			return st;
		}
		return st;
	}
}
