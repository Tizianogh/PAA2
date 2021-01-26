package EXERCICE3;

public class Fournisseur extends Thread {
    private String name;
    private int cpt = 0;
    private  Magasin<Article> magasin;

    public Fournisseur(String name, Magasin<Article> magasin){
        this.magasin=magasin;
        this.name=name;
        this.start();
    }

    public void addItem() throws InterruptedException {
        Article item = new Article(this.name + " " + ++cpt);
        System.err.println(this.getName()+" ajoute "+item);
        magasin.queue(item);
    }

    public void run() {

        while (true) {
            try {
                Thread.sleep(3000);
                this.addItem();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
