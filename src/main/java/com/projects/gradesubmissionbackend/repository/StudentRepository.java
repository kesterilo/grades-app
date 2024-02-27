package com.projects.gradesubmissionbackend.repository;

import org.springframework.data.repository.CrudRepository;

import com.projects.gradesubmissionbackend.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{
	
	
}
