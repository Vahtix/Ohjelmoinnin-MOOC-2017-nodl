package luola;

import java.util.Scanner;

public class Luola {

	private int siirtoja;
	private String komennot;
	private Pelilogiikka pelilogiikka;
	
	public Luola(int leveys, int korkeus, int hirvioita, int siirtoja, boolean hirviotLiikkuvat){
		this.siirtoja = siirtoja;
		this.pelilogiikka = new Pelilogiikka(korkeus, leveys, hirvioita, hirviotLiikkuvat);
	}
	

	public void run(Scanner lukija){
		while(this.siirtoja > 0){
			this.tulostaLuola();
			this.komennot = lukija.nextLine();
			this.siirtoja--;
			pelilogiikka.suoritaSiirrot(komennot);
			
			if(pelilogiikka.tarkistaVoitto()){
				System.out.println("VOITITI");
				break;
			}			
		}
		
		if(this.siirtoja == 0){
			if(pelilogiikka.tarkistaVoitto()){
				System.out.println("VOITIT");
			}else{
				System.out.println("HÄVISIT");
			}
		}

	}
	
	private void tulostaLuola(){
		
		//Tulostetaan pelaajalla olevat siirrot
		System.out.println(this.siirtoja + "\n");		
		
		//Tulostetaan pelihahmot ja niiden koordinaatit
		System.out.println(pelilogiikka.getPelihahmot());
		
		//Tulostetaan luola
		System.out.println(pelilogiikka.getTilanne() + "\n");
			
	}
}
