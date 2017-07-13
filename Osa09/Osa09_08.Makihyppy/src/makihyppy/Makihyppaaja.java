package makihyppy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Makihyppaaja implements Comparable<Makihyppaaja> {

	private String nimi;
	private int kierroksenHyppy = 0;
	private int kokonaispisteet = 0;
	private List<Integer> tuomaripisteet;
	private List<Integer> hypyt;
	private Random random;
	
	public Makihyppaaja(String nimi){
		this.nimi = nimi;
		this.tuomaripisteet = new ArrayList<Integer>();
		this.hypyt = new ArrayList<Integer>();
		random = new Random();
	}
	
	public String getNimi(){
		return this.nimi;
	}
	
	public int getKokonaispisteet(){
		return this.kokonaispisteet;
	}
	
	public void hyppaa(List<Integer> tuomaripisteet){
		this.kierroksenHyppy = random.nextInt(60) + 60;
		this.hypyt.add(kierroksenHyppy);
		this.tuomaripisteet = tuomaripisteet;
	}
	
	public void lisaaKokonaispisteet(){
		for(int i = 1; i < 4; i++){
			int piste = this.tuomaripisteet.get(i);
			this.kierroksenHyppy += piste;
		}
		this.kokonaispisteet += this.kierroksenHyppy;
	}
	
	public String toString(){
		return this.nimi + " (" + this.kokonaispisteet + " pistettä)";
	}
	
	public String kierroksenTulos(){
		return "  " + this.nimi + "\n" + 
				"      pituus: " + this.kierroksenHyppy + " \n" + 
				"       tuomaripisteet: " + this.tuomaripisteet;
	}
	
	public String lopputulos(){
		StringBuilder lopputulos = new StringBuilder();
		
		lopputulos.append("   " + this.toString() + "\n");
		lopputulos.append("           hyppyjen pituudet: ");
		
		for(Integer hyppy : this.hypyt){
			lopputulos.append(hyppy + "m, ");
		}
		
		return lopputulos.toString();
	}

	@Override
	public int compareTo(Makihyppaaja hyppaaja) {
		if(this.kokonaispisteet == hyppaaja.getKokonaispisteet()){
			return 0;
		}else if(this.kokonaispisteet < hyppaaja.getKokonaispisteet()){
			return -1;
		}else{
			return 1;
		}
	}
	
}
