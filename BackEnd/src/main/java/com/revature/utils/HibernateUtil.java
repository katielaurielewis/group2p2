package com.revature.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class HibernateUtil {
	
	@Autowired
	private ApplicationContext context;
	
	
	private static Configuration config = new Configuration().configure("hibernate.cfg.xml")
			.setProperty("hibernate.connection.username", System.getenv("username"))
			.setProperty("hibernate.connection.password", System.getenv("password"))
			.setProperty("hibernate.connection.url", System.getenv("url"));
	
	private static SessionFactory sf = config.buildSessionFactory();
	
	private static Session ses;
	
	public static Session getSession() {
		if (ses == null) {
			ses = sf.openSession();
		}
		return ses;
	}
	
	public static void closeSession() {
		ses.close();
		ses = null;
	}

}
