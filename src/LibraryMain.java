import java.util.ArrayList;
import java.util.Scanner;

//import java.util.ArrayList;
//
//class Library {
//    private ArrayList<Book_$> books = new ArrayList<Book_$>();
//
//    static{
//        System.out.println("Library System Loaded!");
//    }
//    {
//        System.out.println("New Library Instance Created!");
//    }
//
//    class Book_${
//        private String title;
//        private String author;
//
//        Book_$(String title, String author){
//            this.title = title;
//            this.author = author;
//        }
//
//        void display(){
//            System.out.println("Title: " + title + " | Author: " + author);
//        }
//    }
//    void addBook(String title, String author){
//        Book_$ book = new Book_$(title, author);
//        books.add(book);
//        System.out.println("Book added: " + title + " by " + author);
//    }
//    static class LibraryInfo{
//        static void displayInfo(){
//            System.out.println("--- Library Information ---");
//            System.out.println("This system manages a small collection of books.");
//        }
//    }
//    void showBooks(){
//        class BookList{
//            void printAll(){
//                System.out.println("--- List of Books ---");
//                for (Book_$ book : books){
//                    book.display();
//                }
//            }
//        }
//        BookList list = new BookList();
//        list.printAll();
//    }
//}
//public class LibraryMain {
//    public static void main(String[] args) {
//        Library.LibraryInfo.displayInfo();
//
//        Library lib = new Library();
//        lib.addBook("The Hobbit", "J.R.R. Tolkien");
//        lib.addBook("1984", "George Orwell");
//
//        lib.showBooks();
//    }
//}

public class LibraryMain {
    static {
        System.out.println("=== Welcome to the Library System ===");
    }
    class Book$_{
        private String title;
        private String Author;
        private int year;
        private static int bookCount = 0;

        {
            System.out.println("New Book Object Created!");
        }
        public Book$_(String title, String author, int year) {
            this.title = title;
            Author = author;
            this.year = year;
            bookCount++;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return Author;
        }

        public int getYear() {
            return year;
        }

        public static int getBookCount() {
            return bookCount;
        }
        public void displayInfo(){
            System.out.println("Book Title: " + getTitle());
            System.out.println("Book Author: " + getAuthor());
            System.out.println("Book Year: " + getYear());
            System.out.println("================================");
        }
    }
    class Library{
        private ArrayList<Book$_> book$_s = new ArrayList<>();
        private Scanner sc = new Scanner(System.in);

        void addBook(){
            class BookInputHelper{
                Book$_ getFromUser(){
                    System.out.println("Enter title: ");
                    String title = sc.nextLine();
                    System.out.println("Enter author: ");
                    String author = sc.nextLine();
                    System.out.println("Enter year: ");
                    int year = sc.nextInt(); sc.nextLine();

                    return new Book$_(title, author, year);
                }
            }
            BookInputHelper inputHelper = new BookInputHelper();
            Book$_ book = inputHelper.getFromUser();
            book$_s.add(book);
            System.out.println("Book added successfully.");
        }
        void displayBookS(){
            if (book$_s.isEmpty()) System.out.println("Book list is empty.");
            else{
                System.out.println("--- Book List ---");
                for (Book$_ book : book$_s){
                    book.displayInfo();
                }
            }
        }
        void searchBook(){
            boolean found = false;
            System.out.println("Enter Book title to Search: ");
            String title = sc.nextLine();
            for (Book$_ book : book$_s){
                if (book.getTitle().equalsIgnoreCase(title)){
                    System.out.println("Book Found: " + book.getTitle());
                    book.displayInfo();
                    found = true;
                    break;
                }
            }
            if (!found){
                System.out.println("No book found.");
            }
        }
        void displayMenu(){
            System.out.println("\nA. Add Book");
            System.out.println("B. View Books");
            System.out.println("C. Search Book");
            System.out.println("D. Exit");
            System.out.print("Choose: ");

        }
    }

    public static void main(String[] args) {
        LibraryMain main = new LibraryMain();
        Library library = main.new Library();


       String input = "";
       do {
           library.displayMenu();
           input = sc.nextLine();
           switch (input.toUpperCase()){
               case "A":
                   library.addBook();
                   break;
               case "B":
                   library.displayBookS();
                   System.out.println("Total Books Count: " + Book$_.getBookCount());
                   break;
               case "C":
                   library.searchBook();
                   break;
           }
       } while (!input.equalsIgnoreCase("D"));
        System.out.println("Exiting...");

    }
    static Scanner sc = new Scanner(System.in);
}
