public class User {

    //    LEVEL 4: We need to provide a mechanism to calculate a user score. Users will be evaluated based on their actions:
//    a. Registering a book: +1
//    b. Lending a book: +5
//    c. Returning a book in good condition: +2
//    d. If the book is returned in bad condition: -10
//    e. Daily penalty for missing the deadline: -2
    private String name;
    private int bookCount = 0;
    private int historyCount = 0;
    private Book[] userList = new Book[30];
    private Book[] history = new Book[100];
    private int score = 0;
    private Book usedSpace = new Book("used");

    public User() {

    }

    public User(String name) {
        this.name = name;
    }


    void addBook(Book book) {
        if (bookCount < 30) {
            this.userList[bookCount] = book;
            this.history[historyCount] = book;
            //increment values accordingly
            this.historyCount++;
            this.bookCount++;
            this.score += 1;
            book.updateRank(1);
        } else {
            System.out.println("You have exceeded book limit, please return a book before borrowing another book");
        }
    }

    void returnBook(String str, BookList list) {
        //loop through the list of books looking for a match
        for (int i = 0; i < userList.length; i++) {
            System.out.println(userList[i].getBookName());
            if (str.equals(userList[i].getBookName())) {
                System.out.println("found: " + userList[i].getBookName());
                list.addBook(userList[i]);
                this.bookCount--;
                //find the book
                if (userList[i].getCondition().equals("good")) {
                    System.out.println("book was returned in good condition");
                    //update User score and book ranking score
                    this.score += 2;
                    userList[i].updateRank(2);
                    //check if the book was late
                    if (userList[i].getDeadline() < 0) {
                        System.out.println("the book was returned" + Math.abs(userList[i].getDeadline()) + " days late");
                        //update score by a multiple of how many days the book was late
                        this.score += (userList[i].getDeadline() * 2);
                        userList[i].updateRank((userList[i].getDeadline() * 2));
                        userList[i] = usedSpace;
                        break;
                    }
                    userList[i] = usedSpace;
                    break;
                }
                if (userList[i].getCondition().equals("bad")) {
                    System.out.println("the book was returned in bad condition");
                    this.score -= 10;
                    //check if the book was late
                    if (userList[i].getDeadline() < 0) {
                        System.out.println("the book was returned " + Math.abs(userList[i].getDeadline()) + " days late");
                        this.score += (userList[i].getDeadline() * 2);
                        userList[i].updateRank((userList[i].getDeadline() * 2));
                        userList[i] = usedSpace;
                        break;
                    }
                    userList[i] = usedSpace;
                    break;
                }
                break;
            }
            //run if no results were found
            if (i == userList.length) {
                System.out.println("Book cannot be returned because it is not on the list");
            }
        }
    }

    //shows the information for all the books in the list
    void bookInfo() {
        System.out.println(this.getName() + " has rented the following books: ");
        //before looping through books, check if there are any books in the list
        if (bookCount == 0) {

            System.out.println("no books have been rented yet");
        } else {
            //loop through the books and display information
            for (int i = 0; i < bookCount; i++) {
                System.out.println("Book Name: " + userList[i].getBookName());
                System.out.println("The book is in " + userList[i].getCondition() + " condition");
                System.out.println("The book must be returned in: " + userList[i].getDeadline() + "days");
            }
        }
    }

    //displays the history of up to the last 100 bucks rented
    void historyInfo() {
        System.out.println(this.name + "'s rental history: ");
        if (historyCount == 0) {

            System.out.println("no history yet");
        } else {
            for (int i = 0; i < historyCount - 1; i++) {
                System.out.println("Book " + (i + 1) + ": " + history[i].getBookName());
                System.out.println("The book is in " + history[i].getCondition() + " condition");
            }
        }
    }

    //User one lends User two a book
    void lendBook(User one, User two, Book book) {
        //search for book in User one's list
        for (int i = 0; i < one.userList.length; i++) {
            //if successful, give the book to user two
            if (book.getBookName().equals(one.userList[i].getBookName())) {
                two.addBook(userList[i]);
                one.userList[i] = this.usedSpace;
                this.score += 5;
                book.updateRank(5);
                book.setCurrentOwner(two);
                System.out.println(one.getName() + " lent " + two.getName() + " " + book.getBookName());
                break;


            }
            //run if user one does not have the requested book
            if (i == userList.length) {
                System.out.println("no loan happened");
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getHistoryCount() {
        return historyCount;
    }

    public void getScore() {
        System.out.println(score);
    }
}
