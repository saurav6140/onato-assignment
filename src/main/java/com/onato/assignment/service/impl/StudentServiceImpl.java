package com.onato.assignment.service.impl;

import com.onato.assignment.dao.StudentRepository;
import com.onato.assignment.entity.Student;
import com.onato.assignment.service.StudentService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student getStudentById(Integer id) {
		return studentRepository.findOne(id);
	}

	public Student getStudentByRollNumber(String rollNumber, String standard){
		return studentRepository.findByRollNumberAndStandard(rollNumber, standard);
	}

	@Override
	public List<Student> getStudentList() {
		return (List<Student>) studentRepository.findAll();
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void delete(Integer id) {
		studentRepository.delete(id);
	}

}
