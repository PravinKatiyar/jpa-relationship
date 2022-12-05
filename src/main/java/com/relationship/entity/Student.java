package com.relationship.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*Many to many
*/@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String fName;

	private String lName;

	//@JsonIgnore
	@ManyToMany(mappedBy = "enrolledStudents")
	private Set<Subject> Subjects=new HashSet<>();
//
//	
	@JsonIgnore
	public Set<Subject> getSubjects() {
		return Subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		Subjects = subjects;
	}
	

	public Student(int id, String fName, String lName) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
	}

	public Student() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

}
