package com.oa.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the oa_move database table.
 * 
 */
@Entity
@Table(name="oa_move")
@NamedQuery(name="OaMove.findAll", query="SELECT o FROM OaMove o")
public class OaMove implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="move_id")
	private String moveId;

	private String befordept;

	private String beforjob;

	@Temporal(TemporalType.DATE)
	@Column(name="move_date")
	private Date moveDate;

	@Temporal(TemporalType.DATE)
	@Column(name="move_effdate")
	private Date moveEffdate;

	@Column(name="move_emch")
	private int moveEmch;

	@Column(name="move_enc")
	private String moveEnc;

	@Column(name="move_newch")
	private int moveNewch;

	@Column(name="move_oldch")
	private int moveOldch;

	@Column(name="move_remark")
	private String moveRemark;

	@Column(name="move_state")
	private int moveState;

	@Column(name="move_type")
	private int moveType;

	//bi-directional many-to-one association to OaEmp
	@ManyToOne
	@JoinColumn(name="emp_id")
	private OaEmp oaEmp;

	//bi-directional many-to-one association to OaDept
	@ManyToOne
	@JoinColumn(name="dept_id")
	private OaDept oaDept;

	//bi-directional many-to-one association to OaJob
	@ManyToOne
	@JoinColumn(name="job_id")
	private OaJob oaJob;

	public OaMove() {
	}

	public String getMoveId() {
		return this.moveId;
	}

	public void setMoveId(String moveId) {
		this.moveId = moveId;
	}

	public String getBefordept() {
		return this.befordept;
	}

	public void setBefordept(String befordept) {
		this.befordept = befordept;
	}

	public String getBeforjob() {
		return this.beforjob;
	}

	public void setBeforjob(String beforjob) {
		this.beforjob = beforjob;
	}

	public Date getMoveDate() {
		return this.moveDate;
	}

	public void setMoveDate(Date moveDate) {
		this.moveDate = moveDate;
	}

	public Date getMoveEffdate() {
		return this.moveEffdate;
	}

	public void setMoveEffdate(Date moveEffdate) {
		this.moveEffdate = moveEffdate;
	}

	public int getMoveEmch() {
		return this.moveEmch;
	}

	public void setMoveEmch(int moveEmch) {
		this.moveEmch = moveEmch;
	}

	public String getMoveEnc() {
		return this.moveEnc;
	}

	public void setMoveEnc(String moveEnc) {
		this.moveEnc = moveEnc;
	}

	public int getMoveNewch() {
		return this.moveNewch;
	}

	public void setMoveNewch(int moveNewch) {
		this.moveNewch = moveNewch;
	}

	public int getMoveOldch() {
		return this.moveOldch;
	}

	public void setMoveOldch(int moveOldch) {
		this.moveOldch = moveOldch;
	}

	public String getMoveRemark() {
		return this.moveRemark;
	}

	public void setMoveRemark(String moveRemark) {
		this.moveRemark = moveRemark;
	}

	public int getMoveState() {
		return this.moveState;
	}

	public void setMoveState(int moveState) {
		this.moveState = moveState;
	}

	public int getMoveType() {
		return this.moveType;
	}

	public void setMoveType(int moveType) {
		this.moveType = moveType;
	}

	public OaEmp getOaEmp() {
		return this.oaEmp;
	}

	public void setOaEmp(OaEmp oaEmp) {
		this.oaEmp = oaEmp;
	}

	public OaDept getOaDept() {
		return this.oaDept;
	}

	public void setOaDept(OaDept oaDept) {
		this.oaDept = oaDept;
	}

	public OaJob getOaJob() {
		return this.oaJob;
	}

	public void setOaJob(OaJob oaJob) {
		this.oaJob = oaJob;
	}

}