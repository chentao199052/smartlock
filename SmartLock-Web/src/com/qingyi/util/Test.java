package com.qingyi.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import com.qingyi.model.Card;

public class Test {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub "yyyy-MM-dd HH:mm:ss"
//				try {
//					Card cc=new Card("100011", 1, Timestamp.valueOf("2019-01-12 14:26:14"), 2, 2, 1, "101556", "zhang",Timestamp.valueOf("2019-02-12 14:26:14"), "00:00~12:16", "123456", 1, 2);
//					String json=StringTools.simpleObjectToJsonStr(cc);
//					System.out.println(json);
//				} catch (IllegalArgumentException | IllegalAccessException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
		//Map转json
		 LinkedHashMap params=new LinkedHashMap();
		 params.put("a", "nihao");
		 params.put("b", "tahao");
		 params.put("c", "nima");
		 params.put("d", "chung");
		String json= StringTools.mapToString(params);
		  System.out.println(json);
	}
}
