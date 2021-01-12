package EXERCICE4;

import java.io.IOException;
import java.net.*;

public class Chat {
    public Chat(int portE, int portR) throws IOException {
        MulticastSocket ms = new MulticastSocket(portE);
        EXERCICE4.Reiceive reiceive = new EXERCICE4.Reiceive(ms, portE);
        EXERCICE4.Send send = new EXERCICE4.Send(ms, portE);

        reiceive.start();
        send.start();
    }

    public static InetAddress getInetAddress() throws UnknownHostException {
        InetAddress serveur = InetAddress.getByName("224.0.0.1");
        return serveur;
    }
}
