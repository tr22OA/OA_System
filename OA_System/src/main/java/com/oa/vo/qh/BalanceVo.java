package com.oa.vo.qh;

public class BalanceVo {
	private String deptName;
	private String empName;
	private int number;
	private String year;
	
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public BalanceVo(String deptName, String empName, int number) {
		super();
		this.deptName = deptName;
		this.empName = empName;
		this.number = number;
	}
	public BalanceVo() {
		super();
	}
}
