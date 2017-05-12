import java.util.ArrayList;

/**
 * Represents a word in an article.
 * Stores the TF, IDF, and TFIDF values 
 * Stores name as a String and an ArrayList of articles where it is found 
 * Class only setters and getters
 * 
 * @author Angel Chen - 33%
 * @author Brian Grodzki - 33%
 * @author Franco Lombardi - 33%
 * 
 * @version 2017.05.01
 */
public class Term {
    /**
     * Name of the term
     */
    private String name;
    
    /**
     * Term Frequency of term
     */
    private double TF;
    
    /**
     * Inverse Document Frequency of term
     */
    private double IDF;
    
    /**
     * TFIDF of term, which is TF * IDF
     */
    private double TFIDF;
    
    /**
     * List of articles where the term is found in
     */
    private ArrayList<String> listofarticles;
    
    /**
     * Set name of term and rest of fields = 0
     * @param name Name of the term
     */
    public Term(String name) {
        this.setName(name);
        setTF(0);
        setIDF(0);
        setTFIDF(0);
        listofarticles = new ArrayList<String>();
    }

    /**
     * Get the name of the term
     * Complexity O(1) : Simply gets the name
     * @return name of the term
     */
    public String getName() {
        return name;
    }


    /**
     * Set the name of term
     * Complexity O(1) : Simply sets the name
     * @param name Desired name of term
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Get the IDF 
     * Complexity O(1) : Simply gets the IDF
     * @return IDF of term
     */
    public double getIDF() {
        return IDF;
    }


    /**
     * Set the IDF 
     * Complexity O(1) : Simply sets the IDF
     * @param iDF Desired IDF
     */
    public void setIDF(double iDF) {
        IDF = iDF;
    }

    /**
     * Get the TFIDF
     * Complexity O(1) : Simply gets the TFIDF
     * @return TFIDF of term
     */
    public double getTFIDF() {
        return TFIDF;
    }


    /**
     * Set the TFIDF
     * Complexity O(1) : Simply sets the TFIDF
     * @param tFIDF Desired TFIDF of term
     */
    public void setTFIDF(double tFIDF) {
        TFIDF = tFIDF;
    }

    /**
     * Get the TF
     * O(1) : Simply gets the TF
     * @return TF of term
     */
    public double getTF() {
        return TF;
    }


    /**
     * Set the TF
     * O(1) : Simply sets the TF
     * @param tF Desired TF of term
     */
    public void setTF(double tF) {
        TF = tF;
    }

    /**
     * Get the ArrayList of String
     * O(1) : Simply gets the ArrayList
     * @return ArrayList of articles where term is found in 
     */
    public ArrayList<String> getlistofarticles() {
        return listofarticles;
    }

    /**
     * Set the ArrayList of String
     * O(1) : Simply sets the ArrayList
     * @param nameofarticles Desired ArrayList of String
     */
    public void setlistofarticles(ArrayList<String> nameofarticles) {
        this.listofarticles = nameofarticles;
    }
    
    
}

