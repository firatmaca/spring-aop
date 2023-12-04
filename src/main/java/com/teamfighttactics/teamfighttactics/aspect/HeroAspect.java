package com.teamfighttactics.teamfighttactics.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HeroAspect {
    @Pointcut("execution(* com.teamfighttactics.teamfighttactics.service.impl.HeroServiceImpl.getHeroDto(int))")
    public void logPointcutWithExecution(){
        System.out.println("In aspect");
    }

    @Before("logPointcutWithExecution()")
    public void beforeGet(JoinPoint joinPoint) {
        System.out.println("----------------------------");
        System.out.println("Before: " + joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
        System.out.println("----------------------------");
    }


    @After("logPointcutWithExecution()")
    public void afterGet(JoinPoint joinPoint) {
        System.out.println("----------------------------");
        System.out.println("After: " + joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
        System.out.println("----------------------------");
    }


    @Pointcut("execution(* com.teamfighttactics.teamfighttactics.service.impl.*.*(..))")
    public void allServicelogPointcutWithExecution(){
        System.out.println("In aspect");
    }

    @After("allServicelogPointcutWithExecution()")
    public void afterAllService(JoinPoint joinPoint) {
        System.out.println("----------------------------");
        System.out.println("After Service");
        System.out.println(joinPoint.getSignature());
        System.out.println("----------------------------");
    }

}
