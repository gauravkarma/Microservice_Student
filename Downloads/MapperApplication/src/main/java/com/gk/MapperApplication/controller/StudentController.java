package com.gk.MapperApplication.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties.Http;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gk.MapperApplication.DTO.StudentCreateDTO;
import com.gk.MapperApplication.DTO.StudentReadDTO;
import com.gk.MapperApplication.Entities.Student;
import com.gk.MapperApplication.Entities.Test;
import com.gk.MapperApplication.Services.StudentService;
import com.gk.MapperApplication.external.CourseDTO;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    
    @PostMapping
    public StudentCreateDTO saveStudent(@RequestBody @Valid StudentCreateDTO studentCreateDTO){
        return studentService.saveStudent(studentCreateDTO);

    }

    @GetMapping
    public List<StudentReadDTO> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentReadDTO> getStudent(@PathVariable long id){
            StudentReadDTO dto = studentService.getStudentById(id);
            if(dto!=null){
                return new ResponseEntity<>(dto,HttpStatus.OK);    
            }else{
                return ResponseEntity.notFound().build();
            }

         
    } 

    @GetMapping("/courses")
    public List<CourseDTO> getAllCourses(){
        return studentService.getAllCourses();
    }

    @GetMapping("/courses/students/{id}")
    public List<CourseDTO> getCoursesByStudentId(@PathVariable long id){
        return studentService.getCoursesByStudentId(id);
    }

    @PostMapping(path = "/test")
    public Test saveTest(@RequestBody Test test){
        return studentService.saveTest(test);
    }

}
