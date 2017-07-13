import java.util.Random;

public class Lehma implements Lypsava, Eleleva {

	private String nimi;
	private double utareidenTilavuus;
	private double maidonMaara;
	private Random random;
	
	private static final String[] NIMIA = new String[]{
		    "Anu", "Arpa", "Essi", "Heluna", "Hely",
		    "Hento", "Hilke", "Hilsu", "Hymy", "Matti", "Ilme", "Ilo",
		    "Jaana", "Jami", "Jatta", "Laku", "Liekki",
		    "Mainikki", "Mella", "Mimmi", "Naatti",
		    "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
		    "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};
	
	public Lehma(){ 
		random = new Random();
		this.nimi = NIMIA[random.nextInt(NIMIA.length)];
		this.utareidenTilavuus = 15 + (random.nextDouble() * (40 - 15));
		this.maidonMaara = 0;
	}
	
	public Lehma(String nimi){
		random = new Random();
		this.nimi = nimi;
		this.utareidenTilavuus = 15 + (random.nextDouble() * (40 - 15));
		this.maidonMaara = 0;
	}

	public String getNimi(){
		return this.nimi;
	}
	
	public double getTilavuus(){
		return this.utareidenTilavuus;
	}
	
	public double getMaara(){
		return this.maidonMaara;
	}
	
	@Override
	public double lypsa() {
		double maito = this.getMaara();
		this.maidonMaara = 0;
		return maito;
	}

	@Override
	public void eleleTunti() {
		this.maidonMaara += 0.7 + (random.nextDouble() * (1 - 0.7));
		if(this.maidonMaara > this.utareidenTilavuus){
			this.maidonMaara = this.utareidenTilavuus;
		}
	}
	
	public String toString(){
		return this.nimi + " " + Math.ceil(this.maidonMaara) + "/" + Math.ceil(this.utareidenTilavuus);
	}
	
}
