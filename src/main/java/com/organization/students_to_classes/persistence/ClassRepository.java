package com.organization.students_to_classes.persistence;

import com.organization.students_to_classes.exceptions.NotFoundException;
import com.organization.students_to_classes.service.model.ClassBase;
import com.organization.students_to_classes.service.model.ClassStudent;
import com.organization.students_to_classes.service.model.ClassWithId;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("default")
public class ClassRepository extends MockStorage implements IClassRepository {

  @Override
  public List<ClassWithId> getAll() {
    return new ArrayList<ClassWithId>(super.classMap.values());
  }

  @Override
  public ClassWithId save(ClassBase classBase) {
    int newId = super.counterClass.incrementAndGet();
    ClassWithId classWithId = new ClassWithId(classBase.getCode(), classBase.getTitle(),
        classBase.getDescription(), newId);
    super.classMap.put(newId, classWithId);
    ClassStudent classStudent = new ClassStudent(classWithId, new ArrayList<>());
    super.classStudentMap.put(newId, classStudent);
    return classWithId;
  }

  @Override
  public ClassWithId update(int classId, ClassBase classBase) throws NotFoundException {
    if (!super.classMap.containsKey(classId)) {
      throw new NotFoundException("unable to find student");
    }
    ClassWithId classWithId = super.classMap.get(classId);
    classWithId.setCode(classBase.getCode());
    classWithId.setTitle(classBase.getTitle());
    classWithId.setDescription(classBase.getDescription());
    return classWithId;
  }

  @Override
  public void delete(int classId) throws NotFoundException {
    if (!super.classMap.containsKey(classId)) {
      throw new NotFoundException("unable to find Class");
    }
    super.classMap.remove(classId);
  }
}
