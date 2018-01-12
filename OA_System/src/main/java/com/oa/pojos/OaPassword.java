package com.oa.pojos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the oa_password database table.
 * 
 */
@Entity
@Table(name="oa_password")
@NamedQuery(name="OaPassword.findAll", query="SELECT o FROM OaPassword o")
public class OaPassword implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="emp_id")
	private String empId;

	@Column(name="pa_pass")
	private String paPass;

	//bi-directional one-to-one association to OaEmp
	

	public OaPassword() {
	}

	public String getEmpId() {
		return this.empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getPaPass() {
		return this.paPass;
	}

	public void setPaPass(String paPass) {
		this.paPass = paPass;
	}

}