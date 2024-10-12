package com.stalord.springboot.crudemo.dao;

import com.stalord.springboot.crudemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    //dats it no need it to write anything

}
