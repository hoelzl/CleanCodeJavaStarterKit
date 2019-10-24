package WS_02_OCP.WS_Employee.Problem;

public class Main {

    public static void main(String[] args) {

        Employee alex = new Employee(152, "Alex", 60000.00);
        Employee lena = new Employee(983, "Lena", 28);
        Employee julia = new Employee(378, "Julia");
        Project project = new Project("BMW", 30000.00);

        alex.setOvertime(7);
        lena.setOvertime(83);
        julia.setProject(project);

        System.out.println();

        double result = alex.calculatePay(EmployeeType.REGULAR);
        System.out.println("Alex Payment this month is: " + result);

        result = lena.calculatePay(EmployeeType.HOURED);
        System.out.println("Lena Payment this month is: " + result);

        result = julia.calculatePay(EmployeeType.COMMISSIONED);
        System.out.println("Julia Payment this month is: " + result);


    }
}
