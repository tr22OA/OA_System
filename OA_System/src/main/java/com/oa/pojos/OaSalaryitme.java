package com.oa.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the oa_salaryitme database table.
 * 
 */
@Entity
@Table(name="oa_salaryitme")
@NamedQuery(name="OaSalaryitme.findAll", query="SELECT o FROM OaSalaryitme o")
public class OaSalaryitme implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="pay_standardid")
	private String payStandardid;

	@Column(name="pay_standardname")
	private String payStandardname;

	@Column(name="pay_standardstatus")
	private String payStandardstatus;

	@Column(name="pay_standardtype")
	private String payStandardtype;

	@Column(name="pay_standardvalue")
	private String payStandardvalue;

	//bi-directional many-to-many association to OaEmp
	@ManyToMany(mappedBy="oaSalaryitmes")
	private List<OaEmp> oaEmps;

	public OaSalaryitme() {
	}

	public String getPayStandardid() {
		return this.payStandardid;
	}

	public void setPayStandardid(String payStandardid) {
		this.payStandardid = payStandardid;
	}

	public String getPayStandardname() {
		return this.payStandardname;
	}

	public void setPayStandardname(String payStandardname) {
		this.payStandardname = payStandardname;
	}

	public String getPayStandardstatus() {
		return this.payStandardstatus;
	}

	public void setPayStandardstatus(String payStandardstatus) {
		this.payStandardstatus = payStandardstatus;
	}

	public String getPayStandardtype() {
		return this.payStandardtype;
	}

	public void setPayStandardtype(String payStandardtype) {
		this.payStandardtype = payStandardtype;
	}

	public String getPayStandardvalue() {
		return this.payStandardvalue;
	}

	public void setPayStandardvalue(String payStandardvalue) {
		this.payStandardvalue = payStandardvalue;
	}

	public List<OaEmp> getOaEmps() {
		return this.oaEmps;
	}

	public void setOaEmps(List<OaEmp> oaEmps) {
		this.oaEmps = oaEmps;
	}

}