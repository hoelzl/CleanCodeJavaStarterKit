package WS_03_LSP;

public class Rectangle {

    private double height;
    private double width;


    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }


    public double area(){
        return height * width;
    }
}
