package com.organization.students_to_classes.service;

import com.organization.students_to_classes.exceptions.NotFoundException;
import com.organization.students_to_classes.persistence.IClassRepository;
import com.organization.students_to_classes.service.model.ClassBase;
import com.organization.students_to_classes.service.model.ClassWithId;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassSaveService is a service class to manage Classes features
 *
 */
@Service
public class ClassSaveService {

  private IClassRepository classRepository;

  @Autowired
  public ClassSaveService(IClassRepository classRepository) {
    this.classRepository = classRepository;
  }

  public List<ClassWithId> getAll() {
    return this.classRepository.getAll();
  }

  public ClassWithId create(ClassBase classBase) {
    return this.classRepository.save(classBase);
  }

  public ClassWithId update(int classId, ClassBase classBase) throws NotFoundException {
    return this.classRepository.update(classId, classBase);
  }

  public void delete(int classId) throws NotFoundException {
    this.classRepository.delete(classId);
  }
}
