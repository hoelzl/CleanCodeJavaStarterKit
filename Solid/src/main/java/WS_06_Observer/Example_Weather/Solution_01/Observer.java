package WS_06_Observer.Example_Weather.Solution_01;

public interface Observer {

    public void update(int temperature, int pressure, int humidity);
}
