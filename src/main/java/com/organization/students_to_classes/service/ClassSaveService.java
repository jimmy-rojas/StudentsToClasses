package com.organization.students_to_classes.service;

import com.organization.students_to_classes.persistence.IClassRepository;
import com.organization.students_to_classes.service.model.ClassBase;
import com.organization.students_to_classes.service.model.ClassWithId;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassSaveService {

  @Autowired
  private IClassRepository classRepository;

  public List<ClassWithId> getAll() {
    return this.classRepository.getAll();
  }

  public ClassWithId create(ClassBase classBase) {
    return this.classRepository.save(classBase);
  }

  public ClassWithId update(Integer classId, ClassBase classBase) {
    return this.classRepository.update(classId, classBase);
  }

  public void delete(Integer classId) {
    this.classRepository.delete(classId);
  }
}
