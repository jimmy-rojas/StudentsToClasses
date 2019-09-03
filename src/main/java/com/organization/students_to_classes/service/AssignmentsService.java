package com.organization.students_to_classes.service;

import com.organization.students_to_classes.exceptions.NotFoundException;
import com.organization.students_to_classes.persistence.IAssignmentsRepository;
import com.organization.students_to_classes.service.model.ClassStudent;
import com.organization.students_to_classes.service.model.StudentClass;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignmentsService {

  @Autowired
  private IAssignmentsRepository assignmentsRepository;

  public List<StudentClass> getAllStudents() {
    return this.assignmentsRepository.getAllStudents();
  }

  public StudentClass getStudentClasses(Integer studentId) throws NotFoundException {
    return this.assignmentsRepository.getStudentClasses(studentId);
  }

  public List<ClassStudent> getAllClasses() {
    return this.assignmentsRepository.getAllClasses();
  }

  public ClassStudent getClassStudents(Integer classId) throws NotFoundException {
    return this.assignmentsRepository.getClassStudents(classId);
  }
}
