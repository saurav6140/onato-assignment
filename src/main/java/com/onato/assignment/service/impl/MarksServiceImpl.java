package com.onato.assignment.service.impl;

import com.onato.assignment.dao.MarksRepository;
import com.onato.assignment.dao.StudentRepository;
import com.onato.assignment.dto.MarksDto;
import com.onato.assignment.dto.Percentage;
import com.onato.assignment.dto.StudentDao;
import com.onato.assignment.dto.Subjects;
import com.onato.assignment.entity.Marks;
import com.onato.assignment.entity.Student;
import com.onato.assignment.exception.ResourceAlreadyExistsException;
import com.onato.assignment.exception.StudentNotFoundException;
import com.onato.assignment.service.MarksService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MarksServiceImpl implements MarksService {

	@Autowired
	private MarksRepository marksRepository;

	@Autowired
	private StudentRepository studentRepository;
	@Override
	public Marks addMarks(MarksDto marksDto) {

		Student student = studentRepository.findByRollNumberAndStandard(marksDto.getRollNumber(),marksDto.getStandard());
		if(student==null)
			throw new StudentNotFoundException("No such student exists");
		else {
			Marks marks = marksRepository.findByStudentIdAndSubject(student.getId(),marksDto.getSubject());
			if(marks==null) {
				marks = new Marks();
				marks.setMarks(marksDto.getMarks());
				marks.setStudentId(student.getId());
				marks.setSubject(marksDto.getSubject());
				return marksRepository.save(marks);
			}
			else
				throw new ResourceAlreadyExistsException("Marks for this student and subject already exist. Please use update method to edit.");
		}
	}

	@Transactional
	public void deleteMarks(Integer id) {
//		Student student = studentRepository.findByRollNumberAndStandard(rollNumber, standard);
//		if(student == null)
//			throw new StudentNotFoundException("No such student exists");
//		else
//		{
//			Marks marks = marksRepository.findByStudentIdAndSubject(student.getId(), subject);
//			marksRepository.delete(marks.getId());
//			marksRepository.deleteByStudentIdAndSubject(student.getId(),subject);
		marksRepository.delete(id);
		}

	public Marks updateMarks(MarksDto marksDto) {

		Student student = studentRepository.findByRollNumberAndStandard(marksDto.getRollNumber(),marksDto.getStandard());
		if(student==null)
			throw new StudentNotFoundException("No such student exists");
		else {
			Marks marks = marksRepository.findByStudentIdAndSubject(student.getId(),marksDto.getSubject());
			if(marks==null)
				return addMarks(marksDto);
			else
			{
				marks.setMarks(marksDto.getMarks());
				marksRepository.save(marks);
				return marks;
			}
		}
	}

	public List<Subjects> getMarks(String rollNumber, String standard) {

		Student student = studentRepository.findByRollNumberAndStandard(rollNumber, standard);
		if(student==null)
			throw new StudentNotFoundException("No such student exists");
		else {
			List<Marks> marksList = marksRepository.findByStudentId(student.getId());
			List<Subjects> subjectsList = new ArrayList<>();
			for (Marks marks: marksList
			) {
				subjectsList.add(new Subjects(marks.getId(),marks.getSubject(),marks.getMarks()));
			}
			return subjectsList;
		}
	}

	public List<Percentage> getStudents(Integer marks){
		return marksRepository.findPercentage(marks);
	}

	public List<StudentDao> findToppers(String standard, String subject){
		return marksRepository.findToppers(standard, subject);
	}

}