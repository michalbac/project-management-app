package com.michal.pma.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class ApplicationLoggerAspect {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(com.michal.pma.controllers..*)")
    public void definePackagePointcuts(){
        //empty method
    }

    @Around("definePackagePointcuts()")
    public Object logAround(ProceedingJoinPoint joinPoint){
        log.debug("\n \n \n ");
        log.debug("********** Before Method Execution ********** \n {}.{} () with arguments [s] = {}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
        log.debug("_____________________________________________ \n \n \n");

        Object o = null;
        try {
            o = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        log.debug("\n \n \n ");
        log.debug("********** After Method Execution ********** \n {}.{} () with arguments [s] = {}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
        log.debug("_____________________________________________ \n \n \n");

        return o;

    }
}
