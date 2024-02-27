package com.projects.gradesubmissionbackend.service;

import java.util.List;

//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.projects.gradesubmissionbackend.Constants;
import com.projects.gradesubmissionbackend.entity.Grade;
//import com.projects.gradesubmissionbackend.repository.GradeRepository;

//@Service
public interface GradeService {
	
	Grade getGrade(Long studentId, Long courseId);
    Grade saveGrade(Grade grade, Long studentId, Long courseId);
    Grade updateGrade(String score, Long studentId, Long courseId);
    void deleteGrade(Long studentId, Long courseId);
    List<Grade> getStudentGrades(Long studentId);
    List<Grade> getCourseGrades(Long courseId);
    List<Grade> getAllGrades();
  
//  @Autowired
//  GradeRepository gradeRepository;
//  
//  
//
//  public Grade getGrade(int index) {
//    return gradeRepository.getGrade(index);
//  }
//
//  public void updateGrade(@Valid Grade grade, int index) {
//    gradeRepository.updateGrade(grade, index);
//  }
//
//  public void addGrade(@Valid Grade grade) {
//    gradeRepository.addGrade(grade);
//  }
//
//  public List<Grade> getGrades() {
//    return gradeRepository.getGrades();
//  }
//  
//  public int getGradeIndex(String id) {
//    for (int i = 0; i < getGrades().size(); i++) {
//      if (getGrade(i).getId().equals(id))
//        return i;
//    }
//    return Constants.NOT_FOUND;
//  }
//  
//  public Grade getGradeById(String id) {
//    int index = getGradeIndex(id);
//    return index == Constants.NOT_FOUND ? new Grade() : getGrade(index);
//  }
//  
//  public void submitGrade(Grade grade) {
//    int index = getGradeIndex(grade.getId());
//    if (index == Constants.NOT_FOUND) {
//      addGrade(grade);
//    } else {
//      updateGrade(grade, index);
//    }
//  }
  
}
