
public class Rekisterinumero {
    // älä muuta luokan jo valmiina olevia osia

    // oliomuuttujille on lisätty määre final, jolloin niiden arvoa ei asetuksen
    // jälkeen voi enää muuttaa
    private final String rekNro;
    private final String maa;

    public Rekisterinumero(String maa, String rekNro) {
        this.rekNro = rekNro;
        this.maa = maa;
    }

    @Override
    public String toString() {
        return maa + " " + rekNro;
    }
    
    public String getRekkari(){
    	return this.rekNro;
    }
    
    public String getMaa(){
    	return this.maa;
    }
    
    @Override
    public boolean equals(Object olio){
    	
    	if(olio == null){
    		return false;
    	}
    	
    	if(olio.getClass() != this.getClass()){
    		return false;
    	}
    	
    	Rekisterinumero rekkari = (Rekisterinumero)olio;
    	
    	if(rekkari.getRekkari().equals(this.getRekkari()) && rekkari.getMaa().equals(this.getMaa())){
    		return true;
    	}else{
    		return false;
    	}   	
    }
    
    @Override
    public int hashCode(){
    	return this.toString().hashCode();
    }

}
