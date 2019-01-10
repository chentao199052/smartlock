package com.qingyi.nbreceive.info.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.qingyi.model.NBbackorder;
import com.qingyi.model.NBbackorderResult;
import com.qingyi.model.NBbackorderResult2;
import com.qingyi.model.NBbackorderResult3;
import com.qingyi.model.NBbackorderResult4;
import com.qingyi.model.NBbackorderResult5;
import com.qingyi.model.NBorderResult;
import com.qingyi.model.NBorderResult2;
import com.qingyi.model.NBorderResult3;
import com.qingyi.model.NBorderResult4;
import com.qingyi.model.NBorderResult5;
import com.qingyi.model.NBorderResult6;
import com.qingyi.model.NBorderResult7;
import com.qingyi.model.NBrecords;
import com.qingyi.model.NBrecordsResult;
import com.qingyi.model.ReceiveResult;
import com.qingyi.model.SlRoomParamas;
import com.qingyi.nbreceive.info.NBreceiveOrderInfo;
import com.qingyi.util.Constant;
import com.qingyi.util.StringTools;
import com.qingyi.util.Verify;



public class NBreceiveOrderImpl implements NBreceiveOrderInfo {
	private String timeout;
	
	private String secret;

	public NBreceiveOrderImpl() {
		super();
		secret=Constant.SECRET;
		timeout=Constant.TIMEOUT;
	}

	public NBreceiveOrderImpl(String secret,String timeout) {
		super();
		this.timeout = timeout;
		this.secret = secret;
	}
	
	
	    @Override
		public ReceiveResult getNBbackorderResult(String content, String sysdate, String verify) {
			// TODO Auto-generated method stub
			ReceiveResult result =Verify.verify(content, sysdate, verify, secret, timeout);
			if(result.getResultCode().equals("0")) {
				Map json=StringTools.stringToMap2(content);
				NBbackorderResult r=new NBbackorderResult();
				String old = json.get("old").toString();
				String order=json.get("order").toString();
				List<String> rcs = StringTools.getListByString(old);
				List<NBbackorder> rcs1=new ArrayList<NBbackorder>();
				List<NBbackorder> rfs=new ArrayList<NBbackorder>();
				List<NBbackorder> rps=new ArrayList<NBbackorder>();
				for(int i=0;i<rcs.size();i++) {
					String c1 = rcs.get(i).toString();
					String[] param = c1.split("-");
					 if(param.length>=3) {
						Integer paramvalue=Integer.valueOf(param[3]);
						String id = param[1];
						if(id.contains("c")) {
							NBbackorder nbr=new NBbackorder();
							id = id.substring(1);
							nbr.setParam(param);
							nbr.setParamvalue(paramvalue);
							nbr.setId(id);
							rcs1.add(nbr);
						}else if(id.contains("f")) {
							NBbackorder nbr=new NBbackorder();
							id = id.substring(1);
							nbr.setParam(param);
							nbr.setParamvalue(paramvalue);
							nbr.setId(id);
							rfs.add(nbr);
						}else if(id.contains("p")) {}
							NBbackorder nbr=new NBbackorder();
							id = id.substring(1);
							nbr.setParam(param);
							nbr.setParamvalue(paramvalue);
							nbr.setId(id);
							rps.add(nbr);
					 }
				}
				r.setOrder(order);
				r.setRcfps(rcs);
				r.setRcs(rcs1);
				r.setRfs(rfs);
				r.setRps(rps);
				r.setResultstatus(1);
				result.setResultstatus(1);
				result.setResult(r);
			}
			return result;
		}

		@Override
		public ReceiveResult getNBbackorderResult2(String content, String sysdate, String verify) {
			// TODO Auto-generated method stub
			ReceiveResult result =Verify.verify(content, sysdate, verify, secret, timeout);
			if(result.getResultCode().equals("0")) {
				Map json=StringTools.stringToMap2(content);
				NBbackorderResult2 r =new NBbackorderResult2();
				String itid=json.get("rcid").toString();
				String num=json.get("num").toString();
				String finishorder=json.get("finishorder").toString();
				r.setOrderid(itid);
				r.setNum(Integer.parseInt(num));
				r.setFinishorder(finishorder);
				if(Integer.parseInt(num)>=3) {
					String[] os = finishorder.split(",");
					if(os.length>2) {
						String rcids = os[1].replace("~", ",");
						r.setRcids(rcids);
					}
				}	
				r.setResultstatus(1);
				result.setResultstatus(1);
				result.setResult(r);
			}
			return result;
		}

