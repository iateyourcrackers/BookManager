import ecs100.*;
import java.util.HashMap;

/**
 * Write a description of class Books here.
 * 
 * Holds a collection of books in a hashmap
 * Allows a user to add, find, print all, edit from a menu, delete, and prevent user from adding a duplicate book
 *
 * ??? delete
 * ??? prevent user from adding a duplicate
 * @author (HJF)
 * @version (7/4/25)
 */
public class Books
{
    // instance variables
    private HashMap<Integer, Book> library; // declaring the hashmap
    private int currBookId; // store the current id number of the book being added
    private Book currBook; // store the instance of the current book

    /**
     * Constructor for objects of class Books
     */
    public Books()
    {
        // initialise instance variables
        library = new HashMap<Integer, Book>(); // initialise hashmap
        
        // create books
        Book b1 = new Book(1, "The Wicked King", "Holly Black", 12);
        Book b2 = new Book(2, "Persuasion", "Jane Austen", 5);
        Book b3 = new Book(3, "Harry Potter", "JK Rowling", 63);
        
        // put some books in the library
        library.put(1, b1);
        library.put(2, b2);
        library.put(3, b3);
        
        this.currBookId = 3; // store the current book ID number
    }
    
    /**
     * set book ID
     */
    public void setBookId() {
        this.currBookId += 1;
    }
    
    /**
     * Find a book based on the name
     * set the current book instance if found
     * return boolean false or true
     */
    public boolean findBook(String name) {
        // search for the book
        for (int bookId: library.keySet()) {
            if (library.get(bookId).getName().toLowerCase().equals(name.toLowerCase().trim())) {
                this.currBook = this.library.get(bookId); // set the current book
                return true;
            }
        }
        return false;
    }
    
    /**
     * add a book to the hashmap
     */
    public void addBook(String name, String author, int qty) {
        this.setBookId();
        library.put(currBookId, new Book(currBookId, name, author, qty));
    }
    
    /**
     * add a book to the hashmap
     */
    public void addBook(String name, String author, int qty, String img) {
        this.setBookId();
        library.put(currBookId, new Book(currBookId, name, author, qty, img));
    }
    
    /**
     * Book Getter
     * return an instance of Book class
     */
    public Book getBook() {
        return this.currBook;
    }
    
    /**
     * print all books
     */
    public void printAllBooks() {
        for (int bookId: library.keySet()) {
            UI.println(bookId + " Details: ");
            UI.println(library.get(bookId).getName() + " "
            + library.get(bookId).getAuthor() + " "
            + library.get(bookId).getQuantity());
        }
    }
    
    /**
     * Menu to print all and call appropriate methods
     */
    public void menu() {
        // Print menu and force choice
        String choice;
        
        do {
            UI.println("(A)dd a book");
            UI.println("(F)ind a book");
            UI.println("(P)rint all books");
            UI.println("(Q)uit");
            
            choice = UI.askString("Enter your choice: ");
            
            if (choice.equalsIgnoreCase("A")) {
                // add books
                String title = UI.askString("Enter book title: ");
                String author = UI.askString("Enter book author: ");
                
                // check for existing books
                if (findBook(title)) {
                    UI.println("A book with this title already exists.");
                    break;
                } else {
                    double qty = UI.askDouble("Enter quantity: ");
                    UI.println("Book added successfully.");
                    break;
                }
            } else if (choice.equalsIgnoreCase("F")) {
                // find books
                String searchTitle = UI.askString("Enter book title: ");
                if (findBook(searchTitle)) {
                    // found the book, print details
                    UI.println("Book found");
                    UI.print(currBook);
                } else {
                    // did not find the book
                    UI.println("Book not found");
                }
                break;
            } else if (choice.equalsIgnoreCase("P")) {
                // print all books
                printAllBooks();
                break;
            } else if (choice.equalsIgnoreCase("Q")) {
                // quit
                UI.println("BYE");
                UI.quit();
                break;
            } else {
                UI.println("HEY ENTER YOUR OPTION");
            }
            // run the menu until the user enters "Q"
        } while (!choice.equalsIgnoreCase("Q"));
    }
    
    /**
     * main
     */
    public static void main(String[] args) {
        new Books().menu();
    }
}
