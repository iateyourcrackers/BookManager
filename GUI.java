import ecs100.*;

/**
 * Write a description of class GUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GUI
{
    // instance variables - replace the example below with your own
    private Books books;
    private Book book;

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
        UI.addButton("Remove book", UI::quit);
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
     * add a book to the hashmap
     */
    public void addBook() {
        // force a range of quantity
        final int MAX_QUANTITY = 99; // max quantity it can add to the hashmap
        int quantity;
        
        // ask the user for details
        String name = UI.askString("Enter the title: ");
        String author = UI.askString("Enter the author: ");
        
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
        } while (0 > quantity || quantity > MAX_QUANTITY);
        
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