		@Override
		public ReceiveResult getNBbackorderResult3(String content, String sysdate, String verify) {
			// TODO Auto-generated method stub
			ReceiveResult result =Verify.verify(content, sysdate, verify, secret, timeout);
			if(result.getResultCode().equals("0")) {
				Map json=StringTools.stringToMap2(content);
				NBbackorderResult3 r =new NBbackorderResult3();
				String itid=json.get("rcid").toString();
				String num=json.get("num").toString();
				String finishorder=json.get("finishorder").toString();
				r.setOrderid(itid);
				r.setNum(Integer.parseInt(num));
				r.setFinishorder(finishorder);
				if(Integer.parseInt(num)>=3) {
					String[] os = finishorder.split(",");
					if(os.length>=2) {
						String rfid = os[1].toString();
						r.setRfid(rfid);
					}
				}	
				r.setResultstatus(1);
				result.setResultstatus(1);
				result.setResult(r);
			}
			return result;
		}

		@Override
		public ReceiveResult getNBbackorderResult4(String content, String sysdate, String verify) {
			// TODO Auto-generated method stub
			ReceiveResult result =Verify.verify(content, sysdate, verify, secret, timeout);
			if(result.getResultCode().equals("0")) {
				Map json=StringTools.stringToMap2(content);
				NBbackorderResult4 r =new NBbackorderResult4();
				String num=json.get("num").toString();
				r.setNum(Integer.parseInt(num));
				if(Integer.parseInt(num)>=3) {
					String itid = json.get("rcid").toString();
					r.setOrderid(itid);
				}
				r.setResultstatus(1);
				result.setResultstatus(1);
				result.setResult(r);
			}
			return result;
		}
		
		@Override
		public ReceiveResult getNBbackorderResult5(String content, String sysdate, String verify) {
			// TODO Auto-generated method stub
			ReceiveResult result =Verify.verify(content, sysdate, verify, secret, timeout);
			if(result.getResultCode().equals("0")) {
				Map json=StringTools.stringToMap2(content);
				String id = json.get("id").toString();
				String old = json.get("old").toString();
				String[] param = old.split("-");
				String order =json.get("order").toString();
				NBbackorderResult5 r=new NBbackorderResult5();
				r.setOrderid(id);
				r.setOld(old);
				r.setOrder(order);
				r.setParam(param);
				r.setResultstatus(1);
				result.setResultstatus(1);
				result.setResult(r);
			}
			return result;
		}
		
		@Override
		//门锁返回结果的json
		public ReceiveResult getNBorderResult(String content, String sysdate, String verify) {
			// TODO Auto-generated method stub
			ReceiveResult result =Verify.verify(content, sysdate, verify, secret, timeout);
			if(result.getResultCode().equals("0")) {
				Map json=StringTools.stringToMap2(content);
				NBorderResult r=new NBorderResult();
				String order=json.get("order").toString();
				r.setOrder(order);
				String[] os = order.split(",");
				String ids = os[1].replace("~", ",");
				if(ids.contains("p")) {
					ids = ids.replace("p", "");
					r.setIds(ids);
				}else if(ids.contains("c")){
					ids = ids.replace("c", "");
					r.setIds(ids);
				}
				r.setResultstatus(1);
				result.setResultstatus(1);
				result.setResult(r);
			}
			return result;
		}

		@Override
		public ReceiveResult getNBorderResult2(String content, String sysdate, String verify) {
			// TODO Auto-generated method stub
			ReceiveResult result =Verify.verify(content, sysdate, verify, secret, timeout);
			if(result.getResultCode().equals("0")) {
				Map json=StringTools.stringToMap2(content);
				NBorderResult2 r=new NBorderResult2();
				String order=json.get("order").toString();
				r.setOrder(order);
				String[] os = order.split(",");
				if(os.length>=2) {
					String id = os[1].toString();
					r.setId(id);
				}
				r.setResultstatus(1);
				result.setResultstatus(1);
				result.setResult(r);
			}
			return result;
		}

		@Override
		public ReceiveResult getNBorderResult3(String content, String sysdate, String verify) {
			// TODO Auto-generated method stub
			ReceiveResult result =Verify.verify(content, sysdate, verify, secret, timeout);
			if(result.getResultCode().equals("0")) {
				Map json=StringTools.stringToMap2(content);
				NBorderResult3 r=new NBorderResult3();
				String order=json.get("order").toString();
				String[] orders = order.split("-");
				String itid = json.get("rcid").toString();
				r.setOrder(order);
				r.setOrderid(itid);
				String puids = "";
				String rcids = "";
				for(int j=0;j<orders.length;j++) {
					String or = orders[j];
					String[] os = or.split(",");
					String ids = os[1].replace("~", ",");
					if(ids.contains("p")) {
						if("".equals(puids)) {
							puids = ids.replace("p", "");
						}else {
							puids = puids + "," + ids.replace("p", "");
						}
					}else if(ids.contains("c")){
						if("".equals(rcids)) {
							rcids = ids.replace("c", "");
						}else {
							rcids = rcids + "," + ids.replace("c", "");
						}
					}
				}
				r.setPuids(puids);
				r.setRcids(rcids);
				String ret=json.get("result").toString();
				int failtype = StringTools.getFailtype(ret);
				r.setFiletype(failtype);
				r.setResultstatus(1);
				result.setResultstatus(1);
				result.setResult(r);
			}
			return result;
		}

