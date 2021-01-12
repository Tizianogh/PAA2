package EXERCICE3.PROPRE;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reiceive extends Thread {
    private int port;
    private int taille = 1024;
    private DatagramSocket s;

    private byte buffer[] = new byte[taille];

    public Reiceive(DatagramSocket s) {
        this.s = s;
    }

    public void run() {
        try {
            while (true) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
                DatagramPacket data = new DatagramPacket(buffer, taille);
                s.receive(data);
                System.out.println("REICEIVED AT " + sdf.format(new Date()) + " " + " REICEIVED FROM " + data.getAddress() + " " + new String(data.getData(), 0, data.getLength()));
               //socket.send(data);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}