package com.organization.students_to_classes.service.model;

public class ClassWithId extends ClassBase {

  private Integer classId;

  public ClassWithId(String code, String title, String description, Integer classId) {
    super(code, title, description);
    this.classId = classId;
  }

  public Integer getClassId() {
    return classId;
  }

  public void setClassId(Integer classId) {
    this.classId = classId;
  }
}
