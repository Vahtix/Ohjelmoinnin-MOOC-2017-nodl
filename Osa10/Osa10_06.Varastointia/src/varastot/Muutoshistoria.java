package varastot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Muutoshistoria {

	private List<Double> muutoshistoria;
	
	public Muutoshistoria(){
		this.muutoshistoria = new ArrayList<Double>();
	}
	
	public void lisaa(double tilanne){
		this.muutoshistoria.add(tilanne);
	}
	
	public void nollaa(){
		this.muutoshistoria.clear();
	}
	
	public double maxArvo(){
		
		if(this.muutoshistoria.isEmpty()){
			return 0;
		}
		
		return Collections.max(this.muutoshistoria);
	}
	
	public double minArvo(){
		if(this.muutoshistoria.isEmpty()){
			return 0;
		}
		
		return Collections.min(this.muutoshistoria);
	}
	
	public double keskiarvo(){
		if(this.muutoshistoria.isEmpty()){
			return 0;
		}
		
		double summa = 0;
		int lkm = this.muutoshistoria.size();
		
		for(double arvo : this.muutoshistoria){
			summa += arvo;
		}
		
		return summa / lkm;
	}
	
	public double suurinMuutos(){
		if(this.muutoshistoria.isEmpty() || this.muutoshistoria.size() == 1){
			return 0;
		}
		
		List<Double> muutosLista = new ArrayList<Double>();
		double verrattava = 0;
		double arvo = 0;
		
		 for (int i = 0; i < this.muutoshistoria.size(); i++) {
             try {
                 arvo = this.muutoshistoria.get(i);
                 verrattava = this.muutoshistoria.get(i + 1);
                 muutosLista.add(Math.abs(arvo - verrattava));
             } catch (IndexOutOfBoundsException e) {
                 break;
             }
         }
		
		Collections.sort(muutosLista);
        Collections.reverse(muutosLista);
		
		return muutosLista.get(0);
	}
	
	public double varianssi(){
		if(this.muutoshistoria.isEmpty()){
			return 0;
		}
		
		double keskiarvo = this.keskiarvo();
		double varianssi = 0;
		
		for(double arvo : this.muutoshistoria){
			varianssi += Math.pow((arvo - keskiarvo), 2);
		}
		
		varianssi /= this.muutoshistoria.size() - 1;
		
		return varianssi;
	}
	
	public String toString(){
		return this.muutoshistoria.toString();
	}
}
