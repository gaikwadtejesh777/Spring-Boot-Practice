package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.students.StudentRepository;
import com.example.demo.students.Students;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


@SpringBootApplication
public class HibernetAppApplication {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(HibernetAppApplication.class, args);
	}
	
	public void run(String... args) throws Exception {

		logger.info("Students id 10001 -> {}", repository.findById(10001L));

		logger.info("Inserting -> {}", repository.save(new Students("John", "A1234657")));

		logger.info("Update 10003 -> {}", repository.save(new Students(10001L, "Name-Updated", "New-Passport")));

		repository.deleteById(10002L);

		logger.info("All users -> {}", repository.findAll());
	}
}
