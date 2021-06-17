package com.aopdemo;

import com.aopdemo.dao.DAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args){

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AOPConfig.class);

        DAO dao = context.getBean(DAO.class);

        try {
        String result =  dao.doSomething("Testing",true);
        System.out.println(result);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
