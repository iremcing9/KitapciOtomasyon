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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class kitapArController {

	public kitapArController(){
   	 baglanti=VeritabaniUtil.Baglan();
 	 
    }
	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private AnchorPane anchor_ara;

    @FXML
    private Button btn_ara;

    @FXML
    private Button btn_cikis;

    @FXML
    private Button btn_sepetegit;

    @FXML
    private Button btn_sepetekle;
    
    @FXML
    private Button btn_temizle;

    @FXML
    private RadioButton radio_fiyat;

    @FXML
    private RadioButton radio_kuldurum;

    @FXML
    private RadioButton radio_tur;
    
    @FXML
    private RadioButton radio_yazar;

    @FXML
    private TableView<Kitaplar> tableview;

    @FXML
    private TableColumn<Kitaplar, Double> tw_fiyat;

    @FXML
    private TableColumn<Kitaplar, String> tw_kitapadi;

    @FXML
    private TableColumn<Kitaplar, String> tw_kuldurum;

    @FXML
    private TableColumn<Kitaplar, String> tw_tur;

    @FXML
    private TableColumn<Kitaplar, String> tw_yazar;

    @FXML
    private TextField txt_ara;
    
    Connection baglanti = null;
    PreparedStatement sorguIfadesi = null;
    ResultSet getirilen=null;
    String sql;
    
    public void degerGetir(TableView tablo , String sql) {
    	
    	ObservableList<Kitaplar> kitaplarListe=FXCollections.observableArrayList();
     	try {
    		sorguIfadesi=baglanti.prepareStatement(sql);
			ResultSet getirilen=sorguIfadesi.executeQuery();
			
			while(getirilen.next()){
				kitaplarListe.add(new Kitaplar(getirilen.getInt("kitapID") ,getirilen.getString("kitapAdi"),getirilen.getString("tur"),getirilen.getString("kuldurum"),getirilen.getDouble("fiyat"), getirilen.getString("yazar")));
			}
			
			tw_kitapadi.setCellValueFactory(new PropertyValueFactory<>("kitapAdi"));
			tw_tur.setCellValueFactory(new PropertyValueFactory<>("tur"));
			tw_kuldurum.setCellValueFactory(new PropertyValueFactory<>("kuldurum"));
			tw_fiyat.setCellValueFactory(new PropertyValueFactory<>("fiyat"));
			tw_yazar.setCellValueFactory(new PropertyValueFactory<>("yazar"));
			
			tableview.setItems(kitaplarListe);
		}
     	
    	
       catch (Exception e) {
			// TODO: handle exception
		}
    }
    
public void degerGetir1(TableView tablo) {
    	sql="select * from kitaplarim";
    	ObservableList<Kitaplar> kitaplarListe=FXCollections.observableArrayList();
     	try {
    		sorguIfadesi=baglanti.prepareStatement(sql);
			ResultSet getirilen=sorguIfadesi.executeQuery();
			
			while(getirilen.next()){
				kitaplarListe.add(new Kitaplar(getirilen.getInt("kitapID") ,getirilen.getString("kitapAdi"),getirilen.getString("tur"),getirilen.getString("kuldurum"),getirilen.getDouble("fiyat"), getirilen.getString("yazar")));
			}
			
			tw_kitapadi.setCellValueFactory(new PropertyValueFactory<>("kitapAdi"));
			tw_tur.setCellValueFactory(new PropertyValueFactory<>("tur"));
			tw_kuldurum.setCellValueFactory(new PropertyValueFactory<>("kuldurum"));
			tw_fiyat.setCellValueFactory(new PropertyValueFactory<>("fiyat"));
			tw_yazar.setCellValueFactory(new PropertyValueFactory<>("yazar"));
			
			tableview.setItems(kitaplarListe);
		}
    	
       catch (Exception e) {
			// TODO: handle exception
		}
    }

    @FXML
    void Click_btn_sepetegit(ActionEvent event) {
    	try
    	{
    		Alert alert=new Alert(AlertType.INFORMATION);
        	alert.setTitle("Cing Kitapevi");
        	alert.setHeaderText("Alýþ veriþi tamamlamak istediðinize emin misiniz?");
        	alert.setContentText("Sepete yönlendirileceksiniz");
        	alert.showAndWait();
    		
        	Stage stage=new Stage();
    		AnchorPane pane1=(AnchorPane)FXMLLoader.load(getClass().getResource("SepeteEkle.fxml"));
    		
    		Scene scene1=new Scene(pane1);
    		stage.setScene(scene1);
    		stage.show();
    		
			Stage stage1 = (Stage) btn_sepetegit.getScene().getWindow();
    	    stage1.close();
    		
    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }

    @FXML
    void Click_btnara(ActionEvent event) {
         try {
        	 
			if(txt_ara.getText()!="") {
				if(radio_tur.isSelected()) {
					sql="select * from kitaplarim where tur like '%" + txt_ara.getText() +"%' order by tur ASC";
					degerGetir(tableview,sql);
				}
				else if (radio_kuldurum.isSelected()) {
					sql="select * from kitaplarim where kuldurum like '%" + txt_ara.getText() +"%' order by kuldurum ASC";
					degerGetir(tableview,sql);
				}
				else if(radio_fiyat.isSelected()) {
					sql="select * from kitaplarim where fiyat>="+ txt_ara.getText();
					degerGetir(tableview,sql);
				}
				else if(radio_yazar.isSelected()) {
					sql="select * from kitaplarim where yazar like '%" + txt_ara.getText() +"%' order by yazar ASC";
					degerGetir(tableview,sql);
				}
			}
        	 
        	 
        	 
		} catch (Exception e) {
			// TODO: handle exception
		}
    }

    @FXML
    void Click_btncikis(ActionEvent event) {
    	try
    	{
    		
    		AnchorPane pane1 = (AnchorPane)FXMLLoader.load(getClass().getResource("Kitapci.fxml"));
  			anchor_ara.getChildren().setAll(pane1); 
    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }

    @FXML
    void Click_btntemizle(ActionEvent event) {
         txt_ara.clear();
         degerGetir1(tableview);
    }
    
    
    @FXML
    void Click_radiofiyat(ActionEvent event) {

    }

    @FXML
    void Click_radiokuldurum(ActionEvent event) {

    }

    @FXML
    void Click_radiotur(ActionEvent event) {

    }
    
    @FXML
    void Click_radioyazar(ActionEvent event) {

    }

    @FXML
    void btnsepetekle_Click(ActionEvent event) {
         sql = "insert into sepet (sepetID1,kitapAdi,tur,kuldurum,fiyat,yazar) values (?,?,?,?,?,?)";
        
        try {
        	
     	    sorguIfadesi=baglanti.prepareStatement(sql);
     	    sorguIfadesi.setInt(1,tableview.getSelectionModel().getSelectedItem().getKitapID());
 			sorguIfadesi.setString(2,tableview.getSelectionModel().getSelectedItem().getKitapAdi());
 			sorguIfadesi.setString(3,tableview.getSelectionModel().getSelectedItem().getTur());
 			sorguIfadesi.setString(4,tableview.getSelectionModel().getSelectedItem().getKuldurum());
 			sorguIfadesi.setDouble(5,tableview.getSelectionModel().getSelectedItem().getFiyat());
 			sorguIfadesi.setString(6,tableview.getSelectionModel().getSelectedItem().getYazar());
 			
 			
 			sorguIfadesi.executeUpdate();
 			
 			degerGetir(tableview , sql);
 			
     	    
     	   
 	} 
        catch (Exception e) {
 		// TODO: handle exception
 	}
    	    Alert alert=new Alert(AlertType.INFORMATION);
        	alert.setTitle("Cing Kitapevi");
        	alert.setHeaderText("Ürün eklendi");
        	alert.setContentText("Ekleme iþlemi baþarýyla gerçekleþtirildi");
        	alert.showAndWait();
    	
    	
    	
    }

    @FXML
    void tableview_Click(MouseEvent event) {

    }

    @FXML
    void initialize() {
       sql= "select * from kitaplarim";
       degerGetir(tableview, sql);
       
       ToggleGroup grup=new ToggleGroup();
       radio_fiyat.setToggleGroup(grup);
       radio_kuldurum.setToggleGroup(grup);
       radio_tur.setToggleGroup(grup);
       radio_yazar.setToggleGroup(grup);
       
       
       
    }

}

