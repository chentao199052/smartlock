package com.qingyi.receive.info.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qingyi.model.OrderResult;
import com.qingyi.model.ClearsGatewaytatusResult;
import com.qingyi.model.DelRoomCardResult;
import com.qingyi.model.DelRoomFingerResult;
import com.qingyi.model.DelUnlockpswResult;
import com.qingyi.model.FingerMachineStateResult;
import com.qingyi.model.FingerResult;
import com.qingyi.model.FingerfailResult;
import com.qingyi.model.FingerfinishResult;
import com.qingyi.model.FingersuccessResult;
import com.qingyi.model.ForcelockResult;
import com.qingyi.model.GatewayInitializeResult;
import com.qingyi.model.GatewayRecord;
import com.qingyi.model.GatewaystatusResult;
import com.qingyi.model.HeartRecord;
import com.qingyi.model.HeartRecordResult;
import com.qingyi.model.LockInitializeResult;
import com.qingyi.model.LockRecordResult;
import com.qingyi.model.LockResetResult;
import com.qingyi.model.LockStatusResult;
import com.qingyi.model.OpenResult;
import com.qingyi.model.ReadGatewayRecordResult;
import com.qingyi.model.ReadLockRecord;
import com.qingyi.model.ReceiveResult;
import com.qingyi.model.RoomParamas;
import com.qingyi.model.SaveFingerReagyResult;
import com.qingyi.model.SaveUnlockPswResult;
import com.qingyi.model.SyncCPOrderResult;
import com.qingyi.model.SyncFOrderResult;
import com.qingyi.model.UpdateGatewayRoomsResult;
import com.qingyi.model.UpdateGatewaypowResult;
import com.qingyi.model.UpdateRoomNetmodeResult;
import com.qingyi.model.UpdateRoomWorkmodeResult;
import com.qingyi.model.UpdateRoompowResult;
import com.qingyi.receive.info.ReceiveOrderInfo;
import com.qingyi.util.Constant;
import com.qingyi.util.StringTools;
import com.qingyi.util.Verify;
import net.sf.json.JSONObject;

public class ReceiveOrderImpl implements ReceiveOrderInfo {

	private String timeout;

	private String secret;

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	private static SimpleDateFormat sdf1 = new SimpleDateFormat("yyMMddHHmmss");
	private static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public ReceiveOrderImpl() {
		super();
		secret = Constant.SECRET;
		timeout = Constant.TIMEOUT;
	}

	public ReceiveOrderImpl(String secret, String timeout) {
		super();
		this.timeout = timeout;
		this.secret = secret;
	}

	@Override
	public ReceiveResult<LockStatusResult> getLockStatusResult(String content, String sysdate, String verify) {
		// TODO Auto-generated method stub
		ReceiveResult<LockStatusResult> result = Verify.verify(content, sysdate, verify, secret, timeout);
		if (result.getResultCode().equals("0")) {
			try {
				Map json = StringTools.stringToMap2(content);
				String itid = json.get("itid").toString();
				LockStatusResult r = new LockStatusResult();
				r.setOrderid(itid);
				r.setResultstatus(Integer.parseInt(json.get("status").toString()));
				if (json.get("status").toString().equals("1")) {
					String resultorder = json.get("result").toString();
					// 生命周期
					String lca = resultorder.substring(30, 31);
					// 开关门状态
					String status = resultorder.substring(31, 32);
					String bet = resultorder.substring(32, 34);
					// 门锁功率等级默认为最大功率A3
					String powerlev = resultorder.substring(46, 48);
					if (powerlev.toUpperCase().equals("A0")) {
						powerlev = "A0";
					} else if (powerlev.toUpperCase().equals("A1")) {
						powerlev = "A1";
					} else if (powerlev.toUpperCase().equals("A2")) {
						powerlev = "A2";
					} else {
						powerlev = "A3";
					}
					String recordnum = resultorder.substring(50, 54);
					String ver = resultorder.substring(54, 62);
					String channelid = resultorder.substring(62, 66);
					String channel = resultorder.substring(66, 68);
					String networkmode = resultorder.substring(78, 79);
					String workmode = resultorder.substring(79, 80);
					String locktype = resultorder.substring(81, 82);
					String figernum = resultorder.substring(82, 84);
					int bettery = Integer.valueOf(bet, 16);
					if (lca.equals("1")) {
						r.setLocklca(-1);
					} else if (lca.equals("2")) {
						r.setLocklca(1);
					} else if (lca.equals("4")) {
						r.setLocklca(2);
					}
					String[] type = StringTools.getlockstatus(status);
					// 更新状态
					r.setLockstatus(Integer.valueOf(type[0]));
					r.setLockstatus2(Integer.valueOf(type[1]));
					r.setChannelid(channelid);
					r.setChannel(Integer.valueOf(channel, 16) + "");
					r.setPowerlev(powerlev);
					r.setNetworkmode(Integer.valueOf(networkmode));
					r.setWorkmode(Integer.valueOf(workmode));
					r.setLocktype(Integer.valueOf(locktype));
					r.setFigernum(Integer.valueOf(figernum, 16));
					r.setLockver(ver);
					r.setLockcharge(bettery);
					if (recordnum.equals("0000")) {
						r.setRecordnum(0);
					} else {
						r.setRecordnum(Integer.valueOf(recordnum, 16));
					}
				}
				String order = json.get("order").toString();
				String no = json.get("no").toString();
				String space = json.get("space").toString();
				String ret = json.get("result").toString();
				String osdate = json.get("osdate").toString();
				r.setOsdate(sdf2.format(sdf.parse(osdate)));
				r.setOrder(order);
				if (null != no && no.matches("^[0-9]{1,}$")) {
					r.setNo(Integer.parseInt(no));
				}
				r.setResult(ret);
				r.setSpace(space);
				int failtype = StringTools.getFailtype(ret);
				r.setFiletype(failtype);
				result.setResult(r);
				result.setResultstatus(1);
			} catch (Exception e) {
				e.printStackTrace();
				result.setResultCode("100005");
				result.setResultMsg("解析失败");
			}
		} else {
			result.setResultstatus(0);
		}
		return result;
	}

