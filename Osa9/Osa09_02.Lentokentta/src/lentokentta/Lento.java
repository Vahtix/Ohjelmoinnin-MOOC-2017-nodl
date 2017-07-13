package lentokentta;

public class Lento {

	private Lentokone lentokone;
	private String lahtopaikka;
	private String paamaara;
	
	public Lento(Lentokone lentokone, String lahtopaikka, String paamaara){
		this.lentokone = lentokone;
		this.lahtopaikka = lahtopaikka;
		this.paamaara = paamaara;
	}
	
	public String toString(){
		return this.lentokone.getTunnus() + " (" + this.lentokone.getKapasiteetti() + " henkilöä) (" + this.lahtopaikka + "-" + this.paamaara + ")";
	}
	
}
