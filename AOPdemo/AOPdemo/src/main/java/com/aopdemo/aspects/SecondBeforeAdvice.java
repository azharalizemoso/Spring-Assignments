package com.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class SecondBeforeAdvice {

    @Pointcut("execution(public String doSomething(..))")
    public void advice(){}

    @Before("advice()")
    public void secondBeforeDoSomething(){
        System.out.println(">>>>> Executing Second @Before for doSomething()");
    }
}