	@Override
	public ReceiveResult<LockResetResult> getLockResetResult(String content, String sysdate, String verify) {
		// TODO Auto-generated method stub
		ReceiveResult<LockResetResult> result = Verify.verify(content, sysdate, verify, secret, timeout);
		if (result.getResultCode().equals("0")) {
			Map json = StringTools.stringToMap2(content);
			LockResetResult r = new LockResetResult();
			String itid = json.get("itid").toString();
			String locktype = json.get("locktype").toString();
			r.setLocktype(locktype);
			r.setResultstatus(Integer.parseInt(json.get("status").toString()));
			result.setResultstatus(Integer.parseInt(json.get("status").toString()));
			r.setOrderid(itid);
			if ("1".equals(locktype)) {
				String order = json.get("order") == null ? "" : json.get("order").toString();
				String no = json.get("no") == null ? "" : json.get("no").toString();
				String space = json.get("space") == null ? "" : json.get("space").toString();
				String ret = json.get("result") == null ? "" : json.get("result").toString();
				String osdate = json.get("osdate") == null ? "" : json.get("osdate").toString();
				try {
					r.setOsdate(sdf2.format(sdf.parse(osdate)));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				r.setOrder(order);
				if (null != no && no.matches("^[0-9]{1,}$")) {
					r.setNo(Integer.parseInt(no));
				}
				r.setResult(ret);
				r.setSpace(space);
				int failtype = StringTools.getFailtype(ret);
				r.setFiletype(failtype);
			} else {
				String osdate = json.get("osdate") == null ? "" : json.get("osdate").toString();
				String no = json.get("no") == null ? "" : json.get("no").toString();
				try {
					r.setOsdate(sdf2.format(sdf.parse(osdate)));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (null != no && no.matches("^[0-9]{1,}$")) {
					r.setNo(Integer.parseInt(no));
				}
			}
			result.setResult(r);
		}
		return result;
	}

	@Override
	public ReceiveResult<OpenResult> getLockRemoteOpenResult(String content, String sysdate, String verify) {
		// TODO Auto-generated method stub
		ReceiveResult<OpenResult> result = Verify.verify(content, sysdate, verify, secret, timeout);
		if (result.getResultCode().equals("0")) {
			try {
				Map json = StringTools.stringToMap2(content);
				OpenResult r = new OpenResult();
				String itid = json.get("itid").toString();
				String locktype = json.get("locktype").toString();
				r.setLocktype(locktype);
				r.setResultstatus(Integer.parseInt(json.get("status").toString()));
				result.setResultstatus(Integer.parseInt(json.get("status").toString()));
				r.setOrderid(itid);
				String ret = json.get("result") == null ? "" : json.get("result").toString();
				if ("1".equals(locktype)) {
					String order = json.get("order").toString();
					r.setOrder(order);
					String space = json.get("space") == null ? "" : json.get("space").toString();
					r.setSpace(space);
					int failtype = StringTools.getFailtype(ret);
					r.setFiletype(failtype);
				}
				String no = json.get("no").toString();
				String osdate = json.get("osdate") == null ? "" : json.get("osdate").toString();
				String format = sdf2.format(sdf.parse(osdate));
				r.setOsdate(sdf2.format(sdf.parse(osdate)));
				if (null != no && no.matches("^[0-9]{1,}$")) {
					r.setNo(Integer.parseInt(no));
				}
				r.setResult(ret);
				result.setResult(r);
			} catch (Exception e) {
				e.printStackTrace();
				result.setResultCode("100005");
				result.setResultMsg("解析失败");
			}
		}
		return result;
	}

	@Override
	public ReceiveResult<LockRecordResult> getReadLockRecordResult(String content, String sysdate, String verify) {
		// TODO Auto-generated method stub
		ReceiveResult<LockRecordResult> result = Verify.verify(content, sysdate, verify, secret, timeout);
		if (result.getResultCode().equals("0")) {
			Map json = StringTools.stringToMap2(content);
			LockRecordResult recordresult = new LockRecordResult();
			recordresult.setResultstatus(Integer.parseInt(json.get("status").toString()));
			result.setResultstatus(Integer.parseInt(json.get("status").toString()));
			String locktype = json.get("locktype").toString();
			recordresult.setLocktype(locktype);
			if ("1".equals(locktype)) {
				String itid = json.get("itid").toString();
				recordresult.setOrderid(itid);
				String ret = json.get("result").toString();
				if (json.get("status").equals("1")) {
					String[] res = ret.split("-");
					recordresult.setRecordcount(StringTools.getRecordcount(ret));
					if (res != null && res.length > 0) {
						List<ReadLockRecord> lockRecords = new ArrayList<ReadLockRecord>();
						for (int x = 0; x < res.length; x++) {
							List<Map> unlockings = StringTools.getUnlockinglist(res[x]);
							for (int h = 0; h < unlockings.size(); h++) {
								Map map = unlockings.get(h);
								String cardcode = map.get("cardcode") == null ? "" : map.get("cardcode").toString();
								String packageNo = map.get("packageNo") == null ? "" : map.get("packageNo").toString();
								String time = map.get("time") == null ? "" : map.get("time").toString();
								String type = map.get("type") == null ? "" : map.get("type").toString();
								String cardcode2 = map.get("cardcode2") == null ? "" : map.get("cardcode2").toString();
								String password = map.get("password") == null ? "" : map.get("password").toString();
								ReadLockRecord record = new ReadLockRecord(cardcode, packageNo, time, type, cardcode2,
										password, h + 1);
								lockRecords.add(record);
							}
						}
						recordresult.setLockRecords(lockRecords);
					}
				}
				String no = "0";
				try {
					no = json.get("no").toString();
				} catch (Exception e) {
					no = "3";
				}
				recordresult.setNo(no);
				String order = json.get("order") == null ? "" : json.get("order").toString();
				String space = json.get("space") == null ? "" : json.get("space").toString();
				String osdate = json.get("osdate") == null ? "" : json.get("osdate").toString();
				try {
					recordresult.setOsdate(sdf2.format(sdf.parse(osdate)));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				recordresult.setOrder(order);
				recordresult.setResult(ret);
				recordresult.setSpace(space);
				int failtype = StringTools.getFailtype(ret);
				recordresult.setFiletype(failtype);
				result.setResult(recordresult);
			} else {
				if (json.get("status").equals("1")) {
					String records = json.get("records").toString();
					recordresult.setRoomcode2(json.get("roomcode2").toString());
					// String records = p[0];
					// 保存读取到的记录
					List<JSONObject> unlockings = StringTools.getUnlockinglist3(records);
					List<ReadLockRecord> lockRecords = new ArrayList<ReadLockRecord>();
					for (int h = 0; h < unlockings.size(); h++) {
						String cardcode = "";
						String packageNo = "";
						String time = "";
						String type = "";
						String cardcode2 = "";
						String password = "";
						JSONObject jsonObject = unlockings.get(h);
						if (jsonObject.has("packageNo")) {
							packageNo = jsonObject.getString("packageNo");
						}
						if (jsonObject.has("time")) {
							time = jsonObject.getString("time");
							String lrdate = jsonObject.getString("time").substring(0, 10) + " 00:00:00";
						}
						if (jsonObject.has("cardcode")) {
							cardcode = jsonObject.getString("cardcode");
						}
						if (jsonObject.has("type")) {
							type = jsonObject.getString("type");
						}
						if (jsonObject.has("cardcode2")) {
							cardcode2 = jsonObject.getString("cardcode2");
						}
						if (jsonObject.has("password")) {
							password = jsonObject.getString("password");
						}
						ReadLockRecord record = new ReadLockRecord(cardcode, packageNo, time, type, cardcode2, password,
								h + 1);
						lockRecords.add(record);
					}
					recordresult.setLockRecords(lockRecords);
					result.setResult(recordresult);
				}
			}
		}
		return result;
	}

	@Override
	public ReceiveResult<ForcelockResult> getUpdateRoomForcelockResult(String content, String sysdate, String verify) {
		// TODO Auto-generated method stub
		ReceiveResult<ForcelockResult> result = Verify.verify(content, sysdate, verify, secret, timeout);
		if (result.getResultCode().equals("0")) {
			try {
				Map json = StringTools.stringToMap2(content);
				ForcelockResult r = new ForcelockResult();
				r.setResultstatus(Integer.parseInt(json.get("status").toString()));
				String itid = json.get("itid").toString();
				r.setOrderid(itid);
				String locktype = json.get("locktype").toString();
				r.setLocktype(locktype);
				String type = json.get("type") == null ? "" : json.get("type").toString();
				r.setType(type);
				String ret = json.get("result") == null ? "" : json.get("result").toString();
				r.setResult(ret);
				if ("1".equals(locktype)) {
					String order = json.get("order") == null ? "" : json.get("order").toString();
					r.setOrder(order);
					String space = json.get("space") == null ? "" : json.get("space").toString();
					r.setSpace(space);
					int failtype = StringTools.getFailtype(ret);
					r.setFiletype(failtype);
				}

				String no = json.get("no") == null ? "" : json.get("no").toString();
				if (null != no && no.matches("^[0-9]{1,}$")) {
					r.setNo(Integer.parseInt(no));
				}
				String osdate = json.get("osdate").toString();
				r.setOsdate(sdf2.format(sdf.parse(osdate)));
				result.setResult(r);
			} catch (Exception e) {
				e.printStackTrace();
				result = new ReceiveResult<ForcelockResult>("10001", "解析错误", null, null);
			}
		}
		return result;
	}

	@Override
	public ReceiveResult<UpdateRoompowResult> getUpdateRoompowResult(String content, String sysdate, String verify) {
		// TODO Auto-generated method stub
		ReceiveResult<UpdateRoompowResult> result = Verify.verify(content, sysdate, verify, secret, timeout);
		if (result.getResultCode().equals("0")) {
			Map json = StringTools.stringToMap2(content);
			String itid = json.get("itid").toString();
			UpdateRoompowResult r = new UpdateRoompowResult();
			r.setOrderid(itid);
			r.setResultstatus(Integer.parseInt(json.get("status").toString()));
			result.setResultstatus(Integer.parseInt(json.get("status").toString()));
			if (json.get("status").toString().equals("1")) {
				String resultorder = json.get("result").toString();
				// 生命周期
				String lca = resultorder.substring(30, 31);

				// 开关门状态
				String status = resultorder.substring(31, 32);
				String bet = resultorder.substring(32, 34);
				// 门锁功率等级默认为最大功率A3
				String powerlev = resultorder.substring(46, 48);
				if (powerlev.toUpperCase().equals("A0")) {
					powerlev = "A0";
				} else if (powerlev.toUpperCase().equals("A1")) {
					powerlev = "A1";
				} else if (powerlev.toUpperCase().equals("A2")) {
					powerlev = "A2";
				} else {
					powerlev = "A3";
				}
				String recordnum = resultorder.substring(50, 54);
				String ver = resultorder.substring(54, 62);
				String channelid = resultorder.substring(62, 66);
				String channel = resultorder.substring(66, 68);
				String networkmode = resultorder.substring(78, 79);
				String workmode = resultorder.substring(79, 80);
				String locktype = resultorder.substring(81, 82);
				String figernum = resultorder.substring(82, 84);

				int bettery = Integer.valueOf(bet, 16);
				if (lca.equals("1")) {
					r.setLocklca(-1);
				} else if (lca.equals("2")) {
					r.setLocklca(1);
				} else if (lca.equals("4")) {
					r.setLocklca(2);
				}

				String[] type = StringTools.getlockstatus(status);
				// 更新状态
				r.setLockstatus(Integer.valueOf(type[0]));
				r.setLockstatus2(Integer.valueOf(type[1]));
				r.setChannelid(channelid);
				r.setChannel(Integer.valueOf(channel, 16) + "");
				r.setPowerlev(powerlev);
				r.setNetworkmode(Integer.valueOf(networkmode));
				r.setWorkmode(Integer.valueOf(workmode));
				r.setLocktype(Integer.valueOf(locktype));
				r.setFigernum(Integer.valueOf(figernum, 16));
				r.setLockver(ver);
				r.setLockcharge(bettery);
				if (recordnum.equals("0000")) {
					r.setRecordnum(0);
				} else {
					r.setRecordnum(Integer.valueOf(recordnum, 16));
				}
			}
			String order = json.get("order") == null ? "" : json.get("order").toString();
			String no = json.get("no") == null ? "" : json.get("no").toString();
			String space = json.get("space") == null ? "" : json.get("space").toString();
			String ret = json.get("result") == null ? "" : json.get("result").toString();
			String osdate = json.get("osdate") == null ? "" : json.get("osdate").toString();
			try {
				r.setOsdate(sdf2.format(sdf.parse(osdate)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			r.setOrder(order);
			if (null != no && no.matches("^[0-9]{1,}$")) {
				r.setNo(Integer.parseInt(no));
			}
			r.setResult(ret);
			r.setSpace(space);
			int failtype = StringTools.getFailtype(ret);
			r.setFiletype(failtype);
			result.setResult(r);
		}
		return result;
	}

	@Override
	public ReceiveResult<UpdateRoomWorkmodeResult> getUpdateRoomWorkmodeResult(String content, String sysdate,
			String verify) {
		// TODO Auto-generated method stub
		ReceiveResult<UpdateRoomWorkmodeResult> result = Verify.verify(content, sysdate, verify, secret, timeout);
		if (result.getResultCode().equals("0")) {
			Map json = StringTools.stringToMap2(content);
			String itid = json.get("itid").toString();
			UpdateRoomWorkmodeResult r = new UpdateRoomWorkmodeResult();
			r.setOrderid(itid);
			r.setResultstatus(Integer.parseInt(json.get("status").toString()));
			result.setResultstatus(Integer.parseInt(json.get("status").toString()));
			String locktype = json.get("locktype").toString();
			if ("1".equals(locktype)) {
				if (json.get("status").toString().equals("1")) {
					String resultorder = json.get("result").toString();
					// 生命周期
					String lca = resultorder.substring(30, 31);

					// 开关门状态
					String status = resultorder.substring(31, 32);
					String bet = resultorder.substring(32, 34);
					// 门锁功率等级默认为最大功率A3
					String powerlev = resultorder.substring(46, 48);
					if (powerlev.toUpperCase().equals("A0")) {
						powerlev = "A0";
					} else if (powerlev.toUpperCase().equals("A1")) {
						powerlev = "A1";
					} else if (powerlev.toUpperCase().equals("A2")) {
						powerlev = "A2";
					} else {
						powerlev = "A3";
					}
					String recordnum = resultorder.substring(50, 54);
					String ver = resultorder.substring(54, 62);
					String channelid = resultorder.substring(62, 66);
					String channel = resultorder.substring(66, 68);
					String networkmode = resultorder.substring(78, 79);
					String workmode = resultorder.substring(79, 80);
					String figernum = resultorder.substring(82, 84);

					int bettery = Integer.valueOf(bet, 16);
					if (lca.equals("1")) {
						r.setLocklca(-1);
					} else if (lca.equals("2")) {
						r.setLocklca(1);
					} else if (lca.equals("4")) {
						r.setLocklca(2);
					}

					String[] type = StringTools.getlockstatus(status);
					// 更新状态
					r.setLockstatus(Integer.valueOf(type[0]));
					r.setLockstatus2(Integer.valueOf(type[1]));
					r.setChannelid(channelid);
					r.setChannel(Integer.valueOf(channel, 16) + "");
					r.setPowerlev(powerlev);
					r.setNetworkmode(Integer.valueOf(networkmode));
					r.setWorkmode(Integer.valueOf(workmode));
					r.setLocktype(Integer.valueOf(locktype));
					r.setFigernum(Integer.valueOf(figernum, 16));
					r.setLockver(ver);
					r.setLockcharge(bettery);
					if (recordnum.equals("0000")) {
						r.setRecordnum(0);
					} else {
						r.setRecordnum(Integer.valueOf(recordnum, 16));
					}
				}
				String order = json.get("order") == null ? "" : json.get("order").toString();
				String no = json.get("no") == null ? "" : json.get("no").toString();
				String space = json.get("space") == null ? "" : json.get("space").toString();
				String ret = json.get("result") == null ? "" : json.get("result").toString();
				String osdate = json.get("osdate") == null ? "" : json.get("osdate").toString();
				try {
					r.setOsdate(sdf2.format(sdf.parse(osdate)));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				r.setOrder(order);
				if (null != no && no.matches("^[0-9]{1,}$")) {
					r.setNo(Integer.parseInt(no));
				}
				r.setResult(ret);
				r.setSpace(space);
				int failtype = StringTools.getFailtype(ret);
				r.setFiletype(failtype);
				result.setResult(r);
			} else {
				String type = json.get("type").toString();
				r.setType(type);
				String osdate = json.get("osdate") == null ? "" : json.get("osdate").toString();
				r.setOsdate(osdate);
				String ret = json.get("result") == null ? "" : json.get("result").toString();
				r.setResult(ret);
				String no = json.get("no") == null ? "" : json.get("no").toString();
				if (null != no && no.matches("^[0-9]{1,}$")) {
					r.setNo(Integer.parseInt(no));
				}
			}

		}
		return result;
	}

	@Override
	public ReceiveResult<UpdateRoomNetmodeResult> getUpdateRoomNetmodeResult(String content, String sysdate,
			String verify) {
		// TODO Auto-generated method stub
		ReceiveResult<UpdateRoomNetmodeResult> result = Verify.verify(content, sysdate, verify, secret, timeout);
		if (result.getResultCode().equals("0")) {
			Map json = StringTools.stringToMap2(content);
			String itid = json.get("itid").toString();
			UpdateRoomNetmodeResult r = new UpdateRoomNetmodeResult();
			r.setOrderid(itid);
			r.setResultstatus(Integer.parseInt(json.get("status").toString()));
			result.setResultstatus(Integer.parseInt(json.get("status").toString()));
			String locktype = json.get("locktype").toString();
			if ("1".equals(locktype)) {
				if (json.get("status").toString().equals("1")) {
					String resultorder = json.get("result").toString();
					// 生命周期
					String lca = resultorder.substring(30, 31);

					// 开关门状态
					String status = resultorder.substring(31, 32);
					String bet = resultorder.substring(32, 34);
					// 门锁功率等级默认为最大功率A3
					String powerlev = resultorder.substring(46, 48);
					if (powerlev.toUpperCase().equals("A0")) {
						powerlev = "A0";
					} else if (powerlev.toUpperCase().equals("A1")) {
						powerlev = "A1";
					} else if (powerlev.toUpperCase().equals("A2")) {
						powerlev = "A2";
					} else {
						powerlev = "A3";
					}
					String recordnum = resultorder.substring(50, 54);
					String ver = resultorder.substring(54, 62);
					String channelid = resultorder.substring(62, 66);
					String channel = resultorder.substring(66, 68);
					String networkmode = resultorder.substring(78, 79);
					String workmode = resultorder.substring(79, 80);
					locktype = resultorder.substring(81, 82);
					String figernum = resultorder.substring(82, 84);

					int bettery = Integer.valueOf(bet, 16);
					if (lca.equals("1")) {
						r.setLocklca(-1);
					} else if (lca.equals("2")) {
						r.setLocklca(1);
					} else if (lca.equals("4")) {
						r.setLocklca(2);
					}

					String[] type = StringTools.getlockstatus(status);
					// 更新状态
					r.setLockstatus(Integer.valueOf(type[0]));
					r.setLockstatus2(Integer.valueOf(type[1]));
					r.setChannelid(channelid);
					r.setChannel(Integer.valueOf(channel, 16) + "");
					r.setPowerlev(powerlev);
					r.setNetworkmode(Integer.valueOf(networkmode));
					r.setWorkmode(Integer.valueOf(workmode));
					r.setLocktype(Integer.valueOf(locktype));
					r.setFigernum(Integer.valueOf(figernum, 16));
					r.setLockver(ver);
					r.setLockcharge(bettery);
					if (recordnum.equals("0000")) {
						r.setRecordnum(0);
					} else {
						r.setRecordnum(Integer.valueOf(recordnum, 16));
					}
				}
				String order = json.get("order") == null ? "" : json.get("order").toString();
				String no = json.get("no") == null ? "" : json.get("no").toString();
				String space = json.get("space") == null ? "" : json.get("space").toString();
				String ret = json.get("result") == null ? "" : json.get("result").toString();
				String osdate = json.get("osdate") == null ? "" : json.get("osdate").toString();
				try {
					r.setOsdate(sdf2.format(sdf.parse(osdate)));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				r.setOrder(order);
				if (null != no && no.matches("^[0-9]{1,}$")) {
					r.setNo(Integer.parseInt(no));
				}
				r.setResult(ret);
				r.setSpace(space);
				int failtype = StringTools.getFailtype(ret);
				r.setFiletype(failtype);
				result.setResult(r);
			} else {
				String type = json.get("type").toString();
				r.setType(type);
				String osdate = json.get("osdate") == null ? "" : json.get("osdate").toString();
				r.setOsdate(osdate);
				String ret = json.get("result") == null ? "" : json.get("result").toString();
				r.setResult(ret);
				String no = json.get("no") == null ? "" : json.get("no").toString();
				if (null != no && no.matches("^[0-9]{1,}$")) {
					r.setNo(Integer.parseInt(no));
				}
			}
		}
		return result;
	}

	@Override
	public ReceiveResult<SaveFingerReagyResult> getSaveFingerReagyResult(String content, String sysdate,
			String verify) {
		// TODO Auto-generated method stub
		ReceiveResult<SaveFingerReagyResult> result = Verify.verify(content, sysdate, verify, secret, timeout);
		if (result.getResultCode().equals("0")) {
			Map json = StringTools.stringToMap2(content);
			String itid = json.get("itid").toString();
			SaveFingerReagyResult r = new SaveFingerReagyResult();
			r.setOrderid(itid);
			r.setResultstatus(Integer.parseInt(json.get("status").toString()));
			result.setResultstatus(Integer.parseInt(json.get("status").toString()));
			String order = json.get("order") == null ? "" : json.get("order").toString();
			r.setOrder(order);
			String ret = json.get("result") == null ? "" : json.get("result").toString();
			int failtype = StringTools.getFailtype(ret);
			String osdate = json.get("osdate") == null ? "" : json.get("osdate").toString();
			try {
				r.setOsdate(sdf2.format(sdf.parse(osdate)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			r.setResult(ret);
			r.setFiletype(failtype);
			result.setResult(r);
		}
		return result;
	}

	@Override
	public ReceiveResult<GatewaystatusResult> getGatewaystatusResult(String content, String sysdate, String verify) {
		// TODO Auto-generated method stub
		ReceiveResult<GatewaystatusResult> result = Verify.verify(content, sysdate, verify, secret, timeout);
		if (result.getResultCode().equals("0")) {
			Map json = StringTools.stringToMap2(content);
			String itid = json.get("itid").toString();
			GatewaystatusResult r = new GatewaystatusResult();
			r.setOrderid(itid);
			r.setResultstatus(Integer.parseInt(json.get("status").toString()));
			result.setResultstatus(Integer.parseInt(json.get("status").toString()));
			if (json.get("status").toString().equals("1")) {
				String resultorder = json.get("result").toString();
				if (null != resultorder && resultorder.length() > 50) {
					String recordnum = resultorder.substring(30, 34);
					String version = resultorder.substring(34, 42);
					String beforever = version.substring(0, 4);
					// 网关功率等级
					String powerlev = resultorder.substring(48, 50);
					if (powerlev.toUpperCase().equals("A3")) {
						powerlev = "A3";
					} else if (powerlev.toUpperCase().equals("A1")) {
						powerlev = "A1";
					} else if (powerlev.toUpperCase().equals("A2")) {
						powerlev = "A2";
					} else {
						powerlev = "A0";
					}
					// 网关更新信道id-信道-功率
					String xindaoID = resultorder.substring(42, 46);
					String xindao = resultorder.substring(46, 48);
					xindao = Integer.valueOf(xindao, 16) + "";
					String information = xindaoID + "-" + xindao + "-" + powerlev;
					r.setInformation(information);
					// 门锁数量
					String locknum = "";
					String locks = "";
					String wid = null;
					if (Integer.valueOf(beforever) >= 100) {
						// 老版本(无唯一id)
						if (resultorder.substring(20, 24).equals("017a")
								|| resultorder.substring(20, 24).equals("017A")) {
							locknum = resultorder.substring(62, 64);
							locks = resultorder.substring(64, resultorder.length() - 4);
						} else {
							locknum = resultorder.substring(86, 88);
							locks = resultorder.substring(88, resultorder.length() - 4);
							wid = resultorder.substring(54, 64);
						}
					}

					if (recordnum.equals("0000")) {
						r.setRecordnum(0);
					} else {
						String n = Long.valueOf(recordnum, 16) + "";
						r.setRecordnum(Integer.parseInt(n));
					}
					if (locknum.equals("00")) {
						r.setLocknum(0);
						r.setLocks("");
					} else {
						String n = Long.valueOf(locknum, 16) + "";
						r.setLocknum(Integer.parseInt(n));
						r.setLocks(StringTools.getAlllocks(locks));
					}
					r.setVersion(version);
					r.setBeforever(beforever);
					r.setPowerlev(powerlev.toUpperCase());
					r.setXindaoID(xindaoID);
					r.setXindao(Integer.valueOf(xindao, 16));
					r.setWid(wid);
				}
			}
			String begin = json.get("begin") == null ? "" : json.get("begin").toString();
			String no = json.get("no") == null ? "" : json.get("no").toString();
			String space = json.get("space") == null ? "" : json.get("space").toString();
			String ret = json.get("result") == null ? "" : json.get("result").toString();
			String osdate = json.get("osdate") == null ? "" : json.get("osdate").toString();
			try {
				r.setOsdate(sdf2.format(sdf.parse(osdate)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			r.setBegin(begin);
			if (null != no && no.matches("^[0-9]{1,}$")) {
				r.setNo(Integer.parseInt(no));
			}
			r.setSpace(space);
			r.setResult(ret);
			int failtype = StringTools.getFailtype(ret);
			r.setFiletype(failtype);
			result.setResult(r);
		}
		return result;
	}

	@Override
	public ReceiveResult<UpdateGatewaypowResult> getUpdateGatewaypowResult(String content, String sysdate,
			String verify) {
		// TODO Auto-generated method stub
		ReceiveResult<UpdateGatewaypowResult> result = Verify.verify(content, sysdate, verify, secret, timeout);
		if (result.getResultCode().equals("0")) {
			Map json = StringTools.stringToMap2(content);
			String itid = json.get("itid").toString();
			UpdateGatewaypowResult r = new UpdateGatewaypowResult();
			r.setOrderid(itid);
			r.setResultstatus(Integer.parseInt(json.get("status").toString()));
			result.setResultstatus(Integer.parseInt(json.get("status").toString()));
			if (json.get("status").toString().equals("1")) {
				String resultorder = json.get("result").toString();
				if (null != resultorder && resultorder.length() > 50) {
					String recordnum = resultorder.substring(30, 34);
					String version = resultorder.substring(34, 42);
					String beforever = version.substring(0, 4);
					// 网关功率等级
					String powerlev = resultorder.substring(48, 50);
					if (powerlev.toUpperCase().equals("A3")) {
						powerlev = "A3";
					} else if (powerlev.toUpperCase().equals("A1")) {
						powerlev = "A1";
					} else if (powerlev.toUpperCase().equals("A2")) {
						powerlev = "A2";
					} else {
						powerlev = "A0";
					}
					// 网关更新信道id-信道-功率
					String xindaoID = resultorder.substring(42, 46);
					String xindao = resultorder.substring(46, 48);
					xindao = Integer.valueOf(xindao, 16) + "";
					String information = xindaoID + "-" + xindao + "-" + powerlev;

					// 门锁数量
					String locknum = "";
					String locks = "";
					String wid = null;
					if (Integer.valueOf(beforever) >= 100) {
						// 老版本(无唯一id)
						if (resultorder.substring(20, 24).equals("017a")
								|| resultorder.substring(20, 24).equals("017A")) {
							locknum = resultorder.substring(62, 64);
							locks = resultorder.substring(64, resultorder.length() - 4);
						} else {
							locknum = resultorder.substring(86, 88);
							locks = resultorder.substring(88, resultorder.length() - 4);
							wid = resultorder.substring(54, 64);
						}
					}

					if (recordnum.equals("0000")) {
						r.setRecordnum(0);
					} else {
						String n = Long.valueOf(recordnum, 16) + "";
						r.setRecordnum(Integer.parseInt(n));
					}
					if (locknum.equals("00")) {
						r.setLocknum(0);
						r.setLocks("");
					} else {
						String n = Long.valueOf(locknum, 16) + "";
						r.setLocknum(Integer.parseInt(n));
						r.setLocks(StringTools.getAlllocks(locks));
					}
					r.setVersion(version);
					r.setBeforever(beforever);
					r.setPowerlev(powerlev.toUpperCase());
					r.setXindaoID(xindaoID);
					r.setXindao(Integer.valueOf(xindao, 16));
					r.setWid(wid);
				}
			}
			String begin = json.get("begin") == null ? "" : json.get("begin").toString();
			String no = json.get("no") == null ? "" : json.get("no").toString();
			String space = json.get("space") == null ? "" : json.get("space").toString();
			String ret = json.get("result") == null ? "" : json.get("result").toString();
			String osdate = json.get("osdate") == null ? "" : json.get("osdate").toString();
			try {
				r.setOsdate(sdf2.format(sdf.parse(osdate)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			r.setBegin(begin);
			if (null != no && no.matches("^[0-9]{1,}$")) {
				r.setNo(Integer.parseInt(no));
			}
			r.setSpace(space);
			r.setResult(ret);
			int failtype = StringTools.getFailtype(ret);
			r.setFiletype(failtype);
			result.setResult(r);
		}
		return result;
	}

	@Override
	public ReceiveResult<ClearsGatewaytatusResult> getClearsGatewaytatusResult(String content, String sysdate,
			String verify) {
		// TODO Auto-generated method stub
		ReceiveResult<ClearsGatewaytatusResult> result = Verify.verify(content, sysdate, verify, secret, timeout);
		if (result.getResultCode().equals("0")) {
			Map json = StringTools.stringToMap2(content);
			String itid = json.get("itid").toString();
			ClearsGatewaytatusResult r = new ClearsGatewaytatusResult();
			r.setOrderid(itid);
			r.setResultstatus(Integer.parseInt(json.get("status").toString()));
			result.setResultstatus(Integer.parseInt(json.get("status").toString()));
			if (json.get("status").toString().equals("1")) {
				String resultorder = json.get("result").toString();
				if (null != resultorder && resultorder.length() > 50) {
					String recordnum = resultorder.substring(30, 34);
					String version = resultorder.substring(34, 42);
					String beforever = version.substring(0, 4);
					// 网关功率等级
					String powerlev = resultorder.substring(48, 50);
					if (powerlev.toUpperCase().equals("A3")) {
						powerlev = "A3";
					} else if (powerlev.toUpperCase().equals("A1")) {
						powerlev = "A1";
					} else if (powerlev.toUpperCase().equals("A2")) {
						powerlev = "A2";
					} else {
						powerlev = "A0";
					}
					// 网关更新信道id-信道-功率
					String xindaoID = resultorder.substring(42, 46);
					String xindao = resultorder.substring(46, 48);
					xindao = Integer.valueOf(xindao, 16) + "";
					String information = xindaoID + "-" + xindao + "-" + powerlev;

					// 门锁数量
					String locknum = "";
					String locks = "";
					String wid = null;
					if (Integer.valueOf(beforever) >= 100) {
						// 老版本(无唯一id)
						if (resultorder.substring(20, 24).equals("017a")
								|| resultorder.substring(20, 24).equals("017A")) {
							locknum = resultorder.substring(62, 64);
							locks = resultorder.substring(64, resultorder.length() - 4);
						} else {
							locknum = resultorder.substring(86, 88);
							locks = resultorder.substring(88, resultorder.length() - 4);
							wid = resultorder.substring(54, 64);
						}
					}

					if (recordnum.equals("0000")) {
						r.setRecordnum(0);
					} else {
						String n = Long.valueOf(recordnum, 16) + "";
						r.setRecordnum(Integer.parseInt(n));
					}
					if (locknum.equals("00")) {
						r.setLocknum(0);
						r.setLocks("");
					} else {
						String n = Long.valueOf(locknum, 16) + "";
						r.setLocknum(Integer.parseInt(n));
						r.setLocks(StringTools.getAlllocks(locks));
					}
					r.setVersion(version);
					r.setBeforever(beforever);
					r.setPowerlev(powerlev.toUpperCase());
					r.setXindaoID(xindaoID);
					r.setXindao(Integer.valueOf(xindao, 16));
					r.setWid(wid);
				}
			}
			String begin = json.get("begin") == null ? "" : json.get("begin").toString();
			String no = json.get("no") == null ? "" : json.get("no").toString();
			String space = json.get("space") == null ? "" : json.get("space").toString();
			String ret = json.get("result") == null ? "" : json.get("result").toString();
			String osdate = json.get("osdate") == null ? "" : json.get("osdate").toString();
			try {
				r.setOsdate(sdf2.format(sdf.parse(osdate)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			r.setBegin(begin);
			if (null != no && no.matches("^[0-9]{1,}$")) {
				r.setNo(Integer.parseInt(no));
			}
			r.setSpace(space);
			r.setResult(ret);
			int failtype = StringTools.getFailtype(ret);
			r.setFiletype(failtype);
			result.setResult(r);
		}
		return result;
	}

	@Override
	public ReceiveResult<UpdateGatewayRoomsResult> getUpdateGatewayRoomsResult(String content, String sysdate,
			String verify) {
		// TODO Auto-generated method stub
		ReceiveResult<UpdateGatewayRoomsResult> result = Verify.verify(content, sysdate, verify, secret, timeout);
		if (result.getResultCode().equals("0")) {
			Map json = StringTools.stringToMap2(content);
			String itid = json.get("itid").toString();
			UpdateGatewayRoomsResult r = new UpdateGatewayRoomsResult();
			r.setOrderid(itid);
			Integer status = Integer.parseInt(json.get("status").toString());
			r.setResultstatus(status);
			result.setResultstatus(status);
			String order = json.get("order").toString();
			String ret = json.get("result").toString();
			if (status == 1) {
				if (null != ret && ret.length() > 50) {
					String recordnum = ret.substring(30, 34);
					String version = ret.substring(34, 42);
					String beforever = version.substring(0, 4);
					// 网关功率等级
					String powerlev = ret.substring(48, 50);
					if (powerlev.toUpperCase().equals("A3")) {
						powerlev = "A3";
					} else if (powerlev.toUpperCase().equals("A1")) {
						powerlev = "A1";
					} else if (powerlev.toUpperCase().equals("A2")) {
						powerlev = "A2";
					} else {
						powerlev = "A0";
					}
					// 网关更新信道id-信道-功率
					String xindaoID = ret.substring(42, 46);
					String xindao = ret.substring(46, 48);
					xindao = Integer.valueOf(xindao, 16) + "";
					String information = xindaoID + "-" + xindao + "-" + powerlev;
					r.setInformation(information);
					// 门锁数量
					String locknum = "";
					String locks = "";
					String wid = null;
					if (Integer.valueOf(beforever) > 100) {
						// 老版本(无唯一id)
						if (ret.substring(20, 24).equals("017a") || ret.substring(20, 24).equals("017A")) {
							locknum = ret.substring(62, 64);
							locks = ret.substring(64, ret.length() - 4);
						} else {
							locknum = ret.substring(86, 88);
							locks = ret.substring(88, ret.length() - 4);
							wid = ret.substring(54, 64);
						}
					}

					if (recordnum.equals("0000")) {
						r.setRecordnum(0);
					} else {
						String n = Long.valueOf(recordnum, 16) + "";
						r.setRecordnum(Integer.parseInt(n));
					}
					if (locknum.equals("00")) {
						r.setLocknum(0);
						r.setLocks("");
					} else {
						String n = Long.valueOf(locknum, 16) + "";
						r.setLocknum(Integer.parseInt(n));
						r.setLocks(StringTools.getAlllocks(locks));
					}
					r.setVersion(version);
					if (null != wid) {
						r.setWid(wid);
					}
					r.setPowerlev(powerlev.toUpperCase());
				}

			}
			String no = json.get("no").toString();
			String space = json.get("space") == null ? "" : json.get("space").toString();
			String begin = json.get("begin") == null ? "" : json.get("begin").toString();
			r.setBegin(begin);
			String osdate = json.get("osdate") == null ? "" : json.get("osdate").toString();
			try {
				r.setOsdate(sdf2.format(sdf.parse(osdate)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (null != no && no.matches("^[0-9]{1,}$")) {
				r.setNo(Integer.parseInt(no));
			}
			r.setSpace(space);
			int failtype = StringTools.getFailtype(ret);
			r.setOrder(order);
			r.setResult(ret);
			r.setFiletype(failtype);
			result.setResult(r);
		}
		return result;
	}

	@Override
	public ReceiveResult<ReadGatewayRecordResult> getReadGatewayRecordResult(String content, String sysdate,
			String verify) {
		// TODO Auto-generated method stub
		ReceiveResult<ReadGatewayRecordResult> result = Verify.verify(content, sysdate, verify, secret, timeout);
		if (result.getResultCode().equals("0")) {
			Integer status = null;
			try {
				String successval = content;
				String gatewaycode2 = "";
				String resultorder = successval;
				String record = "";
				if (resultorder.substring(0, 4).toUpperCase().equals("BBBB")) {
					gatewaycode2 = resultorder.substring(8, 18);
					record = resultorder.substring(38, resultorder.length() - 4);
				} else {
					gatewaycode2 = resultorder.substring(6, 16);
					record = resultorder.substring(36, resultorder.length() - 4);
				}
				ReadGatewayRecordResult r = new ReadGatewayRecordResult();
				r.setGatewaycode2(gatewaycode2);
				r.setRecord(record);
				if (null != record && record.trim().length() > 0) {
					List<Map> unlockings = StringTools.getUnlockinglist2(record);
					if (unlockings != null && unlockings.size() > 0) {
						List<GatewayRecord> gatewayRecords = new ArrayList<GatewayRecord>();
						for (int i = 0; i < unlockings.size(); i++) {
							Map map = unlockings.get(i);
							String roomcode = map.get("roomcode").toString();
							String cardcode = map.get("cardcode").toString();
							String cardcode2 = map.get("cardcode2").toString();
							String packageNo = map.get("packageNo").toString();
							String time = map.get("time").toString();
							String type = map.get("type").toString();
							String password = map.get("password").toString();
							GatewayRecord gatewayRecord = new GatewayRecord();
							gatewayRecord.setRoomcode(roomcode);
							gatewayRecord.setCardcode(cardcode);
							gatewayRecord.setCardcode2(cardcode2);
							gatewayRecord.setPackageNo(packageNo);
							gatewayRecord.setTime(time);
							gatewayRecord.setType(type);
							gatewayRecord.setPassword(password);
							gatewayRecords.add(gatewayRecord);
						}
						r.setGatewayRecords(gatewayRecords);
					}
				}
				status = 1;
				result.setResult(r);
			} catch (Exception e) {
				e.printStackTrace();
				status = 0;
			} finally {
				result.setResultstatus(status);
			}
		}
		return result;
	}

	@Override
	public ReceiveResult<GatewayInitializeResult> getGatewayInitializeResult(String content, String sysdate,
			String verify) {
		// TODO Auto-generated method stub
		ReceiveResult<GatewayInitializeResult> result = Verify.verify(content, sysdate, verify, secret, timeout);
		if (result.getResultCode().equals("0")) {
			Map json = StringTools.stringToMap2(content);
			String itid = json.get("itid").toString();
			GatewayInitializeResult r = new GatewayInitializeResult();
			r.setOrderid(itid);
			r.setResultstatus(Integer.parseInt(json.get("status").toString()));
			result.setResultstatus(Integer.parseInt(json.get("status").toString()));
			String order = json.get("order") == null ? "" : json.get("order").toString();
			String ret = json.get("result") == null ? "" : json.get("result").toString();
			String no = json.get("no").toString();
			String space = json.get("space") == null ? "" : json.get("space").toString();
			String osdate = json.get("osdate") == null ? "" : json.get("osdate").toString();
			try {
				r.setOsdate(sdf2.format(sdf.parse(osdate)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			r.setOrder(order);
			r.setResult(ret);
			r.setNo(Integer.parseInt(no));
			r.setSpace(space);
			int failtype = StringTools.getFailtype(ret);
			r.setFiletype(failtype);
			result.setResult(r);
		}
		return result;
	}

	@Override
	public ReceiveResult<SaveUnlockPswResult> getSaveUnlockPswResult(String content, String sysdate, String verify) {
		// TODO Auto-generated method stub
		ReceiveResult<SaveUnlockPswResult> result = Verify.verify(content, sysdate, verify, secret, timeout);
		if (result.getResultCode().equals("0")) {
			Map json = StringTools.stringToMap2(content);
			String rcid = json.get("rcid").toString();
			SaveUnlockPswResult r = new SaveUnlockPswResult();
			r.setOrderid(rcid);
			String status = json.get("status").toString();
			r.setResultstatus(Integer.parseInt(status));
			result.setResultstatus(Integer.parseInt(status));
			if (status.equals("0")) {
				if (json.get("cardtype").toString().equals("20")) {
					String order = json.get("order)").toString();
					r.setOrder(order);
					String cardtype = json.get("cardtype").toString();
					r.setCardtype(cardtype);
					String no = json.get("no").toString();
					r.setNo(no);
					String space = json.get("space").toString();
					r.setSpace(space);
				}
			}
			String osdate = json.get("osdate") == null ? "" : json.get("osdate").toString();
			try {
				r.setOsdate(sdf2.format(sdf.parse(osdate)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String ret = json.get("result").toString();
			int failtype = StringTools.getFailtype(ret);
			r.setFiletype(failtype);
			result.setResult(r);
		}
		return result;
	}

	@Override
	public ReceiveResult<DelUnlockpswResult> getDelUnlockpswResult(String content, String sysdate, String verify) {
		// TODO Auto-generated method stub
		ReceiveResult<DelUnlockpswResult> result = Verify.verify(content, sysdate, verify, secret, timeout);
		if (result.getResultCode().equals("0")) {
			Map json = StringTools.stringToMap2(content);
			String rcid = json.get("rcid").toString();
			DelUnlockpswResult r = new DelUnlockpswResult();
			r.setOrderid(rcid);
			String status = json.get("status").toString();
			r.setResultstatus(Integer.parseInt(status));
			result.setResultstatus(Integer.parseInt(status));
			if (json.get("cardtype").toString().equals("40")) {
				String order = json.get("order)").toString();
				r.setOrder(order);
				String cardtype = json.get("cardtype").toString();
				r.setCardtype(cardtype);
				String no = json.get("no").toString();
				r.setNo(no);
				String space = json.get("space") == null ? "" : json.get("space").toString();
				r.setSpace(space);
			}
			String osdate = json.get("osdate") == null ? "" : json.get("osdate").toString();
			try {
				r.setOsdate(sdf2.format(sdf.parse(osdate)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String ret = json.get("result").toString();
			int failtype = StringTools.getFailtype(ret);
			r.setFiletype(failtype);
			result.setResult(r);
		}
		return result;
	}

	@Override
	public ReceiveResult<LockInitializeResult> getLockInitializeResult(String content, String sysdate, String verify) {
		// TODO Auto-generated method stub
		ReceiveResult<LockInitializeResult> result = Verify.verify(content, sysdate, verify, secret, timeout);
		if (result.getResultCode().equals("0")) {
			Map json = StringTools.stringToMap2(content);
			String itid = json.get("itid").toString();
			String od = json.get("od").toString();
			String ret = json.get("result").toString();
			LockInitializeResult r = new LockInitializeResult();
			r.setOrderid(itid);
			r.setResultstatus(Integer.parseInt(json.get("status").toString()));
			result.setResultstatus(Integer.parseInt(json.get("status").toString()));
			if (json.get("status").toString().equals("1")) {
				r.setNewcode(json.get("newcode").toString());
				;
				// TODO B0指令附带门锁当前状态
				// 生命周期
				String lca = ret.substring(30, 31);
				if (lca.equals("1")) {
					r.setLocklca(-1);
				} else if (lca.equals("2")) {
					r.setLocklca(1);
				} else if (lca.equals("4")) {
					r.setLocklca(2);
				}
				// 开关门状态
				String status = ret.substring(31, 32);
				String bet = ret.substring(32, 34);
				// 门锁功率等级默认为最大功率A3
				String powerlev = ret.substring(46, 48);
				if (powerlev.toUpperCase().equals("A0")) {
					powerlev = "A0";
				} else if (powerlev.toUpperCase().equals("A1")) {
					powerlev = "A1";
				} else if (powerlev.toUpperCase().equals("A2")) {
					powerlev = "A2";
				} else {
					powerlev = "A3";
				}
				String recordnum = ret.substring(50, 54);
				String ver = ret.substring(54, 62);
				String channelid = ret.substring(62, 66);
				String channel = ret.substring(66, 68);
				String networkmode = ret.substring(78, 79);
				String workmode = ret.substring(79, 80);
				String locktype = ret.substring(81, 82);
				String figernum = ret.substring(82, 84);
				int bettery = Integer.valueOf(bet, 16);
				String[] type = StringTools.getlockstatus(status);
				// 更新状态
				r.setLockstatus(Integer.valueOf(type[0]));
				r.setLockstatus2(Integer.valueOf(type[1]));
				r.setChannelid(channelid);
				r.setChannel(Integer.valueOf(channel, 16) + "");
				r.setPowerlev(powerlev);
				r.setNetworkmode(Integer.valueOf(networkmode));
				r.setWorkmode(Integer.valueOf(workmode));
				r.setLocktype(Integer.valueOf(locktype));
				r.setFigernum(Integer.valueOf(figernum, 16));
				r.setLockver(ver);
				r.setLockcharge(bettery);
				if (recordnum.equals("0000")) {
					r.setRecordnum(0);
				} else {
					r.setRecordnum(Integer.valueOf(recordnum, 16));
				}
			}
			r.setOrder(json.get("order") == null ? "" : json.get("order").toString());
			r.setNo(json.get("no").toString());
			r.setSpace(json.get("space") == null ? "" : json.get("space").toString());
			String osdate = json.get("osdate") == null ? "" : json.get("osdate").toString();
			try {
				r.setOsdate(sdf2.format(sdf.parse(osdate)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			r.setResult(ret);
			int failtype = StringTools.getFailtype(ret);
			r.setFiletype(failtype);
			result.setResult(r);
		}
		return result;
	}

	/**
	 * 卡片，密码，指纹，授权与删除授权指令结果解析
	 */
	@Override
	public ReceiveResult<OrderResult> getOrderResult(String content, String sysdate, String verify) {
		// TODO Auto-generated method stub
		ReceiveResult<OrderResult> result = Verify.verify(content, sysdate, verify, secret, timeout);
		if (result.getResultCode().equals("0")) {
			Map json = StringTools.stringToMap2(content);
			// 锁类型
			String locktype = json.get("locktype").toString();
			// 结果类型
			String ordertype = json.containsKey("ordertype") ? json.get("ordertype").toString()
					: json.get("orderType").toString();
			// 下发轮次
			String no = "1";
			if (json.containsKey("no")) {
				no = json.get("no").toString();
			}
			// 指令下发时间
			String osdate = json.get("osdate").toString();
			// 指令结果状态
			String status = json.get("status").toString();

			OrderResult r = new OrderResult();
			if (locktype.equals("1")) {
				// 网关锁的结果指令
				String ret = json.get("result").toString();
				r.setOrderid(json.get("itid").toString());
				r.setResultstatus(Integer.parseInt(status));
				r.setNo(no);
				String odate = sdf2.format(new Date());
				try {
					if (osdate.length() == 12) {
						odate = sdf2.format(sdf1.parse(osdate));
					} else {
						odate = sdf2.format(sdf.parse(osdate));
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				r.setOsdate(odate);
				r.setOrderType(ordertype);

				// 如果是单轮结果，无需判断指令失败原因
				if (ordertype.equals("0")) {
					if (no.equals("1")) {
						r.setFailtype(42);
					} else {
						r.setFailtype(43);
					}
				} else {
					if (status.equals("1")) {
						r.setFailtype(-1);
					}
					if (status.equals("2")) {
						r.setFailtype(44);
					} else {
						int failtype = StringTools.getFailtype(ret);
						r.setFailtype(failtype);
					}
				}

				result.setResultstatus(Integer.parseInt(status));
				result.setResult(r);
			} else {
				String odate = sdf2.format(new Date());
				try {
					if (osdate.length() == 12) {
						odate = sdf2.format(sdf1.parse(osdate));
					} else {
						odate = sdf2.format(sdf.parse(osdate));
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				r.setOsdate(odate);

				r.setOrderid(json.get("ids").toString());
				r.setNo(no);
				r.setOrderType(ordertype);
				r.setResultstatus(Integer.parseInt(status));

				if (ordertype.equals("0")) {
					if (no.equals("1")) {
						r.setFailtype(42);
					} else {
						r.setFailtype(43);
					}
				} else {
					if (status.equals("1")) {
						r.setFailtype(-1);
						r.setResultstatus(1);
					} else if (status.equals("2")) {
						r.setFailtype(44);
					} else {
						String fail = json.get("messageId").toString().substring(0, 2);
						if (fail.equals("6")) {
							r.setFailtype(6);
						} else {
							int failtype = StringTools.getFailtype2(fail);
							r.setFailtype(failtype);
						}
					}
				}

				result.setResultstatus(Integer.parseInt(status));
				result.setResult(r);
			}
		}
		return result;
	}

	/**
	 * 卡片密码授权同步指令结果解析
	 */
	@Override
	public ReceiveResult<SyncCPOrderResult> getSyncCPResult(String content, String sysdate, String verify) {
		// TODO Auto-generated method stub
		ReceiveResult<SyncCPOrderResult> result = Verify.verify(content, sysdate, verify, secret, timeout);
		if ("0".equals(result.getResultCode())) {
			Map json = StringTools.stringToMap2(content);
			String orderType = json.containsKey("orderType") ? json.get("orderType").toString()
					: json.get("ordertype").toString();
			String locktype = json.get("locktype").toString();
			String status = json.get("status").toString();
			String osdate = json.get("osdate").toString();
			SyncCPOrderResult res = new SyncCPOrderResult();
			res.setOrderType(orderType);
			res.setResultstatus(Integer.valueOf(status));
			String odate = sdf2.format(new Date());
			try {
				if (osdate.length() == 12) {
					odate = sdf2.format(sdf1.parse(osdate));
				} else {
					odate = sdf2.format(sdf.parse(osdate));
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
			res.setOsdate(odate);
			// 小包结果
			if ("0".equals(orderType)) {
				// 联网锁
				if (locktype.equals("1")) {
					String num = json.get("num").toString();
					String itid = json.get("rcid").toString();
					String sendorder = json.containsKey("sendorder") ? json.get("sendorder").toString() : "";
					String resultorder = json.get("result").toString();
					JSONObject retj = StringTools.getPassOrCardBySendorder(sendorder);
					if (retj.containsKey("pass")) {
						res.setPasswords(retj.getString("pass"));
					}
					if (retj.containsKey("card")) {
						res.setCardcodes(retj.getString("card"));
					}
					res.setNo(num);
					res.setOrderid(itid);
					int failtype = StringTools.getFailtype(resultorder);
					res.setFailtype(failtype);
				} else {

				}
			} else if ("1".equals(orderType)) {
				// 联网锁
				if (locktype.equals("1")) {
					if (status.equals("2")) {
						res.setFailtype(44);
					} else if (status.equals("1")) {
						res.setFailtype(-1);
					} else {
						String resultorder = json.get("result").toString();
						int failtype = StringTools.getFailtype(resultorder);
						res.setFailtype(failtype);
					}

					String num = json.get("num").toString();
					String itid = json.get("rcid").toString();
					res.setNo(num);
					res.setOrderid(itid);
				} else {

				}
			}
			result.setResult(res);
		}
		return result;
	}

	@Override
	public ReceiveResult<SyncFOrderResult> getSyncFResult(String content, String sysdate, String verify) {
		// TODO Auto-generated method stub
		ReceiveResult<SyncFOrderResult> result = Verify.verify(content, sysdate, verify, secret, timeout);
		;
		if (result.getResultCode().equals("0")) {
			Map json = StringTools.stringToMap2(content);
			String orderType = json.containsKey("orderType") ? json.get("orderType").toString()
					: json.get("ordertype").toString();
			String locktype = json.get("locktype").toString();
			String status = json.get("status").toString();
			String osdate = json.get("osdate").toString();
			SyncFOrderResult res = new SyncFOrderResult();
			res.setOrderType(orderType);
			res.setResultstatus(Integer.valueOf(status));
			String odate = sdf2.format(new Date());
			try {
				if (osdate.length() == 12) {
					odate = sdf2.format(sdf1.parse(osdate));
				} else {
					odate = sdf2.format(sdf.parse(osdate));
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
			res.setOsdate(odate);
			// 小包结果
			if ("0".equals(orderType)) {
				// 联网锁
				if (locktype.equals("1")) {
					String num = json.get("num").toString();
					String itid = json.get("rcid").toString();
					String sendorder = json.containsKey("sendorder") ? json.get("sendorder").toString() : "";
					String resultorder = json.get("result").toString();
					String fingercode = StringTools.getFingersBySendorder(sendorder);
					if (!"".equals(fingercode)) {
						res.setFingers(fingercode);
					}

					res.setNo(num);
					res.setOrderid(itid);
					int failtype = StringTools.getFailtype(resultorder);
					res.setFailtype(failtype);
				} else {

				}
			} else if ("1".equals(orderType)) {
				// 联网锁
				if (locktype.equals("1")) {
					if (status.equals("2")) {
						res.setFailtype(44);
					} else if (status.equals("1")) {
						res.setFailtype(-1);
					} else {
						String resultorder = json.get("result").toString();
						int failtype = StringTools.getFailtype(resultorder);
						res.setFailtype(failtype);
					}

					String num = json.get("num").toString();
					String itid = json.get("rcid").toString();
					res.setNo(num);
					res.setOrderid(itid);
				} else {

				}
			}
			result.setResult(res);
		}
		return result;
	}

	@Override
	public ReceiveResult<FingerMachineStateResult> getFingerMachineStateResult(String content, String sysdate,
			String verify) {
		// TODO Auto-generated method stub
		ReceiveResult<FingerMachineStateResult> result = Verify.verify(content, sysdate, verify, secret, timeout);
		if ("0".equals(result.getResultCode())) {
			Map json = StringTools.stringToMap2(content);
			FingerMachineStateResult r = new FingerMachineStateResult();
			String resultorder = json.get("result").toString();
			r.setResult(resultorder);
			String orderid = json.get("itid").toString();
			r.setOrderid(orderid);
			Integer status = Integer.parseInt(json.get("status").toString());
			r.setResultstatus(status);
			result.setResultstatus(status);
			if (status == 1) {
				if (null != resultorder && resultorder.length() > 50) {
					String version = resultorder.substring(34, 42);
					r.setVersion(version);
				}
			} else {
				if (null == resultorder || "".equals(resultorder)) {
				}
			}
			String od = json.get("order").toString();
			r.setOrder(od);
			int failtype = StringTools.getFailtype(resultorder);
			r.setFiletype(failtype);
			String osdate = json.get("osdate").toString();
			try {
				r.setOsdate(sdf2.format(sdf.parse(osdate)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String space = json.get("space") == null ? "" : json.get("space").toString();
			r.setSpace(space);
			result.setResult(r);
		}
		return result;
	}

	@Override
	public ReceiveResult<FingerResult> getFingerResult(String content, String sysdate, String verify) {
		// TODO Auto-generated method stub
		ReceiveResult<FingerResult> result = Verify.verify(content, sysdate, verify, secret, timeout);
		if ("0".equals(result.getResultCode())) {
			Map json = StringTools.stringToMap2(content);
			String orderType = json.get("orderType").toString();
			FingerResult res = new FingerResult();
			res.setOrderType(orderType);
			if ("fail".equals(orderType)) {
				FingerfailResult r = new FingerfailResult();
				String type = json.get("type").toString();
				String num = json.get("num").toString();
				r.setType(type);
				r.setNum(num);
				r.setResultstatus(Integer.parseInt(json.get("status").toString()));
				result.setResultstatus(Integer.parseInt(json.get("status").toString()));
				if (num.equals("1") || num.equals("2")) {
					String rcid = json.get("rcid").toString();
					String order = json.get("fail").toString();
					r.setOrderid(json.get("itid").toString());
					r.setRcid(rcid);
					r.setOrder(order);
					if (type.equals("1")) {

					} else if (type.equals("2")) {
						String fingercodes = StringTools.getFingercodeByOrder(order);
						r.setFingercodes(fingercodes);
					} else {
						String fingercodes = StringTools.getFingercodesByOrders(new String[] { order });
						r.setFingercodes(fingercodes);
					}
				}
				Object object = json.get("result");
				if (object != null) {
					String ret = (String) object;
					Integer failtype = StringTools.getFailtype(ret);
					r.setFailtype(failtype);
				}
				res.setFailResult(r);
			} else if ("finish".equals(orderType)) {
				FingerfinishResult r = new FingerfinishResult();
				String type = json.get("type").toString();
				String itid = json.get("itid").toString();
				String order = json.get("finish").toString();
				r.setOrderid(itid);
				r.setRcid(json.get("rcid").toString());
				;
				r.setType(type);
				r.setOrder(order);
				if (type.equals("1")) {

				} else if (type.equals("2")) {
					String fingercodes = StringTools.getFingercodeByOrder(order);
					r.setFingercodes(fingercodes);
				} else {
					String fingercodes = StringTools.getFingercodesByOrders(new String[] { order });
					r.setFingercodes(fingercodes);
				}
				String ret = json.get("result").toString();
				Integer failtype = StringTools.getFailtype(ret);
				r.setFiletype(failtype);
				r.setResult(ret);
				res.setFinishResult(r);
			} else if ("success".equals("orderType")) {
				FingersuccessResult r = new FingersuccessResult();
				String type = json.get("type").toString();
				String itid = json.get("itid").toString();
				String status = json.get("status").toString();
				String ret = json.get("result").toString();
				r.setOrderid(itid);
				r.setRcid(json.get("rcid").toString());
				r.setType(type);
				r.setResult(ret);
				r.setResultstatus(Integer.parseInt(status));
				result.setResultstatus(Integer.parseInt(status));
				if (type.equals("2")) {
					String failorder = json.get("fail").toString();
					String fingercodes = StringTools.getFingercodeByOrder(failorder);
					r.setFingercodes(fingercodes);
				}
				String order = json.get("order").toString();
				Integer failtype = StringTools.getFailtype(ret);
				r.setFiletype(failtype);
				r.setOrder(order);
				r.setResult(ret);
				res.setSuccessResult(r);
			}
		}
		return result;
	}

	@Override
	public ReceiveResult<RoomParamas> getSlRoomParamas(String content, String sysdate, String verify) {
		// TODO Auto-generated method stub
		ReceiveResult<RoomParamas> result = Verify.verify(content, sysdate, verify, secret, timeout);
		if ("0".equals(result.getResultCode())) {
			RoomParamas r = new RoomParamas();
			JSONObject json = JSONObject.fromObject(content);
			String roomcode2 = json.getString("roomcode2");
			r.setRoomcode2(roomcode2);
			
			Integer roomcharge = json.getInt("roomcharge");
			r.setRoomcharge(roomcharge);
			String roomecl = json.getString("roomecl");
			r.setRoomecl(roomecl);
			String roomsnr = json.getString("roomsnr");
			r.setRoomsnr(roomsnr);
			String roompci = json.getString("roompci");
			r.setRoompci(roompci);
			String devicetype = json.getString("devicetype");
			r.setDevicetype(devicetype);
			String lockver = json.getString("lockver");
			r.setLockver(lockver);
			String locklca = json.getString("locklca");
			r.setLocklca(locklca);
			String roomreset = json.getString("roomreset");
			r.setRoomreset(roomreset);
			Integer isfinger = json.getInt("isfinger");
			r.setIsfinger(isfinger);
			Integer isbluetooth = json.getInt("isbluetooth");
			r.setIsbluetooth(isbluetooth);
			Integer isscanner = json.getInt("isscanner");
			r.setIsscanner(isscanner);
			Integer islockswith = json.getInt("islockswith");
			r.setIslockswith(islockswith);
			Integer islatchswith = json.getInt("islatchswith");
			r.setIslatchswith(islatchswith);
			Integer iskeyswith = json.getInt("iskeyswith");
			r.setIskeyswith(iskeyswith);
			Integer iscontactswith = json.getInt("iscontactswith");
			r.setIscontactswith(iscontactswith);
			Integer antilock = json.getInt("antilock");
			r.setAntilock(antilock);
			Integer open = json.getInt("open");
			r.setOpen(open);
			Integer forcelock = json.getInt("forcelock");
			r.setForcelock(forcelock);
			Integer networkmode = json.getInt("networkmode");
			r.setNetworkmode(networkmode);
			Integer workmode = json.getInt("workmode");
			r.setWorkmode(workmode);
			Integer fingernum = json.getInt("fingernum");
			r.setFingernum(fingernum);
			Integer passnum = json.getInt("passnum");
			r.setPassnum(passnum);
			Integer opencardnum = json.getInt("opencardnum");
			r.setOpencardnum(opencardnum);
			Integer managecardnum = json.getInt("managecardnum");
			r.setManagecardnum(managecardnum);
			Integer specialcardnum = json.getInt("specialcardnum");
			r.setSpecialcardnum(specialcardnum);
			String signalStrength = json.getString("signalStrength");
			r.setSignalStrength(signalStrength);
			String recordcount = json.getString("recordcount");
			r.setRecordcount(recordcount);
			result.setResult(r);
		}
		return result;
	}

	@Override
	public ReceiveResult<HeartRecordResult> getHeartRecordResult(String content, String sysdate, String verify) {
		// TODO Auto-generated method stub
		ReceiveResult<HeartRecordResult> result = Verify.verify(content, sysdate, verify, secret, timeout);
		if ("0".equals(result.getResultCode())) {
			HeartRecordResult r = new HeartRecordResult();
			JSONObject json = JSONObject.fromObject(content);
			String status = json.getString("status");
			r.setResultstatus(Integer.parseInt(status == null ? "0" : status));
			String locktype = json.getString("locktype");
			r.setLocktype(locktype);
			String resultorder = json.getString("resultorder");
			String gatewayname = "";
			String record = "";
			if (resultorder.substring(0, 4).toUpperCase().equals("BBBB")) {
				gatewayname = resultorder.substring(8, 18);
				record = resultorder.substring(38, resultorder.length() - 4);
			} else {
				gatewayname = resultorder.substring(6, 16);
				record = resultorder.substring(36, resultorder.length() - 4);
			}
			r.setGatewaycode2(gatewayname);
			// 如果该唯一id的网关尚未存在则丢弃记录
			if (null != gatewayname) {
				// 保存读取到的记录
				List<Map> unlockings = StringTools.getUnlockinglist2(record);
				List<HeartRecord> records = new ArrayList<HeartRecord>();
				for (int h = 0; h < unlockings.size(); h++) {
					Map jsonObject = unlockings.get(h);
					String roomcode = (String) jsonObject.get("roomcode");
					String cardcode = (String) jsonObject.get("cardcode");
					String packageNo = (String) jsonObject.get("packageNo");
					String time = (String) jsonObject.get("time");
					String cardcode2 = (String) jsonObject.get("cardcode2");
					String type = (String) jsonObject.get("type");
					HeartRecord readlockrecord = new HeartRecord(roomcode, cardcode, packageNo, time, cardcode2, type);
					records.add(readlockrecord);
				}
				r.setRecords(records);
			}
			result.setResult(r);
		}
		return result;
	}
}
