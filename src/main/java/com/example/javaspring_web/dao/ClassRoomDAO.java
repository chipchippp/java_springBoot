package com.example.javaspring_web.dao;

import com.example.javaspring_web.entity.ClassRoom;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClassRoomDAO implements IClassRoomDAO{
    private final EntityManager entityManager;

    @Autowired
    public ClassRoomDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
//    @Transactional
    public List<ClassRoom> getAllClassRoom() {
        return this.entityManager.createQuery("from ClassRoom", ClassRoom.class).getResultList();
    }
    @Override
//    @Transactional
    public ClassRoom getClassRoomById(Long id) {
        return this.entityManager.find(ClassRoom.class, id);
    }

    @Override
    @Transactional
    public void saveClassRoom(ClassRoom classRoom) {
//        entityManager.getTransaction().begin();
//        entityManager.persist(classRoom);
//        entityManager.getTransaction().commit();
//        entityManager.close();
        this.entityManager.persist(classRoom);
    }

    @Override
    @Transactional
    public void updateClassRoom(ClassRoom classRoom) {
        this.entityManager.merge(classRoom);
    }

    @Override
    @Transactional
    public void deleteClassRoom(Long id) {
        ClassRoom classRoom = this.entityManager.find(ClassRoom.class, id);
        this.entityManager.remove(classRoom);
    }
}
