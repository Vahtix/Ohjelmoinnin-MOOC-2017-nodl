import java.util.Scanner;

public class Tekstikayttoliittyma {

	private Scanner lukija;
	private Sanakirja sanakirja;
	
	public Tekstikayttoliittyma(Scanner lukija, Sanakirja sanakirja){
		this.lukija = lukija;
		this.sanakirja = sanakirja;
	}
	
	public void kaynnista(){
		System.out.println("Komennot:");
		System.out.println("	lisaa - lisaa sanaparin sanakirjaan");
		System.out.println("	kaanna - kysyy sanan ja tulostaa sen kaannoksen");
		System.out.println("	lopeta - poistuu kayttoliittymasta");
		
		while(true){
			System.out.println("Komento:");
			String komento = lukija.nextLine();
			
			if(komento.equals("kaanna")){
				
				System.out.println("Anna sana: ");
				String sana = lukija.nextLine();
				System.out.println(this.sanakirja.kaanna(sana));
				
			}else if(komento.equals("lisaa")){
				
				System.out.println("Suomeksi");
				String sana = lukija.nextLine();
				System.out.println("Kaannos:");
				String kaannos = lukija.nextLine();
				
				this.sanakirja.lisaa(sana, kaannos);

			}else if(komento.equals("lopeta")){
				System.out.println("Hei hei!");
				break;
			}else{
				System.out.println("Tuntematon komento");
			}
		}
	}
	
}
