public class Book {

    private String bookName;
    private int deadline = 30;
    private String condition = "good";
    private User currentOwner;
    private String userName;
    private String author;
    private int year;
    private int rank;

    public Book(String book) {
        this.bookName = book;
        //this.currentOwner = getCurrentOwner();
    }

    public User setCurrentOwner(User currentOwner) {
        this.currentOwner = currentOwner;
        this.userName = getUserName();
        return this.currentOwner;
    }



    public String getBookName() {
        return bookName;
    }

    public User getCurrentOwner() {
        return currentOwner;
    }

    public String getUserName() {
        return userName;
    }

    public int getDeadline() {
        return deadline;
    }

    public String getCondition() {
        return condition;
    }

    //change book condition from good to bad and vice versa
    public void changeCondition(){
        if(this.condition.equals("good")) {
            this.condition = "bad";
            System.out.println("uh-oh you messed the book up, the book is now in " + this.condition);
        }
        else{
            this.condition = "good";
            System.out.println("book has been fixed up and is in " + this.condition + " condition");
        }

    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public void bookInfo(){
        System.out.println("Book name is: " + this.getBookName());
        System.out.println("Book condition is: " + this.getCondition());
        System.out.println("Book deadline is: " + this.getDeadline());
        System.out.println("Book author is: " + this.getAuthor());
        System.out.println("Book year is: " + this.getYear());
    }

    public void updateRank(int num){

        this.rank += num;
    }

    public int getRank() {
        return rank;
    }
}
