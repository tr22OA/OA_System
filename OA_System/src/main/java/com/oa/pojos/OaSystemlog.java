package com.oa.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the oa_systemlog database table.
 * 
 */
@Entity
@Table(name="oa_systemlog")
@NamedQuery(name="OaSystemlog.findAll", query="SELECT o FROM OaSystemlog o")
public class OaSystemlog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="log_id")
	private int logId;

	private String log_IP;

	@Column(name="log_option")
	private String logOption;

	@Temporal(TemporalType.DATE)
	private Date log_sysTime;

	//bi-directional many-to-one association to OaEmp
	@ManyToOne
	@JoinColumn(name="emp_id")
	private OaEmp oaEmp;

	public OaSystemlog() {
	}

	public int getLogId() {
		return this.logId;
	}

	public void setLogId(int logId) {
		this.logId = logId;
	}

	public String getLog_IP() {
		return this.log_IP;
	}

	public void setLog_IP(String log_IP) {
		this.log_IP = log_IP;
	}

	public String getLogOption() {
		return this.logOption;
	}

	public void setLogOption(String logOption) {
		this.logOption = logOption;
	}

	public Date getLog_sysTime() {
		return this.log_sysTime;
	}

	public void setLog_sysTime(Date log_sysTime) {
		this.log_sysTime = log_sysTime;
	}

	public OaEmp getOaEmp() {
		return this.oaEmp;
	}

	public void setOaEmp(OaEmp oaEmp) {
		this.oaEmp = oaEmp;
	}

}