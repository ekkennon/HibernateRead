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
@Table(name="Gen_NextGen")
public class NGUser implements User {
	private String guid;
	private String uid;
	private String fn;
	private String ln;
	private String mi;
	private String title;
	private Date lastImported;
	private String adid;
	private boolean deactivated;
	
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
	 * @return the deactivated
	 */
	@Column(name="Deactivated")
	public boolean getDeactivated() {
		return deactivated;
	}
	
	/**
	 * @param deactivated the deactivated to set
	 */
	public void setDeactivated(boolean d) {
		deactivated = d;
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
	 * @return the mi
	 */
	@Column(length=10, name="MI")
	public String getMi() {
		return mi;
	}
	
	/**
	 * @param mi the mi to set
	 */
	public void setMi(String m) {
		mi = m;
	}
	
	/**
	 * @return the title
	 */
	@Column(length=5, name="Title")
	public String getTitle() {
		return title;
	}
	
	/**
	 * @param
	 */
	public void setTitle(String t) {
		title = t;
	}
	
	/**
	 * @return the adid
	 */
	@Column(length=25, name="ADID")
	public String getAdid() {
		return adid;
	}

	/**
	 * @param adid the adid to set
	 */
	public void setAdid(String adid) {
		this.adid = adid;
	}

	@Override
	public String toString() {
		return "NextGen id = " + getUid() + ", name = " + getFn() + " " + getMi() + " " + getLn() + ", AD ID = " + getAdid() + ";";
	}
	
	public NGUser() {
		
	}
	
	public NGUser(String ln, String fn, String m, String t, String id, String ad){
		setUid(id);
		setFn(fn);
		setLn(ln);
		setAdid(ad);
		setMi(m);
		setTitle(t);
	}
}