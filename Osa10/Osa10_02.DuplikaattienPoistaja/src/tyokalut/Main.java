package tyokalut;

public class Main {

    public static void main(String[] args) {
        DuplikaattienPoistaja poistaja = new OmaDuplikaattienPoistaja();
        poistaja.lisaa("eka");
        poistaja.lisaa("toka");
        poistaja.lisaa("eka");

        System.out.println("Duplikaattien maara nyt: " +
        poistaja.getHavaittujenDuplikaattienMaara());

        poistaja.lisaa("vika");
        poistaja.lisaa("vika");
        poistaja.lisaa("uusi");

        System.out.println("Duplikaattien maara nyt: " +
        poistaja.getHavaittujenDuplikaattienMaara());

        System.out.println("Uniikit merkkijonot: " +
        poistaja.getUniikitMerkkijonot());

        poistaja.tyhjenna();

        System.out.println("Duplikaattien maara nyt: " +
        poistaja.getHavaittujenDuplikaattienMaara());

        System.out.println("Uniikit merkkijonot: " +
        poistaja.getUniikitMerkkijonot());
    }
}
