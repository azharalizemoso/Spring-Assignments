package com.aopdemo.dao;

import org.springframework.stereotype.Component;

/**
 * Hello world!
 *
 */
@Component
public class DAO
{
    public String doSomething(String x,boolean withException){

        if(withException){
            throw  new RuntimeException("Exception Caught!");
        }

        
        System.out.println(getClass() + " : Doing my task ie : " + x);

        return x + " Done";
    }
}
