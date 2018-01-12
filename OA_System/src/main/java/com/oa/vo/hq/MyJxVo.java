package com.oa.vo.hq;
//我的绩效实体
public class MyJxVo {
	private int issue;//期次
	private String levelName;//考核等级
	private int allScore;//总评分
	private int score;//自评
	private int scoreByPeople;//指定人评
	private String comment;//综合评语
	public int getIssue() {
		return issue;
	}
	public void setIssue(int issue) {
		this.issue = issue;
	}
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	public int getAllScore() {
		return allScore;
	}
	public void setAllScore(int allScore) {
		this.allScore = allScore;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getScoreByPeople() {
		return scoreByPeople;
	}
	public void setScoreByPeople(int scoreByPeople) {
		this.scoreByPeople = scoreByPeople;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public MyJxVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyJxVo(int issue, String levelName, int allScore, int score, int scoreByPeople, String comment) {
		super();
		this.issue = issue;
		this.levelName = levelName;
		this.allScore = allScore;
		this.score = score;
		this.scoreByPeople = scoreByPeople;
		this.comment = comment;
	}
	
}
