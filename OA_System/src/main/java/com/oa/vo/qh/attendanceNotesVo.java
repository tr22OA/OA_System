package com.oa.vo.qh;


public class attendanceNotesVo {
	private String date;
	private String week;
	private String gotowork;
	private String gooffwork;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getGotowork() {
		return gotowork;
	}
	public void setGotowork(String gotowork) {
		this.gotowork = gotowork;
	}
	public String getGooffwork() {
		return gooffwork;
	}
	public void setGooffwork(String gooffwork) {
		this.gooffwork = gooffwork;
	}
	public attendanceNotesVo(String date, String week, String gotowork, String gooffwork) {
		super();
		this.date = date;
		this.week = week;
		this.gotowork = gotowork;
		this.gooffwork = gooffwork;
	}
	public attendanceNotesVo() {
		super();
		// TODO Auto-generated constructor stub
	}
}
