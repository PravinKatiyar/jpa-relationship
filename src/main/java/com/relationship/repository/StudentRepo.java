package com.relationship.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.relationship.dto.StudentI;
import com.relationship.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

	@Query(value = "SELECT s.f_name as fName, s.id as id FROM student s where id=:id", nativeQuery = true)
	StudentI findStudentById(int id);
//	select st.f_name,su.subjectname 
//	from student st 	
//	INNER JOIN students_enrolled senrolled on st.id=senrolled.student_id
//	INNER JOIN subject su ON senrolled.subject_id=su.id
//	WHERE st.id=1;
}
