package com.oa.vo.qh;

public class ScheduletypeVo {
	private String shtId; //排班类型编号
	private String shtName;//名称
	private String shtWeek;//工作日
	private String shtRemark;//备注
	private String shtStatus;//状态
	public String getShtId() { 
		return shtId;
	}
	public void setShtId(String shtId) {
		this.shtId = shtId;
	}
	public String getShtName() {
		return shtName;
	}
	public void setShtName(String shtName) {
		this.shtName = shtName;
	}
	public String getShtWeek() {
		return shtWeek;
	}
	public void setShtWeek(String shtWeek) {
		this.shtWeek = shtWeek;
	}
	public String getShtRemark() {
		return shtRemark;
	}
	public void setShtRemark(String shtRemark) {
		this.shtRemark = shtRemark;
	}
	public String getShtStatus() {
		return shtStatus;
	}
	public void setShtStatus(String shtStatus) {
		this.shtStatus = shtStatus;
	}
	public ScheduletypeVo(String shtId, String shtName, String shtWeek, String shtRemark, String shtStatus) {
		super();
		this.shtId = shtId;
		this.shtName = shtName;
		this.shtWeek = shtWeek;
		this.shtRemark = shtRemark;
		this.shtStatus = shtStatus;
	}
	public ScheduletypeVo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
