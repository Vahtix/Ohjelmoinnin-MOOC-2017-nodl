
import java.util.Scanner;

public class Peltipoliisit {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        String rekkariString = " ";
        String rekkariNimi;
        int rekkariNopeus;
        Peltipoliisi peltipoliisi = new Peltipoliisi();       
        
        while(true){
        	rekkariString = lukija.nextLine();
        	
        	if(rekkariString.equals("")){
        		break;
        	}
        	rekkariNimi = rekkariString.substring(0, rekkariString.indexOf(";"));
        	rekkariNopeus = Integer.parseInt(rekkariString.substring(rekkariString.indexOf(";") + 1));
        	peltipoliisi.lisaaRekkari(new Rekisterinumero(rekkariNimi, rekkariNopeus));      	
        }
        
        
        System.out.println("Suurin: " + peltipoliisi.getSuurin());
        System.out.println("Pienin: " + peltipoliisi.getPienin());
        System.out.println("Keskiarvo: " + peltipoliisi.getKeskiarvo());
        
        lukija.close();
        
        
    }
}
