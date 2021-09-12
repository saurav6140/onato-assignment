package com.onato.assignment.dto;

import javax.persistence.Column;

public interface StudentDao {

  @Column(name = "student_id")
  String getStudentId();
  @Column(name= "marks")
  String getMarks();
  @Column(name = "subject")
  String getSubject();
  @Column(name = "roll_number")
  String getRollNumber();
  @Column(name = "name")
  String getName();
  @Column(name = "standard")
  String getStandard();



}
