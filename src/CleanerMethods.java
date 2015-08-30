/**
 * 
 */
package com.bjc.ekk.cleanup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author ekk9418
 *
 */
public class CleanerMethods {
	private String ccowDeletes = "";//string of contents of xml file to create
	private HashSet<String> apps = new HashSet<String>();
	private HashMap<String,HashMap<String,CcowUser>> allSuffix = new HashMap<String,HashMap<String,CcowUser>>();
	private final String[] SUFFIXES = {"acceptor", "vault", "bjc_clindesk", "bjc_nextgen", "dbmotionsmartagent", "slch_wellsoft", "wu_channelhealth"};
	private ArrayList<String> deletes = new ArrayList<String>();
	private HashMap<String,ArrayList<String>> ids = new HashMap<String,ArrayList<String>>();
	
	public CleanerMethods() {
		ccowDeletes = "<?xml version=\"1.0\"?><userList xmlns=\"http://www.sentillion.com\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.sentillion.com uma.xsd\">";
		setIds();
	}
	
	public void setIds() {
		ids.put("ru", new ArrayList<String>());
		ids.put("au", new ArrayList<String>());
		ids.put("rs", new ArrayList<String>());
	}
	
	public void setRemoveSuffix(String uid, String ln, String fn, String sfxn, String sid) {
		boolean rs = false;//remove suffix
		boolean au = false;//add user
		boolean ru = false;//remove user
		
		for (Map.Entry<String, ArrayList<String>> idList : ids.entrySet()) {
			if (idList.getKey() == "rs") {//remove suffix
				if (idList.getValue().contains(uid)) {
					rs = true;
				}
			}
			else if (idList.getKey() == "au") {//add user
				if (idList.getValue().contains(uid)) {
					au = true;
				}
			}
			else if (idList.getKey() == "ru") {//remove user
				if (idList.getValue().contains(uid)) {
					ru = true;
				}
			}
			else {
				System.out.println("ids Map has incorrect Key: " + idList.getKey());
			}
		}
		
		if (!rs && !au && !ru) {
			if (!uid.equals("ABC1234") && !uid.equals("TEST USER ID")) {
				ccowDeletes += "\n<user action=\"update\"><uid>" + uid + "</uid><sn>" + ln + "</sn><givenName>" + fn + "</givenName><appEntryList><appEntry action=\"delete\"><logonSuffix>" + sfxn + "</logonSuffix><logonId>" + sid + "</logonId></appEntry></appEntryList></user>";
			}
			ids.get("rs").add(uid);
		}
		else if (ru) {
			System.out.println(uid + " is being deleted from CCOW instead of having a suffix removed");
		}
		else if (au) {
			System.out.println(uid + " is being added to CCOW instead of having a suffix removed");
		}
		else if (rs) {
			//user is already having a suffix removed and nothing needs to be done
		}
		else {
			System.out.println("rs = " + rs + ", au = " + au + ", ru = " + ru);
		}
	}
	
	public void setAddUser(String uid, String ln, String fn, String[] sfxn, String[] sid) {
		boolean rs = false;//remove suffix
		boolean au = false;//add user
		boolean ru = false;//remove user
		
		for (Map.Entry<String, ArrayList<String>> idList : ids.entrySet()) {
			if (idList.getKey() == "rs") {//remove suffix
				if (idList.getValue().contains(uid)) {
					rs = true;
				}
			}
			else if (idList.getKey() == "au") {//add user
				if (idList.getValue().contains(uid)) {
					au = true;
				}
			}
			else if (idList.getKey() == "ru") {//remove user
				if (idList.getValue().contains(uid)) {
					ru = true;
				}
			}
			else {
				System.out.println("ids Map has incorrect Key: " + idList.getKey());
			}
		}
		
		if (!rs && !au && !ru) {
			if (!uid.equals("ABC1234") && !uid.equals("TEST USER ID")) {
				ccowDeletes += "\n<user action=\"replace\"><uid>" + uid + "</uid><sn>" + ln + "</sn><givenName>" + fn + "</givenName><appEntryList>";
				if (sfxn.length == sid.length) {
					for (int i=0;i<sfxn.length;i++) {
						ccowDeletes += "<appEntry action=\"replace\"><logonSuffix>" + sfxn[i] + "</logonSuffix><logonId>" + sid[i] + "</logonId></appEntry>";
					}
				} else {
					System.out.println("error creating ccow account for " + uid);
				}
				ccowDeletes += "</appEntryList></user>";
				ids.get("au").add(uid);
			}
		}
		else if (rs) {
			System.out.println(uid + " will have a suffix removed instead of being added to CCOW");
		}
		else if (ru) {
			System.out.println(uid + " is being removed from CCOW instead of added");
		}
		else if (au) {
			//user is already being added and nothing needs to be done
		}
		else {
			System.out.println("rs = " + rs + ", au = " + au + ", ru = " + ru);
		}
	}
	
