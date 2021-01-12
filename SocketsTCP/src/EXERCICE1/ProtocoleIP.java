package EXERCICE1;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ProtocoleIP {
    public static void main(String[] args) throws IOException {
        InetAddress adrDistante = InetAddress.getByName("www.univ-paris5.fr");
        DatagramSocket socket = new DatagramSocket();
        System.out.println(adrDistante);
        System.out.println(adrDistante.isReachable(10));
        System.out.println(socket.getLocalAddress());
    }
}
