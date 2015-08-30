/**
 * 
 */
package com.bjc.ekk.cleanup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * @author ekk9418
 *
 */
public class CcowCleanerMain {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		Session adSession = HibernateUtil.getSessionFactoryAd().openSession();//central app db
		
		Criteria crAd = adSession.createCriteria(ADUser.class);
		crAd.add(Restrictions.eq("dis",Boolean.TRUE));
		crAd.add(Restrictions.ilike("uid", "%-ts"));
		ArrayList<ADUser> adList = castList(ADUser.class, crAd.list());
		
		adSession.flush();
		adSession.clear();
		adSession.close();
		
		
		Session utSession = HibernateUtil.getSessionFactoryUt().openSession();

		Criteria crCcow = utSession.createCriteria(CcowUser.class);
		ArrayList<CcowUser> ccowList = castList(CcowUser.class, crCcow.list());
		
		Criteria crCd = utSession.createCriteria(ClinDeskUser.class);
		ArrayList<ClinDeskUser> cdList = castList(ClinDeskUser.class, crCd.list());
		
		Criteria crNg = utSession.createCriteria(NGUser.class);
		crNg.add(Restrictions.eq("deactivated", Boolean.FALSE));
		ArrayList<NGUser> ngList = castList(NGUser.class, crNg.list());

		utSession.flush();
		utSession.clear();
		utSession.close();
		
		
		Session ekSession = HibernateUtil.getSessionFactoryEk().openSession();
		
		Criteria crWashU = ekSession.createCriteria(WUuser.class/*AllWashU.classWashuBJC.class*/);//, "w");
		ArrayList<WUuser> wuList = castList(WUuser.class,crWashU.list());//new ArrayList<WUuser>();
		
		ekSession.flush();
		ekSession.clear();
		ekSession.close();
		
		
		Session atSession = HibernateUtil.getSessionFactoryAt().openSession();//term table
		
		Criteria crTerm = atSession.createCriteria(AATUser.class);
		crTerm.add(Restrictions.eq("doNotRemove", Boolean.FALSE));
		crTerm.add(Restrictions.eq("app", "CCOW"));
		ArrayList<AATUser> termList = castList(AATUser.class, crTerm.list());
		
		atSession.flush();
		atSession.clear();
		atSession.close();
		
		
		ArrayList<NewCcowUsr> remove = new ArrayList<NewCcowUsr>();
		ArrayList<NewCcowUsr> addU = new ArrayList<NewCcowUsr>();
		
		HashMap<String,ClinDeskUser> cdUsers = new HashMap<String,ClinDeskUser>();
		HashMap<String,ADUser> adUsers = new HashMap<String,ADUser>();
		HashMap<String,NGUser> ngUsers = new HashMap<String,NGUser>();
		HashMap<String,WUuser> wuIds = new HashMap<String,WUuser>();
		HashMap<String,WUuser> wuBjc = new HashMap<String,WUuser>();
		HashMap<String,CcowUser> ccowUsers = new HashMap<String,CcowUser>();
		
		for (ClinDeskUser u : cdList) {
			cdUsers.put(u.getUid(), u);
		}
		
		for (ADUser u : adList) {
			adUsers.put(u.getUid(),u);
		}
		
		for (WUuser w : wuList) {
			//TODO get wu id's to add/remove in ccow
			wuIds.put(w.getWuID(),w);
			wuBjc.put(w.getBjcID(), w);
		}
		
		for (int i=0;i<termList.size();i++) {
			//TODO this only terms some users from the term list
			for (int j=0;j<ccowList.size();j++) {
				if (termList.get(i).getUid().equals(ccowList.get(j).getUid())) {
					remove.add((new NewCcowUsr(ccowList.get(j).getUid(),ccowList.get(j).getFn(),ccowList.get(j).getLn())));
					ccowList.remove(j);
					termList.remove(i);
					break;
				}
			}
		}
		for (AATUser u : termList) {
			System.out.println(u.getAppFn() + " " + u.getAppLn() + " " + u.getUid());
		}
		
		for (int i=0;i<ccowList.size();i++) {
			CcowUser cu = ccowList.get(i);
			if (cu.getAppEntryData().split(",").length < 2) {
				remove.add(new NewCcowUsr(cu.getUid(),cu.getFn(),cu.getLn()));
				ccowList.remove(i);
			}
		}
		
