import java.util.ArrayList;

public class Kirjasto {

	private ArrayList<Kirja> kirjat;
	
	public Kirjasto(){
		this.kirjat = new ArrayList<Kirja>();
	}
	
	public void lisaaKirja(Kirja uusiKirja){
		this.kirjat.add(uusiKirja);
	}
	
	public void tulostaKirjat(){
		for(int i = 0; i < kirjat.size(); i++){
			System.out.println(kirjat.get(i));
		}
	}
	
	public ArrayList<Kirja> haeKirjaNimekkeella(String nimeke){
		
		ArrayList<Kirja> loydetytKirjat = new ArrayList<Kirja>();
		
		for(int i = 0; i <this.kirjat.size(); i++){
			
			if(this.kirjat.get(i).nimeke().contains(nimeke)){
				loydetytKirjat.add(this.kirjat.get(i));
			}
		}
		
		return loydetytKirjat;
	}
	
	public ArrayList<Kirja> haeKirjaJulkaisijalla(String julkaisija){
		ArrayList<Kirja> loydetytKirjat = new ArrayList<Kirja>();
		
		for(int i = 0; i <this.kirjat.size(); i++){
			if(this.kirjat.get(i).julkaisija().contains(julkaisija)){
				loydetytKirjat.add(this.kirjat.get(i));
			}
		}
		
		return loydetytKirjat;
	}
	
	public ArrayList<Kirja> haeKirjaJulkaisuvuodella(int julkaisuvuosi){
		ArrayList<Kirja> loydetytKirjat = new ArrayList<Kirja>();
		
		for(int i = 0; i <this.kirjat.size(); i++){
			if(this.kirjat.get(i).julkaisuvuosi() == julkaisuvuosi){
				loydetytKirjat.add(this.kirjat.get(i));
			}
		}
		
		return loydetytKirjat;
	}
	
}
