import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Ajoneuvorekisteri {

	private final HashMap<Rekisterinumero, String> omistajat;
	
	public Ajoneuvorekisteri(){
		this.omistajat = new HashMap<Rekisterinumero, String>();
	}
	
	public boolean lisaa(Rekisterinumero rekkari, String omistaja){
		if(this.omistajat.containsKey(rekkari)){
			return false;
		}else{
			this.omistajat.put(rekkari, omistaja);
			return true;
		}
	}
	
	public String hae(Rekisterinumero rekkari){
		if(this.omistajat.containsKey(rekkari)){
			return this.omistajat.get(rekkari);
		}else{
			return null;
		}
	}
	
	public boolean poista(Rekisterinumero rekkari){
		if(this.omistajat.containsKey(rekkari)){
			this.omistajat.remove(rekkari);
			return true;
		}else{
			return false;
		}
	}
	
	public void tulostaRekisterinumerot(){
		for(Rekisterinumero rekkari : this.omistajat.keySet()){
			System.out.println(rekkari);
		}
	}
	
	public void tulostaOmistajat(){

		Set<String> omistajat = new HashSet<String>();
		
		for(Entry<Rekisterinumero, String> merkinta : this.omistajat.entrySet()){			
			omistajat.add(merkinta.getValue());
		}
		
		for(String omistaja : omistajat){
			System.out.println(omistaja);
		}
		
	}
	
	
}
