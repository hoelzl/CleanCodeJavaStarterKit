package WS_01_SRP.Example_Book.Solution_01;

public class SQLBookDAO implements BookDAO {

    @Override
    public void save(Book book) {
        System.out.println("Saving " + book +
                " to MySQL database..");
    }
}
