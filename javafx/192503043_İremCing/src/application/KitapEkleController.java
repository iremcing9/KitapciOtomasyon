package application;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.kitapciMySQL.Util.VeritabaniUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.*;

public class KitapEkleController {
	
	public KitapEkleController() {
		baglanti=VeritabaniUtil.Baglan();
	}
		
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_cikis;

    @FXML
    private Button btn_ekle;

    @FXML
    private Button btn_guncelle;

    @FXML
    private Button btn_sil;

    @FXML
    private Button btn_temizle;

    @FXML
    private TableColumn<Kitaplar, Double> tw_fiyat;

    @FXML
    private TableColumn<Kitaplar, Integer> tw_kID;

    @FXML
    private TableColumn<Kitaplar, String> tw_kitapadi;

    @FXML
    private TableColumn<Kitaplar, String> tw_kuldurum;

    @FXML
    private TableView<Kitaplar> tw_tablo;

    @FXML
    private TableColumn<Kitaplar, String> tw_tur;

    @FXML
    private TableColumn<Kitaplar, String> tw_yazar;

    @FXML
    private TextField txkuldurum;

    @FXML
    private TextField txt_fiyat;

    @FXML
    private TextField txt_ilanno;

    @FXML
    private TextField txt_kitapadi;

    @FXML
    private TextField txt_tur;

    @FXML
    private TextField txt_yazar;

    
    Connection baglanti = null;
    PreparedStatement sorguIfadesi = null;
    ResultSet getirilen=null;
    String sql;
    
    public void degerGetir(TableView tablo) {
    	sql= "select * from kitaplarim";
    	ObservableList<Kitaplar> kitaplarListe=FXCollections.observableArrayList();
    	
    	
    	try {
    		sorguIfadesi=baglanti.prepareStatement(sql);
			ResultSet getirilen=sorguIfadesi.executeQuery();
			
			while(getirilen.next()){
				kitaplarListe.add(new Kitaplar(getirilen.getInt("kitapID") ,getirilen.getString("kitapAdi"),getirilen.getString("tur"),getirilen.getString("kuldurum"),getirilen.getDouble("fiyat"), getirilen.getString("yazar")));
			}
			tw_kID.setCellValueFactory(new PropertyValueFactory<>("kitapID"));
			tw_kitapadi.setCellValueFactory(new PropertyValueFactory<>("kitapAdi"));
			tw_tur.setCellValueFactory(new PropertyValueFactory<>("tur"));
			tw_kuldurum.setCellValueFactory(new PropertyValueFactory<>("kuldurum"));
			tw_fiyat.setCellValueFactory(new PropertyValueFactory<>("fiyat"));
			tw_yazar.setCellValueFactory(new PropertyValueFactory<>("yazar"));
			
			tw_tablo.setItems(kitaplarListe);
		}
    	
       catch (Exception e) {
			// TODO: handle exception
		}
    
    }
    
