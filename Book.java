public class Book {

    private String bookName;
    private int deadline = 30;
    private String condition;

    public Book(String book) {
        this.bookName = book;
    }


    public String getBookName() {
        return bookName;
    }
}
