
public class Henkilo {
	
	private String nimi;
	private String sukupuoli;
	private int vuosi;
	private double lukutaito;
	
	public Henkilo(String nimi, String sukupuoli, int vuosi, double lukutaito){
		this.nimi = nimi;
		this.sukupuoli = sukupuoli;
		this.vuosi = vuosi;
		this.lukutaito = lukutaito;
	}
	
	public String toString(){
		return this.nimi + " (" + this.vuosi + ")," + this.sukupuoli + ", " + this.lukutaito;
	}
	
	public double getLukutaito(){
		return this.lukutaito;
	}
	

}
