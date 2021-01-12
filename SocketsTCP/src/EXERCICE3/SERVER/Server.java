package EXERCICE3.SERVER;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private String clientSentence = "";
    private Socket connectionSocket;

    public Server(Socket connectionSocket) {
        this.connectionSocket = connectionSocket;
    }

    public void run() throws IOException {
        while (true) {
            // Cr´eation du flux en entr´ee attach´e `a la socket
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            PrintWriter outToClient = new PrintWriter(new BufferedWriter(new OutputStreamWriter(connectionSocket.getOutputStream())), true);
            // Lecture des donn´ees arrivant du client
            while (true) {
                clientSentence = inFromClient.readLine();
                // Emission des donn´ees au client
                if (clientSentence.equals("FIN")) {
                    outToClient.println("connexcion au serveur terminée");
                    break;
                }
                outToClient.println(clientSentence.toUpperCase());
            }
            connectionSocket.close();
        } // boucle et attend la connexion d’un nouveau client
    }


    public static void main(String[] args) throws IOException {
        // Cr´eation de la socket d’accueil au port 8080
        ServerSocket welcomeSocket = new ServerSocket(2000);
        // Attente d’une demande de connexion sur la socket d’accueil
        Socket connectionSocket = welcomeSocket.accept();

        Server s1 = new Server(connectionSocket);
    }
}