		for (CcowUser c : ccowList) {
			ccowUsers.put(c.getUid(), c);
		}
		
		CleanerMethods cm = new CleanerMethods();
		
		cm.setAllSuffix(ccowList);
		HashMap<String,HashMap<String,CcowUser>> myMap = new HashMap<String,HashMap<String,CcowUser>>();
		myMap = cm.getAllSuffix();
		
		for (NGUser n : ngList) {
			ngUsers.put(n.getUid(), n);

			if (cdUsers.containsKey(n.getAdid())) {
				ClinDeskUser c = cdUsers.get(n.getAdid());
				
				if (wuBjc.containsKey(n.getAdid())) {
					WUuser w = wuBjc.get(n.getAdid());
					
					if (!ccowUsers.containsKey(c.getUid())) {
						NewCcowUsr u = new NewCcowUsr();
						u.setUid(c.getUid());
						
						if (w.getFamiliarName() != null && w.getFamiliarName() != "") {
							//TODO ! .equals instead of !=
							u.setFn(w.getFamiliarName());
						}
						else if (n.getFn() != null  && n.getFn() != "" && n.getFn().length() > c.getFn().length() && n.getFn().length() > w.getFn().length()) {
							u.setFn(n.getFn());
						}
						else if (c.getFn() != null && c.getFn() != "" && c.getFn().length() > w.getFn().length()) {
							u.setFn(c.getFn());
						}
						else {
							u.setFn(w.getFn());
						}
						if (u.getFn().length() < 1) {
							u.setFn(u.getUid().substring(0, 1));
						}
						
						
						if (n.getLn().length() > c.getLn().length() && n.getLn() != null && n.getLn() != "" && n.getLn().length() > w.getLn().length()) {
							u.setLn(n.getLn());
						}
						else if (c.getLn() != null && c.getLn() != "" && c.getLn().length() > w.getLn().length()){
							u.setLn(c.getLn());
						}
						else {
							u.setLn(w.getLn());
						}
						if (u.getLn().length() < 1) {
							u.setLn(u.getUid().substring(0, 1));
						}
						//TODO verify no wusm_channelhealth suffix is being deleted based on ORM class
						u.setSuffixList("bjc_nextgen:" + n.getUid() + ",bjc_clindesk:" + c.getUid() + ",wusm_channelhealth:" + w.getWuID());
						addU.add(u);
					}
				}
				else {
				
					if (!ccowUsers.containsKey(c.getUid())) {
						NewCcowUsr u = new NewCcowUsr();
						u.setUid(c.getUid());
						
						if (c.getFn() == null || c.getFn() == "" || n.getFn().length() > c.getFn().length()) {
							u.setFn(n.getFn());
						} else {
							u.setFn(c.getFn());
						}
						if (u.getFn().length() < 1) {
							u.setFn(u.getUid().substring(0, 1));
						}
						
						if (n.getLn().length() > c.getLn().length() || c.getLn() == null || c.getLn() == "") {
							u.setLn(n.getLn());
						} else {
							u.setLn(c.getLn());
						}
						if (u.getLn().length() < 1) {
							u.setLn(u.getUid().substring(0, 1));
						}
						
						u.setSuffixList("bjc_nextgen:" + n.getUid() + ",bjc_clindesk:" + c.getUid());
						addU.add(u);
					}
				}
			}
			
			if (wuBjc.containsKey(n.getAdid())) {
				WUuser w = wuBjc.get(n.getAdid());
				
				if (!ccowUsers.containsKey(w.getBjcID())) {
					NewCcowUsr u = new NewCcowUsr();
					u.setUid(w.getBjcID());
					
					if (w.getFamiliarName() != null) {
						u.setFn(w.getFamiliarName());
						//TODO ! .equals instead of !=
					}
					else if (w.getFn() == null || w.getFn() == "" || n.getFn().length() > w.getFn().length()) {
						u.setFn(n.getFn());
					} else {
						u.setFn(w.getFn());
					}
					if (u.getFn().length() < 1) {
						u.setFn(u.getUid().substring(0, 1));
					}
					
					if (n.getLn().length() > w.getLn().length() || w.getLn() == null || w.getLn() == "") {
						u.setLn(n.getLn());
					} else {
						u.setLn(w.getLn());
					}
					if (u.getLn().length() < 1) {
						u.setLn(u.getUid().substring(0, 1));
					}
					
					u.setSuffixList("bjc_nextgen:" + n.getUid() + ",wusm_channelhealth:" + w.getWuID());
					addU.add(u);
				}
			}
		}
		
