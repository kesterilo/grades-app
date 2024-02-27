package com.projects.gradesubmissionbackend.service;

import java.util.List;
import java.util.Optional;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.gradesubmissionbackend.entity.Course;
import com.projects.gradesubmissionbackend.entity.Grade;
import com.projects.gradesubmissionbackend.entity.Student;
import com.projects.gradesubmissionbackend.exceptions.GradeNotFoundException;
import com.projects.gradesubmissionbackend.exceptions.StudentNotEnrolledException;
//import com.projects.gradesubmissionbackend.exceptions.StudentNotFoundException;
import com.projects.gradesubmissionbackend.repository.CourseRepository;
import com.projects.gradesubmissionbackend.repository.GradeRepository;
import com.projects.gradesubmissionbackend.repository.StudentRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class GradeServiceImpl implements GradeService{
	
	GradeRepository gradeRepository;
	StudentRepository studentRepository;
	CourseRepository courseRepository;

	// public GradeServiceImpl(GradeRepository gradeRepository, StudentRepository studentRepository, CourseRepository courseRepository) {
	// 	this.gradeRepository = gradeRepository;
	// 	this.studentRepository = studentRepository;
	// 	this.courseRepository = courseRepository;
	// }
	

	@Override
	public Grade getGrade(Long studentId, Long courseId) {
		Optional<Grade> grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
		return unwrapGrade(grade, studentId, courseId);
//		if (grade.isPresent()) {
//			return grade.get();
//		} else {
//			throw new GradeNotFoundException(studentId, courseId);
//		}
	}

	@Override
	public Grade saveGrade(Grade grade, Long studentId, Long courseId) {
//		Student student = studentRepository.findById(studentId).get();
//		Course course = courseRepository.findById(courseId).get();
		Student student = StudentServiceImpl.unwrapStudent(studentRepository.findById(studentId), studentId);
        Course course = CourseServiceImpl.unwrapCourse(courseRepository.findById(courseId), courseId);
        if (!student.getCourses().contains(course)) throw new StudentNotEnrolledException(studentId, courseId);
		grade.setStudent(student);
		grade.setCourse(course);
		return gradeRepository.save(grade);
	}

	@Override
	public Grade updateGrade(String score, Long studentId, Long courseId) {
		Optional<Grade> grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
		Grade unwrappedGrade = unwrapGrade(grade, studentId, courseId);
		unwrappedGrade.setScore(score);
		return gradeRepository.save(unwrappedGrade);
//		if (grade.isPresent()) {
//			Grade unwrappedGrade = grade.get();
//			unwrappedGrade.setScore(score);
//			return gradeRepository.save(unwrappedGrade);
//		} else {
//			throw new GradeNotFoundException(studentId, courseId);
//		}
	}

	@Override
	public void deleteGrade(Long studentId, Long courseId) {
		gradeRepository.deleteByStudentIdAndCourseId(studentId, courseId);
	}

	@Override
	public List<Grade> getStudentGrades(Long studentId) {
		return gradeRepository.findByStudentId(studentId);
	}

	@Override
	public List<Grade> getCourseGrades(Long courseId) {
		return gradeRepository.findByCourseId(courseId);
	}

	@Override
	public List<Grade> getAllGrades() {
		return (List<Grade>) gradeRepository.findAll();
	}
	
	static Grade unwrapGrade(Optional<Grade> entity, Long studentId, Long courseId) {
        if (entity.isPresent()) return entity.get();
        else throw new GradeNotFoundException(studentId, courseId);
    }

}
