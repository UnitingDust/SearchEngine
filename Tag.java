import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Tags the keywords in all of the articles obtained through the 
 * HashMap by the FileParser. Computes TFIDF of each term
 * Stores all of the important keywords in the ArrayList of Keyword
 * 
 * @author Angel Chen - 33%
 * @author Brian Grodzki - 33%
 * @author Franco Lombardi - 33%
 * 
 * @version 2017.05.01
 */
public class Tag {
    /**
     * Contains a list of articles
     */
    private ArrayList<Article> articles;
      
    /**
     * Initialize ArrayList
     */
    public Tag() {
        articles = new ArrayList<Article>();
    }
    
    /**
     * O(1) : Simply returns an array list
     * @return ArrayList of Files
     */
    public ArrayList<Article> getArrayList() {
        return articles;
    }
    
    /**
     * Methods that takes a HashMap containing documents URL and a list of terms
     * in it and compute the TFIDF of each term. Only  keep terms with TFIDF > 0
     * Uses computeTF and computeIDF methods 
     * O(n^4)
     * @param hm HashMap of all the articles and the words inside each of them 
     */
    public void TFIDF(HashMap<String, ArrayList<String>> hm) {
        
        for (HashMap.Entry<String, ArrayList<String>> entry : hm.entrySet()) {
            Article file = new Article(entry.getKey());
            
            for (int i = 0; i < entry.getValue().size(); i++) {
                Term word = new Term(entry.getValue().get(i));
                
                if (!(this.isExist(word.getName(), file))) {
                    this.computeTF(word, entry.getValue());
                    file.addTerm(word);
                }
            }
            
            this.articles.add(file);            
        }
        
        this.computeIDF(); //O(n^4)    
    }
    
    /**
     * Check if word already exists in an article's ArrayList of terms 
     * O(n)
     * @param x String being checked
     * @param y Article
     * @return true if the String exist in the article, false otherwise
     */
    public boolean isExist(String x, Article y) {
        for (int i = 0; i < y.getTags().size(); i++) {
            if (y.getTags().get(i).getName().equals(x)) {
                return true;
            }
        }
        
        return false;
    }
    
    
    /**
     * Find the TF of the term and set it by using the size of the article
     * and how many times the term appears inside that article
     * O(n) 
     * @param x Term whose's TF needs to be calculated
     * @param listofwords All of the words in an article 
     */
    public void computeTF(Term x, ArrayList<String> listofwords) {
        double frequency = Collections.frequency(listofwords, x.getName());
        x.setTF(frequency/ (double)listofwords.size());
    }
    
    /**
     * Access each Article's terms and compute IDF for each term using
     * filecontains method. At the same time compute TFIDF for each term
     * O(n^4) : Goes through each term in each article, and then uses filecontains which is O(n^2) 
     *     
     */
    public void computeIDF() {
        for (int i = 0; i < this.articles.size(); i++) {
            for (int j = 0; j < this.articles.get(i).getTags().size(); j++) {
                double IDF = (double)this.articles.size()/(double)this.filecontains(articles.get(i).getTags().get(j));
                articles.get(i).getTags().get(j).setIDF(Math.log10(IDF));
                
                double TFIDF = (double)articles.get(i).getTags().get(j).getTF() * (double)articles.get(i).getTags().get(j).getIDF();

                articles.get(i).getTags().get(j).setTFIDF(TFIDF);
                
            }
        }
    }
    
    /**
     * Search how many times a term appears in a list of files 
     * Adds which articles the term is found in within its ArrayList field
     * O(n^2)
     * @param x Term being searched
     * @return how many articles a term appears in
     */
    public int filecontains(Term x) {
        int count = 0;
        
        for (int i = 0; i < this.articles.size(); i++) {
            for (int j = 0; j < this.articles.get(i).getTags().size(); j++) {
                if (x.getName().equals(articles.get(i).getTags().get(j).getName())) {
                    count++;
                    x.getlistofarticles().add(articles.get(i).getName());
                }
            }
        }
        
        return count;
    }
}

