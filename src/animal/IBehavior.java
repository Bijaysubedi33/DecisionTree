package animal;

/**
 *
 * @author Bijay Subedi 12127892
 * IBehaviour is a abstract class that is used to implement the behavior  for
 * processing empty tree, processing a leaf node and processing a non-leaf node.
 */
public interface IBehavior {
    
    public Node emptyTree();
    
    public boolean processNonLeafNode(Node n);
    
    public boolean processLeafNode(Node n);
    
    
    
    
}
