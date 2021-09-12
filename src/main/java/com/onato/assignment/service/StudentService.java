package com.onato.assignment.service;

import com.onato.assignment.entity.Student;
import java.util.List;

public interface StudentService {

	Student addStudent(Student student);

	Student getStudentById(Integer id);

	Student getStudentByRollNumber(String rollNumber, String standard);

	List<Student> getStudentList();

	Student updateStudent(Student student);

	void delete(Integer id);

}
