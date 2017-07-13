package henkilot;

public class Henkilo {

	private String nimi, osoite;
	
	public Henkilo(String nimi, String osoite){
		this.nimi = nimi;
		this.osoite = osoite;
	}
	
	public String toString(){
		return this.nimi + "\n" +
				"  " + this.osoite;
	}
	
}
