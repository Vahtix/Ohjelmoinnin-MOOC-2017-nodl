package numerotiedustelu;

import java.util.HashSet;
import java.util.Set;

public class Henkilo implements Comparable<Henkilo> {

	private String nimi;
	private Set<String> puhelinnumerot;
	private String osoite;
	
	public Henkilo(String nimi){
		this.nimi = nimi;
		this.puhelinnumerot = new HashSet<>();
		this.osoite = "";
	}
	
	public void lisaaPuhelinnumero(String puhelinnumero){
		this.puhelinnumerot.add(puhelinnumero);
	}
	
	public String getNimi(){
		return this.nimi;
	}
	
	public Set<String> getPuhelinnumerot(){
		return this.puhelinnumerot;
	}
	
	public String getOsoite(){
		return this.osoite;
	}
	
	public void setOsoite(String katu, String kaupunki){
		this.osoite = katu + " " + kaupunki;
	}
	
	public String toString(){
		
		StringBuilder henkiloTiedot = new StringBuilder();
		
		if(this.osoite.equals("")){
			henkiloTiedot.append("    Osoite ei tiedossa\n");
		}else{
			henkiloTiedot.append("    Osoite: " + this.osoite +"\n");
		}
		
		if(this.puhelinnumerot.isEmpty()){
			henkiloTiedot.append("    ei puhelinta");
		}else{
			henkiloTiedot.append("    Puhelinnumerot\n");
			
			for(String numero : this.puhelinnumerot){
				henkiloTiedot.append("      " + numero + "\n");
			}
		}
		

		
		return henkiloTiedot.toString();
	}
	
	public String kaikkiTiedot(){
		return "  " + this.nimi + "\n" + 
				this.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nimi == null) ? 0 : nimi.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Henkilo))
			return false;
		Henkilo verrattava = (Henkilo) obj;
		if (nimi == null) {
			if (verrattava.nimi != null)
				return false;
		} else if (!nimi.equals(verrattava.nimi))
			return false;
		return true;
	}

	public int compareTo(Henkilo henkilo) {
		return this.nimi.compareTo(henkilo.getNimi());
	}
	
}
