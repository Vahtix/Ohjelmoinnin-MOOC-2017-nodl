package varastot;

public class Main {

    public static void main(String[] args) {
    	MuistavaTuotevarasto mehu = new MuistavaTuotevarasto("Juice", 1000.0, 1000.0);
    	mehu.otaVarastosta(11.3);
    	mehu.lisaaVarastoon(1.0);
    	mehu.tulostaAnalyysi();
 
    }

}
