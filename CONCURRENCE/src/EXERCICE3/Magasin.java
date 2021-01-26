package EXERCICE3;

import java.util.LinkedList;
import java.util.Queue;

public class Magasin <Article>{
    private Queue<Article> magasin;
    private int taille;

   public Magasin(int taille){
       this.taille=taille;
        this.magasin = new LinkedList<>();
    }

    public synchronized Article enqueue() throws InterruptedException {
       while(magasin.size()<=0){
           this.wait();
       }
        this.notifyAll();
        return magasin.poll();
    }

    public synchronized void queue(Article item) throws InterruptedException {
       while(this.magasin.size()>=this.taille){
           this.wait();
       }
        magasin.add(item);
        this.notifyAll();
    }

    public String getList(){
       String chaine = "";
       for(Article unItem : magasin){
           chaine+=unItem.toString()+" ";
       }
       return chaine;
    }

}
