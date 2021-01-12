package EXERCICE3.PROPRE;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

import static java.net.InetAddress.getByName;

public class Send extends Thread {

    private int port;
    private int taille = 1024;
    private DatagramSocket s;
    private  InetAddress serveur = null;

    public Send(DatagramSocket s, int port) throws UnknownHostException {
        this.port = port;
        this.s = s;
        serveur = getByName("127.0.0.1");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("Entrez votre message : ");
                String a = scanner.nextLine();

                int length = a.length();
                byte buffer[] = a.getBytes();
                DatagramPacket dataSent = new DatagramPacket(buffer, length, serveur, port);
                s.send(dataSent);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



