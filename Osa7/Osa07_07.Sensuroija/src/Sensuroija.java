import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Sensuroija {

	private String merkkijono;
	private Scanner tiedostonLukija;
	private ArrayList<String> tiedostonRivit;
	
	public Sensuroija(String merkkijono){
		this.merkkijono = merkkijono;
		tiedostonRivit = new ArrayList<String>();
	}
	
	public void sensuroi(String lahdetiedosto, String kohdetiedosto){
		
		String sana;
		ArrayList<String> sensuroidutRivit= new ArrayList<String>();
		
		luetiedosto(lahdetiedosto);
		
		for(int i = 0; i < tiedostonRivit.size(); i++){
			sana = tiedostonRivit.get(i);
			
			if(!sana.contains(this.merkkijono)){
				sensuroidutRivit.add(sana);
			}
		}
		
		kirjoitaTiedostoon(kohdetiedosto, sensuroidutRivit);
		
	}
	
	private void luetiedosto(String tiedosto){
		try{
        	tiedostonLukija = new Scanner(new File(tiedosto));        	
        	while(tiedostonLukija.hasNext()){
        		tiedostonRivit.add(tiedostonLukija.nextLine());
        	}
		}catch(Exception e){
			System.out.println("Tiedoston " + tiedosto + " lukeminen epaonnistui");
		}
	}
	
	private void kirjoitaTiedostoon(String tiedosto, ArrayList<String> rivit){
		try {
            Files.write(Paths.get(tiedosto), rivit, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Kirjoittaminen epaonnistui. Virhe: " + e.getMessage());
        }
	}
	
}
