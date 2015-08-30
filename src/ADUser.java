/**
 * 
 */
package com.bjc.ekk.cleanup;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;

/**
 * @author ekk9418
 *
 */
@Entity
@Immutable
@Table(name="ADUsers")
public class ADUser implements User {
	private String guid;
	private String uid;
	private String domain;
	private String dispName;
	private String sid;
	private Date lastLogon;
	private Date pwdLstRest;
	private String fn;
	private String mi;
	private String ln;
	private String empType;
	private String eid;
	private String distNam;
	private String title;
	private String dept;
	private String mng;
	private boolean dis;
	private Boolean deprovisioned;//primitive types cannot be used on fields marked null because primitives cannot contain nulls
	private String loginScript;
	private String posCode;
	private String ent;
	private String cc;
	private String homeDrive;
	private String homeDir;
	private String email;
	private String descript;
	private String info;
	private String ipAd;//IP Address
	private boolean exp;
	private String phone;
	private String pager;
	private String empCode;
	private String extAttr7;
	private String company;
	private Date createDate;
	private Date hireDate;
	private Date lastImported;
	private Date lastModified;
	private Date dateMIISDeprovisioned;
	private String mobile;
	
	/**
	 * @return the guid
	 */
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2", parameters = {})
    @GeneratedValue(generator = "uuid")
	@Column(columnDefinition="uniqueidentifier default newId()", name="GUID")
	public String getGuid() {
		return guid;
	}

	/**
	 * @param guid the guid to set
	 */
	/*
	 * primary key setter private so only hibernate can update this
	 */
	private void setGuid(String guid) {
		this.guid = guid;
	}

	/**
	 * @return the lastImported
	 */
	@Column(name="LastImported",columnDefinition="smalldatetime")
	public Date getLastImported() {
		return lastImported;
	}

	/**
	 * @param lastImported the lastImported to set
	 */
	public void setLastImported(Date li) {
		lastImported = li;
	}

	/**
	 * @return the uid
	 */
	@Column(nullable=false, length=30, name="UID")
	public String getUid() {
		return uid;
	}

	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
	 * @return the fn
	 */
	@Column(length=30, name="FN")
	public String getFn() {
		return fn;
	}

	/**
	 * @param fn the fn to set
	 */
	public void setFn(String fn) {
		this.fn = fn;
	}

	/**
	 * @return the ln
	 */
	@Column(length=60, name="LN")
	public String getLn() {
		return ln;
	}

	/**
	 * @param ln the ln to set
	 */
	public void setLn(String ln) {
		this.ln = ln;
	}
	
	/**
	 * @return the domain
	 */
	@Column(nullable=false, length=30,name="Domain")
	public String getDomain() {
		return domain;
	}

	/**
	 * @param domain the domain to set
	 */
	public void setDomain(String d) {
		domain = d;
	}

	/**
	 * @return the dispName
	 */
	@Column(length=120,name="DispName")
	public String getDispName() {
		return dispName;
	}

	/**
	 * @param dispName the dispName to set
	 */
	public void setDispName(String dn) {
		dispName = dn;
	}

	/**
	 * @return the sid
	 */
	@Column(length=100, name="SID")
	public String getSid() {
		return sid;
	}

	/**
	 * @param sID the sID to set
	 */
	public void setSid(String sID) {
		sid = sID;
	}

	/**
	 * @return the lastLogon
	 */
	@Column(columnDefinition="smalldatetime",name="LastLogon")
	public Date getLastLogon() {
		return lastLogon;
	}

	/**
	 * @param lastLogon the lastLogon to set
	 */
	public void setLastLogon(Date ll) {
		lastLogon = ll;
	}

	/**
	 * @return the pwdLstRest
	 */
	@Column(columnDefinition="smalldatetime",name="PwdLstRest")
	public Date getPwdLstRest() {
		return pwdLstRest;
	}

