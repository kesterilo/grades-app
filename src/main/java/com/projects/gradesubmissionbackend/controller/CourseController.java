package com.projects.gradesubmissionbackend.controller;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.gradesubmissionbackend.entity.Course;
import com.projects.gradesubmissionbackend.entity.Student;
import com.projects.gradesubmissionbackend.service.CourseService;

// import lombok.AllArgsConstructor;



// @AllArgsConstructor
@RestController
@RequestMapping("/course")
public class CourseController {
	
	CourseService courseService;
	
	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}

	public CourseController() {
	}

	@GetMapping("/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable Long id) {
        return new ResponseEntity<>(courseService.getCourse(id), HttpStatus.OK);
    }
	
	@PostMapping
    public ResponseEntity<Course> saveCourse(@RequestBody Course course) {
        return new ResponseEntity<>(courseService.saveCourse(course), HttpStatus.CREATED);
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable Long id) {
		courseService.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	
	@GetMapping("/all")
    public ResponseEntity<List<Course>> getCourses() {
        return new ResponseEntity<>(courseService.getCourses(), HttpStatus.OK);
    }
	
	@PutMapping("/{courseId}/student/{studentId}")
	public ResponseEntity<Course> enrollStudentToCourse(@PathVariable Long courseId, Long studentId) {
		return new ResponseEntity<>(courseService.addStudentToCourse(studentId, courseId), HttpStatus.OK);
	}
	
	@GetMapping("/{id}/students")
	public ResponseEntity<Set<Student>> getEnrolledStudents(@PathVariable Long id) {
		return new ResponseEntity<>(courseService.getEnrolledStudents(id), HttpStatus.OK);
	}

	
}
