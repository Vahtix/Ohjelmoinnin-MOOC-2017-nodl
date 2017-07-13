import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Varasto {

	private Map<String, Integer> hinnat;
	private Map<String, Integer> saldot;
	
	public Varasto(){
		this.hinnat = new HashMap<String, Integer>();
		this.saldot = new HashMap<String, Integer>();
	}
	
	public void lisaaTuote(String tuote, int hinta, int saldo){
		this.hinnat.put(tuote, hinta);
		this.saldot.put(tuote, saldo);
	}
	
	public int hinta(String tuote){		
		if(this.hinnat.containsKey(tuote)){
			return this.hinnat.get(tuote);
		}else{
			return -99;
		}
	}
	
	public int saldo(String tuote){
		if(this.saldot.containsKey(tuote)){
			return this.saldot.get(tuote);
		}else{
			return 0;
		}
	}
	
	public boolean ota(String tuote){
		if(this.saldot.containsKey(tuote) && this.saldot.get(tuote) - 1 >= 0){
			this.saldot.put(tuote, this.saldot.get(tuote) - 1);
			return true;
		}else{
			return false;
		}
	}
	
	public Set<String> tuotteet(){
		
		Set<String> varastoJoukkona = (Set<String>) this.hinnat.keySet();
		
		return varastoJoukkona;
	}
}
