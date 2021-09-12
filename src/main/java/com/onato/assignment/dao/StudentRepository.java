package com.onato.assignment.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onato.assignment.entity.Student;


@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

	Student findByRollNumberAndStandard(String rollNumber, String standard);
}
