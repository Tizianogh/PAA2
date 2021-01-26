package EXERCICE1;

public class Main {
    public static void main(String[] args) {

        Thread c1 = new Compteur();
        Thread c2 = new Compteur();
        Thread c3 = new Compteur();
        Thread c4 = new Compteur();

        c1.setName("Ihsane");
        c2.setName("Abel");
        c3.setName("Tiz");
        c4.setName("julien");

    }
}
