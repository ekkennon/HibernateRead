/**
 * 
 */
package com.bjc.ekk.cleanup;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * @author ekk9418
 *
 */
@Entity
@Immutable
@Table(name="WashuBjc")
public class WUuser {
	 private String wuID;
	 private String ln;
	 private String fn;
	 private String mi;
	 private String familiarName;
	 private String bjcID;
	 
	/**
	 * @return the wuID
	 */
	 @Id
	 @Column(name="samaccountname")
	public String getWuID() {
		return wuID;
	}
	 
	/**
	 * @param wuID the wuID to set
	 */
	public void setWuID(String wuID) {
		this.wuID = wuID;
	}
	
	/**
	 * @return the ln
	 */
	@Column(name="sn")
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
	 * @return the fn
	 */
	@Column(name="givenname")
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
	 * @return the mi
	 */
	@Column(name="initials")
	public String getMi() {
		return mi;
	}
	
	/**
	 * @param mi the mi to set
	 */
	public void setMi(String mi) {
		this.mi = mi;
	}
	
	/**
	 * @return the familiarName
	 */
	@Column(name="familiarname")
	public String getFamiliarName() {
		return familiarName;
	}
	
	/**
	 * @param familiarName the familiarName to set
	 */
	public void setFamiliarName(String familiarName) {
		this.familiarName = familiarName;
	}
	
	/**
	 * @return the bjcID
	 */
	@Column(name="bjcnt_UserID")
	public String getBjcID() {
		return bjcID;
	}
	
	/**
	 * @param bjcID the bjcID to set
	 */
	public void setBjcID(String bjcID) {
		this.bjcID = bjcID;
	}
	
	public WUuser() {
		
	}
	
	/**
	 * @param wuID
	 * @param ln
	 * @param fn
	 * @param mi
	 * @param familiarName
	 * @param bjcID
	 */
	public WUuser(String wuID, String ln, String fn, String mi, String familiarName, String bjcID) {
		setWuID(wuID);
		setLn(ln);
		setFn(fn);
		setMi(mi);
		setFamiliarName(familiarName);
		setBjcID(bjcID);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getWuID() + " is " + getFn() + getMi() + getLn() + " (goes by " + getFamiliarName() + " and bjcID=" + getBjcID();
	}
}