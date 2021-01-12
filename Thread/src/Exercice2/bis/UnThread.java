import java.util.Random;

public class UnThread extends Thread {
    private static int position = 0;
    private static int compteurShare = 1;
    private UnThread(){
        this.start();
    }
    public void run(){
        Random r = new Random();
        int i = 1;
        int max = r.nextInt(10);
        for(; compteurShare<=max; compteurShare++) {
            try {
                Thread.sleep(r.nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Toto "+this.getName()+" : "+compteurShare);
        }
        System.out.println("*** Toto a fini de compter jusqu'à "+(compteurShare)+", il est arrivé en position : "+ ++position);


    }

    public static void main(String[] args) {
        UnThread thread1 = new UnThread();
        UnThread thread2 = new UnThread();
        UnThread thread3 = new UnThread();
        UnThread thread4 = new UnThread();
        UnThread thread5 = new UnThread();
    }
}