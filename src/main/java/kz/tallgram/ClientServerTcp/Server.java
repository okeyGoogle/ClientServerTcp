package kz.tallgram.ClientServerTcp;

import java.net.*;
import java.io.*;


/**
 * Created by Alen on 08.05.2020.
 */
public class Server {
    private static int clientCount = 0;

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(8008);
        System.out.println("Server started");
        while (true) {
            Socket clientSocket = serverSocket.accept();

            System.out.println("Clinet accepted " + (++clientCount));
            System.out.println();

            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(
                            clientSocket.getOutputStream()));

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));


            String request = reader.readLine();
            Thread.sleep(3000);
            String response = "dlina stroki - " + request.length();

            writer.write(response);
            writer.newLine();
            writer.flush();

            reader.close();
            writer.close();
            clientSocket.close();
        }
        //serverSocket.close(); //цикл while досих не дойдёт т.к. рекурсия

    }

}
