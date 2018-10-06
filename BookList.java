import java.util.ArrayList;

public class BookList {

    private ArrayList<Book> allBooks = new ArrayList<Book>();
    ;
    private int bookCount = 0;


    void addBook(Book book) {

        allBooks.add(bookCount, book);
        System.out.println("The book named: " + book.getBookName() + " was added");
        bookCount++;

    }

    //removes book from the rental list and returns the book for use in the addBook function in the User class
    Book rentBook(Book book, User user) {
        int index = allBooks.indexOf(book);
        Book rental = allBooks.remove(index);
        book.setCurrentOwner(user);
        //user.addBook(book);
        bookCount--;
        System.out.println("The book named: " + book.getBookName() + " was rented by: " + user.getName());
        return rental;
    }


    public int getBookCount() {
        System.out.println("Number of books in list is " + bookCount);
        return bookCount;
    }

    public void getAllBooks() {
        //loop through books and display information
        for (int i = 0; i < allBooks.size(); i++) {
            System.out.println("Book " + (i + 1) + " is: " + allBooks.get(i).getBookName());
        }
    }

    //LEVEL 5: Create a search service, allowing users to filter available books by name, author, or year.
    public void searchByName(String str) {
        for (int i = 0; i < bookCount; i++) {
            if (str.equals(allBooks.get(i).getBookName())) {
                System.out.println("Book: " + i);
                allBooks.get(i).bookInfo();
            }
        }
    }

    //Not writing tests for these functions because I don't want to look up and add the data for them.
    public void searchByAuthor(String str) {
        for (int i = 0; i < bookCount; i++) {
            if (str.equals(allBooks.get(i).getAuthor())) {
                System.out.println("Book: " + i);
                allBooks.get(i).bookInfo();
            }
        }
    }

    public void searchByYear(String str) {
        for (int i = 0; i < bookCount; i++) {
            if (str.equals(allBooks.get(i).getYear())) {
                System.out.println("Book: " + i);
                allBooks.get(i).bookInfo();
            }
        }
    }

    //display top books
    public void topBooks(int num) {

        if (!(num > bookCount) && (num > 0)) {

            //declare new array to hold sorted items
            Book[] arr = new Book[bookCount];
            //initialize array with items in bookList
            arr = allBooks.toArray(arr);
            //sort the Array
            arr = bubbleSort(arr);

            //variable to count down from lowest rank
            int count = bookCount - 1;
            //looping over sorted array and displaying results
            for (int i = 0; i < num; i++) {
                System.out.println("Rank " + (count) + " is " + arr[count].getBookName() + " with a score of " + arr[count].getRank());
                count--;

            }
        }
        else{
            System.out.println("Number out of bounds");
        }
    }

    //sort function
    public Book[] bubbleSort(Book[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (arr[j].getRank() > arr[j + 1].getRank()) {
                    Book temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
