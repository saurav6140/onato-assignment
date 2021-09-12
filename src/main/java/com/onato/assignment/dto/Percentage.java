package com.onato.assignment.dto;

import javax.persistence.Column;

public interface Percentage {

  @Column(name = "student_id")
  String getStudentId();
  @Column(name = "roll_number")
  String getRollNumber();
  @Column(name = "name")
  String getName();
  @Column(name = "standard")
  String getStandard();
  @Column(name= "aggregate")
  String getPercentage();

}
