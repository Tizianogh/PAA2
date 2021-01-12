package Exercice1;

import java.util.Random;

public class UnThread extends Thread {

    private UnThread(){
        this.start();
    }
    public void run(){
      for(int i = 0; i<9;i++){
          System.out.println(" Hello world "+this.getName());
      }
    }

    public static void main(String[] args) {
        UnThread thread1 = new UnThread();
        UnThread thread2 = new UnThread();
        UnThread thread3 = new UnThread();
        UnThread thread4 = new UnThread();
        UnThread thread5 = new UnThread();
    }
}