import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Tiedostonlukija {
	
	private Scanner lukija;
	private ArrayList<String> tiedostonRivit;
	
	public Tiedostonlukija(){
		lukija = new Scanner(System.in);
		tiedostonRivit = new ArrayList<String>();
	}
	
	public ArrayList<String> lueTiedosto(String tiedostonimi){
    	try {
    		
			Scanner lukija = new Scanner(new File(tiedostonimi));
			
			while(lukija.hasNext()){
				tiedostonRivit.add(lukija.nextLine());
			}			
			lukija.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	
    	return tiedostonRivit;
	}
	
	public void suljeTiedostonlukija(){
		this.lukija.close();
	}

}
