package com.organization.students_to_classes.persistence;

import com.organization.students_to_classes.service.model.StudentBase;
import com.organization.students_to_classes.service.model.StudentWithId;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("default")
public class StudentRepository extends MockStorage implements IStudentRepository {

  @Override
  public List<StudentWithId> getAll() {
    return new ArrayList<StudentWithId>(super.studentMap.values());
  }

  @Override
  public StudentWithId save(StudentBase student) {
    return null;
  }

  @Override
  public StudentWithId update(Integer studentId, StudentBase student) {
    return null;
  }

  @Override
  public void delete(Integer studentId) {

  }
}
