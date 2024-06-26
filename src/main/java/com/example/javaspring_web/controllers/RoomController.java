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

    // Method to get all rooms
    @GetMapping
    public String getRoom(Model model) {
        List<ClassRoom> classRooms = classRoomService.getAllClassRoom();
        model.addAttribute("classRooms", classRooms);
        return "classroom/index";
    }

//    @GetMapping("/{id}")
//    public String getRoomById(@PathVariable Long id, Model model) {
//        ClassRoom classRoom = classRoomService.getClassRoomById(id);
//        model.addAttribute("classRoom", classRoom);
//        return "classroom/index";
//    }

    @GetMapping("/addRoom")
    public String addRoom(Model model) {
        model.addAttribute("classRoom", new ClassRoom());
        return "classroom/post";
    }

    @PostMapping("/addRoom")
    public String addRoom(@ModelAttribute ClassRoom classRoom) {
        classRoomService.saveClassRoom(classRoom);
        return "redirect:/room";
    }

    @GetMapping("/edit/{id}")
    public String editRoom(@PathVariable("id") Long id, Model model) {
        ClassRoom classRoom = classRoomService.getClassRoomById(id);
        model.addAttribute("classRoom", classRoom);
        return "classroom/put";
    }

    @PostMapping("/update/{id}")
    public String updateRoom(@PathVariable("id") Long id, @ModelAttribute ClassRoom classRoom) {
        classRoomService.updateClassRoom(id, classRoom);
        return "redirect:/room";
    }

    @PostMapping("/delete/{id}")
    public String deleteRoom(@RequestParam("id") Long id) {
        classRoomService.deleteClassRoom(id);
        return "redirect:/room";
    }
}
