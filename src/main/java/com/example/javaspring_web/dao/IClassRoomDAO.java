package com.example.javaspring_web.dao;

import com.example.javaspring_web.entity.ClassRoom;

import java.util.List;

public interface IClassRoomDAO{
    void saveClassRoom(ClassRoom classRoom);
    ClassRoom getClassRoomById(Long id);
    void updateClassRoom(ClassRoom classRoom);
    void deleteClassRoom(Long id);
    List<ClassRoom> getAllClassRoom();

}
