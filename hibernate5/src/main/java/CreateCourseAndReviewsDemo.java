import hibernate.Course;
import hibernate.Instructor;
import hibernate.InstructorDetail;
import hibernate.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewsDemo {

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

        Course tempCourse = new Course("Testing pro");

        tempCourse.addReview(new Review("Good bro"));
        tempCourse.addReview(new Review("Very nice and helpful review"));
        tempCourse.addReview(new Review("Bad! I want my money back!"));

        session.save(tempCourse);

        session.getTransaction().commit();
        System.out.println("Done");

        } finally {
            session.close();
            factory.close();
        }
    }
}
