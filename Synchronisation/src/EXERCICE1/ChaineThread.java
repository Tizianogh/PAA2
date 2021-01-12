package EXERCICE1;

public class ChaineThread extends Thread {

    private static String chaine = "";
    private static StringBuilder sb = new StringBuilder(chaine);

    public ChaineThread(String name) {
        this.setName(name);
    }

    public void run() {
        synchronized (sb){
            sb.append(this.getName()+" ");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread un = new ChaineThread("Un");
        Thread deux = new ChaineThread("Deux");
        Thread trois = new ChaineThread("Trois");

        un.start();
        deux.start();
        trois.start();

        un.join();
        deux.join();
        trois.join();

        System.out.println("Resultat : "+ChaineThread.getChaine());
    }

    private static String getChaine() {
        return sb.toString();
    }
}
