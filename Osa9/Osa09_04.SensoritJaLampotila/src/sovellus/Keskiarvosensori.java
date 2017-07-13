package sovellus;

import java.util.ArrayList;
import java.util.List;

public class Keskiarvosensori implements Sensori {
	
	private List<Sensori> sensorit;
	private List<Integer> mittaukset;
	
	public Keskiarvosensori(){
		this.sensorit = new ArrayList<Sensori>();
		this.mittaukset = new ArrayList<Integer>();
	}
	
	public void lisaaSensori(Sensori lisattava){
		this.sensorit.add(lisattava);
	}

	@Override
	public boolean onPaalla() {
		for(Sensori sensori : this.sensorit){
			if(sensori.onPaalla()){
				return true;
			}
		}
		return false;
	}

	@Override
	public void paalle() {
		for(Sensori sensori : this.sensorit){
			sensori.paalle();
		}
	}

	@Override
	public void poisPaalta() {
		for(Sensori sensori : this.sensorit){
			sensori.poisPaalta();
		}
	}

	@Override
	public int mittaa() {
		if(!this.onPaalla() && this.sensorit.size() == 0){
			throw new IllegalStateException("Keskiarvosensorin tulee olla paalla ja sisaltaa sensoreita ennen mittaamista");
		}
		
		int summa = 0;
		int lkm = this.sensorit.size();
		
		for(Sensori sensori : this.sensorit){
			summa += sensori.mittaa();
		}
		
		int keskiarvo = summa / lkm;
		this.mittaukset.add(keskiarvo);
		
		return keskiarvo;
	}
	
	public List<Integer> mittaukset(){
		return this.mittaukset;
	}

}
