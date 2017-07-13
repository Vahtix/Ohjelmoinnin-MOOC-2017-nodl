package sanakirja;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class OmaUseanKaannoksenSanakirja implements UseanKaannoksenSanakirja {
	
	private Map<String, Set<String>> sanakirja;
	
	public OmaUseanKaannoksenSanakirja(){
		this.sanakirja = new HashMap<String, Set<String>>();
	}

	@Override
	public void lisaa(String sana, String kaannos) {
		if(this.sanakirja.containsKey(sana)){
			this.sanakirja.get(sana).add(kaannos);
		}else{
			this.sanakirja.put(sana, new HashSet<String>());
			this.sanakirja.get(sana).add(kaannos);
		}
	}

	@Override
	public Set<String> kaanna(String sana) {
		if(this.sanakirja.containsKey(sana)){
			return this.sanakirja.get(sana);
		}else{
			return new HashSet<String>();
		}
	}

	@Override
	public void poista(String sana) {
		if(this.sanakirja.containsKey(sana)){
			this.sanakirja.remove(sana);
		}	
	}

}
