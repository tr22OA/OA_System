package com.oa.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the oa_overtimecode database table.
 * 
 */
@Entity
@Table(name="oa_overtimecode")
@NamedQuery(name="OaOvertimecode.findAll", query="SELECT o FROM OaOvertimecode o")
public class OaOvertimecode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="code_id")
	private String codeId;

	@Temporal(TemporalType.DATE)
	@Column(name="code_date")
	private Date codeDate;

	@Column(name="code_long")
	private int codeLong;

	//bi-directional many-to-one association to OaEmp
	@ManyToOne
	@JoinColumn(name="emp_id")
	private OaEmp oaEmp;

	//bi-directional many-to-one association to OaOvertimetype
	@ManyToOne
	@JoinColumn(name="type_id")
	private OaOvertimetype oaOvertimetype;

	public OaOvertimecode() {
	}

	public String getCodeId() {
		return this.codeId;
	}

	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}

	public Date getCodeDate() {
		return this.codeDate;
	}

	public void setCodeDate(Date codeDate) {
		this.codeDate = codeDate;
	}

	public int getCodeLong() {
		return this.codeLong;
	}

	public void setCodeLong(int codeLong) {
		this.codeLong = codeLong;
	}

	public OaEmp getOaEmp() {
		return this.oaEmp;
	}

	public void setOaEmp(OaEmp oaEmp) {
		this.oaEmp = oaEmp;
	}

	public OaOvertimetype getOaOvertimetype() {
		return this.oaOvertimetype;
	}

	public void setOaOvertimetype(OaOvertimetype oaOvertimetype) {
		this.oaOvertimetype = oaOvertimetype;
	}

}