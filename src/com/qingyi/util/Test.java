package com.qingyi.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.qingyi.model.RoomFinger;
import com.qingyi.model.SendResult;
import com.qingyi.send.info.SendOrderInfo;
import com.qingyi.send.info.impl.SendOrderImpl;

public class Test {
	public static void main(String[] args) {
		SendOrderInfo info=new SendOrderImpl();
		 SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmss");
		String date = format.format(new Date());
		RoomFinger rf=new RoomFinger("00000008","dd020dff854c0db2063609ae0a450ba60e19062c98c4135403031440040e183706981927089c0cdc23430408a8200812836807e498570383c1002556010000000000000000000000000011d1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000bedffbdfbd750700000000000000000000000000810057000b0effffffff2f33333337323274716bffffff2b2f2f2f2f2f2a267c766fffff2f2b2b2b2727231b177e7773ff332f2b2723231f17130f7f7b7733332b2723231f17130f0b7f7b77332f2b231f1b1b130f0b077f7b7b2f2b231f1b17130f0b0b077f7f7b2b2b1f17130f0b0b0707077f7fff2a221a120f0b0b0b0b07077f7fff221a15120a0b0b0b0b0b0703ffffff1d15120e0b0b0b0b0bffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff2097000000000000000000000000000001200ad9a4d5000000000000",
				"-1","08:30","20:30","-1","1");
		rf.setFingerseq("1");
		List<RoomFinger> rflist=new ArrayList<RoomFinger>();
		rflist.add(rf);
		SendResult result = info.updateRoomFiger("00a1010001","1818010001","0101",rflist,200,"https://www.baidu.com");
		//SendResult result = info.saveFingerReagy("1817020001", 100,"https://www.baidu.com");
		System.out.println(result.getResultCode()+"-"+result.getResultMsg()+"4");
	}
}
