package luola;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pelilogiikka {
	
	private final char[] mahdollisetKomennot = {'w', 'a', 's', 'd'};
	private int luolanLeveys, luolanKorkeus, hirvioidenMaara;
	private String[][] pelialue;
	private List<Pelihahmo> pelihahmot;
	private boolean hirviotLiikkuvat;
	private Random random;
	
	public Pelilogiikka(int luolanKorkeus, int luolanLeveys, int hirvioidenMaara, boolean hirviotLiikkuvat){
		this.luolanKorkeus = luolanKorkeus;
		this.luolanLeveys = luolanLeveys;	
		this.pelialue = new String[luolanKorkeus][luolanLeveys];
		this.hirvioidenMaara = hirvioidenMaara;
		this.pelihahmot = new ArrayList<Pelihahmo>();
		this.hirviotLiikkuvat = hirviotLiikkuvat;
		this.random = new Random();
		this.alustaPeli();
	}
	
	private void alustaPeli(){
		alustaLuola();
		luoPelaaja();
		luoHirviot();
		sijoitaHahmotLuolaan();
	}

	private void alustaLuola(){
		for(int i = 0; i < this.pelialue.length; i++){
			for(int j = 0; j < this.pelialue[i].length; j++){
				pelialue[i][j] = ".";
			}
		}
	}
	
	private void luoPelaaja(){
		pelihahmot.add(new Pelihahmo("@", new Sijainti(0,0)));
	}
	
	private void luoHirviot(){
		for(int i = 0; i < hirvioidenMaara; i++){
			pelihahmot.add(new Pelihahmo("h", new Sijainti((random.nextInt(luolanKorkeus - 1) + 1), (random.nextInt(luolanLeveys - 1) + 1))));
		}
	}
	
	private void sijoitaHahmotLuolaan() {		
		for(Pelihahmo hahmo : pelihahmot){
			pelialue[hahmo.getSijainti().getY()][hahmo.getSijainti().getX()] = hahmo.getAvatari();
		}
	}
	
	public void suoritaSiirrot(String komennot){
		for(int i = 0; i < komennot.length(); i++){
			
			if(komennot.charAt(i) == mahdollisetKomennot[0]){ //Pelaaja Liikkuu ylospain
				
				if(onkoSallittuSiirto(pelihahmot.get(0).getSijainti().getY() - 1, pelihahmot.get(0).getSijainti().getX())){
					pelihahmot.get(0).liiku(-1, 0);
				}
								
			}else if(komennot.charAt(i) == mahdollisetKomennot[1]){ //Pelaaja liikkuu vasemmalle
				
				if(onkoSallittuSiirto(pelihahmot.get(0).getSijainti().getY(), pelihahmot.get(0).getSijainti().getX() - 1)){
					pelihahmot.get(0).liiku(0, -1);
				}
							
			}else if(komennot.charAt(i) == mahdollisetKomennot[2]){ //Pelaaja liikkuu alaspain
				
				if(onkoSallittuSiirto(pelihahmot.get(0).getSijainti().getY() + 1, pelihahmot.get(0).getSijainti().getX())){
					pelihahmot.get(0).liiku(1, 0);
				}			
				
			}else if(komennot.charAt(i) == mahdollisetKomennot[3]){ //Pelaaja liikkuu oikealle
				
				if(onkoSallittuSiirto(pelihahmot.get(0).getSijainti().getY(), pelihahmot.get(0).getSijainti().getX() + 1)){
					pelihahmot.get(0).liiku(0, 1);
				}	
		
			}
			
			tuhoaMahdollinenHirvio();
			
			if(this.hirviotLiikkuvat){
				liikutaHirvioita();
				tuhoaMahdollinenHirvio();
			}			
		}

		alustaLuola();
		sijoitaHahmotLuolaan();
	}
	
	private void liikutaHirvioita() {
		
		int y, x;
		
		for(int i = 1; i < pelihahmot.size(); i++){
			y = random.nextInt(2) - 1;
			x = random.nextInt(2) - 1;
			
			if(onkoSallittuSiirto(pelihahmot.get(i).getSijainti().getY() + y, pelihahmot.get(i).getSijainti().getX() + x)){
				pelihahmot.get(i).liiku(y, x);
			}
		}
		
	}

	private void tuhoaMahdollinenHirvio() {
		
		List<Pelihahmo> tempHahmot = pelihahmot;
		Pelihahmo pelaaja = pelihahmot.get(0);
		Pelihahmo hirvio;
		
		for(int i = 1; i < tempHahmot.size(); i++){
			hirvio = tempHahmot.get(i);
			
			if(pelaaja.getSijainti().equals(hirvio.getSijainti())){
				pelihahmot.remove(i);
			}
			
		}
		
	}

	private boolean onkoSallittuSiirto(int y, int x){	
		if(y < 0 || y >= pelialue[0].length){
			return false;
		}else if(x < 0 || x >= pelialue.length){
			return false;
		}		
		return true;
	}
	
	public String getTilanne(){
		StringBuilder tilanne = new StringBuilder();
		
		for(int i = 0; i < this.pelialue.length; i++){
			for(int j = 0; j < this.pelialue[i].length; j++){
				tilanne.append(pelialue[i][j]);
			}
			tilanne.append("\n");
		}
		
		return tilanne.toString();
	}
	
	public String getPelihahmot(){
		StringBuilder pelihahmotEsitys = new StringBuilder();
		
		for(Pelihahmo hahmo : pelihahmot){
			pelihahmotEsitys.append(hahmo.toString() + "\n");
		}
		
		return pelihahmotEsitys.toString();
	}
	
	public boolean tarkistaVoitto(){
		if(pelihahmot.size() == 1){
			return true;
		}else{
			return false;
		}
	}
}
