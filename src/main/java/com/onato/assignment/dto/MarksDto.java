package com.onato.assignment.dto;

public class MarksDto {

  private String subject;
  private Integer marks;
  private String standard;
  private String rollNumber;

  public MarksDto(String subject, Integer marks, String standard, String rollNumber) {
    this.subject = subject;
    this.marks = marks;
    this.standard = standard;
    this.rollNumber = rollNumber;
  }
  
  public MarksDto(){
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public Integer getMarks() {
    return marks;
  }

  public void setMarks(Integer marks) {
    this.marks = marks;
  }

  public String getStandard() {
    return standard;
  }

  public void setStandard(String standard) {
    this.standard = standard;
  }

  public String getRollNumber() {
    return rollNumber;
  }

  public void setRollNumber(String rollNumber) {
    this.rollNumber = rollNumber;
  }


}
