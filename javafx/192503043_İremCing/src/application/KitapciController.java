package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;


public class KitapciController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchor_ana;

    @FXML
    private AnchorPane anchor_ana1;

    @FXML
    void initialize() {
    	 try {
  			AnchorPane pane1 = (AnchorPane)FXMLLoader.load(getClass().getResource("GirisFormu.fxml"));
  			anchor_ana1.getChildren().setAll(pane1); 
     		
  			
  		} catch (Exception e) {
  			
  		}

    }

}
