/**
 * 
 */
package com.bjc.ekk.cleanup;

/**
 * @author ekk9418
 *
 */
public class NewCcowUsr {
	private String uid;
	private String fn;
	private String ln;
	private String suffixList;
	/**
	 * @return the uid
	 */
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
	 * @return the suffixList
	 */
	public String getSuffixList() {
		return suffixList;
	}
	/**
	 * @param suffixList the suffixList to set
	 */
	public void setSuffixList(String suffixList) {
		this.suffixList = suffixList;
	}
	
	public NewCcowUsr() {
		
	}
	
	/**
	 * @param uid
	 * @param fn
	 * @param ln
	 */
	public NewCcowUsr(String uid, String fn, String ln) {
		this.uid = uid;
		this.fn = fn;
		this.ln = ln;
	}
	
	/**
	 * @param uid
	 * @param fn
	 * @param ln
	 * @param suffixList
	 */
	public NewCcowUsr(String uid, String fn, String ln, String suffixList) {
		this.uid = uid;
		this.fn = fn;
		this.ln = ln;
		this.suffixList = suffixList;
	}
	
	public NewCcowUsr(CcowUser user) {
		uid=user.getUid();
		fn=user.getFn();
		ln=user.getLn();
		suffixList = user.getAppEntryData();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "NewCcowUsr [" + (uid != null ? "uid=" + uid + ", " : "")
				+ (fn != null ? "fn=" + fn + ", " : "")
				+ (ln != null ? "ln=" + ln + ", " : "")
				+ (suffixList != null ? "suffixList=" + suffixList : "") + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		
		if (this == obj) {
			return true;
		}
		
		
		if (obj.getClass() == CcowUser.class){
			CcowUser user = (CcowUser) obj;
			if (!uid.equals(user.getUid())) {
				return false;
			}
			else {
				return true;
			}
		}
		else if (getClass() != obj.getClass()) {
			return false;
		}
		
		NewCcowUsr other = (NewCcowUsr) obj;
		if (fn == null) {
			if (other.fn != null)
				return false;
		} else if (!fn.equals(other.fn))
			return false;
		if (ln == null) {
			if (other.ln != null)
				return false;
		} else if (!ln.equals(other.ln))
			return false;
		if (suffixList == null) {
			if (other.suffixList != null)
				return false;
		} else if (!suffixList.equals(other.suffixList))
			return false;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		return true;
	}
}