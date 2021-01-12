package EXERCICE3.PROPRE;

import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Chat {

    public Chat(int portE, int portR) throws SocketException, UnknownHostException {

        DatagramSocket s = new DatagramSocket(portR);
        Reiceive reiceive = new Reiceive(s);
        Send send = new Send(s, portE);

        reiceive.start();
        send.start();
    }

}