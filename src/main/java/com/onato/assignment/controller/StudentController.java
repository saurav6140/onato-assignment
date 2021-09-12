package com.onato.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onato.assignment.entity.Student;
import com.onato.assignment.service.StudentService;



@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	
	@PostMapping(value="/add")
	public Student addStudent(@RequestBody Student student) {
		
		return studentService.addStudent(student);
	}
	
	@GetMapping(value="/get/{id}")
	public Student getStudentById(@PathVariable Integer id) {
		return studentService.getStudentById(id);
	}

  @GetMapping(value="/get")
  public Student getStudentByRollNumber(@RequestParam String rollNumber,
      @RequestParam String standard) {
    return studentService.getStudentByRollNumber(rollNumber, standard);
  }
	
	@GetMapping(value="/getall") 
	public List<Student> getAllStudents() {
		return studentService.getStudentList();
	}
	
	@PutMapping(value="/update/{id}")
	public Student updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}

	@DeleteMapping(value="/delete/{id}")
	public void delete(@PathVariable Integer id) {
		studentService.delete(id);
	}
}
