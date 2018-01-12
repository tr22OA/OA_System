package com.oa.pojos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the oa_personalbook database table.
 * 
 */
@Entity
@Table(name="oa_personalbook")
@NamedQuery(name="OaPersonalbook.findAll", query="SELECT o FROM OaPersonalbook o")
public class OaPersonalbook implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="per_id")
	private String perId;

	@Column(name="per_company")
	private String perCompany;

	@Column(name="per_emial")
	private String perEmial;

	@Column(name="per_fax")
	private String perFax;

	@Column(name="per_job")
	private String perJob;

	@Column(name="per_name")
	private String perName;

	@Column(name="per_phone")
	private String perPhone;

	@Column(name="per_residencetel")
	private String perResidencetel;

	@Column(name="per_tel")
	private String perTel;

	//bi-directional many-to-one association to OaEmp
	@ManyToOne
	@JoinColumn(name="emp_id")
	private OaEmp oaEmp;

	//bi-directional many-to-one association to OaTelgroup
	@ManyToOne
	@JoinColumn(name="group_id")
	private OaTelgroup oaTelgroup;

	public OaPersonalbook() {
	}

	public String getPerId() {
		return this.perId;
	}

	public void setPerId(String perId) {
		this.perId = perId;
	}

	public String getPerCompany() {
		return this.perCompany;
	}

	public void setPerCompany(String perCompany) {
		this.perCompany = perCompany;
	}

	public String getPerEmial() {
		return this.perEmial;
	}

	public void setPerEmial(String perEmial) {
		this.perEmial = perEmial;
	}

	public String getPerFax() {
		return this.perFax;
	}

	public void setPerFax(String perFax) {
		this.perFax = perFax;
	}

	public String getPerJob() {
		return this.perJob;
	}

	public void setPerJob(String perJob) {
		this.perJob = perJob;
	}

	public String getPerName() {
		return this.perName;
	}

	public void setPerName(String perName) {
		this.perName = perName;
	}

	public String getPerPhone() {
		return this.perPhone;
	}

	public void setPerPhone(String perPhone) {
		this.perPhone = perPhone;
	}

	public String getPerResidencetel() {
		return this.perResidencetel;
	}

	public void setPerResidencetel(String perResidencetel) {
		this.perResidencetel = perResidencetel;
	}

	public String getPerTel() {
		return this.perTel;
	}

	public void setPerTel(String perTel) {
		this.perTel = perTel;
	}

	public OaEmp getOaEmp() {
		return this.oaEmp;
	}

	public void setOaEmp(OaEmp oaEmp) {
		this.oaEmp = oaEmp;
	}

	public OaTelgroup getOaTelgroup() {
		return this.oaTelgroup;
	}

	public void setOaTelgroup(OaTelgroup oaTelgroup) {
		this.oaTelgroup = oaTelgroup;
	}

}