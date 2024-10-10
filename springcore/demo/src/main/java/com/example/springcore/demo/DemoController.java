package com.example.springcore.demo;

import demo1.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {



    private Coach myCoach;


    @Autowired
    public  void DemoController(@Qualifier("cricketCoach") Coach thecoach){
        myCoach= thecoach;
    }

    @GetMapping("/daily")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}




