package EXERCICE2;
import java.io.*;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
        public static void main(String argv[]) throws Exception {
            String sentence;
            String modifiedSentence;
            BufferedReader inFromUser =
                    new BufferedReader(new InputStreamReader(System.in));
            Socket clientSocket = new Socket("localhost", 2000);
            PrintWriter outToServer = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    clientSocket.getOutputStream())),
                    true);
            BufferedReader inFromServer = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));
            sentence = inFromUser.readLine();

            outToServer.println(sentence);
            modifiedSentence = inFromServer.readLine();
            System.out.println("FROM SERVER: " + modifiedSentence);
            clientSocket.close();
        }
}