package com.qingyi.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qingyi.model.RoomCard;

public class HttpsUtil {
	
	public static String httpURLConnectionPOST (String baseurl,String method,String secret,Map param) {  
		String result="";
        try {  
            URL url = new URL(baseurl+"/"+method);  
              
            // 将url 以 open方法返回的urlConnection  连接强转为HttpURLConnection连接  (标识一个url所引用的远程对象连接)  
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();// 此时cnnection只是为一个连接对象,待连接中  
            connection.setReadTimeout(1000);
            connection.setConnectTimeout(1000);
            // 设置连接输出流为true,默认false (post 请求是以流的方式隐式的传递参数)  
            connection.setDoOutput(true);  
              
            // 设置连接输入流为true  
            connection.setDoInput(true);  
              
            // 设置请求方式为post  
            connection.setRequestMethod("POST");  
              
            // post请求缓存设为false  
            connection.setUseCaches(false);  
              
            // 设置该HttpURLConnection实例是否自动执行重定向  
            connection.setInstanceFollowRedirects(true);  
              
            // 设置请求头里面的各个属性 (以下为设置内容的类型,设置为经过urlEncoded编码过的from参数)  
            // application/x-javascript text/xml->xml数据 application/x-javascript->json对象 application/x-www-form-urlencoded->表单数据  
            // charset=utf-8 必须要，不然妙兜那边会出现乱码【★★★★★】  
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");     
              
            // 建立连接 (请求未开始,直到connection.getInputStream()方法调用时才发起,以上各个参数设置需在此方法之前进行)  
            connection.connect();  
              
            // 创建输入输出流,用于往连接里面输出携带的参数,(输出内容为?后面的内容)  
            DataOutputStream dataout = new DataOutputStream(connection.getOutputStream());  
            
            // 参数
            Date date=new Date();
            String params="";
            Set<Map.Entry<String, Object>> paramsSet = param.entrySet();
            String md="";
    		for (Map.Entry<String, Object> paramEntry : paramsSet) {
    			if(paramEntry.getKey().contains("list")) {
    				List<Object> l=(List<Object>) paramEntry.getValue();
    				String json=StringTools.beanToString(l);
    				params+="&"+paramEntry.getKey()+"="+URLEncoder.encode(json, "utf-8");
	    			md+=json;
    			}else {
	    			params+="&"+paramEntry.getKey()+"="+URLEncoder.encode(paramEntry
	    					.getValue().toString(), "utf-8");
	    			md+=paramEntry
	    					.getValue();
    			}
    		}
    		System.out.println(md+date.getTime()+secret);
    		params = params+ ("&sysdate=" + URLEncoder.encode(date.getTime()+"", "utf-8"));
            String md5=StringTools.getMd5(md+date.getTime()+secret);
            System.out.println(md5);
            String verify = "&verify=" + URLEncoder.encode(md5, "utf-8");
            	            
            // 参数拼接 参数1+参数2+...... 
            String parm = params + verify;  
              
            // 将参数输出到连接  
            dataout.writeBytes(parm);  
              
            // 输出完成后刷新并关闭流  
            dataout.flush();  
            dataout.close(); // 重要且易忽略步骤 (关闭流,切记!)   	              
              
            // 连接发起请求,处理服务器响应  (从连接获取到输入流并包装为bufferedReader)  
            BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));   
            String line;  
            // 读取返回的内容  
            while ((line = bf.readLine()) != null) {  
                result += line;  
            }  
            bf.close();    // 重要且易忽略步骤 (关闭流,切记!)   
            connection.disconnect(); // 销毁连接  
        } catch (Exception e) {  
            e.printStackTrace();  
            result="{\"resultCode\":\"0\",\"resultMsg\":\"连接指令服务器失败，请检查网络！\"}";
        }  
        return result;
    } 
}
