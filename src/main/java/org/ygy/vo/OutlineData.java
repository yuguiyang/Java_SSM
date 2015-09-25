package org.ygy.vo;

import java.math.BigDecimal;

public class OutlineData {
	private String name;
	private String url;
	private String personResponse;
	private Integer registerNum = 0;
	private Integer realNum = 0;
	private Integer investNum = 0;
	private BigDecimal investMoney = new BigDecimal(0.0);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPersonResponse() {
		return personResponse;
	}

	public void setPersonResponse(String personResponse) {
		this.personResponse = personResponse;
	}

	public Integer getRegisterNum() {
		return registerNum;
	}

	public void setRegisterNum(Integer registerNum) {
		this.registerNum = registerNum;
	}

	public Integer getRealNum() {
		return realNum;
	}

	public void setRealNum(Integer realNum) {
		this.realNum = realNum;
	}

	public Integer getInvestNum() {
		return investNum;
	}

	public void setInvestNum(Integer investNum) {
		this.investNum = investNum;
	}

	public BigDecimal getInvestMoney() {
		return investMoney;
	}

	public void setInvestMoney(BigDecimal investMoney) {
		this.investMoney = investMoney;
	}

}
