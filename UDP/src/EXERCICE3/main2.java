package EXERCICE3;

import java.io.IOException;

public class main2 {
    public static void main(String[] args) throws IOException {
        Reiceive reiceive = new Reiceive(8080);
        Send send = new Send(8181);

        reiceive.start();
        send.start();
    }
}
