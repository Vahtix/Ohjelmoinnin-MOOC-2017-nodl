package laatikot;

import java.util.ArrayList;
import java.util.List;

public class MaksimipainollinenLaatikko extends Laatikko {
	
	private int maksimipaino;
	private List<Tavara> laatikko;
	
	public MaksimipainollinenLaatikko(int maksimipaino){
		this.maksimipaino = maksimipaino;
		this.laatikko = new ArrayList<Tavara>();
	}

	@Override
	public void lisaa(Tavara tavara) {
		if(tavara.getPaino() + this.getLaatikonPaino() <= this.maksimipaino){
			this.laatikko.add(tavara);
		}
		
	}

	@Override
	public boolean onkoLaatikossa(Tavara tavara) {
		if(this.laatikko.contains(tavara)){
			return true;
		}else{
			return false;
		}
	}
	
	private int getLaatikonPaino(){
		int kokonaispaino = 0;
		
		for(Tavara tavara : this.laatikko){
			kokonaispaino += tavara.getPaino();
		}
		
		return kokonaispaino;
	}

}
