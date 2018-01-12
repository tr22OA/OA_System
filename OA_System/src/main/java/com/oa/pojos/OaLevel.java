package com.oa.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the oa_level database table.
 * 
 */
@Entity
@Table(name="oa_level")
@NamedQuery(name="OaLevel.findAll", query="SELECT o FROM OaLevel o")
public class OaLevel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="le_id")
	private String leId;

	@Column(name="le_maxscore")
	private int leMaxscore;

	@Column(name="le_minscore")
	private int leMinscore;

	@Column(name="le_name")
	private String leName;

	@Column(name="le_state")
	private int leState;

	@Column(name="le_sx")
	private int leSx;

	//bi-directional many-to-one association to OaPertemp
	@OneToMany(mappedBy="oaLevel")
	private List<OaPertemp> oaPertemps;

	public OaLevel() {
	}

	public String getLeId() {
		return this.leId;
	}

	public void setLeId(String leId) {
		this.leId = leId;
	}

	public int getLeMaxscore() {
		return this.leMaxscore;
	}

	public void setLeMaxscore(int leMaxscore) {
		this.leMaxscore = leMaxscore;
	}

	public int getLeMinscore() {
		return this.leMinscore;
	}

	public void setLeMinscore(int leMinscore) {
		this.leMinscore = leMinscore;
	}

	public String getLeName() {
		return this.leName;
	}

	public void setLeName(String leName) {
		this.leName = leName;
	}

	public int getLeState() {
		return this.leState;
	}

	public void setLeState(int leState) {
		this.leState = leState;
	}

	public int getLeSx() {
		return this.leSx;
	}

	public void setLeSx(int leSx) {
		this.leSx = leSx;
	}

	public List<OaPertemp> getOaPertemps() {
		return this.oaPertemps;
	}

	public void setOaPertemps(List<OaPertemp> oaPertemps) {
		this.oaPertemps = oaPertemps;
	}

	public OaPertemp addOaPertemp(OaPertemp oaPertemp) {
		getOaPertemps().add(oaPertemp);
		oaPertemp.setOaLevel(this);

		return oaPertemp;
	}

	public OaPertemp removeOaPertemp(OaPertemp oaPertemp) {
		getOaPertemps().remove(oaPertemp);
		oaPertemp.setOaLevel(null);

		return oaPertemp;
	}

}