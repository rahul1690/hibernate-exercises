package com.kindson.ormdemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kindson.ormdemo.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
