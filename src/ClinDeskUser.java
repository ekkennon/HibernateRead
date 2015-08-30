/**
 * 
 */
package com.hread;

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
@Table(name="Gen_ClinDesk")
public class ClinDeskUser implements User {
	private String guid;
	private String uid;
	private String eid;
	private String fn;
	private String ln;
	private String mi;
	private String date;
	private String dateCreated;
	private Date lastImported;
	
	/**
	 * @return the guid
	 */
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2", parameters = {})
    @GeneratedValue(generator = "uuid")
	@Column(columnDefinition="uniqueidentifier default newId()",name="GUID")
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
	 * @return the uid
	 */
	@Column(nullable=false, length=25, name="UID")
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
	@Column(length=25, name="FN")
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
	@Column(length=35, name="LN")
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
	 * @return the lastImported
	 */
	@Column(name="LastImported",columnDefinition="datetime default getDate()")
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
	 * @return the eid
	 */
	@Column(length=15, name="EID")
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
	 * @return the mi
	 */
	@Column(length=1, name="MI")
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
	 * @return the date
	 */
	@Column(length=10,name="Date")
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the dateCreated
	 */
	@Column(length=10,name="DateCreated")
	public String getDateCreated() {
		return dateCreated;
	}

	/**
	 * @param dateCreated the dateCreated to set
	 */
	public void setDateCreated(String created) {
		dateCreated = created;
	}

	/*
	 * default constructor required by hibernate
	 */
	public ClinDeskUser() {
	}

	/**
	 * @param uid
	 */	
	public ClinDeskUser(String id){
		setUid(id);
	}
	
	@Override
	public String toString() {
		//TODO correct this method
		return "uid = " + getUid() + ", name = " + getFn() + " " + getLn() + ", Apps: "  + ";";
	}
}