package com.navishkakularathna.studentapp.service;

import java.util.List;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navishkakularathna.studentapp.model.Student;
import com.navishkakularathna.studentapp.repository.StudentRepository;

@Service
public class StudentService {

	private StudentRepository studentRepository;
	
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public Student save(Student student) {
		if(student.getId() != null && studentRepository.exists(student.getId())) {
			throw new EntityExistsException("ID already exists in the db");
		}
		return studentRepository.save(student);
	}
	
	public Student update(Student student) {
		if(student.getId() != null && studentRepository.exists(student.getId())) {
			throw new EntityExistsException("ID already exists in the db");
		}
		return studentRepository.save(student);
	}
	
	public List<Student> findAll(){
		return studentRepository.findAll();
	}
	
	public Student findOne(Integer id) {
		return studentRepository.findOne(id);
	}
	
	public void delete(Integer id) {
		studentRepository.delete(id);
	}
}
