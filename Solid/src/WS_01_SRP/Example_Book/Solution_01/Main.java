package WS_01_SRP.Example_Book.Solution_01;

public class Main {

    public static void main(String[] args) {

        System.out.println("\n====================\n");
        Book book = new Book("Clean SW Architecture",
                "A. Raed, M. Hoelzl", 260);

        BookDAO bookDAO = new SQLBookDAO();
        book.setBookDAO(bookDAO);
        book.save();

        BookPrinter bookPrinter = new ColorBookPrinter();
        book.setBookPrinter(bookPrinter);
        book.print();
    }
}
