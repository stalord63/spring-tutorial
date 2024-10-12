package com.stalord.springboot.crudemo.rest;


import com.stalord.springboot.crudemo.entity.Employee;
import com.stalord.springboot.crudemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;


    @Autowired
    public EmployeeRestController(EmployeeService theemployeeService) {
        employeeService = theemployeeService;
    }







    @GetMapping("/employees")
    public List<Employee> find(){
       return employeeService.findall();
    }

    @GetMapping("/employees/{employeeid}")
    public Employee getemployee(@PathVariable int employeeid){
        Employee emp= employeeService.findbyId(employeeid);
        if (emp==null){
            throw new RuntimeException("Employee not found - "+employeeid);
        }
        else {
        return emp; }
    }


    @PostMapping("/employees")
    public Employee savetodb(@RequestBody Employee theemployee){

        theemployee.setId(0);
        Employee emp=employeeService.save(theemployee);
        return emp;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {

        Employee tempEmployee = employeeService.findbyId(employeeId);

        // throw exception if null

        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        employeeService.delete(employeeId);

        return "Deleted employee id - " + employeeId;
    }



}
