package com.gk.MapperApplication2.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.MapperApplication2.DTO.CourseDTO;
import com.gk.MapperApplication2.DTO.CourseMapper;
import com.gk.MapperApplication2.Entities.Course;
import com.gk.MapperApplication2.Repositories.CourseRepository;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseMapper courseMapper;

    public CourseDTO saveCourseDTO(Course course){
        Course saved = courseRepository.save(course);
        return courseMapper.toCourseDTO(saved);

    }

    public List<Course> getCourses(){
        List<Course> courses = courseRepository.findAll();
        return courses;
        //courseMapper.coursesList(null)
    }

    public Course getCourse(long id){
        return courseRepository.findById(id).orElse(null);
    }

    public List<Course> getCourseByStudentId(long id){
        return courseRepository.findCourseByStudentId(id);
    }

}
