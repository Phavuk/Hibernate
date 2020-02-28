package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteUser {

    public static void main(String[] args) {

    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class)
            .buildSessionFactory();

    Session session = factory.getCurrentSession();

        try {

        session.beginTransaction();

        int theId = 1;

        Instructor tempInstructor = session.get(Instructor.class,theId);

        session.delete(tempInstructor);

        session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
