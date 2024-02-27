package com.projects.gradesubmissionbackend.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.gradesubmissionbackend.entity.Course;
import com.projects.gradesubmissionbackend.entity.Student;
import com.projects.gradesubmissionbackend.exceptions.EntityNotFoundException;
//import com.projects.gradesubmissionbackend.exceptions.StudentNotFoundException;
import com.projects.gradesubmissionbackend.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	
	private StudentRepository studentRepository;
	

	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public Student getStudent(Long id) {
		Optional<Student> student = studentRepository.findById(id);
		return unwrapStudent(student, id);
//		if (student.isPresent()) {
//			return student.get();
//		} else {
//			throw new StudentNotFoundException(id);
//		}
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}

	@Override
	public List<Student> getStudents() {
		return (List<Student>)studentRepository.findAll();
	}
	
	@Override
	public Set<Course> getEnrolledCourses(Long id) {
		Student student = getStudent(id);
		return student.getCourses();
	}
	
	static Student unwrapStudent(Optional<Student> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new EntityNotFoundException(id, Student.class);
    }
	
	
}
