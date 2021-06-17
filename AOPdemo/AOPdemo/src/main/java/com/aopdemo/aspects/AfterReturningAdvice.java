package com.aopdemo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterReturningAdvice {

    @Pointcut("execution(String doSomething(..))")
    public void advice(){}

    @AfterReturning(value = "advice()",returning = "result")
    public void AfterReturnDoSomething(JoinPoint joinPoint,String result){

        System.out.println(">>>>> Executing @AfterReturning for doSomething() with return result : "+
                result);

        result = result.toUpperCase();

        System.out.println(result);
    }
}
