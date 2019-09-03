package com.organization.students_to_classes.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import com.organization.students_to_classes.exceptions.NotFoundException;
import com.organization.students_to_classes.service.StudentSaveService;
import com.organization.students_to_classes.service.model.StudentWithId;
import com.organization.students_to_classes.service.model.StudentBase;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/student")
public class StudentController {

  private final StudentSaveService studentSaveService;

  @Autowired
  public StudentController(
      StudentSaveService studentSaveService) {
    this.studentSaveService = studentSaveService;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/")
  public List<StudentWithId> getAllStudents() {
    return this.studentSaveService.getAll();
  }

  @RequestMapping(method=POST, value="/")
  public StudentWithId createStudent(@RequestBody StudentBase student) {
    return this.studentSaveService.create(student);
  }

  @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{studentId}")
  public StudentWithId updateStudent(@PathVariable Integer studentId, @RequestBody StudentBase student)
      throws NotFoundException {
    return this.studentSaveService.update(studentId, student);
  }

  @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{studentId}")
  public ResponseEntity deleteStudent(@PathVariable Integer studentId) throws NotFoundException {
    this.studentSaveService.delete(studentId);
    return new ResponseEntity(HttpStatus.OK);
  }
}
