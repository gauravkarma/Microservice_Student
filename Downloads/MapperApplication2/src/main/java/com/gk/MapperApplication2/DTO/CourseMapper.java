package com.gk.MapperApplication2.DTO;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.gk.MapperApplication2.Entities.Course;
@Component
public class CourseMapper {
//entity->dto
    public CourseDTO toCourseDTO(Course course){
        return new CourseDTO().builder()
                .courseName(course.getCourseName())
                .courseAuthor(course.getCourseAuthor())
                .coursePrice(course.getCoursePrice())
                .studentId(course.getStudentId())
                .build();
    }
//dto->entity
    public Course toCourse(CourseDTO courseDTO){
        Course course = new Course().builder()
        .courseName(courseDTO.getCourseName())
        .courseAuthor(courseDTO.getCourseAuthor())
        .coursePrice(courseDTO.getCoursePrice())
        .studentId(courseDTO.getStudentId())
        .build();
        return course;
    }
//List<dto> -> List<course>
    
}
