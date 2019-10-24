package WS_02_OCP.WS_Employee.Problem;

public class Employee {

    private int id;
    private String name;
    private double salary;
    private int overtime;
    private Project project;


    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee(int id, String name, int overtime) {
        this.id = id;
        this.name = name;
        this.overtime = overtime;
    }


    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }


    public double calculatePay(EmployeeType employeeType){
        switch(employeeType){
            case REGULAR: return salary / 12 + overtime * 50;
            case HOURED : return overtime * 90 ;
            case COMMISSIONED: return project.getAsset() * 0.18;
            default : throw new IllegalArgumentException("Unknown Employee Type!");
        }
    }

    
    public String reportHours(EmployeeType employeeType) {
        switch (employeeType) {
            case REGULAR:
                return "Employee " + this + " has " + calculateRegularHours() + overtime + " hours per Week";
            case HOURED:
                return "Freelancer " + this + " has " + overtime + " hours per Week";
            case COMMISSIONED:
                return "Commissioned, Working hours are not relevant!";
            default:
                throw new IllegalArgumentException("Unknown Employee Type!");
        }
    }


    public void printReport(){
        System.out.println("Printing the Employee " + this);
    }


    public void saveEmployee(){
        System.out.println("Saving Employee to database...");
    }


    private double calculateRegularHours(){
        return 40.5;
    }




    public void setOvertime(int overtime) {
        this.overtime = overtime;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
