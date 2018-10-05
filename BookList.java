import java.util.ArrayList;

public class BookList {

    private ArrayList<Book> allBooks = new ArrayList<Book>();;
    private int bookCount = 0;


    void addBook(Book book){

        allBooks.add(bookCount,book);
        System.out.println("The book named: " + book.getBookName() + " was added");
        bookCount++;

    }

    Book rentBook(Book book){
         int index = allBooks.indexOf(book);
         Book rental  = allBooks.remove(index);
         bookCount--;
        System.out.println("The book named: " + book.getBookName() + " was rented");
        return rental;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void getAllBooks() {
        String results ="";
        for(int i = 0; i < allBooks.size(); i++){
            System.out.println("Book " + (i+1) + " is: " + allBooks.get(i).getBookName());
            //results += " "  + allBooks.get(i);
        }
        //System.out.println(results);
    }
}
