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

	@Column(name="sd_score")
	private int sdScore;

	//bi-directional many-to-one association to OaExamproject
	@ManyToOne
	@JoinColumn(name="ep_id")
	private OaExamproject oaExamproject;

	//bi-directional many-to-one association to OaScore
	@ManyToOne
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

	public int getSdScore() {
		return this.sdScore;
	}

	public void setSdScore(int sdScore) {
		this.sdScore = sdScore;
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