import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Ostoskori {

	private Map<String, Ostos> ostoskori;
	
	public Ostoskori(){
		this.ostoskori = new HashMap<String, Ostos>();
	}
	
	public void lisaa(String tuote, int hinta){
		if(this.ostoskori.containsKey(tuote)){
			this.ostoskori.get(tuote).kasvataMaaraa();
		}else{
			this.ostoskori.put(tuote, new Ostos(tuote, 1, hinta));
		}		
	}
	
	public int hinta(){
		
		int yhteishinta = 0;
		
		for(Entry<String, Ostos> ostos : this.ostoskori.entrySet()){
			yhteishinta += ostos.getValue().hinta();
		}
		
		return yhteishinta;
	}
	
	public void tulosta(){
		for(Entry<String, Ostos> ostos : this.ostoskori.entrySet()){
			System.out.println(ostos.getValue());
		}
	}
	
}
