
import java.util.ArrayList;
import java.util.Random;

// luo tänne luokkaan oma tekoälysi Uno-peliä varten
public class Tekoalypelaaja implements Pelaaja {

    // Saat luoda tarvittaessa oliomuuttujia. Jos luot konstruktorin, varmista
    // että tekoäly toimii myös parametrittomalla konstruktorilla, eli kutsulla
    // Tekoalypelaaja pelaaja = new Tekoalypelaaja();
	
    @Override
    public int pelaa(ArrayList<Kortti> omatKortit, Kortti paallimmaisin, String vari, Pelitilanne tilanne) {
    	
    	System.out.println("Tekoalyn vuoro\n");
    	
    	String pelattavaVari = paallimmaisin.getVari();
        
    	if(paallimmaisin.onVillikortti()){
    		pelattavaVari = vari;
    		
    		for(int i = 0; i < omatKortit.size(); i++){
    			Kortti kortti = omatKortit.get(i);
    			
    			if(kortti.getVari().equals(pelattavaVari)){
    				return i;
    			}else if(kortti.onVillikortti()){
    				return i;
    			}
    		}   		
    	}else if(paallimmaisin.onNosta() || paallimmaisin.onOhitus() || paallimmaisin.onSuunnanvaihto()){
            for(int i = 0; i < omatKortit.size(); i++){
        		
            	Kortti kortti = omatKortit.get(i);
            	
            	if(kortti.getVari().equals(pelattavaVari)){
            		return i;
            	}
            }
            
            for(int i = 0; i < omatKortit.size(); i++){
            	
            	Kortti kortti = omatKortit.get(i);
            	
            	if(paallimmaisin.getKorttityyppi().equals(kortti.getKorttityyppi())){
            		return i;
            	}
            	if(kortti.onVillikortti()){
            		return i;
            	}
            }
            
    	}else if(paallimmaisin.getKorttityyppi().equals("Numero")){
            for(int i = 0; i < omatKortit.size(); i++){
        		
            	Kortti kortti = omatKortit.get(i);
            	
            	if(kortti.getVari().equals(pelattavaVari)){
            		return i;
            	}else if(kortti.onVillikortti()){
            		return i;
            	}   	
            }
        	
            	
            for(int i = 0; i < omatKortit.size(); i++){
            		
            	Kortti kortti = omatKortit.get(i);
            		
            	if(kortti.getNumero() == paallimmaisin.getNumero()){
            		return i;
            	}else if(kortti.onVillikortti()){
            		return i;
            	}
            }
    	}
        	
           return -1;
    }
    	

    @Override
    public String valitseVari(ArrayList<Kortti> omatKortit) {
        String[] okVarit = {"Punainen", "Vihreä", "Sininen", "Keltainen"};
        Random random = new Random();
        int randomIndeksi = random.nextInt(okVarit.length);
        
        return okVarit[randomIndeksi];
    }

    @Override
    public String nimi() {
        // kirjoita tänne nimimerkkisi, jonka haluat mahdollisesti näkyvän 
        // myös muualla

        return "Vahtix-botti";
    }

}
