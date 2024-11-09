package Package;

public class Bolum {
	private int bolNo;
	private String bolAd;
	public Ogrenci[] ogrenciler;
	public TeorikDers[] teorikDersler;
	public PratikDers[] pratikDersler;
	
	public Bolum(int newBolNo, String newBolAd) {
		this.bolNo = newBolNo;
		this.bolAd = newBolAd;
	}

	public int getBolNo() {
		return bolNo;
	}

	public void setBolNo(int bolNo) {
		this.bolNo = bolNo;
	}

	public String getBolAd() {
		return bolAd;
	}

	public void setBolAd(String bolAd) {
		this.bolAd = bolAd;
	}
}