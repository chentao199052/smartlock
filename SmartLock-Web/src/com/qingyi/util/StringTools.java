package com.qingyi.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;
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
	

	public static void main(String[] args) {
		RoomCard rc=new RoomCard("开门卡", "2f5d2e2c", "1812111506", "23:00", "23:30", "1");
		List l=new ArrayList<>();
		l.add(rc);
		rc=new RoomCard("开门卡", "2e6f5e2a", "1812111506", "21:00", "23:33", "-1");
		l.add(rc);
		UnlockPsw psw=new UnlockPsw("123456", "1", "1812111620", "00:00", "23:59");
		List l2=new ArrayList<>();
		l2.add(psw);
		SendOrderInfo send=new SendOrderImpl("http://localhost:80", "5s4d1rt41rtrt1were4rt1w415tfdsdt1tyt4y51yhtuy");
		SendResult result=send.syncRoomCardAndPsw("00a1010001", "1818010001", "0101", l, l2, 100, "http://localhost/SmartLock");
		System.out.println(result.getResultCode()+"-"+result.getResultMsg());
	}
	
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
				}else if(!val.toString().matches("\\d+")) {
					sr.setResultCode("-10021");
					sr.setResultMsg("有效时间必须为10进制数字");
					return sr;
				}
			}else if(key.equals("pass")) {
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10008");
					sr.setResultMsg("授权密码不允许为空");
					return sr;
				}else if(val.toString().length()!=6||!val.toString().matches("\\d+")) {
					sr.setResultCode("-10009");
					sr.setResultMsg("授权密码必须是长度为6的10进制字符串");
					return sr;
				}
			}else if(key.equals("count")) {
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10010");
					sr.setResultMsg("可开门次数不允许为空");
					return sr;
				}else if(!val.toString().matches("\\d+")) {
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
				}else if(val2.length()!=4||!val2.matches("\\d+")) {
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
				}else if(val2.length()!=4||!val2.matches("\\d+")) {
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
				}else if(val2.length()!=4||!val2.matches("\\d+")) {
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
				}else if(val.toString().matches("\\d+")) {
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
				}else if(val.toString().length()!=8||val.toString().toUpperCase().matches(".*[G-Z].*")) {
					sr.setResultCode("-10038");
					sr.setResultMsg("指纹特征码必须是长度为988的16进制字符串");
					return sr;
				}
			}else if(key.equals("actioncount")) {
				if(val.toString()==null||val.toString().equals("")||val.toString().equals("null")) {
					sr.setResultCode("-10039");
					sr.setResultMsg("开门需按指纹次数不允许为空");
					return sr;
				}else if(val.toString().matches("\\d+")) {
					sr.setResultCode("-10040");
					sr.setResultMsg("开门需按指纹次数必须为数字");
					return sr;
				}
			}else if(key.equals("rclist")) {
			}
		}
		return sr;
	}

}
