package WS_06_Observer.Example_Weather.Solution_02;

public interface Subject {

    public void attach(Observer observer);
    public void detach(Observer observer);
    public void notifyAttachedObservers();


}
