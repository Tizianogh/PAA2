package EXERCICE1;

import java.util.Random;

public class TheThread extends Thread {
    private static int position = 0;
    private TheThread(){

        this.start();
    }
    public void run(){
       Random r = new Random();
        int i = 1;
        int max = r.nextInt(10);
        for(; i<=max; i++) {
            try {
                Thread.sleep(r.nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Toto "+this.getName()+" : "+i);
        }
        System.out.println("*** Toto a fini de compter jusqu'à "+(max)+", il est arrivé en position : "+ ++position);
    }

    public static void main(String[] args) {
        TheThread thread1 = new TheThread();
        TheThread thread2 = new TheThread();
        TheThread thread3 = new TheThread();
        TheThread thread4 = new TheThread();
        TheThread thread5 = new TheThread();
    }
}