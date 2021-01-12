package EXERCICE2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static void main(String argv[]) throws Exception {
        String clientSentence;
        String capitalizedSentence;
        ServerSocket welcomeSocket = new ServerSocket(2000);
        while (true) {
            Socket connectionSocket = welcomeSocket.accept();

            BufferedReader inFromClient = new BufferedReader(
                    new InputStreamReader(
                            connectionSocket.getInputStream()));

            PrintWriter outToClient = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    connectionSocket.getOutputStream())),
                    true);
            clientSentence = inFromClient.readLine();
            outToClient.println("Recu" + " "+clientSentence.toUpperCase());
            connectionSocket.close();
        }
    }
}
