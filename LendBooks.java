import java.util.Scanner;

public class LendBooks {

    public static void main(String[] args) {

        Scanner input  = new Scanner(System.in);

        System.out.print("Enter book: ");

        String book = input.nextLine();

        Book test = new Book(book);
        BookList list = new BookList();

        //books can be added to the rental list
        list.addBook(test);
        list.getAllBooks();
        //book count can be monitored
        System.out.println(list.getBookCount());

        //books can be rented from the list and assigned to another book, this will be used when users rent
        Book test2 = list.rentBook(test);
        System.out.println(test2.getBookName());
        //all the books in the current list can be shown at any time
        list.getAllBooks();
        System.out.println(list.getBookCount());

    }



}
