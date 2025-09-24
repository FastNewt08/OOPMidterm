//class Book {
//    //fields
//    private String title;
//    private String author;
//    private String isbn;
//    private boolean isBorrowed;
//
//    //Methods
//    //Constructor
//    public Book(String title, String author, String isbn){
//        this.title = title;
//        this.author = author;
//        this.isbn = isbn;
//        isBorrowed = false;
//    }
//    //getters
//    public String getTitle (){
//        return title;
//    }
//    public String getAuthor() {
//        return author;
//    }
//    public String getIsbn() {
//        return isbn;
//    }
//    public boolean isBorrowed() {
//        return isBorrowed;
//    }
//
//    //setters
//
//    public void setBorrowed(boolean borrowed) {
//        isBorrowed = borrowed;
//    }
//    public void displayInfo(){
//        System.out.println("Title: " + getTitle() + ", Author: " + getAuthor() + ", ISBN: " + getIsbn());
//    }
//}
//
//class LibraryMember{
//    //fields
//    private String name;
//    private String memberId;
//    private Book borrowedBook;
//
//    //Methods
//    //Constructors
//    public LibraryMember(String name, String memberId){
//        this.name = name;
//        this.memberId = memberId;
//        borrowedBook = null;
//    }
//
//    //getters
//
//    public String getName() {
//        return name;
//    }
//    public String getMemberId() {
//        return memberId;
//    }
//    public Book getBorrowedBook() {
//        return borrowedBook;
//    }
//
//    public void borrowBook(Book book){
//        if (this.borrowedBook != null){
//            System.out.println("You already have a book: " + this.getBorrowedBook().getTitle());
//        } else if (book.isBorrowed()){
//            System.out.println(book.getTitle() + " is currently unavailable.");
//        } else {
//            this.borrowedBook = book;
//            book.setBorrowed(true);
//            System.out.println(getName() + " borrowed " + book.getTitle() + ".");
//        }
//    }
//    public void returnBook(){
//        if (getBorrowedBook() == null){
//            System.out.println("No book to return.");
//        } else {
//            getBorrowedBook().setBorrowed(false);
//            System.out.println(getName() + " returned " + getBorrowedBook().getTitle() + ".");
//            borrowedBook = null;
//        }
//    }
//    public void displayStatus(){
//        System.out.println("Member: " + getName() + " (ID: " + getMemberId() + ")");
//        if (getBorrowedBook() == null){
//            System.out.println("No Books were borrowed.");
//        } else {
//            System.out.print("Current book: "); getBorrowedBook().displayInfo();
//        }
//    }
//    public static void main(String[] args) {
//        // Create books
//        Book book1 = new Book("Java Basics", "J. Doe", "978-123456");
//        Book book2 = new Book("OOP in Practice", "A. Smith", "978-789012");
//
//        // Create member
//        LibraryMember member = new LibraryMember("Alice", "M101");
//        LibraryMember member1 = new LibraryMember("Discaya", "M100");
//
//        // Test borrowing
//        member.borrowBook(book1);
//        member.displayStatus();
//
//        // Try to borrow again
//        member.borrowBook(book2); // Should fail
//
//        // Return book
//        member.returnBook();
//
//        // Now try to borrow book2
//        member.borrowBook(book2);
//
//        // Final status
//        member.displayStatus();
//        member1.borrowBook(book2);
//        member1.displayStatus();
//    }
//}
class Book{
    private String title;
    private String author;
    private String isbn;
    private boolean isBorrowed;

    public Book(String title, String author, String isbn) {
        this.isbn = isbn;
        this.author = author;
        this.title = title;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getIsbn() {
        return isbn;
    }
    public boolean isBorrowed() {
        return isBorrowed;
    }
    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public void displayInfo(){
        System.out.println("Title: " + getTitle() + ", Author: " + getAuthor() + ", ISBN: " + getIsbn());
    }
}
class LibraryMember{
    private String name;
    private String memberId;
    private Book borrowedBook;

    public LibraryMember(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedBook = null;
    }

    public String getName() {
        return name;
    }
    public String getMemberId() {
        return memberId;
    }
    public Book getBorrowedBook() {
        return borrowedBook;
    }

    public void borrowBook(Book book){
        if (borrowedBook != null){
            System.out.println("You already have a book: " + getBorrowedBook().getTitle());
        } else if (book.isBorrowed()){
            System.out.println(book.getTitle() + " is currently unavailable.");
        } else {
            this.borrowedBook = book;
            book.setBorrowed(true);
            System.out.println(getName() + " borrowed " + getBorrowedBook().getTitle());
        }
    }
    public void returnBook (){
        if (getBorrowedBook() == null){
            System.out.println("No book to return.");
        } else {
            borrowedBook.setBorrowed(false);
            System.out.println(getName() + " returned " + getBorrowedBook().getTitle());
            borrowedBook = null;
        }
    }
    public void displayStatus(){
        System.out.println("Member: " + getName() + " (ID: " + getMemberId() + ")");
        if (getBorrowedBook() == null){
            System.out.println("No Books were borrowed.");
        } else {
            System.out.print("Current book: "); getBorrowedBook().displayInfo();
        }
    }
//        public void displayStatus(){
//        System.out.println("Member: " + getName() + " (ID: " + getMemberId() + ")");
//        System.out.print("Current book: "); getBorrowedBook().displayInfo();
//    }
    public static void main(String[] args) {
        // Create books
        Book book1 = new Book("Java Basics", "J. Doe", "978-123456");
        Book book2 = new Book("OOP in Practice", "A. Smith", "978-789012");

        // Create member
        LibraryMember member = new LibraryMember("Alice", "M101");

        // Test borrowing
        member.borrowBook(book1);
        member.displayStatus();

        // Try to borrow again
        member.borrowBook(book2); // Should fail

        // Return book
        member.returnBook();

        // Now try to borrow book2
        member.borrowBook(book2);

        // Final status
        member.displayStatus();


    }
}