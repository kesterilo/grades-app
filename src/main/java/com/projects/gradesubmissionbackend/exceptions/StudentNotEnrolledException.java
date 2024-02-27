package com.projects.gradesubmissionbackend.exceptions;

public class StudentNotEnrolledException extends RuntimeException {
	
	public StudentNotEnrolledException(Long studentId, Long courseId) {
		super("The student with id: '" + studentId + "' is not enrolled in the course with id: '" + courseId);
	}
}
