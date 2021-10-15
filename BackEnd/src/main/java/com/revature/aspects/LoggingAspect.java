package com.revature.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	//Instantiate Logger object
	private static Logger log = LogManager.getLogger(LoggingAspect.class);
	
	//DAO method logs --------------------------------------------
	
	//Log everytime a method within the DAO layer
	@Before("within(com.revature.daos.*)")
	public void logDaoMethods(JoinPoint jp) {
		log.info(jp.getTarget() + " invoked " + jp.getSignature());
	}
	
	//Update method is especially important, so we'll log that another time
	@AfterReturning(pointcut="execution(boolean updateAnimeWatchStatus(..))", returning= "returnedBoolean")
	public void logUpdateWatchStatus(JoinPoint jp, Boolean returnedBoolean) {
		if(returnedBoolean) { //if it returns true
			log.warn(jp.getTarget() + " sucessfully changed a record in the Database");
		}
	}
	
	//Service layer logs -----------------------------------------
	
	//Start with the Login Service
	@AfterReturning(pointcut="execution(boolean checkCredentials(..))", returning = "returnedBoolean")
	public void logLogin(JoinPoint jp, Boolean returnedBoolean) {
		if(returnedBoolean) { //on successful login
			log.info("USER LOGIN GRANTED");
		} else { //on failed login
			log.info("USER LOGIN FAILED");
		}
	}
	
}
