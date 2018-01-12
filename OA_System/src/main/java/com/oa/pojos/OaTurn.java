package com.oa.pojos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the oa_turn database table.
 * 
 */
@Entity
@Table(name="oa_turn")
@NamedQuery(name="OaTurn.findAll", query="SELECT o FROM OaTurn o")
public class OaTurn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="turn_id")
	private String turnId;

	@Column(name="turn_state")
	private int turnState;

	//bi-directional many-to-one association to OaFlow
	@ManyToOne
	@JoinColumn(name="flow_id")
	private OaFlow oaFlow;

	public OaTurn() {
	}

	public String getTurnId() {
		return this.turnId;
	}

	public void setTurnId(String turnId) {
		this.turnId = turnId;
	}

	public int getTurnState() {
		return this.turnState;
	}

	public void setTurnState(int turnState) {
		this.turnState = turnState;
	}

	public OaFlow getOaFlow() {
		return this.oaFlow;
	}

	public void setOaFlow(OaFlow oaFlow) {
		this.oaFlow = oaFlow;
	}

}