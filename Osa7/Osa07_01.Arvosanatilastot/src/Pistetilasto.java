import java.util.ArrayList;

public class Pistetilasto {
	
	private ArrayList<Integer> pisteet;
	private ArrayList<Integer> arvosanat;
	private double yhteisKeskiarvo = 0;
	private double hyvaksyttyjenKeskiarvo = 0;
	private double hyvaksyttyjenProsenttiosuus = 0;
	private String[][] arvosanajakauma;
	
	public Pistetilasto(){
		this.pisteet = new ArrayList<Integer>();
		this.arvosanat = new ArrayList<Integer>();
		this.arvosanajakauma = new String[6][2];
	}
	
	public void lisaaPiste(int piste){
		
		if(piste >= 0 && piste <= 100){
			this.pisteet.add(piste);
		}
	}
	
	public double getYhteiskeskiarvo(){		
		int pisteidenSumma = 0;
		
		for(int i = 0; i < this.pisteet.size(); i++){
			pisteidenSumma += this.pisteet.get(i);
		}
		
		this.yhteisKeskiarvo = (double)pisteidenSumma / this.pisteet.size();
		
		return this.yhteisKeskiarvo;
	}
	
	public double getHyvaksyttyjenKeskiarvo(){
		int pisteidenSumma = 0;
		int pisteidenLkm = 0;
		
		for(int i = 0; i < this.pisteet.size(); i++){
			if(this.pisteet.get(i) > 50){
				pisteidenSumma += this.pisteet.get(i);
				pisteidenLkm++;
			}			
		}
		
		this.hyvaksyttyjenKeskiarvo = (double)pisteidenSumma / pisteidenLkm;
		
		return this.hyvaksyttyjenKeskiarvo;
	}
	
	public double getHyvaksymisProsentti(){
		int hyvaksyttyjenLkm = 0;
		
		for(int i = 0; i < this.pisteet.size(); i++){
			if(this.pisteet.get(i) > 50){
				hyvaksyttyjenLkm++;
			}
		}
		
		this.hyvaksyttyjenProsenttiosuus = 100 * (double)hyvaksyttyjenLkm / (double)this.pisteet.size();
		
		return this.hyvaksyttyjenProsenttiosuus;
	}
	
	public String[][] getArvosanaJakauma(){
		
		this.muunnaPisteetArvosanoiksi();
		
		for(int i = 0; i < this.arvosanajakauma.length; i++){
			
			this.arvosanajakauma[i][0] = "" + i + ": ";
			this.arvosanajakauma[i][1] = this.laskeArvosananMaara(i);
		}
		
		return arvosanajakauma;
	
	}
	
	private void muunnaPisteetArvosanoiksi(){
		int arvosana = 0;
		
		for(int i = 0; i < this.pisteet.size(); i++){			
			arvosana = this.pisteet.get(i);
			this.arvosanat.add(this.muunnaArvosanaksi(arvosana));			
		}	
	}
	
	private int muunnaArvosanaksi(int piste){
		int arvosana;
		
		if(piste < 51){
			arvosana = 0;
		}else if(piste >= 51 && piste < 61){
			arvosana = 1;
		}else if(piste >= 61 && piste < 71){
			arvosana = 2;
		}else if(piste >= 71 && piste < 81){
			arvosana = 3;
		}else if(piste >= 81 && piste < 91) {
			arvosana = 4;
		}else{
			arvosana = 5;
		}
		
		return arvosana;
	}
	
	private String laskeArvosananMaara(int arvosana){
		StringBuilder arvosananLkm = new StringBuilder();
		
		for(int i = 0; i < this.arvosanat.size(); i++){
			if(this.arvosanat.get(i) == arvosana){
				arvosananLkm.append("*");
			}
		}
		
		System.out.println(arvosananLkm.toString());
		
	    return arvosananLkm.toString();
	}

}
