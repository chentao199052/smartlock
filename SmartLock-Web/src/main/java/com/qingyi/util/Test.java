package com.qingyi.util;

import java.util.ArrayList;
import java.util.List;

import com.qingyi.model.AuthRestAndOpen;
import com.qingyi.model.LockResult;
import com.qingyi.model.SendResult;
import com.qingyi.send.info.SendOrderInfo;
import com.qingyi.send.info.impl.SendOrderImpl;

public class Test {
//	public static void main(String[] args) {
//		 String ss="{\"resultCode\":\"0\",\"resultMsg\":\"\",\"result\":[{\"orderId\":\"1114445\",\"locktype\":\"1\",\"code\":\"1114\"}]}";
//		 SendResult send = StringTools .getSendResultByJson2(ss);
//		 System.out.println(send);
		
//		SendOrderInfo info=new SendOrderImpl();
//		List<AuthRestAndOpen> s =new ArrayList<AuthRestAndOpen>();
//		AuthRestAndOpen open=new AuthRestAndOpen("1", "1234567891", "7984561230", "4561", "", 200, "www.ss.com");
//		s.add(open);
//		info.saveTotalResetList(s);
		
//		String ss="{\"resultCode\":\"0\",\"resultMsg\":\"\",\"orderId\":\"1087250121243353088\",\"result\":[{\"orderId\":\"1087250121243353088\",\"locktype\":\"1\",\"code\":\"4561\"}]}";
//		SendResult send = StringTools .getSendResultByJson2(ss,Object.class);
//		System.out.println(send);
//	}
	
	public static void main(String[] args) {
		SendOrderInfo info=new SendOrderImpl();
		//发送门锁记录
//		SendResult readLockRecord = info.readLockRecord("7415267456", "7415267456", "7415", "", "1", 111550, "ss");
//		System.out.println(readLockRecord);
		List<AuthRestAndOpen> oplist=new ArrayList<AuthRestAndOpen>();
		AuthRestAndOpen a1=new AuthRestAndOpen("1", "7415267456", "7415267456", "1234", "7894561232", 100, "ss");
		AuthRestAndOpen a2=new AuthRestAndOpen("2", "", "", "", "7894561232", 100, "ss");
		oplist.add(a1);
		oplist.add(a2);
		SendResult readLockRecord=info.saveTotalOpenList(oplist);
		System.out.println(readLockRecord);
	}
}
