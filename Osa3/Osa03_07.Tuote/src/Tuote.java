
public class Tuote {
	private String nimi;
	private double hinta;
	private int maara;
	
	public Tuote(String nimiAlussa, double hintaAlussa, int maaraAlussa){
		this.nimi = nimiAlussa;
		this.hinta = hintaAlussa;
		this.maara = maaraAlussa;
	}
	
	public void tulostaTuote(){
		System.out.println(nimi + ", " + "hinta " + hinta + ", " + maara + " kpl");
	}
}
