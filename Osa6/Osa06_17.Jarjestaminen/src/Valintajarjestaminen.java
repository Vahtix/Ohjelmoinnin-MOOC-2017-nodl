
public class Valintajarjestaminen {
	
    public void tulostaTyylikkaasti(int[] taulukko) {
    	
    	StringBuilder tulostus = new StringBuilder();
    	
        for(int i = 0; i < taulukko.length; i++){
        	tulostus.append(taulukko[i] + ", ");
        }
        
        tulostus.replace(tulostus.length() - 2, tulostus.length() - 1, "");
        System.out.println(tulostus);
    }
	
	public int pienin(int[] taulukko) {
		
		int pienin = taulukko[0];
		
		for(int i = 1; i < taulukko.length; i++){
			if(taulukko[i] < pienin){
				pienin = taulukko[i];
			}
		}
		
	    return pienin;
	}
	
	public int pienimmanIndeksi(int[] taulukko) {
	    
		int pienimmanIndeksi = 0;
		int pienin = taulukko[0];
		
		for(int i = 1; i < taulukko.length; i++){
			if(taulukko[i] < pienin){
				pienimmanIndeksi = i;
				pienin = taulukko[i];
			}
		}

		return pienimmanIndeksi;
	}
	
	public int pienimmanIndeksiAlkaen(int[] taulukko, int aloitusIndeksi) {
		int pienimmanIndeksi = aloitusIndeksi;
		int pienin = taulukko[aloitusIndeksi];
		
		for(int i = aloitusIndeksi; i < taulukko.length; i++){
			if(taulukko[i] < pienin){
				pienimmanIndeksi = i;
				pienin = taulukko[i];
			}
		}

		return pienimmanIndeksi;
	}
	
	public void vaihda(int[] taulukko, int indeksi1, int indeksi2) {
        int eka = taulukko[indeksi1];
        int toka = taulukko[indeksi2];
        
        taulukko[indeksi1] = toka;
        taulukko[indeksi2] = eka;
	}
	
	public void jarjesta(int[] taulukko) {
		
		int pieninIndeksi = 0;
		
		this.tulostaTyylikkaasti(taulukko);
		
		for(int i = 0; i < taulukko.length; i++){
			pieninIndeksi = this.pienimmanIndeksiAlkaen(taulukko, i);						
			this.vaihda(taulukko, i, pieninIndeksi);
			this.tulostaTyylikkaasti(taulukko);
		}
		
	}
	
}
