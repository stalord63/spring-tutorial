package com.stalord.springboot.crudemo.service;

import com.stalord.springboot.crudemo.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> findall() ;
    Employee findbyId(int id);
    Employee save(Employee theemployee);
    void delete (int id);


}
