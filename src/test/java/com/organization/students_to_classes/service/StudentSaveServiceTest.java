package com.organization.students_to_classes.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.organization.students_to_classes.exceptions.NotFoundException;
import com.organization.students_to_classes.persistence.IStudentRepository;
import com.organization.students_to_classes.service.model.StudentBase;
import com.organization.students_to_classes.service.model.StudentWithId;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class StudentSaveServiceTest {

  private StudentSaveService instance;
  private IStudentRepository studentRepository;
  private StudentBase studentBase;

  @Before
  public void setUp() {
    studentBase = new StudentBase("firstName", "lastName");
    studentRepository = new IStudentRepository() {
      @Override
      public List<StudentWithId> getAll() {
        return new ArrayList<>();
      }

      @Override
      public StudentWithId save(StudentBase student) {
        return new StudentWithId("firstName", "lastName", 1);
      }

      @Override
      public StudentWithId update(int studentId, StudentBase student) throws NotFoundException {
        if (studentId > 0) {
          return new StudentWithId("firstName", "lastName", studentId);
        }
        throw new NotFoundException("Not Found");
      }

      @Override
      public void delete(int studentId) throws NotFoundException {
        if (studentId < 1) {
          throw new NotFoundException("Not Found");
        }
      }
    };
    instance = new StudentSaveService(studentRepository);
  }

  @Test
  public void testGetAll() throws Exception {
    List<StudentWithId> allStudents = instance.getAll();
    assertNotNull(allStudents);
    assertEquals(0, allStudents.size());
  }

  @Test
  public void testCreate() throws Exception {
    StudentWithId studentSaved = instance.create(studentBase);
    assertNotNull(studentSaved);
    assertEquals(1, studentSaved.getStudentId());
  }

  @Test (expected = NotFoundException.class)
  public void testUpdate_NotFoundException() throws Exception {
    instance.update(0, studentBase);
  }

  @Test
  public void testUpdate() throws Exception {
    StudentWithId studentUpdated = instance.update(1, studentBase);
    assertNotNull(studentUpdated);
    assertEquals(1, studentUpdated.getStudentId());
  }

  @Test (expected = NotFoundException.class)
  public void testDelete_NotFoundException() throws Exception {
    instance.delete(0);
  }

  @Test
  public void testDelete() throws Exception {
    instance.delete(1);
  }
}