package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.kitapciMySQL.Util.VeritabaniUtil;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.sql.*;

public class GirisFormuController {

	Connection baglanti = null;
    PreparedStatement sorguIfadesi = null;
    ResultSet getirilen=null;
    String sql;
    
    public GirisFormuController() {
   	 baglanti=VeritabaniUtil.Baglan();
   	 
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchor_dýs;

    @FXML
    private AnchorPane anchor_ic;

    @FXML
    private AnchorPane anchor_yetkili;

    @FXML
    private Button btn_cýkýs;

    @FXML
    private Button btn_girisyap;

    @FXML
    private Button btn_uyeol;

    @FXML
    private Button btn_yetkiligiris;

    @FXML
    private Button btn_yetkiligiris1;

    @FXML
    private TextField txt_kullaniciadi;

    @FXML
    private TextField txt_kullaniciadi1;

    @FXML
    private PasswordField txt_sifre;

    @FXML
    private PasswordField txt_sifre1;

    @FXML
    void btn_yetkiligiris1_Click(ActionEvent event) {
     sql= "select*from yetkili where yoneticiad=? and yoneticisifre=?";
    	
    	try
    	{
    		sorguIfadesi=baglanti.prepareStatement(sql);
    	    sorguIfadesi.setString(1,txt_kullaniciadi1.getText().trim());
    	    sorguIfadesi.setString(2,VeritabaniUtil.MD5Sifrele(txt_sifre1.getText().trim()));
    	   
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
    void btn_yetkiligiris_Click(ActionEvent event) {
    	try
    	{
    		TranslateTransition tt =new TranslateTransition(Duration.seconds(0.5),anchor_yetkili);
    		tt.setByX(-920);
    		tt.play();
    		
    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }

    @FXML
    void btnclick_girisyap(ActionEvent event) {
      sql= "select*from uyelik where kullaniciAdi=? and sifre=?";
    	
    	
    	
    	try
    	{   sorguIfadesi=baglanti.prepareStatement(sql);
    	    sorguIfadesi.setString(1,txt_kullaniciadi.getText().trim());
    	    sorguIfadesi.setString(2,VeritabaniUtil.MD5Sifrele(txt_sifre.getText().trim()));
    	   
    	    ResultSet getirilen=sorguIfadesi.executeQuery();
    	    
    	    if(!getirilen.next()) {
    	    Alert alert=new Alert(AlertType.ERROR);
        	alert.setTitle("Cing Kitapevi");
        	alert.setHeaderText("Hatalý giriþ yaptýnýz.");
        	alert.setContentText("Kullanýcý adý veya þifre hatalý.");
        	alert.showAndWait();
    	    }
    	    else {
    	    	Stage stage=new Stage();
    		AnchorPane pane1=(AnchorPane)FXMLLoader.load(getClass().getResource("kitapAr.fxml"));
    		
    		Scene scene1=new Scene(pane1);
    		stage.setScene(scene1);
    		stage.show();
    		
			Stage stage1 = (Stage) btn_girisyap.getScene().getWindow();
    	    stage1.close();
    	    }
    		
    		
        	
    		
    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }

    @FXML
    void btnclick_uyeol(ActionEvent event) {
    	try
    	{
    		
    		
        	Stage stage=new Stage();
    		AnchorPane pane1=(AnchorPane)FXMLLoader.load(getClass().getResource("uyeol.fxml"));
    		
    		Scene scene1=new Scene(pane1);
    		stage.setScene(scene1);
    		stage.show();
    		
			Stage stage1 = (Stage) btn_uyeol.getScene().getWindow();
    	    stage1.close();
    		
    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }

    @FXML
    void btncýkýs_Click(ActionEvent event) {
    	 try {
 			
    		 TranslateTransition tt =new TranslateTransition(Duration.seconds(0.5),anchor_yetkili);
     		tt.setByX(+920);
     		tt.play();
 			
 		} catch (Exception e) {
 			
 		}
    }

    @FXML
    void initialize() {
       
    }

}

