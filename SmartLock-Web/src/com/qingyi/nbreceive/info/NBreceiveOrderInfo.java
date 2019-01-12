package com.qingyi.nbreceive.info;

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
import com.qingyi.model.NBrecordsResult;
import com.qingyi.model.ReceiveResult;
import com.qingyi.model.SlRoomParamas;

public interface NBreceiveOrderInfo {
		//C1back*  DC1back*   YC1back*
		public ReceiveResult<NBbackorderResult> getNBbackorderResult(String content,String sysdate,String verify);
		//syscbackC1_*   syscbackDC1_*  syscbackYC1_*
		public ReceiveResult<NBbackorderResult2> getNBbackorderResult2(String content,String sysdate,String verify);
		//syscbackC2_*  syscbackDC2_* syscbackYC2_*
		public ReceiveResult<NBbackorderResult3> getNBbackorderResult3(String content,String sysdate,String verify);
		//C2firstback_*   DC2firstback_*   YC2firstback_*
		public ReceiveResult<NBbackorderResult4> getNBbackorderResult4(String content,String sysdate,String verify);
		//C2back* DC2back*    YC2back*
		public ReceiveResult<NBbackorderResult5> getNBbackorderResult5(String content,String sysdate,String verify);

		//C1onesuccess_*(华为)    DC1onesuccess_*(电信)   YC1onesuccess_*（移动）
		public ReceiveResult<NBorderResult> getNBorderResult(String content,String sysdate,String verify);
		// C2onesuccess_*(华为)    DC2onesuccess_*(电信)   YC2onesuccess_*（移动）
		public ReceiveResult<NBorderResult2> getNBorderResult2(String content,String sysdate,String verify);
		/*syscC1success_*(华为)  syscfailC1_*(华为)syscDC1success_*(电信)   syscfailDC1_*(电信) 
		syscYC1success_*（移动）syscfailYC1_*（移动）
		*/
		public ReceiveResult<NBorderResult3> getNBorderResult3(String content,String sysdate,String verify);
		//syscC2success_*(华为)   syscDC2success_*(电信)   syscYC2success_*（移动） 
		public ReceiveResult<NBorderResult4> getNBorderResult4(String content,String sysdate,String verify);
		//syscfailC2_* (华为)       syscfailDC2_*(电信)  syscfailYC2_*（移动）
		public ReceiveResult<NBorderResult5> getNBorderResult5(String content,String sysdate,String verify);
		//C1success* (华为)      DC1success* (电信)  YC1success*（移动）
		public ReceiveResult<NBorderResult6> getNBorderResult6(String content,String sysdate,String verify);
		//C2success_*(华为)    DC2success_* (电信)   YC2success_*（移动）
		public ReceiveResult<NBorderResult7> getNBorderResult7(String content,String sysdate,String verify);
		/**
		 * 解析NB锁操作记录
		 * @param content
		 * @param sysdate
		 * @param verify
		 * @return
		 */
		public ReceiveResult<NBrecordsResult> getNBrecordsResult(String content,String sysdate,String verify);
		/**
		 * 解析NB锁房间的信息（post过来的信息）
		 * @param content
		 * @return
		 */
		public SlRoomParamas getSlRoomParamas(String content);
		/**
		 * 解析NB锁房间的信息（post过来的信息）
		 * @param content
		 * @return
		 */
		public SlRoomParamas getSlRoomParamasYd(String content);
		
}
