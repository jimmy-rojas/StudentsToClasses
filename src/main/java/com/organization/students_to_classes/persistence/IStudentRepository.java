package com.organization.students_to_classes.persistence;

import com.organization.students_to_classes.service.model.StudentBase;
import com.organization.students_to_classes.service.model.StudentWithId;
import java.util.List;

public interface IStudentRepository {

  List<StudentWithId> getAll();

  StudentWithId save(StudentBase student);

  StudentWithId update(Integer studentId, StudentBase student);

  void delete(Integer studentId);
}
