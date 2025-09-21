package com.gk.MapperApplication.external;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
private long courseId;
    private String courseName;
    private String courseAuthor;
    private int coursePrice;
    private long studentId;
}
