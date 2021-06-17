package com.aopdemo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(1)
public class FirstBeforeAdvice {

    @Pointcut("execution(public String doSomething(..))")
    public void advice(){}

    @Before("advice()")
    public void firstBeforeDoSomething(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println(">>>>> Executing First @Before for doSomething() with method signature as " +
            methodSignature);

        Object[] args = joinPoint.getArgs();

        for (Object ob : args){
            System.out.println("Args : " + ob);
        }
    }

}
