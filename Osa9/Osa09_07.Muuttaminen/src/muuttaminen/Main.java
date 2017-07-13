package muuttaminen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import muuttaminen.domain.Esine;
import muuttaminen.domain.Muuttolaatikko;
import muuttaminen.domain.Tavara;
import muuttaminen.logiikka.Pakkaaja;

public class Main {

    public static void main(String[] args) {
    	List<Tavara> tavarat = new ArrayList<>();
    	tavarat.add(new Esine("passi", 2));
    	tavarat.add(new Esine("hammasharja", 1));
    	tavarat.add(new Esine("kirja", 4));
    	tavarat.add(new Esine("sirkkeli", 8));

    	Pakkaaja pakkaaja = new Pakkaaja(10);

    	List<Muuttolaatikko> laatikot = pakkaaja.pakkaaTavarat(tavarat);

    	System.out.println("laatikoita: " + laatikot.size());

    	laatikot.stream().forEach(laatikko -> {
    	    System.out.println("  laatikossa tavaraa: " + laatikko.getTilavuus() + " dm^3");
    	});
    }
}
