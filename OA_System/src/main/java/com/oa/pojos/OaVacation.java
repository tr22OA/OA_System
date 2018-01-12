package com.oa.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the oa_vacation database table.
 * 
 */
@Entity
@Table(name="oa_vacation")
@NamedQuery(name="OaVacation.findAll", query="SELECT o FROM OaVacation o")
public class OaVacation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="vac_id")
	private String vacId;

	@Column(name="vac_check")
	private int vacCheck;

	@Column(name="vac_name")
	private String vacName;

	@Column(name="vac_number")
	private int vacNumber;

	//bi-directional many-to-one association to OaLeave
	@OneToMany(mappedBy="oaVacation")
	private List<OaLeave> oaLeaves;

	public OaVacation() {
	}

	public String getVacId() {
		return this.vacId;
	}

	public void setVacId(String vacId) {
		this.vacId = vacId;
	}

	public int getVacCheck() {
		return this.vacCheck;
	}

	public void setVacCheck(int vacCheck) {
		this.vacCheck = vacCheck;
	}

	public String getVacName() {
		return this.vacName;
	}

	public void setVacName(String vacName) {
		this.vacName = vacName;
	}

	public int getVacNumber() {
		return this.vacNumber;
	}

	public void setVacNumber(int vacNumber) {
		this.vacNumber = vacNumber;
	}

	public List<OaLeave> getOaLeaves() {
		return this.oaLeaves;
	}

	public void setOaLeaves(List<OaLeave> oaLeaves) {
		this.oaLeaves = oaLeaves;
	}

	public OaLeave addOaLeave(OaLeave oaLeave) {
		getOaLeaves().add(oaLeave);
		oaLeave.setOaVacation(this);

		return oaLeave;
	}

	public OaLeave removeOaLeave(OaLeave oaLeave) {
		getOaLeaves().remove(oaLeave);
		oaLeave.setOaVacation(null);

		return oaLeave;
	}

}