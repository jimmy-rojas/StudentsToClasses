package com.organization.students_to_classes.service.model;

public class StudentWithId extends StudentBase {

  private int studentId;

  public StudentWithId(String firstName, String lastName, int studentId) {
    super(firstName, lastName);
    this.studentId = studentId;
  }

  public int getStudentId() {
    return studentId;
  }

  public void setStudentId(int studentId) {
    this.studentId = studentId;
  }

}
