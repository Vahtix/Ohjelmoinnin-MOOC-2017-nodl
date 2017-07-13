package numerotiedustelu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Numerotiedustelu implements TiedusteluToiminnot {

	private List<Henkilo> tietokanta;
	
	public Numerotiedustelu(){
		this.tietokanta = new ArrayList<Henkilo>();
	}

	@Override
	public void lisaaPuhelinnumero(String omistaja, String puhelinnumero) {
		Henkilo henkilo = new Henkilo(omistaja);
		if(this.tietokanta.contains(henkilo)){
			this.tietokanta.get(this.tietokanta.indexOf(henkilo)).lisaaPuhelinnumero(puhelinnumero);
		}else{
			henkilo.lisaaPuhelinnumero(puhelinnumero);
			this.tietokanta.add(henkilo);
		}
		
	}

	@Override
	public Set<String> haePuhelinnumerot(String omistaja) {
		for(Henkilo henkilo : this.tietokanta){
			if(henkilo.getNimi().equals(omistaja)){
				
				if(henkilo.getPuhelinnumerot() == null){
					return new HashSet<String>();
				}else{
					return henkilo.getPuhelinnumerot();
				}
			}
		}
		return null;
	}

	@Override
	public String haeOmistaja(String puhelinnumero) {
		
		for(Henkilo henkilo : this.tietokanta){
			if(henkilo.getPuhelinnumerot().contains(puhelinnumero)){
				return henkilo.getNimi();
			}
		}
		
		return "ei löytynyt";
	}

	@Override
	public void lisaaOsoite(String omistaja, String katu, String kaupunki) {
		Henkilo henkilo = new Henkilo(omistaja);
		if(this.tietokanta.contains(henkilo)){
			this.tietokanta.get(this.tietokanta.indexOf(henkilo)).setOsoite(katu, kaupunki);
		}else{
			henkilo.setOsoite(katu, kaupunki);
			this.tietokanta.add(henkilo);
		}
		
	}

	@Override
	public String haeHenkilonTiedot(String omistaja) {
		Henkilo henkilo = new Henkilo(omistaja);
		if(this.tietokanta.contains(henkilo)){
			return this.tietokanta.get(this.tietokanta.indexOf(henkilo)).toString();
		}else{
			return "ei löytynyt";
		}
	}

	@Override
	public void poistaHenkilonTiedot(String omistaja) {
		Henkilo henkilo = new Henkilo(omistaja);
		if(this.tietokanta.contains(henkilo)){
			this.tietokanta.remove(this.tietokanta.indexOf(henkilo));
		}
		
	}

	@Override
	public String listaaFilteroidysti(String hakusana) {

		Collections.sort(this.tietokanta);
		
		StringBuilder henkiloLista = new StringBuilder();
		
		if(hakusana.equals("")){
			
			for(Henkilo henkilo : this.tietokanta){
				henkiloLista.append("\n");
				henkiloLista.append(henkilo.kaikkiTiedot());
				henkiloLista.append("\n");
			}
		}else{
			
			for(Henkilo henkilo : this.tietokanta){
				if(henkilo.getNimi().contains(hakusana) || henkilo.getOsoite().contains(hakusana)){
					henkiloLista.append("\n" + henkilo.kaikkiTiedot());
					henkiloLista.append("\n");
				}
			}
			
		}
		
		if(henkiloLista.length() == 0){
			return "ei löytynyt";
		}else{
			return henkiloLista.toString();
		}

	}
	
}
