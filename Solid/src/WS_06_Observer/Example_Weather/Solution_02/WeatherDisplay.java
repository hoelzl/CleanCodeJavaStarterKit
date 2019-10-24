package WS_06_Observer.Example_Weather.Solution_02;

public class WeatherDisplay implements Observer {

    WeatherStation subject;


    public WeatherDisplay(WeatherStation subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update(Subject subject) {
        if(this.subject == subject)
            show();
    }

    public void show() {
        int pressure = subject.getPressure();
        int temperature = subject.getTemperature();
        int humidity = subject.getHumidity();

        System.out.println("====================================\n");
        System.out.println("Display has received new weather data..");
        System.out.println("Temperature: " + temperature);
        System.out.println("Pressure: " + pressure);
        System.out.println("humidity: " + humidity);


    }
}
