package com.example.javaspring_web.repository;

import com.example.javaspring_web.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Students, Long> {
}
