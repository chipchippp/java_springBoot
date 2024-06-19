package com.example.javaspring_web.controllers;

import com.example.javaspring_web.entity.ClassRoom;
import com.example.javaspring_web.services.ClassRoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classroom")
public class ClassRoomController{
       private final ClassRoomService classRoomService;
    public ClassRoomController(ClassRoomService classRoomDAO) {
        this.classRoomService = classRoomDAO;
    }
    @GetMapping
    public List<ClassRoom> getAllClassRooms() {
        return classRoomService.getAllClassRoom();
    }
    @GetMapping("/{id}")
    public ClassRoom getClassRoomById(@PathVariable Long id) {
        return classRoomService.getClassRoomById(id);
    }

    @PostMapping
    public void addClassRoom(@RequestBody ClassRoom classRoom){
        classRoomService.saveClassRoom(classRoom);
    }

    @PutMapping("/{id}")
    public void updateClassRoom(@PathVariable Long id, @RequestBody ClassRoom classRoom){
        ClassRoom existingClassRoom = classRoomService.getClassRoomById(id);
        if (existingClassRoom != null) {
            existingClassRoom.setName(classRoom.getName());
            existingClassRoom.setNumberRoom(classRoom.getNumberRoom());
            classRoomService.updateClassRoom(existingClassRoom);
        } else {
            throw new RuntimeException("ClassRoom with id " + id + " not found");
        }
    }

    @DeleteMapping("/{id}")
    public void deleteClassRoom(@PathVariable Long id){
        classRoomService.deleteClassRoom(id);
    }
}
