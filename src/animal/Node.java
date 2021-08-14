package animal;

/**
 *
 * @author Bijay Subedi 12127892
 */
public class Node {
    
    protected String data;
    protected int label;
    protected Node left = null;
    protected Node right = null;
    
    
    public Node(String data){
        
        this.data = data;
    }
    
    public Node(String data, int label){
            
        this.data = data;
        this.label = label;
    }
    
    public Node(String data, Node left, Node right){
        
        this.data = data;
        this.left = left;
        this.right = right;
    }
    
    public String getQuestion(){
        
        if(this.left == null && this.right == null){
            return "Is your animal a(n) "+data;
        }
        else{
            return data;
        }
        
    }
    
    public void extend(String data, String leftAnimal, String rightAnimal){
        
        this.data = data;
        left = new Node(leftAnimal, null, null);
        right = new Node(rightAnimal, null, null);
       

    }
    
    public boolean isLeaf(){
      return left == null && right == null;
    }
    
    public Node getLeft(){
        return left;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
    
    
    public Node getRight(){
        return right;
    }
    
    public String getData(){
        return data;
    }
    
    public int getLabel(){
        return label;
    }
    
    
    
    
    
}
