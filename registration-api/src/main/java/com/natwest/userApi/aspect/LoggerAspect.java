package com.natwest.userApi.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Before(value = "execution(* com.natwest.userApi.controller.UserController.saveUser(..))")
	public void logBeforeSaveUser(JoinPoint joinpoint) {
		log.info("***********");
		log.info(joinpoint.getSignature().getName() );
		
	}
	@After(value = "execution(* com.natwest.userApi.controller.UserController.saveUser(..))")
	public void logAfterSaveUser(JoinPoint joinpoint) {
		log.info("***********");
		log.info("Method arguments are:" + Arrays.toString(joinpoint.getArgs()));
		
	}
	

}
