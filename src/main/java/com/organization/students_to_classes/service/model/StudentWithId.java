package com.organization.students_to_classes.service.model;

public class StudentWithId extends StudentBase {

  private Integer studentId;

  public StudentWithId(String firstName, String lastName, Integer studentId) {
    super(firstName, lastName);
    this.studentId = studentId;
  }

  public Integer getStudentId() {
    return studentId;
  }

  public void setStudentId(Integer studentId) {
    this.studentId = studentId;
  }

}
