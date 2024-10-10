package demo1;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class HockeyCoach  implements Coach{
public HockeyCoach(){
    System.out.println("hockey se aa rha");
}
    public String getDailyWorkout(){

        return "chak de";
    }
}
