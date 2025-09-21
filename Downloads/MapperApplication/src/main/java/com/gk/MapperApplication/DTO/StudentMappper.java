package com.gk.MapperApplication.DTO;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import com.gk.MapperApplication.Entities.Student;

@Component
public class StudentMappper {
//    Entity -> DTO
    public StudentReadDTO toStudentReadDTO(Student student){
        return new StudentReadDTO(student.getId(),student.getName(),student.getAge());
    } 
//  DTO -> Entity
    // public Student toStudent(StudentReadDTO studentReadDTO){
    //     Student student = new Student();
    //     student.setId(studentReadDTO.getId());
    //     student.setName(studentReadDTO.getName());
    //     student.setAge(studentReadDTO.getAge());
    //     return student;
    // }
//for save purpose
    public Student toStudent(StudentCreateDTO studentCreateDTO){
        Student student = new Student();
        student.setName(studentCreateDTO.getName());
        student.setAge(studentCreateDTO.getAge());
        student.setContact(studentCreateDTO.getContact());
        student.setAddress(studentCreateDTO.getAddress());
        return student;
    }
    //for create dto to entity
    public StudentCreateDTO toStudentCreateDTO(Student student){
        return new StudentCreateDTO(student.getName(),student.getAge(),student.getContact(),student.getAddress());

    }

//  List<Entity> -> List<DTO>
    public List<StudentReadDTO> toListStudentReadDTO(List<Student> students){
        return students.stream().map(this::toStudentReadDTO).collect(Collectors.toList());
    }
// List<DTO> -> List<Entity>
    public List<Student> toStudentList(List<StudentCreateDTO> studentCreateDTOs){
        return studentCreateDTOs.stream().map(this::toStudent).collect(Collectors.toList());
    }

    //get Student By id
   
  
//  Map<Type,Type>
}
