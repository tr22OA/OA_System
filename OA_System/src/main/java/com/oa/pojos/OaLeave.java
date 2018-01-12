package com.oa.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the oa_leave database table.
 * 
 */
@Entity
@Table(name="oa_leave")
@NamedQuery(name="OaLeave.findAll", query="SELECT o FROM OaLeave o")
public class OaLeave implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="lea_id")
	private int leaId;

	@Temporal(TemporalType.DATE)
	@Column(name="apply_date")
	private Date applyDate;

	private String dept;

	@Column(name="dept_approve")
	private String deptApprove;

	@Column(name="dept_approve_person")
	private String deptApprovePerson;

	@Temporal(TemporalType.DATE)
	private Date enddate;

	@Column(name="lea_content")
	private String leaContent;

	@Column(name="lea_day")
	private int leaDay;

	@Column(name="lea_name")
	private String leaName;

	@Column(name="lea_type")
	private String leaType;

	@Column(name="manager_approve")
	private String managerApprove;

	@Column(name="person_file")
	private String personFile;

	private String position;

	@Column(name="position_approve_person")
	private String positionApprovePerson;

	@Temporal(TemporalType.DATE)
	private Date startdate;

	public OaLeave() {
	}

	public int getLeaId() {
		return this.leaId;
	}

	public void setLeaId(int leaId) {
		this.leaId = leaId;
	}

	public Date getApplyDate() {
		return this.applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public String getDept() {
		return this.dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getDeptApprove() {
		return this.deptApprove;
	}

	public void setDeptApprove(String deptApprove) {
		this.deptApprove = deptApprove;
	}

	public String getDeptApprovePerson() {
		return this.deptApprovePerson;
	}

	public void setDeptApprovePerson(String deptApprovePerson) {
		this.deptApprovePerson = deptApprovePerson;
	}

	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getLeaContent() {
		return this.leaContent;
	}

	public void setLeaContent(String leaContent) {
		this.leaContent = leaContent;
	}

	public int getLeaDay() {
		return this.leaDay;
	}

	public void setLeaDay(int leaDay) {
		this.leaDay = leaDay;
	}

	public String getLeaName() {
		return this.leaName;
	}

	public void setLeaName(String leaName) {
		this.leaName = leaName;
	}

	public String getLeaType() {
		return this.leaType;
	}

	public void setLeaType(String leaType) {
		this.leaType = leaType;
	}

	public String getManagerApprove() {
		return this.managerApprove;
	}

	public void setManagerApprove(String managerApprove) {
		this.managerApprove = managerApprove;
	}

	public String getPersonFile() {
		return this.personFile;
	}

	public void setPersonFile(String personFile) {
		this.personFile = personFile;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPositionApprovePerson() {
		return this.positionApprovePerson;
	}

	public void setPositionApprovePerson(String positionApprovePerson) {
		this.positionApprovePerson = positionApprovePerson;
	}

	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

}