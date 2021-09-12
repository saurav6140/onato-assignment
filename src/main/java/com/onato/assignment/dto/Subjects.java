package com.onato.assignment.dto;


public class Subjects {

  private Integer id;
  private String subject;
  private Integer marks;

  public Subjects(Integer id, String subject, Integer marks) {
    this.id = id;
    this.subject = subject;
    this.marks = marks;
  }

  public Subjects(){
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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

}
