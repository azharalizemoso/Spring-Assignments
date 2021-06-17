package com.aopdemo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterThrowingAdvice {

    @Pointcut("execution(String doSomething(..))")
    public void advice() {
    }

//    @AfterThrowing(value = "advice()", throwing = "exc")
    public void AfterReturnDoSomething(JoinPoint joinPoint, Exception exc) {

        System.out.println(">>>>> Executing @AfterThrowing for doSomething() with Exception : " +
                exc.getMessage());


    }

}
