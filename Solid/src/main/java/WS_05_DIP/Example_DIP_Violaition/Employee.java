package WS_05_DIP.Example_DIP_Violaition;

public class Employee {

    private String name;
    private double salary;
    private SQLEmployee sqlEmployee;

    public void create(){
        sqlEmployee.create(this);
    }
}




