package com.projects.gradesubmissionbackend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.projects.gradesubmissionbackend.validation.Score;

//import java.util.UUID;

//import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "grade", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"student_id", "course_id"})
})
public class Grade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Score
	@Column(name = "score", nullable = false)
    private String score;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "student_id", referencedColumnName = "id")
	private Student student;

	@ManyToOne(optional = false)
	@JoinColumn(name = "course_id", referencedColumnName = "id")
	private Course course;
	
	

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScore() {
        return this.score;
    }

    public void setScore(String score) {
        this.score = score;
    }

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
  
//  @NotBlank(message = "Name cannot be blank")
//  private String name;
//  @NotBlank(message = "Subject cannot be blank")
//  private String subject;
//  @Score(message = "Score must be an upper-case letter grade")
//  private String score;
//  private String id;
//
//  public Grade() {
//    this.id = UUID.randomUUID().toString();
//  }
//
//  public Grade(String name, String subject, String score) {
//    this.name = name;
//    this.subject = subject;
//    this.score = score;
//    this.id = UUID.randomUUID().toString();
//  }
//
//  public String getName() {
//    return this.name;
//  }
//
//  public void setName(String name) {
//    this.name = name;
//  }
//
//  public String getSubject() {
//    return this.subject;
//  }
//
//  public void setSubject(String subject) {
//    this.subject = subject;
//  }
//
//  public String getScore() {
//    return this.score;
//  }
//
//  public void setScore(String score) {
//    this.score = score;
//  }
//
//  public String getId() {
//    return this.id;
//  }
//
//  public void setId(String id) {
//    this.id = id;
//  } 
//  
}