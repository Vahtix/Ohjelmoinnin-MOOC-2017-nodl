package varastot;

public class MuistavaTuotevarasto extends Tuotevarasto {

	private Muutoshistoria muutoshistoria;
	
	public MuistavaTuotevarasto(String tuotenimi, double tilavuus, double alkusaldo) {
		super(tuotenimi, tilavuus);
		this.muutoshistoria = new Muutoshistoria();
		this.lisaaVarastoon(alkusaldo);
		
	}

	@Override
	public void lisaaVarastoon(double maara){
		super.lisaaVarastoon(maara);
		this.muutoshistoria.lisaa(super.getSaldo());
	}
	
	@Override
	public double otaVarastosta(double maara){	
		 double nykyinenSaldo = super.otaVarastosta(maara);
	     this.muutoshistoria.lisaa(super.getSaldo());
	     return nykyinenSaldo;
	}
	
	public String historia() {
		return this.muutoshistoria.toString();
	}
	
	public void tulostaAnalyysi(){
		
		String analyysi = "Tuote: " + super.getNimi() + "\n" +
				"Historia: " + this.historia() + "\n" +
				"Suurin tuotemäärä: " + this.muutoshistoria.maxArvo() + "\n" +
				"Pienin tuotemäärä: " + this.muutoshistoria.minArvo() + "\n" + 
				"Keskiarvo: " + this.muutoshistoria.keskiarvo() + "\n" +
				"Suurin muutos: " + this.muutoshistoria.suurinMuutos() + "\n" + 
				"Varianssi: " + this.muutoshistoria.varianssi();
		
		System.out.println(analyysi);
		
	}

}
