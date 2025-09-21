package com.gk.MapperApplication.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gk.MapperApplication.DTO.StudentCreateDTO;
import com.gk.MapperApplication.DTO.StudentMappper;
import com.gk.MapperApplication.DTO.StudentReadDTO;
import com.gk.MapperApplication.Entities.Student;
import com.gk.MapperApplication.Repositories.StudentRepo;
import com.gk.MapperApplication.external.CourseDTO;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private StudentMappper studentMapper;

    private final String url = "http://localhost:8081/courses";
    private final String url2 = "http://localhost:8081/courses/students/";
    @Autowired
    private RestTemplate restTemplate;
//create entity from dto
    public StudentCreateDTO saveStudent(StudentCreateDTO studentCreateDTO){
                 Student student = studentMapper.toStudent(studentCreateDTO);
                 Student saved = studentRepo.save(student);
                 return studentMapper.toStudentCreateDTO(saved);   
           }
//get all students with id, namd and age 
    public List<StudentReadDTO> getStudents(){
        List<Student> students = studentRepo.findAll();
        return studentMapper.toListStudentReadDTO(students);
        
    }
    //get student by id
    
    public StudentReadDTO getStudentById(long id){
        if(studentRepo.findById(id).isPresent()){
            Student student = studentRepo.findById(id).orElse(null);
            StudentReadDTO dto = studentMapper.toStudentReadDTO(student);
            return dto;
        }else{
            return null;
        }
        
    }

    //calling courses API from Student service

    public List<CourseDTO> getAllCourses(){
        ResponseEntity<List<CourseDTO>> response = restTemplate.exchange(url, 
                                    HttpMethod.GET,
                                    null,
                                    new ParameterizedTypeReference<List<CourseDTO>>() {}
                                );
        return response.getBody();
        
        
    }
    public List<CourseDTO> getCoursesByStudentId(long id) {
        ResponseEntity<List<CourseDTO>> coursesByStudentId = restTemplate.exchange(url2+id,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<CourseDTO>>() {
                                          });
                return coursesByStudentId.getBody();
      }


}
