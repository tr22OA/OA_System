package com.oa.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the oa_telgroup database table.
 * 
 */
@Entity
@Table(name="oa_telgroup")
@NamedQuery(name="OaTelgroup.findAll", query="SELECT o FROM OaTelgroup o")
public class OaTelgroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="group_id")
	private String groupId;

	@Column(name="group_name")
	private String groupName;

	//bi-directional many-to-one association to OaPersonalbook
	@OneToMany(mappedBy="oaTelgroup")
	private List<OaPersonalbook> oaPersonalbooks;

	public OaTelgroup() {
	}

	public String getGroupId() {
		return this.groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<OaPersonalbook> getOaPersonalbooks() {
		return this.oaPersonalbooks;
	}

	public void setOaPersonalbooks(List<OaPersonalbook> oaPersonalbooks) {
		this.oaPersonalbooks = oaPersonalbooks;
	}

	public OaPersonalbook addOaPersonalbook(OaPersonalbook oaPersonalbook) {
		getOaPersonalbooks().add(oaPersonalbook);
		oaPersonalbook.setOaTelgroup(this);

		return oaPersonalbook;
	}

	public OaPersonalbook removeOaPersonalbook(OaPersonalbook oaPersonalbook) {
		getOaPersonalbooks().remove(oaPersonalbook);
		oaPersonalbook.setOaTelgroup(null);

		return oaPersonalbook;
	}

}