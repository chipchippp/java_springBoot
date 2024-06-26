package com.example.javaspring_web.services;

import com.example.javaspring_web.entity.ClassRoom;
import com.example.javaspring_web.entity.Students;
import com.example.javaspring_web.repository.IClassRoomRepository;
import com.example.javaspring_web.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService{
    private final IStudentRepository studentRepository;

    @Autowired
    public StudentService(IStudentRepository studentRepository, IClassRoomRepository classRoomRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Students> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Students getStudentsById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void saveStudents(Students students) {
        studentRepository.save(students);
    }

    @Override
    public void updateStudents(Long id, Students students) {
        Students students1 = studentRepository.findById(id).orElse(null);
        if (students1 != null) {
            students1.setId(students.getId());
            students1.setName(students.getName());
            students1.setAge(students.getAge());
            studentRepository.save(students1);
        }
    }
    @Override
    public String deleteStudents(Long id) {
        studentRepository.deleteById(id);
        return "Student with id " + id + " has been deleted.";
    }

}
