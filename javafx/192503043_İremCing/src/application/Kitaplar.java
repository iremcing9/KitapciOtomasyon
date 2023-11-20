package application;

public class Kitaplar {
    private int kitapID;
    private String kitapAdi;
    private String tur;
    private String kuldurum;
    private double fiyat;
    private String yazar;
    
    Kitaplar(){
    	
    }
    
    Kitaplar(int kitapID, String kitapAdi , String tur , String kuldurum , double fiyat, String yazar){
    	
    	this.kitapID=kitapID;
    	this.kitapAdi=kitapAdi;
    	this.tur=tur;
    	this.kuldurum=kuldurum;
    	this.fiyat=fiyat;
    	this.yazar=yazar;
    			
    	
    }
   

	public int getKitapID() {
		return kitapID;
	}

	public void setKitapID(int kitapID) {
		this.kitapID = kitapID;
	}

	public String getKitapAdi() {
		return kitapAdi;
	}

	public void setKitapAdi(String kitapAdi) {
		this.kitapAdi = kitapAdi;
	}

	public String getTur() {
		return tur;
	}

	public void setTur(String tur) {
		this.tur = tur;
	}

	public String getKuldurum() {
		return kuldurum;
	}

	public void setKuldurum(String kuldurum) {
		this.kuldurum = kuldurum;
	}

	public double getFiyat() {
		return fiyat;
	}

	public void setFiyat(double fiyat) {
		this.fiyat = fiyat;
	}

	public String getYazar() {
		return yazar;
	}

	public void setYazar(String yazar) {
		this.yazar = yazar;
	}
	
}
