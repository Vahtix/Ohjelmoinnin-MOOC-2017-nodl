import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Sanakirja {

	private HashMap<String, String> sanakirja;
	
	public Sanakirja(){
		this.sanakirja = new HashMap<String, String>();
	}
	
	public void lisaa(String sana, String kaannos){
		this.sanakirja.put(sana, kaannos);
	}
	
	public String kaanna(String sana){
		if(this.sanakirja.containsKey(sana)){
			return this.sanakirja.get(sana);
		}else{
			return null;
		}
	}
	
	public int sanojenLukumaara(){
		return this.sanakirja.size();
	}
	
	public ArrayList<String> kaannoksetListana(){
		ArrayList<String> kaannosLista = new ArrayList<String>();
		
		for(Map.Entry<String, String> merkinta : this.sanakirja.entrySet()){
			kaannosLista.add(merkinta.getKey() + " = " + merkinta.getValue());
		}
		
		return kaannosLista;
	}
	
}
