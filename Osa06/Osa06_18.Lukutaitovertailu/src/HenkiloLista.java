import java.util.ArrayList;

public class HenkiloLista {

	private ArrayList<Henkilo> henkilot;
	
	public HenkiloLista(){
		henkilot = new ArrayList<Henkilo>();
	}
	
	public void lisaaHenkilo(Henkilo henkilo){
		this.henkilot.add(henkilo);
	}
	
	public void jarjestaHenkilot(){
		this.henkilot.stream().sorted((h1, h2) -> {
		    return Double.compare(h1.getLukutaito(), h2.getLukutaito());
		}).forEach(h -> System.out.println(h));
	}
	
	public void tulostaHenkilot(){
		for(int i = 0; i < henkilot.size(); i++){
			System.out.println(henkilot.get(i));
		}
	}
	
	public void muunnaTiedostosta(ArrayList<String> tiedosto){
		
		String[] rivi;
		
    	for(int i = 0; i < tiedosto.size(); i++){

    		rivi = tiedosto.get(i).split(",");
    		
    		rivi[2] = rivi[2].replace(" (%)", "");
    		
    		this.lisaaHenkilo(new Henkilo(rivi[3], rivi[2], Integer.parseInt(rivi[4]), Double.parseDouble(rivi[5])));
    		
    	}
	}
	
}
