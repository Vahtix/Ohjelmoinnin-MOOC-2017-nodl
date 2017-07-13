package muuttaminen.domain;

public class Esine implements Tavara, Comparable<Esine> {

	private String nimi;
	private int tilavuus;
	
	public Esine(String nimi, int tilavuus){
		this.nimi = nimi;
		this.tilavuus = tilavuus;
	}

	public String getNimi(){
		return this.nimi;
	}
	
	@Override
	public int getTilavuus() {
		return this.tilavuus;
	}
	
	public String toString(){
		return this.nimi + " (" + this.tilavuus + " dm^3)";
	}

	@Override
	public int compareTo(Esine esine) {
		if(this.tilavuus == esine.getTilavuus()){
			return 0;
		}else if(this.tilavuus < esine.getTilavuus()){
			return -1;
		}else{
			return 1;
		}
	}
	
}
