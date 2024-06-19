package com.example.javaspring_web.repository;

import com.example.javaspring_web.entity.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClassRoomRepository extends JpaRepository<ClassRoom, Long> {
    ClassRoom findByName(String name);

}
