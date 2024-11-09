package Package;

public class TeorikDers extends Ders {
	private static int dersIDCounter = 0;
	private int dersID;
	private int dersKredi;
	private static String durum = "Teorik";
	
	public TeorikDers(int newBolNo, String newDersAd, int dersKredi) {
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