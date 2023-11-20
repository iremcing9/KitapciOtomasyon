package application;

public class Sepetim {
	    
	    
	    public int getSepetID1() {
			return sepetID1;
		}

		public void setSepetID1(int sepetID1) {
			this.sepetID1 = sepetID1;
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
		
		private int sepetID1;
		private String kitapAdi;
	    private String tur;
	    private String kuldurum;
	    private double fiyat;
	    private String yazar;
	    
	    Sepetim(){
	    	
	    }
	    
	    Sepetim(int sepetID, String kitapAdi , String tur , String kuldurum , double fiyat, String yazar){
	    	
	    	this.sepetID1=sepetID;
	    	this.kitapAdi=kitapAdi;
	    	this.tur=tur;
	    	this.kuldurum=kuldurum;
	    	this.fiyat=fiyat;
	    	this.yazar=yazar;
	    			
	    	
	    }
}