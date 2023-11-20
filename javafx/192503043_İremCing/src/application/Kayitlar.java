package application;

public class Kayitlar {
    private int kulID;
    private String ad;
    private String soyad;
    private String kullaniciAdi;
    private String sifre;
    private String email;
    private String telno;
    private String adres;
    
	Kayitlar(){
		
	}
	
	Kayitlar(int kulID , String ad , String soyad , String kullaniciAdi , String sifre , String email , String telno , String adres)
	{
		this.kulID=kulID;
		this.ad=ad;
		this.soyad=soyad;
		this.kullaniciAdi=kullaniciAdi;
		this.sifre=sifre;
		this.email=email;
		this.telno=telno;
		this.adres=adres;
	}

	public int getKulID() {
		return kulID;
	}

	public void setKulID(int kulID) {
		this.kulID = kulID;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public String getKullaniciAdi() {
		return kullaniciAdi;
	}

	public void setKullaniciAdi(String kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}

	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelno() {
		return telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}
}
