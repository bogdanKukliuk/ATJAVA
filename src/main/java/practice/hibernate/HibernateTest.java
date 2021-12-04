package practice.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import practice.hibernate.model.Student;

public class HibernateTest {

    private static SessionFactory sessionFactory = null;

    public static Student setStudent(String myEmail, String myPassword) {
        Student student = new Student();
        student.setMyEmail(myEmail);
        student.setMyPassword(myPassword);
        try {
            sessionFactory = new HibernateUtil().getSessionFactory();
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Student ID=" + session.save(student));
            session.getTransaction().commit();
        }
        catch (Exception e ){ e.printStackTrace(); }
        finally {
            sessionFactory.close();
        }
        return student;
    }

    public static Student getStudent(Integer id) {
        Student student = null;
        try {
            sessionFactory = new HibernateUtil().getSessionFactory();
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            student = session.get(Student.class, id);
            System.out.println("user = " + student.getId());
            session.getTransaction().commit();
        }
        catch (Exception e ){ e.printStackTrace(); }
        finally {
            sessionFactory.close();
        }
        return student;
    }

    public static void main(String[] args) {
        Student student = setStudent("bogdan.kukliuk@gmail.com","bogdan1234344");
//        Student student = getStudent(5);
        System.out.println(student.getMyEmail());

    }

}
