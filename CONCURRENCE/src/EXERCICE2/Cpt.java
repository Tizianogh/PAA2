package EXERCICE2;

import java.util.concurrent.Semaphore;

public class Cpt extends Thread {
    private int value = 0;
    private Semaphore sema;

    public Cpt(Semaphore s) {
        this.sema = s;
        this.start();
    }

    public void run() {
        while (value <= 10) {
            try {
                this.sema.acquire();
                System.out.println("hi ! " + this.value++);
                this.sema.release();
                System.out.println(this.sema.availablePermits());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Semaphore sema = new Semaphore(5);
        Cpt j = new Cpt(sema);
        Cpt j2 = new Cpt(sema);
        Cpt j3 = new Cpt(sema);
        Cpt j4 = new Cpt(sema);
        Cpt j5 = new Cpt(sema);
        Cpt j6 = new Cpt(sema);
        Cpt j7 = new Cpt(sema);
    }
}
