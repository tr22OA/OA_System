package com.oa.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the oa_emp database table.
 * 
 */
@Entity
@Table(name="oa_emp")
@NamedQuery(name="OaEmp.findAll", query="SELECT o FROM OaEmp o")
public class OaEmp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="emp_id")
	private String empId;

	@Column(name="emp_address")
	private String empAddress;

	@Column(name="emp_bank")
	private String empBank;

	@Column(name="emp_bankid")
	private String empBankid;

	@Temporal(TemporalType.DATE)
	@Column(name="emp_birth")
	private Date empBirth;

	@Column(name="emp_cardid")
	private String empCardid;

	@Temporal(TemporalType.DATE)
	@Column(name="emp_dismission")
	private Date empDismission;

	@Column(name="emp_email")
	private String empEmail;

	@Column(name="emp_eme")
	private String empEme;

	@Column(name="emp_emetel")
	private String empEmetel;

	@Temporal(TemporalType.DATE)
	@Column(name="emp_entrydate")
	private Date empEntrydate;

	@Column(name="emp_fileid")
	private String empFileid;

	@Temporal(TemporalType.DATE)
	@Column(name="emp_formaldate")
	private Date empFormaldate;

	@Temporal(TemporalType.DATE)
	@Column(name="emp_graduation")
	private Date empGraduation;

	@Column(name="emp_healthy")
	private String empHealthy;

	@Column(name="emp_high")
	private String empHigh;

	@Column(name="emp_like")
	private String empLike;

	@Column(name="emp_major")
	private String empMajor;

	@Column(name="emp_maxdegree")
	private String empMaxdegree;

	@Column(name="emp_maxeducation")
	private String empMaxeducation;

	@Column(name="emp_mgr")
	private String empMgr;

	@Column(name="emp_name")
	private String empName;

	@Column(name="emp_nation")
	private String empNation;

	@Column(name="emp_nationality")
	private String empNationality;

	@Column(name="emp_native")
	private String empNative;

	@Column(name="emp_oldname")
	private String empOldname;

	@Column(name="emp_phone")
	private String empPhone;

	@Column(name="emp_photo")
	private String empPhoto;

	@Column(name="emp_qq")
	private String empQq;

	@Column(name="emp_remark")
	private String empRemark;

	@Column(name="emp_school")
	private String empSchool;

	@Column(name="emp_sex")
	private int empSex;

	@Column(name="emp_station")
	private String empStation;

	@Column(name="emp_tel")
	private String empTel;

	@Column(name="emp_type")
	private int empType;

	@Column(name="emp_weight")
	private String empWeight;

	@Column(name="emp_workstate")
	private int empWorkstate;

	//bi-directional many-to-one association to OaAttendance
	@OneToMany(mappedBy="oaEmp")
	private List<OaAttendance> oaAttendances;

	//bi-directional many-to-one association to OaBalance
	@OneToMany(mappedBy="oaEmp1")
	private List<OaBalance> oaBalances1;

	//bi-directional many-to-one association to OaBalance
	@OneToMany(mappedBy="oaEmp2")
	private List<OaBalance> oaBalances2;

	//bi-directional many-to-one association to OaCard
	@OneToMany(mappedBy="oaEmp")
	private List<OaCard> oaCards;

	//bi-directional many-to-one association to OaCardborrow
	@OneToMany(mappedBy="oaEmp")
	private List<OaCardborrow> oaCardborrows;

	//bi-directional many-to-one association to OaContract
	@OneToMany(mappedBy="oaEmp")
	private List<OaContract> oaContracts;

	//bi-directional many-to-one association to OaDismission
	@OneToMany(mappedBy="oaEmp")
	private List<OaDismission> oaDismissions;

	//bi-directional many-to-one association to OaDept
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="dept_id")
	private OaDept oaDept;

	//bi-directional many-to-one association to OaJob
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="job_id")
	private OaJob oaJob;

	//bi-directional many-to-many association to OaSalaryitme
	@ManyToMany
	@JoinTable(
		name="emp_bian"
		, joinColumns={
			@JoinColumn(name="emp_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="pay_standardid")
			}
		)
	private List<OaSalaryitme> oaSalaryitmes;

	//bi-directional many-to-many association to OaTrainplan
	@ManyToMany
	@JoinTable(
		name="trainstu"
		, joinColumns={
			@JoinColumn(name="emp_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="rp_id")
			}
		)
	private List<OaTrainplan> oaTrainplans1;

	//bi-directional many-to-one association to OaFlow
	@OneToMany(mappedBy="oaEmp")
	private List<OaFlow> oaFlows;

	//bi-directional many-to-one association to OaFormal
	@OneToMany(mappedBy="oaEmp")
	private List<OaFormal> oaFormals;

	//bi-directional many-to-one association to OaLeave
	@OneToMany(mappedBy="oaEmp")
	private List<OaLeave> oaLeaves;

	//bi-directional many-to-one association to OaMove
	@OneToMany(mappedBy="oaEmp")
	private List<OaMove> oaMoves;

	//bi-directional many-to-one association to OaOvertimecode
	@OneToMany(mappedBy="oaEmp")
	private List<OaOvertimecode> oaOvertimecodes;

	
	//bi-directional many-to-one association to OaPersonalbook
	@OneToMany(mappedBy="oaEmp")
	private List<OaPersonalbook> oaPersonalbooks;

	//bi-directional many-to-one association to OaPertemp
	@OneToMany(mappedBy="oaEmp")
	private List<OaPertemp> oaPertemps;

	//bi-directional many-to-one association to OaRap
	@OneToMany(mappedBy="oaEmp1")
	private List<OaRap> oaRaps1;

	//bi-directional many-to-one association to OaRap
	@OneToMany(mappedBy="oaEmp2")
	private List<OaRap> oaRaps2;

	//bi-directional many-to-many association to OaRole
	@ManyToMany(mappedBy="oaEmps")
	private List<OaRole> oaRoles;

	//bi-directional many-to-one association to OaSalaryrecord
	@OneToMany(mappedBy="oaEmp")
	private List<OaSalaryrecord> oaSalaryrecords;

	//bi-directional many-to-many association to OaSalarytype
	@ManyToMany(mappedBy="oaEmps")
	private List<OaSalarytype> oaSalarytypes1;

	//bi-directional many-to-one association to OaSalarytype
	@OneToMany(mappedBy="oaEmp")
	private List<OaSalarytype> oaSalarytypes2;

	//bi-directional many-to-one association to OaSchedule
	@OneToMany(mappedBy="oaEmp")
	private List<OaSchedule> oaSchedules;

	//bi-directional many-to-many association to OaScheduletype
	@ManyToMany(mappedBy="oaEmps")
	private List<OaScheduletype> oaScheduletypes;

	//bi-directional many-to-one association to OaScore
	@OneToMany(mappedBy="oaEmp1")
	private List<OaScore> oaScores1;

	//bi-directional many-to-one association to OaScore
	@OneToMany(mappedBy="oaEmp2")
	private List<OaScore> oaScores2;

	//bi-directional many-to-one association to OaSystemlog
	@OneToMany(mappedBy="oaEmp")
	private List<OaSystemlog> oaSystemlogs;

	//bi-directional many-to-one association to OaTrainplan
	@OneToMany(mappedBy="oaEmp")
	private List<OaTrainplan> oaTrainplans2;

	//bi-directional many-to-one association to OaWhereabout
	@OneToMany(mappedBy="oaEmp")
	private List<OaWhereabout> oaWhereabouts;

	public OaEmp() {
	}

	public String getEmpId() {
		return this.empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpAddress() {
		return this.empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public String getEmpBank() {
		return this.empBank;
	}

	public void setEmpBank(String empBank) {
		this.empBank = empBank;
	}

	public String getEmpBankid() {
		return this.empBankid;
	}

	public void setEmpBankid(String empBankid) {
		this.empBankid = empBankid;
	}

	public Date getEmpBirth() {
		return this.empBirth;
	}

	public void setEmpBirth(Date empBirth) {
		this.empBirth = empBirth;
	}

	public String getEmpCardid() {
		return this.empCardid;
	}

	public void setEmpCardid(String empCardid) {
		this.empCardid = empCardid;
	}

	public Date getEmpDismission() {
		return this.empDismission;
	}

	public void setEmpDismission(Date empDismission) {
		this.empDismission = empDismission;
	}

	public String getEmpEmail() {
		return this.empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpEme() {
		return this.empEme;
	}

	public void setEmpEme(String empEme) {
		this.empEme = empEme;
	}

	public String getEmpEmetel() {
		return this.empEmetel;
	}

	public void setEmpEmetel(String empEmetel) {
		this.empEmetel = empEmetel;
	}

	public Date getEmpEntrydate() {
		return this.empEntrydate;
	}

	public void setEmpEntrydate(Date empEntrydate) {
		this.empEntrydate = empEntrydate;
	}

	public String getEmpFileid() {
		return this.empFileid;
	}

	public void setEmpFileid(String empFileid) {
		this.empFileid = empFileid;
	}

	public Date getEmpFormaldate() {
		return this.empFormaldate;
	}

	public void setEmpFormaldate(Date empFormaldate) {
		this.empFormaldate = empFormaldate;
	}

	public Date getEmpGraduation() {
		return this.empGraduation;
	}

	public void setEmpGraduation(Date empGraduation) {
		this.empGraduation = empGraduation;
	}

	public String getEmpHealthy() {
		return this.empHealthy;
	}

	public void setEmpHealthy(String empHealthy) {
		this.empHealthy = empHealthy;
	}

	public String getEmpHigh() {
		return this.empHigh;
	}

	public void setEmpHigh(String empHigh) {
		this.empHigh = empHigh;
	}

	public String getEmpLike() {
		return this.empLike;
	}

	public void setEmpLike(String empLike) {
		this.empLike = empLike;
	}

	public String getEmpMajor() {
		return this.empMajor;
	}

	public void setEmpMajor(String empMajor) {
		this.empMajor = empMajor;
	}

	public String getEmpMaxdegree() {
		return this.empMaxdegree;
	}

	public void setEmpMaxdegree(String empMaxdegree) {
		this.empMaxdegree = empMaxdegree;
	}

	public String getEmpMaxeducation() {
		return this.empMaxeducation;
	}

	public void setEmpMaxeducation(String empMaxeducation) {
		this.empMaxeducation = empMaxeducation;
	}

	public String getEmpMgr() {
		return this.empMgr;
	}

	public void setEmpMgr(String empMgr) {
		this.empMgr = empMgr;
	}

	public String getEmpName() {
		return this.empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpNation() {
		return this.empNation;
	}

	public void setEmpNation(String empNation) {
		this.empNation = empNation;
	}

	public String getEmpNationality() {
		return this.empNationality;
	}

	public void setEmpNationality(String empNationality) {
		this.empNationality = empNationality;
	}

	public String getEmpNative() {
		return this.empNative;
	}

	public void setEmpNative(String empNative) {
		this.empNative = empNative;
	}

	public String getEmpOldname() {
		return this.empOldname;
	}

	public void setEmpOldname(String empOldname) {
		this.empOldname = empOldname;
	}

	public String getEmpPhone() {
		return this.empPhone;
	}

	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}

	public String getEmpPhoto() {
		return this.empPhoto;
	}

	public void setEmpPhoto(String empPhoto) {
		this.empPhoto = empPhoto;
	}

	public String getEmpQq() {
		return this.empQq;
	}

	public void setEmpQq(String empQq) {
		this.empQq = empQq;
	}

	public String getEmpRemark() {
		return this.empRemark;
	}

	public void setEmpRemark(String empRemark) {
		this.empRemark = empRemark;
	}

	public String getEmpSchool() {
		return this.empSchool;
	}

	public void setEmpSchool(String empSchool) {
		this.empSchool = empSchool;
	}

	public int getEmpSex() {
		return this.empSex;
	}

	public void setEmpSex(int empSex) {
		this.empSex = empSex;
	}

	public String getEmpStation() {
		return this.empStation;
	}

	public void setEmpStation(String empStation) {
		this.empStation = empStation;
	}

	public String getEmpTel() {
		return this.empTel;
	}

	public void setEmpTel(String empTel) {
		this.empTel = empTel;
	}

	public int getEmpType() {
		return this.empType;
	}

	public void setEmpType(int empType) {
		this.empType = empType;
	}

	public String getEmpWeight() {
		return this.empWeight;
	}

	public void setEmpWeight(String empWeight) {
		this.empWeight = empWeight;
	}

	public int getEmpWorkstate() {
		return this.empWorkstate;
	}

	public void setEmpWorkstate(int empWorkstate) {
		this.empWorkstate = empWorkstate;
	}

	public List<OaAttendance> getOaAttendances() {
		return this.oaAttendances;
	}

	public void setOaAttendances(List<OaAttendance> oaAttendances) {
		this.oaAttendances = oaAttendances;
	}

	public OaAttendance addOaAttendance(OaAttendance oaAttendance) {
		getOaAttendances().add(oaAttendance);
		oaAttendance.setOaEmp(this);

		return oaAttendance;
	}

	public OaAttendance removeOaAttendance(OaAttendance oaAttendance) {
		getOaAttendances().remove(oaAttendance);
		oaAttendance.setOaEmp(null);

		return oaAttendance;
	}

	public List<OaBalance> getOaBalances1() {
		return this.oaBalances1;
	}

	public void setOaBalances1(List<OaBalance> oaBalances1) {
		this.oaBalances1 = oaBalances1;
	}

	public OaBalance addOaBalances1(OaBalance oaBalances1) {
		getOaBalances1().add(oaBalances1);
		oaBalances1.setOaEmp1(this);

		return oaBalances1;
	}

	public OaBalance removeOaBalances1(OaBalance oaBalances1) {
		getOaBalances1().remove(oaBalances1);
		oaBalances1.setOaEmp1(null);

		return oaBalances1;
	}

	public List<OaBalance> getOaBalances2() {
		return this.oaBalances2;
	}

	public void setOaBalances2(List<OaBalance> oaBalances2) {
		this.oaBalances2 = oaBalances2;
	}

	public OaBalance addOaBalances2(OaBalance oaBalances2) {
		getOaBalances2().add(oaBalances2);
		oaBalances2.setOaEmp2(this);

		return oaBalances2;
	}

	public OaBalance removeOaBalances2(OaBalance oaBalances2) {
		getOaBalances2().remove(oaBalances2);
		oaBalances2.setOaEmp2(null);

		return oaBalances2;
	}

	public List<OaCard> getOaCards() {
		return this.oaCards;
	}

	public void setOaCards(List<OaCard> oaCards) {
		this.oaCards = oaCards;
	}

	public OaCard addOaCard(OaCard oaCard) {
		getOaCards().add(oaCard);
		oaCard.setOaEmp(this);

		return oaCard;
	}

	public OaCard removeOaCard(OaCard oaCard) {
		getOaCards().remove(oaCard);
		oaCard.setOaEmp(null);

		return oaCard;
	}

	public List<OaCardborrow> getOaCardborrows() {
		return this.oaCardborrows;
	}

	public void setOaCardborrows(List<OaCardborrow> oaCardborrows) {
		this.oaCardborrows = oaCardborrows;
	}

	public OaCardborrow addOaCardborrow(OaCardborrow oaCardborrow) {
		getOaCardborrows().add(oaCardborrow);
		oaCardborrow.setOaEmp(this);

		return oaCardborrow;
	}

	public OaCardborrow removeOaCardborrow(OaCardborrow oaCardborrow) {
		getOaCardborrows().remove(oaCardborrow);
		oaCardborrow.setOaEmp(null);

		return oaCardborrow;
	}

	public List<OaContract> getOaContracts() {
		return this.oaContracts;
	}

	public void setOaContracts(List<OaContract> oaContracts) {
		this.oaContracts = oaContracts;
	}

	public OaContract addOaContract(OaContract oaContract) {
		getOaContracts().add(oaContract);
		oaContract.setOaEmp(this);

		return oaContract;
	}

	public OaContract removeOaContract(OaContract oaContract) {
		getOaContracts().remove(oaContract);
		oaContract.setOaEmp(null);

		return oaContract;
	}

	public List<OaDismission> getOaDismissions() {
		return this.oaDismissions;
	}

	public void setOaDismissions(List<OaDismission> oaDismissions) {
		this.oaDismissions = oaDismissions;
	}

	public OaDismission addOaDismission(OaDismission oaDismission) {
		getOaDismissions().add(oaDismission);
		oaDismission.setOaEmp(this);

		return oaDismission;
	}

	public OaDismission removeOaDismission(OaDismission oaDismission) {
		getOaDismissions().remove(oaDismission);
		oaDismission.setOaEmp(null);

		return oaDismission;
	}

	public OaDept getOaDept() {
		return this.oaDept;
	}

	public void setOaDept(OaDept oaDept) {
		this.oaDept = oaDept;
	}

	public OaJob getOaJob() {
		return this.oaJob;
	}

	public void setOaJob(OaJob oaJob) {
		this.oaJob = oaJob;
	}

	public List<OaSalaryitme> getOaSalaryitmes() {
		return this.oaSalaryitmes;
	}

	public void setOaSalaryitmes(List<OaSalaryitme> oaSalaryitmes) {
		this.oaSalaryitmes = oaSalaryitmes;
	}

	public List<OaTrainplan> getOaTrainplans1() {
		return this.oaTrainplans1;
	}

	public void setOaTrainplans1(List<OaTrainplan> oaTrainplans1) {
		this.oaTrainplans1 = oaTrainplans1;
	}

	public List<OaFlow> getOaFlows() {
		return this.oaFlows;
	}

	public void setOaFlows(List<OaFlow> oaFlows) {
		this.oaFlows = oaFlows;
	}

	public OaFlow addOaFlow(OaFlow oaFlow) {
		getOaFlows().add(oaFlow);
		oaFlow.setOaEmp(this);

		return oaFlow;
	}

	public OaFlow removeOaFlow(OaFlow oaFlow) {
		getOaFlows().remove(oaFlow);
		oaFlow.setOaEmp(null);

		return oaFlow;
	}

	public List<OaFormal> getOaFormals() {
		return this.oaFormals;
	}

	public void setOaFormals(List<OaFormal> oaFormals) {
		this.oaFormals = oaFormals;
	}

	public OaFormal addOaFormal(OaFormal oaFormal) {
		getOaFormals().add(oaFormal);
		oaFormal.setOaEmp(this);

		return oaFormal;
	}

	public OaFormal removeOaFormal(OaFormal oaFormal) {
		getOaFormals().remove(oaFormal);
		oaFormal.setOaEmp(null);

		return oaFormal;
	}

	public List<OaLeave> getOaLeaves() {
		return this.oaLeaves;
	}

	public void setOaLeaves(List<OaLeave> oaLeaves) {
		this.oaLeaves = oaLeaves;
	}

	public OaLeave addOaLeave(OaLeave oaLeave) {
		getOaLeaves().add(oaLeave);
		oaLeave.setOaEmp(this);

		return oaLeave;
	}

	public OaLeave removeOaLeave(OaLeave oaLeave) {
		getOaLeaves().remove(oaLeave);
		oaLeave.setOaEmp(null);

		return oaLeave;
	}

	public List<OaMove> getOaMoves() {
		return this.oaMoves;
	}

	public void setOaMoves(List<OaMove> oaMoves) {
		this.oaMoves = oaMoves;
	}

	public OaMove addOaMove(OaMove oaMove) {
		getOaMoves().add(oaMove);
		oaMove.setOaEmp(this);

		return oaMove;
	}

	public OaMove removeOaMove(OaMove oaMove) {
		getOaMoves().remove(oaMove);
		oaMove.setOaEmp(null);

		return oaMove;
	}

	public List<OaOvertimecode> getOaOvertimecodes() {
		return this.oaOvertimecodes;
	}

	public void setOaOvertimecodes(List<OaOvertimecode> oaOvertimecodes) {
		this.oaOvertimecodes = oaOvertimecodes;
	}

	public OaOvertimecode addOaOvertimecode(OaOvertimecode oaOvertimecode) {
		getOaOvertimecodes().add(oaOvertimecode);
		oaOvertimecode.setOaEmp(this);

		return oaOvertimecode;
	}

	public OaOvertimecode removeOaOvertimecode(OaOvertimecode oaOvertimecode) {
		getOaOvertimecodes().remove(oaOvertimecode);
		oaOvertimecode.setOaEmp(null);

		return oaOvertimecode;
	}

	

	public List<OaPersonalbook> getOaPersonalbooks() {
		return this.oaPersonalbooks;
	}

	public void setOaPersonalbooks(List<OaPersonalbook> oaPersonalbooks) {
		this.oaPersonalbooks = oaPersonalbooks;
	}

	public OaPersonalbook addOaPersonalbook(OaPersonalbook oaPersonalbook) {
		getOaPersonalbooks().add(oaPersonalbook);
		oaPersonalbook.setOaEmp(this);

		return oaPersonalbook;
	}

	public OaPersonalbook removeOaPersonalbook(OaPersonalbook oaPersonalbook) {
		getOaPersonalbooks().remove(oaPersonalbook);
		oaPersonalbook.setOaEmp(null);

		return oaPersonalbook;
	}

	public List<OaPertemp> getOaPertemps() {
		return this.oaPertemps;
	}

	public void setOaPertemps(List<OaPertemp> oaPertemps) {
		this.oaPertemps = oaPertemps;
	}

	public OaPertemp addOaPertemp(OaPertemp oaPertemp) {
		getOaPertemps().add(oaPertemp);
		oaPertemp.setOaEmp(this);

		return oaPertemp;
	}

	public OaPertemp removeOaPertemp(OaPertemp oaPertemp) {
		getOaPertemps().remove(oaPertemp);
		oaPertemp.setOaEmp(null);

		return oaPertemp;
	}

	public List<OaRap> getOaRaps1() {
		return this.oaRaps1;
	}

	public void setOaRaps1(List<OaRap> oaRaps1) {
		this.oaRaps1 = oaRaps1;
	}

	public OaRap addOaRaps1(OaRap oaRaps1) {
		getOaRaps1().add(oaRaps1);
		oaRaps1.setOaEmp1(this);

		return oaRaps1;
	}

	public OaRap removeOaRaps1(OaRap oaRaps1) {
		getOaRaps1().remove(oaRaps1);
		oaRaps1.setOaEmp1(null);

		return oaRaps1;
	}

	public List<OaRap> getOaRaps2() {
		return this.oaRaps2;
	}

	public void setOaRaps2(List<OaRap> oaRaps2) {
		this.oaRaps2 = oaRaps2;
	}

	public OaRap addOaRaps2(OaRap oaRaps2) {
		getOaRaps2().add(oaRaps2);
		oaRaps2.setOaEmp2(this);

		return oaRaps2;
	}

	public OaRap removeOaRaps2(OaRap oaRaps2) {
		getOaRaps2().remove(oaRaps2);
		oaRaps2.setOaEmp2(null);

		return oaRaps2;
	}

	public List<OaRole> getOaRoles() {
		return this.oaRoles;
	}

	public void setOaRoles(List<OaRole> oaRoles) {
		this.oaRoles = oaRoles;
	}

	public List<OaSalaryrecord> getOaSalaryrecords() {
		return this.oaSalaryrecords;
	}

	public void setOaSalaryrecords(List<OaSalaryrecord> oaSalaryrecords) {
		this.oaSalaryrecords = oaSalaryrecords;
	}

	public OaSalaryrecord addOaSalaryrecord(OaSalaryrecord oaSalaryrecord) {
		getOaSalaryrecords().add(oaSalaryrecord);
		oaSalaryrecord.setOaEmp(this);

		return oaSalaryrecord;
	}

	public OaSalaryrecord removeOaSalaryrecord(OaSalaryrecord oaSalaryrecord) {
		getOaSalaryrecords().remove(oaSalaryrecord);
		oaSalaryrecord.setOaEmp(null);

		return oaSalaryrecord;
	}

	public List<OaSalarytype> getOaSalarytypes1() {
		return this.oaSalarytypes1;
	}

	public void setOaSalarytypes1(List<OaSalarytype> oaSalarytypes1) {
		this.oaSalarytypes1 = oaSalarytypes1;
	}

	public List<OaSalarytype> getOaSalarytypes2() {
		return this.oaSalarytypes2;
	}

	public void setOaSalarytypes2(List<OaSalarytype> oaSalarytypes2) {
		this.oaSalarytypes2 = oaSalarytypes2;
	}

	public OaSalarytype addOaSalarytypes2(OaSalarytype oaSalarytypes2) {
		getOaSalarytypes2().add(oaSalarytypes2);
		oaSalarytypes2.setOaEmp(this);

		return oaSalarytypes2;
	}

	public OaSalarytype removeOaSalarytypes2(OaSalarytype oaSalarytypes2) {
		getOaSalarytypes2().remove(oaSalarytypes2);
		oaSalarytypes2.setOaEmp(null);

		return oaSalarytypes2;
	}

	public List<OaSchedule> getOaSchedules() {
		return this.oaSchedules;
	}

	public void setOaSchedules(List<OaSchedule> oaSchedules) {
		this.oaSchedules = oaSchedules;
	}

	public OaSchedule addOaSchedule(OaSchedule oaSchedule) {
		getOaSchedules().add(oaSchedule);
		oaSchedule.setOaEmp(this);

		return oaSchedule;
	}

	public OaSchedule removeOaSchedule(OaSchedule oaSchedule) {
		getOaSchedules().remove(oaSchedule);
		oaSchedule.setOaEmp(null);

		return oaSchedule;
	}

	public List<OaScheduletype> getOaScheduletypes() {
		return this.oaScheduletypes;
	}

	public void setOaScheduletypes(List<OaScheduletype> oaScheduletypes) {
		this.oaScheduletypes = oaScheduletypes;
	}

	public List<OaScore> getOaScores1() {
		return this.oaScores1;
	}

	public void setOaScores1(List<OaScore> oaScores1) {
		this.oaScores1 = oaScores1;
	}

	public OaScore addOaScores1(OaScore oaScores1) {
		getOaScores1().add(oaScores1);
		oaScores1.setOaEmp1(this);

		return oaScores1;
	}

	public OaScore removeOaScores1(OaScore oaScores1) {
		getOaScores1().remove(oaScores1);
		oaScores1.setOaEmp1(null);

		return oaScores1;
	}

	public List<OaScore> getOaScores2() {
		return this.oaScores2;
	}

	public void setOaScores2(List<OaScore> oaScores2) {
		this.oaScores2 = oaScores2;
	}

	public OaScore addOaScores2(OaScore oaScores2) {
		getOaScores2().add(oaScores2);
		oaScores2.setOaEmp2(this);

		return oaScores2;
	}

	public OaScore removeOaScores2(OaScore oaScores2) {
		getOaScores2().remove(oaScores2);
		oaScores2.setOaEmp2(null);

		return oaScores2;
	}

	public List<OaSystemlog> getOaSystemlogs() {
		return this.oaSystemlogs;
	}

	public void setOaSystemlogs(List<OaSystemlog> oaSystemlogs) {
		this.oaSystemlogs = oaSystemlogs;
	}

	public OaSystemlog addOaSystemlog(OaSystemlog oaSystemlog) {
		getOaSystemlogs().add(oaSystemlog);
		oaSystemlog.setOaEmp(this);

		return oaSystemlog;
	}

	public OaSystemlog removeOaSystemlog(OaSystemlog oaSystemlog) {
		getOaSystemlogs().remove(oaSystemlog);
		oaSystemlog.setOaEmp(null);

		return oaSystemlog;
	}

	public List<OaTrainplan> getOaTrainplans2() {
		return this.oaTrainplans2;
	}

	public void setOaTrainplans2(List<OaTrainplan> oaTrainplans2) {
		this.oaTrainplans2 = oaTrainplans2;
	}

	public OaTrainplan addOaTrainplans2(OaTrainplan oaTrainplans2) {
		getOaTrainplans2().add(oaTrainplans2);
		oaTrainplans2.setOaEmp(this);

		return oaTrainplans2;
	}

	public OaTrainplan removeOaTrainplans2(OaTrainplan oaTrainplans2) {
		getOaTrainplans2().remove(oaTrainplans2);
		oaTrainplans2.setOaEmp(null);

		return oaTrainplans2;
	}

	public List<OaWhereabout> getOaWhereabouts() {
		return this.oaWhereabouts;
	}

	public void setOaWhereabouts(List<OaWhereabout> oaWhereabouts) {
		this.oaWhereabouts = oaWhereabouts;
	}

	public OaWhereabout addOaWhereabout(OaWhereabout oaWhereabout) {
		getOaWhereabouts().add(oaWhereabout);
		oaWhereabout.setOaEmp(this);

		return oaWhereabout;
	}

	public OaWhereabout removeOaWhereabout(OaWhereabout oaWhereabout) {
		getOaWhereabouts().remove(oaWhereabout);
		oaWhereabout.setOaEmp(null);

		return oaWhereabout;
	}

}