		@Override
		public ReceiveResult getNBorderResult4(String content, String sysdate, String verify) {
			// TODO Auto-generated method stub
			ReceiveResult result =Verify.verify(content, sysdate, verify, secret, timeout);
			if(result.getResultCode().equals("0")) {
				Map json=StringTools.stringToMap2(content);
				NBorderResult4 r=new NBorderResult4();
				String order=json.get("order").toString();
				String[] orders =order.split("-");
				String itid = json.get("rcid").toString();
				r.setOrder(order);
				r.setOrders(orders);
				r.setOrderid(itid);
				r.setResultstatus(1);
				result.setResultstatus(1);
				result.setResult(r);
			}
			return result;
		}

		@Override
		public ReceiveResult getNBorderResult5(String content, String sysdate, String verify) {
			// TODO Auto-generated method stub
			ReceiveResult result =Verify.verify(content, sysdate, verify, secret, timeout);
			if(result.getResultCode().equals("0")) {
				Map json=StringTools.stringToMap2(content);
				NBorderResult5 r=new NBorderResult5();
				String order=json.get("order").toString();
				String[] orders = json.get("order").toString().split("-");
				String itid = json.get("rcid").toString();
				r.setOrderid(itid);
				r.setOrder(order);
				String failids = "";
				for(int j=0;j<orders.length;j++) {
					String ord = orders[j];
					String[] os = ord.split(",");
					String id = os.length>1?os[1].toString():"";
					if("".equals(failids)) {
						failids = id;
					}else {
						failids = failids + "," + id;
					}
				}
				r.setFailids(failids);
				String ret=json.get("result").toString();
				r.setResult(ret);
				r.setResultstatus(1);
				result.setResultstatus(1);
				result.setResult(r);
			}
			return result;
		}

		@Override
		public ReceiveResult getNBorderResult6(String content, String sysdate, String verify) {
			// TODO Auto-generated method stub
			ReceiveResult result =Verify.verify(content, sysdate, verify, secret, timeout);
			if(result.getResultCode().equals("0")) {
				Map json=StringTools.stringToMap2(content);
				NBorderResult6 r=new NBorderResult6();
				//门锁返回结果的json
				String resultorder = json.get("resultmap").toString();
				r.setResultorder(resultorder);
				Map retjson = StringTools.stringToMap2(resultorder);
				//服务器下发的指令
				String order = json.get("order").toString();
				r.setOrder(order);
				String ids = json.get("ids").toString();
				r.setIds(ids);
				//指令结果
				String fail = retjson.get("messageId").toString().substring(0, 2);
				int failtype = Integer.valueOf(fail);
				if(failtype==1) {
					failtype = -1;
				}
				r.setFailtype(failtype);
				String[] empids = ids.split(",");
				List<String> c_ids=new ArrayList<String>();
				List<String> f_ids=new ArrayList<String>();
				List<String> p_ids=new ArrayList<String>();
				for(int j=0;j<empids.length;j++) {
					String id = empids[j];
					if(id.contains("c") && !c_ids.contains(id)) {
						c_ids.add(id.substring(1));
					}else if (id.contains("f") && !f_ids.contains(id)) {
						f_ids.add(id.substring(1));
					}else if (id.contains("p") && !p_ids.contains(id)) {
						p_ids.add(id.substring(1));
					}
				}
				r.setC_ids(c_ids);
				r.setF_ids(f_ids);
				r.setP_ids(p_ids);
				r.setResultstatus(1);
				result.setResultstatus(1);
				result.setResult(r);
			}
			return result;
		}

