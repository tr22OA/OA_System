package com.oa.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the oa_attendance database table.
 * 
 */
@Entity
@Table(name="oa_attendance")
@NamedQuery(name="OaAttendance.findAll", query="SELECT o FROM OaAttendance o")
public class OaAttendance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="att_id")
	private String attId;

	@Temporal(TemporalType.DATE)
	@Column(name="att_date")
	private Date attDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="att_signin")
	private Date attSignin;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="att_signout")
	private Date attSignout;

	@Column(name="att_state")
	private int attState;

	//bi-directional many-to-one association to OaEmp
	@ManyToOne
	@JoinColumn(name="emp_id")
	private OaEmp oaEmp;

	public OaAttendance() {
	}

	public String getAttId() {
		return this.attId;
	}

	public void setAttId(String attId) {
		this.attId = attId;
	}

	public Date getAttDate() {
		return this.attDate;
	}

	public void setAttDate(Date attDate) {
		this.attDate = attDate;
	}

	public Date getAttSignin() {
		return this.attSignin;
	}

	public void setAttSignin(Date attSignin) {
		this.attSignin = attSignin;
	}

	public Date getAttSignout() {
		return this.attSignout;
	}

	public void setAttSignout(Date attSignout) {
		this.attSignout = attSignout;
	}

	public int getAttState() {
		return this.attState;
	}

	public void setAttState(int attState) {
		this.attState = attState;
	}

	public OaEmp getOaEmp() {
		return this.oaEmp;
	}

	public void setOaEmp(OaEmp oaEmp) {
		this.oaEmp = oaEmp;
	}

}