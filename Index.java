import java.util.ArrayList;

/**
 * Class that indexes the keywords that now have an TFIDF 
 * Contains a BST field which holds all of the keywords and a Tag object to do the tagging
 * Contains methods that add keywords to the BST, search for a keyword in the BST, 
 * and print out all the terms
 *  
 * @author Angel Chen - 33%
 * @author Brian Grodzki - 33%
 * @author Franco Lombardi - 33%
 * 
 * @version 2017.05.01
 */
public class Index {
    /**
     * BST containing Keywords
     */
    private BinarySearchTree<Keyword> BST;
    
    /**
     * Tag object that does the tagging 
     */
    private Tag tagger;
    
    /**
     * Initialize BST and Tag 
     */
    public Index() {
        BST = new BinarySearchTree<Keyword>();
        tagger = new Tag();
    }
    
    /**
     * Getter method for Tag
     * Complexity O(1) - just needs to get a data field
     * @return Tag object
     */
    public Tag getTag() {
        return tagger;
    }
    
    /**
     * Getter method for BST
     * Complexity O(1) - just needs to get a data field
     * @return BST
     */
    public BinarySearchTree<Keyword> getBST() {
        return BST;
    }
    
    /**
    * Creates the BST index using the ArrayList of Articles from Tag object
    * Complexity O(n^3) - This method will be used after the TFIDF has been computed 
    * for all terms.  
    * Through the Tag object's ArrayList field, It will go through all the documents, and check each term, and add keywords.
    * to the BST if they have TFIDF value > 0.  
    * Any duplicate keywords when inserting will be ignored 
    * Going through each value in the ArrayList of articles
    * takes O(n^2) and adding each potential term to the BST is O(n), so therefore it is O(n^3).
    */
    public void createIndex() {
        for (int i = 0; i < this.tagger.getArrayList().size(); i++) {
            for (int j = 0; j < this.tagger.getArrayList().get(i).getTags().size(); j++) {
                Keyword index = new Keyword(this.tagger.getArrayList().get(i).getTags().get(j).getName());
                index.setFiles(this.tagger.getArrayList().get(i).getTags().get(j).getlistofarticles());
                
                if (this.BST.find(index) == null && tagger.getArrayList().get(i).getTags().get(j).getTFIDF() != 0.0 ) {                    
                    this.BST.insert(index);
                }
                
                
            }
        }
    }
     
    /**
     * Complexity O(n) - needs to traverse the BST, which has a complexity 
     * worst case O(n)
    * In-order traversal of the BST index, prints the terms
    */
    public void toInOrderIndex() {
        toInOrderIndex(this.BST.getroot());
    }
    
    /**
     * Helper method of toInOrderIndex
     * Complexity O(n) - needs to traverse the BST, which has a complexity 
     * worst case O(n)
     * @param root Root of the BST 
     */
    private void toInOrderIndex(BinaryNode<Keyword> root) {
        if (root == null) {
            return;
        }
        
        toInOrderIndex(root.getLeft());
        System.out.println(root.getElement().getName());
        toInOrderIndex(root.getRight());
    }
    
    /**
    * Find all the articles associated to keyword, calls the find method of the BST class
    * Has complexity O(n), which is the complexity needed
    * to traverse an arrayList and find an element with equivalent value
    * @param keyword the search key
    * @return the ArrayList of articles
    */
    public ArrayList<String> search (String keyword) {
        Keyword key = new Keyword(keyword);
        
        if (this.BST.find(key) == null) {
            return null;
        }
        
        else {
            return this.BST.find(key).getFiles();
        }
    }
    
    

}

