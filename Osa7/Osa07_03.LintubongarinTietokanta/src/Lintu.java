
public class Lintu {
	
	private String nimi;
	private String latinaNimi;
	private int havainnot = 0;
	
	public Lintu(String nimi, String latinaNimi){
		this.nimi = nimi;
		this.latinaNimi = latinaNimi;
	}
	
	public String getNimi(){
		return this.nimi;
	}
	
	public String getLatinaNimi(){
		return this.latinaNimi;
	}
	
	public int getHavainnot(){
		return this.havainnot;
	}
	
	public void lisaaHavainto(){
		this.havainnot++;
	}
	
	public String toString(){
		return this.nimi + " (" + this.latinaNimi + "): " + this.havainnot + " havaintoa"; 
	}

}
