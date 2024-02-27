package com.projects.gradesubmissionbackend.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.gradesubmissionbackend.entity.Course;
import com.projects.gradesubmissionbackend.entity.Student;
import com.projects.gradesubmissionbackend.service.StudentService;

// import lombok.AllArgsConstructor;


// @AllArgsConstructor
@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	public StudentController() {
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable Long id) {
		return new ResponseEntity<>(studentService.getStudent(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Student>> getStudents() {
		return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}/courses")
	public ResponseEntity<Set<Course>> getEnrolledCourses(@PathVariable Long id) {
		return new ResponseEntity<>(studentService.getEnrolledCourses(id), HttpStatus.OK);
	}
	
}
