package WS_01_SRP.Example_Book.Problem;

public class Book {

    private String title;
    private String author;
    private int pages;

    public Book(String title, String author,
                int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public void print(){

        System.out.println("Printing " + this);
    }

    public void save(){

        System.out.println("Saving " + this + " to database");
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


