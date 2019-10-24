package WS_02_OCP.Example_Operation;

public class Calculator {

    private Operation operation;

    public int calculate(int x, int y){
        return operation.execute(x, y);
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}




