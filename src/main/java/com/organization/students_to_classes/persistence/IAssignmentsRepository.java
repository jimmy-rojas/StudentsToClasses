package com.organization.students_to_classes.persistence;

import com.organization.students_to_classes.service.model.ClassStudent;
import com.organization.students_to_classes.service.model.StudentClass;
import java.util.List;

public interface IAssignmentsRepository {

  ClassStudent getClassStudents(Integer classId);

  List<ClassStudent> getAllClasses();

  StudentClass getStudentClasses(Integer studentId);

  List<StudentClass> getAllStudents();
}
