package com.relationship.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.relationship.dto.SubjectStudentI;
import com.relationship.entity.Subject;

public interface SubjectRepo extends JpaRepository<Subject,Integer>{

	Subject save(Subject subject);

	@Query(value = "SELECT st.f_name as fName, su.subjectname as Subjectname FROM student st INNER JOIN subject su ON st.id=su.id", nativeQuery = true)
	List<SubjectStudentI> findAllStudentsAndSubject(int subjectId, int studentId);

}
