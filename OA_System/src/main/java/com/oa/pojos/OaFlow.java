package com.oa.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


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
	private int flowId;

	@Column(name="emp_name")
	private String empName;

	@Temporal(TemporalType.DATE)
	@Column(name="flow_date")
	private Date flowDate;

	@Column(name="flow_name")
	private String flowName;

	@Column(name="flow_state")
	private int flowState;

	@Column(name="flow_step")
	private int flowStep;

	@Column(name="flow_title")
	private String flowTitle;

	@Column(name="flow_type")
	private int flowType;

	@Column(name="turn_state")
	private int turnState;

	public OaFlow() {
	}

	public int getFlowId() {
		return this.flowId;
	}

	public void setFlowId(int flowId) {
		this.flowId = flowId;
	}

	public String getEmpName() {
		return this.empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Date getFlowDate() {
		return this.flowDate;
	}

	public void setFlowDate(Date flowDate) {
		this.flowDate = flowDate;
	}

	public String getFlowName() {
		return this.flowName;
	}

	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}

	public int getFlowState() {
		return this.flowState;
	}

	public void setFlowState(int flowState) {
		this.flowState = flowState;
	}

	public int getFlowStep() {
		return this.flowStep;
	}

	public void setFlowStep(int flowStep) {
		this.flowStep = flowStep;
	}

	public String getFlowTitle() {
		return this.flowTitle;
	}

	public void setFlowTitle(String flowTitle) {
		this.flowTitle = flowTitle;
	}

	public int getFlowType() {
		return this.flowType;
	}

	public void setFlowType(int flowType) {
		this.flowType = flowType;
	}

	public int getTurnState() {
		return this.turnState;
	}

	public void setTurnState(int turnState) {
		this.turnState = turnState;
	}

	public OaFlow(int flowId, String empName, Date flowDate, String flowName, int flowState, int flowStep,
			String flowTitle, int flowType, int turnState) {
		super();
		this.flowId = flowId;
		this.empName = empName;
		this.flowDate = flowDate;
		this.flowName = flowName;
		this.flowState = flowState;
		this.flowStep = flowStep;
		this.flowTitle = flowTitle;
		this.flowType = flowType;
		this.turnState = turnState;
	}
	
	

}