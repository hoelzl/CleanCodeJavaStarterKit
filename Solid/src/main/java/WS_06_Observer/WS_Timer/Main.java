package WS_06_Observer.WS_Timer;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {



    ClockTimer clockTimer = new ClockTimer();
    AnalogClock analogClock = new AnalogClock(clockTimer);

    Runnable runnable = () -> {

        try {

            for (int i = 0; i < 31; i++) {
                TimeUnit.MILLISECONDS.sleep(2000);
                clockTimer.tick();
                System.out.println(clockTimer);
                System.out.println("========================\n");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };

    Thread thread = new Thread(runnable);
    thread.start();

    }
}