package com.onato.assignment.controller;

import com.onato.assignment.dto.MarksDto;
import com.onato.assignment.dto.Percentage;
import com.onato.assignment.dto.StudentDao;
import com.onato.assignment.dto.Subjects;
import com.onato.assignment.entity.Marks;
import com.onato.assignment.service.MarksService;
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

@RestController
@RequestMapping("/api/marks")
public class MarksController {
	
	@Autowired
	private MarksService marksService;

	@PostMapping(value="/add")
	public Marks addMarks(@RequestBody MarksDto marks) {
		return marksService.addMarks(marks);
	}
	
	@DeleteMapping(value="/delete")
	public void deleteMarks(@RequestParam Integer id){
		marksService.deleteMarks(id);
	}

	@PutMapping(value="/update")
	public Marks updateMarks(@RequestBody MarksDto marks) {
		return marksService.updateMarks(marks);
	}

	@GetMapping(value="/get")
	public List<Subjects> getMarks(@RequestParam String rollNumber,
      @RequestParam String standard) {
	  return marksService.getMarks(rollNumber, standard);
  }

	@GetMapping(value="/percent")
	public List<Percentage> findPercent(@RequestParam Integer percent) {
		return marksService.getStudents(percent);
	}

	@GetMapping(value="/highest")
	public List<StudentDao> getTopScorer(@RequestParam String standard, @RequestParam String subject) {
		return marksService.findToppers(standard, subject);
	}

}
