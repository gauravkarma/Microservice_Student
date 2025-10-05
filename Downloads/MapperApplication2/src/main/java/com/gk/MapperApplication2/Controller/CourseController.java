package com.gk.MapperApplication2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gk.MapperApplication2.DTO.CourseDTO;
import com.gk.MapperApplication2.Entities.Course;
import com.gk.MapperApplication2.Services.CourseService;
import com.gk.MapperApplication2.api.version.CourseDTOV1;
import com.gk.MapperApplication2.api.version.CourseDTOV2;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public CourseDTO saveCourse(@RequestBody Course course){
        return courseService.saveCourseDTO(course);
    }

    @GetMapping
    public List<Course> getCourses(){
        return courseService.getCourses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable long id){
        Course course = courseService.getCourse(id);
        if(course!=null){
            return new ResponseEntity<>(course,HttpStatus.OK);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/students/{studentId}")
    public List<Course> getCourseByStudentId(@PathVariable long studentId){
        return courseService.getCourseByStudentId(studentId);
    }

    //for api version v1 and v2
    @GetMapping("/v1/students/{studentId}")
    public List<CourseDTOV1> getCourseByStudentIdV1(@PathVariable long studentId){
        List<Course> courses = courseService.getCourseByStudentId(studentId);
        return courses.stream().map(course->new CourseDTOV1(course.getCourseName(),course.getCoursePrice(),course.getStudentId())).toList();
    }

    @GetMapping("/v2/students/{studentId}")
    public List<CourseDTOV2> getCourseByStudentIdV2(@PathVariable long studentId){
        List<Course> courses = courseService.getCourseByStudentId(studentId);
        return courses.stream().map(course->new CourseDTOV2(course.getCourseAuthor(),course.getStudentId())).toList();
    }

}
