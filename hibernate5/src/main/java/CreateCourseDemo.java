import hibernate.Course;
import hibernate.Instructor;
import hibernate.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseDemo {

    public static void main(String[] args) {

    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class)
            .addAnnotatedClass(Course.class)
            .buildSessionFactory();

    Session session = factory.getCurrentSession();

        try {

        session.beginTransaction();

        int id = 1;
        Instructor tempInstructor = session.get(Instructor.class,id);

        Course tempCourse1 = new Course("How to cheat on neighbor wife ");
        Course tempCourse2 = new Course("How to cheat on neighbor wife part 2");

        tempInstructor.add(tempCourse1);
        tempInstructor.add(tempCourse2);

        session.save(tempCourse1);
        session.save(tempCourse2);

        session.getTransaction().commit();
        System.out.println("Done");

        } finally {
            session.close();
            factory.close();
        }
    }
}
