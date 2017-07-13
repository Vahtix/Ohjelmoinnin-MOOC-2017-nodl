package lentokentta;
import java.util.Scanner;

public class Kayttoliittyma {
		
	private String valinta;
	private Scanner lukija;
	private Lentokentta lentokentta;
	
	public Kayttoliittyma(){
		this.lukija = new Scanner(System.in);
		this.lentokentta = new Lentokentta();
	}
	
	public void paivitaHallintaa(){
		System.out.println("Lentokentän hallinta");
		System.out.println("--------------------");
		System.out.println("");
		
		while(true){
			this.valinta = this.hallinnanOhjeet();
			
			if(this.valinta.equals("1")){
				System.out.print("Anna lentokoneen tunnus: ");
				String tunnus = lukija.nextLine();
				System.out.print("Anna lentokoneen kapasiteetti: ");
				int kapasiteetti = Integer.parseInt(lukija.nextLine());
				this.lentokentta.lisaaLentokone(new Lentokone(tunnus, kapasiteetti));
			}else if(this.valinta.equals("2")){
				System.out.print("Anna lentokoneen tunnus: ");
				String tunnus = lukija.nextLine();
				Lentokone lentokone = lentokentta.haeLentokone(tunnus);
				
				if(lentokone != null){
					System.out.print("Anna lähtöpaikan tunnus: ");
					String lahtopaikka = lukija.nextLine();
					System.out.print("Anna kohdepaikan tunnus: ");
					String kohdepaikka = lukija.nextLine();
					this.lentokentta.lisaaLento(new Lento(lentokone, lahtopaikka, kohdepaikka));
				}else{
					System.out.println("Lentokonetta ei loydy");
				}
				
			}else if(this.valinta.equals("x")){
				break;
			}
		}
		System.out.println("");
	}
	
	public void paivitaLentopalvelua(){
		System.out.println("Lentopalvelu");
		System.out.println("------------");
		System.out.println("");
		
		while(true){		
			this.valinta = this.lentopalvelunOhjeet();
			
			if(this.valinta.equals("1")){
				this.lentokentta.tulostaLentokoneet();
			}else if(this.valinta.equals("2")){
				this.lentokentta.tulostaLennot();
			}else if(this.valinta.equals("3")){
				System.out.print("Mikä kone: ");
				String tunnus = lukija.nextLine();
				this.lentokentta.tulostaLentokone(tunnus);
			}else if(this.valinta.equals("x")){
				break;
			}
		}
	}
	
	private String hallinnanOhjeet(){
        System.out.println("Valitse toiminto:\n"
                + "[1] Lisää lentokone\n"
                + "[2] Lisää lento\n"
                + "[x] Poistu hallintamoodista");

        System.out.print("> ");
        return lukija.nextLine();
	}
	
	private String lentopalvelunOhjeet(){
        System.out.println("Valitse toiminto:\n"
                + "[1] Tulosta lentokoneet\n"
                + "[2] Tulosta lennot\n"
                + "[3] Tulosta lentokoneen tiedot\n"
                + "[x] Lopeta");
        System.out.print("> ");
        return lukija.nextLine();
	}
}
