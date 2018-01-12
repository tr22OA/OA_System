package com.oa.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the oa_rap database table.
 * 
 */
@Entity
@Table(name="oa_rap")
@NamedQuery(name="OaRap.findAll", query="SELECT o FROM OaRap o")
public class OaRap implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="rap_id")
	private String rapId;

	@Column(name="rap_content")
	private String rapContent;

	@Temporal(TemporalType.DATE)
	@Column(name="rap_date")
	private Date rapDate;

	@Column(name="rap_dept")
	private int rapDept;

	@Column(name="rap_emch")
	private int rapEmch;

	@Column(name="rap_manage")
	private int rapManage;

	@Column(name="rap_money")
	private int rapMoney;

	@Column(name="rap_pro")
	private String rapPro;

	@Column(name="rap_state")
	private int rapState;

	@Column(name="rap_type")
	private int rapType;

	//bi-directional many-to-one association to OaEmp
	@ManyToOne
	@JoinColumn(name="raper_id")
	private OaEmp oaEmp1;

	//bi-directional many-to-one association to OaEmp
	@ManyToOne
	@JoinColumn(name="apply_id")
	private OaEmp oaEmp2;

	public OaRap() {
	}

	public String getRapId() {
		return this.rapId;
	}

	public void setRapId(String rapId) {
		this.rapId = rapId;
	}

	public String getRapContent() {
		return this.rapContent;
	}

	public void setRapContent(String rapContent) {
		this.rapContent = rapContent;
	}

	public Date getRapDate() {
		return this.rapDate;
	}

	public void setRapDate(Date rapDate) {
		this.rapDate = rapDate;
	}

	public int getRapDept() {
		return this.rapDept;
	}

	public void setRapDept(int rapDept) {
		this.rapDept = rapDept;
	}

	public int getRapEmch() {
		return this.rapEmch;
	}

	public void setRapEmch(int rapEmch) {
		this.rapEmch = rapEmch;
	}

	public int getRapManage() {
		return this.rapManage;
	}

	public void setRapManage(int rapManage) {
		this.rapManage = rapManage;
	}

	public int getRapMoney() {
		return this.rapMoney;
	}

	public void setRapMoney(int rapMoney) {
		this.rapMoney = rapMoney;
	}

	public String getRapPro() {
		return this.rapPro;
	}

	public void setRapPro(String rapPro) {
		this.rapPro = rapPro;
	}

	public int getRapState() {
		return this.rapState;
	}

	public void setRapState(int rapState) {
		this.rapState = rapState;
	}

	public int getRapType() {
		return this.rapType;
	}

	public void setRapType(int rapType) {
		this.rapType = rapType;
	}

	public OaEmp getOaEmp1() {
		return this.oaEmp1;
	}

	public void setOaEmp1(OaEmp oaEmp1) {
		this.oaEmp1 = oaEmp1;
	}

	public OaEmp getOaEmp2() {
		return this.oaEmp2;
	}

	public void setOaEmp2(OaEmp oaEmp2) {
		this.oaEmp2 = oaEmp2;
	}

}