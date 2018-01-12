package com.oa.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the oa_scheduletype database table.
 * 
 */
@Entity
@Table(name="oa_scheduletype")
@NamedQuery(name="OaScheduletype.findAll", query="SELECT o FROM OaScheduletype o")
public class OaScheduletype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="sht_id")
	private String shtId;

	@Column(name="sht_name")
	private String shtName;

	@Column(name="sht_remark")
	private String shtRemark;

	@Column(name="sht_status")
	private int shtStatus;

	@Column(name="sht_w1")
	private int shtW1;

	@Column(name="sht_w2")
	private int shtW2;

	@Column(name="sht_w3")
	private int shtW3;

	@Column(name="sht_w4")
	private int shtW4;

	@Column(name="sht_w5")
	private int shtW5;

	@Column(name="sht_w6")
	private int shtW6;

	@Column(name="sht_w7")
	private int shtW7;

	//bi-directional many-to-many association to OaEmp
	@ManyToMany
	@JoinTable(
		name="emp_paiban"
		, joinColumns={
			@JoinColumn(name="sht_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="emp_id")
			}
		)
	private List<OaEmp> oaEmps;

	public OaScheduletype() {
	}

	public String getShtId() {
		return this.shtId;
	}

	public void setShtId(String shtId) {
		this.shtId = shtId;
	}

	public String getShtName() {
		return this.shtName;
	}

	public void setShtName(String shtName) {
		this.shtName = shtName;
	}

	public String getShtRemark() {
		return this.shtRemark;
	}

	public void setShtRemark(String shtRemark) {
		this.shtRemark = shtRemark;
	}

	public int getShtStatus() {
		return this.shtStatus;
	}

	public void setShtStatus(int shtStatus) {
		this.shtStatus = shtStatus;
	}

	public int getShtW1() {
		return this.shtW1;
	}

	public void setShtW1(int shtW1) {
		this.shtW1 = shtW1;
	}

	public int getShtW2() {
		return this.shtW2;
	}

	public void setShtW2(int shtW2) {
		this.shtW2 = shtW2;
	}

	public int getShtW3() {
		return this.shtW3;
	}

	public void setShtW3(int shtW3) {
		this.shtW3 = shtW3;
	}

	public int getShtW4() {
		return this.shtW4;
	}

	public void setShtW4(int shtW4) {
		this.shtW4 = shtW4;
	}

	public int getShtW5() {
		return this.shtW5;
	}

	public void setShtW5(int shtW5) {
		this.shtW5 = shtW5;
	}

	public int getShtW6() {
		return this.shtW6;
	}

	public void setShtW6(int shtW6) {
		this.shtW6 = shtW6;
	}

	public int getShtW7() {
		return this.shtW7;
	}

	public void setShtW7(int shtW7) {
		this.shtW7 = shtW7;
	}

	public List<OaEmp> getOaEmps() {
		return this.oaEmps;
	}

	public void setOaEmps(List<OaEmp> oaEmps) {
		this.oaEmps = oaEmps;
	}

}