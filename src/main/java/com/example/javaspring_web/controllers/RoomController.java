package com.example.javaspring_web.controllers;

import com.example.javaspring_web.entity.ClassRoom;
import com.example.javaspring_web.services.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/room")
public class RoomController {
    private final ClassRoomService classRoomService;

    @Autowired
    public RoomController(ClassRoomService classRoomService) {
        this.classRoomService = classRoomService;
    }

    @GetMapping
    public String getRoom(Model model) {
        List<ClassRoom> classRooms = classRoomService.getAllClassRoom();
        model.addAttribute("classRooms", classRooms);
        return "classroom/index";
    }
    @PostMapping("/addRoom")
    public String addRoom() {
        classRoomService.saveClassRoom(new ClassRoom());
        return "classroom/post";
    }
    @PutMapping("/edit/{id}")
    public String editRoom() {
        classRoomService.updateClassRoom(new ClassRoom());
        return "/classroom/put";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteRoom() {
        classRoomService.deleteClassRoom(1L);
        return "/classroom/delete";
    }

}