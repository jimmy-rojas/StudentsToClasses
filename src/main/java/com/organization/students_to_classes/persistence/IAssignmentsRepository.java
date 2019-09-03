package com.organization.students_to_classes.persistence;

import com.organization.students_to_classes.exceptions.NotFoundException;
import com.organization.students_to_classes.service.model.ClassStudent;
import com.organization.students_to_classes.service.model.StudentClass;
import java.util.List;

public interface IAssignmentsRepository {

  ClassStudent getClassStudents(Integer classId) throws NotFoundException;

  List<ClassStudent> getAllClasses();

  StudentClass getStudentClasses(Integer studentId) throws NotFoundException;

  List<StudentClass> getAllStudents();
}
