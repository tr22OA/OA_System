package com.oa.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the oa_dismission database table.
 * 
 */
@Entity
@Table(name="oa_dismission")
@NamedQuery(name="OaDismission.findAll", query="SELECT o FROM OaDismission o")
public class OaDismission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="dis_id")
	private String disId;

	@Temporal(TemporalType.DATE)
	@Column(name="dis_applydate")
	private Date disApplydate;

	@Temporal(TemporalType.DATE)
	@Column(name="dis_date")
	private Date disDate;

	@Column(name="dis_emch")
	private int disEmch;

	@Column(name="dis_enc")
	private String disEnc;

	@Temporal(TemporalType.DATE)
	@Column(name="dis_inworkdate")
	private Date disInworkdate;

	@Column(name="dis_leaderch")
	private int disLeaderch;

	@Column(name="dis_reason")
	private String disReason;

	@Column(name="dis_remark")
	private String disRemark;

	@Column(name="dis_state")
	private int disState;

	@Column(name="dis_type")
	private int disType;

	//bi-directional many-to-one association to OaEmp
	@ManyToOne
	@JoinColumn(name="emp_id")
	private OaEmp oaEmp;

	public OaDismission() {
	}

	public String getDisId() {
		return this.disId;
	}

	public void setDisId(String disId) {
		this.disId = disId;
	}

	public Date getDisApplydate() {
		return this.disApplydate;
	}

	public void setDisApplydate(Date disApplydate) {
		this.disApplydate = disApplydate;
	}

	public Date getDisDate() {
		return this.disDate;
	}

	public void setDisDate(Date disDate) {
		this.disDate = disDate;
	}

	public int getDisEmch() {
		return this.disEmch;
	}

	public void setDisEmch(int disEmch) {
		this.disEmch = disEmch;
	}

	public String getDisEnc() {
		return this.disEnc;
	}

	public void setDisEnc(String disEnc) {
		this.disEnc = disEnc;
	}

	public Date getDisInworkdate() {
		return this.disInworkdate;
	}

	public void setDisInworkdate(Date disInworkdate) {
		this.disInworkdate = disInworkdate;
	}

	public int getDisLeaderch() {
		return this.disLeaderch;
	}

	public void setDisLeaderch(int disLeaderch) {
		this.disLeaderch = disLeaderch;
	}

	public String getDisReason() {
		return this.disReason;
	}

	public void setDisReason(String disReason) {
		this.disReason = disReason;
	}

	public String getDisRemark() {
		return this.disRemark;
	}

	public void setDisRemark(String disRemark) {
		this.disRemark = disRemark;
	}

	public int getDisState() {
		return this.disState;
	}

	public void setDisState(int disState) {
		this.disState = disState;
	}

	public int getDisType() {
		return this.disType;
	}

	public void setDisType(int disType) {
		this.disType = disType;
	}

	public OaEmp getOaEmp() {
		return this.oaEmp;
	}

	public void setOaEmp(OaEmp oaEmp) {
		this.oaEmp = oaEmp;
	}

}