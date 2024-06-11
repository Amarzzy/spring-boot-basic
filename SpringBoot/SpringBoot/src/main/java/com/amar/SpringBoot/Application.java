package com.amar.SpringBoot;

import com.amar.SpringBoot.entity.Student;
import com.amar.SpringBoot.repository.StudentDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	/*@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			processRequest(studentDAO);
		};
	}*/

	private void processRequest(StudentDAO studentDAO) {
		Student student1 = new Student("Amar","deep","amar.deep@xyz");

		Student student2 = new Student("Amar","Jeep","amar.jeep@xyz");

		System.out.println("Before Persisting Student ID saved: "+student1.getId());

		studentDAO.save(student1);

		viewAll(studentDAO);

		studentDAO.updateStudent(student1, "Jhampa", "Rampa");

		viewAll(studentDAO);

		System.out.println("Student ID saved: "+student1.getId());
	}

	private static void viewAll(StudentDAO studentDAO) {
		List<Student> allStudent = studentDAO.getAllStudent();
		for(Student tempStudent: allStudent){
			System.out.println("Student ID saved: "+tempStudent.toString());
		}
	}
}
