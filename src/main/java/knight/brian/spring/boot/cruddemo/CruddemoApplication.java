package knight.brian.spring.boot.cruddemo;

import knight.brian.spring.boot.cruddemo.dao.AppDAO;
import knight.brian.spring.boot.cruddemo.entity.Course;
import knight.brian.spring.boot.cruddemo.entity.Instructor;
import knight.brian.spring.boot.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {
//			createInstructor(appDAO);
//			findInstructor(appDAO);
//			deleteInstructor(appDAO);
//			findInstructorDetail(appDAO);
//			deleteInstructorDetail(appDAO);
			createInstructorWithCourses(appDAO);
		};
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor(
				"Susan",
				"Public",
				"susan@luv2code.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail(
				"http://www.youtube.com",
				"Video Games");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		Course c1 = new Course("Guitar Hero");
		Course c2 = new Course("Pinball Masterclass");

		tempInstructor.add(c1);
		tempInstructor.add(c2);

		System.out.println("Saving instructor: "  + tempInstructor);
		System.out.println("The courses: " + tempInstructor.getCourses());
		// Also saves courses due to CascadeType.PERSIST
		appDAO.save(tempInstructor);

		System.out.println("Done saving.");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int id = 2;
		System.out.println("Deleting instructorDetail for ID: " + id);
		appDAO.deleteInstructorDetailById(id);
		System.out.println("Done deleting");
	}

	private void findInstructorDetail(AppDAO appDAO) {

		int id = 1;
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);

		System.out.println("instructorDetail for ID: " + id);
		System.out.println(instructorDetail);

		System.out.println("associated instructor: " + instructorDetail.getInstructor());
		System.out.println("Done finding bi-directional instructor and detail.");
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id = 2;

		System.out.println("Deleting instructor ID: " + id);
		appDAO.deleteInstructorById(id);
		System.out.println("Done deleting");
	}

	private void findInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor for id: " + id);

		Instructor tempInstructor = appDAO.findInstructorById(id);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("tempInstructor instructorDetails: " + tempInstructor.getInstructorDetail());

	}

	private void createInstructor(AppDAO appDAO) {
		// create instructorChad
		Instructor instructorChad = new Instructor(
				"Chad",
				"Darby",
				"darby@luv2code.com");

		InstructorDetail instructorDetail = new InstructorDetail(
				"http://www.luv2code.com/youtube",
				"Luv 2 Code");

		instructorChad.setInstructorDetail(instructorDetail);

		System.out.println("Saving instructorChad: " + instructorChad);
		// save instructorChad which also saved InstructorDetail due to CascadeType.ALL
		appDAO.save(instructorChad);

		Instructor instructorMadhu = new Instructor(
				"Madhu",
				"Patel",
				"madhu@luv2code.com");

		InstructorDetail instructorDetailMadhu = new InstructorDetail(
				"http://www.luv2code.com/youtube",
				"Guitar");

		instructorMadhu.setInstructorDetail(instructorDetailMadhu);

		System.out.println("Saving instructorMadhu: " + instructorMadhu);
		// save instructorChad which also saved InstructorDetail due to CascadeType.ALL
		appDAO.save(instructorMadhu);

		System.out.println("Done saving!");


	}
}
