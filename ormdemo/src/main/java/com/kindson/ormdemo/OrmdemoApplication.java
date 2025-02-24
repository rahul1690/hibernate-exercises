package com.kindson.ormdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kindson.ormdemo.model.User;
import com.kindson.ormdemo.repo.UserRepo;


@SpringBootApplication
@RestController
public class OrmdemoApplication{
	
	@Autowired
	UserRepo userRepo;
	
	@GetMapping("/")
	public List<User> getUsers() {
		return userRepo.findAll();
	}

	public static void main(String[] args) {
		SpringApplication.run(OrmdemoApplication.class, args);
	}

}
