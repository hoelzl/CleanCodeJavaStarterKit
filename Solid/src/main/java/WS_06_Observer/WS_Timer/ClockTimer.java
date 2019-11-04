package WS_06_Observer.WS_Timer;



import java.util.ArrayList;
import java.util.List;

public class ClockTimer  {

    private int hour;
    private int minute;
    private int second;


    public ClockTimer(){

    }


    public void tick(){

        second += 2;

        if(second >= 60){
            minute++;
            second = 60 - second;
        }


        if(minute >= 60){
            hour++;
            minute = 60 - minute;
        }


    }


    public void internalCall(){
      for(int i=0; i>1000; i++)
          tick();

    }


    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "Subject: ClockTimer{ " + hour + " : " + minute + " : " + second + " }";

    }


}
