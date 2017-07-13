package sovellus;

import java.util.Random;

public class Lampomittari implements Sensori {
	
	private boolean paalla;
	private Random random;
	
	public Lampomittari(){
		this.paalla = false;
		this.random = new Random();
	}

	@Override
	public boolean onPaalla() {
		return this.paalla;
	}

	@Override
	public void paalle() { 
		this.paalla = true;
	}

	@Override
	public void poisPaalta() {
		this.paalla = false;
	}

	@Override
	public int mittaa() {	
		if(this.onPaalla()){
			return (random.nextInt(60)-30);
		}else{
			throw new IllegalStateException("Mittausta ei voida tehda koska mittari ei ole paalla");
		}
		
	}

}
