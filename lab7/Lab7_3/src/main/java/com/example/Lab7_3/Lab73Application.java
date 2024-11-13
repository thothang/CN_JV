package com.example.Lab7_3;

import com.example.Lab7_3.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Lab73Application implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private StudentPagingAndSortingRepository studentPagingAndSortingRepository;



	public static void main(String[] args) {
		SpringApplication.run(Lab73Application.class, args);
	}

	@Override
	public void run(String... args) {
//		Student student1 = new Student(null, "Alice Johnson", 22, "alice@example.com", 7.5);
//		Student student2 = new Student(null, "Bob Smith", 20, "bob@example.com", 6.0);
//		Student student3 = new Student(null, "Charlie Brown", 23, "charlie@example.com", 8.0);
//		Student student4 = new Student(null, "David Lee", 21, "david@example.com", 6.5);
//		Student student5 = new Student(null, "Eva Green", 22, "eva@example.com", 7.0);
//		Student student6 = new Student(null, "Frank Miller", 24, "frank@example.com", 8.5);
//		Student student7 = new Student(null, "Grace Lee", 19, "grace@example.com", 9.0);
//		Student student8 = new Student(null, "Hannah White", 25, "hannah@example.com", 6.8);
//		Student student9 = new Student(null, "Isaac Black", 20, "isaac@example.com", 7.2);
//		Student student10 = new Student(null, "Jack Taylor", 23, "jack@example.com", 7.8);
//
//		studentRepository.save(student1);
//		studentRepository.save(student2);
//		studentRepository.save(student3);
//		studentRepository.save(student4);
//		studentRepository.save(student5);
//		studentRepository.save(student6);
//		studentRepository.save(student7);
//		studentRepository.save(student8);
//		studentRepository.save(student9);
//		studentRepository.save(student10);
//
//		System.out.println("Added students to the database.");
//
//		List<Student> students = (List<Student>) studentRepository.findAll();
//		System.out.println("All students in the database:");
//		students.forEach(System.out::println);
//
//		Optional<Student> studentToUpdate = studentRepository.findById(student1.getId());
//		if (studentToUpdate.isPresent()) {
//			Student student = studentToUpdate.get();
//			student.setAge(23);
//			studentRepository.save(student);
//			System.out.println("Updated student information: " + student);
//		}

//		studentRepository.deleteById(student2.getId());
//		System.out.println("Deleted student with ID: " + student2.getId());
//
//		System.out.println("All students in the database after deletion:");
//		students = (List<Student>) studentRepository.findAll();
//		students.forEach(System.out::println);

		System.out.println("\nCustom Query Results:");

		int age = 21;
		List<Student> studentsByAge = studentRepository.findByMinAge(age);
		System.out.println("Students with age >= " + age + ":");
		studentsByAge.forEach(System.out::println);

		double ieltsScore = 7.5;
		long countByIelts = studentRepository.countByScore(ieltsScore);
		System.out.println("Number of students with IELTS score " + ieltsScore + ": " + countByIelts);

		String nameContains = "Ali";
		List<Student> studentsByName = studentRepository.searchByNamePart(nameContains);
		System.out.println("Students with names containing '" + nameContains + "':");
		studentsByName.forEach(System.out::println);

		// Sort students by age (descending) and ieltsScore (ascending for students of the same age)
		Sort sort = Sort.by(Sort.Order.desc("age"), Sort.Order.asc("ieltsScore"));

		// Retrieve all students sorted by the specified criteria
		Iterable<Student> sortedStudents = studentPagingAndSortingRepository.findAll(sort);

		System.out.println("Students sorted by age (desc) and ieltsScore (asc):");
		sortedStudents.forEach(System.out::println);

		// Paging: Get students 4-5-6 (second page, 3 students per page)
		Pageable pageable = PageRequest.of(1, 3, sort);  // Page 1, with 3 records per page
		List<Student> pageOfStudents = studentPagingAndSortingRepository.findAll(pageable).getContent();

		System.out.println("Students 4-5-6:");
		pageOfStudents.forEach(System.out::println);

	}
}
