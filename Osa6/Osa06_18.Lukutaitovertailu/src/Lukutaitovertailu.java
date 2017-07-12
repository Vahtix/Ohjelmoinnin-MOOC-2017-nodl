
import java.util.ArrayList;

public class Lukutaitovertailu {
    
    public static void main(String[] args) {
    	Tiedostonlukija lukija = new Tiedostonlukija();  
    	HenkiloLista henkilot = new HenkiloLista();
    	ArrayList<String> lukutaitoTiedosto = lukija.lueTiedosto("lukutaito.csv");
    	
    	henkilot.muunnaTiedostosta(lukutaitoTiedosto);
    	henkilot.jarjestaHenkilot();   	
    	henkilot.tulostaHenkilot();
    	
    }
}
