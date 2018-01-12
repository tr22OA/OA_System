package com.oa.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the oa_contract database table.
 * 
 */
@Entity
@Table(name="oa_contract")
@NamedQuery(name="OaContract.findAll", query="SELECT o FROM OaContract o")
public class OaContract implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="con_id")
	private String conId;

	@Temporal(TemporalType.DATE)
	@Column(name="con_begindate")
	private Date conBegindate;

	@Column(name="con_enc")
	private String conEnc;

	@Temporal(TemporalType.DATE)
	@Column(name="con_enddate")
	private Date conEnddate;

	@Column(name="con_remark")
	private String conRemark;

	@Temporal(TemporalType.DATE)
	@Column(name="con_signdate")
	private Date conSigndate;

	@Column(name="con_signtime")
	private int conSigntime;

	@Column(name="con_state")
	private int conState;

	@Temporal(TemporalType.DATE)
	@Column(name="con_stopdate")
	private Date conStopdate;

	@Column(name="con_term")
	private int conTerm;

	@Temporal(TemporalType.DATE)
	@Column(name="con_tryend")
	private Date conTryend;

	@Column(name="con_type")
	private int conType;

	//bi-directional many-to-one association to OaEmp
	@ManyToOne
	@JoinColumn(name="emp_id")
	private OaEmp oaEmp;

	public OaContract() {
	}

	public String getConId() {
		return this.conId;
	}

	public void setConId(String conId) {
		this.conId = conId;
	}

	public Date getConBegindate() {
		return this.conBegindate;
	}

	public void setConBegindate(Date conBegindate) {
		this.conBegindate = conBegindate;
	}

	public String getConEnc() {
		return this.conEnc;
	}

	public void setConEnc(String conEnc) {
		this.conEnc = conEnc;
	}

	public Date getConEnddate() {
		return this.conEnddate;
	}

	public void setConEnddate(Date conEnddate) {
		this.conEnddate = conEnddate;
	}

	public String getConRemark() {
		return this.conRemark;
	}

	public void setConRemark(String conRemark) {
		this.conRemark = conRemark;
	}

	public Date getConSigndate() {
		return this.conSigndate;
	}

	public void setConSigndate(Date conSigndate) {
		this.conSigndate = conSigndate;
	}

	public int getConSigntime() {
		return this.conSigntime;
	}

	public void setConSigntime(int conSigntime) {
		this.conSigntime = conSigntime;
	}

	public int getConState() {
		return this.conState;
	}

	public void setConState(int conState) {
		this.conState = conState;
	}

	public Date getConStopdate() {
		return this.conStopdate;
	}

	public void setConStopdate(Date conStopdate) {
		this.conStopdate = conStopdate;
	}

	public int getConTerm() {
		return this.conTerm;
	}

	public void setConTerm(int conTerm) {
		this.conTerm = conTerm;
	}

	public Date getConTryend() {
		return this.conTryend;
	}

	public void setConTryend(Date conTryend) {
		this.conTryend = conTryend;
	}

	public int getConType() {
		return this.conType;
	}

	public void setConType(int conType) {
		this.conType = conType;
	}

	public OaEmp getOaEmp() {
		return this.oaEmp;
	}

	public void setOaEmp(OaEmp oaEmp) {
		this.oaEmp = oaEmp;
	}

}