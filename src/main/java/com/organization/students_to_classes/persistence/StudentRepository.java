package com.organization.students_to_classes.persistence;

import com.organization.students_to_classes.exceptions.NotFoundException;
import com.organization.students_to_classes.service.model.StudentBase;
import com.organization.students_to_classes.service.model.StudentClass;
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
    int newId = super.counterStudent.incrementAndGet();
    StudentWithId studentWithId = new StudentWithId(student.getFirstName(), student.getLastName(), newId);
    super.studentMap.put(newId, studentWithId);
    StudentClass studentClass = new StudentClass(studentWithId, new ArrayList<>());
    super.studentClassMap.put(newId, studentClass);
    return studentWithId;
  }

  @Override
  public StudentWithId update(int studentId, StudentBase student) throws NotFoundException {
    if (!super.studentMap.containsKey(studentId)) {
      throw new NotFoundException("unable to find student");
    }
    StudentWithId studentWithId = super.studentMap.get(studentId);
    studentWithId.setFirstName(student.getFirstName());
    studentWithId.setLastName(student.getLastName());
    return studentWithId;
  }

  @Override
  public void delete(int studentId) throws NotFoundException {
    if (!super.studentMap.containsKey(studentId)) {
      throw new NotFoundException("unable to find student");
    }
    super.studentMap.remove(studentId);
  }
}
