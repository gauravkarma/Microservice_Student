package com.gk.MapperApplication2.api.version;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.gk.MapperApplication2.Entities.Course;
@Component
public class CourseMapperV2 {
//entity->dto
    public CourseDTOV2 toCourseDTOV2(Course course){
        return new CourseDTOV2().builder()
            //    .courseName(course.getCourseName())
                .courseAuthor(course.getCourseAuthor())
            //   .coursePrice(course.getCoursePrice())
                .studentId(course.getStudentId())
                .build();
    }
//dto->entity
    public Course toCourse(CourseDTOV2 courseDTOV2){
        Course course = new Course().builder()
    //    .courseName(courseDTOV2.getCourseName())
        .courseAuthor(courseDTOV2.getCourseAuthor())
    //    .coursePrice(courseDTOV2.getCoursePrice())
        .studentId(courseDTOV2.getStudentId())
        .build();
        return course;
    }
//List<dto> -> List<course>
    
}
