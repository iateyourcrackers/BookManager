import ecs100.*;

/**
 * Write a description of class Book here.
 * 
 * Support class for Books
 *
 * @author (HJF)
 * @version (7/4/25)
 */
public class Book
{
    // instance variables
    private int id;
    private String name;
    private String author;
    private int quantity;
    private String image;
    static final String DEFAULT_IMAGE = "book.jpg"; // set a default image

    /**
     * Constructor for objects of class Book
     */
    public Book(int key, String nm, String auth, int qty, String img)
    {
        this.id = key;
        this.name = nm;
        this.author = auth;
        this.quantity = qty;
        if (img == null) {
            this.image = DEFAULT_IMAGE; // add default img if user clicks cancel
        } else {
            this.image = img;
        }
    }
    
    /**
     * Display image on GUI
     */
    public void displayBook() {
        int locX = 100; // image x start position
        int locY = 100; // image y start position
        
        final double WIDTH = 250;
        final double HEIGHT = 300;
        
        UI.drawImage(this.image, locX, locY, WIDTH, HEIGHT);
    }
    
    /**
     * Constructor for objects of class Book
     */
    public Book(int key, String nm, String auth, int qty)
    {
        this(key, nm, auth, qty, DEFAULT_IMAGE);
    }

    /**
     * Getter for id number
     */
    public int getId() {
        return this.id;   
    }
    
    /**
     * Getter for name
     */
    public String getName() {
        return this.name;   
    }
    
    /**
     * Getter for author
     */
    public String getAuthor() {
        return this.author;   
    }
    
    /**
     * Getter for quantity number
     */
    public int getQuantity() {
        return this.quantity;   
    }
}
