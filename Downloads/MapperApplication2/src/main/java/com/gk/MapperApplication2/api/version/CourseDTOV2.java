package com.gk.MapperApplication2.api.version;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor
@Builder
public class CourseDTOV2 {
//    private String courseName;
    private String courseAuthor;
 //   private int coursePrice;
// id from student service
    private long studentId;


}
