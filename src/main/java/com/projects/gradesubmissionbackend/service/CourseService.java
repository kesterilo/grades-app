package com.projects.gradesubmissionbackend.service;

import java.util.List;
import java.util.Set;

import com.projects.gradesubmissionbackend.entity.Course;
import com.projects.gradesubmissionbackend.entity.Student;

public interface CourseService{
	Course getCourse(Long id);
    Course saveCourse(Course course);
    void deleteCourse(Long id);
    List<Course> getCourses();
    Course addStudentToCourse(Long studentId, Long courseId);
    Set<Student> getEnrolledStudents(Long id);
}
