package com.stalord.springboot.crudemo.dao;


import com.stalord.springboot.crudemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements  EmployeeDAO {

private EntityManager entityManager;

@Autowired
public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findall() {
        TypedQuery<Employee> theQuery=entityManager.createQuery("from Employee", Employee.class);
        List<Employee> employees=theQuery.getResultList();
        return employees;
    }

    @Override
    public Employee findbyid(int id) {
        Employee theemp=entityManager.find(Employee.class,id);
        return  theemp;


    }

    @Override
    public Employee save(Employee theemployee) {
        Employee emp=entityManager.merge(theemployee);
        return emp;
    }

    @Override
    public void delete(int id) {
    Employee emp=entityManager.find(Employee.class,id);
    entityManager.remove(emp);

    }
}
