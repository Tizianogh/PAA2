package EXERCICE2;

import java.util.concurrent.Semaphore;

public class Jetons {
    private Semaphore semaphore;

    public Jetons(int nbJetons){
        this.semaphore = new Semaphore(nbJetons);
    }

    public int getJetons(){
        return this.semaphore.availablePermits();
    }

    public void jetonAcquire() throws InterruptedException {
        this.semaphore.acquire();
    }

    public Semaphore getSemaphore(){
        return semaphore;
    }
}
