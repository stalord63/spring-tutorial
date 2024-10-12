package com.stalord.springboot.crudemo.service;

import com.stalord.springboot.crudemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findall() ;
    Employee findbyid(int id);
    Employee save(Employee theemployee);
    void delete (int id);


}
