package com.organization.students_to_classes.service.model;

import java.util.List;

public class ClassStudent {

  private ClassWithId classWithId;
  private List<StudentWithId> studentList;

  public ClassStudent(ClassWithId classWithId,
      List<StudentWithId> studentList) {
    this.classWithId = classWithId;
    this.studentList = studentList;
  }

  public ClassWithId getClassWithId() {
    return classWithId;
  }

  public void setClassWithId(ClassWithId classWithId) {
    this.classWithId = classWithId;
  }

  public List<StudentWithId> getStudentList() {
    return studentList;
  }

  public void setStudentList(
      List<StudentWithId> studentList) {
    this.studentList = studentList;
  }
}
