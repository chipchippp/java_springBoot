package com.example.javaspring_web.entity.seeder;
import com.example.javaspring_web.entity.ClassRoom;
import com.example.javaspring_web.repository.IClassRoomRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ClassRoomSeeder implements CommandLineRunner {
    IClassRoomRepository classRoomRepository;
    Faker faker = new Faker();

    public ClassRoomSeeder(IClassRoomRepository classRoomRepository) {
        this.classRoomRepository = classRoomRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        createUsers();
    }

    private void createUsers() {
        for (int i = 0; i < 10; i++) {
            ClassRoom classRoom = new ClassRoom();
            classRoom.setName(faker.name().firstName());
            classRoom.setNumberRoom(faker.number().numberBetween(1, 100));
            classRoomRepository.save(classRoom);
        }
    }
}
