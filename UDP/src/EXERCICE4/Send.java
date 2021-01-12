package EXERCICE4;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Send extends Thread {

    private int port;
    private MulticastSocket ms;

    public Send(MulticastSocket ms,int port) {
        this.ms=ms;
        this.port = port;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        try {
           InetAddress server= Chat.getInetAddress();
            while (true) {
                System.out.println("Entrez votre message : ");
                String a = scanner.nextLine();
                int length = a.length();
                byte buffer[] = a.getBytes();
                DatagramPacket dataSent = new DatagramPacket(buffer, length, server, port);
                ms.send(dataSent);
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



