package com.example.javaspring_web.services;

import com.example.javaspring_web.entity.ClassRoom;

import java.util.List;

public interface IClassRoomService {
    public List<ClassRoom> getAllClassRoom();
    public ClassRoom getClassRoomById(Long id);
    public void saveClassRoom(ClassRoom classRoom);
    public void updateClassRoom(Long id,ClassRoom classRoom);
    public String deleteClassRoom(Long id);

}
