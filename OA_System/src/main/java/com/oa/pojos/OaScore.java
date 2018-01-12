package com.oa.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the oa_score database table.
 * 
 */
@Entity
@Table(name="oa_score")
@NamedQuery(name="OaScore.findAll", query="SELECT o FROM OaScore o")
public class OaScore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="score_id")
	private String scoreId;

	@Column(name="score_content")
	private String scoreContent;

	@Column(name="score_score")
	private int scoreScore;

	@Column(name="score_state")
	private int scoreState;

	//bi-directional many-to-one association to OaEmp
	@ManyToOne
	@JoinColumn(name="emp_id")
	private OaEmp oaEmp1;

	//bi-directional many-to-one association to OaExamtask
	@ManyToOne
	@JoinColumn(name="et_id")
	private OaExamtask oaExamtask;

	//bi-directional many-to-one association to OaEmp
	@ManyToOne
	@JoinColumn(name="score_emp_id")
	private OaEmp oaEmp2;

	//bi-directional many-to-one association to OaScoredetail
	@OneToMany(mappedBy="oaScore")
	private List<OaScoredetail> oaScoredetails;

	public OaScore() {
	}

	public String getScoreId() {
		return this.scoreId;
	}

	public void setScoreId(String scoreId) {
		this.scoreId = scoreId;
	}

	public String getScoreContent() {
		return this.scoreContent;
	}

	public void setScoreContent(String scoreContent) {
		this.scoreContent = scoreContent;
	}

	public int getScoreScore() {
		return this.scoreScore;
	}

	public void setScoreScore(int scoreScore) {
		this.scoreScore = scoreScore;
	}

	public int getScoreState() {
		return this.scoreState;
	}

	public void setScoreState(int scoreState) {
		this.scoreState = scoreState;
	}

	public OaEmp getOaEmp1() {
		return this.oaEmp1;
	}

	public void setOaEmp1(OaEmp oaEmp1) {
		this.oaEmp1 = oaEmp1;
	}

	public OaExamtask getOaExamtask() {
		return this.oaExamtask;
	}

	public void setOaExamtask(OaExamtask oaExamtask) {
		this.oaExamtask = oaExamtask;
	}

	public OaEmp getOaEmp2() {
		return this.oaEmp2;
	}

	public void setOaEmp2(OaEmp oaEmp2) {
		this.oaEmp2 = oaEmp2;
	}

	public List<OaScoredetail> getOaScoredetails() {
		return this.oaScoredetails;
	}

	public void setOaScoredetails(List<OaScoredetail> oaScoredetails) {
		this.oaScoredetails = oaScoredetails;
	}

	public OaScoredetail addOaScoredetail(OaScoredetail oaScoredetail) {
		getOaScoredetails().add(oaScoredetail);
		oaScoredetail.setOaScore(this);

		return oaScoredetail;
	}

	public OaScoredetail removeOaScoredetail(OaScoredetail oaScoredetail) {
		getOaScoredetails().remove(oaScoredetail);
		oaScoredetail.setOaScore(null);

		return oaScoredetail;
	}

}