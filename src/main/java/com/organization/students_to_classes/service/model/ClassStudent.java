package com.organization.students_to_classes.service.model;

import java.util.List;

public class ClassStudent {

  private String code;
  private List<Student> studentList;

  public ClassStudent(String code,
      List<Student> studentList) {
    this.code = code;
    this.studentList = studentList;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public List<Student> getStudentList() {
    return studentList;
  }

  public void setStudentList(
      List<Student> studentList) {
    this.studentList = studentList;
  }
}
