package com.organization.students_to_classes.persistence;

import com.organization.students_to_classes.exceptions.NotFoundException;
import com.organization.students_to_classes.service.model.StudentBase;
import com.organization.students_to_classes.service.model.StudentWithId;
import java.util.List;

public interface IStudentRepository {

  List<StudentWithId> getAll();

  StudentWithId save(StudentBase student);

  StudentWithId update(Integer studentId, StudentBase student) throws NotFoundException;

  void delete(Integer studentId) throws NotFoundException;
}
