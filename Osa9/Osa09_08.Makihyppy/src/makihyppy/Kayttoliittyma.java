package makihyppy;

import java.util.Scanner;

public class Kayttoliittyma {

	private Scanner lukija;
	private Kilpailu kilpailu;
	private int kierros = 0;
	
	public Kayttoliittyma(){
		this.lukija = new Scanner(System.in);
		kilpailu = new Kilpailu();
	}
	
	public void paivita(){
		System.out.println("Kumpulan mäkiviikot");
		System.out.println("");
		this.maaritaOsallistujat();
		System.out.println("");
		System.out.println("Kilpailu alkaa!");
		System.out.println("");
		this.hyppaaKierros();
		System.out.println("");
		System.out.println("Kiitos!");
		System.out.println("");
		this.tulostaLopputulos();
	}
	
	private void maaritaOsallistujat(){
		System.out.println("Syötä kilpailun osallistujat yksi kerrallaan, tyhjällä merkkijonolla siirtyy hyppyvaiheeseen.");
		System.out.println("");
		String kilpailijanNimi = "nimi";
				
		while(true){
			System.out.print("  Osallistujan nimi: ");
			kilpailijanNimi = lukija.nextLine();
			if(kilpailijanNimi.equals("")){
				break;
			}
			this.kilpailu.lisaaKilpailija(new Makihyppaaja(kilpailijanNimi));
		}
	}
	
	private void hyppaaKierros(){
		
		String hyppy;
		
		while(true){
			System.out.print("Kirjoita \"hyppaa\" niin hypätään, muuten lopetetaan: ");
			hyppy = lukija.nextLine();
			if(!hyppy.equals("hyppaa")){
				break;
			}else{
				kierros++;
				System.out.println("");
				System.out.println(this.kierros + ". kierros");
				System.out.println("");
				this.tulostaHyppyJarjestys();
				this.tulostaKierroksenTulos();
			}
		}	
	}
	
	private void tulostaHyppyJarjestys(){
		System.out.println("Hyppyjärjestys:");
		this.kilpailu.tulostaHyppyjarjestys();
		System.out.println("");
	}
	
	private void tulostaKierroksenTulos(){
		this.kilpailu.suoritaHypyt();
		System.out.println("Kierroksen " + this.kierros + " tulokset:");
		this.kilpailu.tulostaKierroksenTulokset();
		this.kilpailu.lisaaKokonaispisteet();
		System.out.println("");
	}
	
	private void tulostaLopputulos(){
		System.out.println("Kilpailun lopputulokset:");
		System.out.println("Sija    Nimi");
		this.kilpailu.tulostaLopputulokset();
	}
	
}
