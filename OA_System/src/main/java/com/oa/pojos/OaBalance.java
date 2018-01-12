package com.oa.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the oa_balance database table.
 * 
 */
@Entity
@Table(name="oa_balance")
@NamedQuery(name="OaBalance.findAll", query="SELECT o FROM OaBalance o")
public class OaBalance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="bal_id")
	private String balId;

	@Temporal(TemporalType.DATE)
	@Column(name="bal_date")
	private Date balDate;

	@Column(name="bal_number")
	private int balNumber;

	@Column(name="bal_reason")
	private String balReason;

	@Column(name="bal_year")
	private String balYear;

	//bi-directional many-to-one association to OaEmp
	@ManyToOne
	@JoinColumn(name="caozuo_id")
	private OaEmp oaEmp1;

	//bi-directional many-to-one association to OaEmp
	@ManyToOne
	@JoinColumn(name="baler_id")
	private OaEmp oaEmp2;

	public OaBalance() {
	}

	public String getBalId() {
		return this.balId;
	}

	public void setBalId(String balId) {
		this.balId = balId;
	}

	public Date getBalDate() {
		return this.balDate;
	}

	public void setBalDate(Date balDate) {
		this.balDate = balDate;
	}

	public int getBalNumber() {
		return this.balNumber;
	}

	public void setBalNumber(int balNumber) {
		this.balNumber = balNumber;
	}

	public String getBalReason() {
		return this.balReason;
	}

	public void setBalReason(String balReason) {
		this.balReason = balReason;
	}

	public String getBalYear() {
		return this.balYear;
	}

	public void setBalYear(String balYear) {
		this.balYear = balYear;
	}

	public OaEmp getOaEmp1() {
		return this.oaEmp1;
	}

	public void setOaEmp1(OaEmp oaEmp1) {
		this.oaEmp1 = oaEmp1;
	}

	public OaEmp getOaEmp2() {
		return this.oaEmp2;
	}

	public void setOaEmp2(OaEmp oaEmp2) {
		this.oaEmp2 = oaEmp2;
	}

}