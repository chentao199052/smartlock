package com.qingyi.receive.info.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.qingyi.model.LockStatusResult;
import com.qingyi.model.ReceiveResult;
import com.qingyi.receive.info.ReceiveOrderInfo;
import com.qingyi.util.Constant;
import com.qingyi.util.StringTools;
import com.qingyi.util.Verify;

public class ReceiveOrderImpl implements ReceiveOrderInfo{

	private String timeout;
	
	private String secret;

	public ReceiveOrderImpl() {
		super();
		secret=Constant.SECRET;
		timeout=Constant.TIMEOUT;
	}

	public ReceiveOrderImpl(String secret,String timeout) {
		super();
		this.timeout = timeout;
		this.secret = secret;
	}
	
	@Override
	public ReceiveResult getLockStatusResult(String content, String sysdate, String verify) {
		// TODO Auto-generated method stub
		ReceiveResult result=Verify.verify(content, sysdate, verify, secret, timeout);
		if(result.getResultCode().equals("0")) {
			Map json=StringTools.stringToMap(content);
			String itid=json.get("itid").toString();
			LockStatusResult r=new LockStatusResult();
			r.setOrderid(itid);
			if(json.get("status").equals("1")){
				String resultorder = json.get("result").toString();
				//生命周期
				String lca = resultorder.substring(30,31);
				
				//开关门状态
				String status =  resultorder.substring(31,32);
				String bet = resultorder.substring(32,34);
				//门锁功率等级默认为最大功率A3
				String powerlev = resultorder.substring(46,48);
				if(powerlev.toUpperCase().equals("A0")){
					powerlev = "A0";
				}else if(powerlev.toUpperCase().equals("A1")){
					powerlev = "A1";
				}else if(powerlev.toUpperCase().equals("A2")){
					powerlev = "A2";
				}else{
					powerlev = "A3";
				}
				String recordnum = resultorder.substring(50,54);
				String ver = resultorder.substring(54,62);
				String channelid = resultorder.substring(62,66);
				String channel = resultorder.substring(66,68);
				String networkmode = resultorder.substring(78,79);
				String workmode = resultorder.substring(79,80);
				String locktype = resultorder.substring(81,82);
				String figernum = resultorder.substring(82,84);
				
				int bettery  = Integer.valueOf(bet,16);
				if(lca.equals("1")){
					r.setLocklca(-1);
				}else if(lca.equals("2")){
					r.setLocklca(1);
				}else if(lca.equals("4")){
					r.setLocklca(2);
				}
				
				String[] type = StringTools.getlockstatus(status);
				//更新状态
				r.setLockstatus(Integer.valueOf(type[0]));
				r.setLockstatus2(Integer.valueOf(type[1]));
				r.setChannelid(channelid);
				r.setChannel(Integer.valueOf(channel,16)+"");
				r.setPowerlev(powerlev);
				r.setNetworkmode(Integer.valueOf(networkmode));
				r.setWorkmode(Integer.valueOf(workmode));
				r.setLocktype(Integer.valueOf(locktype));
				r.setFigernum(Integer.valueOf(figernum,16));
				r.setLockver(ver);
				r.setLockcharge(bettery);
				if(recordnum.equals("0000")){
					r.setRecordnum(0);
				}else{
					r.setRecordnum(Integer.valueOf(recordnum,16));
				}
				
			}
			String ret = json.get("result").toString();
			int failtype = StringTools.getFailtype(ret);
			r.setFiletype(failtype);
			result.setResult(r);
		}
		return result;
	}

}
