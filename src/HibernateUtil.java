/**
 * 
 */
package com.bjc.ekk.cleanup;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * @author ekk9418
 *
 */
public class HibernateUtil {
	
	private static SessionFactory sessionFactoryUt;
	private static ServiceRegistry serviceRegistryUt;
	
	private static SessionFactory sessionFactoryAd;
	private static ServiceRegistry serviceRegistryAd;
	
	private static SessionFactory sessionFactoryEk;
	private static ServiceRegistry serviceRegistryEk;
	
	private static SessionFactory sessionFactoryAt;
	private static ServiceRegistry serviceRegistryAt;
	
	
    static {
        try {
        	Configuration adConfig = new Configuration().addAnnotatedClass(ADUser.class).configure("/hibernate-centralapp.cfg.xml");
        	Configuration atConfig = new Configuration().addAnnotatedClass(AATUser.class).configure("/hibernate-accesstools.cfg.xml");
        	Configuration ekConfig = new Configuration().addAnnotatedClass(WUuser.class).configure("/hibernate-ekkdb.cfg.xml");
        	Configuration utConfig = new Configuration();
        	
        	//atConfig.addAnnotatedClass(WashuBJC.class);
        	//atConfig.addAnnotatedClass(AllWashU.class);
        	
        	utConfig.addAnnotatedClass(CcowUser.class);
        	utConfig.addAnnotatedClass(NGUser.class);
        	utConfig.addAnnotatedClass(ClinDeskUser.class);
        	utConfig.configure("/hibernate-usertables.cfg.xml");
			
			serviceRegistryAd = new StandardServiceRegistryBuilder().applySettings(adConfig.getProperties()).build();
			sessionFactoryAd = adConfig.buildSessionFactory(serviceRegistryAd);
			
			
			serviceRegistryAt = new StandardServiceRegistryBuilder().applySettings(atConfig.getProperties()).build();
			sessionFactoryAt = atConfig.buildSessionFactory(serviceRegistryAt);
			
			
			serviceRegistryEk = new StandardServiceRegistryBuilder().applySettings(ekConfig.getProperties()).build();
			sessionFactoryEk = ekConfig.buildSessionFactory(serviceRegistryEk);
			
			serviceRegistryUt = new StandardServiceRegistryBuilder().applySettings(utConfig.getProperties()).build();
			sessionFactoryUt = utConfig.buildSessionFactory(serviceRegistryUt);
			
        } catch (HibernateException ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            //throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactoryUt() {
        return sessionFactoryUt;
    }
    
    public static SessionFactory getSessionFactoryAd() {
        return sessionFactoryAd;
    }
    
    
    public static SessionFactory getSessionFactoryAt() {
        return sessionFactoryAt;
    }
    
    public static SessionFactory getSessionFactoryEk() {
        return sessionFactoryEk;
    }
}