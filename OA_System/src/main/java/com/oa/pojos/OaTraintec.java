package com.oa.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the oa_traintec database table.
 * 
 */
@Entity
@Table(name="oa_traintec")
@NamedQuery(name="OaTraintec.findAll", query="SELECT o FROM OaTraintec o")
public class OaTraintec implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tec_id")
	private String tecId;

	@Column(name="tec_address")
	private String tecAddress;

	@Column(name="tec_email")
	private String tecEmail;

	@Column(name="tec_enc")
	private String tecEnc;

	@Column(name="tec_inner")
	private String tecInner;

	@Temporal(TemporalType.DATE)
	@Column(name="tec_innerdate")
	private Date tecInnerdate;

	@Column(name="tec_name")
	private String tecName;

	@Column(name="tec_out")
	private String tecOut;

	@Temporal(TemporalType.DATE)
	@Column(name="tec_outdate")
	private Date tecOutdate;

	@Column(name="tec_phone")
	private String tecPhone;

	@Column(name="tec_post")
	private String tecPost;

	@Column(name="tec_remark")
	private String tecRemark;

	@Column(name="tec_state")
	private int tecState;

	@Column(name="tec_type")
	private int tecType;

	//bi-directional many-to-one association to OaTrainplan
	@OneToMany(mappedBy="oaTraintec")
	private List<OaTrainplan> oaTrainplans;

	public OaTraintec() {
	}

	public String getTecId() {
		return this.tecId;
	}

	public void setTecId(String tecId) {
		this.tecId = tecId;
	}

	public String getTecAddress() {
		return this.tecAddress;
	}

	public void setTecAddress(String tecAddress) {
		this.tecAddress = tecAddress;
	}

	public String getTecEmail() {
		return this.tecEmail;
	}

	public void setTecEmail(String tecEmail) {
		this.tecEmail = tecEmail;
	}

	public String getTecEnc() {
		return this.tecEnc;
	}

	public void setTecEnc(String tecEnc) {
		this.tecEnc = tecEnc;
	}

	public String getTecInner() {
		return this.tecInner;
	}

	public void setTecInner(String tecInner) {
		this.tecInner = tecInner;
	}

	public Date getTecInnerdate() {
		return this.tecInnerdate;
	}

	public void setTecInnerdate(Date tecInnerdate) {
		this.tecInnerdate = tecInnerdate;
	}

	public String getTecName() {
		return this.tecName;
	}

	public void setTecName(String tecName) {
		this.tecName = tecName;
	}

	public String getTecOut() {
		return this.tecOut;
	}

	public void setTecOut(String tecOut) {
		this.tecOut = tecOut;
	}

	public Date getTecOutdate() {
		return this.tecOutdate;
	}

	public void setTecOutdate(Date tecOutdate) {
		this.tecOutdate = tecOutdate;
	}

	public String getTecPhone() {
		return this.tecPhone;
	}

	public void setTecPhone(String tecPhone) {
		this.tecPhone = tecPhone;
	}

	public String getTecPost() {
		return this.tecPost;
	}

	public void setTecPost(String tecPost) {
		this.tecPost = tecPost;
	}

	public String getTecRemark() {
		return this.tecRemark;
	}

	public void setTecRemark(String tecRemark) {
		this.tecRemark = tecRemark;
	}

	public int getTecState() {
		return this.tecState;
	}

	public void setTecState(int tecState) {
		this.tecState = tecState;
	}

	public int getTecType() {
		return this.tecType;
	}

	public void setTecType(int tecType) {
		this.tecType = tecType;
	}

	public List<OaTrainplan> getOaTrainplans() {
		return this.oaTrainplans;
	}

	public void setOaTrainplans(List<OaTrainplan> oaTrainplans) {
		this.oaTrainplans = oaTrainplans;
	}

	public OaTrainplan addOaTrainplan(OaTrainplan oaTrainplan) {
		getOaTrainplans().add(oaTrainplan);
		oaTrainplan.setOaTraintec(this);

		return oaTrainplan;
	}

	public OaTrainplan removeOaTrainplan(OaTrainplan oaTrainplan) {
		getOaTrainplans().remove(oaTrainplan);
		oaTrainplan.setOaTraintec(null);

		return oaTrainplan;
	}

}