package com.example.javaspring_web.entity.seeder;

import com.example.javaspring_web.entity.ClassRoom;
import com.example.javaspring_web.entity.Students;
import com.example.javaspring_web.repository.IClassRoomRepository;
import com.example.javaspring_web.repository.IStudentRepository;
import com.github.javafaker.Faker;

public class StudentSeeder {
    IStudentRepository studentRepository;
    IClassRoomRepository classRoomRepository;

    Faker faker = new Faker();

    public StudentSeeder(IStudentRepository studentRepository, IClassRoomRepository classRoomRepository) {
        this.studentRepository = studentRepository;
        this.classRoomRepository = classRoomRepository;
    }

    public void run(String... args) throws Exception {
        createStudents();
    }

    private void createStudents() {
        for (int i = 0; i < 10; i++) {
            Students student = new Students();
            student.setName(faker.name().firstName());
            student.setAge(faker.number().numberBetween(1, 100));

            // Generate or fetch a ClassRoom entity and set it to the student
            ClassRoom classRoom = new ClassRoom();
            classRoom.setName(faker.name().firstName()); // Example name using faker
            classRoom.setNumberRoom(faker.number().numberBetween(1, 100)); // Example numberRoom using faker
            student.setClassRoom(classRoom);
            studentRepository.save(student);
            classRoomRepository.save(classRoom);
        }
    }
}
