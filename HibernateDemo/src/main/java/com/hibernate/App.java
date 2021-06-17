package com.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.Student;
import com.hibernate.HibernateUtil;

public class App {
    public static void main(String[] args) {

        Student student = new Student("Studentx", "Studenty", "student@student.com");

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {


                Student tempStudent = session.get(Student.class,1);

                session.beginTransaction();

                session.delete(tempStudent);

                session.getTransaction().commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List < Student > students = session.createQuery("from Student", Student.class).list();
            students.forEach(s -> System.out.println(s.getFirstName()));
        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
            e.printStackTrace();
        }
    }
}