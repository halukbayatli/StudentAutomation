package Package;

public class Ders {
	private int bolNo;
	private String dersAd;
	
	public Ders(int newBolNo,String newDersAd) {
		this.bolNo = newBolNo;
		this.dersAd = newDersAd;
	}

	public int getBolNo() {
		return bolNo;
	}

	public String getDersAd() {
		return dersAd;
	}
}