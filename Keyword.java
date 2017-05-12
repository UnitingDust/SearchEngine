import java.util.ArrayList;

/**
 * Element being used in the BST class. Represents a keyword.
 * Implements Comparable to allow it to be compared to other Keyword objects
 *  
 * Has a String field that stores the name of the keyword
 * and an ArrayList of Strings which stores name of articles
 * 
 * @author Angel Chen - 33%
 * @author Brian Grodzki - 33%
 * @author Franco Lombardi - 33%
 * 
 * @version 2017.05.01
 *
 */
public class Keyword implements Comparable<Keyword> {
    /**
     * String List of articles in which in the keyword appears in
     */
    private ArrayList<String> articles;
    
    /**
     * Name of the Keyword
     */
    private String name;
    
    /**
     * Constructor for a Keyword
     * @param name Keyword name
     */
    public Keyword(String name) {
        this.setName(name);
        setFiles(new ArrayList<String>());
    }

    
    /**
     * Compares two Keyword objects by their String name
     * O(1) : Simply compares two numbers  
     * @param x 2nd Keyword object 
     * @return -1, 0, 1 depending on the comparison
     */
    public int compareTo(Keyword x) {
        if (this.name.compareTo(x.name) == 0) {
            return 0;
        }
        
        if (this.name.compareTo(x.name) > 0) {
            return 1;
        }
        
        else {
            return - 1;
        }
    }
    
    /**
     * Adds a file to the ArrayList of Articles
     * O(1) : Simply inserting in array list
     * @param x File being added 
     */
    public void update(String x) {
        this.articles.add(x);
    }


    /**
     * Get name of Keyword
     * O(1) : Simply gets the name
     * @return name of keyword
     */
    public String getName() {
        return name;
    }

    /**
     * Set name of Keyword
     * O(1) : Simply sets the name
     * @param name Desired name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Get ArrayList of files
     * O(1) : Simply gets the array list
     * @return ArrayList of files
     */
    public ArrayList<String> getFiles() {
        return articles;
    }


    /**
     * Set ArrayList of Articles
     * O(1) : Simply sets the array list
     * @param articles Desired ArrayList of Articles
     */
    public void setFiles(ArrayList<String> articles) {
        this.articles = articles;
    }    
}

