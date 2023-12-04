package com.teamfighttactics.teamfighttactics.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Aspect
@Slf4j
@Component
public class HeroAspect {
    @Pointcut("execution(* com.teamfighttactics.teamfighttactics.service.impl.HeroServiceImpl.getHeroDto(int))")
    public void logPointcutWithExecution(){
        log.info("In aspect");
    }

    @Before("logPointcutWithExecution()")
    public void beforeGet(JoinPoint joinPoint) {
        log.info("----------------------------");
        log.info("Before: " + joinPoint.getArgs()[0]);
        log.info(joinPoint.getSignature().getName());
        log.info("----------------------------");
    }
    @Around("logPointcutWithExecution()")
    public Object  aroundGet(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("----------------------------");
        log.info("Around: " + joinPoint.getArgs()[0]);
        log.info(joinPoint.getSignature().getName());
        final Object result = joinPoint.proceed();
        if (Objects.nonNull(result)) {
            log.info("nonNull return value: {}", result);
        } else {
            log.info("Null ");
        }
        log.info("----------------------------");
        return result;

    }


    @After("logPointcutWithExecution()")
    public void afterGet(JoinPoint joinPoint) {
        log.info("----------------------------");
        log.info("After: " + joinPoint.getArgs()[0]);
        log.info(joinPoint.getSignature().getName());
        log.info("----------------------------");
    }


    @Pointcut("execution(* com.teamfighttactics.teamfighttactics.service.impl.*.*(..))")
    public void allServicelogPointcutWithExecution(){
        log.info("In aspect");
    }

    @After("allServicelogPointcutWithExecution()")
    public void afterAllService(JoinPoint joinPoint) {
        log.info("----------------------------");
        log.info("After Service");
        log.info(joinPoint.getSignature().getName());
        log.info("----------------------------");
    }

}
