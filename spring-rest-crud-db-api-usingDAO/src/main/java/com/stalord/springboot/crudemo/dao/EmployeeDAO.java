package com.stalord.springboot.crudemo.dao;

import com.stalord.springboot.crudemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

 List<Employee>  findall();
 Employee findbyid(int id);
 Employee save(Employee theemployee);
 void delete (int id);

}
