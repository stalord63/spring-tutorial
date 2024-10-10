package com.stalord.cruddemo.dao;

import com.stalord.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class StudentDAOImpl implements  StudentDAO{



    private EntityManager entityManager;



    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);

    }

    @Override
    public Student findById(Integer id){
      return  entityManager.find(Student.class,id);

    }

    @Override
    public List<Student> findall() {
        TypedQuery<Student> thequery=entityManager.createQuery("FROM Student order by lastName",Student.class);
        return thequery.getResultList();
    }

    @Override
    public List<Student> findlastname(String lastname) {
        TypedQuery<Student> thequery=entityManager.createQuery("FROM Student where lastName=:thelastname", Student.class);
        thequery.setParameter("thelastname",lastname);
        return thequery.getResultList();

    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student st=entityManager.find(Student.class,id);
        entityManager.remove(st);


    }

    @Override
    @Transactional
    public int deleteall() {
      int numrows=entityManager.createQuery("DELETE FROM Student").executeUpdate();
        System.out.println(numrows+" rows deleted");
        return numrows;

    }

}
