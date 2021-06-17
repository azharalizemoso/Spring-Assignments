package com.aopdemo.aspects;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterAdvice {

        @Pointcut("execution(public String doSomething(..))")
        public void advice(){}

        @After("advice()")
        public void afterDoSomething(){
            System.out.println(">>>>> Executing @After for doSomething()");
        }

}
