package com.oa.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the oa_schedule database table.
 * 
 */
@Entity
@Table(name="oa_schedule")
@NamedQuery(name="OaSchedule.findAll", query="SELECT o FROM OaSchedule o")
public class OaSchedule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="sch_id")
	private String schId;

	@Temporal(TemporalType.DATE)
	@Column(name="sch_date")
	private Date schDate;

	@Column(name="sch_timeslot")
	private int schTimeslot;

	//bi-directional many-to-one association to OaSchedulecontent
	@ManyToOne
	@JoinColumn(name="con_cid")
	private OaSchedulecontent oaSchedulecontent;

	//bi-directional many-to-one association to OaEmp
	@ManyToOne
	@JoinColumn(name="emp_id")
	private OaEmp oaEmp;

	public OaSchedule() {
	}

	public String getSchId() {
		return this.schId;
	}

	public void setSchId(String schId) {
		this.schId = schId;
	}

	public Date getSchDate() {
		return this.schDate;
	}

	public void setSchDate(Date schDate) {
		this.schDate = schDate;
	}

	public int getSchTimeslot() {
		return this.schTimeslot;
	}

	public void setSchTimeslot(int schTimeslot) {
		this.schTimeslot = schTimeslot;
	}

	public OaSchedulecontent getOaSchedulecontent() {
		return this.oaSchedulecontent;
	}

	public void setOaSchedulecontent(OaSchedulecontent oaSchedulecontent) {
		this.oaSchedulecontent = oaSchedulecontent;
	}

	public OaEmp getOaEmp() {
		return this.oaEmp;
	}

	public void setOaEmp(OaEmp oaEmp) {
		this.oaEmp = oaEmp;
	}

}