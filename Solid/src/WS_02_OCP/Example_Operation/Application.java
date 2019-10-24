package WS_02_OCP.Example_Operation;

public class Application {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        calculator.setOperation(new Addition());
        int result = calculator.calculate(10, 5);
        System.out.println("calculator with Addition: " + result); // 15

        calculator.setOperation(new Mulitplication());
        result = calculator.calculate(10, 5);
        System.out.println("calculator with Addition: " + result); // 50
    }
}



