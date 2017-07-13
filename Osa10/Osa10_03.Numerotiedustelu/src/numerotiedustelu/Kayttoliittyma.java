package numerotiedustelu;

import java.util.Scanner;
import java.util.Set;

public class Kayttoliittyma {

	private Scanner lukija;
	private String komento;
	private TiedusteluToiminnot numerotiedustelu;
	
	public Kayttoliittyma(){
		this.lukija = new Scanner(System.in);
		this.numerotiedustelu = new Numerotiedustelu();
	}
	
	public void paivita(){
		System.out.println(this.aloitusOhjeet());
		
		while(true){
			System.out.println("");
			System.out.print("Komento: ");
			this.komento = lukija.nextLine();
			
			if(this.komento.equals("1")){
				
				System.out.print("kenelle: ");
				String nimi = lukija.nextLine();
				System.out.print("numero: ");
				String puhelinnumero = lukija.nextLine();
				
				this.numerotiedustelu.lisaaPuhelinnumero(nimi, puhelinnumero);
				
			}else if(this.komento.equals("2")){
				
				System.out.print("kenen: ");
				String nimi = lukija.nextLine();
				
				this.tulostaHenkilonPuhelinnumerot(nimi);
				
			}else if(this.komento.equals("3")){
			
				System.out.print("numero: ");
				String numero = lukija.nextLine();
				System.out.println(this.numerotiedustelu.haeOmistaja(numero));
				
			}else if(this.komento.equals("4")){
				
				System.out.print("kenelle: ");
				String omistaja = lukija.nextLine();
				System.out.print("Katu: ");
				String katu = lukija.nextLine();
				System.out.print("kaupunki: ");
				String kaupunki = lukija.nextLine();
				
				this.numerotiedustelu.lisaaOsoite(omistaja, katu, kaupunki);
				
			}else if(this.komento.equals("5")){
				
				System.out.print("kenen: ");
				String omistaja = lukija.nextLine();
				System.out.println(this.numerotiedustelu.haeHenkilonTiedot(omistaja));
				
				
			}else if(this.komento.equals("6")){
				
				System.out.print("kenet: ");
				String omistaja = lukija.nextLine();
				this.numerotiedustelu.poistaHenkilonTiedot(omistaja);
				
			}else if(this.komento.equals("7")){
				
				System.out.print("hakusana (jos tyhja, listataan kaikki)");
				String hakusana = lukija.nextLine();
				
				System.out.println(this.numerotiedustelu.listaaFilteroidysti(hakusana));
				
			}else if(this.komento.equals("x")){
				break;
			}else{
				System.out.println("tuntematon komento");
			}
			
		}
	}
	
	private String aloitusOhjeet(){
		return "Numerotiedustelu \n" + 
			   "Kaytettavissa olevat komennot:\n" + 
			   "1 lisää numero\n" + 
			   "2 hae numerot\n" + 
			   "3 hae puhelinnumeroa vastaava henkilö\n" + 
			   "4 lisää osoite\n" + 
			   "5 hae henkilön tiedot\n" + 
			   "6 poista henkilön tiedot\n" + 
			   "7 filtteröity listaus\n" + 
			   "x lopeta";
	}
	
	private void tulostaHenkilonPuhelinnumerot(String nimi){
		Set<String> numerot = this.numerotiedustelu.haePuhelinnumerot(nimi);		
		
		if(numerot == null){
			System.out.println("ei löytynyt");
		}else if(numerot.isEmpty()){
			System.out.println("ei puhelinta");
		}else{
			for(String numero : numerot){
				System.out.println("    " + numero);
			}	
		}
	
	}
	
}
