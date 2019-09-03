package com.organization.students_to_classes.service.model;

public class Student {

  private Integer studentId;
  private String firstName;
  private String lastName;

  public Student(Integer studentId, String firstName, String lastName) {
    this.studentId = studentId;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public Integer getStudentId() {
    return studentId;
  }

  public void setStudentId(Integer studentId) {
    this.studentId = studentId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}
