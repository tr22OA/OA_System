package com.oa.vo.hq;
//绩效查询实体
public class FindJxVo {
	private String name;//考核人员
	private int issue;//期次
	private String levelName;//考核等级
	private int allScore;//总评分
	private int projectScore;//项目得分
	private String comment;//综合评语
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
	public int getProjectScore() {
		return projectScore;
	}
	public void setProjectScore(int projectScore) {
		this.projectScore = projectScore;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public FindJxVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FindJxVo(String name, int issue, String levelName, int allScore, int projectScore, String comment) {
		super();
		this.name = name;
		this.issue = issue;
		this.levelName = levelName;
		this.allScore = allScore;
		this.projectScore = projectScore;
		this.comment = comment;
	}
	
}
