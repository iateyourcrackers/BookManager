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
        // set the star size and gap space
        final int MAX_STARS = 5;
        double starSize = 10;
        double gap = 10;
        double yStar = locY + HEIGHT + 10;
        
        // add a for range that loops through as many likes (stars)
        for (int i = 0; i < MAX_STARS; i++) {
            double xStar = locX + i * (starSize + gap);
            
            // only colour up to the liked amount of stars
            if (i < this.likes) {
                UI.setColor(Color.YELLOW);
            } else {
                UI.setColor(Color.LIGHT_GRAY);
            }
            
            // draw a triangle here bc i currently do not know how to draw a star
            double[] xPoints = {xStar, xStar + starSize/2, xStar + starSize};
            double[] yPoints = {yStar + starSize, yStar, yStar + starSize};
            
            UI.fillPolygon(xPoints, yPoints, 3);
        }
    }
    
    /**
     * Constructor for objects of class Book
     */
    public Book(int key, String nm, String auth, int qty, int lkes)
    {
        this(key, nm, auth, qty, lkes, DEFAULT_IMAGE);
    }
    
    /**
     * Change the likes for a book
     */
    public void setLikes(int lkes) {
        this.likes = lkes;
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
