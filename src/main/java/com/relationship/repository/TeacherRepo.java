package com.relationship.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relationship.entity.Teacher;

public interface TeacherRepo extends JpaRepository<Teacher, Integer> {

}
