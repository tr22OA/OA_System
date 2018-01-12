package com.oa.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the oa_salarytype database table.
 * 
 */
@Entity
@Table(name="oa_salarytype")
@NamedQuery(name="OaSalarytype.findAll", query="SELECT o FROM OaSalarytype o")
public class OaSalarytype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="pay_salarytypeid")
	private String paySalarytypeid;

	@Temporal(TemporalType.DATE)
	@Column(name="pay_salarytypecreatedate")
	private Date paySalarytypecreatedate;

	@Column(name="pay_salarytypename")
	private String paySalarytypename;

	@Column(name="pay_salarytyperemark")
	private String paySalarytyperemark;

	@Column(name="pay_salarytypestatus")
	private String paySalarytypestatus;

	//bi-directional many-to-many association to OaEmp
	@ManyToMany
	@JoinTable(
		name="oa_salaryselect"
		, joinColumns={
			@JoinColumn(name="pay_salarytypeid")
			}
		, inverseJoinColumns={
			@JoinColumn(name="pay_salarytypeemp")
			}
		)
	private List<OaEmp> oaEmps;

	//bi-directional many-to-one association to OaEmp
	@ManyToOne
	@JoinColumn(name="pay_salarytypecreaterid")
	private OaEmp oaEmp;

	public OaSalarytype() {
	}

	public String getPaySalarytypeid() {
		return this.paySalarytypeid;
	}

	public void setPaySalarytypeid(String paySalarytypeid) {
		this.paySalarytypeid = paySalarytypeid;
	}

	public Date getPaySalarytypecreatedate() {
		return this.paySalarytypecreatedate;
	}

	public void setPaySalarytypecreatedate(Date paySalarytypecreatedate) {
		this.paySalarytypecreatedate = paySalarytypecreatedate;
	}

	public String getPaySalarytypename() {
		return this.paySalarytypename;
	}

	public void setPaySalarytypename(String paySalarytypename) {
		this.paySalarytypename = paySalarytypename;
	}

	public String getPaySalarytyperemark() {
		return this.paySalarytyperemark;
	}

	public void setPaySalarytyperemark(String paySalarytyperemark) {
		this.paySalarytyperemark = paySalarytyperemark;
	}

	public String getPaySalarytypestatus() {
		return this.paySalarytypestatus;
	}

	public void setPaySalarytypestatus(String paySalarytypestatus) {
		this.paySalarytypestatus = paySalarytypestatus;
	}

	public List<OaEmp> getOaEmps() {
		return this.oaEmps;
	}

	public void setOaEmps(List<OaEmp> oaEmps) {
		this.oaEmps = oaEmps;
	}

	public OaEmp getOaEmp() {
		return this.oaEmp;
	}

	public void setOaEmp(OaEmp oaEmp) {
		this.oaEmp = oaEmp;
	}

}