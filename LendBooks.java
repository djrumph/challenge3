import java.util.Scanner;

/*    LEVEL 1: Book owners must be able to register a list of shared books.
    LEVEL 2: Help users to keep track of who has each book, return deadlines, and past sharing history.
    LEVEL 3: The system will allow users to request any available book. They must return them within a 30-days period.
    LEVEL 5: Create a search service, allowing users to filter available books by name, author, or year.
    LEVEL 6: Provide a book ranking service, that returns the top N books based on their history. Each book score is calculated using their interactions with users. */

public class LendBooks {

    public static void main(String[] args) {

        Scanner input  = new Scanner(System.in);

//          user can create books
//        System.out.print("Enter book: ");
//        String book = input.nextLine();
//        Book test = new Book(book);


        //test making list of books
        //create books
        System.out.println("ADDING BOOKS TEST");
        Book tomSawyer = new Book("Tom Sawyer");
        Book countOfMonteCristo = new Book("Count of Monte Cristo");
        Book watershipDown = new Book ("Watership Down");
        Book theThreeMuskateers = new Book("The Three Muskateers");
        Book janeEyre = new Book ("Jane Eyre");
        Book harryPotter = new Book("Harry Potter");

        //add books to the lendingList
        System.out.println("ADDING BOOKS TO LIST TEST");
        BookList list = new BookList();
        list.addBook(tomSawyer);
        list.addBook(countOfMonteCristo);
        list.addBook(watershipDown);
        list.addBook(theThreeMuskateers);
        list.addBook(janeEyre);
        list.addBook(harryPotter);

        System.out.println();
        //check to see if books have been added to list and number of books in list
        System.out.println("VIEW BOOKS IN LIST TEST");
        list.getBookCount();
        list.getAllBooks();

        System.out.println();
        System.out.println("USER TEST AND RENT TEST");
        //create user
        User DJ = new User("DJ");

        //check to see if user can rent a book
        DJ.addBook(list.rentBook(tomSawyer,DJ));

        //check to see if the book has been removed from the list
        System.out.println();
        System.out.println("RENTED BOOK REMOVED FROM LIST TEST");
        list.getBookCount();
        list.getAllBooks();

        //check to see if book can be returned to list

        System.out.println();
        System.out.println("RETURN BOOK TEST");
        DJ.returnBook("Tom Sawyer", list);

        System.out.println();
        list.getAllBooks();

         //check to see if book has been removed from users books
        System.out.println();
        System.out.println("BOOK REMOVED FROM USER TEST");
        DJ.bookInfo();

        //check to see if the history remains if once the book has been returned
        System.out.println();
        System.out.println("HISTORy TEST");
        DJ.historyInfo();


        //need to test scoring system

        //using new User
        User chey = new User("Chey");

        System.out.println("START CHEY");
        // score should be 0
        System.out.print("Chey's score starting score is: ");
        chey.getScore();

        System.out.println();
        System.out.println("ADDING BOOK TEST");
//        a. Registering a book: +1
        chey.addBook(list.rentBook(countOfMonteCristo, chey));
        chey.bookInfo();
        System.out.println();
        // score should be 1
        System.out.print("Chey's score is: ");
        chey.getScore();
//        b. Lending a book: +5
        //score should be 6
        chey.lendBook(chey,DJ,countOfMonteCristo);
        System.out.print("Chey's score is: ");
        chey.getScore();

//        c. Returning a book in good condition: +2
        //adding book to return to list
        System.out.println();
        System.out.println("GOOD CONDITION TEST");
        list.getAllBooks();
        chey.addBook(list.rentBook(tomSawyer,chey));
        System.out.println();
        list.getAllBooks();
        // score should be 7
        System.out.print("Chey's score is: ");
        chey.getScore();
        chey.returnBook("Tom Sawyer",list); //PROBLEM IS HERE
        System.out.println();
        //score should be 9
        System.out.print("Chey's score is: ");
        chey.getScore();

//        d. If the book is returned in bad condition: -10
        //adding book to test bad condition
        // score should be 10
        System.out.println();
        System.out.println();
        chey.addBook( list.rentBook(tomSawyer, chey));
        System.out.println();
        System.out.print("Chey's score is: ");
        chey.getScore();

        //make book bad condition
        System.out.println();
        System.out.println("BAD CONDITION TEST");
        tomSawyer.changeCondition();
        chey.returnBook(tomSawyer.getBookName(),list);
        //score should be 0
        System.out.print("Chey's score is: ");
        chey.getScore();

//        e. Daily penalty for missing the deadline: -2

        //test late book
        System.out.println();
        System.out.println("LATE TEST");
        chey.addBook(list.rentBook(tomSawyer,chey));
        tomSawyer.changeCondition();
        tomSawyer.getCondition();
        tomSawyer.setDeadline(-10);
        chey.returnBook(tomSawyer.getBookName(),list);
        chey.getScore();

        //test search by name function
        System.out.println();
        System.out.println("TEST SEARCH BY NAME");
        list.searchByName("Harry Potter");

        //test book ranking function by returning all books and checking scores
        System.out.println();
        System.out.println("TEST BOOK RANKING FUNCTION");
        DJ.returnBook(countOfMonteCristo.getBookName(),list);
        list.topBooks();









    }



}
