package com.projects.gradesubmissionbackend.repository;

import org.springframework.data.repository.CrudRepository;

import com.projects.gradesubmissionbackend.entity.Course;

public interface CourseRepository extends CrudRepository<Course, Long>{
	
}
