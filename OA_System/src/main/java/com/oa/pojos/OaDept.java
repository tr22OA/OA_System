package com.oa.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the oa_dept database table.
 * 
 */
@Entity
@Table(name="oa_dept")
@NamedQuery(name="OaDept.findAll", query="SELECT o FROM OaDept o")
public class OaDept implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="dept_id")
	private String deptId;

	@Column(name="dept_name")
	private String deptName;

	//bi-directional many-to-one association to OaEmp
	@OneToMany(mappedBy="oaDept")
	private List<OaEmp> oaEmps;

	//bi-directional many-to-many association to OaMenu
	@ManyToMany(mappedBy="oaDepts")
	private List<OaMenu> oaMenus;

	//bi-directional many-to-one association to OaMove
	@OneToMany(mappedBy="oaDept")
	private List<OaMove> oaMoves;

	public OaDept() {
	}

	public String getDeptId() {
		return this.deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<OaEmp> getOaEmps() {
		return this.oaEmps;
	}

	public void setOaEmps(List<OaEmp> oaEmps) {
		this.oaEmps = oaEmps;
	}

	public OaEmp addOaEmp(OaEmp oaEmp) {
		getOaEmps().add(oaEmp);
		oaEmp.setOaDept(this);

		return oaEmp;
	}

	public OaEmp removeOaEmp(OaEmp oaEmp) {
		getOaEmps().remove(oaEmp);
		oaEmp.setOaDept(null);

		return oaEmp;
	}

	public List<OaMenu> getOaMenus() {
		return this.oaMenus;
	}

	public void setOaMenus(List<OaMenu> oaMenus) {
		this.oaMenus = oaMenus;
	}

	public List<OaMove> getOaMoves() {
		return this.oaMoves;
	}

	public void setOaMoves(List<OaMove> oaMoves) {
		this.oaMoves = oaMoves;
	}

	public OaMove addOaMove(OaMove oaMove) {
		getOaMoves().add(oaMove);
		oaMove.setOaDept(this);

		return oaMove;
	}

	public OaMove removeOaMove(OaMove oaMove) {
		getOaMoves().remove(oaMove);
		oaMove.setOaDept(null);

		return oaMove;
	}

}