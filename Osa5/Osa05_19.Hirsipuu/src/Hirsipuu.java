
import java.util.Scanner;

public class Hirsipuu {

    public static void main(String[] args) {
    	
        Scanner lukija = new Scanner(System.in);       
        System.out.println("Mita merkkijonoa arvataan?");
        String sana = lukija.nextLine();       
        HirsipuuPeli peli = new HirsipuuPeli(sana, lukija);
        peli.pelaaHirsipuuta();
        lukija.close();
      
    }
}
