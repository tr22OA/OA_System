package com.oa.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the oa_formal database table.
 * 
 */
@Entity
@Table(name="oa_formal")
@NamedQuery(name="OaFormal.findAll", query="SELECT o FROM OaFormal o")
public class OaFormal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="for_id")
	private String forId;

	@Temporal(TemporalType.DATE)
	@Column(name="for_applydate")
	private Date forApplydate;

	@Temporal(TemporalType.DATE)
	@Column(name="for_date")
	private Date forDate;

	@Column(name="for_emch")
	private int forEmch;

	@Temporal(TemporalType.DATE)
	@Column(name="for_inworkdate")
	private Date forInworkdate;

	@Column(name="for_leaderch")
	private int forLeaderch;

	@Column(name="for_remark")
	private String forRemark;

	@Column(name="for_state")
	private int forState;

	@Temporal(TemporalType.DATE)
	@Column(name="for_tryend")
	private Date forTryend;

	//bi-directional many-to-one association to OaEmp
	@ManyToOne
	@JoinColumn(name="emp_id")
	private OaEmp oaEmp;

	public OaFormal() {
	}

	public String getForId() {
		return this.forId;
	}

	public void setForId(String forId) {
		this.forId = forId;
	}

	public Date getForApplydate() {
		return this.forApplydate;
	}

	public void setForApplydate(Date forApplydate) {
		this.forApplydate = forApplydate;
	}

	public Date getForDate() {
		return this.forDate;
	}

	public void setForDate(Date forDate) {
		this.forDate = forDate;
	}

	public int getForEmch() {
		return this.forEmch;
	}

	public void setForEmch(int forEmch) {
		this.forEmch = forEmch;
	}

	public Date getForInworkdate() {
		return this.forInworkdate;
	}

	public void setForInworkdate(Date forInworkdate) {
		this.forInworkdate = forInworkdate;
	}

	public int getForLeaderch() {
		return this.forLeaderch;
	}

	public void setForLeaderch(int forLeaderch) {
		this.forLeaderch = forLeaderch;
	}

	public String getForRemark() {
		return this.forRemark;
	}

	public void setForRemark(String forRemark) {
		this.forRemark = forRemark;
	}

	public int getForState() {
		return this.forState;
	}

	public void setForState(int forState) {
		this.forState = forState;
	}

	public Date getForTryend() {
		return this.forTryend;
	}

	public void setForTryend(Date forTryend) {
		this.forTryend = forTryend;
	}

	public OaEmp getOaEmp() {
		return this.oaEmp;
	}

	public void setOaEmp(OaEmp oaEmp) {
		this.oaEmp = oaEmp;
	}

}