package Package;

public class Ogrenci {
	private int bolNo;
	private static int ogrCount = 0;
	private int ogrID;
	private String ogrAd;
	private String ogrSoyad;
	private int ogrSinif;
	
	public Ogrenci(int newBolNo,String newOgrAd, String newOgrSoyad, int newOgrSinif) {
		this.ogrID = ++ogrCount;
		this.bolNo = newBolNo;
		this.ogrAd = newOgrAd;
		this.ogrSoyad = newOgrSoyad;
		this.ogrSinif = newOgrSinif;
	}

	public int getBolNo() {
		return bolNo;
	}

	public int getOgrID() {
		return ogrID;
	}

	public String getOgrAd() {
		return ogrAd;
	}

	public String getOgrSoyad() {
		return ogrSoyad;
	}

	public int getOgrSinif() {
		return ogrSinif;
	}
}