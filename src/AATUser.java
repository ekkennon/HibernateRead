/**
 * 
 */
package com.bjc.ekk.cleanup;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * @author ekk9418
 *
 */

@Entity
@Immutable//added due to errors from read-only permissions when hibernate tried to update the database to the class
@Table(name="Term_AllAppTerm")
@IdClass(CompositeKey.class)
public class AATUser implements User {
	private String appMi;
	private boolean fullMatch;
	private boolean eidMatch;
	private boolean uidMatch;
	private boolean fnLnMatch;
	private boolean lnIdMatch;
	private boolean fnIdMatch;
	private String hrId;
	private String termLn;
	private String termFn;
	private String termMi;
	private boolean doNotRemove;
	private Date termRptDt;
	private String entity;
	private String dept;
	private String position;
	private String title;
	private String echoKey;
	private String dndReason;
	private boolean disabled;
	private String appFn;
	private String appLn;
	private CompositeKey compositeKey = new CompositeKey();
	private String appMiscInfo;
	private String app;
	private String uid;
	private String eid;
	
	/**
	 * @return the compositeKey
	 */
	@Id
	public CompositeKey getCompositeKey() {
		return compositeKey;
	}

	/**
	 * @param compositeKey the compositeKey to set
	 */
	public void setCompositeKey(CompositeKey ck) {
		compositeKey=ck;
	}
	
