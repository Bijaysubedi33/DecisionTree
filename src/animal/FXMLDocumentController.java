package animal;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;

/**
 * FXML Controller class
 *
 * @author Bijay Subedi 12127892 
 * This java class is used to control the UI functionality
 * 
 */
public class FXMLDocumentController implements Initializable, IView{

    //text area for the gui
    @FXML
    private TextArea textArea;

    //load button that is use to load the text file
    @FXML
    private Button load;

    //save button that is used to save the tree in a file
    @FXML
    private Button save;

    //display button that is used to display the tree in the textarea
    @FXML
    private Button display;

    //play button to play the game
    @FXML
    private Button play;

    //exit button to exit the game
    @FXML
    private Button exit;
    
    
    private Game game;

    //This method will show what is done when display is clicked. It runs display from game class
    //and display the tree
    @FXML
    void displayAction(ActionEvent event) {
         display(game.display());
    }

    //when exit button is clicked this method will exit the game
    @FXML
    void exitAction(ActionEvent event) {

        System.exit(0);
    }

    //used to load files 
    @FXML
    void loadAction(ActionEvent event) {
        
        display("Load: Under Development ");
    }

    //use to play the game 
   @FXML
    void playAction(ActionEvent event) {
        
        game.play();
        
    }

    //use to save the tree in text file called animal.txt
    @FXML
    void saveAction(ActionEvent event) {
        game.save("animal.txt");
        
        
    }
  
   
    public void bind(Game game){
        //pass the reference of game
        this.game = game;
        
        
    }
    
    //use to display the string in text area
    @Override
    public void display(String s) {
       
        textArea.setText(s);
        
    }

    //use for appending text in text area
    @Override
    public void append(String s) {
        textArea.appendText(s);
    }

    //used for asking player questions
    @Override
    public String ask(String question) {
        TextInputDialog tid = new TextInputDialog("");
        tid.setHeaderText(question);
        // Block execution until the user responds
        tid.showAndWait();
        return tid.getEditor().getText();

    }

    //players choice will determine whether to add left tree or right
    @Override
    public boolean choose(String question) {
        String r = choose(question, "Yes", "No");
        if (r.equals("Yes"))
            return true;
        return false;

    }

    //players choice will determine whether to add left tree or right
    @Override
    public String choose(String question, String choice1, String choice) {
        ButtonType b1 = new ButtonType( choice1 );
        ButtonType b2 = new ButtonType( choice );
        Alert alert = new Alert(Alert.AlertType.NONE, question, b1, b2 );
        alert.setTitle( "Choose" );
        // Block execution until the user responds
        java.util.Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == b1 )
            return choice1;
        return choice;

    }
    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    

}
