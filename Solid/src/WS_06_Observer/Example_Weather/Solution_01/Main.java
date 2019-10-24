package WS_06_Observer.Example_Weather.Solution_01;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        WeatherDisplay weatherDisplay = new WeatherDisplay(weatherStation);

        Runnable runnable = ()-> {


            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                weatherStation.setTemperature(30);

                TimeUnit.MILLISECONDS.sleep(2000);
                weatherStation.setPressure(80);

                TimeUnit.MILLISECONDS.sleep(3000);
                weatherStation.setHumidity(40);

                TimeUnit.MILLISECONDS.sleep(3000);
                weatherStation.setTemperature(27);

                TimeUnit.MILLISECONDS.sleep(2000);
                weatherStation.setPressure(60);

                TimeUnit.MILLISECONDS.sleep(1000);
                weatherStation.setHumidity(55);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };

        Thread thread = new Thread(runnable);
        thread.start();



    }
}
