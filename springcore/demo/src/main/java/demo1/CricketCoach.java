package demo1;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class CricketCoach implements Coach {
   public CricketCoach(){
       System.out.println("cricket se aa rha");
   }

    @Override
    public String getDailyWorkout() {

        return "Practice bowling for 15 minutes";
    }
}
