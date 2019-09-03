package com.organization.students_to_classes.service.model;

import java.util.List;

public class StudentClass {

  private StudentWithId studentId;
  private List<ClassWithId> classList;

  public StudentClass(StudentWithId studentId,
      List<ClassWithId> classList) {
    this.studentId = studentId;
    this.classList = classList;
  }

  public StudentWithId getStudentId() {
    return studentId;
  }

  public void setStudentId(StudentWithId studentId) {
    this.studentId = studentId;
  }

  public List<ClassWithId> getClassList() {
    return classList;
  }

  public void setClassList(
      List<ClassWithId> classList) {
    this.classList = classList;
  }
}
