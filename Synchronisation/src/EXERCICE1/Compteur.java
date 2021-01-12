package EXERCICE1;

public class Compteur {
    private int compteur =0;

    public synchronized void incrementerAfficher(){
        System.out.println(++compteur);
    }
}
