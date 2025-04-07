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
    // private String image;

    /**
     * Constructor for objects of class Book
     */
    public Book(int key, String nm, String auth, int qty)
    {
        this.id = key;
        this.name = nm;
        this.author = auth;
        this.quantity = qty;
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
