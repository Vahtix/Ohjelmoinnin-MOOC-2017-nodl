
import java.util.Scanner;

public class Paaohjelma {

    public static void main(String[] args) {
        // HUOM! Älä luo ohjelmassa muita Scanner-olioita. Jos ja toivottavasti
        // kun teet muita luokkia, anna allaoleva Scanner-olio niille
        // tarvittaessa parametrina.
        
        Scanner lukija = new Scanner(System.in);
        String komento = "";
        LintuTietokanta lintuTietokanta = new LintuTietokanta();
        
        while(!komento.equals("Lopeta")){
        	komento = lukija.nextLine();
        	
        	if(komento.equals("Lisaa")){
        		
        		lintuTietokanta.lisaa(lukija);
        		
        	}else if(komento.equals("Havainto")){
        		
        		lintuTietokanta.havainto(lukija);
        		
        	}else if(komento.equals("Tilasto")){
        		
        		lintuTietokanta.tilasto();
        		
        	}else if(komento.equals("Nayta")){
        		
        		lintuTietokanta.nayta(lukija);
        		
        	}else{
        		System.out.println("Tuntematon komento");
        	}
        	
        }
        
        lukija.close();

    }

}
