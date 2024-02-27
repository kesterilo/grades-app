package com.projects.gradesubmissionbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

//import javax.validation.Valid;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projects.gradesubmissionbackend.entity.Grade;
import com.projects.gradesubmissionbackend.service.GradeService;

// import lombok.AllArgsConstructor;




//@Controller
// @AllArgsConstructor
@RestController
@RequestMapping("/grade")
public class GradeController {
	
	
	@Autowired
	GradeService gradeService;
	
	
	public GradeController(GradeService gradeService) {
		this.gradeService = gradeService;
	}

	public GradeController() {
	}

	@GetMapping("/student/{studentId}/course/{courseId}")
	public ResponseEntity<Grade> getGrade(@PathVariable Long studentId, @PathVariable Long CourseId) {
		return new ResponseEntity<>(gradeService.getGrade(studentId, CourseId), HttpStatus.OK);
	}
	
	@PostMapping("/student/{studentId}/course/{courseId}")
	public ResponseEntity<Grade> saveGrade(@RequestBody Grade grade, @PathVariable Long studentId, @PathVariable Long courseId) {
		return new ResponseEntity<>(gradeService.saveGrade(grade, studentId, courseId), HttpStatus.CREATED);
	}
	
	@PutMapping("/student/{studentId}/course/{courseId}")
	public ResponseEntity<Grade> updateGrade(@RequestBody Grade grade, @PathVariable Long studentId, @PathVariable Long courseId) {
		return new ResponseEntity<>(gradeService.updateGrade(grade.getScore(), studentId, courseId), HttpStatus.OK);
	}
	
	@DeleteMapping("/student/{studentId}/course/{courseId}")
	public ResponseEntity<HttpStatus> deleteGrade(@PathVariable Long studentId, @PathVariable Long courseId) {
		gradeService.deleteGrade(studentId, courseId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/student/{studentId}")
	public ResponseEntity<List<Grade>> getStudentGrades(@PathVariable Long studentId) {
		return new ResponseEntity<>(gradeService.getStudentGrades(studentId), HttpStatus.OK);
	}
	
	@GetMapping("/course/{courseId}")
	public ResponseEntity<List<Grade>> getCourseGrades(@PathVariable Long courseId) {
		return new ResponseEntity<>(gradeService.getCourseGrades(courseId), HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Grade>> getGrades() {
		return new ResponseEntity<>(gradeService.getAllGrades(), HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	/////////////////////////////////////////////////////////////////////////////////
  
//  @Autowired
//  GradeService gradeService;
//  
//  @GetMapping("/")
//  public String getForm(Model model, @RequestParam(required = false) String id) {
//    model.addAttribute("grade", gradeService.getGradeById(id));
//    return "form";
//  }
//  
//  @PostMapping("/handleSubmit")
//  public String submitForm(@Valid Grade grade, BindingResult result) {
//    if (result.hasErrors())
//      return "form";
//    gradeService.submitGrade(grade);
//    return "redirect:/grades";
//  }
//  
//  @GetMapping("/grades")
//  public String getGrades(Model model) {
//    model.addAttribute("grades", gradeService.getGrades());
//    return "grades";
//  }
  
}