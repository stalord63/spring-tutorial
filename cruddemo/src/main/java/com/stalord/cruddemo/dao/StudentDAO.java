package com.stalord.cruddemo.dao;

import com.stalord.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

     void save(Student theStudent);
     Student findById(Integer id);
     List<Student> findall();

     List<Student> findlastname(String lastname);
     void update(Student theStudent);
     void delete(Integer id);
     int deleteall();
}
