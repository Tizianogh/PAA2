package EXERCICE1;

import EXERCICE1.Verrou;

import java.util.Random;

public class Compteur extends Thread{

    private static int cpt = 0;
    private static Verrou verrou = new Verrou();

    public Compteur() {
        this.start();
    }

    public void run() {

        Random r = new Random();
        int random = r.nextInt(5000);


        while(cpt < 10) {
            try {
                Thread.sleep(random);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                verrou.lock();
                if (cpt < 10) {

                    System.err.println("Toto" + this.getName()+ " : " + cpt++);

                }
                else {
                    System.err.println("Toto "+this.getName()+" a fini de compter jusqu�a " + cpt);
                }
                verrou.unLock();
            } catch (InterruptedException e) {
                System.out.println("je passe mon tour");
            }
        }
    }
}

