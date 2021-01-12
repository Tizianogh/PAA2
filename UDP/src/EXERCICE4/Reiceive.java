package EXERCICE4;

import java.io.IOException;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reiceive extends Thread {
    private int port;
    private int taille = 1024;
    private MulticastSocket ms;

    private byte buffer[] = new byte[taille];

    public Reiceive(MulticastSocket ms, int port) {
        this.ms=ms;
        this.port=port;
    }

    public void run() {
        try {
            InetAddress server = Chat.getInetAddress();
            SocketAddress socketAddress =  new InetSocketAddress("224.0.0.1", port);
            NetworkInterface networkInterface = NetworkInterface.getByName("bge0");

            ms.joinGroup(socketAddress,networkInterface);
            while (true) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
                DatagramPacket data = new DatagramPacket(buffer, taille);
                ms.receive(data);
                System.out.println("REICEIVED AT " + sdf.format(new Date()) + " " + " REICEIVED FROM " + data.getAddress() + " " + new String(data.getData(), 0, data.getLength()));
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}