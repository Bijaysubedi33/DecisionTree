package animal;

/**
 *
 * @author Bijay Subedi 12127892
 */
public class Game {
    
    private DecisionTree tree;
    private IView view;

    public Game(IView view) {
        this.view = view;
        AnimalBehavior animalBehavior = new AnimalBehavior(view); 
        tree = new DecisionTree((IBehavior) animalBehavior);
  
    }

    
    public void load(String name){
        
    }
    
    public void save(String name){
        
        try{
            
            tree.Save(name);
            view.display("File was saved successfully");
            
        }catch(Exception e){
         view.display("There was some problem saving the file");
        }
    }
    
    public void help(){
        
        view.display("Think of an animal. If my tree is non-empty. \n I will ask some yes/no questions to try to determine what it is");
        
    }
    

    public String display(){
        return tree.display();
    }
    
    
    public void play() {
// simplified phase 1 version game behaviour – to test the GUI and // loop.
  // In phase 2 (onwards) the code in the while loop must be modified   
  // to play the game using the decision tree’s execute() method 
  
    help();//display the help message 
    boolean again = true;
    while (again) {
     // Take care: in phase 2 (onwards) when the if condition 
     // tests the result from invoking the tree’s execute() method  a 
     // result of true will mean the player has won, so the 
     // logic below will have to be modified accordingly.
     if(tree.execute() == true)
        
         again = view.choose("You won! Play again?");
     else
         again = view.choose("I won! Play again?");        
     }
    }

    
}
