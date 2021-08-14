package animal;

import java.io.File;
import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author Bijay Subedi 12127892
 */
public class DecisionTree {
    
    protected Node root;
    protected IBehavior behaviour;
    
    
    public DecisionTree(){
        
        
    }
    
    public DecisionTree(IBehavior behaviour){
        this.behaviour = behaviour;
        
    }
    
    public boolean execute(){
        if(root == null){
            Node data = behaviour.emptyTree();
            root = data;
            return true;
            
        }
        else{ 
            boolean result = execute(root);
            return result;

        }
    }
    
    public boolean execute(Node n){
       
        if(n.left == null && n.right == null){
            return behaviour.processLeafNode(n);
        }
        else{
            
           boolean value = behaviour.processNonLeafNode(n);
           
           if(value == true){
               return execute(n.right);
               
           }
           else{
               return execute(n.left);
               
           }

        }
   
    }
    
    public String display(){
        StringBuilder sb = new StringBuilder();
        display(sb, 0, "root: ", root);
        return sb.toString();
    }
    
    private void display(StringBuilder sb, int level, String n, Node node){
        
        if(node == null){
            return;
        }
        level = level + 2;
        for(int i=0;i<level;i++)
            sb.append(" ");      
        sb.append(String.format("%s %s %d\n",n, node.data, node.label));
        display(sb, level, "left", node.left);
        display(sb, level, "right", node.right);
        
        
    } 
    
    private int label(Node n, int count){
        if ( n != null )  {
            int next = label( n.left, count);
            n.label = next++;
            next = label(n.right, next);
            return next;
        } 
        return count;

        
    }
    
    public void Save(String name) throws Exception{
        
        label(root, 0);
        try(Formatter output = new Formatter(name)){
            
            Save(root, output);
            output.close();
            
        }
        catch(Exception e){
            System.err.println("An exception "+e.getMessage()+" occured");
        }

    }
    
    private void Save(Node node, Formatter formatter){
        
        
        if (node == null) {
            return; 
        } 
  
            try{
            
            formatter.format("%d %s ",node.getLabel(),node.getData());
            formatter.flush();
            Save(node.left, formatter);
            Save(node.right, formatter);
        }
        catch(Exception e){
            System.err.println("Error");
        }
        
       
        
        
    }
    
    public void load(String name){
        
    }
    
    private Node insert(Node n, Node t){
        return null;
        
    }
    
}
