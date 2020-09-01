package com.michal.pma.logging;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ApplicationLoggerAspect {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(com.michal.pma.controllers..*)" + "|| within(com.michal.pma.dao..*)")
    public void definePackagePointcuts(){
        //empty method
    }

    @After("definePackagePointcuts()")
    public void log(){
        log.debug("----------------------------------------------");
    }
}
