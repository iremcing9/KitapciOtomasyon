package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class YoneticiTercihController {

    @FXML
    private ResourceBundle resources;
    
    @FXML
    private AnchorPane anchor_ayar;


    @FXML
    private URL location;

    @FXML
    private Button btn_cikis;

    @FXML
    private Button btn_duzenle;

    @FXML
    private Button btn_kulduzenle;

    @FXML
    void Click_btncikis(ActionEvent event) {
    	try
    	{
    		
       
    		AnchorPane pane1 = (AnchorPane)FXMLLoader.load(getClass().getResource("Kitapci.fxml"));
  			anchor_ayar.getChildren().setAll(pane1); 
    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }

    @FXML
    void Click_btnduzenle(ActionEvent event) {
    	try
    	{
    	
    		Stage stage=new Stage();
    		AnchorPane pane1=(AnchorPane)FXMLLoader.load(getClass().getResource("KitapEkle.fxml"));
    		
    		Scene scene1=new Scene(pane1);
    		stage.setScene(scene1);
    		stage.show();
    		
			Stage stage1 = (Stage) btn_duzenle.getScene().getWindow();
    	    stage1.close();
    		
    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }

    @FXML
    void Click_btnkulduzenle(ActionEvent event) {
    	try
    	{
    		    		
        	Stage stage=new Stage();
    		AnchorPane pane1=(AnchorPane)FXMLLoader.load(getClass().getResource("UyeListeleme.fxml"));
    		
    		Scene scene1=new Scene(pane1);
    		stage.setScene(scene1);
    		stage.show();
    		
			Stage stage1 = (Stage) btn_kulduzenle.getScene().getWindow();
    	    stage1.close();
    		
    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }

    @FXML
    void initialize() {
        
    }

}
