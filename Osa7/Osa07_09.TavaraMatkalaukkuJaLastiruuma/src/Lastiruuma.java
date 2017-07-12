import java.util.ArrayList;

public class Lastiruuma {
	
	private int maksimipaino;
	private ArrayList<Matkalaukku> lasti;
	
	public Lastiruuma(int maksimipaino){
		this.maksimipaino = maksimipaino;
		this.lasti = new ArrayList<Matkalaukku>();
	}
	
	public void lisaaMatkalaukku(Matkalaukku laukku){
		if(laukku.yhteispaino() + this.yhteisPaino() <= this.maksimipaino){
			this.lasti.add(laukku);
		}		
	}
	
	public int yhteisPaino(){
		int yhteispaino = 0;
		
		for(Matkalaukku laukku : lasti){
			yhteispaino += laukku.yhteispaino();
		}
		
		return yhteispaino;
		
	}
	
	public String toString(){
		return this.lasti.size() + " matkalaukkua (" + this.yhteisPaino() + " kg)";
	}
	
	public void tulostaTavarat(){		
		for(Matkalaukku laukku : this.lasti){
			laukku.tulostaTavarat();
		}
	}

}
