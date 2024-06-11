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
    public Optional<Student> getSingleStudent(String studentId) {
        return Optional.ofNullable(entityManager.find(Student.class,studentId));
    }

    @Override
    public List<Student> getAllStudent() {
        TypedQuery<Student> getAll = entityManager.createQuery("SELECT s FROM Student s", Student.class);
        return getAll.getResultList();
    }


    @Override
    @Transactional
    public int updateStudent(Student student, String firstName, String lastName) {
        int studentId = student.getId();
//        TypedQuery<Student> studentData = entityManager.createQuery("FROM Student s where s.id= :stdId", Student.class);
//        studentData.setParameter("stdId" , studentId);
//        Student singleStudent = studentData.getSingleResult();


        return entityManager.createQuery("UPDATE Student SET firstName= 'JAPAN', lastName= 'China' WHERE id= 1").executeUpdate();
//        query.setParameter("firstName" , firstName);
//        query.setParameter("lastName" , lastName);
//        query.setParameter("id" , studentId);
////        Student singleResult = studentData.getSingleResult();
////        save(singleResult);
//        return query.executeUpdate();
    }

    @Override
    public int deleteStudent() {
        return 0;
    }
}
