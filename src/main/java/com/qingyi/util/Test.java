package com.qingyi.util;

import java.util.ArrayList;
import java.util.List;

import com.qingyi.model.AuthCard;
import com.qingyi.model.AuthDelCard;
import com.qingyi.model.AuthDelFinger;
import com.qingyi.model.AuthDelPsw;
import com.qingyi.model.AuthFinger;
import com.qingyi.model.AuthPsw;
import com.qingyi.model.AuthRestAndOpen;
import com.qingyi.model.AuthResult;
import com.qingyi.model.DelCardsResult;
import com.qingyi.model.DelFingersResult;
import com.qingyi.model.LockResult;
import com.qingyi.model.PswsResult;
import com.qingyi.model.Room;
import com.qingyi.model.Roompow;
import com.qingyi.model.SendResult;
import com.qingyi.receive.info.ReceiveOrderInfo;
import com.qingyi.receive.info.impl.ReceiveOrderImpl;
import com.qingyi.send.info.SendOrderInfo;
import com.qingyi.send.info.impl.SendOrderImpl;

public class Test {
	public static void main(String[] args) {
		//第一步，注册
		SendOrderInfo info =new SendOrderImpl("指令服务器地址","密钥");
		info.registerDevice("电信填3","门锁的imei","自定义的门锁名称","");
		
		//卡片密码指纹授权结果解析
		ReceiveOrderInfo info2 = new ReceiveOrderImpl();
		info2.getOrderResult("content", "sysdate", "verify");
		/*List<AuthPsw> as=new ArrayList<>();
		AuthPsw c=new AuthPsw(1, "1234567894", "1112", "", "1234567897", "1234567894", "123456","00:00","23:59","-1","-1");
		AuthPsw d=new AuthPsw(2, "1234567894", "1112", "1234567890", "", "", "123456","00:00","23:59","-1","-1");
		as.add(c);
		as.add(d);
		SendResult<AuthResult> ss = info.saveTotalUnlockPswList(as, 200, "sss");
		System.out.println(ss);*/
	}
}
