package com.projects.gradesubmissionbackend.service;

import java.util.List;
import java.util.Set;

import com.projects.gradesubmissionbackend.entity.Course;
import com.projects.gradesubmissionbackend.entity.Student;


public interface StudentService {
	Student getStudent(Long id);
    Student saveStudent(Student student);
    void deleteStudent(Long id);
    List<Student> getStudents();
    Set<Course> getEnrolledCourses(Long id);
}
