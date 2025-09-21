package com.gk.MapperApplication.DTO;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateDTO {
    @NotBlank(message = "Name should not be blank")
    @NotNull(message = "Name should not be null")
    private String name;
    @NotNull(message = "Age should not be null")
    @Range(min = 18,max = 60,message = "Age 18-60 allowed only")
    private int age;
    // @Pattern(regexp = "^[0-9]+$", message = "Contact number must contain only digits")
    //@Range(min = 10,max=12,message = "Contact number bw 10-12 digits")
    private long contact;
    @Size(max = 60)
    
    private String address; 
}
