
public class Sanatulostin {

	private String sana;
	
	public Sanatulostin(String sana){
		this.sana = sana;
	}
	
	public void sanaporras(int luku){
		
        int sanaIndeksi = 0;
        int porras = 1;
        while (porras <= luku) {
 
            sanaIndeksi = tulostaRivi(porras, sanaIndeksi);
 
            System.out.println("");
            porras++;
        }       
        System.out.println("");		
	}

	public void laskevaSanaporras(int luku){
		int sanaIndeksi = 0;
        int porras = luku;
        while (porras >= 1) {
 
            sanaIndeksi = tulostaRivi(porras, sanaIndeksi);
 
            System.out.println("");
            porras--;
        }
    }
    public void sanapyramidi(int luku){
    	int sanaIndeksi = 0;
        int porras = 1;
        while (porras <= luku) {
            sanaIndeksi = tulostaRivi(porras, sanaIndeksi);
            System.out.println("");
            porras++;
        }
 
        porras -= 2;
 
        while (porras >= 1) {
            sanaIndeksi = tulostaRivi(porras, sanaIndeksi);
 
            System.out.println("");
            porras--;
        }
    }
	
    private int tulostaRivi(int merkkejaYhteensa, int sanaIndeksi) {
    	int merkkeja = 1;
        while (merkkeja <= merkkejaYhteensa) {
            System.out.print(this.sana.charAt(sanaIndeksi));
 
            sanaIndeksi++;
            if (sanaIndeksi >= this.sana.length()) {
                sanaIndeksi = 0;
            }
 
            merkkeja++;
        }
        
        return sanaIndeksi;
	}
}
