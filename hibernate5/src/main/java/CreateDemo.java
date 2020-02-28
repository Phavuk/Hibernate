import hibernate.Instructor;
import hibernate.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

    public static void main(String[] args) {

    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class)
            .buildSessionFactory();

    Session session = factory.getCurrentSession();

        try {

        Instructor tempInstructor = new Instructor("johnny","spider","john@spider.com");

        InstructorDetail tempInstructorDetail =
                    new InstructorDetail("youtube.com/test","test");

        session.beginTransaction();

        session.save(tempInstructor);

        System.out.println("Commit transaction");
        session.getTransaction().commit();

        System.out.println("selected instructor "+tempInstructorDetail.getInstructor());

        System.out.println("Done");

        } finally {
            factory.close();
        }
    }
}
