package makihyppy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kilpailu {

	private List<Makihyppaaja> kilpailijat;
	private Tuomaristo tuomaristo;
	
	public Kilpailu(){
		this.kilpailijat = new ArrayList<Makihyppaaja>();
		this.tuomaristo = new Tuomaristo();
	}
	
	public void lisaaKilpailija(Makihyppaaja hyppaaja){
		this.kilpailijat.add(hyppaaja);
	}
	
	public void suoritaHypyt(){
		for(Makihyppaaja hyppaaja : this.kilpailijat){
			hyppaaja.hyppaa(tuomaristo.annaPisteet());			
		}
	}
	
	public void lisaaKokonaispisteet(){
		for(Makihyppaaja hyppaaja : this.kilpailijat){
			hyppaaja.lisaaKokonaispisteet();
		}
	}
	
	public void tulostaKierroksenTulokset(){
		for(Makihyppaaja hyppaaja : this.kilpailijat){
			System.out.println(hyppaaja.kierroksenTulos());
		}
	}
	
	public void tulostaHyppyjarjestys(){
		Collections.sort(this.kilpailijat);
		
		for(Makihyppaaja hyppaaja : this.kilpailijat){
			System.out.println("  " + (this.kilpailijat.indexOf(hyppaaja) + 1) + ". " + hyppaaja);
		}
	}
	
	public void tulostaLopputulokset(){
		Collections.sort(this.kilpailijat);
		Collections.reverse(this.kilpailijat);
		for(Makihyppaaja hyppaaja : this.kilpailijat){
			System.out.print((this.kilpailijat.indexOf(hyppaaja) + 1) + "    ");
			System.out.println(hyppaaja.lopputulos());
		}
	}
	
}
