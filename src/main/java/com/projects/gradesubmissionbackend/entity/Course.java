package com.projects.gradesubmissionbackend.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.NonNull;

@Entity
@Table(name = "course")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotBlank(message = "Subject cannot be blank")
	@NonNull
	@Column(name = "subject", nullable = false)
    private String subject;
	
	@NotBlank(message = "Course code cannot be blank")
	@NonNull
	@Column(name = "code", nullable = false, unique = true)
    private String code;
	
	@NotBlank(message = "Description cannot be blank")
	@NonNull
	@Column(name = "description", nullable = false)
    private String description;
	
	@JsonIgnore
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private List<Grade> grades;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(
			name = "course_student",
			joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id")
			)
	private Set<Student> students;
	

    public Course(String subject, String code, String description) {
		this.subject = subject;
		this.code = code;
		this.description = description;
	}

	public Course() {
	}

	public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

}
