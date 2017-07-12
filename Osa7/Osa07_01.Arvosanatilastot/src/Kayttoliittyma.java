import java.util.Scanner;

public class Kayttoliittyma {
	
	private Scanner lukija;
	private Pistetilasto pistetilasto;
	
	public Kayttoliittyma(){
		lukija = new Scanner(System.in);
		pistetilasto = new Pistetilasto();
	}
	
	public void kaynnista(){
		int piste = 0;
		String[][] arvosanajakauma;
		System.out.println("Syota yhteispisteet, -1 lopettaa:");
		
		while(piste != -1){
			piste = Integer.parseInt(this.lukija.nextLine());
			pistetilasto.lisaaPiste(piste);			
		}	
		
		arvosanajakauma = pistetilasto.getArvosanaJakauma();
		
		System.out.println("Pisteiden keskiarvo (kaikki): " + pistetilasto.getYhteiskeskiarvo());
		System.out.println("Pisteiden keskiarvo (hyvaksytyt): " + pistetilasto.getHyvaksyttyjenKeskiarvo());
		System.out.println("Hyvaksymisprosentti: " + pistetilasto.getHyvaksymisProsentti());
		System.out.println("Arvosanajakauma: ");
		
		for(int i = 0; i < arvosanajakauma.length; i++){
			for(int j = 0; j < arvosanajakauma[i].length; j++){
				System.out.print(arvosanajakauma[i][j]);
			}
			System.out.println("");
		}
		
		
	}

}
