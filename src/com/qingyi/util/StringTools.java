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

import com.qingyi.model.RoomCard;
import com.qingyi.model.SendResult;
import com.qingyi.model.UnlockPsw;
import com.qingyi.send.info.SendOrderInfo;
import com.qingyi.send.info.impl.SendOrderImpl;




public class StringTools {
	

	
	public static Object mapToBean(Class<?> clazz, Map map) throws Exception {
        Object javabean = clazz.newInstance(); // 构建对象
        Method[] methods = clazz.getMethods(); // 获取所有方法
        for (Method method : methods) {
            if (method.getName().startsWith("set")) {
                String field = method.getName(); // 截取属性名
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
				String a[]=arr[i].split(":");
				map.put(a[0].substring(1, a[0].length()-1), a[1].substring(1, a[1].length()-1));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("resultCode", "0");
			map.put("resultMsg", "解析结果出错！");
		}
		try {
			obj=StringTools.mapToBean(clazz, map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

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
            //打印生成的MD5加密信息摘要
            //32位加密  
            // return buf.toString();  
            return buf.toString().toLowerCase();
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
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
					sr.setResultMsg("网关通讯ID不允许为空");
					return sr;
				}else if(val.toString().length()!=10||val.toString().toUpperCase().matches(".*[G-Z].*")) {
					sr.setResultCode("-10002");
					sr.setResultMsg("网关通讯ID必须是长度为10的16进制字符串");
					return sr;
				}
			}else if(key.equals("gatewaycode2")) {
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10003");
					sr.setResultMsg("网关唯一ID不允许为空");
					return sr;
				}else if(val.toString().length()!=10||val.toString().toUpperCase().matches(".*[G-Z].*")) {
					sr.setResultCode("-10004");
					sr.setResultMsg("网关唯一ID必须是长度为10的16进制字符串");
					return sr;
				}
			}else if(key.equals("roomcode")) {
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10005");
					sr.setResultMsg("房间编号不允许为空");
					return sr;
				}else if(val.toString().length()!=4||val.toString().toUpperCase().matches(".*[G-Z].*")) {
					sr.setResultCode("-10006");
					sr.setResultMsg("房间编号必须是长度为4的16进制字符串");
					return sr;
				}
			}else if(key.equals("timeout")) {
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10007");
					sr.setResultMsg("有效时间不允许为空");
					return sr;
				}else if(!val.toString().matches("[0-9]+")) {
					sr.setResultCode("-10021");
					sr.setResultMsg("有效时间必须为10进制数字");
					return sr;
				}
			}else if(key.equals("pass")) {
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10008");
					sr.setResultMsg("授权密码不允许为空");
					return sr;
				}else if(val.toString().length()!=6||!val.toString().matches("[0-9]+")) {
					sr.setResultCode("-10009");
					sr.setResultMsg("授权密码必须是长度为6的10进制字符串");
					return sr;
				}
			}else if(key.equals("count")) {
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10010");
					sr.setResultMsg("可开门次数不允许为空");
					return sr;
				}else if(!val.toString().matches("[0-9]+|(-1)")) {
					sr.setResultCode("-10011");
					sr.setResultMsg("可开门次数必须为10进制数字");
					return sr;
				}
			}else if(key.equals("edate")) {
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10012");
					sr.setResultMsg("有效结束日期不允许为空");
					return sr;
				}else if(!val.toString().equals("-1")&&(val.toString().length()!=10||!val.toString().matches("\\d+"))) {
					sr.setResultCode("-10013");
					sr.setResultMsg("有效结束日期格式必须为yyMMddHHmm");
					return sr;
				}
			}else if(key.equals("unlockstime")) {
				String val2=val.toString().replace(":", "");
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10014");
					sr.setResultMsg("可开门时间段开始时间不允许为空");
					return sr;
				}else if(val.toString().length()!=5) {
					sr.setResultCode("-10015");
					sr.setResultMsg("可开门时间段开始时间格式错误，格式必须为XX:XX，例如00:00");
					return sr;
				}else if(!val.toString().contains(":")) {
					sr.setResultCode("-10015");
					sr.setResultMsg("可开门时间段开始时间格式错误，格式必须为XX:XX，例如00:00");
					return sr;
				}else if(val2.length()!=4||!val2.matches("[0-9]+")) {
					sr.setResultCode("-10015");
					sr.setResultMsg("可开门时间段开始时间格式错误，格式必须为XX:XX，例如00:00");
					return sr;
				}
			}else if(key.equals("unlocketime")) {
				String val2=val.toString().replace(":", "");
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10016");
					sr.setResultMsg("可开门时间段结束时间不允许为空");
					return sr;
				}else if(val.toString().length()!=5) {
					sr.setResultCode("-10017");
					sr.setResultMsg("可开门时间段结束时间格式错误，格式必须为XX:XX，例如00:00");
					return sr;
				}else if(!val.toString().contains(":")) {
					sr.setResultCode("-10017");
					sr.setResultMsg("可开门时间段结束时间格式错误，格式必须为XX:XX，例如00:00");
					return sr;
				}else if(val2.length()!=4||!val2.matches("[0-9]+")) {
					sr.setResultCode("-10017");
					sr.setResultMsg("可开门时间段结束时间格式错误，格式必须为XX:XX，例如00:00");
					return sr;
				}
			}else if(key.equals("callbackurl")) {
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10018");
					sr.setResultMsg("回调地址不允许为空");
					return sr;
				}
			}else if(key.equals("roomcode2")) {
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10019");
					sr.setResultMsg("门锁唯一ID不允许为空");
					return sr;
				}else if(val.toString().length()!=10||val.toString().toUpperCase().matches(".*[G-Z].*")) {
					sr.setResultCode("-10020");
					sr.setResultMsg("门锁唯一ID必须是长度为10的16进制字符串");
					return sr;
				}
			}else if(key.equals("openstime")) {
				String val2=val.toString().replace(":", "");
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10022");
					sr.setResultMsg("可开门时间段开始时间不允许为空");
					return sr;
				}else if(val.toString().length()!=5) {
					sr.setResultCode("-10023");
					sr.setResultMsg("可开门时间段开始时间格式错误，格式必须为XX:XX，例如00:00");
					return sr;
				}else if(!val.toString().contains(":")) {
					sr.setResultCode("-10023");
					sr.setResultMsg("可开门时间段开始时间格式错误，格式必须为XX:XX，例如00:00");
					return sr;
				}else if(val2.length()!=4||!val2.matches("\\d+")) {
					sr.setResultCode("-10023");
					sr.setResultMsg("可开门时间段开始时间格式错误，格式必须为XX:XX，例如00:00");
					return sr;
				}
			}else if(key.equals("openetime")) {
				String val2=val.toString().replace(":", "");
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10024");
					sr.setResultMsg("可开门时间段结束时间不允许为空");
					return sr;
				}else if(val.toString().length()!=5) {
					sr.setResultCode("-10025");
					sr.setResultMsg("可开门时间段结束时间格式错误，格式必须为XX:XX，例如00:00");
					return sr;
				}else if(!val.toString().contains(":")) {
					sr.setResultCode("-10025");
					sr.setResultMsg("可开门时间段结束时间格式错误，格式必须为XX:XX，例如00:00");
					return sr;
				}else if(val2.length()!=4||!val2.matches("[0-9]+")) {
					sr.setResultCode("-10025");
					sr.setResultMsg("可开门时间段结束时间格式错误，格式必须为XX:XX，例如00:00");
					return sr;
				}
			}else if(key.equals("cardtype")) {
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10026");
					sr.setResultMsg("卡片类型不允许为空");
					return sr;
				}else if(!val.toString().equals("开门卡")&&!val.toString().equals("管理卡")&&!val.toString().equals("授权卡")&&!val.toString().equals("身份证")) {
					sr.setResultCode("-10027");
					sr.setResultMsg("卡片类型必须为开门卡/管理卡/授权卡/身份证");
					return sr;
				}
			}else if(key.equals("cardcode")) {
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10028");
					sr.setResultMsg("卡号不允许为空");
					return sr;
				}else if(val.toString().equals("开门卡")||val.toString().equals("管理卡")||val.toString().equals("授权卡")) {
					if(val.toString().length()!=8||val.toString().toUpperCase().matches(".*[G-Z].*")) {
						sr.setResultCode("-10029");
						sr.setResultMsg("开门卡/管理卡/授权卡卡号必须是长度为10的16进制字符串");
						return sr;
					}
				}else if(val.toString().equals("身份证")) {
					if(val.toString().length()!=16||val.toString().toUpperCase().matches(".*[G-Z].*")) {
						sr.setResultCode("-10030");
						sr.setResultMsg("开门卡/管理卡/授权卡卡号必须是长度为16的16进制字符串");
						return sr;
					}
				}
			}else if(key.equals("cardedate")) {
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10031");
					sr.setResultMsg("卡片有效结束日期不允许为空");
					return sr;
				}else if(!val.toString().equals("-1")&&(val.toString().length()!=10||!val.toString().matches("\\d+"))) {
					sr.setResultCode("-10032");
					sr.setResultMsg("卡片有效结束日期格式必须为yyMMddHHmm");
					return sr;
				}
			}else if(key.equals("opencount")) {
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10033");
					sr.setResultMsg("可开门次数不允许为空");
					return sr;
				}else if(val.toString().matches("[0-9]+|(-1)")) {
					sr.setResultCode("-10034");
					sr.setResultMsg("可开门次数必须为数字");
					return sr;
				}
			}else if(key.equals("fingercode")) {
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10035");
					sr.setResultMsg("指纹编号不允许为空");
					return sr;
				}else if(val.toString().length()!=8||val.toString().toUpperCase().matches(".*[G-Z].*")) {
					sr.setResultCode("-10036");
					sr.setResultMsg("指纹编号必须是长度为10的16进制字符串");
					return sr;
				}
			}else if(key.equals("fingercontent")) {
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10037");
					sr.setResultMsg("指纹特征码不允许为空");
					return sr;
				}else if(val.toString().length()!=988||val.toString().toUpperCase().matches(".*[G-Z].*")) {
					sr.setResultCode("-10038");
					sr.setResultMsg("指纹特征码必须是长度为988的16进制字符串");
					return sr;
				}
			}else if(key.equals("actioncount")) {
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10039");
					sr.setResultMsg("开门需按指纹次数不允许为空");
					return sr;
				}else if(val.toString().matches("[0-9]+|(-1)")) {
					sr.setResultCode("-10040");
					sr.setResultMsg("开门需按指纹次数必须为数字");
					return sr;
				}
			}else if(key.equals("rclist")) {
			}else if(key.equals("fpcode")) {
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10041");
					sr.setResultMsg("指纹机唯一ID不允许为空");
					return sr;
				}
			}else if(key.equals("roomimei")) {
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10042");
					sr.setResultMsg("IMEI不允许为空");
					return sr;
				}
			}
		}
		return sr;
	}
	
	/**
	  * 切割指令获取failtype
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
	  * 获取门锁状态
	  * @param lockstatus
	  * @return
	  */
	 public static String[] getlockstatus(String lockstatus){
		 String[] ret = new String[2];
		 
		 String ls =hexString2binaryString("0"+lockstatus);
		 ls = ls.substring(4);
		 //1为（开关门）无意义
		 if(ls.substring(0,1).equals("0")){
			 if(ls.substring(3,4).equals("1")){
				 ret[0] = "1";
			 }else{
				 ret[0] = "0";
			 }
		 }else{
			 ret[0] = "2";
		 }  
		 
		 //反锁有无意义
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
	  * 多条门锁操作记录解析成json列表(完整版)
	  * @param order
	  * @return
	  */
	 public static List<Map> getUnlockinglist(String order){
		 List<Map> slUnlockings = new ArrayList<Map>();
		 String uns = "";
		 //单条
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
	  * 分割多条门锁操作记录为单条记录数组
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
	  * 为多个门锁字符串添加分隔符号","
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
	 
	 //指令位22,26
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
	  * 多条门锁操作记录解析成json列表(有效指令截取版)
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
	  * 每两位十六进制字符串转成二进制8位字符串
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
	  * 获取实时查询门锁记录所得返回记录总数
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
}