		@Override
		public ReceiveResult getNBorderResult7(String content, String sysdate, String verify) {
			// TODO Auto-generated method stub
			ReceiveResult result =Verify.verify(content, sysdate, verify, secret, timeout);
			if(result.getResultCode().equals("0")) {
				Map json=StringTools.stringToMap2(content);
				NBorderResult7 r=new NBorderResult7();
				//门锁返回结果的json
				String resultorder = json.get("resultmap").toString();
				r.setResultorder(resultorder);
				Map retjson = StringTools.stringToMap2(resultorder);
				//服务器下发的指令
				String order = json.get("order").toString();
				r.setOrder(order);
				String rfid = json.get("id").toString();
				r.setRfid(rfid);
				//指令结果
				String fail = retjson.get("messageId").toString().substring(0, 2);
				int failtype = Integer.valueOf(fail);
				if(failtype==1) {
					failtype = -1;
				}
				r.setFailtype(failtype);
				r.setResultstatus(1);
				result.setResultstatus(1);
				result.setResult(r);
			}
			return result;
		}

		@Override
		public ReceiveResult getNBrecordsResult(String content, String sysdate, String verify) {
			// TODO Auto-generated method stub
			ReceiveResult result =Verify.verify(content, sysdate, verify, secret, timeout);
			if(result.getResultCode().equals("0")) {
				String successval = content;
				String[] p = successval.split("-");
				String roomid = p[1];
				String records = p[0];
				NBrecordsResult r=new NBrecordsResult();
				r.setRoomid(roomid);
				r.setRecords(records);
				List<NBrecords> list=new ArrayList<NBrecords>();
				//保存读取到的记录
				List<Map> unlockings = StringTools.getUnlockinglist2(records);
				for(int h=0;h<unlockings.size();h++){
					    NBrecords rds=new NBrecords();
						Map map = unlockings.get(h);
						rds.setPackageNo(map.get("packageNo").toString());
						rds.setTime(map.get("time").toString());
						rds.setCardcode(map.get("cardcode").toString());
						rds.setType(map.get("type").toString());
						rds.setCardcode2(map.get("cardcode2").toString());
						rds.setPassword(map.get("password").toString());
						list.add(rds);
				}
				r.setNbrecords(list);
				r.setResultstatus(1);
				result.setResultstatus(1);
				result.setResult(r);
			}
			return result;
		}

		@Override
		public SlRoomParamas getSlRoomParamas(String content) {
			// TODO Auto-generated method stub
			SlRoomParamas sr=new SlRoomParamas();
			Map json=StringTools.stringToMap2(content);
			 String battery = json.get("batteryLevel").toString();
			 sr.setRoomcharge(Integer.valueOf(battery,16));
			 //信号强度
			 String signalStrength = json.get("signalStrength").toString();
			 int st = Integer.valueOf(signalStrength,16)-Integer.valueOf("ffff",16)-1;
			 //信号等级
			 String signalECL = json.get("signalECL").toString();
			 int rcl = Integer.valueOf(signalECL,16);
			 sr.setRoomecl(rcl+"");
			 //信噪比
			 String signalSNR = json.get("signalSNR").toString();
			 int snr = Integer.valueOf(signalSNR,16);
			 if(snr>30) {
				 snr = snr - Integer.valueOf("ffff",16)-1;
			 }
			 sr.setRoomsnr(snr+"");
			 //版本号
			 String softwareVer = json.get("softwareVer").toString();
			 sr.setLockver(softwareVer);
			 //生命周期
			 String lifeState = json.get("lifeState").toString();
			 sr.setLocklca(Integer.valueOf(lifeState));
			 //总复位次数
			 String resetCnt = json.get("resetCnt").toString();
			 sr.setRoomreset(Integer.valueOf(resetCnt,16));
			 //功能配置
			 String doorConfigInfo =StringTools.hexToBinary(json.get("doorConfigInfo").toString());
			 String isfinger = doorConfigInfo.substring(0, 1);
			 String isbluetooth = doorConfigInfo.substring(1, 2);
			 String isscanner = doorConfigInfo.substring(2, 3);
			 String islockswith = doorConfigInfo.substring(4, 5);
			 String islatchswith = doorConfigInfo.substring(5, 6);
			 String iskeyswith = doorConfigInfo.substring(6, 7);
			 String iscontactswith = doorConfigInfo.substring(7, 8);
			 LinkedHashMap config=new LinkedHashMap();
			 config.put("isfinger", isfinger.equals("0")?"无":"有");
			 config.put("isbluetooth", isbluetooth.equals("0")?"无":"有");
			 config.put("isscanner", isscanner.equals("0")?"无":"有");
			 config.put("islockswith", islockswith.equals("0")?"无":"有");
			 config.put("islatchswith", islatchswith.equals("0")?"无":"有");
			 config.put("iskeyswith", iskeyswith.equals("0")?"无":"有");
			 config.put("iscontactswith", iscontactswith.equals("0")?"无":"有");
			 config.put("signalStrength", signalStrength);
			 sr.setRoomconfig(StringTools.mapToString(config));
			 
			 //门锁反锁及开关门状态
			 String doorWorkSta = StringTools.hexToBinary(json.get("doorWorkSta").toString());
			 sr.setRoomstatus2(Integer.valueOf(doorWorkSta.substring(4, 5)));
			 sr.setRoomstatus(Integer.valueOf(doorWorkSta.substring(7, 8)));
			 
			 //工作模式
			 String doorWorkMode = StringTools.hexToBinary(json.get("doorWorkMode").toString());
			 //sr.setForcelock(Integer.valueOf(doorWorkMode.substring(5, 6)));
			 //sr.setNetworkmode(Integer.valueOf(doorWorkMode.substring(6, 7))+1);
			 //sr.setWorkmode(Integer.valueOf(doorWorkMode.substring(7, 8))+1);
			 
			 //记录条数
			 String numberOfRecords = json.get("numberOfRecords").toString();
			 sr.setRecordcount(Integer.valueOf(numberOfRecords,16));
			return sr;
		}

