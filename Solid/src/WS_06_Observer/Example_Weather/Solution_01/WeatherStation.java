package WS_06_Observer.Example_Weather.Solution_01;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject{

    private int temperature;
    private int pressure;
    private int humidity;

    private List<Observer> observers;

    public WeatherStation(){
        observers = new ArrayList<>();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        if(observers.indexOf(observer) >= 0)
            observers.remove(observer);
    }

    @Override
    public void notifyAttachedObservers() {
        for(Observer observer : observers)
            observer.update(temperature, pressure, humidity);
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyAttachedObservers();
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
        notifyAttachedObservers();
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
        notifyAttachedObservers();
    }
}
