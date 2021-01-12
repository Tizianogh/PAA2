package EXERCICE1;

public class UnThread extends Thread {
    private static int position = 0;
    Compteur compteur;
    private UnThread(Compteur compteur){
        this.compteur=compteur;
    }

    public void run(){
        this.compteur.incrementerAfficher();
    }

    public static void main(String[] args) {
        Compteur compteur = new Compteur();
        UnThread thread1 = new UnThread(compteur);
        UnThread thread2 = new UnThread(compteur);
        UnThread thread3 = new UnThread(compteur);
        UnThread thread4 = new UnThread(compteur);
        UnThread thread5 = new UnThread(compteur);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}