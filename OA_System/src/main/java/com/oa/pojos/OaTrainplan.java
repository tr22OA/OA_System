package com.oa.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the oa_trainplan database table.
 * 
 */
@Entity
@Table(name="oa_trainplan")
@NamedQuery(name="OaTrainplan.findAll", query="SELECT o FROM OaTrainplan o")
public class OaTrainplan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="rp_id")
	private String rpId;

	@Column(name="rp_assess")
	private String rpAssess;

	@Temporal(TemporalType.DATE)
	@Column(name="rp_begin")
	private Date rpBegin;

	@Column(name="rp_content")
	private String rpContent;

	@Column(name="rp_day")
	private int rpDay;

	@Temporal(TemporalType.DATE)
	@Column(name="rp_end")
	private Date rpEnd;

	@Column(name="rp_host")
	private String rpHost;

	@Column(name="rp_money")
	private int rpMoney;

	@Column(name="rp_name")
	private String rpName;

	@Column(name="rp_others")
	private int rpOthers;

	@Column(name="rp_place")
	private String rpPlace;

	@Column(name="rp_remark")
	private String rpRemark;

	@Column(name="rp_state")
	private int rpState;

	@Column(name="rp_stunum")
	private int rpStunum;

	//bi-directional many-to-one association to OaEmp
	@ManyToOne
	@JoinColumn(name="emp_id")
	private OaEmp oaEmp;

	//bi-directional many-to-one association to OaTraintec
	@ManyToOne
	@JoinColumn(name="tec_id")
	private OaTraintec oaTraintec;

	//bi-directional many-to-many association to OaEmp
	@ManyToMany(mappedBy="oaTrainplans2")
	private List<OaEmp> oaEmps;

	public OaTrainplan() {
	}

	public String getRpId() {
		return this.rpId;
	}

	public void setRpId(String rpId) {
		this.rpId = rpId;
	}

	public String getRpAssess() {
		return this.rpAssess;
	}

	public void setRpAssess(String rpAssess) {
		this.rpAssess = rpAssess;
	}

	public Date getRpBegin() {
		return this.rpBegin;
	}

	public void setRpBegin(Date rpBegin) {
		this.rpBegin = rpBegin;
	}

	public String getRpContent() {
		return this.rpContent;
	}

	public void setRpContent(String rpContent) {
		this.rpContent = rpContent;
	}

	public int getRpDay() {
		return this.rpDay;
	}

	public void setRpDay(int rpDay) {
		this.rpDay = rpDay;
	}

	public Date getRpEnd() {
		return this.rpEnd;
	}

	public void setRpEnd(Date rpEnd) {
		this.rpEnd = rpEnd;
	}

	public String getRpHost() {
		return this.rpHost;
	}

	public void setRpHost(String rpHost) {
		this.rpHost = rpHost;
	}

	public int getRpMoney() {
		return this.rpMoney;
	}

	public void setRpMoney(int rpMoney) {
		this.rpMoney = rpMoney;
	}

	public String getRpName() {
		return this.rpName;
	}

	public void setRpName(String rpName) {
		this.rpName = rpName;
	}

	public int getRpOthers() {
		return this.rpOthers;
	}

	public void setRpOthers(int rpOthers) {
		this.rpOthers = rpOthers;
	}

	public String getRpPlace() {
		return this.rpPlace;
	}

	public void setRpPlace(String rpPlace) {
		this.rpPlace = rpPlace;
	}

	public String getRpRemark() {
		return this.rpRemark;
	}

	public void setRpRemark(String rpRemark) {
		this.rpRemark = rpRemark;
	}

	public int getRpState() {
		return this.rpState;
	}

	public void setRpState(int rpState) {
		this.rpState = rpState;
	}

	public int getRpStunum() {
		return this.rpStunum;
	}

	public void setRpStunum(int rpStunum) {
		this.rpStunum = rpStunum;
	}

	public OaEmp getOaEmp() {
		return this.oaEmp;
	}

	public void setOaEmp(OaEmp oaEmp) {
		this.oaEmp = oaEmp;
	}

	public OaTraintec getOaTraintec() {
		return this.oaTraintec;
	}

	public void setOaTraintec(OaTraintec oaTraintec) {
		this.oaTraintec = oaTraintec;
	}

	public List<OaEmp> getOaEmps() {
		return this.oaEmps;
	}

	public void setOaEmps(List<OaEmp> oaEmps) {
		this.oaEmps = oaEmps;
	}

}