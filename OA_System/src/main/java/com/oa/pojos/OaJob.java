package com.oa.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the oa_job database table.
 * 
 */
@Entity
@Table(name="oa_job")
@NamedQuery(name="OaJob.findAll", query="SELECT o FROM OaJob o")
public class OaJob implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="job_id")
	private String jobId;

	@Column(name="job_dec")
	private String jobDec;

	@Column(name="job_duty")
	private String jobDuty;

	@Column(name="job_level")
	private String jobLevel;

	@Column(name="job_name")
	private String jobName;

	@Column(name="job_require")
	private String jobRequire;

	@Column(name="job_superior")
	private String jobSuperior;

	//bi-directional many-to-one association to OaEmp
	@OneToMany(mappedBy="oaJob")
	private List<OaEmp> oaEmps;

	//bi-directional many-to-one association to OaMove
	@OneToMany(mappedBy="oaJob")
	private List<OaMove> oaMoves;

	//bi-directional many-to-one association to OaPertemp
	@OneToMany(mappedBy="oaJob")
	private List<OaPertemp> oaPertemps;

	public OaJob() {
	}

	public String getJobId() {
		return this.jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobDec() {
		return this.jobDec;
	}

	public void setJobDec(String jobDec) {
		this.jobDec = jobDec;
	}

	public String getJobDuty() {
		return this.jobDuty;
	}

	public void setJobDuty(String jobDuty) {
		this.jobDuty = jobDuty;
	}

	public String getJobLevel() {
		return this.jobLevel;
	}

	public void setJobLevel(String jobLevel) {
		this.jobLevel = jobLevel;
	}

	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobRequire() {
		return this.jobRequire;
	}

	public void setJobRequire(String jobRequire) {
		this.jobRequire = jobRequire;
	}

	public String getJobSuperior() {
		return this.jobSuperior;
	}

	public void setJobSuperior(String jobSuperior) {
		this.jobSuperior = jobSuperior;
	}

	public List<OaEmp> getOaEmps() {
		return this.oaEmps;
	}

	public void setOaEmps(List<OaEmp> oaEmps) {
		this.oaEmps = oaEmps;
	}

	public OaEmp addOaEmp(OaEmp oaEmp) {
		getOaEmps().add(oaEmp);
		oaEmp.setOaJob(this);

		return oaEmp;
	}

	public OaEmp removeOaEmp(OaEmp oaEmp) {
		getOaEmps().remove(oaEmp);
		oaEmp.setOaJob(null);

		return oaEmp;
	}

	public List<OaMove> getOaMoves() {
		return this.oaMoves;
	}

	public void setOaMoves(List<OaMove> oaMoves) {
		this.oaMoves = oaMoves;
	}

	public OaMove addOaMove(OaMove oaMove) {
		getOaMoves().add(oaMove);
		oaMove.setOaJob(this);

		return oaMove;
	}

	public OaMove removeOaMove(OaMove oaMove) {
		getOaMoves().remove(oaMove);
		oaMove.setOaJob(null);

		return oaMove;
	}

	public List<OaPertemp> getOaPertemps() {
		return this.oaPertemps;
	}

	public void setOaPertemps(List<OaPertemp> oaPertemps) {
		this.oaPertemps = oaPertemps;
	}

	public OaPertemp addOaPertemp(OaPertemp oaPertemp) {
		getOaPertemps().add(oaPertemp);
		oaPertemp.setOaJob(this);

		return oaPertemp;
	}

	public OaPertemp removeOaPertemp(OaPertemp oaPertemp) {
		getOaPertemps().remove(oaPertemp);
		oaPertemp.setOaJob(null);

		return oaPertemp;
	}

}