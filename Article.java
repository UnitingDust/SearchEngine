import java.util.ArrayList;

/**
 * Represents an article 
 * Contains an ArrayList of Terms which represent the words in an article 
 * and a String field which represents its name 
 * 
 * 
 * @author Angel Chen  
 * @version 2017.05.01
 */
public class Article {
    /**
     * Contains all of the terms inside an article
     */
    private ArrayList<Term> tags;
    
    /**
     * Name of the article
     */
    private String name;
    
    /**
     * Set name and initialize ArrayList of terms
     * @param name Name of the file
     */
    public Article(String name) {
        this.setName(name);
        setFiles(new ArrayList<Term>());
    }

    /**
     * ArrayList of terms
     * Complexity O(1) - just needs to return a data field
     * @return ArrayList of Terms
     */
    public ArrayList<Term> getTags() {
        return tags;
    }

    /**
     * Set ArrayList of terms
     * Complexity O(1) - just needs to set a data field
     * @param tags Desired ArrayList
     */
    public void setFiles(ArrayList<Term> tags) {
        this.tags = tags;
    }

    /**
     * Get name of the file
     * Complexity O(1) - just needs to return a data field
     * @return Name of the file
     */
    public String getName() {
        return name;
    }

    /**
     * Set name of the file
     * Complexity O(1) - just needs to set a data field
     * @param name Desired name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Add Term to the ArrayList
     * Complexity O(1) - just needs to add an element
     * to the ArrayList<Term> field
     * @param x Term being added
     */
    public void addTerm(Term x) {
        this.tags.add(x);
    }

}

