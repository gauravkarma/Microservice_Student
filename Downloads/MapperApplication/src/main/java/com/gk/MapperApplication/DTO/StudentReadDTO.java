package com.gk.MapperApplication.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentReadDTO {
    private long id;
    private String name;
    private int age;
}
