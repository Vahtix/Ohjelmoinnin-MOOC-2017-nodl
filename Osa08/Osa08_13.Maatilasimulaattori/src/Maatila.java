import java.util.ArrayList;
import java.util.List;

public class Maatila implements Eleleva {

	private String omistaja;
	private Navetta navetta;
	private List<Lehma> lehmat;
	
	public Maatila(String omistaja, Navetta navetta){
		this.omistaja = omistaja;
		this.navetta = navetta;
		this.lehmat = new ArrayList<Lehma>();
	}
	
	public String getOmistaja(){
		return this.omistaja;
	}
	
	public void lisaaLehma(Lehma lehma){
		this.lehmat.add(lehma);
	}

	@Override
	public void eleleTunti() {
		for(Lehma lehma : this.lehmat){
			lehma.eleleTunti();
		}
	}
	
	public void asennaNavettaanLypsyrobotti(Lypsyrobotti robotti) {
		this.navetta.asennaLypsyrobotti(robotti);
	}
	
	public void hoidaLehmat() {
		this.navetta.hoida(lehmat);
	}
	
	public String toString(){
		
		StringBuilder maatilanTiedot = new StringBuilder();
		maatilanTiedot.append("Maatilan omistaja: " + this.omistaja + "\nNavetan maitosailio: " + this.navetta.getMaitosailio());
		maatilanTiedot.append("\nLehmat:");
		
		for(Lehma lehma : this.lehmat){
			maatilanTiedot.append("\n	" + lehma);
		}
		
		return maatilanTiedot.toString();
	}

}
