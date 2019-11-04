package WS_02_OCP.WS_Employee.Problem;

public class Project {

    private String name;
    private double asset;

    public Project(String name, double asset) {
        this.name = name;
        this.asset = asset;
    }

    public double getAsset() {
        return asset;
    }
}