	public String getCcowDeletes() {
		return ccowDeletes;
	}
	
	public ArrayList<String> getDeletes() {
		return deletes;
	}
	
	public HashMap<String,HashMap<String,CcowUser>> getAllSuffix() {
		return allSuffix;
	}
	
	public void setAllSuffix(ArrayList<CcowUser> userlist) {
		for (CcowUser u : userlist) {
			String[] sfxLst = u.getAppEntryData().split(",");
			for (int i=0;i<sfxLst.length;i++) {
				String[] sfxPr = sfxLst[i].split(":");
				if (allSuffix.containsKey((sfxPr[0]))) {
					if (!(allSuffix.get(sfxPr[0]).containsKey(sfxPr[1]))) {
						allSuffix.get(sfxPr[0]).put(sfxPr[1],u);
					}
					else {
						setRemoveSuffix(u.getUid(),u.getLn(),u.getFn(),sfxPr[0],sfxPr[1]);
						setRemoveSuffix(allSuffix.get(sfxPr[0]).get(sfxPr[1]).getUid(),allSuffix.get(sfxPr[0]).get(sfxPr[1]).getLn(),allSuffix.get(sfxPr[0]).get(sfxPr[1]).getFn(),sfxPr[0],sfxPr[1]);
						allSuffix.get(sfxPr[0]).remove(sfxPr[1]);
						//removes duplicates for each suffix
					}
				}
				else if (Arrays.asList(SUFFIXES).contains(sfxPr[0])){
					allSuffix.put(sfxPr[0], new HashMap<String, CcowUser>());
					allSuffix.get(sfxPr[0]).put(sfxPr[1],u);
				}
				else {
					setRemoveSuffix(u.getUid(),u.getLn(),u.getFn(),sfxPr[0],sfxPr[1]);
				}
			}
		}
	}
	
	public boolean setApps(String app) {
		if (!apps.contains(app)) {//if current suffix is already in apps then ignore
			//verify suffix being looked at is currently active
			if (Arrays.asList(SUFFIXES).contains(app)) {
				apps.add(app);
			}
			else {
				return true;//delete suffix because it is not currently active for ccow
			}
		}
		return false;
	}
	
	//add next row to text string which will be written to xml file
	public void setRemoveUser(String fn, String ln, String uid) {
		boolean rs = false;//remove suffix
		boolean au = false;//add user
		boolean ru = false;//remove user
		
		for (Map.Entry<String, ArrayList<String>> idList : ids.entrySet()) {
			if (idList.getKey() == "rs") {//remove suffix
				if (idList.getValue().contains(uid)) {
					rs = true;
				}
			}
			else if (idList.getKey() == "au") {//add user
				if (idList.getValue().contains(uid)) {
					au = true;
				}
			}
			else if (idList.getKey() == "ru") {//remove user
				if (idList.getValue().contains(uid)) {
					ru = true;
				}
			}
			else {
				System.out.println("ids Map has incorrect Key: " + idList.getKey());
			}
		}
		
		if (!rs && !au && !ru) {
			if (!uid.equals("ABC1234") && !uid.equals("TEST USER ID")) {
				ccowDeletes += "\n<user action=\"delete\"><uid>" + uid + "</uid><sn>" + ln + "</sn><givenName>" + fn + "</givenName></user>";
			}
			ids.get("ru").add(uid);
		}
		else if (rs) {
			System.out.println(uid + " will have a suffix removed instead of being removed from CCOW");
		}
		else if (au) {
			System.out.println(uid + " is being added to CCOW instead of removed");
		}
		else if (ru) {
			//user is already being removed and nothing needs to be done
		}
		else {
			System.out.println("rs = " + rs + ", au = " + au + ", ru = " + ru);
		}
	}
}