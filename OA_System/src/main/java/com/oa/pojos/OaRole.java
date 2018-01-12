package com.oa.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the oa_role database table.
 * 
 */
@Entity
@Table(name="oa_role")
@NamedQuery(name="OaRole.findAll", query="SELECT o FROM OaRole o")
public class OaRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="role_id")
	private int roleId;

	@Column(name="dept_id")
	private String deptId;

	@Column(name="role_name")
	private String roleName;

	//bi-directional many-to-many association to OaEmp
	@ManyToMany
	@JoinTable(
		name="oa_role_emp"
		, joinColumns={
			@JoinColumn(name="role_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="emp_id")
			}
		)
	private List<OaEmp> oaEmps;

	//bi-directional many-to-many association to OaMenu
	@ManyToMany
	@JoinTable(
		name="oa_role_menu"
		, joinColumns={
			@JoinColumn(name="role_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="menu_id")
			}
		)
	private List<OaMenu> oaMenus;

	public OaRole() {
	}

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getDeptId() {
		return this.deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<OaEmp> getOaEmps() {
		return this.oaEmps;
	}

	public void setOaEmps(List<OaEmp> oaEmps) {
		this.oaEmps = oaEmps;
	}

	public List<OaMenu> getOaMenus() {
		return this.oaMenus;
	}

	public void setOaMenus(List<OaMenu> oaMenus) {
		this.oaMenus = oaMenus;
	}

}