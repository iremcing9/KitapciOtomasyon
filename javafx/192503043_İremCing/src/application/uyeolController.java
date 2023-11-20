package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.kitapciMySQL.Util.VeritabaniUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.sql.*;

public class uyeolController {
	
	public uyeolController() {
		baglanti=VeritabaniUtil.Baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private AnchorPane anchor_kayit;

    @FXML
    private Button btn_iptal;

    @FXML
    private Button btn_uyeol;

    @FXML
    private DatePicker datepicker;

    @FXML
    private TextField txt_ad;

    @FXML
    private TextField txt_adres;

    @FXML
    private TextField txt_email;

    @FXML
    private TextField txt_kuladi;

    @FXML
    private TextField txt_sifre;

    @FXML
    private TextField txt_soyad;

    @FXML
    private TextField txt_telefon;

    Connection baglanti = null;
    PreparedStatement sorguIfadesi = null;
    ResultSet getirilen=null;
    String sql;
    
    
    @FXML
    void Click_btn_iptal(ActionEvent event) {
    	
    	try
    	{
    		Alert alert=new Alert(AlertType.WARNING);
        	alert.setTitle("Cing Kitapevi");
        	alert.setHeaderText("Çýkmak istediðinize emin misiniz?");
        	alert.setContentText("Giriþ ekranýna yönlendirileceksiniz.");
        	alert.showAndWait();
    		
        
        	AnchorPane pane1 = (AnchorPane)FXMLLoader.load(getClass().getResource("Kitapci.fxml"));
  			anchor_kayit.getChildren().setAll(pane1); 
    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }

    @FXML
    void Click_btn_uyeol(ActionEvent event) {
    	sql= "insert into uyelik(ad, soyad, kullaniciAdi, sifre , email , telno , adres) values(?,?,?,?,?,?,?)";
    	try {
    	    if (txt_ad.getText().isEmpty() || txt_soyad.getText().isEmpty() || txt_kuladi.getText().isEmpty() || VeritabaniUtil.MD5Sifrele(txt_sifre.getText()).isEmpty() || txt_email.getText().isEmpty() || txt_telefon.getText().isEmpty() || txt_adres.getText().isEmpty())
    	    {
    	    	
    	    	Alert alert=new Alert(AlertType.ERROR);
            	alert.setTitle("Cing Kitapevi");
            	alert.setHeaderText("Alan boþ geçilemez");
            	alert.setContentText("Boþ alanlarý doldurunuz.");
            	alert.showAndWait();
    	    }
    	    else{
    	    	sorguIfadesi = baglanti.prepareStatement(sql);
    	   sorguIfadesi.setString(1,txt_ad.getText().trim());
    	   sorguIfadesi.setString(2,txt_soyad.getText().trim());
    	   sorguIfadesi.setString(3,txt_kuladi.getText().trim());
    	   sorguIfadesi.setString(4,VeritabaniUtil.MD5Sifrele(txt_sifre.getText().trim()));
    	   sorguIfadesi.setString(5,txt_email.getText().trim());
    	   sorguIfadesi.setString(6,txt_telefon.getText().trim());
    	   
    	   sorguIfadesi.setString(7,txt_adres.getText().trim());
    	   sorguIfadesi.executeUpdate();
    	   
    	  
    		Alert alert=new Alert(AlertType.INFORMATION);
        	alert.setTitle("Cing Kitapevi");
        	alert.setHeaderText("Üyelik baþarý ile oluþturuldu");
        	alert.setContentText("Giriþ ekranýna yönlendirileceksiniz.");
        	alert.showAndWait();
    	   
        	AnchorPane pane1 = (AnchorPane)FXMLLoader.load(getClass().getResource("Kitapci.fxml"));
  			anchor_kayit.getChildren().setAll(pane1); 
    	    }
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


