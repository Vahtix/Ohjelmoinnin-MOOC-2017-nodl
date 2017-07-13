
public class Paivays {

    private int paiva;
    private int kuukausi;
    private int vuosi;

    public Paivays(int paiva, int kuukausi, int vuosi) {
        this.paiva = paiva;
        this.kuukausi = kuukausi;
        this.vuosi = vuosi;
    }

    @Override
    public String toString() {
        return this.paiva + "." + this.kuukausi + "." + this.vuosi;
    }

    public boolean aiemmin(Paivays verrattava) {
        if (this.vuosi < verrattava.vuosi) {
            return true;
        }

        if (this.vuosi == verrattava.vuosi
                && this.kuukausi < verrattava.kuukausi) {
            return true;
        }

        if (this.vuosi == verrattava.vuosi
                && this.kuukausi == verrattava.kuukausi
                && this.paiva < verrattava.paiva) {
            return true;
        }

        return false;
    }

    public int erotusVuosissa(Paivays verrattava) {
        if (aiemmin(verrattava)) {
            return verrattava.erotusVuosissa(this);
        }

        int vuosiPois = 0;

        if (this.kuukausi < verrattava.kuukausi) {
            vuosiPois = 1;
        } else if (this.kuukausi == verrattava.kuukausi && this.paiva < verrattava.paiva) {
            vuosiPois = 1;
        }

        return this.vuosi - verrattava.vuosi - vuosiPois;
    }
    
    public int getPaiva(){
    	return this.paiva;
    }
    
    public int getKuukausi(){
    	return this.kuukausi;
    }
    
    public int getVuosi(){
    	return this.vuosi;
    }

    @Override
    public boolean equals(Object olio){
    	
    	if(olio == null){
    		return false;
    	}
    	
    	if(olio.getClass() != this.getClass()){
    		return false;
    	}
    	
    	Paivays paivays = (Paivays)olio;
    	
    	if(paivays.getPaiva() == this.getPaiva() && paivays.getKuukausi() == this.getKuukausi() && paivays.getVuosi() == this.getVuosi()){
    		return true;
    	}else{
    		return false;
    	}
    	
    }
    
}
