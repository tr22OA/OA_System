package com.oa.vo.qh;

public class deptVo {
	private String deptId;//部门编号
	private String deptName;//部门名称
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public deptVo(String deptId, String deptName) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
	}
	public deptVo() {
		super();
		// TODO Auto-generated constructor stub
	}
}
