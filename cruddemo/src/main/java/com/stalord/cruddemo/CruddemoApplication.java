package com.stalord.cruddemo;

import com.stalord.cruddemo.dao.StudentDAO;
import com.stalord.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class CruddemoApplication {



	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);

			//getfromdb(studentDAO);
			//querystudents(studentDAO);
			//getlastnamefromdb(studentDAO);
			//updatetable(studentDAO);
			//deletefromtb(studentDAO);
			//deletealltb(studentDAO);

		};
	}

	private void deletealltb(StudentDAO studentDAO) {
		int rows=studentDAO.deleteall();
		System.out.println(rows+" deleted!!!!");
	}

	private void createStudent(StudentDAO theStudentDAO){

		System.out.println("Creating object");
		Student temp=new Student("Aditya","Singh","adi06031998@gmail.com");


		System.out.println("Saving into db");
		theStudentDAO.save(temp);

		System.out.println("printing the id of the db"+ temp.getId());




	}



	private void createMultipleStudents(StudentDAO studentDAO) {

		// create multiple students
		System.out.println("Creating 3 student objects ...");
		Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
		Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
		Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");

		// save the student objects
		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}


	private void getfromdb(StudentDAO studentDAO){


		Student mystudent=studentDAO.findById(1);
		System.out.println(mystudent);




	}

	private void querystudents(StudentDAO studentDAO){
		List<Student> thequery = studentDAO.findall();
		for(Student itr:thequery){
			System.out.println(itr);
		}
	}

	private  void getlastnamefromdb(StudentDAO studentDAO){
		List<Student> thequery = studentDAO.findlastname("singh");
		for(Student itr:thequery){
			System.out.println(itr);
		}
	}

	private void updatetable(StudentDAO studentDAO){
		int studentId=2;
		Student st=studentDAO.findById(studentId);
		st.setFirstName("honey");
		studentDAO.update(st);
		System.out.println("updated");


	}
	private  void deletefromtb(StudentDAO studentDAO){
		int studentid=2;
		studentDAO.delete(studentid);
		System.out.println("deleted");
	}
}
