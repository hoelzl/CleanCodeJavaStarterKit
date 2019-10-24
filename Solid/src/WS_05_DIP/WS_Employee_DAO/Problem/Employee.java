package WS_05_DIP.WS_Employee_DAO.Problem;

public class Employee {

    private int id;
    private String name;
    private double salary;

    public void create(){
        System.out.println("adding " + this + " to database");
    }

    public Employee retrieve(int id){
        return null;
    }

    public void update(){
        System.out.println("updating " + this);
    }

    public void delete(int id){
        System.out.println("deleting Employee with id: " + id);
    }
}
