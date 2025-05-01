import ecs100.*;
import java.awt.Color;

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
    private int likes;
    
    /**
     * Constructor for objects of class Book
     */
    public Book(int key, String nm, String auth, int qty, int lkes, String img)
    {
        this.id = key;
        this.name = nm;
        this.author = auth;
        this.quantity = qty;
        this.likes = lkes;
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
        // draw the book cover
        int locX = 100; // image x start position
        int locY = 100; // image y start position
        
        final double WIDTH = 250;
        final double HEIGHT = 300;
        
        UI.drawImage(this.image, locX, locY, WIDTH, HEIGHT);
        
        // draw the star rating
        
    }
    
    /**
     * Constructor for objects of class Book
     */
    public Book(int key, String nm, String auth, int qty, int lkes)
    {
        this(key, nm, auth, qty, lkes, DEFAULT_IMAGE);
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
    
    /**
     * Getter for likes
     */
    public int getLikes() {
        return this.likes;
    }
}
