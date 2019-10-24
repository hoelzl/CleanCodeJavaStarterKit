package WS_06_Observer.Example_Weather.Solution_01;

public interface Subject {

    public void attach(Observer observer);
    public void detach(Observer observer);
    public void notifyAttachedObservers();
}
