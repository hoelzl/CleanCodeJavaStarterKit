package WS_01_SRP.Example_Book.Solution_01;

public class ColorBookPrinter implements BookPrinter {

    @Override
    public void print(Book book) {
        System.out.println("Sending " + book +
                " to the color printer..");
    }
}
