package animal;

/**
 *
 * @author Bijay Subedi 12127892i
 * this class implements the IBehavior method to provide the behavior required to use decision tree to play game
 */
public class AnimalBehavior implements IBehavior {
    
    private IView view;
    
    public AnimalBehavior(IView view){
        
        this.view = view;
        
    }
    
    
    
    public Node emptyTree(){
        String data = view.ask("What is your animal?");
        return new Node(data);  //creates new node if the tree is empty
                
    }
    
    //process nonleafnode
    public boolean processNonLeafNode(Node n){
       
        boolean choose = view.choose(n.getQuestion());
        return choose;
    }
    
    //process leaf nodes
    public boolean processLeafNode(Node n){
        n.getQuestion();
        boolean choose = view.choose(n.getQuestion());
        if(choose == true){
            return false;
        }
        else{
            String data = view.ask("Please enter your animal");
            String question = view.ask("Provide a yes/no question that distinguish between " +data+" and "+n.getData()+". Yes = "+data+" no = "+n.getData());
            n.extend(question, n.getData(), data);
            return true;
        }
    }
    
    
    
    
    
}
