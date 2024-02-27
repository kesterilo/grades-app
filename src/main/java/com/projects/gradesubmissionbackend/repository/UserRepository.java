package com.projects.gradesubmissionbackend.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.projects.gradesubmissionbackend.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{
	Optional<User> findByUsername(String username);

}
