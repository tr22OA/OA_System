package com.oa.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the oa_schedulecontent database table.
 * 
 */
@Entity
@Table(name="oa_schedulecontent")
@NamedQuery(name="OaSchedulecontent.findAll", query="SELECT o FROM OaSchedulecontent o")
public class OaSchedulecontent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="con_cid")
	private String conCid;

	@Column(name="con_content")
	private String conContent;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="con_endtime")
	private Date conEndtime;

	@Column(name="con_reminding")
	private int conReminding;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="con_remindtime")
	private Date conRemindtime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="con_starttime")
	private Date conStarttime;

	@Column(name="con_type")
	private int conType;

	//bi-directional many-to-one association to OaSchedule
	@OneToMany(mappedBy="oaSchedulecontent")
	private List<OaSchedule> oaSchedules;

	public OaSchedulecontent() {
	}

	public String getConCid() {
		return this.conCid;
	}

	public void setConCid(String conCid) {
		this.conCid = conCid;
	}

	public String getConContent() {
		return this.conContent;
	}

	public void setConContent(String conContent) {
		this.conContent = conContent;
	}

	public Date getConEndtime() {
		return this.conEndtime;
	}

	public void setConEndtime(Date conEndtime) {
		this.conEndtime = conEndtime;
	}

	public int getConReminding() {
		return this.conReminding;
	}

	public void setConReminding(int conReminding) {
		this.conReminding = conReminding;
	}

	public Date getConRemindtime() {
		return this.conRemindtime;
	}

	public void setConRemindtime(Date conRemindtime) {
		this.conRemindtime = conRemindtime;
	}

	public Date getConStarttime() {
		return this.conStarttime;
	}

	public void setConStarttime(Date conStarttime) {
		this.conStarttime = conStarttime;
	}

	public int getConType() {
		return this.conType;
	}

	public void setConType(int conType) {
		this.conType = conType;
	}

	public List<OaSchedule> getOaSchedules() {
		return this.oaSchedules;
	}

	public void setOaSchedules(List<OaSchedule> oaSchedules) {
		this.oaSchedules = oaSchedules;
	}

	public OaSchedule addOaSchedule(OaSchedule oaSchedule) {
		getOaSchedules().add(oaSchedule);
		oaSchedule.setOaSchedulecontent(this);

		return oaSchedule;
	}

	public OaSchedule removeOaSchedule(OaSchedule oaSchedule) {
		getOaSchedules().remove(oaSchedule);
		oaSchedule.setOaSchedulecontent(null);

		return oaSchedule;
	}

}