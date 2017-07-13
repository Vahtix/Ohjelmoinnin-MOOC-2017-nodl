package henkilot;

public class Opiskelija extends Henkilo {
	
	private int opintopisteet = 0;

	public Opiskelija(String nimi, String osoite) {
		super(nimi, osoite);
	}
	
	public void opiskele(){
		this.opintopisteet++;
	}
	
	public int opintopisteita(){
		return this.opintopisteet;
	}
	
	public String toString(){
		return super.toString() + "\n" + 
				"  opintopisteitä " + this.opintopisteet;
		
	}

}
