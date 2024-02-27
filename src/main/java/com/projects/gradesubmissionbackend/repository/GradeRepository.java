package com.projects.gradesubmissionbackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

//import java.util.ArrayList;
//import java.util.List;

//import org.springframework.stereotype.Repository;

import com.projects.gradesubmissionbackend.entity.Grade;

//@Repository
public interface GradeRepository extends CrudRepository<Grade, Long>{
	Optional<Grade> findByStudentIdAndCourseId(Long studentId, Long courseId);
	@Transactional
	void deleteByStudentIdAndCourseId(Long studentId, Long courseId);
	List<Grade> findByStudentId(Long studentId);
	List<Grade> findByCourseId(Long courseId);
	
	
	
	
	
	
	
	
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	
	
  
//  private List<Grade> studentGrades = new ArrayList<>();
//  //   new Grade("Harry", "Potions", "C-"), new Grade("Hermione", "Arithmancy", "A+"), new Grade("Neville", "Charms", "A-")
//  // );
//  
//  
//  
//  public Grade getGrade(int index) {
//    return studentGrades.get(index);
//  }
//  
//  public void addGrade(Grade grade) {
//    studentGrades.add(grade);
//  }
//  
//  public void updateGrade(Grade grade, int index) {
//    studentGrades.set(index, grade);
//  }
//  
//  public List<Grade> getGrades() {
//    return studentGrades;
//  }
//  
}
