package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.kitapciMySQL.Util.VeritabaniUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.sql.*;

public class UyeListelemeController {
     
	public UyeListelemeController(){
    	 baglanti=VeritabaniUtil.Baglan();
  	 
     }
	
	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_iptal;

    @FXML
    private TableColumn<Kayitlar, String> tw_ad;

    @FXML
    private TableColumn<Kayitlar, String> tw_adres;
  
    @FXML
    private TableColumn<Kayitlar, String> tw_email;

    @FXML
    private TableColumn<Kayitlar, Integer> tw_kulID;

    @FXML
    private TableColumn<Kayitlar, String> tw_kuladi;

    @FXML
    private TableColumn<Kayitlar, String> tw_sifre;

    @FXML
    private TableColumn<Kayitlar, String> tw_soyad;

    @FXML
    private TableColumn<Kayitlar, String> tw_telno;

    @FXML
    private TableView<Kayitlar> tw_uyeler;
    
    
    Connection baglanti = null;
    PreparedStatement sorguIfadesi = null;
    ResultSet getirilen=null;
    String sql;
    
    public void degerGetir(TableView tablo, String sql) {
    	
    	ObservableList<Kayitlar> KayitlarListe=FXCollections.observableArrayList();
    	
    	try {
			sorguIfadesi=baglanti.prepareStatement(sql);
			ResultSet getirilen=sorguIfadesi.executeQuery();
			
			while(getirilen.next()) {
				KayitlarListe.add(new Kayitlar(getirilen.getInt("kulID"),getirilen.getString("ad"),getirilen.getString("soyad"),getirilen.getString("kullaniciAdi"),getirilen.getString("sifre"),getirilen.getString("email"),getirilen.getString("telno"), getirilen.getString("adres")));
			}
			tw_kulID.setCellValueFactory(new PropertyValueFactory<>("kulID"));
			tw_ad.setCellValueFactory(new PropertyValueFactory<>("ad"));
			tw_soyad.setCellValueFactory(new PropertyValueFactory<>("soyad"));
			tw_kuladi.setCellValueFactory(new PropertyValueFactory<>("kullaniciAdi"));
			tw_sifre.setCellValueFactory(new PropertyValueFactory<>("sifre"));
			tw_email.setCellValueFactory(new PropertyValueFactory<>("email"));
			tw_telno.setCellValueFactory(new PropertyValueFactory<>("telno"));
			tw_adres.setCellValueFactory(new PropertyValueFactory<>("adres"));

			tw_uyeler.setItems(KayitlarListe);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
    }
    
    @FXML
    void Click_btniptal(ActionEvent event) {
    	try
    	{
    		Stage stage=new Stage();
    		AnchorPane pane1=(AnchorPane)FXMLLoader.load(getClass().getResource("YoneticiTercih.fxml"));
    		
    		Scene scene1=new Scene(pane1);
    		stage.setScene(scene1);
    		stage.show();
    		
			Stage stage1 = (Stage) btn_iptal.getScene().getWindow();
    	    stage1.close();
    		
    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }

    @FXML
    void Click_twuyeler(MouseEvent event) {

    }

    @FXML
    void initialize() {
      sql="select*from uyelik";
      degerGetir(tw_uyeler,sql);
    }

}

