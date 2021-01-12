package EXERCICE2.Client;

import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class HeureA

{
    final static int port = 8532;
    final static int taille = 1024;
    final static byte buffer[] = new byte[taille];

    public static void main(String argv[]) throws Exception

    {
        DatagramSocket socket = new DatagramSocket(port);
        while(true)
        {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
            DatagramPacket data = new DatagramPacket(buffer, taille);
            socket.receive(data);
            System.out.println("REICEIVED AT "+sdf.format(new Date())+" "+" REICEIVED FROM "+data.getAddress()+" "+new String(data.getData(), 0, data.getLength()));
            socket.send(data);

            // QUESTION : Pas nécessaire de faire du thread, c'est le principe de l'UDP
        }
    }
}