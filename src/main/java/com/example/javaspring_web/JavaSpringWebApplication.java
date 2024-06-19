package com.example.javaspring_web;

import com.example.javaspring_web.entity.ClassRoom;
import com.example.javaspring_web.services.ClassRoomService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaSpringWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaSpringWebApplication.class, args);
//        System.out.println("Hello World!");
    }
    @Bean
    public CommandLineRunner commandLineRunner(ClassRoomService classRoomService) {
        return args -> {
            getClassById(classRoomService);
            addNewClass(classRoomService);
            updateClass(classRoomService);
            deleteClass(classRoomService);
        };
    }
//    @Bean
//    public CommandLineRunner seedData(ClassRoomDAO classRoomDAO) {
//        return args -> {
//            // Check if database is empty
//            if (classRoomDAO.getAllClassRoom().isEmpty()) {
//                // Seed data
//                classRoomDAO.saveClassRoom(new ClassRoom("Class A", 1));
//                classRoomDAO.saveClassRoom(new ClassRoom("Class B", 2));
//                classRoomDAO.saveClassRoom(new ClassRoom("Class C", 3));
//            }
//        };
//    }
    private static void addNewClass(ClassRoomService classRoomDAO) {
        ClassRoom classRoom = new ClassRoom();
        classRoom.setName("A");
        classRoom.setNumberRoom(1);
        classRoomDAO.saveClassRoom(classRoom);
    }

    private static void getClassById(ClassRoomService classRoomDAO) {
        ClassRoom classRoom = classRoomDAO.getClassRoomById(1L);
        for (ClassRoom c : classRoomDAO.getAllClassRoom()) {
            System.out.println(c.toString());
        }
    }
    private static void updateClass(ClassRoomService classRoomDAO) {
        ClassRoom classRoom = classRoomDAO.getClassRoomById(1L);
        classRoom.setName("B");
        classRoomDAO.updateClassRoom(classRoom);
    }
    private static void deleteClass(ClassRoomService classRoomDAO) {
        classRoomDAO.deleteClassRoom(1L);
    }

} 
