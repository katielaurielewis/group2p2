package com.revature;

import static io.javalin.apibuilder.ApiBuilder.*;


import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.utils.HibernateUtil;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {

		try(Session ses = HibernateUtil.getSession()){
			System.out.println("Hello you have a Connection to your DB with Hibernate!");
			HibernateUtil.closeSession(); //if you want to leave this connection test in, close the session within the try
		} catch (HibernateException e) {
			System.out.println("DB connection failed!!");
			e.printStackTrace();
		}

	}

}
