package WS_02_OCP.Example_HR.Solution;

public class App {

    public static void main(String[] args) {

        Employee lara = new Developer("Lara",55000);
        Employee elke = new Secretary("Elke", 40000);

        HumanRessourceManagement manager = new HumanRessourceManagement();
        manager.callUpon(lara);
        manager.callUpon(elke);
    }
}
