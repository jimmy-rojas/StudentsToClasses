package com.organization.students_to_classes.controller;

import com.organization.students_to_classes.exceptions.NotFoundException;
import com.organization.students_to_classes.service.AssignmentsService;
import com.organization.students_to_classes.service.model.ClassStudent;
import com.organization.students_to_classes.service.model.StudentClass;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AssignmentsController exposes all endpoints related to Assignments for Students and Classes
 *
 */
@RestController
@RequestMapping("v1/assignments")
public class AssignmentsController {

  private final AssignmentsService assignmentsService;

  @Autowired
  public AssignmentsController(
      AssignmentsService assignmentsService) {
    this.assignmentsService = assignmentsService;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/allStudents")
  public List<StudentClass> getAllStudents() {
    return this.assignmentsService.getAllStudents();
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/student/{studentId}")
  public StudentClass getStudentClasses(@PathVariable int studentId) throws NotFoundException {
    return this.assignmentsService.getStudentClasses(studentId);
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/allClasses")
  public List<ClassStudent> getAllClasses() {
    return this.assignmentsService.getAllClasses();
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/class/{classId}")
  public ClassStudent getClassStudents(@PathVariable int classId) throws NotFoundException {
    return this.assignmentsService.getClassStudents(classId);
  }
}
