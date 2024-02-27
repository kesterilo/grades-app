package com.projects.gradesubmissionbackend.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.projects.gradesubmissionbackend.entity.Course;
import com.projects.gradesubmissionbackend.entity.Student;
import com.projects.gradesubmissionbackend.exceptions.EntityNotFoundException;
//import com.projects.gradesubmissionbackend.exceptions.CourseNotFoundException;
import com.projects.gradesubmissionbackend.repository.CourseRepository;
import com.projects.gradesubmissionbackend.repository.StudentRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService{
	
	CourseRepository courseRepository;
	StudentRepository studentRepository;
	

	// public CourseServiceImpl(CourseRepository courseRepository, StudentRepository studentRepository) {
	// 	this.courseRepository = courseRepository;
	// 	this.studentRepository = studentRepository;
	// }

	public CourseServiceImpl() {
	}

	@Override
	public Course getCourse(Long id) {
		Optional<Course> course = courseRepository.findById(id);
		return unwrapCourse(course, id);
//		if (course.isPresent()) {
//			return course.get();
//		} else {
//			throw new CourseNotFoundException(id);
//		}
	}

	@Override
	public Course saveCourse(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public void deleteCourse(Long id) {
		courseRepository.deleteById(id);
	}

	@Override
	public List<Course> getCourses() {
		return (List<Course>)courseRepository.findAll();
	}
	
	@Override
	public Course addStudentToCourse(Long studentId, Long courseId) {
		Course course = getCourse(courseId);
		Optional<Student> student = studentRepository.findById(studentId);
		Student unwrappedStudent = StudentServiceImpl.unwrapStudent(student, studentId);
		course.getStudents().add(unwrappedStudent);
		return courseRepository.save(course);
	}
	
	@Override
	public Set<Student> getEnrolledStudents(Long id) {
		Course course = getCourse(id);
		return course.getStudents()	;
	}
	
	static Course unwrapCourse(Optional<Course> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new EntityNotFoundException(id, Course.class);
    }
	
}