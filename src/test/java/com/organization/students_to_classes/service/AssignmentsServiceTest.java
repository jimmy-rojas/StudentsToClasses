package com.organization.students_to_classes.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.organization.students_to_classes.exceptions.NotFoundException;
import com.organization.students_to_classes.persistence.IAssignmentsRepository;
import com.organization.students_to_classes.service.model.ClassStudent;
import com.organization.students_to_classes.service.model.ClassWithId;
import com.organization.students_to_classes.service.model.StudentClass;
import com.organization.students_to_classes.service.model.StudentWithId;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class AssignmentsServiceTest {

  private AssignmentsService instance;
  private IAssignmentsRepository assignmentsRepository;

  @Before
  public void setUp() {
    assignmentsRepository = new IAssignmentsRepository() {
      @Override
      public ClassStudent getClassStudents(int classId) throws NotFoundException {
        if (classId > 0) {
          return new ClassStudent(
              new ClassWithId("code", "title", "description", classId),
              new ArrayList<>());
        }
        throw new NotFoundException("Not Found");
      }

      @Override
      public List<ClassStudent> getAllClasses() {
        return new ArrayList<>();
      }

      @Override
      public StudentClass getStudentClasses(int studentId) throws NotFoundException {
        if (studentId > 0) {
          return new StudentClass(
              new StudentWithId("firstName", "lastName", studentId),
              new ArrayList<>());
        }
        throw new NotFoundException("Not Found");
      }

      @Override
      public List<StudentClass> getAllStudents() {
        return new ArrayList<>();
      }
    };
    instance = new AssignmentsService(assignmentsRepository);
  }

  @Test
  public void getAllStudents() throws Exception {
    List<StudentClass> allStudentsList = instance.getAllStudents();
    assertNotNull(allStudentsList);
    assertEquals(0, allStudentsList.size());
  }

  @Test (expected = NotFoundException.class)
  public void getStudentClasses_NotFoundException() throws Exception {
    instance.getStudentClasses(-1);
  }

  @Test
  public void getStudentClasses() throws Exception {
    StudentClass studentClasses = instance.getStudentClasses(1);
    assertNotNull(studentClasses);
    assertEquals(1, studentClasses.getStudentId().getStudentId());
  }

  @Test
  public void getAllClasses() throws Exception {
    List<ClassStudent> allClassesList = instance.getAllClasses();
    assertNotNull(allClassesList);
    assertEquals(0, allClassesList.size());
  }

  @Test (expected = NotFoundException.class)
  public void getClassStudents_NotFoundException() throws Exception {
    instance.getClassStudents(0);
  }

  @Test
  public void getClassStudents() throws Exception {
    ClassStudent classStudents = instance.getClassStudents(1);
    assertNotNull(classStudents);
    assertEquals(1, classStudents.getClassWithId().getClassId());
  }
}