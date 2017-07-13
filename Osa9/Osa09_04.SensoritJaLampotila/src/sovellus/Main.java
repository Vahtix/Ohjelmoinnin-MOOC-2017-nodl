package sovellus;

public class Main {

	public static void main(String[] args) {
	    Sensori kumpula = new Lampomittari();
	    Sensori kaisaniemi = new Lampomittari();
	    Sensori helsinkiVantaa = new Lampomittari();

	    Keskiarvosensori paakaupunki = new Keskiarvosensori();
	    paakaupunki.lisaaSensori(kumpula);
	    paakaupunki.lisaaSensori(kaisaniemi);
	    paakaupunki.lisaaSensori(helsinkiVantaa);

	    paakaupunki.paalle();
	    System.out.println("lampotila Paakaupunkiseudulla "+paakaupunki.mittaa() + " astetta");
	    System.out.println("lampotila Paakaupunkiseudulla "+paakaupunki.mittaa() + " astetta");
	    System.out.println("lampotila Paakaupunkiseudulla "+paakaupunki.mittaa() + " astetta");

	    System.out.println("mittaukset: "+paakaupunki.mittaukset());
	}

}
