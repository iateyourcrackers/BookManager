import ecs100.*;
import java.util.HashMap;

/**
 * Write a description of class Books here.
 * 
 * Holds a collection of books in a hashmap
 * Allows a user to add, find, print all, edit from a menu, delete, and prevent user from adding a duplicate book
 *
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
        
        this.currBookId = 3; // store the current boook ID number
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
            } else if (choice.equalsIgnoreCase("F")) {
                // find books
            } else if (choice.equalsIgnoreCase("P")) {
                // print all books
            } else if (choice.equalsIgnoreCase("Q")) {
                // quit
                UI.println("BYE");
                UI.quit();
            } else {
                UI.println("HEY ENTER YOUR OPTION");
            }
            // run the menu until the user enters "Q"
        } while (!choice.equalsIgnoreCase("Q"));
    }
}
