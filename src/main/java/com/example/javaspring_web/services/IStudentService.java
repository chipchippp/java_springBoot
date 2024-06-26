package com.example.javaspring_web.services;

import com.example.javaspring_web.entity.Students;

import java.util.List;

public interface IStudentService {
    public List<Students> getAllStudents();
    public Students getStudentsById(Long id);
    public void saveStudents(Students students);
    public void updateStudents(Long id,Students students);
    public String deleteStudents(Long id);
}
