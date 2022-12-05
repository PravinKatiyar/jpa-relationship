package com.relationship.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.relationship.dto.StudentI;
import com.relationship.dto.SubjectStudentI;
import com.relationship.entity.Student;
import com.relationship.entity.Subject;
import com.relationship.entity.Teacher;
import com.relationship.repository.StudentRepo;
import com.relationship.repository.SubjectRepo;
import com.relationship.repository.TeacherRepo;

@RestController
public class Controller {

	@Autowired
	private StudentRepo studentRepo;

	@Autowired
	private SubjectRepo subjectRepo;

	@Autowired
	private TeacherRepo teacherRepo;

	@PostMapping(value = "/student")
	public Student addStudent(@RequestBody Student student) {
		return studentRepo.save(student);
	}

	@GetMapping(value = "/student")
	public List<Student> findAllStudent() {
		return studentRepo.findAll();
	}

	@GetMapping(value = "/studentId/{id}")
	public StudentI findStudentStudent(@PathVariable("id") int id) {
		return studentRepo.findStudentById(id);
	}

	@PostMapping(value = "/subject")
	public Subject addSubject(@RequestBody Subject subject) {
		return subjectRepo.save(subject);
	}

	@GetMapping(value = "/subject")
	public List<Subject> findAllSubject() {
		return subjectRepo.findAll();
	}

	@PostMapping(value = "/teacher")
	public Teacher addteacher(@RequestBody Teacher teacher) {
		return teacherRepo.save(teacher);
	}

	@GetMapping(value = "/teacher")
	public List<Teacher> findAllteacher() {
		return teacherRepo.findAll();
	}

	@PutMapping(value = "/subject/{subjectId}/student/{studentId}")
	public Subject enrollStudentToSubject(@PathVariable int subjectId, @PathVariable int studentId) {
		Student student = studentRepo.findById(studentId).get();
		Subject subject = subjectRepo.findById(subjectId).get();
		subject.getEnrolledStudents().add(student);
		return subjectRepo.save(subject);

	}

	@GetMapping(value = "/subject/{subjectId}/student/{studentId}")
	public List<SubjectStudentI> findAllStudentsAndSubject(@PathVariable int subjectId, @PathVariable int studentId) {

		return subjectRepo.findAllStudentsAndSubject(subjectId, studentId);

	}

	@PutMapping("/subject/{subjectId}/teacher/{teacherId}")
	Subject assignTeacherToSubject(@PathVariable int subjectId, @PathVariable int teacherId) {
		Subject subject = subjectRepo.findById(subjectId).get();
		Teacher teacher = teacherRepo.findById(teacherId).get();
		subject.setTeacher(teacher);
		return subjectRepo.save(subject);
	}
}
