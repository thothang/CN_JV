package com.example.Lab7_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab72Application implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(Lab72Application.class, args);
	}

	@Override
	public void run(String... args) {
		// Add at least 3 students
		Student student1 = new Student(null, "Alice Smith", 22, "alice@example.com", 7.0);
		Student student2 = new Student(null, "Bob Johnson", 24, "bob@example.com", 6.5);
		Student student3 = new Student(null, "Charlie Brown", 23, "charlie@example.com", 8.0);

		studentRepository.save(student1);
		studentRepository.save(student2);
		studentRepository.save(student3);

		// Read and print all students
		System.out.println("All students:");
		studentRepository.findAll().forEach(System.out::println);

		// Update a student's information
		Student studentToUpdate = studentRepository.findById(student1.getId()).orElse(null);
		if (studentToUpdate != null) {
			studentToUpdate.setAge(23); // Update age
			studentToUpdate.setIeltsScore(7.5); // Update IELTS score
			studentRepository.save(studentToUpdate);
		}

		// Print all students after updating
		System.out.println("Students after update:");
		studentRepository.findAll().forEach(System.out::println);

		// Delete a student
		studentRepository.deleteById(student2.getId());

		// Print all students after deleting
		System.out.println("Students after deletion:");
		studentRepository.findAll().forEach(System.out::println);
	}
}

