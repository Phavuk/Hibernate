import hibernate.Course;
import hibernate.Instructor;
import hibernate.InstructorDetail;
import hibernate.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseAndReviewsDemo {

    public static void main(String[] args) {

    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class)
            .addAnnotatedClass(Course.class)
            .addAnnotatedClass(Review.class)
            .buildSessionFactory();

    Session session = factory.getCurrentSession();

        try {

        session.beginTransaction();

        int theId = 20;
        Course tempCourse = session.get(Course.class,theId);

        System.out.println(tempCourse);

        System.out.println(tempCourse.getReviews());

        session.delete(tempCourse);

        session.getTransaction().commit();
        System.out.println("Done");

        } finally {
            session.close();
            factory.close();
        }
    }
}
