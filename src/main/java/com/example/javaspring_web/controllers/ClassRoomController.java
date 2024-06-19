package com.example.javaspring_web.controllers;

import com.example.javaspring_web.dao.ClassRoomDAO;
import com.example.javaspring_web.entity.ClassRoom;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classroom")
public class ClassRoomController{
    private final ClassRoomDAO classRoomDAO;

    public ClassRoomController(ClassRoomDAO classRoomDAO) {
        this.classRoomDAO = classRoomDAO;
    }
    @GetMapping
    public List<ClassRoom> getAllClassRooms() {
        return classRoomDAO.getAllClassRoom();
    }
    @GetMapping("/{id}")
    public ClassRoom getClassRoomById(@PathVariable Long id) {
        return classRoomDAO.getClassRoomById(id);
    }

    @PostMapping
    public void addClassRoom(@RequestBody ClassRoom classRoom){
        classRoomDAO.saveClassRoom(classRoom);
    }

    @PutMapping("/{id}")
    public void updateClassRoom(@PathVariable Long id, @RequestBody ClassRoom classRoom){
        ClassRoom existingClassRoom = classRoomDAO.getClassRoomById(id);
        if (existingClassRoom != null) {
            existingClassRoom.setName(classRoom.getName());
            existingClassRoom.setNumberRoom(classRoom.getNumberRoom());
            classRoomDAO.updateClassRoom(existingClassRoom);
        } else {
            throw new RuntimeException("ClassRoom with id " + id + " not found");
        }
    }

    @DeleteMapping("/{id}")
    public void deleteClassRoom(@PathVariable Long id){
        classRoomDAO.deleteClassRoom(id);
    }
}
