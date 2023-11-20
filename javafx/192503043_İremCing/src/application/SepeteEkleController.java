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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

public class SepeteEkleController {
	
	Connection baglanti = null;
    PreparedStatement sorguIfadesi = null;
    ResultSet getirilen=null;
    String sql;
	
    public SepeteEkleController() {
      	 baglanti=VeritabaniUtil.Baglan();
      	 
       }
	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_devam;

    @FXML
    private Button btn_tamamla;
    
    @FXML
    private Button btn_temizle;

    @FXML
    private TableView<Sepetim> tableview;
    
    @FXML
    private TableColumn<Sepetim, Integer> sepetID1;
    
    @FXML
    private TableColumn<Sepetim, Double> tw_fiyat;

    @FXML
    private TableColumn<Sepetim, String> tw_kitapadi;

    @FXML
    private TableColumn<Sepetim, String> tw_kuldurum;

    @FXML
    private TableColumn<Sepetim, String> tw_tur;

    @FXML
    private TableColumn<Sepetim, String> tw_yazar;
    
    public void degerGetir(TableView tablo , String sql) {
    	sql="select * from sepet";
    	ObservableList<Sepetim> sepetListe=FXCollections.observableArrayList();
     	try {
    		sorguIfadesi=baglanti.prepareStatement(sql);
			ResultSet getirilen=sorguIfadesi.executeQuery();
			
			while(getirilen.next()){
				sepetListe.add(new Sepetim(getirilen.getInt("sepetID1") ,getirilen.getString("kitapAdi"),getirilen.getString("tur"),getirilen.getString("kuldurum"),getirilen.getDouble("fiyat"), getirilen.getString("yazar")));
			}
			
			tw_kitapadi.setCellValueFactory(new PropertyValueFactory<>("kitapAdi"));
			tw_tur.setCellValueFactory(new PropertyValueFactory<>("tur"));
			tw_kuldurum.setCellValueFactory(new PropertyValueFactory<>("kuldurum"));
			tw_fiyat.setCellValueFactory(new PropertyValueFactory<>("fiyat"));
			tw_yazar.setCellValueFactory(new PropertyValueFactory<>("yazar"));
			
			tableview.setItems(sepetListe);
		}
    	
       catch (Exception e) {
			// TODO: handle exception
		}
    }

    @FXML
    void Click_btndevam(ActionEvent event) {
    	try
    	{
    		
        	Stage stage=new Stage();
    		AnchorPane pane1=(AnchorPane)FXMLLoader.load(getClass().getResource("kitapAr.fxml"));
    		
    		Scene scene1=new Scene(pane1);
    		stage.setScene(scene1);
    		stage.show();
    		
			Stage stage1 = (Stage) btn_devam.getScene().getWindow();
    	    stage1.close();
    		
    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }

    @FXML
    void Click_btntamamla(ActionEvent event) {
    	try
    	{
    		Alert alert=new Alert(AlertType.WARNING);
        	alert.setTitle("Cing Kitapevi");
        	alert.setHeaderText("Alýþ veriþinizi sonlandýrmak istediðinize emin misiniz?");
        	alert.setContentText("Program kapatýlacak.");
        	alert.showAndWait();
    		
        	
    		
			Stage stage1 = (Stage) btn_tamamla.getScene().getWindow();
    	    stage1.close();
    		
    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    @FXML
    void Click_btntemizle(ActionEvent event) {
      sql = "delete from sepet where sepetID1=?";
    	     try {
				sorguIfadesi=baglanti.prepareStatement(sql);
				sorguIfadesi.setInt(1,tableview.getSelectionModel().getSelectedItem().getSepetID1());
	 			sorguIfadesi.executeUpdate();
	 			
	 			degerGetir(tableview , sql);
				
			} catch (Exception e) {
			System.out.println(e.getMessage().toString());
			}
    	
    	
    	
     	    Alert alert=new Alert(AlertType.INFORMATION);
         	alert.setTitle("Cing Kitapevi");
         	alert.setHeaderText("Ürün Silindi.");
         	alert.setContentText("Alýþ veriþe devam etmek için butona týklayýn.");
         	alert.showAndWait();
     	
     	
      
    }

    @FXML
    void tableview_Click(MouseEvent event) {

    }
    
    @FXML
    void initialize() {

    	
       degerGetir(tableview , sql);
    }

}