	/**
	 * @return the uid
	 */
	@Column(columnDefinition="nvarchar(25)", nullable=false,updatable=false,insertable=false, name="UID")
	public String getUid() {
		return compositeKey.getUid();
	}
	
	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		compositeKey.setUid(uid);
	}
	
	/**
	 * @return the eid
	 */
	@Column(columnDefinition="nvarchar(40)", nullable=false,updatable=false,insertable=false, name="EID")
	private String getEid() {
		return compositeKey.getEid();
	}

	/**
	 * @param eid the eid to set
	 */
	public void setEid(String eID) {
		compositeKey.setEid(eID);
	}
	
	/**
	 * @return the appMiscInfo
	 */
	@Column(columnDefinition="nvarchar(255)",name="AppMiscInfo", nullable=false,updatable=false,insertable=false)
	private String getAppMiscInfo() {
		return compositeKey.getAppMiscInfo();
	}

	/**
	 * @param appMiscInfo the appMiscInfo to set
	 */
	public void setAppMiscInfo(String ami) {
		compositeKey.setAppMiscInfo(ami);
	}

	/**
	 * @return the app
	 */
	@Column(columnDefinition="nvarchar(25)",name="App", nullable=false,updatable=false,insertable=false)
	public String getApp() {
		return compositeKey.getApp();
	}

	/**
	 * @param app the app to set
	 */
	public void setApp(String a) {
		compositeKey.setApp(a);
	}
	
	/**
	 * @return the appFn
	 */
	@Column(columnDefinition="nvarchar(25)",name="AppFN")
	public String getAppFn() {
		return appFn;
	}
	
	/**
	 * @param appFn the appFn to set
	 */
	public void setAppFn(String fn) {
		appFn = fn;
	}
	
	/**
	 * @return the appLn
	 */
	@Column(columnDefinition="nvarchar(35)",name="AppLN")
	public String getAppLn() {
		return appLn;
	}
	
	/**
	 * @param appLn the appLn to set
	 */
	public void setAppLn(String ln) {
		appLn = ln;
	}

	/**
	 * @return the appMi
	 */
	@Column(columnDefinition="nvarchar",name="AppMI")
	public String getAppMi() {
		return appMi;
	}

	/**
	 * @param appMi the appMi to set
	 */
	public void setAppMi(String mi) {
		appMi = mi;
	}

	/**
	 * @return the fullMatch
	 */
	@Column(name="FullMatch",nullable=false)
	public boolean getFullMatch() {
		return fullMatch;
	}

	/**
	 * @param fullMatch the fullMatch to set
	 */
	public void setFullMatch(boolean fm) {
		fullMatch = fm;
	}

	/**
	 * @return the eidMatch
	 */
	@Column(name="EIDMatch")
	public boolean getEidMatch() {
		return eidMatch;
	}

	/**
	 * @param eidMatch the eidMatch to set
	 */
	public void setEidMatch(boolean eidM) {
		eidMatch = eidM;
	}

	/**
	 * @return the uidMatch
	 */
	@Column(name="UIDMatch")
	public boolean getUidMatch() {
		return uidMatch;
	}

	/**
	 * @param uidMatch the uidMatch to set
	 */
	public void setUidMatch(boolean uidM) {
		uidMatch = uidM;
	}

	/**
	 * @return the fnLnMatch
	 */
	@Column(name="FNLNMatch")
	public boolean getFnLnMatch() {
		return fnLnMatch;
	}

	/**
	 * @param fnLnMatch the fnLnMatch to set
	 */
	public void setFnLnMatch(boolean fnlnM) {
		fnLnMatch = fnlnM;
	}

	/**
	 * @return the lnIdMatch
	 */
	@Column(name="LNIDMatch")
	public boolean getLnIdMatch() {
		return lnIdMatch;
	}

	/**
	 * @param lnIdMatch the lnIdMatch to set
	 */
	public void setLnIdMatch(boolean lnIdM) {
		lnIdMatch = lnIdM;
	}

	/**
	 * @return the fnIdMatch
	 */
	@Column(name="FNIDMatch")
	public boolean getFnIdMatch() {
		return fnIdMatch;
	}

	/**
	 * @param fnIdMatch the fnIdMatch to set
	 */
	public void setFnIdMatch(boolean fnIdM) {
		fnIdMatch = fnIdM;
	}

	/**
	 * @return the hrId
	 */
	@Column(columnDefinition="nvarchar(50)", name="HRID")
	public String getHrId() {
		return hrId;
	}

	/**
	 * @param hrId the hrId to set
	 */
	public void setHrId(String hrid) {
		hrId = hrid;
	}

	/**
	 * @return the termLn
	 */
	@Column(columnDefinition="nvarchar(35)",name="TermLN")
	public String getTermLn() {
		return termLn;
	}

	/**
	 * @param termLn the termLn to set
	 */
	public void setTermLn(String ln) {
		termLn = ln;
	}

	/**
	 * @return the termFn
	 */
	@Column(columnDefinition="nvarchar(25)",name="TermFN")
	public String getTermFn() {
		return termFn;
	}

	/**
	 * @param termFn the termFn to set
	 */
	public void setTermFn(String fn) {
		termFn = fn;
	}

	/**
	 * @return the termMi
	 */
	@Column(columnDefinition="nvarchar",name="TermMI")
	public String getTermMi() {
		return termMi;
	}

	/**
	 * @param termMI the termMi to set
	 */
	public void setTermMi(String mi) {
		termMi = mi;
	}

	/**
	 * @return the doNotRemove
	 */
	@Column(name="DoNotRemove",nullable=false)
	public boolean getDoNotRemove() {
		return doNotRemove;
	}

	/**
	 * @param doNotRemove the doNotRemove to set
	 */
	public void setDoNotRemove(boolean dnr) {
		doNotRemove = dnr;
	}

	/**
	 * @return the termRptDt
	 */
	@Column(name="TermRptDt")
	public Date getTermRptDt() {
		return termRptDt;
	}

	/**
	 * @param termRptDt the termRptDt to set
	 */
	public void setTermRptDt(Date trd) {
		termRptDt = trd;
	}

	/**
	 * @return the entity
	 */
	@Column(columnDefinition="nvarchar(50)",name="Entity")
	public String getEntity() {
		return entity;
	}

	/**
	 * @param entity the entity to set
	 */
	public void setEntity(String e) {
		entity = e;
	}

	/**
	 * @return the dept
	 */
	@Column(columnDefinition="nvarchar(50)",name="Dept")
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
	 * @return the position
	 */
	@Column(columnDefinition="nvarchar(50)",name="Position")
	public String getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(String p) {
		position = p;
	}

	/**
	 * @return the title
	 */
	@Column(columnDefinition="nvarchar(50)",name="Title")
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
	 * @return the echoKey
	 */
	@Column(columnDefinition="nvarchar(100)",name="EchoKey")
	public String getEchoKey() {
		return echoKey;
	}

	/**
	 * @param echoKey the echoKey to set
	 */
	public void setEchoKey(String ek) {
		echoKey = ek;
	}

	/**
	 * @return the dndReason
	 */
	@Column(columnDefinition="nvarchar(255)", name="DNDReason")
	public String getDndReason() {
		return dndReason;
	}

	/**
	 * @param dndReason the dndReason to set
	 */
	public void setDndReason(String dndr) {
		dndReason = dndr;
	}

	/**
	 * @return the disabled
	 */
	@Column(name="Disabled")
	public boolean getDisabled() {
		return disabled;
	}

	/**
	 * @param disabled the disabled to set
	 */
	public void setDisabled(boolean d) {
		disabled = d;
	}

	/*
	 * default constructor required by hibernate
	 */
	public AATUser() {
	}

	/**
	 * @param uid
	 */	
	public AATUser(String fName, String lName, String a){
		setAppFn(fName);
		setAppLn(lName);
		setFullMatch(true);
		setDoNotRemove(true);
		setUidMatch(true);
		setLnIdMatch(true);
		setFnLnMatch(true);
		setFnIdMatch(true);
		setEidMatch(true);
		if (a != null && a != "") {
			setApp(a);
		}
	}
	
	@Override
	public String toString() {
		//TODO correct this function
		return "uid = " + getUid() + ", name = " + getAppFn() + " " + getAppLn();
	}
}