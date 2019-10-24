package WS_03_LSP;

public class Main {

    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(10);
        rectangle.setWidth(5);
        System.out.println(rectangle.area()); // Liefert 50.

        rectangle = new Square();
        rectangle.setHeight(10);
        rectangle.setWidth(5);
        System.out.println(rectangle.area()); // Liefert 25
    }
}
