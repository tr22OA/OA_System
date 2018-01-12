package com.oa.vo.qh;

public class attendanceCountVo {
	private String id;//编号
	private String name;//姓名
	private int shouldWork;//应上班
	private int actualWord;//实上班
	private int late;//迟到
	private int leaveEarly;//早退
	private int absenteeism;//旷工
	private int leakCard; //漏刷卡
	private int restdayOvertime;//休息日加班
	private int holidayOvertime;//节假日加班
	private int weekdayOvertime;//平日加班
	private int takeOff;//调休
	private int yearLeave;//年假
	private int thingLeave;//事假
	private int sickLeave;//病假
	private int marryLeave;//婚假
	private int maternityLeave;//产假
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getShouldWork() {
		return shouldWork;
	}
	public void setShouldWork(int shouldWork) {
		this.shouldWork = shouldWork;
	}
	public int getActualWord() {
		return actualWord;
	}
	public void setActualWord(int actualWord) {
		this.actualWord = actualWord;
	}
	public int getLate() {
		return late;
	}
	public void setLate(int late) {
		this.late = late;
	}
	public int getLeaveEarly() {
		return leaveEarly;
	}
	public void setLeaveEarly(int leaveEarly) {
		this.leaveEarly = leaveEarly;
	}
	public int getAbsenteeism() {
		return absenteeism;
	}
	public void setAbsenteeism(int absenteeism) {
		this.absenteeism = absenteeism;
	}
	public int getLeakCard() {
		return leakCard;
	}
	public void setLeakCard(int leakCard) {
		this.leakCard = leakCard;
	}
	public int getRestdayOvertime() {
		return restdayOvertime;
	}
	public void setRestdayOvertime(int restdayOvertime) {
		this.restdayOvertime = restdayOvertime;
	}
	public int getHolidayOvertime() {
		return holidayOvertime;
	}
	public void setHolidayOvertime(int holidayOvertime) {
		this.holidayOvertime = holidayOvertime;
	}
	public int getWeekdayOvertime() {
		return weekdayOvertime;
	}
	public void setWeekdayOvertime(int weekdayOvertime) {
		this.weekdayOvertime = weekdayOvertime;
	}
	public int getTakeOff() {
		return takeOff;
	}
	public void setTakeOff(int takeOff) {
		this.takeOff = takeOff;
	}
	public int getYearLeave() {
		return yearLeave;
	}
	public void setYearLeave(int yearLeave) {
		this.yearLeave = yearLeave;
	}
	public int getThingLeave() {
		return thingLeave;
	}
	public void setThingLeave(int thingLeave) {
		this.thingLeave = thingLeave;
	}
	public int getSickLeave() {
		return sickLeave;
	}
	public void setSickLeave(int sickLeave) {
		this.sickLeave = sickLeave;
	}
	public int getMarryLeave() {
		return marryLeave;
	}
	public void setMarryLeave(int marryLeave) {
		this.marryLeave = marryLeave;
	}
	public int getMaternityLeave() {
		return maternityLeave;
	}
	public void setMaternityLeave(int maternityLeave) {
		this.maternityLeave = maternityLeave;
	}
	public attendanceCountVo(String id, String name, int shouldWork, int actualWord, int late, int leaveEarly,
			int absenteeism, int leakCard, int restdayOvertime, int holidayOvertime, int weekdayOvertime, int takeOff,
			int yearLeave, int thingLeave, int sickLeave, int marryLeave, int maternityLeave) {
		super();
		this.id = id;
		this.name = name;
		this.shouldWork = shouldWork;
		this.actualWord = actualWord;
		this.late = late;
		this.leaveEarly = leaveEarly;
		this.absenteeism = absenteeism;
		this.leakCard = leakCard;
		this.restdayOvertime = restdayOvertime;
		this.holidayOvertime = holidayOvertime;
		this.weekdayOvertime = weekdayOvertime;
		this.takeOff = takeOff;
		this.yearLeave = yearLeave;
		this.thingLeave = thingLeave;
		this.sickLeave = sickLeave;
		this.marryLeave = marryLeave;
		this.maternityLeave = maternityLeave;
	}
	public attendanceCountVo() {
		super();
	}
	
	
}
