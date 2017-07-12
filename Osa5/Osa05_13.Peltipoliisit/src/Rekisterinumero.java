
public class Rekisterinumero {
	
	private String rekkari;
	private int nopeus;
	
	public Rekisterinumero(String rekkari, int nopeus){
		this.rekkari = rekkari;
		this.nopeus = nopeus;
	}
	
	public String getRekkari(){
		return this.rekkari;
	}
	
	public int getNopeus(){
		return this.nopeus;
	}
	
	public String toString(){
		return this.rekkari + ", " + this.nopeus;
	}
}

