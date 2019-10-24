package WS_06_Observer.Example_Weather.Solution_01;

public class WeatherDisplay implements Observer {

    private Subject subject;

    private int temperature;
    private int pressure;
    private int humidity;

    public WeatherDisplay(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update(int temperature, int pressure, int humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        show();
    }

    public void show(){
        System.out.println("====================================\n");
        System.out.println("Display has received new weather data..");
        System.out.println("Temperature: " + temperature);
        System.out.println("Pressure: " + pressure);
        System.out.println("humidity: " + humidity);

    }
}
