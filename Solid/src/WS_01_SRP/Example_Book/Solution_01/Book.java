package WS_01_SRP.Example_Book.Solution_01;

public class Book {

    private String title;
    private String author;
    private int pages;
    private BookDAO bookDAO;
    private BookPrinter bookPrinter;

    public Book(String title, String author,
                int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public void print(){
        if(bookPrinter != null)
            bookPrinter.print(this);
    }

    public void save(){
        if(bookDAO != null)
            bookDAO.save(this);
    }

    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public void setBookPrinter(BookPrinter bookPrinter) {
        this.bookPrinter = bookPrinter;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                '}';
    }
}


