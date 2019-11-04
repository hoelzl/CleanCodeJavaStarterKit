package WS_01_SRP.Example_Book.Problem;

public class Main {

    public static void main(String[] args) {

        System.out.println("\n====================\n");
        Book book = new Book("Clean SW Architecture",
                "A. Raed, M. Hoelzl", 260);

        book.print();
        book.save();
    }
}


