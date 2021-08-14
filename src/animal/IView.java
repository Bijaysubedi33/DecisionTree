package animal;

/**
 *
 * @author Bijay Subedi 12127892
 * IView interface is an abstract class that is used to group related methods used for UI
 */
public interface IView {
    
    public void display(String s);
    
    public void append(String s);
    
    public String ask(String question);
    
    public boolean choose(String question);
    
    public String choose(String question, String choice1, String choice);
    
    
    
}