    @FXML
    void Click_btncikis(ActionEvent event) {
    	try
    	{
    		
    		
        	Stage stage=new Stage();
    		AnchorPane pane1=(AnchorPane)FXMLLoader.load(getClass().getResource("YoneticiTercih.fxml"));
    		
    		Scene scene1=new Scene(pane1);
    		stage.setScene(scene1);
    		stage.show();
    		
			Stage stage1 = (Stage) btn_cikis.getScene().getWindow();
    	    stage1.close();
    		
    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }

    @FXML
    void Click_btnekle(ActionEvent event) {
    	sql = "insert into kitaplarim (kitapadi,tur,kuldurum,fiyat,yazar) values (?,?,?,?,?)";
        
        try {
        	
     	    sorguIfadesi=baglanti.prepareStatement(sql);
 			sorguIfadesi.setString(1,txt_kitapadi.getText().trim());
 			sorguIfadesi.setString(2,txt_tur.getText().trim());
 			sorguIfadesi.setString(3,txkuldurum.getText().trim());
 			sorguIfadesi.setString(4,txt_fiyat.getText().trim());
 			sorguIfadesi.setString(5,txt_yazar.getText().trim());
 			
 			
 			sorguIfadesi.executeUpdate();
 			
 			degerGetir(tw_tablo);
 			
     	    Alert alert=new Alert(AlertType.INFORMATION);
        	alert.setTitle("Cing Kitapevi");
        	alert.setHeaderText("Ürün eklendi");
        	alert.setContentText("Ekleme iþlemi baþarýyla gerçekleþtirildi");
        	alert.showAndWait();
     	   
 	} 
        catch (Exception e) {
 		// TODO: handle exception
 	}
    }

    @FXML
    void Click_btnguncelle(ActionEvent event) {
    	sql = "update kitaplarim set kitapadi=? , tur=? , kuldurum=? , fiyat=? , yazar=? where kitapID=?";
        
        try {
			sorguIfadesi=baglanti.prepareStatement(sql);
			sorguIfadesi.setString(1,txt_kitapadi.getText().trim());
			sorguIfadesi.setString(2,txt_tur.getText().trim());
			sorguIfadesi.setString(3,txkuldurum.getText().trim());
			sorguIfadesi.setString(4,txt_fiyat.getText().trim());
			sorguIfadesi.setString(5,txt_yazar.getText().trim());
			sorguIfadesi.setString(6,txt_ilanno.getText().trim());
			
			Alert alert=new Alert(AlertType.CONFIRMATION);
        	alert.setTitle("Cing Kitapevi");
        	alert.setHeaderText("Güncelleme yapmak istediðinize emin misiniz?");
        	alert.setContentText("Yapýlan deðiþiklikler kaydedilecek");
        	
        	
        	ButtonType btn1=new ButtonType("Evet");
        	ButtonType btn2=new ButtonType("Hayýr" , ButtonData.CANCEL_CLOSE);
        	
        	alert.getButtonTypes().setAll(btn1, btn2);
        	Optional<ButtonType> buton =alert.showAndWait();
        	
        	if(buton.get()==btn1) {
        		sorguIfadesi.executeUpdate();
			degerGetir(tw_tablo);
        	}
        	
		} 
        
        
        catch (Exception e) {
			// TODO: handle exception
		}
    }

    @FXML
    void Click_btnsil(ActionEvent event) {
      
          sql="delete from kitaplarim where kitapID=?";
        
        try {
     	    sorguIfadesi=baglanti.prepareStatement(sql);
     	    sorguIfadesi.setString(1, txt_ilanno.getText().trim());
     	
     	Alert alert=new Alert(AlertType.CONFIRMATION);
       	alert.setTitle("Cing Kitapevi");
       	alert.setHeaderText("Silmek istediðinize emin misiniz?");
       	alert.setContentText("Yapýlan deðiþiklikler kaydedilecek");
       	
       	
       	ButtonType btn1=new ButtonType("Evet");
       	ButtonType btn2=new ButtonType("Hayýr" , ButtonData.CANCEL_CLOSE);
       	
       	alert.getButtonTypes().setAll(btn1, btn2);
       	Optional<ButtonType> buton =alert.showAndWait();
       	
       	if(buton.get()==btn1) {
       		sorguIfadesi.executeUpdate();
			degerGetir(tw_tablo);
       	}
 	} 
        catch (Exception e) {
 		// TODO: handle exception
 	}
    }

    @FXML
    void click_btntemizle(ActionEvent event) {
    	txt_kitapadi.clear();
        txt_tur.clear();
        txkuldurum.clear();
        txt_fiyat.clear();
        txt_yazar.clear();
        txt_ilanno.clear();
    }

    @FXML
    void tw_mouseclick(MouseEvent event) {
    	 Kitaplar kitap = new Kitaplar();
         kitap=(Kitaplar) tw_tablo.getItems().get(tw_tablo.getSelectionModel().getSelectedIndex());
         txt_ilanno.setText(String.valueOf(kitap.getKitapID()));
         txt_kitapadi.setText(kitap.getKitapAdi());
         txt_tur.setText(kitap.getTur());
         txkuldurum.setText(kitap.getKuldurum());
         txt_fiyat.setText(String.valueOf(kitap.getFiyat()));
         txt_yazar.setText(kitap.getYazar());
    }

    @FXML
    void initialize() {
    	
        degerGetir(tw_tablo);
    }

}
