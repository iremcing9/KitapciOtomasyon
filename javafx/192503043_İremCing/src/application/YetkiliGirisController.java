package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.kitapciMySQL.Util.VeritabaniUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class YetkiliGirisController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
   

    @FXML
    private AnchorPane anchorpanegiris;
    
    @FXML
    private AnchorPane anchorpanegirisye;
    
    @FXML
    private AnchorPane anchoryetkiligiris;

    @FXML
    private Button btn_cýkýs;

    @FXML
    private Button btn_yetkiligiris;

    @FXML
    private TextField txt_kullaniciadi;

    @FXML
    private TextField txt_sifre;

    Connection baglanti = null;
    PreparedStatement sorguIfadesi = null;
    ResultSet getirilen=null;
    String sql;
    
    public YetkiliGirisController() {
    	baglanti=VeritabaniUtil.Baglan();
    }
    
    
    
    @FXML
    void btn_yetkiligiris_Click(ActionEvent event) {
    	sql= "select*from yetkili where yoneticiad=? and yoneticisifre=?";
    	
    	try
    	{
    		sorguIfadesi=baglanti.prepareStatement(sql);
    	    sorguIfadesi.setString(1,txt_kullaniciadi.getText().trim());
    	    sorguIfadesi.setString(2,VeritabaniUtil.MD5Sifrele(txt_sifre.getText().trim()));
    	   
    	    ResultSet getirilen=sorguIfadesi.executeQuery();
    	    
    	    if(!getirilen.next() ) {
    	        Alert alert=new Alert(AlertType.ERROR);
            	alert.setTitle("Cing Kitapevi");
            	alert.setHeaderText("Hatalý veya eksik giriþ yaptýnýz");
            	alert.setContentText("Yalnýzca yönetici eriþebilir.");
            	alert.showAndWait();
    	    	
    	    }
    	    else {
    	    	Stage stage=new Stage();
    		AnchorPane pane1=(AnchorPane)FXMLLoader.load(getClass().getResource("YoneticiTercih.fxml"));
    		
    		Scene scene1=new Scene(pane1);
    		stage.setScene(scene1);
    		stage.show();
    		
			Stage stage1 = (Stage) btn_yetkiligiris.getScene().getWindow();
    	    stage1.close();
    	    	
    	    	
    	    }
        	
    		
    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }

    @FXML
    void btncýkýs_Click(ActionEvent event) {
    	try
    	{
    		
    		
        	Stage stage=new Stage();
    		AnchorPane pane1=(AnchorPane)FXMLLoader.load(getClass().getResource("GirisFormu.fxml"));
    		
    		Scene scene1=new Scene(pane1);
    		stage.setScene(scene1);
    		stage.show();
    		
			Stage stage1 = (Stage) btn_cýkýs.getScene().getWindow();
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
