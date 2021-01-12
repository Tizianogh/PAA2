package Exercice4;

public class UnThread extends Thread {
    private static int[] tableau = new int[]{45,2,3,42,23,1};

    private UnThread(){

    }

    private static void triTable(int[] tableau){
        int i,j, tampon;

        for(i = 0; i<tableau.length; i++){
            tampon=tableau[i];
            j=i;
            while((j>=1) && (tableau[j-1])>tampon){
                tableau[j]=tableau[j-1];
                j=j-1;
            }
            System.out.println(tableau[j]=tampon);
        }
    }

    public void run(){

    }

    public static void main(String[] args) {
        triTable(tableau);
    }
}