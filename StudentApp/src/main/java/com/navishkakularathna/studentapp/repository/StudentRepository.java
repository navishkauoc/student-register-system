package com.navishkakularathna.studentapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.navishkakularathna.studentapp.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	Student findByName(String name);
	
}
