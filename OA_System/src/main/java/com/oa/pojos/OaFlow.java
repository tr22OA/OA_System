package com.oa.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the oa_flow database table.
 * 
 */
@Entity
@Table(name="oa_flow")
@NamedQuery(name="OaFlow.findAll", query="SELECT o FROM OaFlow o")
public class OaFlow implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="flow_id")
	private String flowId;

	@Temporal(TemporalType.DATE)
	@Column(name="flow_date")
	private Date flowDate;

	@Temporal(TemporalType.DATE)
	@Column(name="flow_enddate")
	private Date flowEnddate;

	@Column(name="flow_name")
	private String flowName;

	@Temporal(TemporalType.DATE)
	@Column(name="flow_startdate")
	private Date flowStartdate;

	@Column(name="flow_state")
	private int flowState;

	@Column(name="flow_step")
	private String flowStep;

	@Column(name="flow_title")
	private String flowTitle;

	//bi-directional many-to-one association to OaEmp
	@ManyToOne
	@JoinColumn(name="emp_id")
	private OaEmp oaEmp;

	//bi-directional many-to-one association to OaTurn
	@OneToMany(mappedBy="oaFlow")
	private List<OaTurn> oaTurns;

	public OaFlow() {
	}

	public String getFlowId() {
		return this.flowId;
	}

	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}

	public Date getFlowDate() {
		return this.flowDate;
	}

	public void setFlowDate(Date flowDate) {
		this.flowDate = flowDate;
	}

	public Date getFlowEnddate() {
		return this.flowEnddate;
	}

	public void setFlowEnddate(Date flowEnddate) {
		this.flowEnddate = flowEnddate;
	}

	public String getFlowName() {
		return this.flowName;
	}

	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}

	public Date getFlowStartdate() {
		return this.flowStartdate;
	}

	public void setFlowStartdate(Date flowStartdate) {
		this.flowStartdate = flowStartdate;
	}

	public int getFlowState() {
		return this.flowState;
	}

	public void setFlowState(int flowState) {
		this.flowState = flowState;
	}

	public String getFlowStep() {
		return this.flowStep;
	}

	public void setFlowStep(String flowStep) {
		this.flowStep = flowStep;
	}

	public String getFlowTitle() {
		return this.flowTitle;
	}

	public void setFlowTitle(String flowTitle) {
		this.flowTitle = flowTitle;
	}

	public OaEmp getOaEmp() {
		return this.oaEmp;
	}

	public void setOaEmp(OaEmp oaEmp) {
		this.oaEmp = oaEmp;
	}

	public List<OaTurn> getOaTurns() {
		return this.oaTurns;
	}

	public void setOaTurns(List<OaTurn> oaTurns) {
		this.oaTurns = oaTurns;
	}

	public OaTurn addOaTurn(OaTurn oaTurn) {
		getOaTurns().add(oaTurn);
		oaTurn.setOaFlow(this);

		return oaTurn;
	}

	public OaTurn removeOaTurn(OaTurn oaTurn) {
		getOaTurns().remove(oaTurn);
		oaTurn.setOaFlow(null);

		return oaTurn;
	}

}