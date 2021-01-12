package EXERCICE3;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

import static java.net.InetAddress.getByName;

public class Send extends Thread {

    private int port = 8181;
    private int taille = 1024;

    public Send(int port) {
        this.port = port;
    }

    public void run() {
        //Scanner pour l'entrée de l'utilisateur
        Scanner scanner = new Scanner(System.in);

        InetAddress serveur = null;
        try {
            serveur = getByName("127.0.0.1");

            DatagramSocket socket = new DatagramSocket();

            while (true) {
                System.out.println("Entrez votre message : ");
                String a = scanner.nextLine();

                int length = a.length();
                byte buffer[] = a.getBytes();
                DatagramPacket dataSent = new DatagramPacket(buffer, length, serveur, port);
                socket.send(dataSent);
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



