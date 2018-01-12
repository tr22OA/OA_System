package com.oa.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the oa_examtask database table.
 * 
 */
@Entity
@Table(name="oa_examtask")
@NamedQuery(name="OaExamtask.findAll", query="SELECT o FROM OaExamtask o")
public class OaExamtask implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="et_id")
	private String etId;

	@Temporal(TemporalType.DATE)
	@Column(name="et_enddate")
	private Date etEnddate;

	@Column(name="et_fb_state")
	private String etFbState;

	@Column(name="et_issue")
	private int etIssue;

	@Column(name="et_name")
	private String etName;

	@Column(name="et_remark")
	private String etRemark;

	@Temporal(TemporalType.DATE)
	@Column(name="et_startdate")
	private Date etStartdate;

	@Column(name="et_state")
	private int etState;

	@Column(name="et_year")
	private int etYear;

	//bi-directional many-to-one association to OaPertemp
	@ManyToOne
	@JoinColumn(name="pt_id")
	private OaPertemp oaPertemp;

	//bi-directional many-to-one association to OaScore
	@OneToMany(mappedBy="oaExamtask")
	private List<OaScore> oaScores;

	public OaExamtask() {
	}

	public String getEtId() {
		return this.etId;
	}

	public void setEtId(String etId) {
		this.etId = etId;
	}

	public Date getEtEnddate() {
		return this.etEnddate;
	}

	public void setEtEnddate(Date etEnddate) {
		this.etEnddate = etEnddate;
	}

	public String getEtFbState() {
		return this.etFbState;
	}

	public void setEtFbState(String etFbState) {
		this.etFbState = etFbState;
	}

	public int getEtIssue() {
		return this.etIssue;
	}

	public void setEtIssue(int etIssue) {
		this.etIssue = etIssue;
	}

	public String getEtName() {
		return this.etName;
	}

	public void setEtName(String etName) {
		this.etName = etName;
	}

	public String getEtRemark() {
		return this.etRemark;
	}

	public void setEtRemark(String etRemark) {
		this.etRemark = etRemark;
	}

	public Date getEtStartdate() {
		return this.etStartdate;
	}

	public void setEtStartdate(Date etStartdate) {
		this.etStartdate = etStartdate;
	}

	public int getEtState() {
		return this.etState;
	}

	public void setEtState(int etState) {
		this.etState = etState;
	}

	public int getEtYear() {
		return this.etYear;
	}

	public void setEtYear(int etYear) {
		this.etYear = etYear;
	}

	public OaPertemp getOaPertemp() {
		return this.oaPertemp;
	}

	public void setOaPertemp(OaPertemp oaPertemp) {
		this.oaPertemp = oaPertemp;
	}

	public List<OaScore> getOaScores() {
		return this.oaScores;
	}

	public void setOaScores(List<OaScore> oaScores) {
		this.oaScores = oaScores;
	}

	public OaScore addOaScore(OaScore oaScore) {
		getOaScores().add(oaScore);
		oaScore.setOaExamtask(this);

		return oaScore;
	}

	public OaScore removeOaScore(OaScore oaScore) {
		getOaScores().remove(oaScore);
		oaScore.setOaExamtask(null);

		return oaScore;
	}

}