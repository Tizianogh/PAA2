package EXERCICE2.Server;

import java.net.*;

public class HeureB
{
    final static int port = 8532;
    final static int taille = 1024;
    final static byte buffer[] = new byte[taille];
    public static void main(String argv[]) throws Exception
    {
        //Lancer via CMD avec port 8532
        InetAddress serveur = InetAddress.getByName(argv[0]);
        int length = argv[1].length();
        byte buffer[] = argv[1].getBytes();
        DatagramPacket dataSent = new DatagramPacket(buffer, length, serveur, port);
        DatagramSocket socket = new DatagramSocket();
        socket.send(dataSent);
        DatagramPacket dataReceived = new DatagramPacket(new byte[taille], taille);
        socket.receive(dataReceived);
        System.out.println("Data received : " + new String(dataReceived.getData(), 0, dataReceived.getLength()));
        System.out.println("From : " + dataReceived.getAddress() + ":" + dataReceived.getPort());
    }
}