package luola;

public class Pelihahmo implements Liikkuva{

	private String avatari;
	private Sijainti sijainti;
	
	public Pelihahmo(String avatari, Sijainti sijainti){
		this.avatari = avatari;
		this.sijainti = sijainti;
	}
	
	public String getAvatari() {
		return avatari;
	}

	public Sijainti getSijainti(){
		return this.sijainti;
	}
	
	@Override
	public void liiku(int y, int x) {
		this.sijainti.siirra(y, x);		
	}
	
	public String toString(){
		return this.avatari + " " + sijainti.toString();
	}
	
}
