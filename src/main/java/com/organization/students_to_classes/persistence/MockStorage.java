package com.organization.students_to_classes.persistence;

import com.organization.students_to_classes.service.model.ClassStudent;
import com.organization.students_to_classes.service.model.ClassWithId;
import com.organization.students_to_classes.service.model.StudentClass;
import com.organization.students_to_classes.service.model.StudentWithId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class MockStorage {

  protected static Map<Integer, StudentWithId> studentMap = new HashMap<>();
  protected static Map<Integer, ClassWithId> classMap = new HashMap<>();
  protected static Map<Integer, ClassStudent> classStudentMap = new HashMap<>();
  protected static Map<Integer, StudentClass> studentClassMap = new HashMap<>();

  protected static final AtomicInteger counterStudent = new AtomicInteger();
  protected static final AtomicInteger counterClass = new AtomicInteger();

  {
    for (int i=0; i<5; i++) {
      StudentWithId studentWithId = new StudentWithId("firstName-"+i, "lastName-"+i, i);
      studentMap.put(i, studentWithId);
      counterStudent.incrementAndGet();

      StudentClass studentClass = new StudentClass(studentWithId, new ArrayList<>());
      studentClassMap.put(i, studentClass);
    }
    for (int i=0; i<3; i++) {
      ClassWithId classWithId = new ClassWithId("code-"+i, "title-"+i, "description-"+i, i);
      classMap.put(i, classWithId);
      counterClass.incrementAndGet();
      int rand = new Random().nextInt(studentMap.size());
      List<StudentWithId> studentList = new ArrayList<>();
      for (int j=0; j<=rand; j++) {
        studentList.add(studentMap.get(j));
        studentClassMap.get(j).getClassList().add(classWithId);
      }
      ClassStudent classStudent = new ClassStudent(classWithId, studentList);
      classStudentMap.put(i, classStudent);
    }
  }

}
