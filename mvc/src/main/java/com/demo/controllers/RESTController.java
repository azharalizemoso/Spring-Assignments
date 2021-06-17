package com.demo.controllers;

import com.demo.hibernate.HibernateUtil;
import com.demo.hibernate.Student;
import org.hibernate.Session;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class RESTController {

    @GetMapping("students")
    public String getStudents(){

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Student> students = session.createQuery("from Student", Student.class).list();
            return "Result";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
