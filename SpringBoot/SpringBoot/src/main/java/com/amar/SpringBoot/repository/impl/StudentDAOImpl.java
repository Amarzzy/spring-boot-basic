package com.amar.SpringBoot.repository.impl;

import com.amar.SpringBoot.entity.Student;
import com.amar.SpringBoot.repository.StudentDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 *
 */
@Repository
@Transactional
public class StudentDAOImpl implements StudentDAO {

    private final EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Optional<Student> getSingleStudent(int studentId) {
        return Optional.ofNullable(entityManager.find(Student.class,studentId));
    }

    @Override
    public List<Student> getAllStudent() {
        TypedQuery<Student> getAll = entityManager.createQuery("from Student", Student.class);
        return getAll.getResultList();
    }


    @Override
    @Transactional
    public Student updateStudent(Student student) {
        Student updatedStudent = entityManager.merge(student);
        return updatedStudent;
    }

    @Override
    public void deleteStudent(Student student) {
        entityManager.remove(student);
    }
}
