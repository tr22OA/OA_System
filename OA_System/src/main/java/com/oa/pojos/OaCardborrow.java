package com.oa.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the oa_cardborrow database table.
 * 
 */
@Entity
@Table(name="oa_cardborrow")
@NamedQuery(name="OaCardborrow.findAll", query="SELECT o FROM OaCardborrow o")
public class OaCardborrow implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cb_id")
	private String cbId;

	@Temporal(TemporalType.DATE)
	@Column(name="cb_bdate")
	private Date cbBdate;

	@Temporal(TemporalType.DATE)
	@Column(name="cb_rdate")
	private Date cbRdate;

	@Column(name="cb_reason")
	private String cbReason;

	//bi-directional many-to-one association to OaEmp
	@ManyToOne
	@JoinColumn(name="emp_id")
	private OaEmp oaEmp;

	//bi-directional many-to-one association to OaCard
	@ManyToOne
	@JoinColumn(name="card_id")
	private OaCard oaCard;

	public OaCardborrow() {
	}

	public String getCbId() {
		return this.cbId;
	}

	public void setCbId(String cbId) {
		this.cbId = cbId;
	}

	public Date getCbBdate() {
		return this.cbBdate;
	}

	public void setCbBdate(Date cbBdate) {
		this.cbBdate = cbBdate;
	}

	public Date getCbRdate() {
		return this.cbRdate;
	}

	public void setCbRdate(Date cbRdate) {
		this.cbRdate = cbRdate;
	}

	public String getCbReason() {
		return this.cbReason;
	}

	public void setCbReason(String cbReason) {
		this.cbReason = cbReason;
	}

	public OaEmp getOaEmp() {
		return this.oaEmp;
	}

	public void setOaEmp(OaEmp oaEmp) {
		this.oaEmp = oaEmp;
	}

	public OaCard getOaCard() {
		return this.oaCard;
	}

	public void setOaCard(OaCard oaCard) {
		this.oaCard = oaCard;
	}

}