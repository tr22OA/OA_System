package com.oa.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the oa_salaryrecord database table.
 * 
 */
@Entity
@Table(name="oa_salaryrecord")
@NamedQuery(name="OaSalaryrecord.findAll", query="SELECT o FROM OaSalaryrecord o")
public class OaSalaryrecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="pay_id")
	private String payId;

	@Column(name="pay_money")
	private BigDecimal payMoney;

	@Column(name="pay_remark")
	private String payRemark;

	@Temporal(TemporalType.DATE)
	@Column(name="pay_senddate")
	private Date paySenddate;

	//bi-directional many-to-one association to OaEmp
	@ManyToOne
	@JoinColumn(name="emp_id")
	private OaEmp oaEmp;

	public OaSalaryrecord() {
	}

	public String getPayId() {
		return this.payId;
	}

	public void setPayId(String payId) {
		this.payId = payId;
	}

	public BigDecimal getPayMoney() {
		return this.payMoney;
	}

	public void setPayMoney(BigDecimal payMoney) {
		this.payMoney = payMoney;
	}

	public String getPayRemark() {
		return this.payRemark;
	}

	public void setPayRemark(String payRemark) {
		this.payRemark = payRemark;
	}

	public Date getPaySenddate() {
		return this.paySenddate;
	}

	public void setPaySenddate(Date paySenddate) {
		this.paySenddate = paySenddate;
	}

	public OaEmp getOaEmp() {
		return this.oaEmp;
	}

	public void setOaEmp(OaEmp oaEmp) {
		this.oaEmp = oaEmp;
	}

}