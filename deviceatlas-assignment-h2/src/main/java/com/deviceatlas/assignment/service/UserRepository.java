package com.deviceatlas.assignment.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.deviceatlas.assignment.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	List<User> findByUser(String user);
}