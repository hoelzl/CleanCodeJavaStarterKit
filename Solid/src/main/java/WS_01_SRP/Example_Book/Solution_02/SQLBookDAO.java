package WS_01_SRP.Example_Book.Solution_02;

public class SQLBookDAO implements BookDAO {

    private Book book;

    public SQLBookDAO(Book book) {
        this.book = book;
    }

    @Override
    public void save() {
        System.out.println("Saving " + book + " to database");
    }
}
