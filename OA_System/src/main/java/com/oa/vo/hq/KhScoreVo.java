package com.oa.vo.hq;
//考核评分实体KhScoreVo
public class KhScoreVo {
	private String khName;
	private String khStep;	//考核步骤
	private String khPeople;	//被考核人
	private String a;	//开始时间
	private String b;	//结束时间
	public String getKhName() {
		return khName;
	}
	public void setKhName(String khName) {
		this.khName = khName;
	}
	public String getKhStep() {
		return khStep;
	}
	public void setKhStep(String khStep) {
		this.khStep = khStep;
	}
	public String getKhPeople() {
		return khPeople;
	}
	public void setKhPeople(String khPeople) {
		this.khPeople = khPeople;
	}
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	public KhScoreVo(String khName, String khStep, String khPeople, String a, String b) {
		super();
		this.khName = khName;
		this.khStep = khStep;
		this.khPeople = khPeople;
		this.a = a;
		this.b = b;
	}
	public KhScoreVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
