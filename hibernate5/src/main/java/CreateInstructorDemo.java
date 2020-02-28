import hibernate.Course;
import hibernate.Instructor;
import hibernate.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

    public static void main(String[] args) {

    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class)
            .addAnnotatedClass(Course.class)
            .buildSessionFactory();

    Session session = factory.getCurrentSession();

        try {

        Instructor tempInstructor = new Instructor("johnny2","spider2","john@spider2.com");

        InstructorDetail tempInstructorDetail =
                    new InstructorDetail("youtube.com/test2","test2");

        session.beginTransaction();

        session.save(tempInstructor);

        System.out.println("Commit transaction");
        session.getTransaction().commit();

        System.out.println("selected instructor "+tempInstructorDetail.getInstructor());

        System.out.println("Done");

        } finally {
            session.close();
            factory.close();
        }
    }
}
