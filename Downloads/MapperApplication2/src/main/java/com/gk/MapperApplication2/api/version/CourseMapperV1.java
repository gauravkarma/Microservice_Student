package com.gk.MapperApplication2.api.version;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.gk.MapperApplication2.Entities.Course;
@Component
public class CourseMapperV1 {
//entity->dto
    public CourseDTOV1 toCourseDTOV1(Course course){
        return new CourseDTOV1().builder()
                .courseName(course.getCourseName())
            //    .courseAuthor(course.getCourseAuthor())
            //   .coursePrice(course.getCoursePrice())
                .studentId(course.getStudentId())
                .build();
    }
//dto->entity
    public Course toCourse(CourseDTOV1 courseDTOV1){
        Course course = new Course().builder()
        .courseName(courseDTOV1.getCourseName())
    //    .courseAuthor(courseDTOV1.getCourseAuthor())
    //    .coursePrice(courseDTOV1.getCoursePrice())
        .studentId(courseDTOV1.getStudentId())
        .build();
        return course;
    }
//List<dto> -> List<course>
    
}
