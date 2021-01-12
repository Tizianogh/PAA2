package EXERCICE3;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        Reiceive reiceive = new Reiceive(8181);
        Send send = new Send(8080);

        reiceive.start();
        send.start();
    }
}
