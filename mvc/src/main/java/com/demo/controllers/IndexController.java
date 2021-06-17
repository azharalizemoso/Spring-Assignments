package com.demo.controllers;

import com.demo.hibernate.HibernateUtil;
import com.demo.hibernate.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

//    @RequestMapping("/")
//    public String showIndex(Model model){
//
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            List<Student> students = session.createQuery("from Student", Student.class).list();
//            Student student = students.get(1);
//            for (Student s :students
//                 ) {
//                System.out.println(s.getFirstName());
//            }
//
//                model.addAttribute("lists",students.toArray());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return "index";
//    }

    @RequestMapping("/")
    public String showIndex(HttpServletRequest request,
                            Model model){

        Transaction transaction = null;

        if (request.getParameter("firstName")!=null && request.getParameter("lastName")!=null
                && request.getParameter("email")!=null){

             Student newStudent = new Student(request.getParameter("firstName"),
                     request.getParameter("lastName"),
                     request.getParameter("email"));
             System.out.println(request.getParameter("fname")+
                     request.getParameter("lname")+
                     request.getParameter("email"));


            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student objects
            session.save(newStudent);
            // commit transaction
            transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }

        }

        if(request.getParameter("ID")!=null){
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {


                Student tempStudent = session.get(Student.class,Integer.parseInt(request.getParameter("ID")) );

                session.beginTransaction();

                session.delete(tempStudent);

                session.getTransaction().commit();

        } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }


        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            List<Student> students = session.createQuery("from Student", Student.class).list();

            model.addAttribute("lists",students.toArray());
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "index";
    }

    @RequestMapping("/newEntry")
    public String formOutput(
            HttpServletRequest request,Model model){

        return "newForm";
    }

    @RequestMapping("/deleteEntry")
    public String deleteEntry(HttpServletRequest request,Model model){

        return "deleteForm";
    }
}
