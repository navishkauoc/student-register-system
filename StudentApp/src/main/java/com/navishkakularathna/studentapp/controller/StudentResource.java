package com.navishkakularathna.studentapp.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.navishkakularathna.studentapp.model.Student;
import com.navishkakularathna.studentapp.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentResource {

	private StudentService studentService;
	
	public StudentResource(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@RequestMapping(value = "student", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Student> getAllStudents(){
		return studentService.findAll();
	}
	
	@RequestMapping(value = "student", method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> createStudent(@RequestBody Student student)throws URISyntaxException{
		try {
			Student result = studentService.save(student);
			return ResponseEntity.created(new URI("/api/student/"+result.getId())).body(result);
		} catch (Exception e) {
			return new ResponseEntity<Student>(HttpStatus.CONFLICT);
		}
	}
	
	@RequestMapping(value = "student", method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> updateStudent(@RequestBody Student student)throws URISyntaxException{
		if(student.getId()==null) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		
		try {
			Student result = studentService.update(student);
			return ResponseEntity.created(new URI("/api/student/"+result.getId())).body(result);
		} catch (Exception e) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/student/(id)", method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteStudent(@PathVariable Integer id){
		studentService.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
