
public class Taulukot {
    // HUOM! Älä lisää luokalle Taulukot oliomuuttujia
	
	public int[] kopioi(int[] taulukko){
		
		int[] kopioTaulukko = new int[taulukko.length];
		
		for(int i = 0; i < kopioTaulukko.length; i++){
			kopioTaulukko[i] = taulukko[i];
		}
		
		return kopioTaulukko;
	}
	
	public int[] kaanna(int[] taulukko){
		
		int[] kaannettyTaulukko = new int[taulukko.length];
		int j = 0;
		
		for(int i = taulukko.length - 1; i >= 0; i--){
			kaannettyTaulukko[j] = taulukko[i];
			j++;
		}
		
		return kaannettyTaulukko;
	}

}