		for (ClinDeskUser c : cdList) {
			if (wuBjc.containsKey(c.getUid())) {
				WUuser w = wuBjc.get(c.getUid());
				
				if (!ccowUsers.containsKey(w.getBjcID())) {
					NewCcowUsr u = new NewCcowUsr();
					u.setUid(w.getBjcID());
					
					if(w.getFamiliarName() != null) {
						u.setFn(w.getFamiliarName());
						//TODO ! .equals instead of !=
					}
					else if (w.getFn() == null || w.getFn() == "" || c.getFn().length() > w.getFn().length()) {
						u.setFn(c.getFn());
					} else {
						u.setFn(w.getFn());
					}
					if (u.getFn().length() < 1) {
						u.setFn(u.getUid().substring(0, 1));
					}
					
					if (c.getLn().length() > w.getLn().length() || w.getLn() == null || w.getLn() == "") {
						u.setLn(c.getLn());
					} else {
						u.setLn(w.getLn());
					}
					if (u.getLn().length() < 1) {
						u.setLn(u.getUid().substring(0, 1));
					}
					
					u.setSuffixList("bjc_clindesk:" + c.getUid() + ",wusm_channelhealth:" + w.getWuID());
					addU.add(u);
				}
			}
		}
		
		for (Map.Entry<String, HashMap<String,CcowUser>> app : myMap.entrySet()) {
			if (app.getKey().equals("bjc_nextgen")) {
				HashMap<String,CcowUser> idMap = new HashMap<String,CcowUser>();
				idMap = app.getValue();
				for (Map.Entry<String, CcowUser> id : idMap.entrySet()) {
					for (int i=0;i<addU.size();i++) {
						if (addU.get(i).equals(id.getValue())) {
							addU.remove(i);
						}
						else if (addU.get(i).getUid().equals(id.getValue().getUid())) {
							addU.remove(i);
						}
					}
					if (!ngUsers.containsKey(id.getKey())) {
						//TODO if list of ng users contains id.getValue() then correct the suffix. else:
						cm.setRemoveSuffix(id.getValue().getUid(), id.getValue().getLn(), id.getValue().getFn(), app.getKey(), id.getKey());
					}
					else {
						//TODO should verify name is correct
					}
				}
			}
			
			else if (app.getKey().equals("bjc_clindesk")) {
				HashMap<String,CcowUser> idMap = new HashMap<String,CcowUser>();
				idMap = app.getValue();
				for (Map.Entry<String, CcowUser> id : idMap.entrySet()) {
					for (int i=0;i<addU.size();i++) {
						if (addU.get(i).equals(id.getValue())) {
							addU.remove(i);
						}
						else if (addU.get(i).getUid().equals(id.getValue().getUid())) {
							addU.remove(i);
						}
					}
					if (!cdUsers.containsKey(id.getKey())) {//cdIds.contains(id.getKey())) {
						//TODO if list of cd users contains id.getValue() then correct the suffix. else:
						cm.setRemoveSuffix(id.getValue().getUid(), id.getValue().getLn(), id.getValue().getFn(), app.getKey(), id.getKey());
					}
					else {
						//TODO should verify name is correct
					}
				}
			}
		}

		for (NewCcowUsr u : remove) {
			cm.setRemoveUser(u.getFn(), u.getLn(), u.getUid());
		}
		
		for (NewCcowUsr u : addU) {
			String[] sfxlst = u.getSuffixList().split(","); 
			String[] sfxn = new String[sfxlst.length];
			String[] sid = new String[sfxlst.length];
			for (int i=0;i<sfxlst.length;i++) {
				sfxn[i] = sfxlst[i].split(":")[0];
				sid[i] = sfxlst[i].split(":")[1];
			}
			cm.setAddUser(u.getUid(),u.getLn(),u.getFn(),sfxn,sid);
		}

		new WriteFile(cm.getCcowDeletes());//ccowDeletes is the contents of the xml file that WriteFile creates
	}
	
	public static <T> ArrayList<T> castList(Class<? extends T> clazz, Collection<?> c) {
	    ArrayList<T> r = new ArrayList<T>(c.size());
	    for(Object o: c)
	      r.add(clazz.cast(o));
	    return r;
	}
}