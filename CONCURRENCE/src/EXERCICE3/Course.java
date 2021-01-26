package EXERCICE3;

import java.util.Random;

public class Course extends Thread {

    private Magasin<Article> magasin;

    public Course(Magasin<Article> magasin) {
        this.magasin=magasin;
        this.start();
    }

    public void removeItem() throws InterruptedException {
        System.out.println(this.getName()+" retire "+magasin.enqueue());
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
                this.removeItem();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
