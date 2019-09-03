package com.organization.students_to_classes.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import com.organization.students_to_classes.exceptions.NotFoundException;
import com.organization.students_to_classes.service.ClassSaveService;
import com.organization.students_to_classes.service.model.ClassBase;
import com.organization.students_to_classes.service.model.ClassWithId;
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
@RequestMapping("v1/class")
public class ClassController {

  private final ClassSaveService classSaveService;

  @Autowired
  public ClassController(
      ClassSaveService classSaveService) {
    this.classSaveService = classSaveService;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/")
  public List<ClassWithId> getAllClasses() {
    return this.classSaveService.getAll();
  }

  @RequestMapping(method=POST, value="/")
  public ClassWithId createStudent(@RequestBody ClassBase classBase) {
    return this.classSaveService.create(classBase);
  }

  @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{classId}")
  public ClassWithId updateStudent(@PathVariable Integer classId, @RequestBody ClassBase classBase)
      throws NotFoundException {
    return this.classSaveService.update(classId, classBase);
  }

  @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{classId}")
  public ResponseEntity deleteStudent(@PathVariable Integer classId) throws NotFoundException {
    this.classSaveService.delete(classId);
    return new ResponseEntity(HttpStatus.OK);
  }
}
