package com.example.javaspring_web.services;

import com.example.javaspring_web.entity.ClassRoom;
import com.example.javaspring_web.repository.IClassRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassRoomService implements IClassRoomService{
    private final IClassRoomRepository classRoomRepository;

    @Autowired
    public ClassRoomService(IClassRoomRepository classRoomRepository) {
        this.classRoomRepository = classRoomRepository;
    }

    @Override
    public List<ClassRoom> getAllClassRoom() {
        return classRoomRepository.findAll();
    }

    @Override
    public ClassRoom getClassRoomById(Long id) {
        return classRoomRepository.findById(id).orElse(null);
    }

    @Override
    public void saveClassRoom(ClassRoom classRoom) {
        classRoomRepository.save(classRoom);
    }

    @Override
    public void updateClassRoom(ClassRoom classRoom) {
    }

    @Override
    public void deleteClassRoom(Long id) {
        classRoomRepository.deleteById(id);
    }
}
