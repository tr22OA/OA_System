package com.oa.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the oa_whereabouts database table.
 * 
 */
@Entity
@Table(name="oa_whereabouts")
@NamedQuery(name="OaWhereabout.findAll", query="SELECT o FROM OaWhereabout o")
public class OaWhereabout implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="whe_id")
	private String wheId;

	@Column(name="whe_about")
	private String wheAbout;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="whe_end")
	private Date wheEnd;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="whe_start")
	private Date wheStart;

	@Column(name="whe_state")
	private int wheState;

	//bi-directional many-to-one association to OaEmp
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="emp_id")
	private OaEmp oaEmp;

	public OaWhereabout() {
	}

	public String getWheId() {
		return this.wheId;
	}

	public void setWheId(String wheId) {
		this.wheId = wheId;
	}

	public String getWheAbout() {
		return this.wheAbout;
	}

	public void setWheAbout(String wheAbout) {
		this.wheAbout = wheAbout;
	}

	public Date getWheEnd() {
		return this.wheEnd;
	}

	public void setWheEnd(Date wheEnd) {
		this.wheEnd = wheEnd;
	}

	public Date getWheStart() {
		return this.wheStart;
	}

	public void setWheStart(Date wheStart) {
		this.wheStart = wheStart;
	}

	public int getWheState() {
		return this.wheState;
	}

	public void setWheState(int wheState) {
		this.wheState = wheState;
	}

	public OaEmp getOaEmp() {
		return this.oaEmp;
	}

	public void setOaEmp(OaEmp oaEmp) {
		this.oaEmp = oaEmp;
	}

}