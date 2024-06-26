package com.example.javaspring_web.controllers;

import com.example.javaspring_web.entity.ClassRoom;
import com.example.javaspring_web.entity.Students;
import com.example.javaspring_web.services.ClassRoomService;
import com.example.javaspring_web.services.StudentService;
import jakarta.servlet.http.HttpServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/student")
public class StudentController extends HttpServlet {
    private final StudentService studentService;
    private final ClassRoomService classRoomService;

    @Autowired
    public StudentController(StudentService studentService, ClassRoomService classRoomService) {
        this.studentService = studentService;
        this.classRoomService = classRoomService;
    }

    @GetMapping()
    public String getStudent(Model model) {
        List<Students> students = studentService.getAllStudents();
        students = students.stream()
                .filter(student -> student.getClassRoom() != null)
                .collect(Collectors.toList());
        model.addAttribute("students", students);
        return "student/index";
    }

    @GetMapping("/{id}")
    public String getStudentById(@PathVariable Long id, Model model) {
        Students students = studentService.getStudentsById(id);
        model.addAttribute("students", students);
        return "student/index";
    }

    @GetMapping("/addStudent")
    public String addStudent(Model model) {
        List<ClassRoom> classRooms = classRoomService.getAllClassRoom();
        model.addAttribute("classRooms", classRooms);
        model.addAttribute("student", new Students());
        return "student/post";
    }

    @PostMapping("/addStudent")
    public String addStudent(@ModelAttribute Students students, @ModelAttribute ClassRoom classRooms) {
//        ClassRoom classRoom = classRoomService.getClassRoomById(students.getId());
//        List<ClassRoom> classRoom = classRoomService.getAllClassRoom();
        classRoomService.saveClassRoom(classRooms);
        students.setClassRoom(classRooms);
        studentService.saveStudents(students);
        return "redirect:/student";
    }

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        List<ClassRoom> classRooms = classRoomService.getAllClassRoom();
        Students students = studentService.getStudentsById(id);

        model.addAttribute("classRooms", classRooms);
        model.addAttribute("student", students);
        return "student/put";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable Long id,@ModelAttribute Students students) {
        studentService.updateStudents(id, students);
        return "redirect:/student";
    }

    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudents(id);
        return "redirect:/student";
    }
}
