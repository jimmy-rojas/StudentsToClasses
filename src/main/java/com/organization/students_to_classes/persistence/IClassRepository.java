package com.organization.students_to_classes.persistence;

import com.organization.students_to_classes.exceptions.NotFoundException;
import com.organization.students_to_classes.service.model.ClassBase;
import com.organization.students_to_classes.service.model.ClassWithId;
import java.util.List;

public interface IClassRepository {

  List<ClassWithId> getAll();

  ClassWithId save(ClassBase classBase);

  ClassWithId update(Integer classId, ClassBase classBase) throws NotFoundException;

  void delete(Integer classId) throws NotFoundException;
}
