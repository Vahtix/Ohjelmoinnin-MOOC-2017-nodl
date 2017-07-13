package henkilot;

import java.util.List;

public class HenkiloTulostus {

	public void tulostaLaitoksenHenkilot(List<Henkilo> henkilot){
		
		for(Henkilo henkilo : henkilot){
			System.out.println(henkilo);
		}
		
	}
	
}
