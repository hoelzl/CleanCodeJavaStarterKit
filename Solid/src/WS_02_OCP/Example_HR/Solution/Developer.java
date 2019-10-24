package WS_02_OCP.Example_HR.Solution;

public class Developer extends Employee {

    public Developer(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void perform() {
        writeCode();
        testCode();
    }

    public void writeCode(){

        System.out.println("Writing code...");
    }

    public void testCode(){

        System.out.println("Testing code...");
    }
}
