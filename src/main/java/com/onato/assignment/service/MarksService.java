package com.onato.assignment.service;

import com.onato.assignment.dto.MarksDto;
import com.onato.assignment.dto.Percentage;
import com.onato.assignment.dto.StudentDao;
import com.onato.assignment.dto.Subjects;
import com.onato.assignment.entity.Marks;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MarksService {

	Marks addMarks(MarksDto marks);

	void deleteMarks(Integer id);

	Marks updateMarks(MarksDto marksDto);

	List<Subjects> getMarks(String rollNumber, String standard);

	List<Percentage> getStudents(Integer marks);

	List<StudentDao> findToppers(String subject, String standard);

}
