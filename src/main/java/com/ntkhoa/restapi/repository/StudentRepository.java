package com.ntkhoa.restapi.repository;

import com.ntkhoa.restapi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}

