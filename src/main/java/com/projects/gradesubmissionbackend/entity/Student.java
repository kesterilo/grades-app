package com.projects.gradesubmissionbackend.entity;

import java.time.LocalDate;
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
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;


@Entity
@Table(name = "student")
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotBlank(message = "Name cannot be blank")
	@NonNull
	@Column(name = "name", nullable = false)
    private String name;
	
	@Past(message = "The birth date must be in the past")
	@NonNull
	@Column(name = "birth_date", nullable =false)
    private LocalDate birthDate;
	
	@JsonIgnore
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	private List<Grade> grades;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(
			name= "course_student",
			joinColumns = @JoinColumn(name = "student_id",
					referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "course_id", 
					referencedColumnName = "id")
			)
	private Set<Course> courses;

	public Student(String name, LocalDate birthDate) {
		this.name = name;
		this.birthDate = birthDate;
	}

	public Student() {
	}

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

}
