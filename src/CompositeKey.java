/**
 * 
 */
package com.bjc.ekk.cleanup;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author ekk9418
 *
 */
@Embeddable
public class CompositeKey implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String uid;
	private String eid;
	private String appMiscInfo;
	private String app;
	
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	/**
	 * @return the uid
	 */
	@Column(columnDefinition="nvarchar(25)", nullable=false,updatable=false,insertable=false, name="UID")
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
	 * @return the eid
	 */
	@Column(columnDefinition="nvarchar(40)", nullable=false,updatable=false,insertable=false, name="EID")
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
	 * @return the appMiscInfo
	 */
	@Column(columnDefinition="nvarchar(255)",name="AppMiscInfo", nullable=false,updatable=false,insertable=false)
	public String getAppMiscInfo() {
		return appMiscInfo;
	}

	/**
	 * @param appMiscInfo the appMiscInfo to set
	 */
	public void setAppMiscInfo(String ami) {
		appMiscInfo = ami;
	}

	/**
	 * @return the app
	 */
	@Column(columnDefinition="nvarchar(25)",name="App", nullable=false,updatable=false,insertable=false)
	public String getApp() {
		return app;
	}

	/**
	 * @param app the app to set
	 */
	public void setApp(String a) {
		app = a;
	}
	
	public CompositeKey() {
	}
	
	/**
	 * @param uid
	 * @param eid
	 * @param appMiscInfo
	 * @param app
	 */
	public CompositeKey(String ami, String a) {
		if (a == "" || a == null) {
			setApp("CCOW");
		} else {
			setApp(a);
		}
		if (ami == "" || ami == null) {
			appMiscInfo = "misc";
		} else {
			setAppMiscInfo(ami);
		}
		setEid("a");
		setUid("b");
	}
	
	public int hashCode() {
		int tmp = 0;
		tmp = (uid + eid + app + appMiscInfo).hashCode();
		return tmp;
	}
	
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!this.getClass().equals(obj.getClass())) {
			return false;
		}
		CompositeKey obj2 = (CompositeKey) obj;
		if (uid.equals(obj2.getUid()) && eid == obj2.getEid() && appMiscInfo.equals(obj2.getAppMiscInfo()) && app.equals(obj2.getApp())) {
			return true;
		} 
		
		return false;
	} 
}