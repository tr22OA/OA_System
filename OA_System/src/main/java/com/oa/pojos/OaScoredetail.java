package com.oa.pojos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the oa_scoredetail database table.
 * 
 */
@Entity
@Table(name="oa_scoredetail")
@NamedQuery(name="OaScoredetail.findAll", query="SELECT o FROM OaScoredetail o")
public class OaScoredetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="sd_id")
	private String sdId;

	@Column(name="sd_leadcon")
	private String sdLeadcon;	//领导评语

	@Column(name="sd_summary")
	private String sdSummary;	//工作总结

	//bi-directional many-to-one association to OaExamproject
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ep_id")
	private OaExamproject oaExamproject;

	//bi-directional many-to-one association to OaScore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="score_id")
	private OaScore oaScore;

	public OaScoredetail() {
	}

	public String getSdId() {
		return this.sdId;
	}

	public void setSdId(String sdId) {
		this.sdId = sdId;
	}

	public String getSdLeadcon() {
		return this.sdLeadcon;
	}

	public void setSdLeadcon(String sdLeadcon) {
		this.sdLeadcon = sdLeadcon;
	}

	public String getSdSummary() {
		return this.sdSummary;
	}

	public void setSdSummary(String sdSummary) {
		this.sdSummary = sdSummary;
	}

	public OaExamproject getOaExamproject() {
		return this.oaExamproject;
	}

	public void setOaExamproject(OaExamproject oaExamproject) {
		this.oaExamproject = oaExamproject;
	}

	public OaScore getOaScore() {
		return this.oaScore;
	}

	public void setOaScore(OaScore oaScore) {
		this.oaScore = oaScore;
	}

}