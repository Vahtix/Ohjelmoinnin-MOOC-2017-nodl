package numerotiedustelu;

import java.util.Set;

public interface TiedusteluToiminnot {
	void lisaaPuhelinnumero(String omistaja, String puhelinnumero);
	Set<String> haePuhelinnumerot(String omistaja);
	String haeOmistaja(String puhelinnumero);
	void lisaaOsoite(String omistaja, String katu, String kaupunki);
	String haeHenkilonTiedot(String omistaja);
	void poistaHenkilonTiedot(String omistaja);
	String listaaFilteroidysti(String hakusana);
}
