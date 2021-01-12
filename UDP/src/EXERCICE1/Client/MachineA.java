package EXERCICE2.Client;

import java.net.*;
class MachineA
{
    final static int port = 8532;
    final static int taille = 1024;
    final static byte buffer[] = new byte[taille];
    public static void main(String argv[]) throws Exception
    {
        DatagramSocket socket = new DatagramSocket(port);
        while(true)
        {
            DatagramPacket data = new DatagramPacket(buffer, buffer.length);
            socket.receive(data);
            System.out.println("REICEIVED FROM "+data.getAddress()+" "+new String(data.getData()));
            socket.send(data);
        }
    }
}