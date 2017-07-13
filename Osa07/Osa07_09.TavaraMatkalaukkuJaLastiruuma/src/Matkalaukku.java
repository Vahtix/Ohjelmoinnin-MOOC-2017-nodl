import java.util.ArrayList;

public class Matkalaukku {
	
	private ArrayList<Tavara> matkalaukku;
	private int maksimiPaino;
	
	public Matkalaukku(int maksimiPaino){
		this.maksimiPaino = maksimiPaino;
		this.matkalaukku = new ArrayList<Tavara>();
	}
	
	public void lisaaTavara(Tavara tavara){
		
		if(tavara.getPaino() + this.yhteispaino() <= this.maksimiPaino){
			this.matkalaukku.add(tavara);
		}
				
	}
	
	public int yhteispaino(){
		int kokonaisPaino = 0;
		
		for(Tavara tavara : matkalaukku){
			kokonaisPaino += tavara.getPaino();
		}
		
		return kokonaisPaino;
	}
	
	public String toString(){
		
		if(this.matkalaukku.isEmpty()){
			return "ei matkatavaroita (0 kg)";
		}else if(this.matkalaukku.size() == 1){
			return this.matkalaukku.size() + " tavara (" + this.yhteispaino() + " kg)";
		}else{
			return this.matkalaukku.size() + " tavaraa (" + this.yhteispaino() + " kg)";
		}			
	}
	
	public void tulostaTavarat(){
		for(Tavara tavara : matkalaukku){
			System.out.println(tavara);
		}
	}
	
	public Tavara raskainTavara(){
		
		if(this.matkalaukku.isEmpty()){
			return null;
		}else{
			Tavara raskainTavara = matkalaukku.get(0);
			
			for(Tavara tavara : matkalaukku){
				if(tavara.getPaino() > raskainTavara.getPaino()){
					raskainTavara = tavara;
				}
			}
			
			return raskainTavara;
			
		}
	}

}
