package com.organization.students_to_classes.service.model;

public class ClassWithId extends ClassBase {

  private int classId;

  public ClassWithId(String code, String title, String description, int classId) {
    super(code, title, description);
    this.classId = classId;
  }

  public int getClassId() {
    return classId;
  }

  public void setClassId(int classId) {
    this.classId = classId;
  }
}
