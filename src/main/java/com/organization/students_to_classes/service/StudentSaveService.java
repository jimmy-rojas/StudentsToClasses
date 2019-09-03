package com.organization.students_to_classes.service;

import com.organization.students_to_classes.exceptions.NotFoundException;
import com.organization.students_to_classes.persistence.IStudentRepository;
import com.organization.students_to_classes.service.model.StudentBase;
import com.organization.students_to_classes.service.model.StudentWithId;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentSaveService {

  @Autowired
  private IStudentRepository studentRepository;

  public List<StudentWithId> getAll() {
    return this.studentRepository.getAll();
  }

  public StudentWithId create(StudentBase student) {
    return this.studentRepository.save(student);
  }

  public StudentWithId update(Integer studentId, StudentBase student) throws NotFoundException {
    return this.studentRepository.update(studentId, student);
  }

  public void delete(Integer studentId) throws NotFoundException {
    this.studentRepository.delete(studentId);
  }
}
