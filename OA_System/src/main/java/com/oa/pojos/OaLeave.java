package com.oa.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the oa_leave database table.
 * 
 */
@Entity
@Table(name="oa_leave")
@NamedQuery(name="OaLeave.findAll", query="SELECT o FROM OaLeave o")
public class OaLeave implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="lea_id")

	private String leaId;

	@Temporal(TemporalType.DATE)
	@Column(name="lea_applydate")
	private Date leaApplydate;

	@Column(name="lea_content")
	private String leaContent;

	@Column(name="lea_day")
	private int leaDay;

	@Column(name="lea_deptch")
	private int leaDeptch;

	@Column(name="lea_emch")
	private int leaEmch;

	@Temporal(TemporalType.DATE)
	@Column(name="lea_enddate")
	private Date leaEnddate;

	@Column(name="lea_managech")
	private int leaManagech;

	@Column(name="lea_name")
	private String leaName;


	@Temporal(TemporalType.DATE)
	@Column(name="lea_startdate")
	private Date leaStartdate;

	@Column(name="lea_state")
	private int leaState;

	//bi-directional many-to-one association to OaEmp
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="emp_id")
	private OaEmp oaEmp;

	//bi-directional many-to-one association to OaVacation
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="vac_id")
	private OaVacation oaVacation;

	public OaLeave() {
	}


	public String getLeaId() {
		return this.leaId;
	}

	public void setLeaId(String leaId) {
		this.leaId = leaId;
	}

	public Date getLeaApplydate() {
		return this.leaApplydate;
	}

	public void setLeaApplydate(Date leaApplydate) {
		this.leaApplydate = leaApplydate;
	}

	public String getLeaContent() {
		return this.leaContent;
	}

	public void setLeaContent(String leaContent) {
		this.leaContent = leaContent;
	}

	public int getLeaDay() {
		return this.leaDay;
	}

	public void setLeaDay(int leaDay) {
		this.leaDay = leaDay;
	}

	public int getLeaDeptch() {
		return this.leaDeptch;
	}

	public void setLeaDeptch(int leaDeptch) {
		this.leaDeptch = leaDeptch;
	}

	public int getLeaEmch() {
		return this.leaEmch;
	}

	public void setLeaEmch(int leaEmch) {
		this.leaEmch = leaEmch;
	}

	public Date getLeaEnddate() {
		return this.leaEnddate;
	}

	public void setLeaEnddate(Date leaEnddate) {
		this.leaEnddate = leaEnddate;
	}

	public int getLeaManagech() {
		return this.leaManagech;
	}

	public void setLeaManagech(int leaManagech) {
		this.leaManagech = leaManagech;


	public String getLeaName() {
		return this.leaName;
	}

	public void setLeaName(String leaName) {
		this.leaName = leaName;
	}

	public Date getLeaStartdate() {
		return this.leaStartdate;
	}

	public void setLeaStartdate(Date leaStartdate) {
		this.leaStartdate = leaStartdate;
	}

	public int getLeaState() {
		return this.leaState;
	}

	public void setLeaState(int leaState) {
		this.leaState = leaState;
	}

	public OaEmp getOaEmp() {
		return this.oaEmp;
	}

	public void setOaEmp(OaEmp oaEmp) {
		this.oaEmp = oaEmp;
	}

	public OaVacation getOaVacation() {
		return this.oaVacation;
	}

	public void setOaVacation(OaVacation oaVacation) {
		this.oaVacation = oaVacation;
	}

}