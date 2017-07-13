package tyokalut;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class OmaDuplikaattienPoistaja implements DuplikaattienPoistaja {
	
	private List<String> lista;
	private int dublikaatit = 0;
	
	public OmaDuplikaattienPoistaja(){
		this.lista = new ArrayList<String>();
	}

	@Override
	public void lisaa(String merkkijono) {
		if(this.lista.contains(merkkijono)){
			this.dublikaatit++;
		}else{
			this.lista.add(merkkijono);
		}
		
	}

	@Override
	public int getHavaittujenDuplikaattienMaara() {
		return this.dublikaatit;
	}

	@Override
	public Set<String> getUniikitMerkkijonot() {
		if(this.lista.isEmpty()){
			return new HashSet<String>();
		}else{
			return new HashSet<String>(this.lista);
		}
	}

	@Override
	public void tyhjenna() {
		this.lista.clear();
		this.dublikaatit = 0;
	}

}
