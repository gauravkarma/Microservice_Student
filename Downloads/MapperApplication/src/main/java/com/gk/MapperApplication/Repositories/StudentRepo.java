package com.gk.MapperApplication.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gk.MapperApplication.DTO.StudentReadDTO;
import com.gk.MapperApplication.Entities.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {

    // @Query("Select s.id,s.name,s.age from Student s")
    // public List<StudentReadDTO> getStudents(); 
   // Optional<StudentReadDTO> findById(long id);
}
