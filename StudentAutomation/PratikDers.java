package Package;

public class PratikDers extends Ders {
	private static int dersIDCounter = 0;
	private int dersID;
	private int dersKredi;
	private static String durum = "Pratik";
	
	public PratikDers(int newBolNo, String newDersAd, int dersKredi) {
		super(newBolNo, newDersAd);
		this.dersID = ++dersIDCounter;
		this.dersKredi = dersKredi;
		this.durum = durum;
	}

	public int getDersID() {
		return dersID;
	}

	public int getDersKredi() {
		return dersKredi;
	}

	public String getDurum() {
		return durum;
	}
}