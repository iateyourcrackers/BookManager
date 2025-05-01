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
        UI.addButton("Find a book", this::findBook);
        UI.addButton("Print all books", books::printAllBooks);
        UI.addButton("Quit", UI::quit);
        UI.addButton("Remove a book", this::deleteBook);
        UI.addButton("Edit a book's likes", UI::quit);
    }
    
    /**
     * Remove a book based on the name
     * use findbook then use .remove or smth
     */
    public void deleteBook() {
        // use findbook
        // this.cock.is.very.big.8====D
        String bookName = UI.askString("Enter the book title: ");
        this.book = findBook(bookName);
        
        // catch null cases later
        if (this.book == null) {
            UI.println("hey so this book doesn't exist");
        } else {
            int bookId = this.book.getId();
            books.deleteBook(bookId);
            UI.println("book removed");
        }
    }
    
    /**
     * Find a book based on the name
     * set the current book instance if found
     * return boolean false or true
     */
    private Book findBook(String bookName) {
        // search for the book
        if (this.books.findBook(bookName.toLowerCase().trim())) {
            // refer back to books instance books method findBook to return true or false
            UI.println("found book PARAMETERRRR");
            this.book = books.getBook();
            return this.book;
        } else {
            UI.println("That book does not exist.");
            return null;
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
        if (this.books.findBook(bookName.toLowerCase().trim())) {
            // refer back to books instance books method findBook to return true or false
            UI.println("found book :P");
            this.book = books.getBook();
            this.book.displayBook();
            UI.println("Author: " + this.book.getAuthor());
            UI.println("Quantity: " + this.book.getQuantity());
        } else {
            UI.println("That book does not exist.");
        }
    }
    
    /**
     * drawer for stars (or triangles for now)
     */
    private void drawStars(int likes) {
        // draw five triangles
        UI.setColor(Co
    }
    
    /**
     * add a book to the hashmap
     */
    public void addBook() {
        // force a range of quantity
        final int MAX_QUANTITY = 99; // max quantity it can add to the hashmap
        int quantity;
        
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
        this.books.addBook(name, author, quantity, imgFileName);
    }
    
    /**
     * main routine
     */
    public static void main(String[] args) {
        new GUI();
    }
}
