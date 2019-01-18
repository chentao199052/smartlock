package com.qingyi.model;

import java.util.List;

public class AuthResult {
	
	private List<CardsResult> cardsresult;
	
	private List<DelCardsResult> delcardsresult;
	
	private List<FingersResult> fingersresult;
	
	private List<DelFingersResult> delfingersresult;
	
	private List<PswsResult> pswsresult;
	
	private List<DelPswsResult> delpswsresult;
	
	public AuthResult() {
		super();
	}

	/**
	 * 混合授权结果构造方法
	 * @param cardsresult 卡片授权结果list
	 * @param delcardsresult 删除卡片授权结果list
	 * @param fingersresult 指纹授权结果list
	 * @param delfingersresult 删除指纹授权结果list
	 * @param pswsresult 密码授权结果list
	 * @param delpswsresult 删除密码授权结果list
	 */
	public AuthResult(List<CardsResult> cardsresult, List<DelCardsResult> delcardsresult,
			List<FingersResult> fingersresult, List<DelFingersResult> delfingersresult, List<PswsResult> pswsresult,
			List<DelPswsResult> delpswsresult) {
		super();
		this.cardsresult = cardsresult;
		this.delcardsresult = delcardsresult;
		this.fingersresult = fingersresult;
		this.delfingersresult = delfingersresult;
		this.pswsresult = pswsresult;
		this.delpswsresult = delpswsresult;
	}

	public List<CardsResult> getCardsresult() {
		return cardsresult;
	}

	public void setCardsresult(List<CardsResult> cardsresult) {
		this.cardsresult = cardsresult;
	}

	public List<DelCardsResult> getDelcardsresult() {
		return delcardsresult;
	}

	public void setDelcardsresult(List<DelCardsResult> delcardsresult) {
		this.delcardsresult = delcardsresult;
	}

	public List<FingersResult> getFingersresult() {
		return fingersresult;
	}

	public void setFingersresult(List<FingersResult> fingersresult) {
		this.fingersresult = fingersresult;
	}

	public List<DelFingersResult> getDelfingersresult() {
		return delfingersresult;
	}

	public void setDelfingersresult(List<DelFingersResult> delfingersresult) {
		this.delfingersresult = delfingersresult;
	}

	public List<PswsResult> getPswsresult() {
		return pswsresult;
	}

	public void setPswsresult(List<PswsResult> pswsresult) {
		this.pswsresult = pswsresult;
	}

	public List<DelPswsResult> getDelpswsresult() {
		return delpswsresult;
	}

	public void setDelpswsresult(List<DelPswsResult> delpswsresult) {
		this.delpswsresult = delpswsresult;
	}

	
}
