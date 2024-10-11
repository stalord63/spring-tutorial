package com.restapi.restapi.listofstudents;


import com.restapi.restapi.Entity.student;
import com.restapi.restapi.errorhandling.StudentErrorResponse;
import com.restapi.restapi.errorhandling.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ListRestController {

 private List<student> thestudent;


 @PostConstruct
 void adddata(){
     thestudent=new ArrayList<>();
     thestudent.add(new student("aditya","singh"));
     thestudent.add(new student("sameer","bhaisare"));
     thestudent.add(new student("ehtesham","akhtar"));
 }


 @GetMapping("/students/{studentid}")
 public student getlistofstudents(@PathVariable int studentid) {


     if ((studentid >= thestudent.size()) || studentid < 0)
         throw new StudentNotFoundException("Student id not found- " + studentid);
     return thestudent.get(studentid);


 }





}
