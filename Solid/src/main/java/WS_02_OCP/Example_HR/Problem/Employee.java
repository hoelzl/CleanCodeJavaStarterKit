package WS_02_OCP.Example_HR.Problem;

public class Employee {

    private String name;
    private double salary;

    public Employee(String name,  double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}










