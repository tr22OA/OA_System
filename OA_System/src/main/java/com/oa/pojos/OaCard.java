package com.oa.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the oa_card database table.
 * 
 */
@Entity
@Table(name="oa_card")
@NamedQuery(name="OaCard.findAll", query="SELECT o FROM OaCard o")
public class OaCard implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="card_id")
	private String cardId;

	@Column(name="card_enc")
	private String cardEnc;

	@Column(name="card_org")
	private String cardOrg;

	@Temporal(TemporalType.DATE)
	@Column(name="card_overdate")
	private Date cardOverdate;

	@Column(name="card_rewark")
	private String cardRewark;

	@Temporal(TemporalType.DATE)
	@Column(name="card_takedate")
	private Date cardTakedate;

	@Temporal(TemporalType.DATE)
	@Column(name="card_workdate")
	private Date cardWorkdate;

	//bi-directional many-to-one association to OaEmp
	@ManyToOne
	@JoinColumn(name="emp_id")
	private OaEmp oaEmp;

	//bi-directional many-to-one association to OaCardborrow
	@OneToMany(mappedBy="oaCard")
	private List<OaCardborrow> oaCardborrows;

	public OaCard() {
	}

	public String getCardId() {
		return this.cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getCardEnc() {
		return this.cardEnc;
	}

	public void setCardEnc(String cardEnc) {
		this.cardEnc = cardEnc;
	}

	public String getCardOrg() {
		return this.cardOrg;
	}

	public void setCardOrg(String cardOrg) {
		this.cardOrg = cardOrg;
	}

	public Date getCardOverdate() {
		return this.cardOverdate;
	}

	public void setCardOverdate(Date cardOverdate) {
		this.cardOverdate = cardOverdate;
	}

	public String getCardRewark() {
		return this.cardRewark;
	}

	public void setCardRewark(String cardRewark) {
		this.cardRewark = cardRewark;
	}

	public Date getCardTakedate() {
		return this.cardTakedate;
	}

	public void setCardTakedate(Date cardTakedate) {
		this.cardTakedate = cardTakedate;
	}

	public Date getCardWorkdate() {
		return this.cardWorkdate;
	}

	public void setCardWorkdate(Date cardWorkdate) {
		this.cardWorkdate = cardWorkdate;
	}

	public OaEmp getOaEmp() {
		return this.oaEmp;
	}

	public void setOaEmp(OaEmp oaEmp) {
		this.oaEmp = oaEmp;
	}

	public List<OaCardborrow> getOaCardborrows() {
		return this.oaCardborrows;
	}

	public void setOaCardborrows(List<OaCardborrow> oaCardborrows) {
		this.oaCardborrows = oaCardborrows;
	}

	public OaCardborrow addOaCardborrow(OaCardborrow oaCardborrow) {
		getOaCardborrows().add(oaCardborrow);
		oaCardborrow.setOaCard(this);

		return oaCardborrow;
	}

	public OaCardborrow removeOaCardborrow(OaCardborrow oaCardborrow) {
		getOaCardborrows().remove(oaCardborrow);
		oaCardborrow.setOaCard(null);

		return oaCardborrow;
	}

}