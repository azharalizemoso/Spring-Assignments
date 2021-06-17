package com.aopdemo.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AroundAdvice {

    @Pointcut("execution(String doSomething(..))")
    public void advice() {
    }

    @Around("advice()")
    public Object AroundDoSomething(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        Object result = null;

        try {
        result = proceedingJoinPoint.proceed();
        }catch (Exception e){
            System.out.println(e.getMessage());
            result = "Everything is working great!";
        }

        return result;
    }
}
