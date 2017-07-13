package laatikot;

import java.util.ArrayList;
import java.util.List;

public class YhdenTavaranLaatikko extends Laatikko {
	
	private List<Tavara> laatikko;
	
	public YhdenTavaranLaatikko(){
		this.laatikko = new ArrayList<Tavara>();
	}

	@Override
	public void lisaa(Tavara tavara) {
		if(this.laatikko.isEmpty()){
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

}
