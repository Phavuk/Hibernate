import hibernate.Instructor;
import hibernate.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {

    public static void main(String[] args) {

    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class)
            .buildSessionFactory();

    Session session = factory.getCurrentSession();

        try {

        session.beginTransaction();

        int theId = 2;

        InstructorDetail tempInstructorDetail =
                session.get(InstructorDetail.class,theId);

        session.delete(tempInstructorDetail);

        session.getTransaction().commit();

        System.out.println("instructor getted from tempInstructorDetail "+tempInstructorDetail);

        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            factory.close();
        }
    }
}
