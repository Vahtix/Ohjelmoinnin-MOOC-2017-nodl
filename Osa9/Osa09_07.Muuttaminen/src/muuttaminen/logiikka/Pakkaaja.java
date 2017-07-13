package muuttaminen.logiikka;

import java.util.ArrayList;
import java.util.List;

import muuttaminen.domain.Muuttolaatikko;
import muuttaminen.domain.Tavara;

public class Pakkaaja {

	private int laatikoidentilavuus;
	
	public Pakkaaja(int laatikoidentilavuus){
		this.laatikoidentilavuus = laatikoidentilavuus;
	}
	
	public List<Muuttolaatikko> pakkaaTavarat(List<Tavara> tavarat){
		ArrayList<Muuttolaatikko> muuttolaatikot = new ArrayList<Muuttolaatikko>();
		muuttolaatikot.add(new Muuttolaatikko(this.laatikoidentilavuus));
		int laatikonIndeksi = 0;
		
		for(Tavara tavara : tavarat){
			if(!muuttolaatikot.get(laatikonIndeksi).lisaaTavara(tavara)){
				muuttolaatikot.add(new Muuttolaatikko(this.laatikoidentilavuus));
				laatikonIndeksi++;
				muuttolaatikot.get(laatikonIndeksi).lisaaTavara(tavara);
			}
		}
		
		return muuttolaatikot;	
	}
}
