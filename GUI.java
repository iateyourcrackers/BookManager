import ecs100.*;
import java.awt.Color;

/**
 * Write a description of class GUI here.
 *
 * @author (HJF)
 * @version (1/5/25)
 */
public class GUI
{
    // instance variables - replace the example below with your own
    private Books books;
    private Book book;
    private Color starColor;

    /**
     * Constructor for objects of class GUI
     */
    public GUI()
    {
        // initialise instance variables
        books = new Books();
        
        // initialise the GUI
        UI.initialise();
        UI.addButton("Add a book", this::addBook);
        UI.addButton("Display (find) a book", this::findBook);
        UI.addButton("Print all books", books::printAllBooks);
        UI.addButton("Quit", UI::quit);
        UI.addButton("Remove a book", this::deleteBook);
        UI.addButton("Edit a book's likes", this::editLikes);
    }
    
    /**
     * Remove a book based on the title
     */
    public void deleteBook() {
        // search library based on title and store the book found in book
        String bookName = UI.askString("Enter the book title: ");
        String bookAuthor = UI.askString("Enter the book author: ");
        
        this.book = findBook(bookName, bookAuthor);
        
        // check whether the book exists first, then remove from library
        if (this.book == null) {
            UI.println("hey so this book doesn't exist?");
        } else {
            // Find book's ID to remove from library
            int bookId = this.book.getId();
            books.deleteBook(bookId);
            UI.println("book removed");
        }
    }
    
    /**
     * Find a book based on the title passed in through the parameter
     * Set the current book instance if found
     * Returns the book found
     */
    private Book findBook(String bookName, String bookAuthor) {
        // search for the book
        if (this.books.findBook(bookName.toLowerCase().trim(), bookAuthor.toLowerCase().trim())) {
            // If match found, return the book
            this.book = books.getBook();
            return this.book;
        } else {
            UI.println("That book does not exist.");
            return null; // return nothing if not found
        }
    }
    
    /**
     * Check whether the likes entered is within 0 - 5 (valid)
     */
    public int checkLikes() {
        //hahahahaha
        final int MAX_STARS = 5;
        int likes;
        
        // Check boundaries for the likes (stars)
        do {
            likes = UI.askInt("Enter new star rating (out of five stars): ");
            if ((likes > 0) && (likes <= MAX_STARS)) {
                UI.println("ok cool");
            } else if (likes > MAX_STARS) {
                UI.println("Must be from 0 to 5.");
            } else if (likes < 0) {
                UI.println("If you hate this book why's it in your library? (Try again)");
            } else {
                UI.println("That's not a valid number (Enter 0 to 5).");
            }
        } while (likes < 0 || likes > MAX_STARS);
        
        return likes;
    }
    
    /**
     * Swap the book's old likes for the new rating
     */
    public void editLikes() {
        // find the book
        String bookName = UI.askString("Enter the book title: ");
        String bookAuthor = UI.askString("Enter the book author: ");
        this.book = this.findBook(bookName, bookAuthor);
        
        // check whether book exists
        if (book == null) {
            UI.println("That book does not exist.");
        } else {
            // ask for new rating, then swap the old rating out
            int newLikes = checkLikes();
            this.book.setLikes(newLikes);
        }
    }
    
    /**
     * Find a book based on the name
     * set the current book instance if found
     * return boolean false or true
     */
    public void findBook() {
        // search for the book
        String bookName = UI.askString("Enter the book title: ");
        String bookAuthor = UI.askString("Enter the book author: ");
        
        if (this.books.findBook(bookName.toLowerCase().trim(), bookAuthor.toLowerCase().trim())) {
            // refer back to books instance books method findBook to return true or false
            UI.println("Found your book :P");
            this.book = books.getBook();
            
            // display the book's info
            this.book.displayBook();
            UI.println("Author: " + this.book.getAuthor());
            UI.println("Quantity: " + this.book.getQuantity());
            UI.println("Rating (out of five stars): " + this.book.getLikes());
        } else {
            UI.println("That book does not exist.");
        }
    }
    
    /**
     * Add a book to the library (hashmap)
     */
    public void addBook() {
        // force a range of quantity
        final int MAX_QUANTITY = 99; // max quantity it can add to the hashmap
        final int MAX_STARS = 5;
        int quantity;
        int likes;
        
        // ask the user for details
        String name = UI.askString("Enter book title: ");
        String author = UI.askString("Enter book author: ");
        
        // Check boundaries for the number of books added
        do {
            quantity = UI.askInt("Quantity: ");
            if ((quantity > 0) && (quantity <= MAX_QUANTITY)) {
                UI.println("Added new book.");
            } else if (quantity > MAX_QUANTITY) {
                UI.println("Must be less than 100");
            } else if (quantity < 1) {
                UI.println("Must be greater than 0");
            } else {
                UI.println("that ain't a number??");
            }
        } while (0 >= quantity || quantity > MAX_QUANTITY);
        
        // add a book image for display
        String imgFileName = UIFileChooser.open("Choose Image File: ");
        
        // add books with images
        this.books.addBook(name, author, quantity, checkLikes(), imgFileName);
    }
    
    /**
     * Main routine
     */
    public static void main(String[] args) {
        new GUI();
    }
}
