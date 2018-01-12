package com.oa.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the oa_examproject database table.
 * 
 */
@Entity
@Table(name="oa_examproject")
@NamedQuery(name="OaExamproject.findAll", query="SELECT o FROM OaExamproject o")
public class OaExamproject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ep_id")
	private String epId;

	@Column(name="ep_maxscore")
	private int epMaxscore;

	@Column(name="ep_minscore")
	private int epMinscore;

	@Column(name="ep_name")
	private String epName;

	@Column(name="ep_remark")
	private String epRemark;

	@Column(name="ep_scorerule")
	private String epScorerule;

	@Column(name="ep_stand")
	private int epStand;

	@Column(name="ep_state")
	private int epState;

	//bi-directional many-to-one association to OaPertemp
	@ManyToOne
	@JoinColumn(name="pt_id")
	private OaPertemp oaPertemp;

	//bi-directional many-to-one association to OaScoredetail
	@OneToMany(mappedBy="oaExamproject")
	private List<OaScoredetail> oaScoredetails;

	public OaExamproject() {
	}

	public String getEpId() {
		return this.epId;
	}

	public void setEpId(String epId) {
		this.epId = epId;
	}

	public int getEpMaxscore() {
		return this.epMaxscore;
	}

	public void setEpMaxscore(int epMaxscore) {
		this.epMaxscore = epMaxscore;
	}

	public int getEpMinscore() {
		return this.epMinscore;
	}

	public void setEpMinscore(int epMinscore) {
		this.epMinscore = epMinscore;
	}

	public String getEpName() {
		return this.epName;
	}

	public void setEpName(String epName) {
		this.epName = epName;
	}

	public String getEpRemark() {
		return this.epRemark;
	}

	public void setEpRemark(String epRemark) {
		this.epRemark = epRemark;
	}

	public String getEpScorerule() {
		return this.epScorerule;
	}

	public void setEpScorerule(String epScorerule) {
		this.epScorerule = epScorerule;
	}

	public int getEpStand() {
		return this.epStand;
	}

	public void setEpStand(int epStand) {
		this.epStand = epStand;
	}

	public int getEpState() {
		return this.epState;
	}

	public void setEpState(int epState) {
		this.epState = epState;
	}

	public OaPertemp getOaPertemp() {
		return this.oaPertemp;
	}

	public void setOaPertemp(OaPertemp oaPertemp) {
		this.oaPertemp = oaPertemp;
	}

	public List<OaScoredetail> getOaScoredetails() {
		return this.oaScoredetails;
	}

	public void setOaScoredetails(List<OaScoredetail> oaScoredetails) {
		this.oaScoredetails = oaScoredetails;
	}

	public OaScoredetail addOaScoredetail(OaScoredetail oaScoredetail) {
		getOaScoredetails().add(oaScoredetail);
		oaScoredetail.setOaExamproject(this);

		return oaScoredetail;
	}

	public OaScoredetail removeOaScoredetail(OaScoredetail oaScoredetail) {
		getOaScoredetails().remove(oaScoredetail);
		oaScoredetail.setOaExamproject(null);

		return oaScoredetail;
	}

}