package com.stalord.springboot.crudemo.service;

import com.stalord.springboot.crudemo.dao.EmployeeDAO;
import com.stalord.springboot.crudemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{


    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theemployeeDAO) {
        employeeDAO = theemployeeDAO;
    }

    @Override
    public List<Employee> findall() {
        return employeeDAO.findall();
    }

    @Override
    public Employee findbyid(int id) {
        return employeeDAO.findbyid(id);
    }

    @Transactional
    @Override
    public Employee save(Employee theemployee) {
        return employeeDAO.save(theemployee);
    }

    @Transactional
    @Override
    public void delete(int id) {
        employeeDAO.delete(id);
    }


}
