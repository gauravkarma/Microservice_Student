package com.gk.MapperApplication.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gk.MapperApplication.Entities.Test;

@Repository
public interface TestRepository extends JpaRepository<Test,Integer> {

}
