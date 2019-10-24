package WS_06_Observer.Example_Weather.Solution_02;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject {

    private int temperature;
    private int pressure;
    private int humidity;

    List<Observer> observers;

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
            observer.update(this);
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

    public int getTemperature() {
        return temperature;
    }

    public int getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }
}
