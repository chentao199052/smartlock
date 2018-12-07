package com.qingyi.util;

import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

import com.qingyi.model.SendResult;
import com.qingyi.send.info.impl.SendOrderImpl;


public class StringTools {
	

	public static void main(String[] args) {
		SendOrderImpl send=new SendOrderImpl();
		SendResult sr=send.getLockStaus("1812010001", "1812010001", "0101", "0", "http://s.keenzy.cn");
		System.out.println(sr.getResultMsg());
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
            return buf.toString().toUpperCase();
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
        
	}

}
