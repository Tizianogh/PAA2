package EXERCICE1;

public class Verrou {

    private  boolean verrou = true;

    public synchronized void lock() throws InterruptedException {
        while(!verrou) {
            this.wait();
        }
        this.verrou = false;
    }

    public synchronized void unLock() {
        this.verrou = true;
        this.notifyAll();
    }

    public synchronized boolean getVerrou() {
        return verrou;
    }

}