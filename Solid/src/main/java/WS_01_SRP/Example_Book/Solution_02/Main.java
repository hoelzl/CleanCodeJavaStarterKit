package WS_01_SRP.Example_Book.Solution_02;

public class Main {

    public static void main(String[] args) {

        System.out.println("\n====================\n");
        Book book = new Book("Clean SW Architecture",
                "A. Raed, M. Hoelzl", 260);

        BookDAO sqlBookDAO = new SQLBookDAO(book);
        sqlBookDAO.save();

        BookPrinter colorBookPrinter = new ColorBookPrinter(book);
        colorBookPrinter.print();
    }
}
