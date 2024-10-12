package com.stalord.springboot.crudemo.service;

import com.stalord.springboot.crudemo.dao.EmployeeRepository;
import com.stalord.springboot.crudemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeServiceImpl implements EmployeeService{


    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theemployeerepository) {
        employeeRepository = theemployeerepository;
    }

    @Override
    public List<Employee> findall() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findbyId(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee emp=null;
        if(result.isPresent()){
           emp = result.get();
        }
        else {
            throw  new RuntimeException("Employee not found "+ id);
        }
        return emp;
    }


    @Override
    public Employee save(Employee theemployee) {
        return employeeRepository.save(theemployee);
    }


    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }


}
