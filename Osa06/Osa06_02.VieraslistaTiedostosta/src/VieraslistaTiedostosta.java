
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class VieraslistaTiedostosta {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Scanner tiedostonLukija = null;
        
        System.out.println("Minkä niminen tiedosto luetaan? ");
        String tiedosto = lukija.nextLine();

        ArrayList<String> lista = new ArrayList<>();
        // toteuta tiedoston lukeminen tässä.
        
        try{
        	tiedostonLukija = new Scanner(new File(tiedosto));        	
        	while(tiedostonLukija.hasNext()){
        		lista.add(tiedostonLukija.next());
        	}
        	
        }catch(Exception e){
        	System.out.println("Tiedoston " + tiedosto + " lukeminen epaonnistui");
        }
        
        System.out.println("");

        System.out.println("Syötä nimiä, tyhjä rivi lopettaa.");
        while (true) {
            String nimi = lukija.nextLine();
            if (nimi.isEmpty()) {
                break;
            }

            if (lista.contains(nimi)) {
                System.out.println("Nimi on listalla.");
            } else {
                System.out.println("Nimi ei ole listalla.");
            }
        }

        System.out.println("Kiitos!");
        lukija.close();
        tiedostonLukija.close();
    }
}
