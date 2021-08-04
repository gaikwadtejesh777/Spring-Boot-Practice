package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner{

	private static final Logger log =
			LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);
	
	@Autowired
	private UserRepository userRepo;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User user = new User("Adam","Client");
		userRepo.save(user);
		log.info("New user created"+user);
		
		
		Optional<User> userwithIdone = userRepo.findById(1L);
		log.info("New user created"+userwithIdone);
		
		List<User> users = userRepo.findAll();
		log.info("All user"+users);
		
	

	}

}