		@Override
		public SlRoomParamas getSlRoomParamasYd(String content) {
			// TODO Auto-generated method stub
			 SlRoomParamas sr=new SlRoomParamas();
			 LinkedHashMap config = new LinkedHashMap();
			 String battery = content.substring(46,48);
			 sr.setRoomcharge(Integer.valueOf(battery,16));
			 //信号强度
			 String signalStrength = content.substring(48, 52);
			 int st = Integer.valueOf(signalStrength,16)-Integer.valueOf("ffff",16)-1;
			 //信号等级
			 String signalECL = content.substring(52, 54);
			 int rcl = Integer.valueOf(signalECL,16);
			 sr.setRoomecl(rcl+"");
			 //信噪比
			 String signalSNR = content.substring(66,70);
			 int snr = Integer.valueOf(signalSNR,16);
			 if(snr>30) {
				 snr = snr - Integer.valueOf("ffff",16)-1;
			 }
			 sr.setRoomsnr(snr+"");
			 //版本号
			 String softwareVer = content.substring(92,102);
			 sr.setLockver(softwareVer);
			 //生命周期
			 String lifeState = content.substring(102,104);
			 sr.setLocklca(Integer.valueOf(lifeState));
			 //总复位次数
			 String resetCnt = content.substring(104,108);
			 sr.setRoomreset(Integer.valueOf(resetCnt,16));
			 //功能配置
			 String doorConfigInfo =StringTools.hexToBinary(content.substring(108,110));
			 String isfinger = doorConfigInfo.substring(0, 1);
			 String isbluetooth = doorConfigInfo.substring(1, 2);
			 String isscanner = doorConfigInfo.substring(2, 3);
			 String islockswith = doorConfigInfo.substring(4, 5);
			 String islatchswith = doorConfigInfo.substring(5, 6);
			 String iskeyswith = doorConfigInfo.substring(6, 7);
			 String iscontactswith = doorConfigInfo.substring(7, 8);
			 config.put("isfinger", isfinger.equals("0")?"无":"有");
			 config.put("isbluetooth", isbluetooth.equals("0")?"无":"有");
			 config.put("isscanner", isscanner.equals("0")?"无":"有");
			 config.put("islockswith", islockswith.equals("0")?"无":"有");
			 config.put("islatchswith", islatchswith.equals("0")?"无":"有");
			 config.put("iskeyswith", iskeyswith.equals("0")?"无":"有");
			 config.put("iscontactswith", iscontactswith.equals("0")?"无":"有");
			 config.put("signalStrength", signalStrength);
			 sr.setRoomconfig(config.toString());
			 
			 //门锁反锁及开关门状态
			 String doorWorkSta = StringTools.hexToBinary(content.substring(112,114));
			 sr.setRoomstatus2(Integer.valueOf(doorWorkSta.substring(4, 5)));
			 sr.setRoomstatus(Integer.valueOf(doorWorkSta.substring(7, 8)));
			 
			 //工作模式
			 String doorWorkMode = StringTools.hexToBinary(content.substring(114,116));
			 //sr.setForcelock(Integer.valueOf(doorWorkMode.substring(5, 6)));
			 //sr.setNetworkmode(Integer.valueOf(doorWorkMode.substring(6, 7))+1);
			 //sr.setWorkmode(Integer.valueOf(doorWorkMode.substring(7, 8))+1);
			 
			 //记录条数
			 String numberOfRecords = content.substring(116,120);
			 sr.setRecordcount(Integer.valueOf(numberOfRecords,16));
			 return sr;
		 
		}

}
