package com.oa.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the oa_overtimetype database table.
 * 
 */
@Entity
@Table(name="oa_overtimetype")
@NamedQuery(name="OaOvertimetype.findAll", query="SELECT o FROM OaOvertimetype o")
public class OaOvertimetype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="type_id")
	private String typeId;

	@Column(name="type_name")
	private String typeName;

	@Column(name="type_price")
	private int typePrice;

	//bi-directional many-to-one association to OaOvertimecode
	@OneToMany(mappedBy="oaOvertimetype")
	private List<OaOvertimecode> oaOvertimecodes;

	public OaOvertimetype() {
	}

	public String getTypeId() {
		return this.typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getTypePrice() {
		return this.typePrice;
	}

	public void setTypePrice(int typePrice) {
		this.typePrice = typePrice;
	}

	public List<OaOvertimecode> getOaOvertimecodes() {
		return this.oaOvertimecodes;
	}

	public void setOaOvertimecodes(List<OaOvertimecode> oaOvertimecodes) {
		this.oaOvertimecodes = oaOvertimecodes;
	}

	public OaOvertimecode addOaOvertimecode(OaOvertimecode oaOvertimecode) {
		getOaOvertimecodes().add(oaOvertimecode);
		oaOvertimecode.setOaOvertimetype(this);

		return oaOvertimecode;
	}

	public OaOvertimecode removeOaOvertimecode(OaOvertimecode oaOvertimecode) {
		getOaOvertimecodes().remove(oaOvertimecode);
		oaOvertimecode.setOaOvertimetype(null);

		return oaOvertimecode;
	}

}