	/**
	 * @param pwdLstRest the pwdLstRest to set
	 */
	public void setPwdLstRest(Date plr) {
		pwdLstRest = plr;
	}

	/**
	 * @return the mi
	 */
	@Column(length=30, name="MI")
	public String getMi() {
		return mi;
	}

	/**
	 * @param mi the mi to set
	 */
	public void setMi(String mI) {
		mi = mI;
	}

	/**
	 * @return the empType
	 */
	@Column(length=50,name="EmpType")
	public String getEmpType() {
		return empType;
	}

	/**
	 * @param empType the empType to set
	 */
	public void setEmpType(String et) {
		empType = et;
	}

	/**
	 * @return the eid
	 */
	@Column(length=30, name="EID")
	public String getEid() {
		return eid;
	}

	/**
	 * @param eid the eid to set
	 */
	public void setEid(String eID) {
		eid = eID;
	}

	/**
	 * @return the distNam
	 */
	@Column(name="DistNam")
	public String getDistNam() {
		return distNam;
	}

	/**
	 * @param distNam the distNam to set
	 */
	public void setDistNam(String dn) {
		distNam = dn;
	}

	/**
	 * @return the title
	 */
	@Column(length=100,name="Title")
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String t) {
		title = t;
	}

	/**
	 * @return the dept
	 */
	@Column(length=100,name="Dept")
	public String getDept() {
		return dept;
	}

	/**
	 * @param dept the dept to set
	 */
	public void setDept(String d) {
		dept = d;
	}

	/**
	 * @return the mng
	 */
	@Column(length=150,name="Mng")
	public String getMng() {
		return mng;
	}

	/**
	 * @param mng the mng to set
	 */
	public void setMng(String m) {
		mng = m;
	}

	/**
	 * @return the dis
	 */
	@Column(nullable=true,name="Dis")
	public boolean getDis() {
		return dis;
	}

	/**
	 * @param dis the dis to set
	 */
	public void setDis(boolean d) {
		dis = d;
	}

	/**
	 * @return the deprovisioned
	 */
	@Column(nullable=true,name="Deprovisioned")
	public Boolean getDeprovisioned() {
		return deprovisioned;
	}

	/**
	 * @param deprovisioned the deprovisioned to set
	 */
	public void setDeprovisioned(Boolean d) {
		deprovisioned = d;
	}

	/**
	 * @return the loginScript
	 */
	@Column(length=100,name="loginScript")
	public String getLoginScript() {
		return loginScript;
	}

	/**
	 * @param loginScript the loginScript to set
	 */
	public void setLoginScript(String ls) {
		loginScript = ls;
	}

	/**
	 * @return the posCode
	 */
	@Column(length=20,name="PosCode")
	public String getPosCode() {
		return posCode;
	}

	/**
	 * @param posCode the posCode to set
	 */
	public void setPosCode(String pc) {
		posCode = pc;
	}

	/**
	 * @return the ent
	 */
	@Column(length=10,name="Ent")
	public String getEnt() {
		return ent;
	}

	/**
	 * @param ent the ent to set
	 */
	public void setEnt(String e) {
		ent = e;
	}

	/**
	 * @return the cc
	 */
	@Column(length=20,name="CC")
	public String getCc() {
		return cc;
	}

	/**
	 * @param cc the cc to set
	 */
	public void setCc(String cc) {
		this.cc = cc;
	}

	/**
	 * @return the homeDrive
	 */
	@Column(length=100,name="HomeDrive")
	public String getHomeDrive() {
		return homeDrive;
	}

	/**
	 * @param homeDrive the homeDrive to set
	 */
	public void setHomeDrive(String hd) {
		homeDrive = hd;
	}

	/**
	 * @return the homeDir
	 */
	@Column(length=100,name="HomeDir")
	public String getHomeDir() {
		return homeDir;
	}

	/**
	 * @param homeDir the homeDir to set
	 */
	public void setHomeDir(String hd) {
		homeDir = hd;
	}

	/**
	 * @return the email
	 */
	@Column(length=50,name="Email")
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String e) {
		email = e;
	}

	/**
	 * @return the descript
	 */
	@Column(columnDefinition="text",name="Descript")
	public String getDescript() {
		return descript;
	}

	/**
	 * @param descript the descript to set
	 */
	public void setDescript(String d) {
		descript = d;
	}

	/**
	 * @return the info
	 */
	@Column(columnDefinition="text",name="Info")
	public String getInfo() {
		return info;
	}

	/**
	 * @param info the info to set
	 */
	public void setInfo(String i) {
		info = i;
	}

	/**
	 * @return the ipAd
	 */
	@Column(length=15, name="IPAd")
	public String getIpAd() {
		return ipAd;
	}

	/**
	 * @param ipAd the ipAd to set
	 */
	public void setIpAd(String ip) {
		ipAd = ip;
	}

	/**
	 * @return the exp
	 */
	@Column(name="Exp")
	public boolean getExp() {
		return exp;
	}

	/**
	 * @param exp the exp to set
	 */
	public void setExp(boolean e) {
		exp = e;
	}

	/**
	 * @return the phone
	 */
	@Column(length=40,name="Phone")
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String ph) {
		phone = ph;
	}

	/**
	 * @return the pager
	 */
	@Column(length=20,name="Pager")
	public String getPager() {
		return pager;
	}

	/**
	 * @param pager the pager to set
	 */
	public void setPager(String p) {
		pager = p;
	}

	/**
	 * @return the empCode
	 */
	@Column(length=10,name="EmpCode")
	public String getEmpCode() {
		return empCode;
	}

	/**
	 * @param empCode the empCode to set
	 */
	public void setEmpCode(String ec) {
		empCode = ec;
	}

	/**
	 * @return the extAttr7
	 */
	@Column(length=10,name="ExtAttr7")
	public String getExtAttr7() {
		return extAttr7;
	}

	/**
	 * @param extAttr7 the extAttr7 to set
	 */
	public void setExtAttr7(String ea7) {
		extAttr7 = ea7;
	}

	/**
	 * @return the company
	 */
	@Column(length=100,name="Company")
	public String getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(String c) {
		company = c;
	}

	/**
	 * @return the createDate
	 */
	@Column(columnDefinition="smalldatetime")
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date cd) {
		createDate = cd;
	}

	/**
	 * @return the hireDate
	 */
	@Column(name="HireDate")
	public Date getHireDate() {
		return hireDate;
	}

	/**
	 * @param hireDate the hireDate to set
	 */
	public void setHireDate(Date hd) {
		hireDate = hd;
	}

	/**
	 * @return the lastModified
	 */
	@Column(columnDefinition="smalldatetime",name="LastModified")
	public Date getLastModified() {
		return lastModified;
	}

	/**
	 * @param lastModified the lastModified to set
	 */
	public void setLastModified(Date lm) {
		lastModified = lm;
	}

	/**
	 * @return the dateMIISDeprovisioned
	 */
	@Column(columnDefinition="smalldatetime",name="DateMIISDeprovisioned")
	public Date getDateMIISDeprovisioned() {
		return dateMIISDeprovisioned;
	}

	/**
	 * @param dateMIISDeprovisioned the dateMIISDeprovisioned to set
	 */
	public void setDateMIISDeprovisioned(Date d) {
		dateMIISDeprovisioned = d;
	}

	/**
	 * @return the mobile
	 */
	@Column(length=50,name="Mobile")
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String m) {
		mobile = m;
	}

	public ADUser() {
		
	}
	
	public ADUser(String domain, String id){
		setUid(id);
		setDomain(domain);
	}
	
	@Override
	public String toString() {
		//TODO correct this function
		return "NextGen id = " + getUid() + ", name = " + getFn() + " " + getLn() + ", AD ID = " + ";";
	}
}