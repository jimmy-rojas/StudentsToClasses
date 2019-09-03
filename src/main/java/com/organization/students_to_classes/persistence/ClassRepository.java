package com.organization.students_to_classes.persistence;

import com.organization.students_to_classes.service.model.ClassBase;
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
    return null;
  }

  @Override
  public ClassWithId update(Integer classId, ClassBase classBase) {
    return null;
  }

  @Override
  public void delete(Integer classId) {

  }
}
