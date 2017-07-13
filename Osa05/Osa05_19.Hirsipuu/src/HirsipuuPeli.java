import java.util.ArrayList;

import java.util.Scanner;

public class HirsipuuPeli {

	private int arvaustenMaara = 9;
	private String arvattavaSana;
	private String arvaus;
	private String loppuIlmoitus = "Hävisit!";
	private ArrayList<String> arvatutMerkit;
	private ArrayList<String> piilotettuSana;
	private Scanner lukija;	
	
	public HirsipuuPeli(String arvattavaSana, Scanner lukija){
		this.arvattavaSana = arvattavaSana.toLowerCase();
		arvatutMerkit = new ArrayList<String>();
		piilotettuSana = new ArrayList<String>();
		this.lukija = lukija;
		
        for(int i = 0; i < this.arvattavaSana.length(); i++){
        	piilotettuSana.add(" _ ");
        }
		
	}
	
	private void tulostaTilanne(){
		System.out.print("Sana: ");
    	for(String alkio : piilotettuSana){
    		System.out.print(alkio);
    	}       	
    	System.out.println("");
    	System.out.println("Arvauksia jaljella: " + arvaustenMaara);
    	System.out.print("Arvatut ");
    	
    	for(String alkio : arvatutMerkit){
    		System.out.print(alkio + " ");
    	}
    	System.out.println("");
	}
	
	public void pelaaHirsipuuta(){
		
		while(this.arvaustenMaara > 0){
			tulostaTilanne();
			
	    	System.out.println("Arvaus: ");
	    	arvaus = lukija.nextLine().toLowerCase();
			
			if(arvaus.length() > 1){
				System.out.println("Vain yksi merkki on sallittua arvata!");
				continue;
			}else if(arvatutMerkit.contains(arvaus)){
				System.out.println("Olet arvannut jo kyseisen merkin!");
				continue;
			}
        	
        	if(arvattavaSana.contains(arvaus)){
        		for(int i = 0; i < piilotettuSana.size(); i++){        			
        			if(arvattavaSana.charAt(i) == arvaus.charAt(0)){
        				piilotettuSana.set(i, arvaus);
        			}
        		}
        	}
        	
        	this.arvatutMerkit.add(arvaus);
        	
        	if(!piilotettuSana.contains(" _ ")){
        		loppuIlmoitus = "Voitit!";
        		break;       		
        	}
        	
        	arvaustenMaara--;
        	
		}
        
        System.out.println(loppuIlmoitus);
		
	}
	
	
}
