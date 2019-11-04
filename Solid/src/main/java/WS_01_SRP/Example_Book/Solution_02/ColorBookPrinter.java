package WS_01_SRP.Example_Book.Solution_02;

public class ColorBookPrinter implements BookPrinter {

    private Book book;

    public ColorBookPrinter(Book book) {
        this.book = book;
    }

    @Override
    public void print() {
        System.out.println("Sending " + book +
                " to the color printern..");
    }
}
