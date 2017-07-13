package muuttaminen.domain;

import java.util.ArrayList;
import java.util.List;

public class Muuttolaatikko implements Tavara {

	private int maksimitilavuus;
	private List<Tavara> tavarat;
	
	public Muuttolaatikko(int maksimitilavuus){
		this.maksimitilavuus = maksimitilavuus;
		this.tavarat = new ArrayList<Tavara>();
	}
	
	public boolean lisaaTavara(Tavara tavara){
		if(this.getTilavuus() + tavara.getTilavuus() > this.maksimitilavuus){
			return false;
		}else{
			this.tavarat.add(tavara);
			return true;
		}
		
	}

	@Override
	public int getTilavuus() {
		int tilavuus = 0;
		for(Tavara tavara : this.tavarat){
			tilavuus += tavara.getTilavuus();
		}
		return tilavuus;
	}
	
	public String toString(){
		return "laatikossa tavaraa: " + this.getTilavuus() + " dm^3"; 
	}
}
