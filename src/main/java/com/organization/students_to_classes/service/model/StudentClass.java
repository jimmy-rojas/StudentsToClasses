package com.organization.students_to_classes.service.model;

import java.util.List;

public class StudentClass {

  private Integer studentId;
  private List<ClassStudent> classList;

  public StudentClass(Integer studentId,
      List<ClassStudent> classList) {
    this.studentId = studentId;
    this.classList = classList;
  }

  public Integer getStudentId() {
    return studentId;
  }

  public void setStudentId(Integer studentId) {
    this.studentId = studentId;
  }

  public List<ClassStudent> getClassList() {
    return classList;
  }

  public void setClassList(
      List<ClassStudent> classList) {
    this.classList = classList;
  }
}
