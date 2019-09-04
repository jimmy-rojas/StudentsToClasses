package com.organization.students_to_classes.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.organization.students_to_classes.exceptions.NotFoundException;
import com.organization.students_to_classes.persistence.IClassRepository;
import com.organization.students_to_classes.service.model.ClassBase;
import com.organization.students_to_classes.service.model.ClassWithId;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class ClassSaveServiceTest {

  private ClassSaveService instance;
  private IClassRepository classRepository;
  private ClassBase classBase;

  @Before
  public void setUp() {
    classBase = new ClassBase("code", "title", "description");
    classRepository = new IClassRepository() {
      @Override
      public List<ClassWithId> getAll() {
        return new ArrayList<>();
      }

      @Override
      public ClassWithId save(ClassBase classBase) {
        return new ClassWithId("code", "title", "description", 1);
      }

      @Override
      public ClassWithId update(int classId, ClassBase classBase) throws NotFoundException {
        if (classId > 0) {
          return new ClassWithId(classBase.getCode(), classBase.getTitle(),
              classBase.getDescription(), classId);
        }
        throw new NotFoundException("Not Found");
      }

      @Override
      public void delete(int classId) throws NotFoundException {
        if (classId < 1) {
          throw new NotFoundException("Not Found");
        }
      }
    };
    instance = new ClassSaveService(classRepository);
  }

  @Test
  public void testGetAll() {
    List<ClassWithId> allClasses = instance.getAll();
    assertNotNull(allClasses);
    assertEquals(0, allClasses.size());
  }

  @Test
  public void testCreate() {
    ClassWithId classSaved = instance.create(classBase);
    assertNotNull(classSaved);
    assertEquals(1, classSaved.getClassId());
  }

  @Test (expected = NotFoundException.class)
  public void testUpdate_NotFoundException() throws Exception {
    instance.update(0, classBase);
  }

  @Test
  public void testUpdate() throws Exception {
    ClassWithId classUpdated = instance.update(1, classBase);
    assertNotNull(classUpdated);
    assertEquals(1, classUpdated.getClassId());
  }

  @Test (expected = NotFoundException.class)
  public void testDelete_NotFoundException() throws Exception {
    instance.delete(-1);
  }

  @Test
  public void testDelete() throws Exception {
    instance.delete(1);
  }
}