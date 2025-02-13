package com.example.learn.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.learn.spring.service.UserService.introduceUser(..))")
    public void logBefore() {
        System.out.println("Before method execution: LoggingAspect.logBefore()");
    }

    @After("execution(* com.example.learn.spring.service.UserService.introduceUser(..))")
    public void logAfter() {
        System.out.println("After method execution: LoggingAspect.logAfter()");
    }

    @AfterReturning(pointcut = "execution(* com.example.learn.spring.service.UserService.introduceUser(..))", returning = "result")
    public void logAfterReturning(Object result) {
        System.out.println("Method successfully returned with result: " + result);
    }

    @Around("execution(* com.example.learn.spring.service.UserService.introduceUser(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Execution time: " + elapsedTime + " ms");
        return result;
    }
}
