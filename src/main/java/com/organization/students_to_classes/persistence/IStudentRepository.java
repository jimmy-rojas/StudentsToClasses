package com.organization.students_to_classes.persistence;

import com.organization.students_to_classes.exceptions.NotFoundException;
import com.organization.students_to_classes.service.model.StudentBase;
import com.organization.students_to_classes.service.model.StudentWithId;
import java.util.List;

public interface IStudentRepository {

  List<StudentWithId> getAll();

  StudentWithId save(StudentBase student);

  StudentWithId update(int studentId, StudentBase student) throws NotFoundException;

  void delete(int studentId) throws NotFoundException;
}
