import java.util.ArrayList;
import java.util.Scanner;

public class LintuTietokanta {

	private ArrayList<Lintu> linnut;
	
	public LintuTietokanta(){
		linnut = new ArrayList<Lintu>();
	}
	
	public void lisaa(Scanner lukija){
		
		System.out.println("Nimi: "); 
		String nimi = lukija.nextLine();
		System.out.println("Latinankielinen nimi: ");
		String latinaNimi = lukija.nextLine();
		
		this.linnut.add(new Lintu(nimi, latinaNimi));
	}
	
	public void havainto(Scanner lukija){
		System.out.println("Mika havaittu?");
		String haettava = lukija.nextLine();
		
		if(this.onkoTietokannassa(haettava)){
			for(int i = 0; i < this.linnut.size(); i++){
				if(this.linnut.get(i).getNimi().equals(haettava)){
					this.linnut.get(i).lisaaHavainto();;
				}
			}
		}else{
			System.out.println("Ei ole lintu!");
		}
		
	}
	
	public void tilasto(){
		for(int i = 0; i < linnut.size(); i++){
			System.out.println(linnut.get(i));
		}
	}
	
	public void nayta(Scanner lukija){
		System.out.println("Mika?");
		String haettava = lukija.nextLine();
		
		if(this.onkoTietokannassa(haettava)){
			for(int i = 0; i < this.linnut.size(); i++){
				if(this.linnut.get(i).getNimi().equals(haettava)){
					System.out.println(this.linnut.get(i));
				}
			}
		}else{
			System.out.println("Ei ole lintu!");
		}
	}
	
	private boolean onkoTietokannassa(String nimi){
		ArrayList<String> lintujenNimet = new ArrayList<String>();
		
		for(int i = 0; i < this.linnut.size(); i++){
			lintujenNimet.add(this.linnut.get(i).getNimi());
		}
		
		return lintujenNimet.contains(nimi);
	}
	
}
