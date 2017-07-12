import java.util.ArrayList;

public class Peltipoliisi {
	
	
	private ArrayList<Rekisterinumero> rekisterit;
	
	public Peltipoliisi(){
		rekisterit = new ArrayList<Rekisterinumero>();
	}
	
	public ArrayList<Rekisterinumero> getRekkarit(){
		return this.rekisterit;
	}
	
	public void lisaaRekkari(Rekisterinumero rekkari){
		this.rekisterit.add(rekkari);
	}
	
	
	public Rekisterinumero getSuurin(){
		
		int suurinNopeus = rekisterit.get(0).getNopeus();
		Rekisterinumero rekisteri = rekisterit.get(0);
		
		for(int i = 0; i < rekisterit.size(); i++){
			if(rekisterit.get(i).getNopeus() > suurinNopeus){
				suurinNopeus = rekisterit.get(i).getNopeus();
				rekisteri = rekisterit.get(i);
			}
		}
		
		return rekisteri;
	}
	
	public Rekisterinumero getPienin(){
		
		int pieninNopeus = rekisterit.get(0).getNopeus();
		Rekisterinumero rekisteri = rekisterit.get(0);
		
		for(int i = 0; i < rekisterit.size(); i++){
			if(rekisterit.get(i).getNopeus() < pieninNopeus){
				pieninNopeus = rekisterit.get(i).getNopeus();
				rekisteri = rekisterit.get(i);
			}
		}
		
		return rekisteri;
	}
	
	public double getKeskiarvo(){
		int summa = 0;
		double keskiarvo;
		
		for(int i = 0; i < rekisterit.size(); i++){
			summa += rekisterit.get(i).getNopeus();
		}
		
		keskiarvo = (double)summa / rekisterit.size();
		return keskiarvo;
		
	}
	
}
